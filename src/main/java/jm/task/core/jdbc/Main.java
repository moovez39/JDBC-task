package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

//        JDBC REALISATION
//        userService.createUsersTable();
//        userService.saveUser("John","Cena", (byte)45);
//        userService.saveUser("Oleg","Tinkoff", (byte)66);
//        userService.saveUser("Ivan","Pupkin", (byte)34);
//        userService.saveUser("Petr","Perviy", (byte)88);
//        userService.getAllUsers();
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
//        Util.closeConnection();

//        Hibernate realisation
        userService.createUsersTable();
        userService.saveUser("John", "Cena", (byte) 45);
        userService.saveUser("Oleg", "Tinkoff", (byte) 66);
        userService.saveUser("Ivan", "Pupkin", (byte) 34);
        userService.saveUser("Petr", "Perviy", (byte) 88);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
        Util.closeSessionFactory();
    }
}
