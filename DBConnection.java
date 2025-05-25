package com.voting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/voting_db", 
                "root",                                 
                "Sk@54321"                                
            );
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return conn;
    }
}