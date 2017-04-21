/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Zhewei
 */
public class UserProfile {
    
    private String name;
    private String transportationMode;
    private double maxDistance;
    private boolean inRain;
    private boolean inSnow;
    
    UserProfile() {
        name = "Default Profile";
        transportationMode = "Walking";
        maxDistance = 1.0;
        inRain = true;
        inSnow = false;
    }

    public UserProfile(String name, String transportationMode, double maxDistance, boolean inRain, boolean inSnow) {
        this.name = name;
        this.transportationMode = transportationMode;
        this.maxDistance = maxDistance;
        this.inRain = inRain;
        this.inSnow = inSnow;
    }
    
    UserProfile(ResultSet rows) throws SQLException {
        while(rows.next()) {
            name = rows.getString("name");
            transportationMode = rows.getString("transportation");
            maxDistance = Double.parseDouble(rows.getString("distance"));
            if (rows.getString("rain").equals("Yes")) {
                inRain = true;
            }
            else {
                inRain = false;
            }
            if (rows.getString("snow").equals("Yes")) {
                inSnow = true;
            }
            else {
                inSnow = false;
            }
        }
    }
    
    /**
     *
     * @return
     */
    public String toString() {
        return name;
    }

    public String getTransportationMode() {
        return transportationMode;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public boolean isInRain() {
        return inRain;
    }

    public boolean isInSnow() {
        return inSnow;
    }
    
    
}

