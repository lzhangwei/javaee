package com.tw.core;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizhang on 7/8/15.
 */
public class UserDao {

    public List<User> getUsers() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        List<User> users = new ArrayList<User>();

        try {
            connection = DBHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setGender(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setAge(resultSet.getInt(5));
                users.add(user);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.closeResource(resultSet, statement, connection);
        }
        return users;
    }

    public void addUser(User aUser) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBHelper.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO users VALUES (null,?,?,?,?)");
            preparedStatement.setString(1, aUser.getName());
            preparedStatement.setString(2, aUser.getGender());
            preparedStatement.setString(3, aUser.getEmail());
            preparedStatement.setInt(4, aUser.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResource(null,preparedStatement,connection);
        }
    }

    public void deleteUser(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBHelper.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResource(null,preparedStatement,connection);
        }
    }

    public void updateUser(User aUser) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBHelper.getConnection();
            preparedStatement = connection.prepareStatement("update users set name=?,gender=?,email=?,age=? where id=?");
            preparedStatement.setString(1, aUser.getName());
            preparedStatement.setString(2, aUser.getGender());
            preparedStatement.setString(3, aUser.getEmail());
            preparedStatement.setInt(4, aUser.getAge());
            preparedStatement.setInt(5, aUser.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeResource(null,preparedStatement,connection);
        }

    }

    public User getUserById(int userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        User myUser = new User();

        try {
            connection = DBHelper.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            preparedStatement.setInt(1,userId);

            if (resultSet.next()) {
                myUser.setId(resultSet.getInt(1));
                myUser.setName(resultSet.getString(2));
                myUser.setGender(resultSet.getString(3));
                myUser.setEmail(resultSet.getString(4));
                myUser.setAge(resultSet.getInt(5));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBHelper.closeResource(resultSet,preparedStatement,connection);
        }
        return myUser;
    }
}
