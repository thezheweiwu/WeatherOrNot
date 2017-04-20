/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author Zhewei
 */
class WeatherPanel extends JPanel implements ActionListener{
    
    private WeatherPanelTop top;
    private WeatherPanelMid mid;
    private WeatherPanelBot bot;
    private SavedLocationPanel right;
    
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
        right.setVisible(false);
        top.getChangeLocationButton().addActionListener(this);
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

    public void setTop(WeatherPanelTop top) {
        this.top = top;
    }

    public void setMid(WeatherPanelMid mid) {
        this.mid = mid;
    }

    public void setBot(WeatherPanelBot bot) {
        this.bot = bot;
    }

    public void setRight(SavedLocationPanel right) {
        this.right = right;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.getTop().getChangeLocationButton()) {
            right.setVisible(!right.isVisible());
        }
    }
    
    
}
