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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author Zhewei 
 */
public final class WeatherInfoPanel extends JPanel{
    private Location location;
    private ForecastIO forecast;
    private final JLabel timeLabel;
    private final JLabel locationLabel;
    private final JLabel summaryLabel;
    private final JLabel precipProbabilityLabel;
    private final JLabel temperatureLabel;
    private final JLabel realFeelLabel;
    private final JLabel humidityLabel;
    private final JLabel windSpeedLabel;
    
    
    WeatherInfoPanel() throws IOException, GeoIp2Exception {
        super();
        setBackground(new Color(116,130,143));
        timeLabel = addLabel();
        add(timeLabel);
        locationLabel = addLabel();
        add(locationLabel);
        summaryLabel = addLabel();
        add(summaryLabel);
        precipProbabilityLabel = addLabel();
        add(precipProbabilityLabel);
        temperatureLabel = addLabel();
        add(temperatureLabel);
        realFeelLabel = addLabel();
        add(realFeelLabel);
        humidityLabel = addLabel();
        add(humidityLabel);
        windSpeedLabel = addLabel();
        add(windSpeedLabel);
        updateInfo();
        setLayout(new GridLayout(4,2));
    }
    
    void updateInfo() throws IOException, GeoIp2Exception {
        this.location = new Location();
        this.forecast = forecast = new ForecastIO(location.getLatitude(), location.getLongitude(), "9811b7c9d35ea099b80118df438269e2");
        location = new Location();
        long time = Long.valueOf(forecast.getCurrently().get("time").toString());
        Date unixDate = new Date(time * 1000L); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a"); // the format of your date
        String date = sdf.format(unixDate);
        timeLabel.setText("Time: " + date);
        locationLabel.setText("Location: "+location.getCity()+location.getState());
        summaryLabel.setText("Summary: "+functions.removeQuotes(forecast.getCurrently().get("summary").toString()));
        precipProbabilityLabel.setText("Precipitation Probability: "+String.format("%.0f", Double.parseDouble(forecast.getCurrently().get("precipProbability").toString())*100)+"%");
        temperatureLabel.setText("Tempatures: "+forecast.getCurrently().get("temperature")+location.getWeatherUnit());
        realFeelLabel.setText("Real Feel: "+forecast.getCurrently().get("apparentTemperature")+location.getWeatherUnit());
        humidityLabel.setText("Humidity: "+String.format("%.0f", Double.parseDouble(forecast.getCurrently().get("humidity").toString())*100)+"%");
        windSpeedLabel.setText("Wind Speed: "+forecast.getCurrently().get("windSpeed").toString()+location.getWindUnit());
    }
    
    JLabel addLabel() {
        JLabel label = new JLabel();
        label.setFont(new Font("SansSerif", Font.BOLD, 20));
        label.setForeground(Color.white);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
}
