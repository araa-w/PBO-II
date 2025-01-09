/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafe.controller;
import com.cafe.dao.ProfitDAO;
import com.cafe.dao.OrderDAO;
import com.cafe.dao.ExpenseDAO;
import com.cafe.model.Profit;
import com.cafe.model.Order;
import com.cafe.model.Expense;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
/**
 *
 * @author rama
 */
public class ProfitController {
    private ProfitDAO profitDAO;
    private OrderDAO orderDAO;
    private ExpenseDAO expenseDAO;

    public ProfitController() {
        profitDAO = new ProfitDAO();
        orderDAO = new OrderDAO();
        expenseDAO = new ExpenseDAO();
    }

    public boolean addProfit(Date tanggal, double pendapatan, double pengeluaran) {
        Profit newProfit = new Profit();
        newProfit.setTanggal(tanggal);
        newProfit.setPendapatan(pendapatan);
        newProfit.setPengeluaran(pengeluaran);
        newProfit.setKeuntunganBersih(pendapatan - pengeluaran);

        try {
            profitDAO.addProfit(newProfit);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Profit getProfit(int id) {
        try {
            return profitDAO.getProfit(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Profit> getAllProfits() {
        try {
            return profitDAO.getAllProfits();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Profit> getProfitsByDateRange(Date startDate, Date endDate) {
        List<Profit> profits = new ArrayList<>();
        try {
            List<Order> orders = orderDAO.getOrdersByDateRange(startDate, endDate);
            List<Expense> expenses = expenseDAO.getExpensesByDateRange(startDate, endDate);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            while (!calendar.getTime().after(endDate)) {
                Date currentDate = calendar.getTime();
                double dailyRevenue = calculateDailyRevenue(orders, currentDate);
                double dailyExpense = calculateDailyExpense(expenses, currentDate);
                double dailyProfit = dailyRevenue - dailyExpense;

                Profit profit = new Profit();
                profit.setTanggal(currentDate);
                profit.setPendapatan(dailyRevenue);
                profit.setPengeluaran(dailyExpense);
                profit.setKeuntunganBersih(dailyProfit);

                profits.add(profit);

                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profits;
    }
    
    private double calculateDailyRevenue(List<Order> orders, Date date) {
        return orders.stream()
                .filter(order -> isSameDay(order.getTanggal(), date))
                .mapToDouble(Order::getTotal)
                .sum();
    }

    private double calculateDailyExpense(List<Expense> expenses, Date date) {
        return expenses.stream()
                .filter(expense -> isSameDay(expense.getTanggal(), date))
                .mapToDouble(Expense::getJumlah)
                .sum();
    }
    
    private boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }

    public boolean updateProfit(Profit profit) {
        try {
            profitDAO.updateProfit(profit);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteProfit(int id) {
        try {
            profitDAO.deleteProfit(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
