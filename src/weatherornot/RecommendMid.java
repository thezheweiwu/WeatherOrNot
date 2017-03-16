package weatherornot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Caitlin
 */
public class RecommendMid extends JPanel implements ChangeListener{
    JLabel placeholderText;
    JSlider recommendationSlide;
    
    RecommendMid () {
    super();
        setBackground(new Color(116,130,143));
        placeholderText = addLabel("80%");
        recommendationSlide = new JSlider();
        recommendationSlide.setValue(80);
        recommendationSlide.addChangeListener(this);
        Dimension d = recommendationSlide.getPreferredSize();
        recommendationSlide.setPreferredSize(new Dimension(d.width+250,d.height));
        recommendationSlide.setValueIsAdjusting(false);
        add(recommendationSlide);
        add(placeholderText);
    }
    
     JLabel addLabel(String in) {
        JLabel label = new JLabel(in);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        label.setForeground(Color.white);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource()==recommendationSlide) {
            placeholderText.setText((Integer.toString(recommendationSlide.getValue())));
        }
    }
}
