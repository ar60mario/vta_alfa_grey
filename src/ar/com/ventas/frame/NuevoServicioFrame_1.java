/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.Estructura;
import ar.com.ventas.entities.EstructuraServicio;
import ar.com.ventas.entities.Importe;
import ar.com.ventas.entities.RenglonTrabajo;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.Servicio;
import ar.com.ventas.entities.Trabajo;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.services.EstructuraServicioService;
import ar.com.ventas.services.ImporteService;
import ar.com.ventas.services.RenglonTrabajoService;
import ar.com.ventas.services.RubroService;
import ar.com.ventas.services.ServicioService;
import ar.com.ventas.services.TrabajoService;
import ar.com.ventas.util.UtilFrame;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class NuevoServicioFrame_1 extends javax.swing.JFrame {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private final DecimalFormat dfp = new DecimalFormat("#0");
    private final DecimalFormat df = new DecimalFormat("#0.00");
    private Date fecha;
    private Consorcio consorcio;
    private List<Consorcio> consorcios;
//    private List<Rubro> rubros;
    private Rubro rubro;
    private List<Importe> importes;

    /**
     * Creates new form NuevoTrabajoFrame
     *
     */
    public NuevoServicioFrame_1(Consorcio consorcio, Rubro rubro) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(this.MAXIMIZED_BOTH);
        this.consorcio = consorcio;
        this.rubro = rubro;
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
        guardarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fechaTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cantidadCuotasTxt = new javax.swing.JTextField();
        comboP = new javax.swing.JComboBox<>();
        caracteristicasTxt = new javax.swing.JTextField();
        calleTxt = new javax.swing.JTextField();
        fisicoQuimicoCbx = new javax.swing.JCheckBox();
        bacteriologicoCbx = new javax.swing.JCheckBox();
        ingresaUltimaFechaChk = new javax.swing.JCheckBox();
        fechaUltimoTrabajoTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        combo1 = new javax.swing.JComboBox<>();
        combo2 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        importeFacturarTxt = new javax.swing.JTextField();
        rubroTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ALTA NUEVO SERVICIO");

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        guardarBtn.setText("Guardar");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Consorcio:");

        jLabel2.setText("Fecha:");

        fechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaTxt.setText("FECHA");

        jLabel4.setText("Rubro:");

        jLabel3.setText("Cantidad de Cuotas:");

        jLabel5.setText("Periodicidad:");

        jLabel6.setText("Características:");

        cantidadCuotasTxt.setText("CANT.CUOTAS");
        cantidadCuotasTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantidadCuotasTxtKeyPressed(evt);
            }
        });

        comboP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPActionPerformed(evt);
            }
        });

        caracteristicasTxt.setText("CARACTERISTICAS");
        caracteristicasTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                caracteristicasTxtKeyPressed(evt);
            }
        });

        calleTxt.setText("CALLE");
        calleTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                calleTxtKeyPressed(evt);
            }
        });

        fisicoQuimicoCbx.setText("Físico Químico");

        bacteriologicoCbx.setText("Bacteriológico");

        ingresaUltimaFechaChk.setText("INGRESAR FECHA ULTIMO SERVICIO");
        ingresaUltimaFechaChk.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ingresaUltimaFechaChkStateChanged(evt);
            }
        });
        ingresaUltimaFechaChk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresaUltimaFechaChkActionPerformed(evt);
            }
        });

        fechaUltimoTrabajoTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaUltimoTrabajoTxt.setText("FECHA");
        fechaUltimoTrabajoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaUltimoTrabajoTxtKeyPressed(evt);
            }
        });

        jLabel8.setText("Fecha:");

        jLabel9.setText("Respete Formato: >>>   DD/MM/AAAA");

        jLabel10.setText("PAGO A OPERARIO SOLO:");

        jLabel11.setText("PAGO A OPERARIO ACOMPAÑADO:");

        combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        combo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Importe a Facturar:");

        importeFacturarTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeFacturarTxt.setText("IMP.A.FACTU");

        rubroTxt.setText("RUBRO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combo1, 0, 499, Short.MAX_VALUE)
                                    .addComponent(combo2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fisicoQuimicoCbx)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ingresaUltimaFechaChk)
                                            .addComponent(bacteriologicoCbx))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(18, 18, 18)
                                                .addComponent(importeFacturarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(fechaUltimoTrabajoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(186, 186, 186))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(guardarBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 749, Short.MAX_VALUE)
                                .addComponent(volverBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cantidadCuotasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(comboP, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(caracteristicasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(rubroTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                                            .addComponent(calleTxt))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(calleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rubroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(cantidadCuotasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(caracteristicasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bacteriologicoCbx)
                    .addComponent(jLabel12)
                    .addComponent(importeFacturarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(fisicoQuimicoCbx)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingresaUltimaFechaChk)
                    .addComponent(fechaUltimoTrabajoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(guardarBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        guardar();
    }//GEN-LAST:event_guardarBtnActionPerformed

    private void cantidadCuotasTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadCuotasTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            comboP.requestFocus();
        }
    }//GEN-LAST:event_cantidadCuotasTxtKeyPressed

    private void caracteristicasTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caracteristicasTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            guardarBtn.requestFocus();
        }
    }//GEN-LAST:event_caracteristicasTxtKeyPressed

    private void comboPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPActionPerformed
        int rowP = comboP.getSelectedIndex();
        if (rowP > 0) {
            caracteristicasTxt.requestFocus();
        }
    }//GEN-LAST:event_comboPActionPerformed

    private void calleTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calleTxtKeyPressed
//        if (evt.getKeyCode() == 10) {
//            llenarComboC();
//        }
    }//GEN-LAST:event_calleTxtKeyPressed

    private void ingresaUltimaFechaChkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresaUltimaFechaChkActionPerformed
//        if(ingresaUltimaFechaChk.isSelected()){
//            fechaUltimoTrabajoTxt.setVisible(true);
//            fechaUltimoTrabajoTxt.requestFocus();
//            jLabel8.setVisible(true);
//            jLabel9.setVisible(true);
//        }else{
//            fechaUltimoTrabajoTxt.setVisible(false);
//            jLabel8.setVisible(false);
//            jLabel9.setVisible(false);
//            //fechaUltimoTrabajoTxt.requestFocus();
//        }
    }//GEN-LAST:event_ingresaUltimaFechaChkActionPerformed

    private void ingresaUltimaFechaChkStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ingresaUltimaFechaChkStateChanged
        if (ingresaUltimaFechaChk.isSelected()) {
            fechaUltimoTrabajoTxt.setVisible(true);
            fechaUltimoTrabajoTxt.requestFocus();
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
        } else {
            fechaUltimoTrabajoTxt.setVisible(false);
            jLabel8.setVisible(false);
            jLabel9.setVisible(false);
            //fechaUltimoTrabajoTxt.requestFocus();
        }
    }//GEN-LAST:event_ingresaUltimaFechaChkStateChanged

    private void fechaUltimoTrabajoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaUltimoTrabajoTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!fechaUltimoTrabajoTxt.getText().isEmpty()) {
                int largo = fechaUltimoTrabajoTxt.getText().length();
                String fe = fechaUltimoTrabajoTxt.getText();
                if (largo == 10) {
                    guardarBtn.requestFocus();
                } else {
                    fe = UtilFrame.fecha(fe);
                    fechaUltimoTrabajoTxt.setText(fe);
                }
            } else {
                String fe = "";
                fe = UtilFrame.fecha(fe);
                fechaUltimoTrabajoTxt.setText(fe);
            }
        }
    }//GEN-LAST:event_fechaUltimoTrabajoTxtKeyPressed

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
            java.util.logging.Logger.getLogger(NuevoServicioFrame_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoServicioFrame_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoServicioFrame_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoServicioFrame_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoServicioFrame_1(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox bacteriologicoCbx;
    private javax.swing.JTextField calleTxt;
    private javax.swing.JTextField cantidadCuotasTxt;
    private javax.swing.JTextField caracteristicasTxt;
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JComboBox<String> combo2;
    private javax.swing.JComboBox<String> comboP;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JTextField fechaUltimoTrabajoTxt;
    private javax.swing.JCheckBox fisicoQuimicoCbx;
    private javax.swing.JButton guardarBtn;
    private javax.swing.JTextField importeFacturarTxt;
    private javax.swing.JCheckBox ingresaUltimaFechaChk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField rubroTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void llenarCombos() {
        consorcios = null;
        try {
            consorcios = new ConsorcioService().getAllConsorciosActivos();
        } catch (Exception ex) {
            Logger.getLogger(NuevoServicioFrame_1.class.getName()).log(Level.SEVERE, null, ex);
        }
//        comboC.removeAllItems();
//        comboC.addItem("");
//        if (consorcios != null && !consorcios.isEmpty()) {
//            for (Consorcio c : consorcios) {
//                comboC.addItem(c.getNombre() + " "
//                        + c.getDomicilio().getCalle() + " "
//                        + c.getDomicilio().getNumero()
//                );
//            }
//        }
        comboP.removeAllItems();
        comboP.addItem("");
        for (int i = 0; i < 13; i++) {
            comboP.addItem(dfp.format(i));
        }
//        rubros = null;
//        try {
//            rubros = new RubroService().getAllRubrosActivos();
//        } catch (Exception ex) {
//            Logger.getLogger(NuevoServicioFrame_1.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        comboR.removeAllItems();
//        comboR.addItem("");
//        if (rubros != null && !rubros.isEmpty()) {
//            for (Rubro r : rubros) {
//                comboR.addItem(r.getDetalle());
//            }
//        }
        combo1.removeAllItems();
        combo2.removeAllItems();
        combo1.addItem("");
        combo2.addItem("");
        importes = null;
        try {
            importes = new ImporteService().getAllImportesActivos();
        } catch (Exception ex) {
            Logger.getLogger(NuevoServicioFrame_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (importes != null && !importes.isEmpty()) {
            for (Importe im : importes) {
                combo1.addItem(im.getDetalle());
                combo2.addItem(im.getDetalle());
            }
        }
    }

    private void limpiarCampos() {
        // llenarCombos();
        Domicilio dm = consorcio.getDomicilio();
        calleTxt.setText(dm.getCalle() + " " + dm.getNumero());
        calleTxt.setEditable(false);
        rubroTxt.setText(rubro.getDetalle());
        fecha = new Date();
        fechaUltimoTrabajoTxt.setText("");
        fechaUltimoTrabajoTxt.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        fechaTxt.setText(sdf.format(fecha));
        fechaTxt.requestFocus();
        try {
            fecha = sdf.parse(fechaTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(NuevoServicioFrame_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        cantidadCuotasTxt.setText("");
        caracteristicasTxt.setText("");
        fisicoQuimicoCbx.setSelected(false);
        bacteriologicoCbx.setSelected(true);
    }

    private void guardar() {
        if (validar()) {
            Servicio servicio = new Servicio();
            int row1 = combo1.getSelectedIndex();
            int row2 = combo2.getSelectedIndex();
            Importe importe1 = importes.get(row1 - 1);
            Importe importe2 = importes.get(row2 - 1);
            servicio.setActivo(true);
//            int rowC = comboC.getSelectedIndex();
//            consorcio = consorcios.get(rowC - 1);
//            int rowR = comboR.getSelectedIndex();
//            rubro = rubros.get(rowR - 1);
            int cantidad = Integer.valueOf(cantidadCuotasTxt.getText());
            servicio.setCantidadCuotas(cantidad);
            servicio.setTrabajoCreado(false);
            servicio.setCaracteristicas(caracteristicasTxt.getText());
            servicio.setConsorcio(consorcio);
            servicio.setFecha(fecha);
            servicio.setImporte1(importe1);
            servicio.setImporte2(importe2);
            Date fe1 = new Date();
            try {
                fe1 = sdf.parse(fechaUltimoTrabajoTxt.getText());
            } catch (ParseException ex) {
                Logger.getLogger(NuevoServicioFrame_1.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR AL PROCESAR FECHA");
                fechaUltimoTrabajoTxt.requestFocus();
                return;
            }
            servicio.setUltimoTrabajo(fe1);
            Double importe = 1.00;
            servicio.setImporte(importe);
            int rowP = comboP.getSelectedIndex();
            servicio.setPeriodicidad(rowP - 1);
            servicio.setRubro(rubro);
            if (fisicoQuimicoCbx.isSelected()) {
                servicio.setFisicoQuimico(true);
            } else {
                servicio.setFisicoQuimico(false);
            }
            if (bacteriologicoCbx.isSelected()) {
                servicio.setBacteriologico(true);
            } else {
                servicio.setBacteriologico(false);
            }
            if (ingresaUltimaFechaChk.isSelected()) {
                servicio.setTrabajoCreado(true);
            }
            try {
                new ServicioService().saveServicio(servicio);
                JOptionPane.showMessageDialog(this, "SERVICIO GUARDADO CORRECTAMENTE");
            } catch (Exception ex) {
                Logger.getLogger(NuevoServicioFrame_1.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro.434 GUARDANDO SERVICIO");
                return;
            }
            List<RenglonTrabajo> renglones = new ArrayList<>();
            Trabajo trabajo = new Trabajo();

            Boolean bacterio;
            Boolean fisicoQi;
            String caracteristicas;
            if (ingresaUltimaFechaChk.isSelected()) {
                trabajo.setActivo(true);
                trabajo.setCuota(1);
                trabajo.setFacturaEmitida(false);
                Date ultimaFecha = new Date();
                try {
                    ultimaFecha = sdf.parse(fechaUltimoTrabajoTxt.getText());
                } catch (ParseException ex) {
                    Logger.getLogger(NuevoServicioFrame_1.class.getName()).log(Level.SEVERE, null, ex);
                }
                trabajo.setFecha(ultimaFecha);
                trabajo.setPdfGenerado(false);
                trabajo.setReciboEmitido(false);
                trabajo.setRenovado(false);
                trabajo.setServicio(servicio);
                trabajo.setTextoEnFactura("");
                try {
                    trabajo = new TrabajoService().saveTrabajo(trabajo);
                } catch (Exception ex) {
                    Logger.getLogger(NuevoServicioFrame_1.class.getName()).log(Level.SEVERE, null, ex);
                }
                Date fechaCargar = ultimaFecha;
                if (servicio.getBacteriologico()) {
                    bacterio = true;
                } else {
                    bacterio = false;
                }
                if (servicio.getFisicoQuimico()) {
                    fisicoQi = true;
                } else {
                    fisicoQi = false;
                }
                caracteristicas = servicio.getCaracteristicas();
                Rubro rubro = servicio.getRubro();
                Estructura estructura = rubro.getEstructura();
                List<EstructuraServicio> es = null;
                try {
                    es = new EstructuraServicioService().getAllEstructuraServicioByEstructuraActivos(estructura);
                } catch (Exception ex) {
                    Logger.getLogger(NuevoTrabajoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (es != null && !es.isEmpty()) {
                    for (EstructuraServicio e : es) {
                        RenglonTrabajo rs = new RenglonTrabajo();
                        rs.setActivo(true);
                        rs.setVisible(e.getVisible());
                        rs.setCampo(e.getContenido());
                        rs.setCodigoCampo(e.getCampoEstructura());
                        rs.setContenido("");
                        rs.setFecha(new Date());
                        rs.setTrabajo(trabajo);
                        rs.setOrden(e.getOrden());

                        renglones.add(rs);
                    }
                    for (RenglonTrabajo rt : renglones) {
                        if (rt.getCodigoCampo().equals(4)) {
                            rt.setContenido(sdf.format(fechaCargar));
                        }
                        if (rt.getCodigoCampo().equals(13)) {
                            rt.setContenido(caracteristicas);
                        }
                        if (rt.getCodigoCampo().equals(17)) {
                            rt.setContenido("2");
                        }
                        if (rt.getCodigoCampo().equals(16)) {
                            if (fisicoQi) {
                                rt.setContenido("1");
                            } else {
                                rt.setContenido("2");
                            }
                        }
                        if (rt.getCodigoCampo().equals(15)) {
                            if (bacterio) {
                                rt.setContenido("1");
                            } else {
                                rt.setContenido("2");
                            }
                        }
                        if (rt.getCodigoCampo().equals(10)) {
                            rt.setContenido("2");
                        }
                        if (rt.getCodigoCampo().equals(11)) {
                            rt.setContenido("2");
                        }
                        try {
                            new RenglonTrabajoService().saveRenglonTrabajo(rt);
                        } catch (Exception ex) {
                            Logger.getLogger(NuevoServicioFrame_1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }
        } else {
            return;
        }
        volver();
    }

    private boolean validar() {
        Servicio s = null;
        if(importeFacturarTxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "DEBE INDICAR UN IMPORTE PARA FACTURAR LOS TRABAJOS");
            return false;
        }
        if (cantidadCuotasTxt.getText().isEmpty()) {
            cantidadCuotasTxt.setText("0");
        }
        if (ingresaUltimaFechaChk.isSelected()) {
            if (fechaUltimoTrabajoTxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "DEBE INGRESAR UNA FECHA DE ULTIMO SERVICIO");
                fechaUltimoTrabajoTxt.requestFocus();
                return false;
            }
        } else {
            fechaUltimoTrabajoTxt.setText(sdf.format(new Date()));
        }
        int rowP = comboP.getSelectedIndex();
        if (rowP < 1) {
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR UNA PERIODICIDAD");
            comboP.requestFocus();
            return false;
        }
//        int rowC = comboC.getSelectedIndex();
//        if (rowC < 1) {
//            JOptionPane.showMessageDialog(this, "DEBE INGRESAR UN CONSORCIO");
//            comboC.requestFocus();
//            return false;
//        }
//        int rowR = comboR.getSelectedIndex();
//        if (rowR < 1) {
//            JOptionPane.showMessageDialog(this, "DEBE INGRESAR UN RUBRO");
//            comboR.requestFocus();
//            return false;
//        }
        int row1 = combo1.getSelectedIndex();
        int row2 = combo2.getSelectedIndex();
        if (row1 < 1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN CONCEPTO DE PAGO");
            combo1.requestFocus();
            return false;
        }
        if (row2 < 1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN CONCEPTO DE PAGO\n"
                    + "    ELIJA EL MISMO SI SON IGUALES");
            combo2.requestFocus();
            return false;
        }
//        Consorcio consorcio = consorcios.get(rowC - 1);
//        Rubro rubro = rubros.get(rowR - 1);
        try {
            s = new ServicioService().getServicioActivoByRubroAndConsorcio(rubro, consorcio);
            if (s != null) {
                JOptionPane.showMessageDialog(this, "ESTRE CONSORCIO YA CONTIENE UN SERVICIO CON ESTE RUBRO");
                return false;
            }
        } catch (Exception ex) {
            // Es correcto que no encuentre uno coincidente
        }
        return true;
    }
}
