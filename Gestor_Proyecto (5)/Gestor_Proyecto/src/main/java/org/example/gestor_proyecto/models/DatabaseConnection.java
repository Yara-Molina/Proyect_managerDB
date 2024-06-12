package org.example.gestor_proyecto.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/project_manager";
    private static final String USER = "root";
    private static final String PASSWORD = "noobmaster69";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection to MySQL has been established.");
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting MySQL.");
            e.printStackTrace();
        }
        return connection;
    }
}

