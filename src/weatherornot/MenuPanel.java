/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Zhewei
 */
public final class MenuPanel extends JPanel{
    private final JButton refreshButton;
    private final JButton changeLocationButton;
    private final JButton userPreferencesButton;
    
    MenuPanel() {
        super();
        setBackground(new Color(150,192,206));
        refreshButton = addButton("Refresh");
        add(refreshButton);
        changeLocationButton = addButton("See Locations");
        add(changeLocationButton);
        userPreferencesButton = addButton("Change User Preferences");
        add(userPreferencesButton);
    }
    
    public JButton getRefresh() {
        return refreshButton;
    }  
    
    public JButton getChangeLocationButton() {
        return changeLocationButton;
    }
    
    public JButton getUserPreferencesButton () {
        return userPreferencesButton;
    }
    
    private JButton addButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(194,91,86));
        button.setForeground(Color.white);
        return button;
    }
}
