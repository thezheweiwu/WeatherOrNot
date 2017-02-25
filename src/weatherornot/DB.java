/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherornot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Zhewei
 */
public class DB {
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        // Initialize the database
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:WeatherOrNot.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        statement.executeUpdate("drop table if exists preference");
        statement.executeUpdate("create table preference (id integer, transportation text, distance text, rain text, snow text)");
        execute("insert into preference values(1, 'Car', '0.5', 'Yes', 'Yes')");
    }
    
    public static void execute(String sql) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:WeatherOrNot.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        statement.executeUpdate(sql);
    }
    
    public static ResultSet getRows(String sql) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:WeatherOrNot.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        ResultSet rs = statement.executeQuery(sql);
        return rs;
    }

}
