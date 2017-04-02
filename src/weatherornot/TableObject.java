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
class TableObject {
    private String cityRegion;
    private String lat;
    private String longitude;
    
    public TableObject(String cityRegion, String lat, String longitude) {
        this.cityRegion = cityRegion;
        this.lat = lat;
        this.longitude = longitude;
    }

    public String getCityRegion() {
        return cityRegion;
    }

    public String getLat() {
        return lat;
    }

    public String getLongitude() {
        return longitude;
    }
    
    
}
