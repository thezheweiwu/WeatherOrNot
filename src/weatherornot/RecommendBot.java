/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Caitlin
 */
public class RecommendBot extends JPanel{
    private final JButton changeUserPreferencesButton;
    private final JButton getButton;
    
    RecommendBot () {
        super();
        setBackground(new Color(150,192,206));

        changeUserPreferencesButton = new JButton("Change User Preferences");
        changeUserPreferencesButton.setBackground(new Color(194, 91, 86));
        changeUserPreferencesButton.setForeground(Color.white);
        add(changeUserPreferencesButton);
          
        getButton = new JButton("Get Recommendation");
        getButton.setBackground(new Color(194, 91, 86));
        getButton.setForeground(Color.white);
        add(getButton);
        
    }

    public JButton getChangeUserPreferencesButton() {
        return changeUserPreferencesButton;
    }
    
    
    public JButton getGetButton() {
        return getButton;
    }
    
}
