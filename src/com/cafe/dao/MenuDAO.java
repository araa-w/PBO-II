/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafe.dao;
import com.cafe.model.Menu;
import com.cafe.database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author rama
 */
public class MenuDAO {
    private Connection connection;

    public MenuDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public void addMenu(Menu menu) throws SQLException {
        String query = "INSERT INTO menu (nama, harga, kategori) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, menu.getNama());
            pstmt.setDouble(2, menu.getHarga());
            pstmt.setString(3, menu.getKategori());
            pstmt.executeUpdate();
            
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    menu.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public Menu getMenu(int id) throws SQLException {
        String query = "SELECT * FROM menu WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractMenuFromResultSet(rs);
                }
            }
        }
        return null;
    }

    public List<Menu> getAllMenus() throws SQLException {
        List<Menu> menus = new ArrayList<>();
        String query = "SELECT * FROM menu";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                menus.add(extractMenuFromResultSet(rs));
            }
        }
        return menus;
    }

    public void updateMenu(Menu menu) throws SQLException {
        String query = "UPDATE menu SET nama = ?, harga = ?, kategori = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, menu.getNama());
            pstmt.setDouble(2, menu.getHarga());
            pstmt.setString(3, menu.getKategori());
            pstmt.setInt(4, menu.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteMenu(int id) throws SQLException {
        String query = "DELETE FROM menu WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    private Menu extractMenuFromResultSet(ResultSet rs) throws SQLException {
        Menu menu = new Menu();
        menu.setId(rs.getInt("id"));
        menu.setNama(rs.getString("nama"));
        menu.setHarga(rs.getDouble("harga"));
        menu.setKategori(rs.getString("kategori"));
        return menu;
    }
    
    public Menu getMenuByName(String nama) throws SQLException {
        String query = "SELECT * FROM menu WHERE nama = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, nama);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractMenuFromResultSet(rs);
                }
            }
        }
        return null;
    }

    // Tambahkan metode baru ini
    public List<Menu> getMenusByCategory(String category) throws SQLException {
        List<Menu> menus = new ArrayList<>();
        String query = "SELECT * FROM menu WHERE kategori = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, category);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    menus.add(extractMenuFromResultSet(rs));
                }
            }
        }
        return menus;
    }
    
     
    
    
}
