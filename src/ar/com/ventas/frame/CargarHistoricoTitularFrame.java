/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.ComprobanteNumerosIniciales;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.services.ComprobanteNumerosInicialesService;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.IvaVentasService;
import ar.com.ventas.services.TitularCuitService;
import ar.com.ventas.util.UtilFrame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class CargarHistoricoTitularFrame extends javax.swing.JFrame {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private List<TitularCuit> titulares;
    private TitularCuit titular;
    private Date fecha;
    private Double importe;

    /**
     * Creates new form CargarHistoricoTitularFrame
     */
    public CargarHistoricoTitularFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        setExtendedState(6);
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
        combo = new javax.swing.JComboBox<>();
        filtroTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cuitTxt = new javax.swing.JTextField();
        nombreFantasiaTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fechaTxt = new javax.swing.JTextField();
        importeTxt = new javax.swing.JTextField();
        grabarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        letraTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CARGAR HISTORICO DE FACTURAS");

        jLabel1.setText("Titular ingrese apellido o parte del nombre:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        combo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboKeyPressed(evt);
            }
        });

        filtroTxt.setText("FILTRO");
        filtroTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filtroTxtKeyPressed(evt);
            }
        });

        jLabel2.setText("CUIT:");

        jLabel3.setText("Nombre Fantasia:");

        cuitTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cuitTxt.setText("CUIT");

        nombreFantasiaTxt.setText("NOMBRE FANTASIA");

        jLabel4.setText("FECHA:");

        jLabel5.setText("TOTAL FACTURA:");

        fechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaTxt.setText("FECHA");
        fechaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaTxtKeyPressed(evt);
            }
        });

        importeTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeTxt.setText("IMPORTE");
        importeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                importeTxtKeyPressed(evt);
            }
        });

        grabarBtn.setText("Grabar");
        grabarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarBtnActionPerformed(evt);
            }
        });
        grabarBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                grabarBtnKeyPressed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("LETRA:");

        letraTxt.setText("LETRA");
        letraTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                letraTxtKeyPressed(evt);
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
                        .addComponent(grabarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(filtroTxt))
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(cuitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nombreFantasiaTxt)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(letraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(importeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 400, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(filtroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cuitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombreFantasiaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(letraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(importeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grabarBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filtroTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            llenarCombo();
        }
    }//GEN-LAST:event_filtroTxtKeyPressed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        if (evt.getModifiers() == 16) {
            int row = combo.getSelectedIndex();
            if (row > 0) {
                titular = titulares.get(row - 1);
                completarFrame();
            }
        }
    }//GEN-LAST:event_comboActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void grabarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarBtnActionPerformed
        grabar();
    }//GEN-LAST:event_grabarBtnActionPerformed

    private void comboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboKeyPressed
        if (evt.getKeyCode() == 10) {
            int row = combo.getSelectedIndex();
            if (row > 0) {
                titular = titulares.get(row - 1);
                completarFrame();
            }
        }
    }//GEN-LAST:event_comboKeyPressed

    private void fechaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = fechaTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                letraTxt.setText("C");
                letraTxt.requestFocus();
            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            fechaTxt.setText(fe);
        }
    }//GEN-LAST:event_fechaTxtKeyPressed

    private void letraTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_letraTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            importeTxt.requestFocus();
        }
    }//GEN-LAST:event_letraTxtKeyPressed

    private void importeTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importeTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!importeTxt.getText().isEmpty()) {
                grabarBtn.requestFocus();
            }
        }
    }//GEN-LAST:event_importeTxtKeyPressed

    private void grabarBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_grabarBtnKeyPressed
        if (evt.getKeyCode() == 10) {
            grabar();
        }
    }//GEN-LAST:event_grabarBtnKeyPressed

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
            java.util.logging.Logger.getLogger(CargarHistoricoTitularFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargarHistoricoTitularFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargarHistoricoTitularFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargarHistoricoTitularFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargarHistoricoTitularFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField cuitTxt;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JTextField filtroTxt;
    private javax.swing.JButton grabarBtn;
    private javax.swing.JTextField importeTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField letraTxt;
    private javax.swing.JTextField nombreFantasiaTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        fechaTxt.setText("");
        importeTxt.setText("");
        filtroTxt.setText("");
        cuitTxt.setText("");
        nombreFantasiaTxt.setText("");
        letraTxt.setText("");
        combo.removeAllItems();
    }

    private void volver() {
        AbmPersonaFrame apf = new AbmPersonaFrame();
        apf.setVisible(true);
        this.dispose();
    }

    private void grabar() {
        if (validar()) {
            ComprobanteNumerosIniciales ivni = null;
            try {
                ivni = new ComprobanteNumerosInicialesService().getNumeroInicialByTitular(titular);
            } catch (Exception ex) {
                Logger.getLogger(CargarHistoricoTitularFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "NO SE PUDO LEER NUMERO INICIAL DE FACTURAS");
                return;
            }
            Integer nro;
            if (ivni != null) {
                nro = ivni.getNroCpbte();
            } else {
                nro = 0;
            }
            nro += 1;
            Comprobante iv = new Comprobante();
            Domicilio dm = titular.getDomicilio();
            String domi = dm.getCalle() + " " + dm.getNumero();
            iv.setCae(0L);
            iv.setCodigoComprobante(11);
            iv.setTipoComprobanteAsociado(0);
            iv.setCuitTitular(titular.getCuit());
            iv.setCuitCliente(titular.getCuit());
            iv.setCalleNroPisoDtoCliente(domi);
            iv.setDomicilioTitular(domi);
            iv.setFecha(fecha);
            iv.setFechaInicioActividades(titular.getFechaInicioActividades());
            iv.setFechaVencimientoCae(fecha);
            iv.setIibb(titular.getIibb());
            iv.setLetra(letraTxt.getText());
            iv.setLetraComprobanteAsociado("C");
            iv.setNumero(nro);
            iv.setNumeroComprobanteAsociado(0);
            iv.setRazonSocialTitular(titular.getPersona().getApellidoNombre());
            iv.setRazonSocialCliente(titular.getPersona().getApellidoNombre());
            iv.setSucursal(0);
            iv.setSucursalComprobanteAsociado(0);
            iv.setTipoInscripcion(titular.getTipoInscipcion().toString());
            iv.setTotal(importe);
            try {
                new ComprobanteService().saveComprobante(iv);
                if (nro == 1) {
                    ComprobanteNumerosIniciales iv2ni = new ComprobanteNumerosIniciales();
                    iv2ni.setNroCpbte(nro);
                    iv2ni.setTitular(titular);
                    new ComprobanteNumerosInicialesService().saveImporte(iv2ni);
                } else {
                    ivni.setNroCpbte(nro);
                    new ComprobanteNumerosInicialesService().updateImporte(ivni);
                }
            } catch (Exception ex) {
                Logger.getLogger(CargarHistoricoTitularFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR GRABANDO COMPROBANTE");
                return;
            }
            JOptionPane.showMessageDialog(this, "COMPROBANTE GUARDADO CORRECTAMENTE");
            limpiarCampos2();
        }
    }

    private void llenarCombo() {
        titulares = null;
        if (filtroTxt.getText().isEmpty()) {
            try {
                titulares = new TitularCuitService().getAllTitularDeCuitActivos();
            } catch (Exception ex) {
                Logger.getLogger(CargarHistoricoTitularFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            String filtro = filtroTxt.getText();
            try {
                titulares = new TitularCuitService().getTitularDeCuitActivoByFiltro(filtro);
            } catch (Exception ex) {
                Logger.getLogger(CargarHistoricoTitularFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (titulares != null && !titulares.isEmpty()) {
            combo.removeAllItems();
            combo.addItem("");
            for (TitularCuit t : titulares) {
                combo.addItem(t.getPersona().getApellidoNombre());
            }
            combo.addFocusListener(null);
            combo.showPopup();
            combo.requestFocus();
        }
    }

    private void completarFrame() {
        cuitTxt.setText(titular.getCuit());
        nombreFantasiaTxt.setText(titular.getNombreFantasia());
        fechaTxt.requestFocus();
    }

    private boolean validar() {
        int row = combo.getSelectedIndex();
        if (row < 1) {
            JOptionPane.showMessageDialog(this, "DEBE ELEGIR UN TITULAR DE CUIT");
            combo.requestFocus();
            return false;
        }
        fecha = new Date();
        try {
            fecha = sdf.parse(fechaTxt.getText());
        } catch (ParseException ex) {
//            Logger.getLogger(CargarHistoricoTitularFrame.class.getName()).log(Level.SEVERE, null, ex);
            fechaMal();
            return false;
        }
        if (importeTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR UN IMPORTE");
            importeTxt.requestFocus();
            return false;
        }
        importe = Double.valueOf(importeTxt.getText());
        if (letraTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR UNA LETRA DE COMPROBANTE C/B");
            letraTxt.requestFocus();
            return false;
        }
        return true;
    }

    private void fechaMal() {
        JOptionPane.showMessageDialog(this, "ERROR EN LA FECHA");
        fechaTxt.requestFocus();
    }

    private void limpiarCampos2() {
        importeTxt.setText("");
        fechaTxt.setText("");
        fechaTxt.requestFocus();
    }
}