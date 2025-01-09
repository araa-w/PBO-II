/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafe.controller;
import com.cafe.dao.OrderDAO;
import com.cafe.dao.OrderDetailDAO;
import com.cafe.model.Order;
import com.cafe.model.OrderDetail;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
/**
 *
 * @author rama
 */
public class OrderController {
     private OrderDAO orderDAO;
    private OrderDetailDAO orderDetailDAO;

    public OrderController() {
        orderDAO = new OrderDAO();
        orderDetailDAO = new OrderDetailDAO();
    }

    public boolean createOrder(Date tanggal, double total, int kasirId, List<OrderDetail> orderDetails) {
        try {
            Order newOrder = new Order();
            newOrder.setTanggal(tanggal);
            newOrder.setTotal(total);
            newOrder.setKasirId(kasirId);
            
            orderDAO.addOrder(newOrder);
            
            for (OrderDetail detail : orderDetails) {
                detail.setPesananId(newOrder.getId());
                orderDetailDAO.addOrderDetail(detail);
            }
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Order getOrder(int id) {
        try {
            Order order = orderDAO.getOrder(id);
            if (order != null) {
                List<OrderDetail> details = orderDetailDAO.getOrderDetailsByOrderId(id);
                // Anda mungkin ingin menambahkan metode setOrderDetails ke kelas Order
                // order.setOrderDetails(details);
            }
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Order> getAllOrders() {
        try {
            return orderDAO.getAllOrders();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateOrder(Order order, List<OrderDetail> orderDetails) {
        try {
            orderDAO.updateOrder(order);
            
            // Hapus detail pesanan lama
            List<OrderDetail> oldDetails = orderDetailDAO.getOrderDetailsByOrderId(order.getId());
            for (OrderDetail oldDetail : oldDetails) {
                orderDetailDAO.deleteOrderDetail(oldDetail.getId());
            }
            
            // Tambahkan detail pesanan baru
            for (OrderDetail detail : orderDetails) {
                orderDetailDAO.addOrderDetail(detail);
            }
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteOrder(int id) {
        try {
            // Hapus detail pesanan terlebih dahulu
            List<OrderDetail> details = orderDetailDAO.getOrderDetailsByOrderId(id);
            for (OrderDetail detail : details) {
                orderDetailDAO.deleteOrderDetail(detail.getId());
            }
            
            // Kemudian hapus pesanan
            orderDAO.deleteOrder(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
