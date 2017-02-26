/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

/**
 *
 * @author Zhewei
 */
public class UserPreferenceView {
    
    private UserPreferenceFrame wpf;
    
    UserPreferenceView() {
        wpf = new UserPreferenceFrame();
    }

    public UserPreferenceFrame getWpf() {
        return wpf;
    }

    public void setWpf(UserPreferenceFrame wpf) {
        this.wpf = wpf;
    }
    
}
