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
public class RecommendationFrame extends WFrame{
    
    RecommendationPanel rp;
    
    public RecommendationFrame() {
        super("User Recommendations");
        setSize(800,400);
        setResizable(false);
        setVisible(true);
        
        rp = new RecommendationPanel();
        add(rp);
    }
    
}
