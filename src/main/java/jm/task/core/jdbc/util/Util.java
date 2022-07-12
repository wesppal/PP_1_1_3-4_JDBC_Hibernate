package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static Connection connection = null;
    private static Statement statement = null;

    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String connectionString = "jdbc:mysql://127.0.0.1:3306/katapp";
    private static final String login = "root";
    private static final String password = "root";


    public static void getDBConnectWithExecuteQuery (String sqlQuery) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(connectionString, login, password);
            statement = connection.createStatement();
            statement.execute(sqlQuery);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
