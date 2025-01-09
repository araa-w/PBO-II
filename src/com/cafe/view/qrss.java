/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cafe.view;
import javax.swing.*;
import java.awt.Desktop;


import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author vvhal
 */
public class qrss extends javax.swing.JFrame {
    private DefaultTableModel orderTableModel;
    public qrss() {
        initComponents();
        setupComponents();
        
    }
    
    private void setupComponents() {
        String[] columns = {"Menu", "Jml", "Harga", "Subtotal"};
        orderTableModel = new DefaultTableModel(columns, 0);
        tblpay.setModel(orderTableModel);
        TableColumnModel columnModel = tblpay.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150); // Kolom 'Menu'
        columnModel.getColumn(1).setPreferredWidth(40);  // Kolom 'Jumlah'
        columnModel.getColumn(2).setPreferredWidth(100); // Kolom 'Harga'
        columnModel.getColumn(3).setPreferredWidth(100); // Kolom 'Subtotal'
        tblpay.getTableHeader().setResizingAllowed(false); // Mencegah kolom diubah secara manual
        tblpay.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        // Tambahkan KeyListener untuk txtTunai
        txtTunai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculateChange();
            }
        });
    }
    
    private void calculateChange() {
    try {
        // Remove currency formatting from strings
        String totalStr = txtTotalHarga1.getText().replaceAll("[Rp.,\\s]", "");
        String tunaiStr = txtTunai.getText().replaceAll("[Rp.,\\s]", "");
        
        // Parse to double
        double total = Double.parseDouble(totalStr);
        double tunai = Double.parseDouble(tunaiStr);
        
        // Calculate change
        double kembalian = tunai - total;
        DecimalFormat df = new DecimalFormat("#,###");
        String dfKembalian = "Rp" + df.format(kembalian);
       
        
        // Handle negative change (insufficient payment)
        if (kembalian < 0) {
            txtTotalKembalian.setForeground(java.awt.Color.RED);
        } else {
//            txtTotalKembalian.setText(formatter.format(kembalian));
            txtTotalKembalian.setText(dfKembalian);
            txtTotalKembalian.setForeground(java.awt.Color.BLACK);
        }
        
    } catch (NumberFormatException e) {
        txtTotalKembalian.setText("Rp 0");
        txtTotalKembalian.setForeground(java.awt.Color.BLACK);
    }
}
    
    public DefaultTableModel getPayTableModel() {
        return (DefaultTableModel) tblpay.getModel();
    }

    // Setter for txtTotalHarga1
    public void setTxtTotalHarga1(String totalPrice) {
        txtTotalHarga1.setText(totalPrice);
    }

    // Getter methods for text fields to allow external calculation
    public JTextField getTxtTotalHarga1() {
        return txtTotalHarga1;
    }

    public JTextField getTxtTunai() {
        return txtTunai;
    }

    public JTextField getTxtTotalKembalian() {
        return txtTotalKembalian;
    }
    
    private void openQRCodeForm(double total) {
    // Konversi total ke format string yang sesuai
    String totalHarga = String.format("%.0f", total);
    
    // Generate link DANA (sesuaikan dengan kebutuhan Anda)
    String danaLink = generateDanaLink(totalHarga);
    
    // Buka QRCodeFrame
    QRCodeFrame qrFrame = new QRCodeFrame(totalHarga, danaLink);
    qrFrame.setVisible(true);
    }
    
    private String generateDanaLink(String totalHarga) {
    // Format link DANA 
    // Contoh: "dana://pay?amount=50000"
    return "https://saweria.co/rar27";
    }
    
    private void openPdfFile(String fileName) {
    if (Desktop.isDesktopSupported()) {
        try {
            File myFile = new File(fileName);
            Desktop.getDesktop().open(myFile);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, 
                "Tidak dapat membuka PDF: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
    // Metode pembantu untuk membuat sel tabel
    private PdfPCell createCell(String text, Font font, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(alignment);
        return cell;
    }

    // Metode pembantu untuk membuat paragraf dengan alignment
    private Paragraph createParagraphWithAlign(String text, Font font, int alignment) {
        Paragraph paragraph = new Paragraph(text, font);
        paragraph.setAlignment(alignment);
        return paragraph;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTunai = new javax.swing.JTextField();
        btnQR = new javax.swing.JButton();
        btnStruk = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblpay = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtTotalHarga1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtTotalKembalian = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        subPanel.setBackground(new java.awt.Color(255, 255, 255));
        subPanel.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tunai :");

        btnQR.setText("QRIS");
        btnQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQRActionPerformed(evt);
            }
        });

        btnStruk.setText("Cetak Struk");
        btnStruk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStrukActionPerformed(evt);
            }
        });

        tblpay.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblpay);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Harga"));

        txtTotalHarga1.setEditable(false);
        txtTotalHarga1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTotalHarga1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTotalHarga1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Kembalian"));

        txtTotalKembalian.setEditable(false);
        txtTotalKembalian.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalKembalian.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTotalKembalian.setText("0");
        txtTotalKembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalKembalianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTotalKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTotalKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout subPanelLayout = new javax.swing.GroupLayout(subPanel);
        subPanel.setLayout(subPanelLayout);
        subPanelLayout.setHorizontalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnQR)
                        .addGap(18, 18, 18)
                        .addComponent(btnStruk))
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTunai, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        subPanelLayout.setVerticalGroup(
            subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(subPanelLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTunai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addGroup(subPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQR)
                            .addComponent(btnStruk))))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQRActionPerformed
