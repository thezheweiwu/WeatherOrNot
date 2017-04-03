package weatherornot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Caitlin
 */
public class RecommendMid extends JPanel{
    private JTextField inHowFar;
    private JLabel whichProfile, howFar;
    private JComboBox preferences;
    private JSlider percentageSlide;
    private JLabel factorsLabel;
    
    RecommendMid () {
        super();
        setBackground(new Color(116,130,143));
        
        howFar = addLabel("How far are you traveling...?   ");
        inHowFar = new JTextField("miles...");
        add(howFar);
        add(inHowFar);
        
        whichProfile = addLabel("Which profile...?   ");
        preferences = new JComboBox();
        add(whichProfile);
        add(preferences);
        
        percentageSlide = new JSlider();
        percentageSlide.setPreferredSize(new Dimension(100,100));
        factorsLabel = new JLabel();
        factorsLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 30));
        add(percentageSlide);
        add(factorsLabel);
        
        setLayout(new GridLayout(3,2));
        
    }
    
     public JSlider getPercentageSlide() {
        return percentageSlide;
    }

    public JLabel getFactorsLabel() {
        return factorsLabel;
    }
    
     public JTextField getinHowFar() {
        return inHowFar;
    }
    
    public void setOptions(ArrayList<String> options) {
        for (String item : options) {
            preferences.addItem(item);
        }
    }
    
    public JComboBox getPreferences() {
        return preferences;
    }
    
     JLabel addLabel(String in) {
        JLabel label = new JLabel(in);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        label.setForeground(Color.white);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
     
     public void optionsVisible() {
        //add(howFar, BorderLayout.NORTH);
        //add(preferences, BorderLayout.CENTER);
    }
    
     
}
