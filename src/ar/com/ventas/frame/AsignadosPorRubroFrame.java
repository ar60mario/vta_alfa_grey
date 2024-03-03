/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.ConsorcioMaster;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ConsorcioMasterService;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.services.RubroService;
import ar.com.ventas.util.UtilFrame;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class AsignadosPorRubroFrame extends javax.swing.JFrame {

    private List<ConsorcioMaster> cons_mstr;
    private List<Rubro> rubros;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form AsignadosPorRubroFrame
     */
    public AsignadosPorRubroFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
//        this.setLocationRelativeTo(null);
        setExtendedState(6); // this.MAXIMIZED_BOTH
        llenarCombo();
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
        combo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        volver = new javax.swing.JButton();
        asignadoRb = new javax.swing.JRadioButton();
        masterRb = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ASIGNADOS  POR RUBRO");

        jLabel1.setText("RUBRO:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO M", "CONSORCIO M", "M.FECH.PERIO.ABO", "CODIGO A", "CONSORCIO A", "A.FECH.PERIO.ABO", "ACTIVO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(300);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(60);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(20);
        }

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        asignadoRb.setText("ASIGNADO");
        asignadoRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignadoRbActionPerformed(evt);
            }
        });

        masterRb.setText("MASTER");
        masterRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterRbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(volver)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(asignadoRb)
                                .addGap(18, 18, 18)
                                .addComponent(masterRb)))
                        .addGap(0, 279, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asignadoRb)
                    .addComponent(masterRb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(volver)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        volver();
    }//GEN-LAST:event_volverActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        buscarAbonos();
    }//GEN-LAST:event_comboActionPerformed

    private void masterRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masterRbActionPerformed
        masterRb.setSelected(true);
        asignadoRb.setSelected(false);
        int row = combo.getSelectedIndex();
        if (row > 0) {

        }
    }//GEN-LAST:event_masterRbActionPerformed

    private void asignadoRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignadoRbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asignadoRbActionPerformed

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
            java.util.logging.Logger.getLogger(AsignadosPorRubroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignadosPorRubroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignadosPorRubroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignadosPorRubroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsignadosPorRubroFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton asignadoRb;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton masterRb;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void buscarAbonos() {
        int row = combo.getSelectedIndex();
        if (row > 0) {
            Rubro rubro = rubros.get(row - 1);
            llenarTabla(rubro);
        }
    }

    private void llenarCombo() {
        masterRb.setSelected(true);
        asignadoRb.setSelected(false);
        combo.removeAllItems();
        combo.addItem("");
        rubros = null;
        try {
            rubros = new RubroService().getAllRubrosActivos();
        } catch (Exception ex) {
            Logger.getLogger(AsignadosPorRubroFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (rubros != null && !rubros.isEmpty()) {
            for (Rubro r : rubros) {
                combo.addItem(r.getDetalle());
            }
        }
    }

    private void llenarTabla(Rubro rubro) {
        cons_mstr = null;
        UtilFrame.limpiarTabla(tabla);
        try {
            if (masterRb.isSelected()) {
                cons_mstr = new ConsorcioMasterService().getConsorciosByRubro(rubro, 1);
            } else {
                cons_mstr = new ConsorcioMasterService().getConsorciosByRubro(rubro, 2);
            }
        } catch (Exception ex) {
            Logger.getLogger(AsignadosPorRubroFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        if (cons_mstr != null && !cons_mstr.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (ConsorcioMaster cm : cons_mstr) {
                Consorcio cons = null;
                try {
                    cons = new ConsorcioService().getConsorcioByCodigo(cm.getMaster());
                } catch (Exception ex) {
                    Logger.getLogger(AsignadosPorRubroFrame.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                Domicilio dm = cons.getDomicilio();
                String calle = dm.getCalle() + " " + dm.getNumero();
                Domicilio dm2 = cm.getConsorcio().getDomicilio();
                String calle2 = dm2.getCalle() + " " + dm2.getNumero();
                Object o[] = new Object[7];
                o[0] = cons.getCodigo();
                o[1] = calle;
                o[2] = "";
                o[3] = cm.getConsorcio().getCodigo();
                o[4] = calle2;
                o[5] = "";
                if (cm.getActivo()) {
                    o[6] = "ACT";
                } else {
                    o[6] = "INACT";
                }
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
    }
}
