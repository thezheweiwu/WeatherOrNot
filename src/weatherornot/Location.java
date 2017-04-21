/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.csvreader.CsvReader;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.Subdivision;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Zhewei
 */
public class Location {

    private String latitude;
    private String longitude;
    private String city;
    private String state;
    private String country;
    private String weatherUnit;
    private String windUnit;
    private final ArrayList<String> useF = new ArrayList<String>() {
        {
            add("United States");
            add("Palau");
            add("Belize");
        }
    };

    Location() throws IOException, GeoIp2Exception {
        File database = new File("db/GeoLite2-City.mmdb");
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        DatabaseReader reader = new DatabaseReader.Builder(database).build();
        BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
        String ipString = in.readLine();
        InetAddress IP = InetAddress.getByName(ipString);
        CityResponse response = reader.city(IP);
        com.maxmind.geoip2.record.Location location = response.getLocation();
        Subdivision subdivision = response.getMostSpecificSubdivision();
        latitude = location.getLatitude().toString();
        longitude = location.getLongitude().toString();
        city = response.getCity().getName();
        state = subdivision.getIsoCode();
        country = response.getCountry().getName();
        if (useF.contains(country)) {
            weatherUnit = "°F";
            windUnit = "mph";
        } else {
            weatherUnit = "°C";
            windUnit = "km/h";
        }
        if (state == null) {
            state = "";
        }
    }

    Location(String zipcode) throws FileNotFoundException, IOException {
        CsvReader zipDB = new CsvReader("db/zipcode.csv");
        zipDB.readHeaders();
        while (zipDB.readRecord()) {
            if (zipDB.get(zipDB.getHeader(0)).equals(zipcode)) {
                latitude = zipDB.get(zipDB.getHeader(2));
                longitude = zipDB.get(zipDB.getHeader(3));
                city = zipDB.get(zipDB.getHeader(4));
                state = zipDB.get(zipDB.getHeader(1));
                country = "United States";
                weatherUnit = "°F";
                windUnit = "mph";
            }
        }
    }
    
    Location (String latitude, String longitude, String city, String state, String country) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.state = state;
        this.country = country;
        this.weatherUnit = "°F";
        this.windUnit = "mph";
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWeatherUnit() {
        return weatherUnit;
    }

    public void setWeatherUnit(String weatherUnit) {
        this.weatherUnit = weatherUnit;
    }

    public String getWindUnit() {
        return windUnit;
    }

    public void setWindUnit(String windUnit) {
        this.windUnit = windUnit;
    }

}
