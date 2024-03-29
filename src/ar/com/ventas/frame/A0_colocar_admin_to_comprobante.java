/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.ConsorcioMaster;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.ConsorcioMasterService;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.services.RubroService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class A0_colocar_admin_to_comprobante extends javax.swing.JFrame {

    private List<Rubro> rubros;

    /**
     * Creates new form A0_colocar_admin_to_comprobante
     */
    public A0_colocar_admin_to_comprobante() {
        initComponents();
        llenarRubros();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        goBtn = new javax.swing.JButton();
        go_2_Btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        goBtn.setText("go");
        goBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBtnActionPerformed(evt);
            }
        });

        go_2_Btn.setText("go 2");
        go_2_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_2_BtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Rubros: ");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goBtn)
                    .addComponent(go_2_Btn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(343, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(goBtn)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(go_2_Btn)
                .addContainerGap(371, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBtnActionPerformed
        go();
    }//GEN-LAST:event_goBtnActionPerformed

    private void go_2_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_2_BtnActionPerformed
        go2();
    }//GEN-LAST:event_go_2_BtnActionPerformed

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
            java.util.logging.Logger.getLogger(A0_colocar_admin_to_comprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A0_colocar_admin_to_comprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A0_colocar_admin_to_comprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A0_colocar_admin_to_comprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A0_colocar_admin_to_comprobante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton goBtn;
    private javax.swing.JButton go_2_Btn;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void go() {
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = new ComprobanteService().getComprobantesActivos();
        } catch (Exception ex) {
            Logger.getLogger(A0_colocar_admin_to_comprobante.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR-114");
            return;
        }
        if (comprobantes != null && !comprobantes.isEmpty()) {
            for (Comprobante co : comprobantes) {
                Integer codigo = co.getCodigoCliente();
                Consorcio cons = null;
                Administrador adm;
                try {
                    cons = new ConsorcioService().getConsorcioByCodigo(codigo);
                } catch (Exception ex) {
                    Logger.getLogger(A0_colocar_admin_to_comprobante.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "ERROR-127");
                    return;
                }
                if (cons != null) {
                    adm = cons.getAdministrador();
                    co.setId_administrador(adm.getId());
                    try {
                        new ComprobanteService().updateComprobante(co);
                    } catch (Exception ex) {
                        Logger.getLogger(A0_colocar_admin_to_comprobante.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println(co.getId());
                        JOptionPane.showMessageDialog(this, "ERROR-139");
                        return;
                    }
                }
            }
        }
        System.exit(0);
    }

    private void go2() {
        int row = combo.getSelectedIndex();
        if (row < 1) {
            JOptionPane.showMessageDialog(this, "SELECCIONE RUBRO");
            combo.requestFocus();
            return;
        }
        Rubro ru = rubros.get(row - 1);
        List<Comprobante> comprobantes;
        try {
            comprobantes = new ComprobanteService().getComprobantesActivos();
        } catch (Exception ex) {
            Logger.getLogger(A0_colocar_admin_to_comprobante.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR-173");
            return;
        }
        if (comprobantes != null && !comprobantes.isEmpty()) {
            for (Comprobante co : comprobantes) {
                if (co.getOriginal() == null) {
                    Consorcio cons = null;
                    Integer codigo = co.getCodigoCliente();
                    try {
                        cons = new ConsorcioService().getConsorcioByCodigo(codigo);
                    } catch (Exception ex) {
                        Logger.getLogger(A0_colocar_admin_to_comprobante.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "ERROR-214");
                        return;
                    }
                    ConsorcioMaster cm = null;
                    try {
                        cm = new ConsorcioMasterService().getConsorcioMasterParaElim(cons, ru);
                    } catch (Exception ex) {
                        Logger.getLogger(A0_colocar_admin_to_comprobante.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "ERROR-223");
                        return;
                    }
                    if (cm != null) {
                        Integer cons_master = cm.getMaster();
                        co.setOriginal(false);
                        co.setId_original(cons_master.longValue());
                        try {
                            new ComprobanteService().updateComprobante(co);
                        } catch (Exception ex) {
                            Logger.getLogger(A0_colocar_admin_to_comprobante.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, "ERROR-234");
                            return;
                        }

                    } else {
                        co.setOriginal(true);
                        co.setId_original(0L);
                        try {
                            new ComprobanteService().updateComprobante(co);
                        } catch (Exception ex) {
                            Logger.getLogger(A0_colocar_admin_to_comprobante.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, "ERROR-245");
                            return;
                        }
                    }
                }
            }
        }
    }
    

    private void llenarRubros() {
        rubros = null;
        combo.removeAllItems();
        combo.addItem("");
        try {
            rubros = new RubroService().getAllRubrosActivos();
        } catch (Exception ex) {
            Logger.getLogger(A0_colocar_admin_to_comprobante.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR-198");
            return;
        }
        if (rubros != null && !rubros.isEmpty()) {
            for (Rubro ru : rubros) {
                combo.addItem(ru.getDetalle());
            }
        }
    }
}
