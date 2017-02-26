/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Zhewei
 */
public class WeatherFrame extends JFrame {
    
    private WeatherPanel wp;
    
    WeatherFrame() throws IOException, GeoIp2Exception {
        super("Weather or Not");
        wp = new WeatherPanel();
        add(wp);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,400);
        setIconImage(new ImageIcon("icon.png").getImage());
        setResizable(false);
        setVisible(true);
    }

    public WeatherPanel getWp() {
        return wp;
    }

    public void setWp(WeatherPanel wp) {
        this.wp = wp;
    }
}
