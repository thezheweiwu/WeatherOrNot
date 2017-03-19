/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caitlin
 */
public class RecommendationController implements ActionListener{
    
    private RecommendationView rv;
    private UserPreferenceController upc;
    private ArrayList<UserProfile> up;
    private ArrayList<String> options;
     
    RecommendationController(RecommendationView rv) throws ClassNotFoundException, SQLException {
        this.rv = rv;
        up = new ArrayList<>();
        DB data = new DB();
        up.add(new UserProfile());
        up.add(new UserProfile(data.getRows("SELECT * FROM preference WHERE id = 1")));
        options = new ArrayList<>();
        for (UserProfile item: up) {
            options.add(item.toString());
        }
        rv.getRf().getRp().getRm().getRight().setOptions(options);
        rv.getRf().getRp().getRm().getRight().optionsVisible();
        rv.getRf().getRp().getRb().getChangeUserPreferencesButton().addActionListener(this);
        rv.getRf().getRp().getRm().getRight().getGetButton().addActionListener(this);
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
        else if (obj==rv.getRf().getRp().getRm().getRight().getGetButton()) {
            int num = Integer.parseInt(rv.getRf().getRp().getRm().getRight().getHowFar().getText());
            rv.getRf().getRp().getRm().getLeft().getPercentageLabel().setText(Integer.toString(num));
            rv.getRf().getRp().getRm().getLeft().getPercentageSlide().setValue(num);
        }
    }
}
