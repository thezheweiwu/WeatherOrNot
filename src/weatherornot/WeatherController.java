/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Zhewei
 */
class WeatherController implements ActionListener {

    private WeatherModel model;
    private WeatherView view;
    private UserPreferenceController upc;
    private RecommendationController rc;

    WeatherController(WeatherModel model, WeatherView view) throws IOException, GeoIp2Exception, ClassNotFoundException, SQLException {
        this.model = model;
        this.view = view;
        view.getWf().getWp().getTop().getRefresh().addActionListener(this);
        view.getWf().getWp().getBot().getSubmit().addActionListener(this);
        view.getWf().getWp().getTop().getGetRecommendationButton().addActionListener(this);
        view.getWf().getWp().getBot().getSaveLocation().addActionListener(this);
        updateInfo("");
        rc = new RecommendationController(new RecommendationView(), model);
        view.getWf().getWp().getRight().getLocations().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    try {
                        DB data = new DB();
                        JTable target = (JTable) e.getSource();
                        String sql = "SELECT * FROM location WHERE id =" + (target.getSelectedRow()+1);
                        ResultSet results = data.getRows(sql);
                        while(results.next()) {
                            updateInfo(results.getString("latitude"), results.getString("longitude"), results.getString("city"), results.getString("state"), results.getString("country")) ;
                        }
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(WeatherController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        });
    }

    private void updateInfo(String zipcode) throws IOException, GeoIp2Exception {
        if (!zipcode.equals("")) {
            model.setLocation(new Location(zipcode));
        } else {
            model.setLocation(new Location());
        }
        updateWeather();
    }
    
    private void updateInfo(String lat, String longitude, String city, String state, String country) {
        model.setLocation(new Location(lat, longitude, city, state, country));
        updateWeather();
    }
    
    private void updateWeather() {
        model.setWeather(new ForecastIO(model.getLocation().getLatitude(), model.getLocation().getLongitude(), "9811b7c9d35ea099b80118df438269e2"));
        long time = Long.valueOf(model.getWeather().getCurrently().get("time").toString());
        Date unixDate = new Date(time * 1000L); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a"); // the format of your date
        String date = sdf.format(unixDate);
        view.getWf().getWp().getMid().getTimeLabel().setText("Time: " + date);
        view.getWf().getWp().getMid().getLocationLabel().setText("Location: " + model.getLocation().getCity() + ", " + model.getLocation().getState());
        view.getWf().getWp().getMid().getSummaryLabel().setText("Summary: " + model.getWeather().getCurrently().get("summary").toString().substring(1, model.getWeather().getCurrently().get("summary").toString().length() - 1));
        view.getWf().getWp().getMid().getPrecipProbabilityLabel().setText("Precipitation Probability: " + String.format("%.0f", Double.parseDouble(model.getWeather().getCurrently().get("precipProbability").toString()) * 100) + "%");
        view.getWf().getWp().getMid().getTemperatureLabel().setText("Temperature: " + (int)Double.parseDouble(model.getWeather().getCurrently().get("temperature").toString()) + model.getLocation().getWeatherUnit());
        view.getWf().getWp().getMid().getRealFeelLabel().setText("Real Feel: " + (int)Double.parseDouble(model.getWeather().getCurrently().get("apparentTemperature").toString()) + model.getLocation().getWeatherUnit());
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
                if (view.getWf().getWp().getMid().isVisible()) {
                    view.getWf().getWp().add(rc.getRv().getRf(),BorderLayout.CENTER);
                    rc.getRv().getRf().setVisible(true);
                    view.getWf().getWp().getMid().setVisible(false);
                    view.getWf().getWp().getBot().setVisible(false);
                    System.out.println(1);
                }
                else {
                    view.getWf().getWp().remove(rc.getRv().getRf());
                    rc.getRv().getRf().setVisible(false);
                    view.getWf().getWp().getMid().setVisible(true);
                    view.getWf().getWp().getBot().setVisible(true);
                    System.out.println(2);
                }
        }
        if (obj== view.getWf().getWp().getBot().getSaveLocation()) {
            try {
                DB data = new DB();
                String sql = "INSERT INTO location (city, state, country, longitude, latitude) values ('"+model.getLocation().getCity()+"', '"+model.getLocation().getState()+"', '"+model.getLocation().getCountry()+"', '"+model.getLocation().getLongitude()+"', '"+model.getLocation().getLatitude()+"')";
                data.insertSql(sql);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(WeatherController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
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
