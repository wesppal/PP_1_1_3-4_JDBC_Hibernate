package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        User user1 = new User("Doc", "Oct", (byte) 34);
        User user2 = new User("Don", "Pomidor", (byte) 15);
        User user3 = new User("Clark", "Kent", (byte) 24);
        User user4 = new User("Black", "Widow", (byte) 30);

        userDao.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userDao.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userDao.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        userDao.getAllUsers().forEach(System.out::println);
        userDao.cleanUsersTable();
        userDao.dropUsersTable();


    }
}
