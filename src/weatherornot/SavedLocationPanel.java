/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zhewei
 */
public class SavedLocationPanel extends JPanel {
    
    private JLabel title;
    private final Object[] columnNames = {"City - Region", "Latitude", "Longitude"};
    private final ArrayList<TableObject> data;
    private JTable locations;
    private DefaultTableModel model;
    private DB database;

    
    public SavedLocationPanel() throws ClassNotFoundException, SQLException {
        super();
        this.setLayout(new BorderLayout());
        title = new JLabel("Saved Locations");
        add(title, BorderLayout.NORTH);
        
        data = new ArrayList<>();
        database = new DB();
        String sql = "SELECT * FROM location";
        ResultSet results = database.getRows(sql);
        
        while(results.next()) {
            data.add(new TableObject(results.getString("city") + " - " + results.getString("state"), results.getString("latitude"), results.getString("longitude")));
        }
        
        model = new DefaultTableModel(columnNames, data.size()) {
            public boolean isCellEditable(int i, int j) {
                return false;
            }
        };
        
        
        for (TableObject e : data) {
            model.addRow(new Object[]{e.getCityRegion(), e.getLat(), e.getLongitude()});
        }
        
        locations = new JTable(model);
        add(locations, BorderLayout.CENTER);
    }
}
