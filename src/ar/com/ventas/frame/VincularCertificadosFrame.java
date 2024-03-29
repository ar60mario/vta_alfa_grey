/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.CertificadosAfip;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.CertificadosAfipService;
import java.io.File;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class VincularCertificadosFrame extends javax.swing.JFrame {

    private TitularCuit titular;
    private String certificado;
    private String llave;

    /**
     * Creates new form VincularCertificadosFrame
     */
    public VincularCertificadosFrame(TitularCuit titular) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(6); // this.MAXIMIZED_BOTH
        this.titular = titular;
        llenarCampos();

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
        titularTxt = new javax.swing.JTextField();
        cuitTxt = new javax.swing.JTextField();
        seleccionarCertificadoBtn = new javax.swing.JButton();
        seleccionarLlavaBtn = new javax.swing.JButton();
        certificadoTxt = new javax.swing.JTextField();
        llaveTxt = new javax.swing.JTextField();
        aplicarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("VINCULAR CERTIFICADO A TITULAR");

        jLabel1.setText("Titular:");

        jLabel2.setText("Cuit:");

        titularTxt.setText("TITULAR");

        cuitTxt.setText("CUIT");

        seleccionarCertificadoBtn.setText("Seleccione Certificado");
        seleccionarCertificadoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarCertificadoBtnActionPerformed(evt);
            }
        });

        seleccionarLlavaBtn.setText("Seleccione Llave");
        seleccionarLlavaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarLlavaBtnActionPerformed(evt);
            }
        });

        certificadoTxt.setText("CERTIFICADO");

        llaveTxt.setText("LLAVE");

        aplicarBtn.setText("Aplicar");
        aplicarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarBtnActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(titularTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                            .addComponent(cuitTxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(seleccionarCertificadoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(certificadoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(seleccionarLlavaBtn)
                        .addGap(18, 18, 18)
                        .addComponent(llaveTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aplicarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(titularTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cuitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seleccionarCertificadoBtn)
                    .addComponent(certificadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seleccionarLlavaBtn)
                    .addComponent(llaveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aplicarBtn)
                    .addComponent(volverBtn))
                .addContainerGap(296, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void aplicarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarBtnActionPerformed
        aplicar();
    }//GEN-LAST:event_aplicarBtnActionPerformed

    private void seleccionarCertificadoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarCertificadoBtnActionPerformed
        certificado();
    }//GEN-LAST:event_seleccionarCertificadoBtnActionPerformed

    private void seleccionarLlavaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarLlavaBtnActionPerformed
        llave();
    }//GEN-LAST:event_seleccionarLlavaBtnActionPerformed

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
            java.util.logging.Logger.getLogger(VincularCertificadosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VincularCertificadosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VincularCertificadosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VincularCertificadosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VincularCertificadosFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aplicarBtn;
    private javax.swing.JTextField certificadoTxt;
    private javax.swing.JTextField cuitTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField llaveTxt;
    private javax.swing.JButton seleccionarCertificadoBtn;
    private javax.swing.JButton seleccionarLlavaBtn;
    private javax.swing.JTextField titularTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarCampos() {
        titularTxt.setText(titular.getPersona().getApellidoNombre());
        cuitTxt.setText(titular.getCuit());
        certificadoTxt.setText("");
        llaveTxt.setText("");
        seleccionarCertificadoBtn.requestFocus();
    }

    private void aplicar() {
        if (validar()) {
            if (existCertif(titular)) {
                CertificadosAfip ca = leerCertificado(titular);
                ca.setCertificado(certificado);
                ca.setLlave(llave);
                ca.setTitularCuit(titular);
                ca.setFecha(new Date());
                try {
                    new CertificadosAfipService().updateCertificado(ca);
                    JOptionPane.showMessageDialog(this, "CERTIFICADO ACTUALIZADO CORRECTAMENTE");
                } catch (Exception ex) {
                    Logger.getLogger(VincularCertificadosFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "ERRORGUARDANDO CERTIFICADO");
                    return;
                }
            } else {
                CertificadosAfip ca = new CertificadosAfip();
                ca.setCertificado(certificado);
                ca.setLlave(llave);
                ca.setTitularCuit(titular);
                ca.setFecha(new Date());
                try {
                    new CertificadosAfipService().saveCertificado(ca);
                    JOptionPane.showMessageDialog(this, "CERTIFICADO GUARDADO CORRECTAMENTE");
                } catch (Exception ex) {
                    Logger.getLogger(VincularCertificadosFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "ERRORGUARDANDO CERTIFICADO");
                    return;
                }
            }
            volver();
        }
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void certificado() {
        JFileChooser selector = new JFileChooser();
        selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        if (archivo != null) {
            certificado = archivo.toString();
            certificadoTxt.setText(certificado);
        }
    }

    private void llave() {
        JFileChooser selector = new JFileChooser();
        selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        if (archivo != null) {
            llave = archivo.toString();
            llaveTxt.setText(llave);
        }
    }

    private boolean validar() {
        if (certificadoTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN CERTIFICADO VALIDO");
            return false;
        }
        if (llaveTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA LLAVE VALIDA");
            return false;
        }
        return true;
    }

    private boolean existCertif(TitularCuit ca) {
        CertificadosAfip nuevo = null;
        try {
            nuevo = new CertificadosAfipService().getCertificadoByTitular(titular);
        } catch (Exception ex) {
            Logger.getLogger(VincularCertificadosFrame.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        if (nuevo != null) {
            return true;
        } else {
            return false;
        }
    }

    private CertificadosAfip leerCertificado(TitularCuit titular) {
        CertificadosAfip nuevo = null;
        try {
            nuevo = new CertificadosAfipService().getCertificadoByTitular(titular);
        } catch (Exception ex) {
            Logger.getLogger(VincularCertificadosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        
        
            return false;
        }
        if (nuevo != null) {
            return true;
        } else {
            return false;
        }
        */
        return nuevo;
    }
}
