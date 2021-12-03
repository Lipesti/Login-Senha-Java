/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author felip
 */
public class ConexaoDAO {
    
    public static Connection getConexao () throws Exception {
        Connection conn;
        conn = null;
        
        String serverName = "localhost";
        String mydatabase = "login";
        
        String username = "root";
        String password = "root";
        
        
        String driverName = "com.mysql.jdbc.Driver";
        Class.forName(driverName);
        
        
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
        conn = DriverManager.getConnection(url, username, password);
        
        return conn;
        
        
}
}

