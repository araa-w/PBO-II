package App;

import AppDB.Mahasiswa;
import AppDB.MahasiswaManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

public class JUtama extends javax.swing.JFrame {
    List<Mahasiswa> Mahasiswa = new ArrayList<Mahasiswa>();
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
            Mahasiswa Mhs = Mahasiswa.get(currentRow);
            tfNobp.setText(Mhs.getNoBp());
            tfNama.setText(Mhs.getNama());
            tfTmpLahir.setText(Mhs.getTmpLahir());
            tfTglLahir.setText(Mhs.getTglLahir());
            taAlamat.setText(Mhs.getAlamat());
            tfNotelp.setText(Mhs.getPhone());
            tfAsalsek.setText(Mhs.getAsalSekolah());
        }
    }

    private void getValue(){
        MahasiswaManager MhsMgr = new MahasiswaManager();
        Mahasiswa Mhs = new Mahasiswa();
        Mhs.setNoBp(tfNobp.getText());
        Mhs.setNama(tfNama.getText());
        Mhs.setTmpLahir(tfTmpLahir.getText());
        Mhs.setTglLahir(tfTglLahir.getText());
        Mhs.setAlamat(taAlamat.getText());
        Mhs.setPhone(tfNotelp.getText());
        Mhs.setAsalSekolah(tfNobp.getText());
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
        tfTglLahir.setText("hh/bb/tt");
        tfTglLahir.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfTglLahir.getText().equals("hh/bb/tt")){
                    tfTglLahir.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfTglLahir.getText().equals("")){
                    tfTglLahir.setText("hh/bb/tt");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAlamat = new javax.swing.JTextArea();
        tfNobp = new javax.swing.JTextField();
        tfNama = new javax.swing.JTextField();
        tfTmpLahir = new javax.swing.JTextField();
        tfTglLahir = new javax.swing.JTextField();
        tfNotelp = new javax.swing.JTextField();
        tfAsalsek = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Mahasiswa"));
        jPanel1.setFocusable(false);

        jLabel1.setText("No BP");

        jLabel2.setText("Nama");

        jLabel3.setText("Tempat / Tanggal Lahir");

        jLabel4.setText("Alamat");

        jLabel5.setText("No Telepon");

        jLabel6.setText("Asal Sekolah");

        taAlamat.setColumns(20);
        taAlamat.setRows(10);
        jScrollPane1.setViewportView(taAlamat);

        tfNobp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNobpActionPerformed(evt);
            }
        });

        tfTmpLahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTmpLahirActionPerformed(evt);
            }
        });

        btnNew.setText("Baru");
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MahasiswaManager MhsMgr = new MahasiswaManager();
                Mahasiswa Mhs = new Mahasiswa();
                if (btnNew.getText().equals("Baru")){
                    //Logika untuk memulai input baru
                    tfNobp.requestFocus();
                    setTextNoBP();
                    setTextNama();
                    setTextTmpLahir();
                    setTextTgLahir();
                    setTextNoTelp();
                    setTextAsalSek();

                    btnNew.setText("Simpan");
                    btnDelete.setText("Hapus");
                    btnDelete.setEnabled(true);
                    btnEdit.setEnabled(false);
                    btnNext.setEnabled(false);
                    btnPrev.setEnabled(false);
                } else if (btnNew.getText().equals("Simpan")) {

                    //Logika untuk menyimpan data
                    if (!tfNobp.getText().equals("") && !tfNama.getText().equals("")){
                        Mhs.setNoBp(tfNobp.getText());
                        Mhs.setNama(tfNama.getText());
                        Mhs.setTmpLahir(tfTmpLahir.getText());
                        Mhs.setTglLahir(tfTglLahir.getText());
                        Mhs.setAlamat(taAlamat.getText());
                        Mhs.setPhone(tfNotelp.getText());
                        Mhs.setAsalSekolah(tfAsalsek.getText());

                        int result = MhsMgr.Insert(Mhs);
                        System.out.println("Return value from insert : " + result);

                        if (result > 0){
                            JOptionPane.showMessageDialog(null,"Data Baru Berhasil Disimpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,"Data Baru Gagal Disimpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
                        }
                        resetForm();
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Harap isi semua data yang diperlukan","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEditActionPerformed(evt);
                resetForm();
            }
        });

        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnDelete.getText().equals("Hapuss")){
                    int dialogResult = JOptionPane.showConfirmDialog(null,"Apakah Anda Yakin Menghapus Data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                    if (dialogResult == JOptionPane.YES_OPTION){
                        MahasiswaManager MhsMgr = new MahasiswaManager();
                        Mahasiswa Mhs = Mahasiswa.get(currentRow);
                        if (MhsMgr.Delete(Mhs)>0){
                            loadData();
                            currentRow = currentRow - 1;
                            binData();
                            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus!","Informasi",JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,"Data Gagal Dihapus!","Informasi",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else if (btnDelete.getText().equals("Batal")){
                    loadData();
                    binData();
                    btnNew.setText("Baru");
                    btnEdit.setText("Ubah");
                    btnDelete.setText("Hapus");

                    btnEdit.setEnabled(true);
                    btnNext.setEnabled(true);
                    btnPrev.setEnabled(true);
                }
                resetForm();
            }
        });


        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (currentRow < Mahasiswa.size() -1){
                    ++currentRow;
                    btnNext.setEnabled(true);
                }else {
                    btnPrev.setEnabled(false);
                }
                btnPrevActionPerformed(evt);
                resetForm();
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (currentRow > 0){
                    --currentRow;
                    btnPrev.setEnabled(true);
                } else {
                    btnNext.setEnabled(false);
                }
                btnNextActionPerformed(evt);
                resetForm();
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfNotelp, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfAsalsek, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(tfTmpLahir)
                            .addGap(18, 18, 18)
                            .addComponent(tfTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfNobp, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfNama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNobp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfTmpLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfNotelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfAsalsek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnPrev)
                    .addComponent(btnNext))
                .addGap(17, 17, 17))
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

    private void resetForm() {
        setTextNoBP();
        setTextNama();
        setTextTmpLahir();
        setTextTgLahir();
        setTextAsalSek();
        setTextNoTelp();
        setTextAlamat();
    }

    private void tfNobpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNobpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNobpActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (btnEdit.getText().equals("Ubah")){
            //Atur input data
            tfNobp.requestFocus();
            setTextNoBP();
            setTextNama();
            setTextTmpLahir();
            setTextTgLahir();
            setTextNoTelp();
            setTextAsalSek();

            btnEdit.setText("Simpan");
            btnDelete.setText("Batal");
            btnNew.setEnabled(false);
            btnNext.setEnabled(false);
            btnPrev.setEnabled(false);
        } else {
            getValue();

            btnEdit.setText("Ubah");
            btnDelete.setText("Ubah");
            btnNew.setEnabled(true);
            btnNext.setEnabled(true);
            btnPrev.setEnabled(true);
        }
    }

    private void tfTmpLahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTmpLahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTmpLahirActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed

    /**
     * @param args the command line arguments
     */

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfTglLahir;
    private JTextArea taAlamat;
    private JTextField tfAsalsek;
    private JTextField tfTmpLahir;
    private JTextField tfNotelp;
    private JTextField tfNobp;
    private JButton btnPrev;
    private JButton btnNew;
    private JButton btnEdit;
    private JButton btnNext;
    private JButton btnDelete;



    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JUtama().setVisible(true);
            }
        });
    }
}
