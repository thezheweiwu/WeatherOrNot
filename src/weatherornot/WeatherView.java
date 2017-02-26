/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.io.IOException;

/**
 *
 * @author Zhewei
 */
class WeatherView {
    
    private WeatherFrame wf;
    private WeatherModel wm;
    
    WeatherView(WeatherModel model) throws IOException, GeoIp2Exception {
        wm = new WeatherModel();
        wf = new WeatherFrame();
    }

    public WeatherFrame getWf() {
        return wf;
    }

    public void setWf(WeatherFrame wf) {
        this.wf = wf;
    }

    public WeatherModel getWm() {
        return wm;
    }

    public void setWm(WeatherModel wm) {
        this.wm = wm;
    }
    
}
