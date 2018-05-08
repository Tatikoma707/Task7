package com.epam.dmitriy_abdulin.java.lesson7.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by dima7 on 05.05.2018.
 */
public class Main {

    public static void main(String[] args) {
        String query = "select * from books";

        try {
            Connection connection = ConnectionFactory.getConnection();
            process(connection);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int id = 0;
            ArrayList<String> names = new ArrayList<>();
            ArrayList<String> authors = new ArrayList<>();
            while (resultSet.next()) {
                names.add(resultSet.getString(2));
                authors.add(resultSet.getString(3));
                id++;
            }
            int idCount = id;
            for (int i = 0; i < id; i++) {
                for (int j = 0; j < 10; j++) {
                    idCount++;
                    String queryInsert = "insert into books(id, name, author) " +
                            "values (" + idCount + ",'" + names.get(i) + "', '" + authors.get(i) + "');";
                    statement.executeUpdate(queryInsert);
                }
            }
            close(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        try {
            resultSet.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    private static void process(Connection connection) {
        System.out.println("Connection success");
    }
}
