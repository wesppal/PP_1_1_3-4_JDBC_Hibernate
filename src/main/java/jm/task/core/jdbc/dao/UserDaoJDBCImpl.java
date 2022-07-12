package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static Connection connection = null;
    private static Statement statement = null;
    private final static String CREATE_USER_TABLE_SQL = "CREATE TABLE IF NOT EXISTS user(id BIGINT primary key" +
            " auto_increment, name varchar(100),  lastName varchar(100), age int)";
    private final static String DROP_USER_TABLE_SQL = "DROP TABLE IF EXISTS user";
    private final static String ADD_NEW_USER_SQL = "INSERT INTO user (name, lastName, age) VALUES (?, ?, ?)";


    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        actionWithTable(CREATE_USER_TABLE_SQL);
    }

    public void dropUsersTable() {
        actionWithTable(DROP_USER_TABLE_SQL);
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            connection = Util.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement statement = connection.prepareStatement(ADD_NEW_USER_SQL, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.execute();


            ResultSet resultSet = statement.getGeneratedKeys();
            User user = new User();
            while (resultSet.next()) {
                user.setId(resultSet.getLong(1));
            }

            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            System.out.println("Was saved " + user);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }

    private void actionWithTable(String sqlQuery) {
        try {
            Class.forName(Util.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = Util.getConnection();
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
