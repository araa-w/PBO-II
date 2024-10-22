package Aplikasi;

import DbManagement.MahasiswaInput;
import DbManagement.MahasiswaManager;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

public class JUtama extends javax.swing.JFrame {
    List<MahasiswaInput> Mahasiswa = new ArrayList<>();
    int currentRow = 0;

    public JUtama() {
        initComponents();
        String lookAndFeel = javax.swing.UIManager.getSystemLookAndFeelClassName();
        try {
            javax.swing.UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception e){
            e.printStackTrace();
        }

        loadData();
        binData();
        this.setTitle("Data Mahasiswa");
        this.setLocationRelativeTo(this);

    }
    private void loadData(){
        MahasiswaManager MhsMgr = new MahasiswaManager();
        Mahasiswa = MhsMgr.getMahasiswa();
        MhsMgr.closeConnection();
    }

    private void binData(){
        if (!Mahasiswa.isEmpty()){
            MahasiswaInput Mhs = Mahasiswa.get(currentRow);
            tfNobp.setText(Mhs.getNoBp());
            tfNama.setText(Mhs.getNama());
            tfTmtLahir.setText(Mhs.getTmpLahir());
            tfTgLahir.setText(Mhs.getTglLahir());
            taAlamat.setText(Mhs.getAlamat());
            tfNotelp.setText(Mhs.getPhone());
            tfAsalsek.setText(Mhs.getAsalSekolah());
        }
    }

    private void getValue(String vab){
        MahasiswaManager MhsMgr = new MahasiswaManager();
        MahasiswaInput Mhs = new MahasiswaInput();
        Mhs.setNoBp(tfNobp.getText());
        Mhs.setNama(tfNama.getText());
        Mhs.setTmpLahir(tfTmtLahir.getText());
        Mhs.setTglLahir(tfTgLahir.getText());
        Mhs.setAlamat(taAlamat.getText());
        Mhs.setPhone(tfNotelp.getText());
        Mhs.setAsalSekolah(tfNobp.getText());

        if (MhsMgr.Insert(Mhs)>0){
            loadData();
            currentRow = Mahasiswa.size()-1;
            binData();
            JOptionPane.showMessageDialog(this,"Data "+vab+" Berhasil Disimpan", "Informasi",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,"Data "+vab+" Gagal Disimpan", "Informasi",JOptionPane.INFORMATION_MESSAGE);
        }

        MhsMgr.closeConnection();
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
        tfTmtLahir.setText("ex : Padang");
        tfTmtLahir.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfTmtLahir.getText().equals("ex : Padang")){
                    tfTmtLahir.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfTmtLahir.getText().equals("")){
                    tfTmtLahir.setText("ex : Padang");
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
        tfTgLahir.setText("hh/bb/tt");
        tfTgLahir.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfTgLahir.getText().equals("hh/bb/tt")){
                    tfTgLahir.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfTgLahir.getText().equals("")){
                    tfTgLahir.setText("hh/bb/tt");
                }
            }
        });
    }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfNobp = new javax.swing.JTextField();
        tfNama = new javax.swing.JTextField();
        tfTmtLahir = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfTgLahir = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAlamat = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        tfNotelp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfAsalsek = new javax.swing.JTextField();
        btnPrev = new javax.swing.JButton();
        bntNext = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Mahasiswa"));

        tfNobp.setText("jTextField1");
        tfNobp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNobpActionPerformed(evt);
            }
        });

        tfNama.setText("jTextField2");

        tfTmtLahir.setText("jTextField3");
        tfTmtLahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTmtLahirActionPerformed(evt);
            }
        });

        jLabel1.setText("Nomor BP :");

        jLabel2.setText("Nama Lengkap :");

        jLabel3.setText("Tempat/Tgl Lahir :");

        jLabel4.setText("/");

        tfTgLahir.setText("jTextField4");
        tfTgLahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTgLahirActionPerformed(evt);
            }
        });

        jLabel5.setText("Alamat :");

        taAlamat.setColumns(20);
        taAlamat.setRows(5);
        jScrollPane1.setViewportView(taAlamat);

        jLabel6.setText("No Telp :");

        tfNotelp.setText("jTextField5");

        jLabel7.setText("Asal Sekolah :");

        tfAsalsek.setText("jTextField6");

        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                btnPrevActionPerformed(evt);
            }
        });

        bntNext.setText(">>");
        bntNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNextActionPerformed(evt);
            }
        });

        btnNew.setText("Baru");

        btnDelete.setText("Hapus");

        btnEdit.setText("Edit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfAsalsek, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addComponent(tfNotelp, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(139, 139, 139)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfNobp, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                        .addComponent(tfNama)
                                        .addComponent(tfTmtLahir))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfTgLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntNext, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNobp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfTmtLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfTgLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfNotelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfAsalsek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(bntNext)
                    .addComponent(btnNew)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit))
                .addGap(31, 31, 31))
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
    }// </editor-fold>//GEN-END:initComponents

    private void tfNobpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNobpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNobpActionPerformed

    private void tfTmtLahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTmtLahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTmtLahirActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        if (currentRow < Mahasiswa.size() -1){
            ++currentRow;
            btnNext.setEnabled(true);
        }else {
            btnPrev.setEnabled(false);
        }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void bntNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNextActionPerformed
        // TODO add your handling code here:
        if (currentRow > 0){
            --currentRow;
            btnPrev.setEnabled(true);
        } else {
            btnNext.setEnabled(false);
        }
    }//GEN-LAST:event_bntNextActionPerformed

    private void tfTgLahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTgLahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTgLahirActionPerformed

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
            java.util.logging.Logger.getLogger(JUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntNext;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnPrev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taAlamat;
    private javax.swing.JTextField tfAsalsek;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNobp;
    private javax.swing.JTextField tfNotelp;
    private javax.swing.JTextField tfTgLahir;
    private javax.swing.JTextField tfTmtLahir;
    // End of variables declaration//GEN-END:variables
}
