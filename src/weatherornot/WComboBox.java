/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.Color;
import javax.swing.JComboBox;

/**
 *
 * @author zjw5063
 */
public class WComboBox extends JComboBox {
    
    WComboBox(String[] a) {
        super(a);
        this.setBackground(Color.pink);
    }
}
