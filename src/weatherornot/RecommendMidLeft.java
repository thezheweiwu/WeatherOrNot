/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author Zhewei
 */
public class RecommendMidLeft extends JPanel {
    
    private JSlider percentageSlide;
    private JLabel percentageLabel;
    
    RecommendMidLeft() {
        percentageSlide = new JSlider();
        percentageLabel = new JLabel("test");
        add(percentageSlide);
        add(percentageLabel);
    }

    public JSlider getPercentageSlide() {
        return percentageSlide;
    }

    public JLabel getPercentageLabel() {
        return percentageLabel;
    }
    
    
}
