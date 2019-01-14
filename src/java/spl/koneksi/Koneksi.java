/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spl.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;

/**
 *
 * @author khoerulAbu
 */
public class Koneksi {
   //static reference to itself
    private static Koneksi instance =  new Koneksi();
    String url = "jdbc:mysql://localhost/lembur_db";
    String user = "root";
    String password = "";
    String driverClass = "com.mysql.jdbc.Driver"; 
     
    //private constructor
    private Koneksi() {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    public static Koneksi getInstance()   {
        return instance;
    }
     
    public Connection getConnection() throws SQLException, 
    ClassNotFoundException {
        Connection connection = 
            DriverManager.getConnection(url, user, password);
        return connection;
    }   
}
