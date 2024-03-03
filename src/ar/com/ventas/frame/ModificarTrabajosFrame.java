/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.RenglonTrabajo;
import ar.com.ventas.entities.Trabajo;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.services.RenglonTrabajoService;
import ar.com.ventas.services.TrabajoService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class ModificarTrabajosFrame extends javax.swing.JFrame {

    private List<Consorcio> consorcios;
    private List<Trabajo> trabajos = null;

    /**
     * Creates new form ModificarTrabajoFrame
     */
    public ModificarTrabajosFrame() {
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
        setTitle("MODIFICAR TRABAJO");

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar x Calle:");

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

        jLabel2.setText("Consorcio:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Trabajo"
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
                        .addGap(0, 737, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(calleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboC, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificarBtn))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(calleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modificarBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(volverBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void calleTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calleTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            llenarComboC();
        }
    }//GEN-LAST:event_calleTxtKeyPressed

    private void comboCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCActionPerformed
        cargarTrabajo();
    }//GEN-LAST:event_comboCActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        int row = tabla.getSelectedRow();
        if(row < 0){
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN TRABAJO PARA MODIFICAR");
            return;
        }
        modificar(row);
    }//GEN-LAST:event_modificarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarTrabajosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarTrabajosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarTrabajosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarTrabajosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarTrabajosFrame().setVisible(true);
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

    private void limpiarCampos() {
        calleTxt.setText("");
        comboC.removeAllItems();
        comboC.addItem("");
        calleTxt.requestFocus();
    }

    private void llenarComboC() {
        comboC.removeAllItems();
        comboC.addItem("");
        consorcios = null;
        String filtro = calleTxt.getText();
        int largo = filtro.length();
        if (largo > 0) {
            try {
                consorcios = new ConsorcioService().getAllConsorciosActivosByFiltro(filtro);
            } catch (Exception ex) {
                Logger.getLogger(ModificarTrabajosFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (consorcios != null && !consorcios.isEmpty()) {
                for (Consorcio c : consorcios) {
                    comboC.addItem(c.getNombre() + " "
                            + c.getDomicilio().getCalle() + " "
                            + c.getDomicilio().getNumero());
                }
                comboC.addFocusListener(null);
                comboC.showPopup();
                comboC.requestFocus();
            }
        }
    }

    private void cargarTrabajo() {
        int row = comboC.getSelectedIndex();
        if (row > 0) {
            Consorcio consorcio = consorcios.get(row -1);
            
            try {
                trabajos = new TrabajoService().getTrabajosByConsorcioActivos(consorcio);
            } catch (Exception ex) {
                Logger.getLogger(ModificarTrabajosFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(trabajos != null && !trabajos.isEmpty()){
                limpiarTabla();
                DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
                for (Trabajo t:trabajos){
                    Object o[]= new Object[2];
                    o[0]=t.getFecha();
                    o[1]=t.getServicio().getRubro().getDetalle();
                    tbl.addRow(o);
                }
                tabla.setModel(tbl);
            }
        }
    }

    private void limpiarTabla() {
        int rows = tabla.getRowCount();
        if (rows > 0) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (int i = 0; i < rows; i++) {
                tbl.removeRow(0);
            }
            tabla.setModel(tbl);
        }
    }

    private void volver() {
        MainFrame asf = new MainFrame();
        asf.setVisible(true);
        this.dispose();
    }

    private void modificar(Integer row) {
        Trabajo trabajo = trabajos.get(row);
        List<RenglonTrabajo> renglones = null;
        try {
            renglones = new RenglonTrabajoService().getAllRenglonTrabajoActivos();
        } catch (Exception ex) {
            Logger.getLogger(ModificarTrabajosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ActualizarTrabajoFrame atf = new ActualizarTrabajoFrame(trabajo, renglones);
        atf.setVisible(true);
        this.dispose();
    }
}