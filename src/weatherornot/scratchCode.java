/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.io.IOException;

/**
 *
 * @author Zhewei
 */
public class scratchCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Location location = new Location();
            ForecastIO forecast = new ForecastIO(location.getLatitude(), location.getLongitude(), "9811b7c9d35ea099b80118df438269e2");
            //System.out.println(forecast.getCurrently());
            // access by key
            //String summary = forecast.getCurrently().get("summary").toString();
            //System.out.println(removeQuotes(summary));
        } catch (java.net.UnknownHostException e) {
            System.out.println("You're offline.");
        } catch (IOException | GeoIp2Exception e) {
            System.out.println(e);
        }

    }

    public static String removeQuotes(String thing) {
        return thing.substring(1, thing.length() - 1);
    }
    }
    
