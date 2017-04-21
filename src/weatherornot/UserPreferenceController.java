/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zhewei
 */
public class UserPreferenceController implements ActionListener {

    private DB database;
    private UserPreferenceView upv;
    private RecommendationController rc;

    UserPreferenceController(RecommendationController rc) throws ClassNotFoundException, SQLException {
        database = new DB();
        upv = new UserPreferenceView();
        upv.getWpf().getUpp().getBot().getSavePreferences().addActionListener(this);
        this.rc = rc;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj == upv.getWpf().getUpp().getBot().getSavePreferences()) {
            try {
                String sql = "UPDATE preference SET name = '" + upv.getWpf().getUpp().getMid().getProfileNameField().getText() + "', transportation='" + upv.getWpf().getUpp().getMid().getTransportation().getSelectedItem() + "', distance='" + upv.getWpf().getUpp().getMid().getDistance().getSelectedItem() + "', rain='" + upv.getWpf().getUpp().getMid().getTravelInRain().getSelectedItem() + "', snow='" + upv.getWpf().getUpp().getMid().getTravelInSnow().getSelectedItem() + "' WHERE id = 1";
                database.insertSql(sql);
                if (rc.getRv().getRf().getRm().getPreferences().getItemCount()>1) {
                rc.getRv().getRf().getRm().getPreferences().removeItemAt(1);
                rc.getUp().remove(1);
                }
                rc.getRv().getRf().getRm().getPreferences().addItem(upv.getWpf().getUpp().getMid().getProfileNameField().getText());
                DB data = new DB();
                ResultSet results = data.getRows("SELECT * FROM preference WHERE id = 1");
                rc.getUp().add(1, new UserProfile(results));
                rc.getRv().getRf().getRm().getPreferences().setSelectedIndex(1);
                upv.getWpf().getUpp().getBot().getStatusMessage().setVisible(true);
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                    @Override
                    public void run() {
                        upv.getWpf().setVisible(false);
                    }
                },
                        5000
                );
            } catch (SQLException ex) {
                Logger.getLogger(UserPreferenceController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserPreferenceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
