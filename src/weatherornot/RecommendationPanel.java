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
    private RecommendTop rt;
    private RecommendMid rm;
    private RecommendBot rb;
    private RecommendMidLeft left;
    private RecommendMidRight right;
    
    RecommendationPanel() {
        super();
        setLayout(new BorderLayout());
        rt = new RecommendTop();
        add(rt, BorderLayout.NORTH);
        left = new RecommendMidLeft();
        right = new RecommendMidRight();
        rm = new RecommendMid(left, right);
        add(rm, BorderLayout.CENTER);
        rb = new RecommendBot();
        add(rb, BorderLayout.SOUTH);
    }

    public RecommendTop getRt() {
        return rt;
    }

    public RecommendMid getRm() {
        return rm;
    }

    public RecommendBot getRb() {
        return rb;
    }

    public RecommendMidLeft getLeft() {
        return left;
    }

    public RecommendMidRight getRight() {
        return right;
    }
    
    
}
