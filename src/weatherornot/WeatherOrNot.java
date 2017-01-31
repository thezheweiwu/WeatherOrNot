/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.github.dvdme.ForecastIOLib.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 *
 * @author Zhewei
 */
public class WeatherOrNot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        // state college
        ForecastIO forecast = new ForecastIO("40.7948376","-77.8653124","9811b7c9d35ea099b80118df438269e2");
        System.out.println(forecast.getCurrently().toString());
        // access by key
        String summary = forecast.getCurrently().get("summary").toString();
        System.out.println(removeQuotes(summary));
        // IP Address
        InetAddress IP=InetAddress.getLocalHost();
        System.out.println(IP.getHostAddress().toString());
    }
    
    public static String removeQuotes(String thing) {
        return thing.substring(1,thing.length()-1);
    }
    
}
