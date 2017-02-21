/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import javax.swing.JFrame;

/**
 *
 * @author Caitlin
 */
public class LocationFrame extends JFrame{
    LocationFrame() {
        super("Change Location");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        LocationPanel lp = new LocationPanel();
        add(lp);
        setSize(400,200);
        setResizable(false);
        setVisible(true);
    }
}
