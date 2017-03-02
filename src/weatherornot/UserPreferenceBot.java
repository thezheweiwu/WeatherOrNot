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
 * @author Zhewei
 */
class UserPreferenceBot extends JPanel {
    private JButton savePreferences;
    private JLabel statusMessage, spaceWaster;
    
    UserPreferenceBot () {
        super();
        setBackground(new Color(150,192,206));
        
        spaceWaster = new JLabel("Saved Preferencessssssssss"); //quick layout fix
        spaceWaster.setVisible(false);
        add(spaceWaster);
        
        statusMessage = new JLabel("Saved Preferences");
        statusMessage.setFont(new Font("SansSerif", Font.BOLD, 14));
        statusMessage.setForeground(Color.white);
        statusMessage.setHorizontalAlignment(JLabel.CENTER);
        add(statusMessage);
        statusMessage.setVisible(false);
        
        spaceWaster = new JLabel("Saved Preferencessssssssss"); //quick layout fix
        spaceWaster.setVisible(false);
        add(spaceWaster);
        
        savePreferences = new JButton("Save Preferences");
        savePreferences.setBackground(new Color(194, 91, 86));
        savePreferences.setForeground(Color.white);
        add(savePreferences);
        
        spaceWaster = new JLabel("Saved Preferencessssssssss"); //quick layout fix
        spaceWaster.setVisible(false);
        add(spaceWaster);
        
        setLayout(new GridLayout(1,5));
    }
    
    JButton getSavePreferences() {
        return savePreferences;
    }

    public JLabel getStatusMessage() {
        return statusMessage;
    }
}
