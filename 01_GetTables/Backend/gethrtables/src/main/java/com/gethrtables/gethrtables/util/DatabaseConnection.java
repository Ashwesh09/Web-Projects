package com.gethrtables.gethrtables.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection{
    private static final String URL = "jdbc:mysql://localhost:3307/hr?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static Connection conn = null;
    private  DatabaseConnection() {
    }
    public static Connection getConnection() throws SQLException {
        if(conn == null) {
            conn =  DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Connected to database server "
                + conn.getMetaData().getDatabaseProductName()
                + " version: "
                + conn.getMetaData().getDatabaseProductVersion());
        }
        return conn;
    }
    public static void closeConnection() throws SQLException {
        if(conn != null)
            conn.close();
    }
}
