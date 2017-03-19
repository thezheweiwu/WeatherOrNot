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
    
    private String transportationMode;
    private double maxDistance;
    private boolean inRain;
    private boolean inSnow;
    
    UserProfile() {
        transportationMode = "Walking";
        maxDistance = 1.0;
        inRain = true;
        inSnow = false;
    }
    

    UserProfile(ResultSet rows) throws SQLException {
        while(rows.next()) {
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
        return transportationMode + ", " + maxDistance + ", " + inRain + ", " +inSnow;
    }
}

