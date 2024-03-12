package com.dh.dental.clinic.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbMySQL {

    private static dbMySQL instance;
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/ . . . ";
    private static final String USER = "root";
    private static final String PASSWORD = "Bdatos2023";
    private dbMySQL(){
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static dbMySQL getInstance() {
        if(instance == null){
            instance = new dbMySQL();
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }


}
