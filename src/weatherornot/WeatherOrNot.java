/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.github.dvdme.ForecastIOLib.*;
import com.google.gson.*;
/**
 *
 * @author Zhewei
 */
public class WeatherOrNot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ForecastIO forecast = new ForecastIO("37.8267","-122.4233","9811b7c9d35ea099b80118df438269e2");
        System.out.println(forecast.getCurrently().toString());
    }
    
}
