package org.example.myappm.DAO;

import org.example.myappm.Models.User;
import org.example.myappm.Utils.UserUtility;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Logger;

public class UserDAO {
    private Connection connection;

    private static final Logger logger = Logger.getLogger(UserDAO.class.getName());


    public UserDAO(Connection connection){
        this.connection = connection;
    }

    public User findUserByCredentials(String userName, String password){
        ResultSet resultSet = null;
        User user = null;
        String sql = "SELECT id, UserName, Password FROM users WHERE UserName = ?";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, userName);
            resultSet = stmt.executeQuery();
            if(resultSet.next()){
                String  storedPasswordHash = resultSet.getString("Password");
                if(UserUtility.verifyPassword(password,storedPasswordHash)){
                    user = new User(resultSet.getInt("Id"),resultSet.getString("UserName"));
                }

            }
        }catch (SQLException e){
            logger.severe("Database error while try to find user by cred");
            e.printStackTrace();
        }

        return user;
    }


    public void createUser(String userName, String password, LocalDate date){
        String sql = "INSERT INTO users (UserName, Password, Date) VALUES (?, ?, ?)";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, userName);
            stmt.setString(2, UserUtility.hashPassword(password));
            stmt.setDate(3, Date.valueOf(date));
            stmt.executeUpdate();
        }catch (SQLException e){
            logger.severe("Error creating user: " + e.getMessage());
        }
    }


}
