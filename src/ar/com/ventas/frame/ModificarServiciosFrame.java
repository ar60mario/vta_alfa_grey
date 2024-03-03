/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.Servicio;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ConsorcioService;
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
public class ModificarServiciosFrame extends javax.swing.JFrame {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private List<Consorcio> consorcios;
    private List<Servicio> servicios;

    /**
     * Creates new form ModificarServiciosFrame
     */
    public ModificarServiciosFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(this.MAXIMIZED_BOTH);
        limpiarCampos();
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
        jLabel1 = new javax.swing.JLabel();
        calleTxt = new javax.swing.JTextField();
        comboC = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        modificarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("MODIFICAR SERVICIOS POR CONSORCIO");

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar por Calle:");

        calleTxt.setText("CALLE");
        calleTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                calleTxtKeyPressed(evt);
            }
        });

        comboC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCActionPerformed(evt);
            }
        });
        comboC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboCKeyPressed(evt);
            }
        });

        jLabel2.setText("Consorcio:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FECHA", "CARACTERISTICAS", "RUBRO", "CUOTAS", "PERIODICIDAD"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        modificarBtn.setText("Modificar");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
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
                        .addComponent(modificarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(calleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboC, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 87, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(calleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(modificarBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void calleTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calleTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!calleTxt.getText().isEmpty()) {
                llenarCombo();
            }
        }
    }//GEN-LAST:event_calleTxtKeyPressed

    private void comboCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCActionPerformed
        if (evt.getModifiers() == 16) {
            int rowC = comboC.getSelectedIndex();
            if (rowC > 0) {
                llenarTabla();
            }
        }
    }//GEN-LAST:event_comboCActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        int rowT = tabla.getSelectedRow();
        if (rowT < 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONE UN SERVICIO PARA MODIFICAR");
            return;
        }
        Servicio ser = servicios.get(rowT);
        ModificarServicioFrame msf = new ModificarServicioFrame(ser);
        msf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void comboCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboCKeyPressed
        int row = comboC.getSelectedIndex();
        if (row > 0) {
            llenarTabla();
        }
    }//GEN-LAST:event_comboCKeyPressed

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
            java.util.logging.Logger.getLogger(ModificarServiciosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarServiciosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarServiciosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarServiciosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarServiciosFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField calleTxt;
    private javax.swing.JComboBox<String> comboC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void llenarCombo() {
        consorcios = null;
        String filtro = calleTxt.getText();
        comboC.removeAllItems();
        comboC.addItem("");
        try {
            consorcios = new ConsorcioService().getAllConsorciosActivosByFiltro(filtro);
        } catch (Exception ex) {
            Logger.getLogger(ModificarServiciosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (consorcios != null && !consorcios.isEmpty()) {
            for (Consorcio c : consorcios) {
                String co = c.getDomicilio().getCalle() + " "
                        + c.getDomicilio().getNumero();
                comboC.addItem(co);
            }
            comboC.addFocusListener(null);
            comboC.showPopup();
            comboC.requestFocus();
        }
    }

    private void llenarTabla() {
        UtilFrame.limpiarTabla(tabla);
        int rowC = comboC.getSelectedIndex();
        servicios = null;
        Consorcio co = consorcios.get(rowC - 1);
        try {
            servicios = new ServicioService().getAllServiciosActivosByConsorcio(co);
        } catch (Exception ex) {
            Logger.getLogger(ModificarServiciosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (servicios != null && !servicios.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (Servicio s : servicios) {
                Object o[] = new Object[5];
                if (s.getUltimoTrabajo() != null) {
                    o[0] = sdf.format(s.getUltimoTrabajo());
                } else {
                    o[0] = "SIN TRABAJO";
                }
                o[1] = s.getCaracteristicas();
                o[2] = s.getRubro().getDetalle();
                o[3] = s.getCantidadCuotas();
                o[4] = s.getPeriodicidad();
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
    }

    private void limpiarCampos() {
        calleTxt.setText("");
        comboC.removeAllItems();
        comboC.addItem("");
        UtilFrame.limpiarTabla(tabla);
        calleTxt.requestFocus();
    }
}