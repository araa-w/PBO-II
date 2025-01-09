/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafe.controller;
import com.cafe.dao.MenuDAO;
import com.cafe.model.Menu;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author rama
 */
public class MenuController {
    private MenuDAO menuDAO;

    public MenuController() {
        menuDAO = new MenuDAO();
    }

    public boolean addMenu(String nama, double harga, String kategori) {
        Menu newMenu = new Menu();
        newMenu.setNama(nama);
        newMenu.setHarga(harga);
        newMenu.setKategori(kategori);

        try {
            menuDAO.addMenu(newMenu);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Menu> getAllMenus() {
        try {
            return menuDAO.getAllMenus();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Menu getMenuByName(String nama) {
        try {
            return menuDAO.getMenuByName(nama);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Tambahkan metode baru ini
    public List<Menu> getMenusByCategory(String category) {
        try {
            return menuDAO.getMenusByCategory(category);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    

    public boolean updateMenu(int id, String nama, double harga, String kategori) {
        Menu menu = new Menu();
        menu.setId(id);
        menu.setNama(nama);
        menu.setHarga(harga);
        menu.setKategori(kategori);

        try {
            menuDAO.updateMenu(menu);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMenu(int id) {
        try {
            menuDAO.deleteMenu(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
