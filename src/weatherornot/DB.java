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
    
    private Connection connection;
    private Statement statement;
    
    DB() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:WeatherOrNot.db");
        statement = connection.createStatement();
        statement.setQueryTimeout(30);
    }

    public void insertSql(String sql) throws SQLException {
        statement.executeUpdate(sql);
    }
    
    public ResultSet getRows(String sql) throws SQLException {
        ResultSet rs = statement.executeQuery(sql);
        return rs;
    }
    
    public static void main(String arg[]) throws ClassNotFoundException, SQLException {
        DB database = new DB();
        database.insertSql("drop table if exists preference");
        database.insertSql("create table preference (id integer, transportation text, distance text, rain text, snow text)");
    }
}
