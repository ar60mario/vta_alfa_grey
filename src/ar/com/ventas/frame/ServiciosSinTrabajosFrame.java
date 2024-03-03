/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.Servicio;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ServicioService;
import ar.com.ventas.util.UtilFrame;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class ServiciosSinTrabajosFrame extends javax.swing.JFrame {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private List<Servicio> servicios;

    /**
     * Creates new form ServiciosSinTrabajosFrame
     */
    public ServiciosSinTrabajosFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(this.MAXIMIZED_BOTH);
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

        volverBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        crearTrabajoBtn = new javax.swing.JButton();
        marcarComoInactivoBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SERVICIOS SIN TRABAJOS RELACIONADOS");

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Rubro", "Consorcio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        crearTrabajoBtn.setText("Crear Trabajo");
        crearTrabajoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearTrabajoBtnActionPerformed(evt);
            }
        });

        marcarComoInactivoBtn.setText("Marcar como Inactivo");
        marcarComoInactivoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcarComoInactivoBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(crearTrabajoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(marcarComoInactivoBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(crearTrabajoBtn)
                    .addComponent(marcarComoInactivoBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void marcarComoInactivoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcarComoInactivoBtnActionPerformed
        marcarInactivo();
    }//GEN-LAST:event_marcarComoInactivoBtnActionPerformed

    private void crearTrabajoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearTrabajoBtnActionPerformed
        crearTrabajo();
    }//GEN-LAST:event_crearTrabajoBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ServiciosSinTrabajosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServiciosSinTrabajosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServiciosSinTrabajosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServiciosSinTrabajosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServiciosSinTrabajosFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearTrabajoBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton marcarComoInactivoBtn;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla() {
        UtilFrame.limpiarTabla(tabla);
        servicios = null;
        try {
            servicios = new ServicioService().getAllServiciosActivosSinTrabajo();
        } catch (Exception ex) {
            Logger.getLogger(ServiciosSinTrabajosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (servicios != null && !servicios.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (Servicio s : servicios) {
                Object o[] = new Object[3];
                o[0] = sdf.format(s.getFecha());
                o[1] = s.getRubro().getDetalle();
                Domicilio dm = s.getConsorcio().getDomicilio();
                o[2] = dm.getCalle() + " " + dm.getNumero();
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

    private void marcarInactivo() {
        int row = tabla.getSelectedRow();
        Servicio servicio = servicios.get(row);
        servicio.setActivo(false);
        int a = JOptionPane.showConfirmDialog(this, "Texto a confirmar", "Atención", JOptionPane.YES_NO_OPTION);
        if (a==0){
            try {
                new ServicioService().updateServicio(servicio);
                
            } catch (Exception ex) {
                Logger.getLogger(ServiciosSinTrabajosFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro. 225 MARCANDO SERVICIO COMO INACTIVO");
                return;
            }
            JOptionPane.showMessageDialog(this, "SERVICIO MARCADO COMO INACTIVO");
        }
        llenarTabla();
    }

    private void crearTrabajo() {
        
    }
}
