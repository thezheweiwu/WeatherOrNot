/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Caitlin
 */
public class UserPreferenceInputPanel extends JPanel{
    private JComboBox transportationCombo;
    private JComboBox distanceCombo;
    private JComboBox travelInRainCombo; 
    private JComboBox travelInSnowCombo;
    JLabel transportationLabel, distanceLabel, travelInRainLabel, travelInSnowLabel; 
    
    UserPreferenceInputPanel() {
        super();
        setBackground(new Color(116,130,143));
        
        transportationLabel = addLabel("Mode of Transportation: ");
        add(transportationLabel);
        String[] transportationList = { "Car", "Bike", "Walking", "Bus", "Horse" }; 
        transportationCombo = new JComboBox(transportationList);
        add(transportationCombo);
        
        distanceLabel = addLabel("Max distance will travel in bad weather (in miles): ");
        add(distanceLabel);
        String[] distanceList = { "0.5", "1", "2", "5"}; 
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

    public JComboBox getTransportationCombo() {
        return transportationCombo;
    }

    public JComboBox getDistanceCombo() {
        return distanceCombo;
    }

    public JComboBox getTravelInRainCombo() {
        return travelInRainCombo;
    }

    public JComboBox getTravelInSnowCombo() {
        return travelInSnowCombo;
    }
    
    
}
