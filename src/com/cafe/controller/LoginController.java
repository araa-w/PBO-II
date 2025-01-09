/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafe.controller;
import com.cafe.dao.UserDAO;
import com.cafe.model.User;
import java.sql.SQLException;
/**
 *
 * @author rama
 */
public class LoginController {
    private UserDAO userDAO;

    public LoginController() {
        userDAO = new UserDAO();
    }

    public User login(String username, String password) {
        try {
            User user = userDAO.getUserByUsername(username);
            if (user != null && password.equals(user.getPassword())) {
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
