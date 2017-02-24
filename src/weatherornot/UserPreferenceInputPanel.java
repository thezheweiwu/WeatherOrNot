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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Caitlin
 */
public class UserPreferenceInputPanel extends JPanel{
    JComboBox transportationCombo, distanceCombo, travelInRainCombo, travelInSnowCombo;
    JLabel transportationLabel, distanceLabel, travelInRainLabel, travelInSnowLabel; 
    
    UserPreferenceInputPanel() {
        super();
        setBackground(new Color(116,130,143));
        
        transportationLabel = addLabel("Mode of Transportation: ");
        add(transportationLabel);
        String[] transportationList = { "Car", "Bike", "Walking", "Bus", "Horse" }; 
        transportationCombo = new JComboBox(transportationList);
        add(transportationCombo);
        
        distanceLabel = addLabel("Max distance will travel in bad weather: ");
        add(distanceLabel);
        String[] distanceList = { "1/2 mile", "1 mile", "2 miles", "5 miles"}; 
        distanceCombo = new JComboBox(distanceList);
        add(distanceCombo);
        
        travelInRainLabel = addLabel("Willing to Travel in Rain: ");
        add(travelInRainLabel);
        String[] rain = { "Yes", "No"}; 
        travelInRainCombo = new JComboBox(rain);
        add(travelInRainCombo);
        
        travelInSnowLabel = addLabel("Willing to Travel in Snow: ");
        add(travelInSnowLabel);
        String[] snow = { "Yes", "No"}; 
        travelInSnowCombo = new JComboBox(snow);
        add(travelInSnowCombo);
        
        setLayout(new GridLayout(4,2));
    }
    
    JLabel addLabel(String in) {
        JLabel label = new JLabel(in);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        label.setForeground(Color.white);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
}

