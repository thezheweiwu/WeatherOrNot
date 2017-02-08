/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author Zhewei
 */
public class WeatherInfoPanel extends JPanel{
    private Location location;
    private ForecastIO forecast;
    private JLabel timeLabel;
    private JLabel locationLabel;
    private JLabel summaryLabel;
    private JLabel precipProbabilityLabel;
    private JLabel temperatureLabel;
    private JLabel realFeelLabel;
    private JLabel humidityLabel;
    private JLabel windSpeedLabel;
    private String weatherUnit;
    private String windUnit;
    
    WeatherInfoPanel() throws IOException, GeoIp2Exception {
        super();
        setBackground(new Color(116,130,143));
        location = new Location();
        String state = location.getState();
        if (location.getCountry().equals("United States")) {
            weatherUnit = " °F";
            windUnit = " mph";
        }
        else {
            weatherUnit = " °C";
            windUnit = " km/h";
        }
        if (state==null) {
                state = "";
            }
            else {
                state = ", " + state;
            }
        forecast = new ForecastIO(location.getLatitude(), location.getLongitude(), "9811b7c9d35ea099b80118df438269e2");
        timeLabel = addLabel("Time: " + forecast.getCurrently().get("time").toString());
        add(timeLabel);
        locationLabel = addLabel("Location: "+location.getCity()+state);
        add(locationLabel);
        summaryLabel = addLabel("Summary: "+forecast.getCurrently().get("summary"));
        add(summaryLabel);
        precipProbabilityLabel = addLabel("Precipitation Probability: "+forecast.getCurrently().get("precipProbability").toString());
        add(precipProbabilityLabel);
        temperatureLabel = addLabel("Tempatures: "+forecast.getCurrently().get("temperature")+weatherUnit);
        add(temperatureLabel);
        realFeelLabel = addLabel("Real Feel: "+forecast.getCurrently().get("apparentTemperature")+weatherUnit);
        add(realFeelLabel);
        humidityLabel = addLabel("Humidity: "+forecast.getCurrently().get("humidity").toString());
        add(humidityLabel);
        windSpeedLabel = addLabel("Wind Speed: "+forecast.getCurrently().get("windSpeed").toString()+windUnit);
        add(windSpeedLabel);
        setLayout(new GridLayout(4,2));
    }
    
    void updateInfo() {
        forecast.update();
        timeLabel.setText("Time: " + forecast.getCurrently().get("time").toString());
        locationLabel.setText("Location: "+location.getCity()+", "+location.getState());
        summaryLabel.setText("Summary: "+forecast.getCurrently().get("summary").toString());
        precipProbabilityLabel.setText("Precipitation Probability: "+forecast.getCurrently().get("precipProbability").toString());
        temperatureLabel.setText("Tempatures: "+forecast.getCurrently().get("temperature")+weatherUnit);
        realFeelLabel.setText("Real Feel: "+forecast.getCurrently().get("apparentTemperature")+weatherUnit);
        humidityLabel.setText("Humidity: "+forecast.getCurrently().get("humidity").toString());
        windSpeedLabel.setText("Wind Speed: "+forecast.getCurrently().get("windSpeed").toString()+windUnit);
    }
    
    JLabel addLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.BOLD, 20));
        label.setForeground(Color.white);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
}
