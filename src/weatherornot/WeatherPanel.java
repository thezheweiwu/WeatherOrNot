/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Zhewei
 */
class WeatherPanel extends JPanel{
    
    
    private Location location;
    private ForecastIO forecast;
    private JLabel locationLabel;
    private JLabel summaryLabel;
    private JLabel precipProbabilityLabel;
    private JLabel temperatureLabel;
    private JLabel humidityLabel;
    private JLabel windSpeedLabel;
    
    WeatherPanel() throws IOException, GeoIp2Exception {
        super();
        location = new Location();
        forecast = new ForecastIO(location.getLatitude(), location.getLongitude(), "9811b7c9d35ea099b80118df438269e2");
        locationLabel = new JLabel("Location: "+location.getCity()+", "+location.getState());
        add(locationLabel);
        summaryLabel = new JLabel("Summary: "+forecast.getCurrently().get("summary").toString());
        add(summaryLabel);
        precipProbabilityLabel = new JLabel("Precipitation Probability: "+forecast.getCurrently().get("precipProbability").toString()+"%");
        add(precipProbabilityLabel);
        temperatureLabel = new JLabel("Precipitation Probability: "+forecast.getCurrently().get("temperature"));
        add(temperatureLabel);
        humidityLabel = new JLabel("Humidity: "+forecast.getCurrently().get("humidity").toString());
        add(humidityLabel);
        windSpeedLabel = new JLabel("Wind Speed: "+forecast.getCurrently().get("windSpeed").toString());
        add(windSpeedLabel);
    }
}