//        // Get the total price from txtTotalHarga1
//    String totalHarga = txtTotalHarga1.getText();
//    
//    // Generate link DANA (you can modify this as needed)
//    String danaLink = generateDanaLink(totalHarga);
//    
//    // Open QRCodeFrame with total harga and dana link
//    QRCodeFrame qrFrame = new QRCodeFrame(totalHarga, danaLink);
//    qrFrame.setVisible(true);
//    
    try {
        // Ambil total harga dan bersihkan formatnya
        String totalHarga = txtTotalHarga1.getText().replaceAll("[Rp.,\\s]", "");
        
        // Generate link pembayaran
        String paymentLink = "https://saweria.co/rar27";
        
        // Buka QR Code frame
        QRCodeFrame qrFrame = new QRCodeFrame(totalHarga, paymentLink);
        qrFrame.setVisible(true);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Error membuka QR Code: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnQRActionPerformed

    private void btnStrukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStrukActionPerformed
    try {
        File pdfDir = new File("C:\\Aplikasir\\Struk");
        if (!pdfDir.exists()) {
            boolean dirCreated = pdfDir.mkdirs();
            if (!dirCreated) {
                JOptionPane.showMessageDialog(this, "Tidak dapat membuat direktori. Pastikan aplikasi memiliki akses write.",
                        "Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        if (txtTotalHarga1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Total harga tidak valid",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Buat nama file dengan timestamp
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmm");
        String fileName = "C:\\Aplikasir\\Struk\\struk" + "Tgl_"+ dateFormat.format(new Date()) + ".pdf";

        // Ukuran struk thermal biasa (58mm x 100mm)
        Document document = new Document(new Rectangle(164, 283), 10, 10, 10, 10);
        PdfWriter.getInstance(document, new FileOutputStream(fileName));
        document.open();

        // Font
        BaseFont baseFont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.EMBEDDED);
        Font titleFont = new Font(baseFont, 9, Font.BOLD);
        Font subTitleFont = new Font(baseFont, 7, Font.BOLD);
        Font normalFont = new Font(baseFont, 8, Font.NORMAL);
        Font smallFont = new Font(baseFont, 7, Font.NORMAL);

        // Nama Cafe (Sesuaikan dengan nama cafe Anda)
        Paragraph cafeTitle = new Paragraph("Kantin Abang Adek", titleFont);
        cafeTitle.setAlignment(Element.ALIGN_CENTER);
        document.add(cafeTitle);

        Paragraph address = new Paragraph("Universitas Dharma Andalas", smallFont);
        address.setAlignment(Element.ALIGN_CENTER);
        document.add(address);

        Paragraph separator = new Paragraph("==============================", normalFont);
        separator.setAlignment(Element.ALIGN_CENTER);
        document.add(separator);

        // Informasi Transaksi
        SimpleDateFormat fullDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Paragraph transactionInfo = new Paragraph(fullDateFormat.format(new Date()), smallFont);
        transactionInfo.setAlignment(Element.ALIGN_CENTER);
        document.add(transactionInfo);

        document.add(separator);

        // Buat tabel untuk item pembelian
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{2, 1, 1, 1});

        // Ambil data dari tabel
        DefaultTableModel model = (DefaultTableModel) tblpay.getModel();
        
        // Header
        table.addCell(createCell("Item", subTitleFont, Element.ALIGN_LEFT));
        table.addCell(createCell("Harga", subTitleFont, Element.ALIGN_CENTER));
        table.addCell(createCell("Qty", subTitleFont, Element.ALIGN_RIGHT));
        table.addCell(createCell("Total", subTitleFont, Element.ALIGN_RIGHT));

        // Total harga sebelum diskon
        double totalSebelumDiskon = 0;

        // Tambahkan item
        String totalHarga = txtTotalHarga1.getText().replaceAll("[Rp.,\\s]", "");
        for (int i = 0; i < model.getRowCount(); i++) {
            String namaItem = model.getValueAt(i, 0).toString();
            String qty = model.getValueAt(i, 1).toString();
            String harga = model.getValueAt(i, 2).toString();
            String total = model.getValueAt(i, 3).toString();
            String subTotal = totalHarga;

            table.addCell(createCell(namaItem, smallFont, Element.ALIGN_LEFT));
            table.addCell(createCell(harga, smallFont, Element.ALIGN_CENTER));
            table.addCell(createCell(qty, smallFont, Element.ALIGN_CENTER));
            table.addCell(createCell(total, smallFont, Element.ALIGN_RIGHT));

            // Hitung total sebelum diskon
            totalSebelumDiskon += Double.parseDouble(subTotal.replace("Rp", "").replace(".", "").trim());
        }

        document.add(table);
        document.add(separator);

        // Format mata uang
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        currencyFormat.setMaximumFractionDigits(0);
        
        // Buat tabel untuk item pembelian
        PdfPTable table1 = new PdfPTable(2);
        table1.setWidthPercentage(100);
        table1.setWidths(new float[]{2, 2});
        
        // Total, Tunai, Kembalian
        String subTotal = txtTotalHarga1.getText();
        String tunai = txtTunai.getText();
        String kembalian = txtTotalKembalian.getText();
        
        //Penambahan Rp di variabel tunai
        double dtunai = Double.parseDouble(tunai);
        DecimalFormat df = new DecimalFormat("#,###");
        String dfTunai = "Rp" + df.format(dtunai);
        
        table1.addCell(createCell("Total    : ", subTitleFont, Element.ALIGN_RIGHT));
        table1.addCell(createCell(subTotal, smallFont, Element.ALIGN_RIGHT));
        
        table1.addCell(createCell("Bayar    : ", subTitleFont, Element.ALIGN_RIGHT));
        table1.addCell(createCell(dfTunai, smallFont, Element.ALIGN_RIGHT));
        
        table1.addCell(createCell("Kembali  : ", subTitleFont, Element.ALIGN_RIGHT));
        table1.addCell(createCell(kembalian, smallFont, Element.ALIGN_RIGHT));
        
        document.add(table1);
        document.add(separator);

        // Penutup
        Paragraph footer1 = new Paragraph("Terima Kasih", subTitleFont);
        footer1.setAlignment(Element.ALIGN_CENTER);
        document.add(footer1);

        Paragraph footer2 = new Paragraph("Barang yang sudah dibeli tidak dapat", smallFont);
        footer2.setAlignment(Element.ALIGN_CENTER);
        document.add(footer2);

        Paragraph footer3 = new Paragraph("dikembalikan", smallFont);
        footer3.setAlignment(Element.ALIGN_CENTER);
        document.add(footer3);

        // Tutup dokumen
        document.close();

        // Buka PDF yang baru saja dibuat
        Desktop.getDesktop().open(new File(fileName));

        JOptionPane.showMessageDialog(this, "Struk berhasil dicetak: " + fileName, "Sukses", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this,
            "Error saat mencetak struk: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
    
    }//GEN-LAST:event_btnStrukActionPerformed

    private void txtTotalKembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalKembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalKembalianActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(qrss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(qrss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(qrss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(qrss.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new qrss().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQR;
    private javax.swing.JButton btnStruk;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel subPanel;
    private javax.swing.JTable tblpay;
    private javax.swing.JTextField txtTotalHarga1;
    private javax.swing.JTextField txtTotalKembalian;
    private javax.swing.JTextField txtTunai;
    // End of variables declaration//GEN-END:variables

}
