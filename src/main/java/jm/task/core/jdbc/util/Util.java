package jm.task.core.jdbc.util;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/test_database";
    private static Connection CONNECTION = null;

    public static Connection openConnection() {
        if (CONNECTION != null) {
            return CONNECTION;
        } else {
            try {
                CONNECTION = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Connected to database");
            } catch (SQLException e) {
                System.err.println("Could not connect to database");
                e.printStackTrace();
            }
        }
        return CONNECTION;
    }

    public static void closeConnection() {
        if (CONNECTION != null) {
            try {
                CONNECTION.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                System.err.println("Could not close connection");
                throw new RuntimeException(e);
            }
        }
    }
}

