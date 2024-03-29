/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Hijo;
import ar.com.ventas.entities.Persona;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.services.HijoService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class ModificarHijoFrame extends javax.swing.JFrame {
    
    private Persona persona;
    private Hijo hijo;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Integer h;

    /**
     * Creates new form NuevoHijoFrame
     *
     * @param persona
     */
    public ModificarHijoFrame(Persona persona, Hijo hijo, Integer h) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(this.MAXIMIZED_BOTH);
        this.persona = persona;
        this.hijo = hijo;
        this.h = h;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        personaTxt = new javax.swing.JTextField();
        apellidoNombreTxt = new javax.swing.JTextField();
        apellidoNombreOtroPadreTxt = new javax.swing.JTextField();
        fechaNacimientoTxt = new javax.swing.JTextField();
        dniTxt = new javax.swing.JTextField();
        cuilTxt = new javax.swing.JTextField();
        guardarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        activoChk = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("MODIFICAR HIJO HIJO");

        jLabel1.setText("Padre:");

        jLabel2.setText("Apellido y Nombre:");

        jLabel3.setText("Fecha Nacimiento:");

        jLabel4.setText("DNI:");

        jLabel5.setText("CUIL:");

        jLabel6.setText("Otro Padre:");

        personaTxt.setText("PERSONA PADRE");

        apellidoNombreTxt.setText("APELLIDO Y NOMBRE");
        apellidoNombreTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                apellidoNombreTxtKeyPressed(evt);
            }
        });

        apellidoNombreOtroPadreTxt.setText("APELLIDO NOMBRE DEL OTRO PADRE");

        fechaNacimientoTxt.setText("FECHA NACIM");
        fechaNacimientoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaNacimientoTxtKeyPressed(evt);
            }
        });

        dniTxt.setText("DNI");
        dniTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dniTxtKeyPressed(evt);
            }
        });

        cuilTxt.setText("CUIL");
        cuilTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cuilTxtKeyPressed(evt);
            }
        });

        guardarBtn.setText("Guardar");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("*");

        jLabel8.setText("*");

        jLabel9.setText("*");

        activoChk.setText("Activo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dniTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cuilTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(personaTxt)
                                    .addComponent(apellidoNombreTxt)
                                    .addComponent(apellidoNombreOtroPadreTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fechaNacimientoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addGap(128, 128, 128)
                                        .addComponent(activoChk)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)))
                        .addGap(0, 242, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(guardarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(personaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(apellidoNombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fechaNacimientoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(activoChk))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dniTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cuilTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(apellidoNombreOtroPadreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        guardar();
    }//GEN-LAST:event_guardarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void apellidoNombreTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidoNombreTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!apellidoNombreTxt.getText().isEmpty()) {
                fechaNacimientoTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_apellidoNombreTxtKeyPressed

    private void fechaNacimientoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaNacimientoTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!fechaNacimientoTxt.getText().isEmpty()) {
                int largo = fechaNacimientoTxt.getText().length();
                if (largo != 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN FORMATO FECHA\n"
                            + "UTILICE FORMATO DD/MM/AAAA");
                    return;
                }
                dniTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_fechaNacimientoTxtKeyPressed

    private void dniTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dniTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!dniTxt.getText().isEmpty()) {
                cuilTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_dniTxtKeyPressed

    private void cuilTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cuilTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            apellidoNombreOtroPadreTxt.requestFocus();
        }
    }//GEN-LAST:event_cuilTxtKeyPressed

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
            java.util.logging.Logger.getLogger(ModificarHijoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarHijoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarHijoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarHijoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarHijoFrame(null, null, null).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox activoChk;
    private javax.swing.JTextField apellidoNombreOtroPadreTxt;
    private javax.swing.JTextField apellidoNombreTxt;
    private javax.swing.JTextField cuilTxt;
    private javax.swing.JTextField dniTxt;
    private javax.swing.JTextField fechaNacimientoTxt;
    private javax.swing.JButton guardarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField personaTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void guardar() {
        if (validar()) {
            if (activoChk.isSelected()) {
                hijo.setActivo(true);
            } else {
                hijo.setActivo(false);
            }
            hijo.setApellidoNombre(apellidoNombreTxt.getText());
            hijo.setCuil(cuilTxt.getText());
            hijo.setDni(dniTxt.getText());
            Date nacimiento = new Date();
            try {
                nacimiento = sdf.parse(fechaNacimientoTxt.getText());
            } catch (ParseException ex) {
                Logger.getLogger(ModificarHijoFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro.305 FECHA INCORRECTA");
                fechaNacimientoTxt.requestFocus();
                return;
            }
            hijo.setNacimiento(nacimiento);
            hijo.setOtroPadre(apellidoNombreOtroPadreTxt.getText());
            hijo.setPadre(persona);
            try {
                new HijoService().updateHijo(hijo);
                JOptionPane.showMessageDialog(this, "HIJO GUARDADO CORRECTAMENTE");
            } catch (Exception ex) {
                Logger.getLogger(ModificarHijoFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro.317 GUARDANDO HIJO");
                return;
            }
            volver();
        }
    }
    
    private void volver() {
        AbmHijosFrame ahf = new AbmHijosFrame(persona, h);
        ahf.setVisible(true);
        this.dispose();
    }
    
    private boolean validar() {
        if (apellidoNombreTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR UN APELLIDO Y NOMBRE PARA HIJO");
            apellidoNombreTxt.requestFocus();
            return false;
        }
        if (fechaNacimientoTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR UNA FECHA DE NACIMIENTO PARA HIJO");
            fechaNacimientoTxt.requestFocus();
            return false;
        }
        if (dniTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR UN DNI PARA HIJO");
            dniTxt.requestFocus();
            return false;
        }
        return true;
    }
    
    private void llenarCampos() {
        personaTxt.setText(persona.getApellidoNombre());
        personaTxt.setEditable(false);
        if (hijo.getActivo()) {
            activoChk.setSelected(true);
        } else {
            activoChk.setSelected(false);
        }
        apellidoNombreTxt.requestFocus();
        apellidoNombreTxt.setText(hijo.getApellidoNombre());
        fechaNacimientoTxt.setText(sdf.format(hijo.getNacimiento()));
        dniTxt.setText(hijo.getDni());
        cuilTxt.setText(hijo.getCuil());
        apellidoNombreOtroPadreTxt.setText(hijo.getOtroPadre());
    }
}
