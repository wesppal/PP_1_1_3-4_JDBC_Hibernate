package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoJDBCImpl();
    private UserDao userDaoH = new UserDaoHibernateImpl();

    public void createUsersTable() {
//        userDao.createUsersTable();
        userDaoH.createUsersTable();
    }

    public void dropUsersTable() {
//        userDao.dropUsersTable();
        userDaoH.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
//        userDao.saveUser(name, lastName, age);
        userDaoH.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
//        userDao.removeUserById(id);
        userDaoH.removeUserById(id);
    }

    public List<User> getAllUsers() {
//        return userDao.getAllUsers();
        return userDaoH.getAllUsers();
    }

    public void cleanUsersTable() {
//        userDao.cleanUsersTable();
        userDaoH.cleanUsersTable();
    }
}
