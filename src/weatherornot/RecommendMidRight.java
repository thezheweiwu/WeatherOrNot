/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Zhewei
 */
public class RecommendMidRight extends JPanel {
    
    private JComboBox preferences;
    private JButton getButton;
    private JTextField howFar;
    private JLabel whichProfile;
    
    RecommendMidRight () {
        setLayout(new BorderLayout());
        howFar = new JTextField("How far away is the destination?");
        preferences = new JComboBox();
        getButton = new JButton("Get Recommendation");
        whichProfile = new JLabel("Which profile?   ");
        add(whichProfile, BorderLayout.WEST);
    }
    
    public void setOptions(ArrayList<String> options) {
        for (String item: options) {
            preferences.addItem(item);
        }
    }
    
    public void optionsVisible() {
        add(howFar, BorderLayout.NORTH);
        add(preferences, BorderLayout.CENTER);
        add(getButton, BorderLayout.SOUTH);
    }

    public JButton getGetButton() {
        return getButton;
    }
    
    public JTextField getHowFar() {
        return howFar;
    }
    
    public JComboBox getPreferences() {
        return preferences;
    }
    
}
