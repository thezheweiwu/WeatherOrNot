package weatherornot;


import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import weatherornot.UserPreferenceDirectionsPanel;
import weatherornot.UserPreferenceInputPanel;
import weatherornot.UserPreferenceMenuPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Caitlin
 */
public class UserPreferencePanel extends JPanel implements ActionListener{
    UserPreferenceDirectionsPanel updp;
    UserPreferenceInputPanel upp;
    UserPreferenceMenuPanel upmp;
    
    UserPreferencePanel () {
        super();
        setLayout(new BorderLayout());
        updp = new UserPreferenceDirectionsPanel();
        add(updp,BorderLayout.NORTH);
        upp = new UserPreferenceInputPanel();
        add(upp, BorderLayout.CENTER);
        upmp = new UserPreferenceMenuPanel();
        add(upmp, BorderLayout.SOUTH);
        
        upmp.getSavePreferences().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==upmp.getSavePreferences()) {
            upmp.statusMessage.setVisible(true);
}
}
}
