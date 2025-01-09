/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafe.controller;
import com.cafe.dao.ExpenseDAO;
import com.cafe.model.Expense;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
/**
 *
 * @author rama
 */
public class ExpenseController {
    private ExpenseDAO expenseDAO;

    public ExpenseController() {
        expenseDAO = new ExpenseDAO();
    }

    public boolean addExpense(Date tanggal, String deskripsi, double jumlah, int penggunaId) {
        Expense newExpense = new Expense();
        newExpense.setTanggal(tanggal);
        newExpense.setDeskripsi(deskripsi);
        newExpense.setJumlah(jumlah);
        newExpense.setPenggunaId(penggunaId);

        try {
            expenseDAO.addExpense(newExpense);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Expense getExpense(int id) {
        try {
            return expenseDAO.getExpense(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Expense> getAllExpenses() {
        try {
            return expenseDAO.getAllExpenses();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Expense> getExpensesByDateRange(Date startDate, Date endDate) {
        try {
            return expenseDAO.getExpensesByDateRange(startDate, endDate);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateExpense(Expense expense) {
        try {
            expenseDAO.updateExpense(expense);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteExpense(int id) {
        try {
            expenseDAO.deleteExpense(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
