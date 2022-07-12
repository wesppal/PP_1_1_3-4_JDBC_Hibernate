package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoJDBCImpl;


public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
//        userDao.createUsersTable();
//        userDao.dropUsersTable();
        String name = "Pavel";
        String lastName = "Paul";
        byte age = 30;
        userDao.saveUser(name,lastName,age);
//        userDao.cleanUsersTable();
        userDao.removeUserById(2);
    }
}
