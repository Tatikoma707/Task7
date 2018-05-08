package com.epam.dmitriy_abdulin.java.lesson7.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by dima7 on 05.05.2018.
 */
public class ConnectionFactory {
    public static Connection getConnection() {
        final String url = "jdbc:mysql://localhost:3306/world";
        final String user = "root";
        final String password = "mysql";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
