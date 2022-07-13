package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String connectionString = "jdbc:mysql://127.0.0.1:3306/katapp";
    private static final String login = "root";
    private static final String password = "root";
    private static Connection connection = null;


    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(connectionString, login, password);
            System.out.println("Connection is open.");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
