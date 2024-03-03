/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.CertificadosAfip;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.CertificadosAfipService;
import ar.com.ventas.services.TitularCuitService;
import ar.com.ventas.util.UtilFrame;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class CertificadosAfipFrame extends javax.swing.JFrame {

    private List<TitularCuit> titulares;

    /**
     * Creates new form CertificadosAfip
     */
    public CertificadosAfipFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(90, 180, 180));
        this.setLocationRelativeTo(null);
//        setExtendedState(6); // this.MAXIMIZED_BOTH
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        vincularBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        desvincularBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CERTIFICADOS AFIP");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CUIT", "TITULAR", "CERTIFICADO", "LLAVE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        vincularBtn.setText("Vincular");
        vincularBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vincularBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        desvincularBtn.setText("Desvincular");
        desvincularBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desvincularBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(vincularBtn)
                        .addGap(18, 18, 18)
                        .addComponent(desvincularBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vincularBtn)
                    .addComponent(volverBtn)
                    .addComponent(desvincularBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void vincularBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vincularBtnActionPerformed
        int row = tabla.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN TITLUAR PARA VINCULAR CERTIFICADO");
            return;
        }
        TitularCuit t = titulares.get(row);
        vincular(t);
    }//GEN-LAST:event_vincularBtnActionPerformed

    private void desvincularBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desvincularBtnActionPerformed
        desvincular();
    }//GEN-LAST:event_desvincularBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CertificadosAfipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CertificadosAfipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CertificadosAfipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CertificadosAfipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CertificadosAfipFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton desvincularBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JButton vincularBtn;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla() {
        UtilFrame.limpiarTabla(tabla);
        titulares = null;
        try {
            titulares = new TitularCuitService().getAllTitularDeCuitActivos();
        } catch (Exception ex) {
            Logger.getLogger(CertificadosAfipFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (titulares != null && !titulares.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (TitularCuit tc : titulares) {
                CertificadosAfip ca = null;
                try {
                    ca = new CertificadosAfipService().getCertificadoByTitular(tc);
                } catch (Exception ex) {
                    Logger.getLogger(CertificadosAfipFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                Object o[] = new Object[4];
                o[0] = tc.getCuit();
                o[1] = tc.getPersona().getApellidoNombre();
                if (ca != null) {
                    o[2] = ca.getCertificado();
                    o[3] = ca.getLlave();
                }
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void vincular(TitularCuit t) {
        VincularCertificadosFrame vcf = new VincularCertificadosFrame(t);
        vcf.setVisible(true);
        this.dispose();
    }

    private void desvincular() {
        int row = tabla.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN CERTIFICADO PARA DESVINCULAR");
            return;
        }
        TitularCuit tc = titulares.get(row);
        int a = JOptionPane.showConfirmDialog(this, "CONFIRMA DEVINCULAR CERTIFICADO PARA TITULAR:\n"
                + tc.getPersona().getApellidoNombre(), "Atención", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            CertificadosAfip ca = null;
            try {
                ca = new CertificadosAfipService().getCertificadoByTitular(tc);
            } catch (Exception ex) {
                Logger.getLogger(CertificadosAfipFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(ca != null){
                ca.setCertificado("");
                ca.setLlave("");
                try {
                    new CertificadosAfipService().updateCertificado(ca);
                } catch (Exception ex) {
                    Logger.getLogger(CertificadosAfipFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            llenarTabla();
        }
    }
}