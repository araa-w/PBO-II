
package Aplikasi;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import DBConfig.MahasiswaManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JMain extends javax.swing.JFrame {
    
    private Connection Conn;

    public JMain() {
        initComponents();
        Conn = MahasiswaManager.getConnection();

        //Untuk menampilkan data di tabel
        getData();

        //default
        resetForm();

    }

    private void getData(){
        DefaultTableModel tableModel = (DefaultTableModel) tbData.getModel();
        tableModel.setRowCount(0);


        try {
            String cmdSql = "SELECT * FROM tabelmahasiswa;";
            PreparedStatement preStat = Conn.prepareStatement(cmdSql);
            ResultSet resultSet = preStat.executeQuery();

            //parsing tanggal
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            while (resultSet.next()){
                String noBp = resultSet.getString("NoBP");
                String nama = resultSet.getString("Nama");
                String tmpLahir = resultSet.getString("TempatLahir");
                String alamat = resultSet.getString("Alamat");
                String noTelp = resultSet.getString("NoTelp");
                String asalSekolah = resultSet.getString("AsalSekolah");

                String tgLahirStr = resultSet.getString("TanggalLahir");
                Date tgLahir = null;

                if (tgLahirStr != null){
                    tgLahir = new Date(dateFormat.parse(tgLahirStr).getTime());
                }

                Object[] rowData = {noBp, nama, tmpLahir, tgLahir, alamat, noTelp, asalSekolah};
                tableModel.addRow(rowData);
            }

            resultSet.close();
            preStat.close();

        } catch (Exception e){
            Logger.getLogger(JMain.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tfNobp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        tfTmpLahir = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfTgLahir = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taAlamat = new javax.swing.JTextArea();
        tfAsalsek = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        tfNotelp = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Mahasiswa"));

        tbData.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        tbData.setForeground(new java.awt.Color(102, 102, 102));
        tbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No Bp", "Nama", "Tempat Lahir", "Tanggal Lahir", "Alamat", "No Telp", "Asal Sekolah"
            }
        ));
        tbData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbData.setGridColor(new java.awt.Color(204, 204, 204));
        tbData.setRowHeight(30);
        tbData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbData.setShowVerticalLines(true);
        tbData.setSurrendersFocusOnKeystroke(true);
        tbData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbData);

        jLabel1.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        jLabel1.setText("No BP");

        tfNobp.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        jLabel2.setText("Nama");

        tfNama.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N

        tfTmpLahir.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        tfTmpLahir.setText("jTextField1");

        jLabel3.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        jLabel3.setText("Tempat/Tanggal Lahir");

        tfTgLahir.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        tfTgLahir.setText("jTextField1");

        jLabel4.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        jLabel4.setText("/");

        jLabel5.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        jLabel5.setText("Alamat");

        taAlamat.setColumns(20);
        taAlamat.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        taAlamat.setRows(5);
        jScrollPane2.setViewportView(taAlamat);

        tfAsalsek.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        tfAsalsek.setText("jTextField1");

        jLabel6.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        jLabel6.setText("Nomor Telepon");

        jLabel7.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        jLabel7.setText("Asal Sekolah");

        btnDelete.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnNew.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        btnNew.setText("Baru");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        btnCancel.setText("Batal");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        tfNotelp.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        tfNotelp.setText("jTextField1");

        btnExit.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        btnExit.setText("Keluar");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfAsalsek, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                    .addComponent(tfNotelp)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfNama)
                                    .addComponent(tfNobp)
                                    .addComponent(jScrollPane2)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfTmpLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfTgLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNew)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addGap(18, 18, 18)
                        .addComponent(btnExit)
                        .addGap(23, 23, 23))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNobp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfTmpLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTgLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfNotelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAsalsek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnCancel)
                    .addComponent(btnExit))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {                                       
        String noBp = tfNobp.getText();
        String nama = tfNama.getText();
        String tmpLahir = tfTmpLahir.getText();
        String tgLahir = tfTgLahir.getText();
        String alamat = taAlamat.getText();
        String noTelp = tfNotelp.getText();
        String asalSekolah = tfAsalsek.getText();

        if(noBp.isEmpty() || nama.isEmpty()){
            JOptionPane.showMessageDialog(this,"Kolom Harus Diisi", "Informas", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try{
            String cmdSql = "INSERT INTO tabelmahasiswa (NoBp, Nama, TempatLahir, TanggalLahir, Alamat, NoTelp, AsalSekolah) values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preStat = Conn.prepareStatement(cmdSql);

            preStat.setString(1, noBp);
            preStat.setString(2, nama);
            preStat.setString(3, tmpLahir);
            preStat.setString(4, tgLahir);
            preStat.setString(5, alamat);
            preStat.setString(6, noTelp);
            preStat.setString(7, asalSekolah);

            int rowInsert = preStat.executeUpdate();
            if (rowInsert > 0){
                JOptionPane.showMessageDialog(this,"Data Baru Berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                resetForm();
                getData();
            }
            
            preStat.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(JMain.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = tbData.getSelectedRow();
        if (selectedRow != -1){
            
            if (btnEdit.getText().equals("Edit")) {

                //mengaktifkan field
                tfNobp.setEditable(true);
                tfNama.setEditable(true);
                tfTmpLahir.setEditable(true);
                tfTgLahir.setEditable(true);
                taAlamat.setEditable(true);
                tfNotelp.setEditable(true);
                tfAsalsek.setEditable(true);

                //jika tombol edit di tekan
                btnEdit.setText("Simpan");
            } else if (btnEdit.getText().equals("Simpan")) {
                //mengambil data dari form input
                String noBp = tfNobp.getText();
                String nama = tfNama.getText();
                String tmpLahir = tfTmpLahir.getText();
                String tgLahir = tfTgLahir.getText();
                String alamat = taAlamat.getText();
                String noTelp = tfNotelp.getText();
                String asalSekolah = tfAsalsek.getText();

                //validasi input
                if (noBp.isEmpty() || nama.isEmpty()){
                    JOptionPane.showMessageDialog(this,"Kolom Harus Diisi","Informasi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //update data didtabase
                try {
                    String cmdSql = "UPDATE tabelmahasiswa set nama = ?, tempatlahir = ?, tanggalLahir = ?, alamat = ?, notelp = ?, asalsekolah = ? where nobp = ?;";
                    PreparedStatement preStat = Conn.prepareStatement(cmdSql);

                    preStat.setString(1, nama);
                    preStat.setString(2, tmpLahir);
                    preStat.setString(3, tgLahir);
                    preStat.setString(4, alamat);
                    preStat.setString(5, noTelp);
                    preStat.setString(6, asalSekolah);
                    preStat.setString(7, noBp);

                    //eksekusi kueri
                    int rowInsert = preStat.executeUpdate();
                    if (rowInsert > 0){
                        JOptionPane.showMessageDialog(this,"Data Update Berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                        resetForm();
                        getData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Gagal meng-update data", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    preStat.close();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(JMain.class.getName()).log(Level.SEVERE, null, e);
                }

                //setelah berhasil menyimpan, mengembalikan tombol edit
                btnEdit.setText("Edit");

                //non aktif kan kembalie field
                tfNobp.setEditable(false);
                tfNama.setEditable(false);
                tfTmpLahir.setEditable(false);
                tfTgLahir.setEditable(false);
                taAlamat.setEditable(false);
                tfNotelp.setEditable(false);
                tfAsalsek.setEditable(false);

            }
        } else { JOptionPane.showMessageDialog(this,"Pilih data terlebih dahulu dari tabel", "Informasi", JOptionPane.WARNING_MESSAGE);}
    }                                      

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = tbData.getSelectedRow();
        if (selectedRow != -1){
            if (btnDelete.getText().equals("Hapus")) {
                int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda Mau Menghapus Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    String noBp = tfNobp.getText();

                    //delete data didtabase
                    try {
                        String cmdSql = "DELETE FROM tabelmahasiswa where nobp = ?;";
                        PreparedStatement preStat = Conn.prepareStatement(cmdSql);

                        preStat.setString(1, noBp);

                        //eksekusi kueri
                        int rowInsert = preStat.executeUpdate();
                        if (rowInsert > 0){
                            JOptionPane.showMessageDialog(this,"Data Berhasil dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                            resetForm();
                            getData();
                        } else {
                            JOptionPane.showMessageDialog(this, "Gagal meng-update data", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                        preStat.close();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(JMain.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
            }
        }
    }

    private void tbDataMouseClicked(MouseEvent evt) {//GEN-FIRST:event_tbDataMouseClicked
        int row = tbData.rowAtPoint(evt.getPoint());

        //melakukan sesuatu ketika tabel di klik tanpa pengeditan
        if (row >= 0){
            btnCancel.setText("Kembali");
            
            // Ambil data dari baris yang diklik
            String noBp = tbData.getValueAt(row, 0).toString();
            String nama = tbData.getValueAt(row, 1).toString();
            String tmpLahir = tbData.getValueAt(row, 2).toString();
            String tgLahir = tbData.getValueAt(row, 3).toString();
            String alamat = tbData.getValueAt(row, 4).toString();
            String noTelp = tbData.getValueAt(row, 5).toString();
            String asalSekolah = tbData.getValueAt(row, 6).toString();

            // Mengisi form dengan data yang diklik
            tfNobp.setText(noBp);
            tfNama.setText(nama);
            tfTmpLahir.setText(tmpLahir);
            tfTgLahir.setText(tgLahir);
            taAlamat.setText(alamat);
            tfNotelp.setText(noTelp);
            tfAsalsek.setText(asalSekolah);

            //mengunci field
            tfNobp.setEditable(false);
            tfNama.setEditable(false);
            tfTmpLahir.setEditable(false);
            tfTgLahir.setEditable(false);
            taAlamat.setEditable(false);
            tfNotelp.setEditable(false);
            tfAsalsek.setEditable(false);

           
            //mengunci button
            btnNew.setEnabled(false);

        }
    }//GEN-LAST:event_tbDataMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        int respon = JOptionPane.showConfirmDialog(null,"Anda Yakin ingin keluar?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (respon == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {                                          
        resetForm();
    }

    private void resetForm() {
        setTextNoBP();
        setTextNama();
        setTextTmpLahir();
        setTextTgLahir();
        setTextAsalSek();
        setTextNoTelp();
        setTextAlamat();

        //membuka field saat tombol kembali di tekan
        tfNobp.setEditable(true);
        tfNama.setEditable(true);
        tfTmpLahir.setEditable(true);
        tfTgLahir.setEditable(true);
        taAlamat.setEditable(true);
        tfNotelp.setEditable(true);
        tfAsalsek.setEditable(true);

        //mmbuka button
        btnNew.setEnabled(true);

        btnCancel.setText("Batal");
        btnEdit.setText("Edit");

    }

    private void setTextNama(){
        tfNama.setText("Nama Lengkap");
        //Menambahkan Hint Text
        tfNama.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfNama.getText().equals("Nama Lengkap")){
                    tfNama.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfNama.getText().equals("")){
                    tfNama.setText("Nama Lengkap");
                }
            }
        });
    }
    private void setTextNoBP(){
        tfNobp.setText("Input No Bp");
        tfNobp.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(tfNobp.getText().equals("Input No Bp")){
                    tfNobp.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(tfNobp.getText().equals("")){
                    tfNobp.setText("Input No Bp");
                }
            }
        });
    }
    private void setTextTmpLahir(){
        tfTmpLahir.setText("ex : Padang");
        tfTmpLahir.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfTmpLahir.getText().equals("ex : Padang")){
                    tfTmpLahir.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfTmpLahir.getText().equals("")){
                    tfTmpLahir.setText("ex : Padang");
                }
            }
        });
    }
    private void setTextAsalSek(){
        tfAsalsek.setText("Asal Sekolah");
        tfAsalsek.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfAsalsek.getText().equals("Asal Sekolah")){
                    tfAsalsek.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfAsalsek.getText().equals("")){
                    tfAsalsek.setText("Asal Sekolah");
                }
            }
        });
    }
    private void setTextNoTelp(){
        tfNotelp.setText("08xxxxxxxxxx");
        tfNotelp.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfNotelp.getText().equals("08xxxxxxxxxx")){
                    tfNotelp.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfNotelp.getText().equals("")){
                    tfNotelp.setText("08xxxxxxxxxx");
                }
            }
        });
    }
    private void setTextTgLahir(){
        tfTgLahir.setText("yyyy-mm-dd");
        tfTgLahir.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfTgLahir.getText().equals("yyyy-mm-dd")){
                    tfTgLahir.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfTgLahir.getText().equals("")){
                    tfTgLahir.setText("yyyy-mm-dd");
                }
            }
        });
    }
    private void setTextAlamat(){
        taAlamat.setText(".....");
        taAlamat.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (taAlamat.getText().equals(".....")){
                    taAlamat.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (taAlamat.getText().equals("")){
                    taAlamat.setText(".....");
                }
            }
        });
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taAlamat;
    private javax.swing.JTable tbData;
    private javax.swing.JTextField tfAsalsek;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNobp;
    private javax.swing.JTextField tfNotelp;
    private javax.swing.JTextField tfTgLahir;
    private javax.swing.JTextField tfTmpLahir;
    // End of variables declaration//GEN-END:variables
}
