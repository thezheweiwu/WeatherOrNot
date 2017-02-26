/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author Zhewei
 */
class WeatherPanel extends JPanel{
    
    private final WeatherPanelTop top;
    private final WeatherPanelMid mid;
    private final WeatherPanelBot bot;
    
    WeatherPanel() throws IOException, GeoIp2Exception {
        super();
        setLayout(new BorderLayout());
        top = new WeatherPanelTop();
        add(top,BorderLayout.NORTH);
        mid = new WeatherPanelMid();
        add(mid,BorderLayout.CENTER);
        bot = new WeatherPanelBot();
        add(bot, BorderLayout.SOUTH);
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
