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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Caitlin
 */
public class RecommendationController implements ActionListener, ChangeListener{
    
    private RecommendationView rv;
    private UserPreferenceController upc;
    private ArrayList<UserProfile> up;
    private ArrayList<String> options;
    private WeatherModel model;
     
    RecommendationController(RecommendationView rv, WeatherModel model) throws ClassNotFoundException, SQLException {
        this.rv = rv;
        this.model = model;
        up = new ArrayList<>();
        DB data = new DB();
        up.add(new UserProfile());
        ResultSet results = data.getRows("SELECT * FROM preference WHERE id = 1");
        while(results.next()) {
            if (!results.getString("transportation").equals("not initialized")) {
                up.add(new UserProfile(data.getRows("SELECT * FROM preference WHERE id = 1")));
            }
        }
        options = new ArrayList<>();
        for (UserProfile item: up) {
            options.add(item.toString());
        }
        
        
        rv.getRf().getRm().setOptions(options);
        rv.getRf().getRm().optionsVisible();
        rv.getRf().getRb().getChangeUserPreferencesButton().addActionListener(this);
        rv.getRf().getRb().getGetButton().addActionListener(this);
        rv.getRf().getRm().getPercentageSlide().addChangeListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj== rv.getRf().getRb().getChangeUserPreferencesButton()) {
            try {
                upc = new UserPreferenceController();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(RecommendationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (obj==rv.getRf().getRb().getGetButton()) {
            Double value;
            try {
                value = Double.valueOf(rv.getRf().getRm().getinHowFar().getText());
            }
            catch (NumberFormatException exception) {
                value = 0.0;
            }
            int num = getRecommendation(value, up.get(rv.getRf().getRm().getPreferences().getSelectedIndex()));
            rv.getRf().getRm().getFactorsLabel().setText(Integer.toString(num));
            rv.getRf().getRm().getPercentageSlide().setValue(num);
        }
    }
    // implement this...
    private int getRecommendation (double distance, UserProfile profile) {
        // which transporation mode is it?
        if (model.getWeather().getCurrently().get("temperature").asDouble()<0) {
            return 0;
        }
        else {
            if ("Horse".equals(profile.getTransportationMode()) || "Car".equals(profile.getTransportationMode())) {
            // how fast is the wind going?
            if (model.getWeather().getCurrently().get("windSpeed").asDouble()>50) {
                return 0;
            }
            else {
                // how far is the destination?
                if (distance<10) {
                    double preciProb = model.getWeather().getCurrently().get("precipProbability").asDouble();
                    System.out.println(preciProb);
                    // how likely is it to precipitate during the travel?
                    if (preciProb>0.80) {
                        // if it is likely to precipitate, is the distance within the tolerable range
                        if (distance>profile.getMaxDistance()) {
                            return 0;
                        }
                        else {
                            return (int)((1-distance/profile.getMaxDistance())*100);
                        }
                    }
                }
                else if(distance<60) {
                    double preciProb = model.getMaxPreciHourly();
                    if (preciProb>0.80) {
                        if (distance>profile.getMaxDistance()) {
                            return 0;
                        }
                        else {
                            return (int)((1-distance/profile.getMaxDistance())*100);
                        }
                    }
                }
                else {
                    double preciProb = model.getMaxPreciToday();
                    if (preciProb>.80) {
                        if (distance>profile.getMaxDistance()) {
                            return 0;
                        }
                        else {
                            return (int)((1-distance/profile.getMaxDistance())*100);
                        }
                    }
                }
            }
        }
        else {
            // how fast is the wind going?
            if (model.getWeather().getCurrently().get("windSpeed").asDouble()>25) {
                return 0;
            }
            else {
                // how far is the destination?
                if (distance<10) {
                    double preciProb = model.getWeather().getCurrently().get("precipProbability").asDouble();
                    // how likely is it to precipitate during the travel?
                    if (preciProb>.80) {
                        // if it is likely to precipitate, is the distance within the tolerable range
                        if (distance>profile.getMaxDistance()) {
                            return 0;
                        }
                        else {
                            return (int)((1-distance/profile.getMaxDistance())*100);
                        }
                    }
                }
                else if(distance<60) {
                    double preciProb = model.getMaxPreciHourly();
                    if (preciProb>.80) {
                        if (distance>profile.getMaxDistance()) {
                            return 0;
                        }
                        else {
                            return (int)((1-distance/profile.getMaxDistance())*100);
                        }
                    }
                }
                else {
                    double preciProb = model.getMaxPreciToday();
                    if (preciProb>.80) {
                        if (distance>profile.getMaxDistance()) {
                            return 0;
                        }
                        else {
                            return (int)((1-distance/profile.getMaxDistance())*100);
                        }
                    }
                }
            }
        }
        }
        return 100;
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        Object obj = ce.getSource();
        if (obj==rv.getRf().getRm().getPercentageSlide()) {
            rv.getRf().getRm().getFactorsLabel().setText(Integer.toString(rv.getRf().getRm().getPercentageSlide().getValue()));
        }
    }

    public RecommendationView getRv() {
        return rv;
    }
    
    
}
