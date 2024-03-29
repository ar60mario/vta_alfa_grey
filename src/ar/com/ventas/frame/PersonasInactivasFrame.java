/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Persona;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.PersonaService;
import ar.com.ventas.services.TitularCuitService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class PersonasInactivasFrame extends javax.swing.JFrame {

    private List<Persona> personas;

    /**
     * Creates new form AbmPersonaFrame
     */
    public PersonasInactivasFrame() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        activarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PERSONAS INACTIVAS");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "APELLIDO NOMBRE", "CUIL", "CLAVE FISCAL", "NOMBRE FANTASIA", "TELEFONO", "TIT CUIT", "EMPLEADO", "ACTIVO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        activarBtn.setText("Activar");
        activarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(activarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activarBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void activarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activarBtnActionPerformed
        activar();
    }//GEN-LAST:event_activarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(PersonasInactivasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonasInactivasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonasInactivasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonasInactivasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonasInactivasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton activarBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla() {
        limpiarTabla();
        personas = null;
        try {
            personas = new PersonaService().getAllPersonasInactivas();
        } catch (Exception ex) {
            Logger.getLogger(PersonasInactivasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (personas != null && !personas.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            String nf = "";
            for (Persona p : personas) {
                Object o[] = new Object[8];
                o[0] = p.getApellidoNombre();
                o[1] = p.getCuil();
                o[2] = p.getClaveFiscal();
                if (p.getEsTitularCuit()) {
                    TitularCuit tc = null;
                    try {
                        tc = new TitularCuitService().getTitularDeCuitActivoByPersona(p);
                    } catch (Exception ex) {
                        Logger.getLogger(PersonasInactivasFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (tc != null) {
                        nf = tc.getNombreFantasia();
                    }
                }
                o[3] = nf;
                o[4] = p.getTelefono();
                if (p.getEsTitularCuit()) {
                    o[5] = "ES TITULAR";
                } else {
                    o[5] = "NO ES";
                }
                if (p.getEsEmpleado()) {
                    o[6] = "ES EMPLEADO";
                } else {
                    o[6] = "NO ES";
                }
                if (p.getActivo()) {
                    o[7] = "ACTIVO";
                } else {
                    o[7] = "INACTIVO";
                }
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
    }

    private void volver() {
        AbmPersonaFrame mf = new AbmPersonaFrame();
        mf.setVisible(true);
        this.dispose();
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

    private void activar() {
        int row = tabla.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA PERSONA PARA ACTIVAR");
            return;
        }
        Persona p = personas.get(row);
        String n = p.getApellidoNombre();
        int a = JOptionPane.showConfirmDialog(this, "CONFIRMA ACTIVAR A\n" + n
                , "Atención", JOptionPane.YES_NO_OPTION);
        if(a==0){
            p.setActivo(true);
            try {
                new PersonaService().updatePersona(p);
                JOptionPane.showMessageDialog(this, "PERSONA ACTUALIZADA CORRECTAMENTE");
            } catch (Exception ex) {
                Logger.getLogger(PersonasInactivasFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro. 246 ACTUALIZANDO PERSONA");
                return;
            }
            volver();
        }
    }
}
