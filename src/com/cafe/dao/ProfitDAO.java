/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafe.dao;
import com.cafe.model.Profit;
import com.cafe.database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author rama
 */
public class ProfitDAO {
    private Connection connection;

    public ProfitDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public void addProfit(Profit profit) throws SQLException {
        String query = "INSERT INTO keuntungan (tanggal, pendapatan, pengeluaran, keuntungan_bersih) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, new java.sql.Date(profit.getTanggal().getTime()));
            pstmt.setDouble(2, profit.getPendapatan());
            pstmt.setDouble(3, profit.getPengeluaran());
            pstmt.setDouble(4, profit.getKeuntunganBersih());
            pstmt.executeUpdate();
            
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    profit.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public Profit getProfit(int id) throws SQLException {
        String query = "SELECT * FROM keuntungan WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractProfitFromResultSet(rs);
                }
            }
        }
        return null;
    }

    public List<Profit> getAllProfits() throws SQLException {
        List<Profit> profits = new ArrayList<>();
        String query = "SELECT * FROM keuntungan";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                profits.add(extractProfitFromResultSet(rs));
            }
        }
        return profits;
    }

    public List<Profit> getProfitsByDateRange(java.util.Date startDate, java.util.Date endDate) throws SQLException {
        List<Profit> profits = new ArrayList<>();
        String query = "SELECT * FROM keuntungan WHERE tanggal BETWEEN ? AND ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDate(1, new java.sql.Date(startDate.getTime()));
            pstmt.setDate(2, new java.sql.Date(endDate.getTime()));
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    profits.add(extractProfitFromResultSet(rs));
                }
            }
        }
        return profits;
    }

    public void updateProfit(Profit profit) throws SQLException {
        String query = "UPDATE keuntungan SET tanggal = ?, pendapatan = ?, pengeluaran = ?, keuntungan_bersih = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDate(1, new java.sql.Date(profit.getTanggal().getTime()));
            pstmt.setDouble(2, profit.getPendapatan());
            pstmt.setDouble(3, profit.getPengeluaran());
            pstmt.setDouble(4, profit.getKeuntunganBersih());
            pstmt.setInt(5, profit.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteProfit(int id) throws SQLException {
        String query = "DELETE FROM keuntungan WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    private Profit extractProfitFromResultSet(ResultSet rs) throws SQLException {
        Profit profit = new Profit();
        profit.setId(rs.getInt("id"));
        profit.setTanggal(rs.getDate("tanggal"));
        profit.setPendapatan(rs.getDouble("pendapatan"));
        profit.setPengeluaran(rs.getDouble("pengeluaran"));
        profit.setKeuntunganBersih(rs.getDouble("keuntungan_bersih"));
        return profit;
    }
}
