/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.CertificadosAfip;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.estructuras.TipoResponsable;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.CertificadosAfipService;
import ar.com.ventas.services.TitularCuitService;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.LibraryLoader;
import com.jacob.com.Variant;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class TestAfipFrame extends javax.swing.JFrame {

    private DecimalFormat df = new DecimalFormat("#0");
    private List<TitularCuit> titulares;
    private TitularCuit titular;

    /**
     * Creates new form TestAfipFrame
     */
    public TestAfipFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(90, 180, 180));
        this.setLocationRelativeTo(null);
//        setExtendedState(6); // this.MAXIMIZED_BOTH
        limpiarCampos();
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
        fcAfipTxt = new javax.swing.JTextField();
        volverBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ncTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cuitTxt = new javax.swing.JTextField();
        puntoVentaTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inscripcionTxt = new javax.swing.JTextField();
        categoriaTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CONSULTAR AFIP");

        jLabel1.setText("Ultimo número Factura:");

        fcAfipTxt.setText("NUMERO");

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Ultima Nota Crédito:");

        ncTxt.setText("NUM NC");

        jLabel4.setText("TITULAR DE CUIT:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        jLabel2.setText("CUIT:");

        jLabel5.setText("PUNTO DE VENTA:");

        cuitTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cuitTxt.setText("CUIT");

        puntoVentaTxt.setText("PUNTO V");

        jLabel6.setText("INSCRIPCION:");

        jLabel7.setText("CATEGORIA:");

        inscripcionTxt.setText("INSCRIPCION");

        categoriaTxt.setText("CATEGORIA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(volverBtn)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fcAfipTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(ncTxt))
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cuitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(puntoVentaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inscripcionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(categoriaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inscripcionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(categoriaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cuitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(puntoVentaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fcAfipTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ncTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(volverBtn)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        int row = combo.getSelectedIndex();
        if (row > 0) {
            titular = titulares.get(row - 1);
            consultar();
        }
    }//GEN-LAST:event_comboActionPerformed

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
            java.util.logging.Logger.getLogger(TestAfipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestAfipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestAfipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestAfipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestAfipFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField categoriaTxt;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField cuitTxt;
    private javax.swing.JTextField fcAfipTxt;
    private javax.swing.JTextField inscripcionTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField ncTxt;
    private javax.swing.JTextField puntoVentaTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        fcAfipTxt.setText("");
        ncTxt.setText("");
        inscripcionTxt.setText("");
        categoriaTxt.setText("");
        cuitTxt.setText("");
        puntoVentaTxt.setText("");
        
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void consultar() {
        Integer inscrip = titular.getTipoInscipcion();
        String tipoInscr = inscrip.toString();
        inscripcionTxt.setText(tipoInscr);
        categoriaTxt.setText(titular.getCategoria());
        cuitTxt.setText(titular.getCuit());
        puntoVentaTxt.setText(titular.getSucursal().toString());
        CertificadosAfip cAfip = null;
        try {
            cAfip = new CertificadosAfipService().getCertificadoByTitular(titular);
        } catch (Exception ex) {
            Logger.getLogger(TestAfipFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR LEYENDO CERTIFICADOS");
            return;
        }

        if (cAfip != null) {
            String certif = cAfip.getCertificado();
            String llave = cAfip.getLlave();

            String cui = titular.getCuit();
            String cuit = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
            String nroComp;
            String pVta = titular.getSucursal().toString();
            Integer tipoInscrip = titular.getTipoInscipcion();
            if (tipoInscrip == 6) {
                nroComp = "11";
            } else {
                nroComp = "6";
            }
            try {
                LibraryLoader.loadJacobLibrary();
                ActiveXComponent wsaa = new ActiveXComponent("WSAA");
                String wsdl = "https://wsaa.afip.gov.ar/ws/services/LoginCms";

                Dispatch.call(wsaa, "Autenticar",
                        new Variant("wsfe"),
                        new Variant(certif),
                        new Variant(llave),
                        /*
                    new Variant(userdir + "/nuevo2018_6851c538ff621621.crt"),
                    new Variant(userdir + "/clave_privada_20142553202_201811010137.key"),
                         */
                        new Variant(wsdl));
                String excepcion = Dispatch.get(wsaa, "Excepcion").toString();
                System.out.println(excepcion);

                String token = Dispatch.get(wsaa, "Token").toString();
                String sign = Dispatch.get(wsaa, "Sign").toString();

                System.out.println(token);

                System.out.println(sign);

                if (token.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "VERIFIQUE LOS CERTIFICADOS");
                    System.exit(0);
                }

//            JOptionPane.showMessageDialog(this, "Ver");
                ActiveXComponent wsfev1 = new ActiveXComponent("WSFEv1");
                Dispatch.put(wsfev1, "Cuit", new Variant(cuit));
                Dispatch.put(wsfev1, "Token", new Variant(token));
                Dispatch.put(wsfev1, "Sign", new Variant(sign));
                String cache = "";
                wsdl = "https://servicios1.afip.gov.ar/wsfev1/service.asmx?WSDL"; // produccion
                Dispatch.call(wsfev1, "Conectar",
                        new Variant(cache),
                        new Variant(wsdl)
                );
                String tipo_cbte = "1";
                tipo_cbte = nroComp; //Factura C
                String pto_vta = pVta; // Sucursal declarada WS
                Variant ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
                        new Variant(tipo_cbte),
                        new Variant(pto_vta));
                excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
                fcAfipTxt.setText(ult.toString());
                tipo_cbte = "13"; //Nota Credito C
                // pto_vta = "6"; // Sucursal declarada WS
                ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
                        new Variant(tipo_cbte),
                        new Variant(pto_vta));
                excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
                ncTxt.setText(ult.toString());
            } catch (Exception e) {
//                JOptionPane.showMessageDialog(this, e);
//                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "VERIFIQUE LOS CERTIFICADOS");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "VERIFIQUE LOS CERTIFICADOS");
            return;
        }
    }

    private void llenarCombo() {
        combo.removeAllItems();
        combo.addItem("");
        titulares = null;
        try {
            titulares = new TitularCuitService().getAllTitularDeCuitActivos();
        } catch (Exception ex) {
            Logger.getLogger(TestAfipFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (titulares != null && !titulares.isEmpty()) {
            for (TitularCuit tc : titulares) {
                combo.addItem(tc.getPersona().getApellidoNombre());
            }
        }
    }
}
