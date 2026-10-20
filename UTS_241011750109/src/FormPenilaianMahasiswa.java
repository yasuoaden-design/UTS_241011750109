/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ALI
 */
public class FormPenilaianMahasiswa extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormPenilaianMahasiswa.class.getName());

    /**
     * Creates new form FormPenilaianMahasiswa
     */
    public FormPenilaianMahasiswa() {
        initComponents();
        updateSks();
        txtSks.setEditable(false);
        txtNilaiAkhir.setEditable(false);
        txtGrade.setEditable(false);
    }

    private void updateSks() {
        String mataKuliah
                = String.valueOf(cmbMatakuliah.getSelectedItem());

        int sks;

        switch (mataKuliah) {
            case "Rekayasa web":
                sks = 2;
                break;

            case "Java 2":
            case "Basis Data":
            case "Jaringan Komputer":
            case "Pemrograman Mobile":
                sks = 3;
                break;

            default:
                sks = 2;
        }

        txtSks.setText(String.valueOf(sks));
    }

    private boolean hitungNilai() {
        try {
            // Validasi identitas
            if (txtNim.getText().trim().isEmpty()
                    || txtNama.getText().trim().isEmpty()) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "NIM dan Nama wajib diisi!"
                );
                return false;
            }

            if (!rbLakilaki.isSelected()
                    && !rbPerempuan.isSelected()) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Pilih jenis kelamin terlebih dahulu!"
                );
                return false;
            }

            int sks = Integer.parseInt(txtSks.getText().trim());
            int presensi = Integer.parseInt(
                    txtPresensi.getText().trim());

            double tugas = Double.parseDouble(
                    txtTugas.getText().trim());

            double uts = Double.parseDouble(
                    txtUts.getText().trim());

            double uas = Double.parseDouble(
                    txtUas.getText().trim());

            // Jumlah pertemuan berdasarkan SKS
            int jumlahPertemuan;

            if (sks == 3) {
                jumlahPertemuan = 21;
            } else if (sks == 2) {
                jumlahPertemuan = 14;
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                        this, "SKS harus 2 atau 3!"
                );
                return false;
            }

            // Validasi presensi
            if (presensi < 0 || presensi > jumlahPertemuan) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Presensi melebihi batas!\n"
                        + "Mata kuliah ini " + sks + " SKS.\n"
                        + "Maksimal presensi: " + jumlahPertemuan
                        + " pertemuan.",
                        "Peringatan Presensi",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );
                return false;
            }

            // Validasi nilai akademik
            if (tugas < 0 || tugas > 100
                    || uts < 0 || uts > 100
                    || uas < 0 || uas > 100) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Nilai Tugas, UTS, dan UAS harus 0–100!"
                );
                return false;
            }

            // Menghitung bobot nilai
            double persentasePresensi
                    = (double) presensi / jumlahPertemuan * 100;

            double nilaiAbsensi
                    = persentasePresensi * 0.10;

            double nilaiTugas = tugas * 0.20;
            double nilaiUts = uts * 0.30;
            double nilaiUas = uas * 0.40;

            double nilaiAkhir
                    = nilaiAbsensi + nilaiTugas + nilaiUts + nilaiUas;

            // Menentukan grade berdasarkan nilai akhir
            String grade;

            if (nilaiAkhir > 80) {
                grade = "A";
            } else if (nilaiAkhir > 60) {
                grade = "B";
            } else if (nilaiAkhir > 40) {
                grade = "C";
            } else {
                grade = "D";
            }

            // Aturan khusus absensi dari soal UTS
            if (persentasePresensi < 50) {
                grade = "E";
            } else if (persentasePresensi < 75) {
                grade = "D";
            }

            // Menampilkan hasil
            txtNilaiAkhir.setText(
                    String.format(
                            java.util.Locale.US,
                            "%.2f",
                            nilaiAkhir
                    )
            );

            txtGrade.setText(grade);

            return true;

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Presensi, Tugas, UTS, dan UAS harus berupa angka!"
            );
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNim = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        rbLakilaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        txtSks = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPresensi = new javax.swing.JTextField();
        txtTugas = new javax.swing.JTextField();
        txtUts = new javax.swing.JTextField();
        txtUas = new javax.swing.JTextField();
        txtNilaiAkhir = new javax.swing.JTextField();
        txtGrade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        cmbMatakuliah = new javax.swing.JComboBox<>();
        btnAddData = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnProses = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("FORM PENILAIIAN MAHASIWA");

        jLabel2.setText("Nim");

        jLabel3.setText("Nama");

        jLabel4.setText("Jenis kelamin");

        jLabel5.setText("Mata Kuliah");

        jLabel6.setText("Sks");

        buttonGroup1.add(rbLakilaki);
        rbLakilaki.setText("laki-laki");
        rbLakilaki.addActionListener(this::rbLakilakiActionPerformed);

        buttonGroup1.add(rbPerempuan);
        rbPerempuan.setText("perempuan");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Bobot Penilaian."));
        jPanel1.setToolTipText("");

        jLabel7.setText("PRESENSI");

        jLabel8.setText("TUGAS");

        jLabel9.setText("UTS");

        jLabel10.setText("UAS");

        jLabel11.setText("NILAI AKHIR");

        jLabel12.setText("GRADE");

        txtTugas.addActionListener(this::txtTugasActionPerformed);

        txtUts.addActionListener(this::txtUtsActionPerformed);

        txtNilaiAkhir.addActionListener(this::txtNilaiAkhirActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNilaiAkhir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTugas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPresensi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGrade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPresensi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtUts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtUas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNilaiAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        txtLog.setColumns(20);
        txtLog.setRows(5);
        jScrollPane1.setViewportView(txtLog);

        cmbMatakuliah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rekayasa web", "Java 2", "Basis data", "Jaringan komputer", "Pemrograman mobile" }));
        cmbMatakuliah.addActionListener(this::cmbMatakuliahActionPerformed);

        btnAddData.setText("Add Data");
        btnAddData.addActionListener(this::btnAddDataActionPerformed);

        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);

        btnProses.setText("Proses");
        btnProses.addActionListener(this::btnProsesActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNim)
                                    .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtSks, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(rbLakilaki, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(rbPerempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(cmbMatakuliah, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnAddData)
                                    .addGap(31, 31, 31)
                                    .addComponent(btnClear))
                                .addComponent(btnProses))
                            .addGap(33, 33, 33)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbLakilaki)
                                .addComponent(rbPerempuan)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbMatakuliah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddData)
                            .addComponent(btnClear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProses))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbLakilakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLakilakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbLakilakiActionPerformed

    private void txtNilaiAkhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNilaiAkhirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNilaiAkhirActionPerformed

    private void txtTugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTugasActionPerformed

    private void txtUtsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUtsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUtsActionPerformed

    private void btnAddDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDataActionPerformed
        if (!hitungNilai()) {
            return;
        }

        String jk = rbLakilaki.isSelected() ? "LAKI-LAKI" : "PEREMPUAN";

        txtLog.append(
                txtNim.getText().trim()
                + " | " + txtNama.getText().trim()
                + " | " + jk
                + " | Matkul : " + cmbMatakuliah.getSelectedItem()
                + " | SKS : " + txtSks.getText()
                + " | Absensi : " + txtPresensi.getText().trim()
                + " | Tugas : " + txtTugas.getText().trim()
                + " | UTS : " + txtUts.getText().trim()
                + " | UAS : " + txtUas.getText().trim()
                + " | Nilai Akhir : " + txtNilaiAkhir.getText()
                + " | Grade : " + txtGrade.getText()
                + "\n"
        );
    }//GEN-LAST:event_btnAddDataActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtNim.setText("");
        txtNama.setText("");

        buttonGroup1.clearSelection();

        cmbMatakuliah.setSelectedIndex(0);
        updateSks();

        txtPresensi.setText("");
        txtTugas.setText("");
        txtUts.setText("");
        txtUas.setText("");
        txtNilaiAkhir.setText("");
        txtGrade.setText("");

        txtNim.requestFocus();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        hitungNilai();
    }//GEN-LAST:event_btnProsesActionPerformed

    private void cmbMatakuliahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMatakuliahActionPerformed
        updateSks();
    }//GEN-LAST:event_cmbMatakuliahActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormPenilaianMahasiswa().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddData;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnProses;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbMatakuliah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbLakilaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTextField txtGrade;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNilaiAkhir;
    private javax.swing.JTextField txtNim;
    private javax.swing.JTextField txtPresensi;
    private javax.swing.JTextField txtSks;
    private javax.swing.JTextField txtTugas;
    private javax.swing.JTextField txtUas;
    private javax.swing.JTextField txtUts;
    // End of variables declaration//GEN-END:variables
}
