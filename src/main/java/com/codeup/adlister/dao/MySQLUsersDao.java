package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users{
    private Connection connection = null;


//    constructor
    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findByUsername(String username) {
        try {
            PreparedStatement stmt=connection.prepareStatement("Select * from users where username=?");
            stmt.setString(1,username);
            ResultSet rs =stmt.executeQuery();
            rs.next();
            return extractUser(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

//    private List<User> createUsersFromResults(ResultSet rs) throws SQLException {
//        List<User> users = new ArrayList<>();
//        while (rs.next()) {
//            users.add(extractUser(rs));
//        }
//        return users;
//    }



    @Override
    public Long insert(User user) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO users(username, email, password) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,user.getUsername());
            stmt.setString(2,user.getEmail());
            stmt.setString(3,user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }

}
