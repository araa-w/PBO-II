/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafe.dao;
import com.cafe.model.Expense;
import com.cafe.database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rama
 */
public class ExpenseDAO {
    private Connection connection;

    public ExpenseDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public void addExpense(Expense expense) throws SQLException {
        String query = "INSERT INTO pengeluaran (tanggal, deskripsi, jumlah, pengguna_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, new java.sql.Date(expense.getTanggal().getTime()));
            pstmt.setString(2, expense.getDeskripsi());
            pstmt.setDouble(3, expense.getJumlah());
            pstmt.setInt(4, expense.getPenggunaId());
            pstmt.executeUpdate();
            
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    expense.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public Expense getExpense(int id) throws SQLException {
        String query = "SELECT * FROM pengeluaran WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractExpenseFromResultSet(rs);
                }
            }
        }
        return null;
    }

    public List<Expense> getAllExpenses() throws SQLException {
        List<Expense> expenses = new ArrayList<>();
        String query = "SELECT * FROM pengeluaran";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                expenses.add(extractExpenseFromResultSet(rs));
            }
        }
        return expenses;
    }

    public List<Expense> getExpensesByDateRange(java.util.Date startDate, java.util.Date endDate) throws SQLException {
        List<Expense> expenses = new ArrayList<>();
        String query = "SELECT * FROM pengeluaran WHERE tanggal BETWEEN ? AND ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDate(1, new java.sql.Date(startDate.getTime()));
            pstmt.setDate(2, new java.sql.Date(endDate.getTime()));
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    expenses.add(extractExpenseFromResultSet(rs));
                }
            }
        }
        return expenses;
    }

    public void updateExpense(Expense expense) throws SQLException {
        String query = "UPDATE pengeluaran SET tanggal = ?, deskripsi = ?, jumlah = ?, pengguna_id = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDate(1, new java.sql.Date(expense.getTanggal().getTime()));
            pstmt.setString(2, expense.getDeskripsi());
            pstmt.setDouble(3, expense.getJumlah());
            pstmt.setInt(4, expense.getPenggunaId());
            pstmt.setInt(5, expense.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteExpense(int id) throws SQLException {
        String query = "DELETE FROM pengeluaran WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    private Expense extractExpenseFromResultSet(ResultSet rs) throws SQLException {
        Expense expense = new Expense();
        expense.setId(rs.getInt("id"));
        expense.setTanggal(rs.getDate("tanggal"));
        expense.setDeskripsi(rs.getString("deskripsi"));
        expense.setJumlah(rs.getDouble("jumlah"));
        expense.setPenggunaId(rs.getInt("pengguna_id"));
        return expense;
    }
}
