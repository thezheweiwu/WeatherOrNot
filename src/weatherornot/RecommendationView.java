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
    private RecommendationPanel rf; 
    
    RecommendationView () {
        rf = new RecommendationPanel();
    }

    /**
     * @return the rf
     */
    public RecommendationPanel getRf() {
        return rf;
    }

    /**
     * @param rf the rf to set
     */
    public void setRf(RecommendationPanel rf) {
        this.rf = rf;
    }
}
