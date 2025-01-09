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
public class RegistrationController {
    private UserDAO userDAO;

    public RegistrationController() {
        userDAO = new UserDAO();
    }

    public boolean registerUser(String username, String password, String namaLengkap, String email, String role) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password); 
        newUser.setNamaLengkap(namaLengkap);
        newUser.setEmail(email);
        newUser.setRole(role);

        try {
            userDAO.addUser(newUser);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
