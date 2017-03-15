/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Caitlin
 */
public class RecommendationPanel extends JPanel{
    RecommendTop rt;
    RecommendMid rm;
    RecommendBot rb;
    
    RecommendationPanel() {
        super();
        setLayout(new BorderLayout());
        rt = new RecommendTop();
        add(rt, BorderLayout.NORTH);
        rm = new RecommendMid();
        add(rm, BorderLayout.CENTER);
        rb = new RecommendBot();
        add(rb, BorderLayout.SOUTH);
    }
}
