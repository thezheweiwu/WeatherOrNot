package weatherornot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
public class RecommendMid extends JPanel{
    private RecommendMidLeft left;
    private RecommendMidRight right;
    
    RecommendMid (RecommendMidLeft left, RecommendMidRight right) {
    super();
        setBackground(new Color(116,130,143));
        this.left = left;
        this.right = right;
        setLayout(new GridLayout(1,2));
        add(left);
        add(right);
    }
    
     JLabel addLabel(String in) {
        JLabel label = new JLabel(in);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        label.setForeground(Color.white);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    public RecommendMidLeft getLeft() {
        return left;
    }

    public RecommendMidRight getRight() {
        return right;
    }
     
     
}
