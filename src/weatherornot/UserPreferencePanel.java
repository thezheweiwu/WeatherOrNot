package weatherornot;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Caitlin
 */
public class UserPreferencePanel extends JPanel implements ActionListener {

    UserPreferenceDirectionsPanel updp;
    UserPreferenceInputPanel upp;
    UserPreferenceMenuPanel upmp;

    UserPreferencePanel() {
        super();
        setLayout(new BorderLayout());
        updp = new UserPreferenceDirectionsPanel();
        add(updp, BorderLayout.NORTH);
        upp = new UserPreferenceInputPanel();
        add(upp, BorderLayout.CENTER);
        upmp = new UserPreferenceMenuPanel();
        add(upmp, BorderLayout.SOUTH);

        upmp.getSavePreferences().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == upmp.getSavePreferences()) {
            try {
                String sql = "insert into preference values(1, '" + upp.getTransportationCombo().getSelectedItem() + "', '" + upp.getDistanceCombo().getSelectedItem() + "', '" + upp.getTravelInRainCombo().getSelectedItem() + "', '" + upp.getTravelInSnowCombo().getSelectedItem() + "')";
                DB.execute(sql);
            } catch (SQLException ex) {
                Logger.getLogger(UserPreferencePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            upmp.getStatusMessage().setVisible(true);
        }
    }
}
