/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class BackupFrame extends javax.swing.JFrame {

    /**
     * Creates new form BackupFrame
     */
    public BackupFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(this.MAXIMIZED_BOTH);
        habilitarChk.setSelected(false);
        procesarBtn.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        procesarBtn = new javax.swing.JButton();
        habilitarChk = new javax.swing.JCheckBox();
        volverBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("BACKUP DEL SISTEMA");

        jLabel1.setText("Realizar un Backup");

        procesarBtn.setText("Procesar");
        procesarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarBtnActionPerformed(evt);
            }
        });

        habilitarChk.setText("Habilitar");
        habilitarChk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarChkActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(habilitarChk)
                    .addComponent(procesarBtn))
                .addContainerGap(543, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volverBtn)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(habilitarChk)
                .addGap(18, 18, 18)
                .addComponent(procesarBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                .addComponent(volverBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void habilitarChkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habilitarChkActionPerformed
        if (habilitarChk.isSelected()) {
            habilitarChk.setSelected(true);
            procesarBtn.setEnabled(true);
        } else {
            habilitarChk.setSelected(false);
            procesarBtn.setEnabled(false);
        }
    }//GEN-LAST:event_habilitarChkActionPerformed

    private void procesarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesarBtnActionPerformed
        int opc = JOptionPane.showConfirmDialog(null,
                "Quiere realizar un Backup AHORA?",
                "Atencion", JOptionPane.YES_NO_OPTION);
        if (opc == 0) {
            backup();
        }
    }//GEN-LAST:event_procesarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

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
            java.util.logging.Logger.getLogger(BackupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BackupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BackupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BackupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BackupFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox habilitarChk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton procesarBtn;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void backup() {
        boolean status = false;
        try {
            Process p = null;
            Date date = new Date();
            String filepath = "C:\\backup\\bkp_db.sql";
            String batchCommand = "";
            batchCommand = "c:\\ventas\\mysqldump.exe" + " -h " + "localhost" + " --port " + "3306" + " -u " + "root" + " --password=root ventas_emtk" + " -r " + filepath;
            Runtime runtime = Runtime.getRuntime();
            p = runtime.exec(batchCommand);
            int processComplete = p.waitFor();
            if (processComplete == 0) {
                status = true;
                JOptionPane.showMessageDialog(this,"Backup creado correctamente DB\n" + "EMITANK en BACKUP");
            } else {
                status = false;
                JOptionPane.showMessageDialog(this,"Error creando Backup DB " + "EMITANK en BACKUP");
            }

        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(this, ioe.getCause());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getCause());
        }
        if (!status) {
        JOptionPane.showMessageDialog(this, "Error generando Backup");
        }
        volver();
    }

    private void volver() {
        MainFrame wmp = new MainFrame();
        wmp.setVisible(true);
        this.dispose();
    }
}
