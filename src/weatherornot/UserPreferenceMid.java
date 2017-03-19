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
 * @author Zhewei
 */
class UserPreferenceMid extends JPanel {
    private WComboBox transportation;
    private WComboBox distance;
    private WComboBox travelInRain;
    private WComboBox travelInSnow;
    private JLabel transportationLabel, distanceLabel, travelInRainLabel, travelInSnowLabel; 
    
    UserPreferenceMid () {
        super();
        setBackground(new Color(116,130,143));
        
        transportationLabel = addLabel("Mode of Transportation: ");
        add(transportationLabel);
        String[] transportationList = { "Car", "Bike", "Walking", "Bus", "Horse" }; 
        transportation = new WComboBox(transportationList);
        add(transportation);
        
        distanceLabel = addLabel("Max distance will travel in bad weather (in miles): ");
        add(distanceLabel);
        String[] distanceList = { "5", "10", "20", "50"}; 
        distance = new WComboBox(distanceList);
        add(distance);
        
        travelInRainLabel = addLabel("Willing to Travel in Rain: ");
        add(travelInRainLabel);
        String[] rain = { "Yes", "No"}; 
        travelInRain = new WComboBox(rain);
        add(travelInRain);
        
        travelInSnowLabel = addLabel("Willing to Travel in Snow: ");
        add(travelInSnowLabel);
        String[] snow = { "Yes", "No"}; 
        travelInSnow = new WComboBox(snow);
        add(travelInSnow);
        
        setLayout(new GridLayout(4,2));
    }
    
    JLabel addLabel(String in) {
        JLabel label = new JLabel(in);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        label.setForeground(Color.white);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
    
    public JComboBox getTransportation() {
        return transportation;
    }

    public JComboBox getDistance() {
        return distance;
    }

    public JComboBox getTravelInRain() {
        return travelInRain;
    }

    public JComboBox getTravelInSnow() {
        return travelInSnow;
    }
}
