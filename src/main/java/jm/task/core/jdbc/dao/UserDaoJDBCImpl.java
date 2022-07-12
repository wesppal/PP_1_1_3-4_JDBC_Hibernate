package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final static String CREATE_USER_TABLE_SQL = "CREATE TABLE IF NOT EXISTS user(id BIGINT primary key" +
            " auto_increment, name varchar(100),  lastName varchar(100), age int)";
    private final static String DROP_USER_TABLE_SQL = "DROP TABLE IF EXISTS user";
    private final static String ADD_NEW_USER_SQL = "INSERT INTO user VALUE (0,?,?,?)";


    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {

        Util.getDBConnectWithExecuteQuery(CREATE_USER_TABLE_SQL);
    }

    public void dropUsersTable() {
        Util.getDBConnectWithExecuteQuery(DROP_USER_TABLE_SQL);
    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
