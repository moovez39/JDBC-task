package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String query = "CREATE TABLE IF NOT EXISTS users(id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                " name VARCHAR(32) NOT NULL ,lastName VARCHAR(32) NOT NULL , age SMALLINT NOT NULL )";
        try (Statement statement = Util.openConnection().createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        String query = "DROP TABLE IF EXISTS users";
        try (Statement statement = Util.openConnection().createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String query = "INSERT INTO users(name,lastName,age) VALUES (?, ?, ?)";
        try (PreparedStatement statement = Util.openConnection().prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.execute();
            System.out.println("User с именем - " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String query = "DELETE users FROM users WHERE id = ?";
        try (PreparedStatement statement = Util.openConnection().prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        String query = "SELECT * FROM users;";
        List<User> users = new ArrayList<>();
        try (Statement statement = Util.openConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
                System.out.println(user);
            }
//            System.out.println(users);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void cleanUsersTable() {
        String query = "TRUNCATE users;";
        try (Statement statement = Util.openConnection().createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
