/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.cafe.view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;
import com.cafe.controller.OrderController;
import com.cafe.controller.MenuController;
import com.cafe.model.Menu;
import com.cafe.model.OrderDetail;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;
import javax.swing.table.TableColumnModel;
import com.cafe.tabbed.tabbedForm;
import java.text.DecimalFormat;
import raven.toast.Notifications;

/**
 *
 * @author rama
 */
public class OrdersForm extends tabbedForm{
    private OrderController orderController;
    private MenuController menuController;
    private DefaultTableModel orderTableModel;
    private DefaultListModel<String> menuListModel;
    private List<OrderDetail> orderDetails;
    /**
     * Creates new form OrderForm
     */
    public OrdersForm() {
        initComponents();
        orderController = new OrderController();
        menuController = new MenuController();
        orderDetails = new ArrayList<>();
        setupComponents(); // Panggil ini sebelum loadMenuData()
        loadMenuData();
    }
    
    public static String formatRupiah(double totalHarga) {
         // Format mata uang
        DecimalFormat df = new DecimalFormat("#,###");
        String dfTotal = "Rp" + df.format(totalHarga);
        return df.format(totalHarga);
    }
    
     private void setupComponents() {
        // Setup for menu list
        menuListModel = new DefaultListModel<>();
        lstMenu.setModel(menuListModel);

        // Setup for order table
        String[] columns = {"Menu", "Jml", "Harga", "Subtotal"};
        orderTableModel = new DefaultTableModel(columns, 0);
        tblOrder.setModel(orderTableModel);
        TableColumnModel columnModel = tblOrder.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150); // Kolom 'Menu'
        columnModel.getColumn(1).setPreferredWidth(40);  // Kolom 'Jumlah'
        columnModel.getColumn(2).setPreferredWidth(100); // Kolom 'Harga'
        columnModel.getColumn(3).setPreferredWidth(100); // Kolom 'Subtotal'
        tblOrder.getTableHeader().setResizingAllowed(false); // Mencegah kolom diubah secara manual
        tblOrder.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Setup category combo box
        cmbKategori.addItem("Semua");
        cmbKategori.addItem("Makanan");
        cmbKategori.addItem("Minuman");
    }
    
    private void loadMenuData() {
        List<Menu> menus = menuController.getAllMenus();
        menuListModel.clear(); // Sekarang ini aman karena menuListModel sudah diinisialisasi
        for (Menu menu : menus) {
            menuListModel.addElement(menu.getNama());
        }
    }
    
    private void updateTotal() {
        double total = calculateTotal();
        DecimalFormat df = new DecimalFormat("#,###");
        String dfTotal = "Rp" + df.format(total);
        
        txtTotal.setText(dfTotal);
    }
    
    private double calculateTotal() {
        double total = 0;
        for (OrderDetail detail : orderDetails) {
            total += detail.getSubtotal();
        }
        return total;
    }
    
    private void clearOrder() {
        orderDetails.clear();
        orderTableModel.setRowCount(0);
        updateTotal();
    }
    
    private int getCurrentUserId() {
        // Implementasi untuk mendapatkan ID user yang sedang login
        return 1; // Ganti dengan implementasi yang sesuai
    }
    
    private void calculateChange(qrss payForm) {
        try {
            // Get total price and cash amount
            // Remove currency formatting from strings
            String totalStr = payForm.getTxtTotalHarga1().getText().replaceAll("[Rp.,\\s]", "");
            String tunaiStr = payForm.getTxtTunai().getText().replaceAll("[Rp.,\\s]", "");

            // Parse to double
            double total = Double.parseDouble(totalStr);
            double tunai = Double.parseDouble(tunaiStr);
            
//            double totalPrice = Double.parseDouble(payForm.getTxtTotalHarga1().getText());
//            double cashAmount = Double.parseDouble(payForm.getTxtTunai().getText());

            // Calculate change
//            double change = cashAmount - totalPrice;
            double kembalian = tunai - total;
            DecimalFormat df = new DecimalFormat("#,###");
            String dfKembalian = "Rp" + df.format(kembalian);

            // Set change amount in txtTotalKembalian
            payForm.getTxtTotalKembalian().setText(dfKembalian);
        } catch (NumberFormatException ex) {
            // Handle invalid input
            payForm.getTxtTotalKembalian().setText("0");
        }
    }
    
    public boolean formClose(){
        if (txtTotal.getText().trim().equals("")) {
            return true;
        }
        int opt = JOptionPane.showConfirmDialog(this, "Data belum tersimpan, hati hati!", "Warnin", JOptionPane.YES_NO_OPTION);
        return opt == JOptionPane.YES_OPTION;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbKategori = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstMenu = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        spnJumlah = new javax.swing.JSpinner();
        btnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        subPanel.setBackground(new java.awt.Color(255, 255, 255));
        subPanel.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Kategori :");

        cmbKategori.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategoriActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(lstMenu);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Jumlah: ");

        spnJumlah.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        btnAdd.setText("Tambah ke Pesanan");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Daftar Pesanan");

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblOrder);

        btnDelete.setText("Hapus Item");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCancel.setText("Batal Pesanan");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnPay.setText("Proses Pembayaran");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Total Harga :");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subPanelLayout = new javax.swing.GroupLayout(subPanel);
        subPanel.setLayout(subPanelLayout);
        subPanelLayout.setHorizontalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(subPanelLayout.createSequentialGroup()
                                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(subPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spnJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(subPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(subPanelLayout.createSequentialGroup()
                                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(subPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        subPanelLayout.setVerticalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(spnJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnPay))
                .addGap(10, 10, 10)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriActionPerformed
        String selectedCategory = cmbKategori.getSelectedItem().toString();
        List<Menu> menus;
        if ("Semua".equals(selectedCategory)) {
            menus = menuController.getAllMenus();
        } else {
            menus = menuController.getMenusByCategory(selectedCategory);
        }
        menuListModel.clear();
        for (Menu menu : menus) {
            menuListModel.addElement(menu.getNama());
        }
    }//GEN-LAST:event_cmbKategoriActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String selectedMenu = lstMenu.getSelectedValue();
        int jumlah = (int) spnJumlah.getValue();

        if (selectedMenu != null && jumlah > 0) {
            Menu menu = menuController.getMenuByName(selectedMenu);
            if (menu != null) {
                OrderDetail detail = new OrderDetail();
                detail.setMenuId(menu.getId());
                detail.setJumlah(jumlah);
                detail.setSubtotal(menu.getHarga() * jumlah);
                double harga = menu.getHarga();
                double subTotal = menu.getHarga() * jumlah;
                orderDetails.add(detail);

                Object[] row = {selectedMenu, jumlah, formatRupiah(harga), formatRupiah(subTotal)};
                orderTableModel.addRow(row);
                spnJumlah.setValue(0);
                updateTotal();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih menu dan masukkan jumlah");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblOrder.getSelectedRow();
        if (selectedRow != -1) {
            orderDetails.remove(selectedRow);
            orderTableModel.removeRow(selectedRow);
            spnJumlah.setValue(0);
            Notifications.getInstance().show(Notifications.Type.INFO,"Umm, menu berhasil dihapus");
            updateTotal();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih item yang akan dihapus");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        spnJumlah.setValue(0);
        clearOrder();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        if (!orderDetails.isEmpty()) {
            double total = calculateTotal();
            if (orderController.createOrder(new java.util.Date(), total, getCurrentUserId(), orderDetails)) {
                // Membuka QRCodeForm setelah pesanan berhasil diproses
                qrss payForm = new qrss();

                // Set total price from OrderForm to PayForm
                payForm.setTxtTotalHarga1(txtTotal.getText());

                // Copy data from tblOrder to tblPay
                DefaultTableModel modelOrder = (DefaultTableModel) tblOrder.getModel();
                DefaultTableModel modelPay = payForm.getPayTableModel();

                // Clear existing rows in tblPay
                modelPay.setRowCount(0);

                // Copy each row from tblOrder to tblPay
                for (int i = 0; i < modelOrder.getRowCount(); i++) {
                    Vector<Object> row = new Vector<>();
                    for (int j = 0; j < modelOrder.getColumnCount(); j++) {
                        row.add(modelOrder.getValueAt(i, j));
                    }
                    modelPay.addRow(row);
                }

                // Add key listener to txtTunai to calculate change
                payForm.getTxtTunai().addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        calculateChange(payForm);
                    }
                });

                // Show PayForm
                payForm.setVisible(true);

                // Clear order setelah membuka QR Code
                clearOrder();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal memproses pesanan");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada item dalam pesanan");
        }

        // Create PayForm instance

    }//GEN-LAST:event_btnPayActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPay;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> lstMenu;
    private javax.swing.JSpinner spnJumlah;
    private javax.swing.JPanel subPanel;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
