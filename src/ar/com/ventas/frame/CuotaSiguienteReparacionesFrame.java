package ar.com.ventas.frame;

import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.ComprobanteRenglones;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.CuentaCorrienteCliente;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ComprobanteRenglonesService;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.ConfiguracionService;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.services.CuentaCorrienteClienteService;
import ar.com.ventas.util.UtilFactura;
import ar.com.ventas.util.UtilFrame;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CuotaSiguienteReparacionesFrame extends javax.swing.JFrame {

    private List<Comprobante> comprobantes;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat df = new DecimalFormat("#0.00");

    public CuotaSiguienteReparacionesFrame() {
        initComponents();
//        setExtendedState(6); // this.MAXIMIZED_BOTH
        buscar();
        llenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        generarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("GENERAR CUOTAS SIGUIENTE EN REPARACIONES");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FECHA", "CONSORCIO", "ADMIN", "RUBRO", "CUOTA", "CUOTAS", "IMPORTE", "ORG/ASG"
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

        generarBtn.setText("GENERAR FACTURA");
        generarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarBtnActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(generarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generarBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarBtnActionPerformed
        generar();
    }//GEN-LAST:event_generarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CuotaSiguienteReparacionesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CuotaSiguienteReparacionesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CuotaSiguienteReparacionesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CuotaSiguienteReparacionesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CuotaSiguienteReparacionesFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton generarBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void generar() {
        int row = tabla.getSelectedRow();
        int rows = tabla.getSelectedRowCount();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONE UN CONSORCIO PARA FACTURAR");
            return;
        }
        if (rows > 1) {
            JOptionPane.showMessageDialog(this, "SELECCIONE UN CONSORCIO PARA FACTURAR");
            return;
        }
        if (comprobantes != null && !comprobantes.isEmpty()) {
            Comprobante co = comprobantes.get(row);
            FacturaReparacionDeFacturaFrame frdff = new FacturaReparacionDeFacturaFrame(co);
            frdff.setVisible(true);
            this.dispose();
        }
    }

    private void sacar() {
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
        int cantidadSeleccionada = tabla.getSelectedRowCount();
        int a[] = tabla.getSelectedRows();
        if (cantidadSeleccionada < 1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN CONSORCIO PARA SACER");
            return;
        }
        for (int n = cantidadSeleccionada - 1; n > -1; n--) {
            tbl.removeRow(a[n]);
            comprobantes.remove(a[n]);
        }
        llenarTabla();
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void buscar() {
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
        comprobantes = null;
        try {
            comprobantes = new ComprobanteService().getComprobantesActivosReparacionCuotaSiguiente();
        } catch (Exception ex) {
            Logger.getLogger(CuotaSiguienteReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarTabla() {
        UtilFrame.limpiarTabla(tabla);
        if (comprobantes != null && !comprobantes.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (Comprobante co : comprobantes) {
                Integer cod = co.getCodigoCliente();
                Consorcio cons = null;
                try {
                    cons = new ConsorcioService().getConsorcioByCodigo(cod);
                } catch (Exception ex) {
                    Logger.getLogger(CuotaSiguienteReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                Administrador adm = cons.getAdministrador();
                Object o[] = new Object[8];
                o[0] = sdf.format(co.getFecha());
                o[1] = co.getCalleNroPisoDtoCliente();
                o[2] = adm.getNombreAdministrador();
                o[3] = co.getRubro().getDetalle();
                o[4] = co.getCuotasPagadas();
                o[5] = co.getCantidadCuotas();
                o[6] = df.format(co.getTotal());
                if (co.getTipoEmision().equals(4)) {
                    o[7] = "N/A";
                } else {
                    if (co.getOriginal() != null) {
                        if (co.getOriginal()) {
                            o[7] = "ORIG";
                        } else {
                            o[7] = "ASIG";
                        }
                    } else {
                        o[7] = "ORIG";
                    }
                }
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
    }
}
