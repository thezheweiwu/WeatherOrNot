/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Zhewei
 */
public class WFrame extends JFrame {
    
    WFrame(String title) {
        super();
        this.setTitle(title);
        this.setIconImage(new ImageIcon("icon.png").getImage());
    }
    
}
