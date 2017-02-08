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
import javax.swing.*;

/**
 *
 * @author Zhewei
 */
class WeatherPanel extends JPanel implements ActionListener{
    
    private MenuPanel mp;
    private WeatherInfoPanel wip;
    
    WeatherPanel() throws IOException, GeoIp2Exception {
        super();
        setLayout(new BorderLayout());
        mp = new MenuPanel();
        add(mp,BorderLayout.NORTH);
        wip = new WeatherInfoPanel();
        add(wip,BorderLayout.CENTER);
        mp.getRefresh().addActionListener(this);
        mp.getChangeLocationButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mp.getRefresh()) {
            wip.updateInfo();
        }
        if(e.getSource()==mp.getChangeLocationButton()) {
            JFrame frame = new JFrame();
            frame.setSize(400, 400);
            frame.setVisible(true);
        }
    }
    
}
