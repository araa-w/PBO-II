/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafe.dao;
import com.cafe.model.Order;
import com.cafe.database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author rama
 */
public class OrderDAO {
    private Connection connection;

    public OrderDAO() {
        connection = DatabaseConnection.getConnection();
    }
    
    public List<Order> getOrdersByDateRange(Date startDate, Date endDate) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM pesanan WHERE tanggal BETWEEN ? AND ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDate(1, new java.sql.Date(startDate.getTime()));
            pstmt.setDate(2, new java.sql.Date(endDate.getTime()));
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    orders.add(extractOrderFromResultSet(rs));
                }
            }
        }
        return orders;
    }

    public void addOrder(Order order) throws SQLException {
        String query = "INSERT INTO pesanan (tanggal, total, kasir_id) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, new java.sql.Date(order.getTanggal().getTime()));
            pstmt.setDouble(2, order.getTotal());
            pstmt.setInt(3, order.getKasirId());
            pstmt.executeUpdate();
            
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    order.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public Order getOrder(int id) throws SQLException {
        String query = "SELECT * FROM pesanan WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractOrderFromResultSet(rs);
                }
            }
        }
        return null;
    }

    public List<Order> getAllOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM pesanan";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                orders.add(extractOrderFromResultSet(rs));
            }
        }
        return orders;
    }

    public void updateOrder(Order order) throws SQLException {
        String query = "UPDATE pesanan SET tanggal = ?, total = ?, kasir_id = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDate(1, new java.sql.Date(order.getTanggal().getTime()));
            pstmt.setDouble(2, order.getTotal());
            pstmt.setInt(3, order.getKasirId());
            pstmt.setInt(4, order.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteOrder(int id) throws SQLException {
        String query = "DELETE FROM pesanan WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    private Order extractOrderFromResultSet(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setTanggal(rs.getDate("tanggal"));
        order.setTotal(rs.getDouble("total"));
        order.setKasirId(rs.getInt("kasir_id"));
        return order;
    }
}
