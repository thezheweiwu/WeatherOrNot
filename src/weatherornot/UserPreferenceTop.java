/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Zhewei
 */
class UserPreferenceTop extends JPanel {
    
    private final JLabel pageTitle;
    private final JLabel directions;
    
    UserPreferenceTop() {
        super();
        setBackground(new Color(150,192,206));
        pageTitle = newLabel("User Preferences");
        add(pageTitle);
        directions = newLabel("Select or change the following user preferences: ");
        add(directions);
        setLayout(new GridLayout(2,1));
    }
    
    private JLabel newLabel(String title) {
        JLabel lab = new JLabel(title);
        lab.setFont(new Font("SansSerif", Font.BOLD, 16));
        lab.setForeground(Color.white);
        lab.setHorizontalAlignment(JLabel.CENTER);
        return lab;
    }
}
