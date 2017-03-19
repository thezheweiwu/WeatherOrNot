/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Zhewei
 */
public class WeatherOrNot {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws com.maxmind.geoip2.exception.GeoIp2Exception
     */
    public static void main(String[] args) throws IOException, GeoIp2Exception, ClassNotFoundException, SQLException {
        WeatherModel model = new WeatherModel();
        WeatherView view = new WeatherView(model);
        WeatherController controller = new WeatherController(model, view); 
//        DB data = new DB();
//        ResultSet rs = data.getRows("SELECT * FROM preference WHERE id = 1");
//        while(rs.next())
//      {
//        // read the result set
//        System.out.println("transportation = " + rs.getString("transportation"));
//        System.out.println("distance = " + rs.getString("distance"));
//      }
    }
    
}
