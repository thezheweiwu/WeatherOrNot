/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import javax.swing.JFrame;

/**
 *
 * @author Zhewei
 */
public class UserPreferenceFrame extends JFrame {
    
    private UserPreferencePanel upp;
    
    UserPreferenceFrame() {
        super("Change User Preferences");
        upp = new UserPreferencePanel();
        add(upp);
        setSize(800,400);
        setResizable(false);
        setVisible(true);
    }

    public UserPreferencePanel getUpp() {
        return upp;
    }

    public void setUpp(UserPreferencePanel upp) {
        this.upp = upp;
    }
    
}
