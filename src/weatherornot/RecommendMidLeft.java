/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author Zhewei
 */
public class RecommendMidLeft extends JPanel {
    
    private JSlider percentageSlide;
    private JLabel statusLabel;
    private JLabel factorsLabel;
    
    RecommendMidLeft() {
        super();
        setLayout(new BorderLayout());
        percentageSlide = new JSlider();
        statusLabel = new JLabel("Press get recommendation to continue.");
        factorsLabel = new JLabel();
        add(factorsLabel, BorderLayout.CENTER);
        add(percentageSlide, BorderLayout.SOUTH);
        add(statusLabel, BorderLayout.NORTH);
    }

    public JSlider getPercentageSlide() {
        return percentageSlide;
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }
    
    public JLabel getFactorsLabel() {
        return factorsLabel;
    }
}
