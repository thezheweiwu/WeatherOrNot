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
 * @author Zhewei
 */
class UserPreferencePanel extends JPanel {

    private UserPreferenceTop top;
    private UserPreferenceMid mid;
    private UserPreferenceBot bot;
    
    public UserPreferencePanel() {
        super();
        setLayout(new BorderLayout());
        top = new UserPreferenceTop();
        add(top, BorderLayout.NORTH);
        mid = new UserPreferenceMid();
        add(mid, BorderLayout.CENTER);
        bot = new UserPreferenceBot();
        add(bot, BorderLayout.SOUTH);
    }

    public UserPreferenceTop getTop() {
        return top;
    }

    public void setTop(UserPreferenceTop top) {
        this.top = top;
    }

    public UserPreferenceMid getMid() {
        return mid;
    }

    public void setMid(UserPreferenceMid mid) {
        this.mid = mid;
    }

    public UserPreferenceBot getBot() {
        return bot;
    }

    public void setBot(UserPreferenceBot bot) {
        this.bot = bot;
    }
    
    
}
