/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.github.dvdme.ForecastIOLib.*;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Subdivision;
import java.io.File;
import java.net.InetAddress;

/**
 *
 * @author Zhewei
 */
public class WeatherOrNot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File database = new File("src/WeatherOrNot/GeoLite2-City.mmdb");
            DatabaseReader reader = new DatabaseReader.Builder(database).build();

            InetAddress IP = InetAddress.getLocalHost();
            CityResponse response = reader.city(IP);
            com.maxmind.geoip2.record.Location location = response.getLocation();
            Subdivision subdivision = response.getMostSpecificSubdivision();
            City city = response.getCity();
            System.out.println(city.getName()+", "+subdivision.getIsoCode()); // 'MN'
            // state college
            ForecastIO forecast = new ForecastIO(location.getLatitude().toString(), location.getLongitude().toString(), "9811b7c9d35ea099b80118df438269e2");
            System.out.println(forecast.getCurrently().toString());
            // access by key
            String summary = forecast.getCurrently().get("summary").toString();
            System.out.println(removeQuotes(summary));
            // IP Address
        } catch (Exception ex) {
            System.out.println("You are offline.");
        }

    }

    public static String removeQuotes(String thing) {
        return thing.substring(1, thing.length() - 1);
    }

}
