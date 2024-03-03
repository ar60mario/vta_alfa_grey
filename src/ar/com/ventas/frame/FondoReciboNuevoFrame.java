/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.FondoRecibo;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.services.FondoReciboService;
import ar.com.ventas.services.TitularCuitService;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class FondoReciboNuevoFrame extends javax.swing.JFrame {

    private List<TitularCuit> titulares;

    /**
     * Creates new form FondoReciboNuevoFrame
     */
    public FondoReciboNuevoFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(6); // this.MAXIMIZED_BOTH
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        seleccionarBtn = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        empresaTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fondoTxt = new javax.swing.JTextField();
        crearBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("GRABAR NUEVO FONDO RECIBO");

        jLabel1.setText("EMPRESA:");

        jLabel2.setText("TITULAR DE CUIT:");

        jLabel3.setText("UBICACION:");

        seleccionarBtn.setText("Seleccionar");
        seleccionarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarBtnActionPerformed(evt);
            }
        });

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        empresaTxt.setText("EMPRESA");

        jLabel4.setText("FONDO:");

        fondoTxt.setText("RUTA DEL FONDO");

        crearBtn.setText("CREAR NUEVO");
        crearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearBtnActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seleccionarBtn)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(combo, 0, 265, Short.MAX_VALUE)
                                .addComponent(empresaTxt))
                            .addComponent(fondoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 124, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(crearBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(empresaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(seleccionarBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fondoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearBtnActionPerformed
        crear();
    }//GEN-LAST:event_crearBtnActionPerformed

    private void seleccionarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarBtnActionPerformed
        String fondo = seleccionar();
        fondoTxt.setText(fondo);
    }//GEN-LAST:event_seleccionarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FondoReciboNuevoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FondoReciboNuevoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FondoReciboNuevoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FondoReciboNuevoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FondoReciboNuevoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton crearBtn;
    private javax.swing.JTextField empresaTxt;
    private javax.swing.JTextField fondoTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton seleccionarBtn;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void volver() {
        AbmFondosRecibosFrame afrf = new AbmFondosRecibosFrame();
        afrf.setVisible(true);
        this.dispose();
    }

    private String seleccionar() {
        String fondo = "";
        JFileChooser selector = new JFileChooser();
        selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        if (archivo != null) {
            fondo = archivo.toString();
        }
        return fondo;
    }

    private void crear() {
        int row = combo.getSelectedIndex();
        Integer codigo;
        if (validar(row)) {
            try {
                codigo = new FondoReciboService().getCodigoSiguiente();
            } catch (Exception ex) {
                Logger.getLogger(FondoReciboNuevoFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR 224 - NUEVO FONDO RECIBO");
                return;
            }
            TitularCuit titular = titulares.get(row - 1);
            FondoRecibo fr = new FondoRecibo();
            fr.setActivo(true);
            fr.setCodigo(codigo + 1);
            fr.setEmpresa(empresaTxt.getText());
            fr.setTitular(titular);
            fr.setUbicacion(fondoTxt.getText());
            try {
                new FondoReciboService().saveFondoRecibo(fr);
            } catch (Exception ex) {
                Logger.getLogger(FondoReciboNuevoFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR 249 - SAVE FONDO RECIBO");
                return;
            }
            JOptionPane.showMessageDialog(this, "GRABACION CORRECTA");
            volver();
        }
    }

    private void limpiarCampos() {
        empresaTxt.setText("");
        combo.removeAllItems();
        combo.addItem("");
        fondoTxt.setEditable(false);
        titulares = null;
        try {
            titulares = new TitularCuitService().getAllTitularDeCuitActivos();
        } catch (Exception ex) {
            Logger.getLogger(FondoReciboNuevoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR 246 - TITULARES");
            return;
        }
        if (titulares != null && !titulares.isEmpty()) {
            for (TitularCuit t : titulares) {
                combo.addItem(t.getPersona().getApellidoNombre());
            }
        }
    }

    private boolean validar(int row) {
        if (row < 1) {
            JOptionPane.showMessageDialog(this, "SELECCIONE UN TITULAR DE CUIT");
            return false;
        }
        if(empresaTxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "DEBE INDICAR UN NOMBRE EMPRESA PARA EL FONDO");
            return false;
        }
        if(fondoTxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN FONDO CON EL BOTON DE >> SELECCIONAR <<");
            return false;
        }
        return true;
    }
}