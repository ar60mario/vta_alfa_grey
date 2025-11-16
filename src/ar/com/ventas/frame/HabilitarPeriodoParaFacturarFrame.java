package ar.com.ventas.frame;

import ar.com.ventas.entities.Abono;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.AbonoService;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.RubroService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class HabilitarPeriodoParaFacturarFrame extends javax.swing.JFrame {

    private List<Rubro> rubros;

    public HabilitarPeriodoParaFacturarFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(6); // this.MAXIMIZED_BOTH
        llenarCombo();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        habilitarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("HABILITAR PERIODOS POR RUBROS");

        jLabel1.setText("RUBRO:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        habilitarBtn.setText("HABILITAR");
        habilitarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("VOLVER");
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(habilitarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(habilitarBtn)
                    .addComponent(volverBtn))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void habilitarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habilitarBtnActionPerformed
        int row = combo.getSelectedIndex();
        if (row > 0) {
            habilitar(row);
        }
    }//GEN-LAST:event_habilitarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(HabilitarPeriodoParaFacturarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HabilitarPeriodoParaFacturarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HabilitarPeriodoParaFacturarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HabilitarPeriodoParaFacturarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HabilitarPeriodoParaFacturarFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton habilitarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarCombo() {
        rubros = null;
        combo.removeAllItems();
        combo.addItem("");
        try {
            rubros = new RubroService().getAllRubrosActivos();
        } catch (Exception ex) {
            Logger.getLogger(HabilitarPeriodoParaFacturarFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (rubros != null && !rubros.isEmpty()) {
            for (Rubro r : rubros) {
                combo.addItem(r.getDetalle());
            }
        }
    }

    private void habilitar(int row) {
        List<Abono> abonos;
        Rubro rubro;
        try {
            rubro = rubros.get(row - 1);
            if (rubro.getId().equals(4L)) {
                abonos = new AbonoService().getAbonosActivosOrdenadoByRubroFumigacion(rubro);
            } else {
                abonos = new AbonoService().getAllAbonosActivosOrdenadoByRubro(rubro);
            }
        } catch (Exception ex) {
            Logger.getLogger(HabilitarPeriodoParaFacturarFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR 173 - ABONOS");
            return;
        }
        if (abonos != null && !abonos.isEmpty()) {
            for (Abono ab : abonos) {
                if (rubro.getId().equals(4L)) {
                    if (ab.getFrecuencia().equals(1)) {
                        ab.setPendiente(true);
                        System.out.println("HABILITADO");
                    } else {
                        Integer freq = ab.getFrecuencia();
                        Date fechaComparativa = new Date();
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(fechaComparativa);
                        Integer mesActual = cal.get(Calendar.MONTH);
                        Date fechaAbono = ab.getFechaPeriodo();
                        Calendar calAbono = Calendar.getInstance();
                        calAbono.setTime(fechaAbono);
                        Integer mesAbono = calAbono.get(Calendar.MONTH);
                        Integer diferencia = mesActual - mesAbono;
                        System.out.println(mesAbono);
                        System.out.println(mesActual);
                        System.out.println(fechaComparativa);
                        System.out.println(fechaAbono);
                        System.out.println(diferencia);
                        System.out.println(freq);
                        if (diferencia < 0) {
                            diferencia += 12;
                        }
                        if (freq.equals(diferencia)) {
                            ab.setPendiente(true);
                            System.out.println("HABILITADO");
                        }
                    }
                } else {
                    ab.setPendiente(true);
                }
//                JOptionPane.showMessageDialog(this, "VER"+ab.getConsorcio().getDomicilio().getCalle());
                try {
                    new AbonoService().updateAbono(ab);
                } catch (Exception ex) {
                    Logger.getLogger(HabilitarPeriodoParaFacturarFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        JOptionPane.showMessageDialog(this, "PROCESO REALIZADO");
        volver();
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }
}
