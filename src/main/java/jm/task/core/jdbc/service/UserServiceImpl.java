package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
//    JDBC realisation
//
//    private final UserDaoJDBCImpl userDAO = new UserDaoJDBCImpl();
//
//    public void createUsersTable() {
//        userDAO.createUsersTable();
//    }
//
//    public void dropUsersTable() {
//        userDAO.dropUsersTable();
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        userDAO.saveUser(name, lastName, age);
//    }
//
//    public void removeUserById(long id) {
//        userDAO.removeUserById(id);
//    }
//
//    public List<User> getAllUsers() {
//        return userDAO.getAllUsers();
//    }
//
//    public void cleanUsersTable() {
//        userDAO.cleanUsersTable();
//    }

//    Hibernate realisation
    private final UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {
        userDaoHibernate.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userDaoHibernate.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernate.saveUser(name,lastName,age);
    }

    @Override
    public void removeUserById(long id) {
        userDaoHibernate.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoHibernate.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDaoHibernate.cleanUsersTable();
    }
}
