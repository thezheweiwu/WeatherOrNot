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
class WeatherModel {
    private ForecastIO weather;
    private Location location;
    
    public WeatherModel() throws IOException, GeoIp2Exception {
        location = new Location();
        weather = new ForecastIO(location.getLatitude(), location.getLongitude(), "9811b7c9d35ea099b80118df438269e2");
    }

    public ForecastIO getWeather() {
        return weather;
    }

    public void setWeather(ForecastIO weather) {
        this.weather = weather;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    
}
