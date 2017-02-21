/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Caitlin
 */
        
public class LocationPanel extends JPanel{
    private final JLabel directions;
    JTextField zipcodeField;
    private final JButton submit; 
    
    LocationPanel() {
        super();
        setBackground(new Color(116,130,143));
        directions = new JLabel();
        directions.setText("Input a zipcode to select a new location");
        directions.setFont(new Font("SansSerif", Font.BOLD, 16));
        directions.setForeground(Color.white);
        directions.setHorizontalAlignment(JLabel.CENTER);
        directions.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        add(directions);
        zipcodeField = new JTextField("Zip", 5);
        zipcodeField.setHorizontalAlignment(JTextField.CENTER);
        zipcodeField.setFont(new Font("SansSerif", Font.BOLD, 16));
        zipcodeField.setForeground(new Color(116,130,143));
        add(zipcodeField);
        submit = new JButton("Submit");
        submit.setBackground(new Color(194,91,86));
        submit.setForeground(Color.white);
        submit.setHorizontalAlignment(JButton.CENTER);
        add(submit);
    }
}
