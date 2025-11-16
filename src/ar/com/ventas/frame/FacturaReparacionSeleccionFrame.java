package ar.com.ventas.frame;

import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;


public class FacturaReparacionSeleccionFrame extends javax.swing.JFrame {

    
    public FacturaReparacionSeleccionFrame() {
        initComponents();
        limpiarCampos();
        facturaNuevaRb.setSelected(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        facturaNuevaRb = new javax.swing.JRadioButton();
        facturaSiguienteOtroTitularRb = new javax.swing.JRadioButton();
        volverBtn = new javax.swing.JButton();
        facturaSiguienteMismoTitularRb = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SELECCIONE COMO FACTURAR CUOTAS SIGUIENTES");

        facturaNuevaRb.setText("Factura Nueva");
        facturaNuevaRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaNuevaRbActionPerformed(evt);
            }
        });

        facturaSiguienteOtroTitularRb.setText("Factura Cuota Siguiente Otro Titular");
        facturaSiguienteOtroTitularRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaSiguienteOtroTitularRbActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        facturaSiguienteMismoTitularRb.setText("Factura Cuota Siguiente Mismo Titular");
        facturaSiguienteMismoTitularRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaSiguienteMismoTitularRbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(facturaSiguienteOtroTitularRb)
                    .addComponent(facturaSiguienteMismoTitularRb)
                    .addComponent(facturaNuevaRb))
                .addContainerGap(273, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volverBtn)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(facturaNuevaRb)
                .addGap(18, 18, 18)
                .addComponent(facturaSiguienteMismoTitularRb)
                .addGap(18, 18, 18)
                .addComponent(facturaSiguienteOtroTitularRb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(volverBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void facturaNuevaRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaNuevaRbActionPerformed
        facturaNueva();

    }//GEN-LAST:event_facturaNuevaRbActionPerformed

    private void facturaSiguienteOtroTitularRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaSiguienteOtroTitularRbActionPerformed
        cuotaSiguienteConOtroTitular();
    }//GEN-LAST:event_facturaSiguienteOtroTitularRbActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void facturaSiguienteMismoTitularRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaSiguienteMismoTitularRbActionPerformed
        cuotaSiguienteReparacion();
    }//GEN-LAST:event_facturaSiguienteMismoTitularRbActionPerformed

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
            java.util.logging.Logger.getLogger(FacturaReparacionSeleccionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaReparacionSeleccionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaReparacionSeleccionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaReparacionSeleccionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturaReparacionSeleccionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton facturaNuevaRb;
    private javax.swing.JRadioButton facturaSiguienteMismoTitularRb;
    private javax.swing.JRadioButton facturaSiguienteOtroTitularRb;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void facturaNueva() {
        FacturaReparacion2Frame fr2f = new FacturaReparacion2Frame();
        fr2f.setVisible(true);
        this.dispose();
    }

    private void cuotaSiguienteConOtroTitular() {
        CuotaSiguienteReparacionesFrame csrf = new CuotaSiguienteReparacionesFrame();
        csrf.setVisible(true);
        this.dispose();
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void cuotaSiguienteReparacion() {
        CuotaSiguienteReparacionesMismoTitularFrame csrf = new CuotaSiguienteReparacionesMismoTitularFrame();
        csrf.setVisible(true);
        this.dispose();
    }

    private void limpiarCampos() {
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
    }
}
