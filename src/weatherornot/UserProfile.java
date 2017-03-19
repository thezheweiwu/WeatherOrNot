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
public class UserProfile {
    
    String transportationMode;
    double maxDistance;
    boolean inRain;
    boolean inSnow;
    
    UserProfile() {
        transportationMode = "Walking";
        maxDistance = 1.0;
        inRain = true;
        inSnow = false;
    }
    
    UserProfile(String transportationMode, double maxDistance, boolean inRain, boolean inSnow) {
        this.transportationMode = transportationMode;
        this.maxDistance = maxDistance;
        this.inRain = inRain;
        this.inSnow = inSnow;
    }
}

