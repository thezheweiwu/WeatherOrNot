package weatherornot;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Caitlin
 */
public class RecommendMid extends JPanel {
    JLabel placeholderText;
    
    RecommendMid () {
    super();
        setBackground(new Color(116,130,143));
        placeholderText = addLabel("This shall sit here until we figure out some method or formula for making recommendations");
        add(placeholderText);
    }
    
     JLabel addLabel(String in) {
        JLabel label = new JLabel(in);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        label.setForeground(Color.white);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
}
