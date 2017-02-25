package weatherornot;

import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Caitlin
 */
public class UserPreferenceFrame extends JFrame {
    UserPreferenceFrame () {
        super("Change User Preferences");
        UserPreferencePanel upp = new UserPreferencePanel();
        add(upp);
        setSize(800,400);
        setResizable(false);
        setVisible(true);

    }
}
