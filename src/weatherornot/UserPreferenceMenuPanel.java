/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Caitlin
 */
public class UserPreferenceMenuPanel extends JPanel{
    private JButton savePreferences;
    private JLabel statusMessage;
    
    UserPreferenceMenuPanel () {
        super();
        setBackground(new Color(150,192,206));
        
        statusMessage = new JLabel("Saved Preferences");
        statusMessage.setFont(new Font("SansSerif", Font.BOLD, 14));
        statusMessage.setForeground(Color.white);
        statusMessage.setHorizontalAlignment(JLabel.CENTER);
        add(statusMessage);
        statusMessage.setVisible(false);
        
        savePreferences = new JButton("Save Preferences");
        add(savePreferences);
        setLayout(new GridLayout(2,1));
    }
    
    JButton getSavePreferences() {
        return savePreferences;
    }

    public JLabel getStatusMessage() {
        return statusMessage;
    }
    
    
}
