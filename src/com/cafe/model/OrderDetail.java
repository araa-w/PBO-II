/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafe.model;

/**
 *
 * @author rama
 */
public class OrderDetail {
    private int id;
    private int pesananId;
    private int menuId;
    private int jumlah;
    private double subtotal;

    public OrderDetail() {}

    public OrderDetail(int id, int pesananId, int menuId, int jumlah, double subtotal) {
        this.id = id;
        this.pesananId = pesananId;
        this.menuId = menuId;
        this.jumlah = jumlah;
        this.subtotal = subtotal;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPesananId() {
        return pesananId;
    }

    public void setPesananId(int pesananId) {
        this.pesananId = pesananId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
