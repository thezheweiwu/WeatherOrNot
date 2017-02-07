/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Zhewei
 */
public class WeatherFrame extends JFrame {
    
    WeatherFrame() throws IOException, GeoIp2Exception {
        super();
        WeatherPanel wp = new WeatherPanel();
        add(wp);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,600);
        setVisible(true);
    }
}