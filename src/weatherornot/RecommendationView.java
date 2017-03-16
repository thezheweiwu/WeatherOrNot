/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

/**
 *
 * @author Caitlin
 */
public class RecommendationView {
    private RecommendationFrame rf; 
    
    RecommendationView () {
        rf = new RecommendationFrame();
    }

    /**
     * @return the rf
     */
    public RecommendationFrame getRf() {
        return rf;
    }

    /**
     * @param rf the rf to set
     */
    public void setRf(RecommendationFrame rf) {
        this.rf = rf;
    }
}
