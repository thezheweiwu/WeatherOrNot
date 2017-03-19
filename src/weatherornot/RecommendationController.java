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
 * @author Caitlin
 */
public class RecommendationController implements ActionListener{
    
    private RecommendationView rv;
    private UserPreferenceController upc;
    private UserProfile up;
     
    RecommendationController() throws ClassNotFoundException, SQLException {
        rv = new RecommendationView();
        rv.getRf().getRp().getRb().getChangeUserPreferencesButton().addActionListener(this);
        rv.getRf().getRp().getRb().getRefreshButton();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj== rv.getRf().getRp().getRb().getChangeUserPreferencesButton()) {
            try {
                upc = new UserPreferenceController();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(RecommendationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
