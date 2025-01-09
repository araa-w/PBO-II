/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.cafe.view;

import com.cafe.controller.ExpenseController;
import com.cafe.model.Expense;
import com.cafe.tabbed.tabbedForm;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumnModel;;

/**
 *
 * @author vvhal
 */
public class ExpensesForm extends tabbedForm {

    private ExpenseController expenseController;
    private DefaultTableModel expenseTableModel;
    private int editingExpenseId = -1;
    /**
     * Creates new form ExpenseForm
     */
    public ExpensesForm() {
        initComponents();
        expenseController = new ExpenseController();
        setupTable();
        loadExpenseData();
    }
    
    private void setupTable() {
        String[] columns = {"ID", "Tanggal", "Deskripsi", "Jumlah"};
        expenseTableModel = (DefaultTableModel) tblExpens.getModel();
        expenseTableModel.setColumnIdentifiers(columns);
        TableColumnModel columnModel = tblExpens.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30); // Kolom 'ID'
        columnModel.getColumn(1).setPreferredWidth(30);  // Kolom 'Tanggal'
        columnModel.getColumn(2).setPreferredWidth(150); // Kolom 'Desk'
        columnModel.getColumn(3).setPreferredWidth(50); // Kolom 'Jumlah'
        tblExpens.getTableHeader().setResizingAllowed(false); // Mencegah kolom diubah secara manual
        tblExpens.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        // Menambahkan ListSelectionListener ke jTable1
        tblExpens.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblExpens.getSelectedRow();
                if (selectedRow != -1) {
                    editingExpenseId = (int) tblExpens.getValueAt(selectedRow, 0);
                    jDateChooser1.setDate((Date) tblExpens.getValueAt(selectedRow, 1));
                    txtDesx.setText((String) tblExpens.getValueAt(selectedRow, 2));
                    jTextField2.setText(tblExpens.getValueAt(selectedRow, 3).toString());
                    btnNew.setText("Update");
                }
            }
        });
    }
    
    private void loadExpenseData() {
        List<Expense> expenses = expenseController.getAllExpenses();
        expenseTableModel.setRowCount(0);
        for (Expense expense : expenses) {
            Object[] row = {expense.getId(), expense.getTanggal(), expense.getDeskripsi(), expense.getJumlah()};
            expenseTableModel.addRow(row);
        }
    }
    
    private void clearInputFields() {
        editingExpenseId = -1;
        jDateChooser1.setDate(new Date());
        txtDesx.setText("");
        jTextField2.setText("");
        btnNew.setText("Tambah");
    }
    
    private int getCurrentUserId() {
        // Implementasi untuk mendapatkan ID user yang sedang login
        return 1; // Ganti dengan implementasi yang sesuai
    }
    
    public boolean formClose(){
        if (txtDesx.getText().trim().equals("")) {
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
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtDesx = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExpens = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnCetak = new javax.swing.JButton();

        subPanel.setBackground(new java.awt.Color(255, 255, 255));
        subPanel.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tanggal :");

        jDateChooser1.setMaxSelectableDate(new java.util.Date());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Deskripsi :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Jumlah :");

        btnNew.setText("Tambah Pengeluaran");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        tblExpens.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblExpens);

        btnDelete.setText("Hapus Pengeluaran");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Pengeluaran");

        btnCetak.setText("Cetak Laporan");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subPanelLayout = new javax.swing.GroupLayout(subPanel);
        subPanel.setLayout(subPanelLayout);
        subPanelLayout.setHorizontalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addComponent(btnCetak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                            .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(subPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(subPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDesx)))
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        subPanelLayout.setVerticalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDesx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnCetak))
                .addContainerGap(22, Short.MAX_VALUE))
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

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        Date tanggal = jDateChooser1.getDate();
        String deskripsi = txtDesx.getText();
        double jumlah;
        try {
            jumlah = Double.parseDouble(jTextField2.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Jumlah harus berupa angka.");
            return;
        }

        if (editingExpenseId == -1) {
            // Tambah pengeluaran baru
            if (expenseController.addExpense(tanggal, deskripsi, jumlah, getCurrentUserId())) {
                JOptionPane.showMessageDialog(this, "Pengeluaran berhasil ditambahkan");
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menambahkan pengeluaran");
            }
        } else {
            // Update pengeluaran yang ada
            Expense updatedExpense = new Expense(editingExpenseId, tanggal, deskripsi, jumlah, getCurrentUserId());
            if (expenseController.updateExpense(updatedExpense)) {
                JOptionPane.showMessageDialog(this, "Pengeluaran berhasil diperbarui");
            } else {
                JOptionPane.showMessageDialog(this, "Gagal memperbarui pengeluaran");
            }
        }
        loadExpenseData();
        clearInputFields();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tblExpens.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tblExpens.getValueAt(selectedRow, 0);
            if (expenseController.deleteExpense(id)) {
                JOptionPane.showMessageDialog(this, "Pengeluaran berhasil dihapus");
                loadExpenseData();
                clearInputFields();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus pengeluaran");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih pengeluaran yang akan dihapus");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        try {
        // Buat folder 'Laporan' di direktori aplikasi jika belum ada
        String folderPath = "Laporan/Pengeluaran";
        Files.createDirectories(Paths.get(folderPath));
        
        // Buat nama file dengan timestamp
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
        String timestamp = dateFormat.format(new Date());
        String fileName = "Laporan_Pengeluaran_" + timestamp + ".pdf";
        
        // Path lengkap file PDF
        String filePath = folderPath + File.separator + fileName;
        
        // Buat dokumen PDF
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();
        
        // Tambah judul
        Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Paragraph title = new Paragraph("Laporan Pengeluaran", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        
        // Tambah tanggal cetak
        Font dateFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
        SimpleDateFormat printDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Paragraph printDate = new Paragraph("Tanggal Cetak: " + printDateFormat.format(new Date()), dateFont);
        printDate.setAlignment(Element.ALIGN_RIGHT);
        document.add(printDate);
        document.add(new Paragraph("\n"));
        
        // Buat tabel
        PdfPTable pdfTable = new PdfPTable(4);
        pdfTable.setWidthPercentage(100);
        
        // Set lebar kolom (total = 100)
        float[] columnWidths = {10f, 20f, 50f, 20f};
        pdfTable.setWidths(columnWidths);
        
        // Header tabel
        String[] headers = {"ID", "Tanggal", "Deskripsi", "Jumlah"};
        Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setPadding(5);
            pdfTable.addCell(cell);
        }
        
        // Isi tabel
        Font contentFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
        SimpleDateFormat tableDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        double totalJumlah = 0;
        
        for (int i = 0; i < tblExpens.getRowCount(); i++) {
            // ID
            PdfPCell cellId = new PdfPCell(new Phrase(tblExpens.getValueAt(i, 0).toString(), contentFont));
            cellId.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfTable.addCell(cellId);
            
            // Tanggal
            Date date = (Date) tblExpens.getValueAt(i, 1);
            PdfPCell cellDate = new PdfPCell(new Phrase(tableDateFormat.format(date), contentFont));
            cellDate.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfTable.addCell(cellDate);
            
            // Deskripsi
            PdfPCell cellDesc = new PdfPCell(new Phrase(tblExpens.getValueAt(i, 2).toString(), contentFont));
            cellDesc.setHorizontalAlignment(Element.ALIGN_LEFT);
            pdfTable.addCell(cellDesc);
            
            // Jumlah
            double jumlah = Double.parseDouble(tblExpens.getValueAt(i, 3).toString());
            totalJumlah += jumlah;
            PdfPCell cellJumlah = new PdfPCell(new Phrase(String.format("Rp %.2f", jumlah), contentFont));
            cellJumlah.setHorizontalAlignment(Element.ALIGN_RIGHT);
            pdfTable.addCell(cellJumlah);
        }
        
        // Tambah total
        PdfPCell cellTotal = new PdfPCell(new Phrase("Total", headerFont));
        cellTotal.setColspan(3);
        cellTotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cellTotal.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cellTotal.setPadding(5);
        pdfTable.addCell(cellTotal);
        
        PdfPCell cellTotalValue = new PdfPCell(new Phrase(String.format("Rp %.2f", totalJumlah), headerFont));
        cellTotalValue.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cellTotalValue.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cellTotalValue.setPadding(5);
        pdfTable.addCell(cellTotalValue);
        
        document.add(pdfTable);
        document.close();
        
        // Buka file PDF setelah dibuat
        File pdfFile = new File(filePath);
        if (pdfFile.exists()) {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(pdfFile);
            } else {
                JOptionPane.showMessageDialog(this, "PDF berhasil dibuat di: " + filePath);
            }
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error membuat PDF: " + e.getMessage());
        e.printStackTrace();
    }

    }//GEN-LAST:event_btnCetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel subPanel;
    private javax.swing.JTable tblExpens;
    private javax.swing.JTextField txtDesx;
    // End of variables declaration//GEN-END:variables
}
