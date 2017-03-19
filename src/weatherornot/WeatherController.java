/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Zhewei
 */
class WeatherController implements ActionListener {

    private WeatherModel model;
    private WeatherView view;
    private UserPreferenceController upc;
    private RecommendationController rc; //change to controller after we figure a recomm. formula

    WeatherController(WeatherModel model, WeatherView view) throws IOException, GeoIp2Exception {
        this.model = model;
        this.view = view;
        view.getWf().getWp().getTop().getRefresh().addActionListener(this);
        view.getWf().getWp().getBot().getSubmit().addActionListener(this);
        view.getWf().getWp().getTop().getGetRecommendationButton().addActionListener(this);
        updateInfo("");
    }

    private void updateInfo(String zipcode) throws IOException, GeoIp2Exception {
        if (!zipcode.equals("")) {
            model.setLocation(new Location(zipcode));
        } else {
            model.setLocation(new Location());
        }
        model.setWeather(new ForecastIO(model.getLocation().getLatitude(), model.getLocation().getLongitude(), "9811b7c9d35ea099b80118df438269e2"));
        long time = Long.valueOf(model.getWeather().getCurrently().get("time").toString());
        Date unixDate = new Date(time * 1000L); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a"); // the format of your date
        String date = sdf.format(unixDate);
        view.getWf().getWp().getMid().getTimeLabel().setText("Time: " + date);
        view.getWf().getWp().getMid().getLocationLabel().setText("Location: " + model.getLocation().getCity() + ", " + model.getLocation().getState());
        view.getWf().getWp().getMid().getSummaryLabel().setText("Summary: " + model.getWeather().getCurrently().get("summary").toString().substring(1, model.getWeather().getCurrently().get("summary").toString().length() - 1));
        view.getWf().getWp().getMid().getPrecipProbabilityLabel().setText("Precipitation Probability: " + String.format("%.0f", Double.parseDouble(model.getWeather().getCurrently().get("precipProbability").toString()) * 100) + "%");
        view.getWf().getWp().getMid().getTemperatureLabel().setText("Temperature: " + model.getWeather().getCurrently().get("temperature") + model.getLocation().getWeatherUnit());
        view.getWf().getWp().getMid().getRealFeelLabel().setText("Real Feel: " + model.getWeather().getCurrently().get("apparentTemperature") + model.getLocation().getWeatherUnit());
        view.getWf().getWp().getMid().getHumidityLabel().setText("Humidity: " + String.format("%.0f", Double.parseDouble(model.getWeather().getCurrently().get("humidity").toString()) * 100) + "%");
        view.getWf().getWp().getMid().getWindSpeedLabel().setText("Wind Speed: " + model.getWeather().getCurrently().get("windSpeed").toString() + " " + model.getLocation().getWindUnit());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj == view.getWf().getWp().getTop().getRefresh()) {
            try {
                if (view.getWf().getWp().getBot().getZipcodeField().getText().trim().equals("")) {
                    updateInfo("");
                }
                else {
                    isZip5();
                }
            } catch (IOException | GeoIp2Exception ex) {
                Logger.getLogger(WeatherController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (obj == view.getWf().getWp().getBot().getSubmit()) {
            try {
                isZip5();
            } catch (IOException | GeoIp2Exception ex) {
                Logger.getLogger(WeatherController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(obj == view.getWf().getWp().getTop().getGetRecommendationButton()) {
            try {
                rc = new RecommendationController(new RecommendationView());
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(WeatherController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    private void isZip5() throws IOException, GeoIp2Exception {
        if (view.getWf().getWp().getBot().getZipcodeField().getText().length() == 5) {
            updateInfo(view.getWf().getWp().getBot().getZipcodeField().getText());
        } else {
            JOptionPane.showMessageDialog(view.getWf(), "Error: The length of the zipcode must be 5 numbers long.");
        }
    }
}
