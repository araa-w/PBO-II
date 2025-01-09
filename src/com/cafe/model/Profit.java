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
public class Profit {
     private int id;
    private Date tanggal;
    private double pendapatan;
    private double pengeluaran;
    private double keuntunganBersih;

    public Profit() {}

    public Profit(int id, Date tanggal, double pendapatan, double pengeluaran, double keuntunganBersih) {
        this.id = id;
        this.tanggal = tanggal;
        this.pendapatan = pendapatan;
        this.pengeluaran = pengeluaran;
        this.keuntunganBersih = keuntunganBersih;
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

    public double getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(double pendapatan) {
        this.pendapatan = pendapatan;
    }

    public double getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(double pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

    public double getKeuntunganBersih() {
        return keuntunganBersih;
    }

    public void setKeuntunganBersih(double keuntunganBersih) {
        this.keuntunganBersih = keuntunganBersih;
    }
}
