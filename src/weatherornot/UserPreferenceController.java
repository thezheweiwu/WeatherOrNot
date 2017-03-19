/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zhewei
 */
public class UserPreferenceController implements ActionListener{
    
    private DB database;
    private UserPreferenceView upv;
    
    UserPreferenceController() throws ClassNotFoundException, SQLException {
        database = new DB();
        upv = new UserPreferenceView();
        upv.getWpf().getUpp().getBot().getSavePreferences().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj==upv.getWpf().getUpp().getBot().getSavePreferences()) {
            try {
                String sql = "UPDATE preference SET transportation='"+upv.getWpf().getUpp().getMid().getTransportation().getSelectedItem() + "', distance='" + upv.getWpf().getUpp().getMid().getDistance().getSelectedItem() + "', rain='" + upv.getWpf().getUpp().getMid().getTravelInRain().getSelectedItem() + "', snow='" + upv.getWpf().getUpp().getMid().getTravelInSnow().getSelectedItem() + "' WHERE id = 1";
                database.insertSql(sql);
                upv.getWpf().getUpp().getBot().getStatusMessage().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(UserPreferenceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
