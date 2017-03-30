/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Zhewei
 */
class WeatherPanelBot extends JPanel {

    private final JLabel directions;
    private final JFormattedTextField zipcodeField;
    private final JButton submit;
    private final JButton saveLocation;

    WeatherPanelBot() {
        super();
        setBackground(new Color(150, 192, 206));
        directions = new JLabel("Input a zipcode to select a new location:");
        directions.setFont(new Font("SansSerif", Font.BOLD, 16));
        directions.setForeground(Color.white);
        add(directions);
        NumberFormat longFormat = NumberFormat.getIntegerInstance();
        longFormat.setGroupingUsed(false);
        NumberFormatter numberFormatter = new NumberFormatter(longFormat);
        numberFormatter.setAllowsInvalid(false); //only allows numbers to be inputted
        zipcodeField = new JFormattedTextField(numberFormatter);
        zipcodeField.setColumns(5); // makes the textfield 5 characters long
        zipcodeField.setFont(new Font("SansSerif", Font.BOLD, 16));
        zipcodeField.setForeground(new Color(116, 130, 143));
        add(zipcodeField);
        submit = new JButton("Submit");
        submit.setBackground(new Color(194, 91, 86));
        submit.setForeground(Color.white);
        add(submit);
        saveLocation = new JButton("Save Location");
        saveLocation.setBackground(new Color(194, 91, 86));
        saveLocation.setForeground(Color.white);
        add(saveLocation);
    }

    public JFormattedTextField getZipcodeField() {
        return zipcodeField;
    }

    public JButton getSubmit() {
        return submit;
    }

    public JButton getSaveLocation() {
        return saveLocation;
    }
}
