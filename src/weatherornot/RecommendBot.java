/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Caitlin
 */
public class RecommendBot extends JPanel{
    private JButton changeUserPreferencesButton, refreshButton;
    
    RecommendBot () {
        super();
        setBackground(new Color(150,192,206));

        changeUserPreferencesButton = new JButton("Change User Preferences");
        changeUserPreferencesButton.setBackground(new Color(194, 91, 86));
        changeUserPreferencesButton.setForeground(Color.white);
        add(changeUserPreferencesButton);
        
        refreshButton = new JButton("Refresh Recommendation");
        refreshButton.setBackground(new Color(194, 91, 86));
        refreshButton.setForeground(Color.white);
        add(refreshButton);
        
    }

    public JButton getChangeUserPreferencesButton() {
        return changeUserPreferencesButton;
    }

    public JButton getRefreshButton() {
        return refreshButton;
    }
    
}
