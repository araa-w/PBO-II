/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafe.model;
import java.util.Date;
/**
 *
 * @author rama
 */
public class Order {
    private int id;
    private Date tanggal;
    private double total;
    private int kasirId;

    public Order() {}

    public Order(int id, Date tanggal, double total, int kasirId) {
        this.id = id;
        this.tanggal = tanggal;
        this.total = total;
        this.kasirId = kasirId;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getKasirId() {
        return kasirId;
    }

    public void setKasirId(int kasirId) {
        this.kasirId = kasirId;
    }
}
