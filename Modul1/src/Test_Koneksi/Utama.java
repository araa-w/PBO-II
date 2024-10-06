package Test_Koneksi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utama extends JFrame implements ActionListener {

    public Utama() {
        initComponents();
    }

    private void initComponents() {
        this.setTitle("Utama");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();

        jButton1.setText("Koneksi Class.ForName");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (Exception | SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        jButton2.setText("Koneksi registerDriver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton2ActionPerformed(evt);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        //Mengatur pengaturan otomatis untuk gaps
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        //Mengatur layout secara horizontal
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        this.add(panel);
        this.pack();
        this.setVisible(true);

    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ClassNotFoundException {
        try {
            //Membuat Jendela Baru
            JFrame frame1 = new JFrame("Koneksi Database");
            frame1.setSize(400, 300);
            frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            frame1.setVisible(true);

            //Membuka Koneksi Database
            if (Latihan1.DBKonek() != null){
                JLabel lblsucs = new JLabel("Koneksi Database Berhasil");
                frame1.add(lblsucs);
            } else {
                JLabel lblfail = new JLabel("Koneksi Database Gagal");
                frame1.add(lblfail);
            }
        } catch (java.sql.SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Utama.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ClassNotFoundException{
        try {
            Latihan2.DBKonek();

            //Membuat Jendela Baru
            JFrame frame2 = new JFrame("Koneksi RegisterDriver");
            frame2.setSize(300, 150);
            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            //Membuka Koneksi Database
            if (Latihan2.DBKonek() != null){
                JLabel lblsucs = new JLabel("Koneksi Database Berhasil");
                frame2.add(lblsucs);
            } else {
                JLabel lblfail = new JLabel("Koneksi Database Gagal");
                frame2.add(lblfail);
            }
            frame2.setVisible(true);

        } catch (java.sql.SQLException | ClassNotFoundException ex){
            Logger.getLogger(Utama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new Utama();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
