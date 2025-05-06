package org.example;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "STUDENT";
    private static Connection connection = null;
    private static final ComboPooledDataSource cpds = new ComboPooledDataSource();

    private Database() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        try {
            connection = cpds.getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        }
        return connection;
    }

    private static void createConnection() {
        cpds.setJdbcUrl(URL);
        cpds.setUser(USER);
        cpds.setPassword(PASSWORD);

    }

}
