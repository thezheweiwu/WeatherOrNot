/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Zhewei
 */
class WeatherPanelMid extends JPanel {

    private final JLabel timeLabel;
    private final JLabel locationLabel;
    private final JLabel summaryLabel;
    private final JLabel precipProbabilityLabel;
    private final JLabel temperatureLabel;
    private final JLabel realFeelLabel;
    private final JLabel humidityLabel;
    private final JLabel windSpeedLabel;
    
    
    WeatherPanelMid() throws IOException, GeoIp2Exception {
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
        setLayout(new GridLayout(4,2));
    }
    
    private JLabel addLabel() {
        JLabel label = new JLabel();
        label.setFont(new Font("SansSerif", Font.BOLD, 20));
        label.setForeground(Color.white);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    public JLabel getTimeLabel() {
        return timeLabel;
    }

    public JLabel getLocationLabel() {
        return locationLabel;
    }

    public JLabel getSummaryLabel() {
        return summaryLabel;
    }

    public JLabel getPrecipProbabilityLabel() {
        return precipProbabilityLabel;
    }

    public JLabel getTemperatureLabel() {
        return temperatureLabel;
    }

    public JLabel getRealFeelLabel() {
        return realFeelLabel;
    }

    public JLabel getHumidityLabel() {
        return humidityLabel;
    }

    public JLabel getWindSpeedLabel() {
        return windSpeedLabel;
    }
}
