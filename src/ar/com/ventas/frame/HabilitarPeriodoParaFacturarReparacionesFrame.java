package ar.com.ventas.frame;

import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.RubroService;
import ar.com.ventas.util.UtilFrame;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HabilitarPeriodoParaFacturarReparacionesFrame extends javax.swing.JFrame {

    private DecimalFormat df = new DecimalFormat("#0.00");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private List<Comprobante> comprobantes;
    private List<Rubro> rubros;

    public HabilitarPeriodoParaFacturarReparacionesFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(6); // this.MAXIMIZED_BOTH
//        buscarComprobantes();
        llenarCombo();
//        llenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        habilitarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        sacarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("HABILITAR PERIODO PARA CUOTA SIGUIENTE DE REPARACIONES");

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

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CONSORCIO", "FECHA", "LETRA", "NUMERO", "CUOTA", "CUOTAS", "IMPORTE", "RUBRO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(30);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(60);
            tabla.getColumnModel().getColumn(7).setPreferredWidth(150);
        }

        sacarBtn.setText("SACAR");
        sacarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sacarBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("RUBRO:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(habilitarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(sacarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(habilitarBtn)
                    .addComponent(volverBtn)
                    .addComponent(sacarBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void habilitarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habilitarBtnActionPerformed
        habilitar();
    }//GEN-LAST:event_habilitarBtnActionPerformed

    private void sacarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sacarBtnActionPerformed
        sacar();
    }//GEN-LAST:event_sacarBtnActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        int row = combo.getSelectedIndex();
        if (row > 0) {
            Rubro r = rubros.get(row - 1);
            buscarFcByRubro(r);
        }
    }//GEN-LAST:event_comboActionPerformed

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
            java.util.logging.Logger.getLogger(HabilitarPeriodoParaFacturarReparacionesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HabilitarPeriodoParaFacturarReparacionesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HabilitarPeriodoParaFacturarReparacionesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HabilitarPeriodoParaFacturarReparacionesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HabilitarPeriodoParaFacturarReparacionesFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton habilitarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sacarBtn;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla() {

        UtilFrame.limpiarTabla(tabla);
        if (comprobantes != null && !comprobantes.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (Comprobante co : comprobantes) {
                Object o[] = new Object[8];
                o[0] = co.getCalleNroPisoDtoCliente();
                o[1] = sdf.format(co.getFecha());
                o[2] = co.getLetra();
                o[3] = co.getNumero();
                o[4] = co.getCuotasPagadas();
                o[5] = co.getCantidadCuotas();
                o[6] = df.format(co.getTotal());
                o[7] = co.getRubro().getDetalle();
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

    private void habilitar() {
        if (comprobantes != null && !comprobantes.isEmpty()) {
            for (Comprobante com : comprobantes) {
                com.setPeriodoHabilitado(true);
                try {
                    new ComprobanteService().updateComprobante(com);
                } catch (Exception ex) {
                    Logger.getLogger(HabilitarPeriodoParaFacturarReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        volver();
    }

    private void sacar() {
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
        int cantidadSeleccionada = tabla.getSelectedRowCount();
        int a[] = tabla.getSelectedRows();
        if (cantidadSeleccionada < 1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN COMPROBANTE PARA SACER");
            return;
        }
        for (int n = cantidadSeleccionada - 1; n > -1; n--) {
            tbl.removeRow(a[n]);
            comprobantes.remove(a[n]);
        }
        llenarTabla();
    }

    private void buscarComprobantes(Rubro rubro) {
        comprobantes = null;
        try {
            comprobantes = new ComprobanteService().getComprobantesActivosReparacionParaRenovarByRubro(rubro);
        } catch (Exception ex) {
            Logger.getLogger(HabilitarPeriodoParaFacturarReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarCombo() {
        rubros = null;
        try {
            rubros = new RubroService().getAllRubrosReparacionesActivos();
        } catch (Exception ex) {
            Logger.getLogger(HabilitarPeriodoParaFacturarReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR 286 - RUBROS");
            return;
        }
        combo.removeAllItems();
        combo.addItem("");
        for (Rubro r : rubros) {
            combo.addItem(r.getDetalle());
        }
    }

    private void buscarFcByRubro(Rubro r) {
        buscarComprobantes(r);
        llenarTabla();
    }
}
