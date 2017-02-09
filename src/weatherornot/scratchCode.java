/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Zhewei
 */
public class scratchCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, GeoIp2Exception {
        Location location = new Location();
        ForecastIO forecast = new ForecastIO(location.getLatitude(), location.getLongitude(), "9811b7c9d35ea099b80118df438269e2");
        long time = Long.valueOf(forecast.getCurrently().get("time").toString());
        Date unixDate = new Date(time * 1000L); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z"); // the format of your date
        String date = sdf.format(unixDate);
    }

}
