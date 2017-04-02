/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author Zhewei
 */
class WeatherPanel extends JPanel{
    
    private final WeatherPanelTop top;
    private final WeatherPanelMid mid;
    private final WeatherPanelBot bot;
    private final SavedLocationPanel right;
    
    WeatherPanel() throws IOException, GeoIp2Exception, ClassNotFoundException, SQLException {
        super();
        setLayout(new BorderLayout());
        top = new WeatherPanelTop();
        add(top,BorderLayout.NORTH);
        mid = new WeatherPanelMid();
        add(mid,BorderLayout.CENTER);
        bot = new WeatherPanelBot();
        add(bot, BorderLayout.SOUTH);
        right = new SavedLocationPanel();
        add(right, BorderLayout.EAST);
    }

    public WeatherPanelTop getTop() {
        return top;
    }

    public WeatherPanelMid getMid() {
        return mid;
    }

    public WeatherPanelBot getBot() {
        return bot;
    }
    
    
}
