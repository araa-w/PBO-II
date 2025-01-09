/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafe.dao;
import com.cafe.model.OrderDetail;
import com.cafe.database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author rama
 */
public class OrderDetailDAO {
    private Connection connection;

    public OrderDetailDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public void addOrderDetail(OrderDetail orderDetail) throws SQLException {
        String query = "INSERT INTO detail_pesanan (pesanan_id, menu_id, jumlah, subtotal) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, orderDetail.getPesananId());
            pstmt.setInt(2, orderDetail.getMenuId());
            pstmt.setInt(3, orderDetail.getJumlah());
            pstmt.setDouble(4, orderDetail.getSubtotal());
            pstmt.executeUpdate();
            
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    orderDetail.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public OrderDetail getOrderDetail(int id) throws SQLException {
        String query = "SELECT * FROM detail_pesanan WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractOrderDetailFromResultSet(rs);
                }
            }
        }
        return null;
    }

    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) throws SQLException {
        List<OrderDetail> orderDetails = new ArrayList<>();
        String query = "SELECT * FROM detail_pesanan WHERE pesanan_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, orderId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    orderDetails.add(extractOrderDetailFromResultSet(rs));
                }
            }
        }
        return orderDetails;
    }

    public void updateOrderDetail(OrderDetail orderDetail) throws SQLException {
        String query = "UPDATE detail_pesanan SET pesanan_id = ?, menu_id = ?, jumlah = ?, subtotal = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, orderDetail.getPesananId());
            pstmt.setInt(2, orderDetail.getMenuId());
            pstmt.setInt(3, orderDetail.getJumlah());
            pstmt.setDouble(4, orderDetail.getSubtotal());
            pstmt.setInt(5, orderDetail.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteOrderDetail(int id) throws SQLException {
        String query = "DELETE FROM detail_pesanan WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    private OrderDetail extractOrderDetailFromResultSet(ResultSet rs) throws SQLException {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(rs.getInt("id"));
        orderDetail.setPesananId(rs.getInt("pesanan_id"));
        orderDetail.setMenuId(rs.getInt("menu_id"));
        orderDetail.setJumlah(rs.getInt("jumlah"));
        orderDetail.setSubtotal(rs.getDouble("subtotal"));
        return orderDetail;
    }
}
