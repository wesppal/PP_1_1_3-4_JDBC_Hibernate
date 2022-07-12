package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {

    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String connectionString = "jdbc:mysql://127.0.0.1:3306/katapp";
    private static final String login = "root";
    private static final String password = "root";


    public static Connection getConnection() throws  SQLException{
        return DriverManager.getConnection(connectionString, login, password);
    }

    public static String getDriver() {
        return driverName;
    }

}
