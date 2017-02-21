/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Zhewei
 */
class WeatherPanel extends JPanel implements ActionListener{
    
    private final MenuPanel mp;
    private final WeatherInfoPanel wip;
    private final LocationPanel lp;
    
    WeatherPanel() throws IOException, GeoIp2Exception {
        super();
        setLayout(new BorderLayout());
        mp = new MenuPanel();
        add(mp,BorderLayout.NORTH);
        wip = new WeatherInfoPanel();
        add(wip,BorderLayout.CENTER);
        lp = new LocationPanel();
        add(lp, BorderLayout.SOUTH);
        mp.getRefresh().addActionListener(this);
        mp.getChangeLocationButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mp.getRefresh()) {
            try {
                wip.updateInfo();
            } catch (IOException | GeoIp2Exception ex) {
                Logger.getLogger(WeatherPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
