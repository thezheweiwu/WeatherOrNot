/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.Color;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author Caitlin
 */
public class UserPreferenceDirectionsPanel extends JPanel{
    private final JLabel pageTitle, directions;
    
    UserPreferenceDirectionsPanel () {
        super();
        setBackground(new Color(150,192,206));
        
        pageTitle = new JLabel("User Preferences");
        pageTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
        pageTitle.setForeground(Color.white);
        pageTitle.setHorizontalAlignment(JLabel.CENTER);
        add(pageTitle);  
        
        directions = new JLabel("Select or Change the Following User Preferences: ");
        directions.setFont(new Font("SansSerif", Font.BOLD, 14));
        directions.setForeground(Color.white);
        directions.setHorizontalAlignment(JLabel.CENTER);
        add(directions);
        
        setLayout(new GridLayout(2,1));
    }
}
