/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.CategoriaMonotributo;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.NuevoCae;
import ar.com.ventas.entities.Persona;
import ar.com.ventas.entities.Servicio;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.entities.Trabajo;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.services.CategoriaMonotributoService;
import ar.com.ventas.services.PersonaService;
import ar.com.ventas.services.TitularCuitService;
import ar.com.ventas.util.DesktopApi;
import ar.com.ventas.util.PDFBuilder;
import ar.com.ventas.util.UtilFrame;
import com.itextpdf.text.DocumentException;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class FacturaTrabajoFrame extends javax.swing.JFrame {

    private final Trabajo trabajo;
    private Consorcio consorcio;
    private DecimalFormat df = new DecimalFormat("#0.00");
    private DecimalFormat df1 = new DecimalFormat("#0");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private List<Persona> titulares;

    /**
     * Creates new form FacturaTrabajoFrame
     *
     * @param trabajo
     */
    public FacturaTrabajoFrame(Trabajo trabajo) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(this.MAXIMIZED_BOTH);
        this.trabajo = trabajo;
        cargarFrame();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        detalleTxt = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        consorcioTxt = new javax.swing.JTextField();
        servicioTxt = new javax.swing.JTextField();
        totalFacturaTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        limiteCategoriaTxt = new javax.swing.JTextField();
        categoriaTxt = new javax.swing.JTextField();
        acumulado12Txt = new javax.swing.JTextField();
        acumulado6Txt = new javax.swing.JTextField();
        facturaUnicaChk = new javax.swing.JCheckBox();
        generarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        otroTextoTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        fechaInicioTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        limiteFacturarTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cantidadCuotasTxt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        disponibleFacturarTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("FACTURAR TRABAJO");

        jLabel1.setText("CONSORCIO:");

        jLabel2.setText("SERVICIO:");

        jLabel3.setText("DETALLE:");

        detalleTxt.setColumns(20);
        detalleTxt.setRows(5);
        jScrollPane1.setViewportView(detalleTxt);

        jLabel4.setText("TOTAL FACTURA:");

        consorcioTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        consorcioTxt.setText("CONSORCIO");

        servicioTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        servicioTxt.setText("SERVICIO");

        totalFacturaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalFacturaTxt.setText("TOTAL FC");

        jLabel5.setText("TITULAR DE CUIT:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        jLabel6.setText("ACUMULADO 6 MESES:");

        jLabel7.setText("ACUMULADO 12 MESES:");

        jLabel8.setText("CATEGORIA:");

        jLabel9.setText("LIMITES DE LA CATEGORIA:");

        limiteCategoriaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        limiteCategoriaTxt.setText("LIMITES");

        categoriaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        categoriaTxt.setText("CATEGORIA");

        acumulado12Txt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        acumulado12Txt.setText("ACUM 12");

        acumulado6Txt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        acumulado6Txt.setText("ACUM 6");

        facturaUnicaChk.setText("FACTURA UNICA");

        generarBtn.setText("Generar");
        generarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel10.setText("OTRO TEXTO:");

        otroTextoTxt.setText("OTRO TEXTO");

        jLabel11.setText("FECHA INICIO ACTIVIDADES:");

        fechaInicioTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaInicioTxt.setText("FECHA INICIO");

        jLabel12.setText("LIMITE A FACTURAR:");

        limiteFacturarTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        limiteFacturarTxt.setText("LIMITE FACTURAR");

        jLabel13.setText("CANTIDAD DE CUOTAS:");

        cantidadCuotasTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadCuotasTxt.setText("CANT_CUOTAS");

        jLabel14.setText("DISPONIBLE PARA FACTURAR:");

        disponibleFacturarTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        disponibleFacturarTxt.setText("DISPONIBLE FC");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(generarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(totalFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(cantidadCuotasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel10))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                                    .addComponent(consorcioTxt)
                                    .addComponent(servicioTxt)
                                    .addComponent(otroTextoTxt)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(disponibleFacturarTxt)
                                    .addComponent(limiteCategoriaTxt)
                                    .addComponent(acumulado12Txt)
                                    .addComponent(acumulado6Txt)
                                    .addComponent(limiteFacturarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                                .addGap(165, 165, 165)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaInicioTxt)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(facturaUnicaChk)
                                            .addComponent(jLabel8)
                                            .addComponent(categoriaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 12, Short.MAX_VALUE)))))
                        .addGap(0, 205, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(consorcioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(servicioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(otroTextoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(totalFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cantidadCuotasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(acumulado6Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(acumulado12Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaInicioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(disponibleFacturarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(facturaUnicaChk))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(limiteFacturarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(limiteCategoriaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoriaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generarBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        int row = combo.getSelectedIndex();
        if (row > 0) {
            Persona p = titulares.get(row - 1);
            limpiarTitular();
            mostrarTitular(p);
        }
    }//GEN-LAST:event_comboActionPerformed

    private void generarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarBtnActionPerformed
        generarFactura();
    }//GEN-LAST:event_generarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FacturaTrabajoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaTrabajoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaTrabajoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaTrabajoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturaTrabajoFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acumulado12Txt;
    private javax.swing.JTextField acumulado6Txt;
    private javax.swing.JTextField cantidadCuotasTxt;
    private javax.swing.JTextField categoriaTxt;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField consorcioTxt;
    private javax.swing.JTextArea detalleTxt;
    private javax.swing.JTextField disponibleFacturarTxt;
    private javax.swing.JCheckBox facturaUnicaChk;
    private javax.swing.JTextField fechaInicioTxt;
    private javax.swing.JButton generarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField limiteCategoriaTxt;
    private javax.swing.JTextField limiteFacturarTxt;
    private javax.swing.JTextField otroTextoTxt;
    private javax.swing.JTextField servicioTxt;
    private javax.swing.JTextField totalFacturaTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void cargarFrame() {
        Servicio servicio = trabajo.getServicio();
        consorcio = servicio.getConsorcio();
        Domicilio dm = consorcio.getDomicilio();
        String conso = dm.getCalle() + " " + dm.getNumero();
        String serv = servicio.getRubro().getDetalle();
        String textoFc1 = trabajo.getTextoEnFactura();
        Double importe = servicio.getImporte();

        consorcioTxt.setText(conso);
        consorcioTxt.setEditable(false);
        servicioTxt.setText(serv);
        detalleTxt.setText(trabajo.getTextoEnFactura());
        servicioTxt.setEditable(false);
        detalleTxt.setText(textoFc1);
        totalFacturaTxt.setText(df.format(importe));
        facturaUnicaChk.setSelected(true);
        cantidadCuotasTxt.setText(df1.format(servicio.getCantidadCuotas()));
        otroTextoTxt.setText("");

        limpiarTitular();

        llenarCombo();

    }

    private void llenarCombo() {
        titulares = null;
        combo.removeAllItems();
        combo.addItem("");
        try {
            titulares = new PersonaService().getTitularesActivos();
        } catch (Exception ex) {
            Logger.getLogger(FacturaTrabajoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (titulares != null && !titulares.isEmpty()) {
            for (Persona p : titulares) {
                combo.addItem(p.getApellidoNombre());
            }
        }
    }

    private void volver() {
        TrabajosPendientesDeFacturarFrame tpf = new TrabajosPendientesDeFacturarFrame();
        tpf.setVisible(true);
        this.dispose();
    }

    private void mostrarTitular(Persona p) {
        TitularCuit tc = null;
        try {
            tc = new TitularCuitService().getTitularDeCuitActivoByPersona(p);
        } catch (Exception ex) {
            Logger.getLogger(FacturaTrabajoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (tc != null) {
            Double tf6 = UtilFrame.totalFacturado6(p);
            Double tf12 = UtilFrame.totalFacturado12(p);
            Double limFac = tc.getLimiteFacturar();
            Double limCat = 0.0;
            Double dispoFac = 0.0;
            int tipoInscr = tc.getTipoInscipcion();
            String letraCategoria = tc.getCategoria();
            if (tipoInscr == 6) {
                CategoriaMonotributo categoria = null;
                try {
                    categoria = new CategoriaMonotributoService().getCategoriaByLetraActivo(letraCategoria);
                } catch (Exception ex) {
                    Logger.getLogger(FacturaTrabajoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (categoria != null) {
                    limCat = categoria.getIngresosBrutos();
                }
            }
            acumulado6Txt.setText(df.format(tf6));
            acumulado12Txt.setText(df.format(tf12));
            categoriaTxt.setText(tc.getCategoria());

            limiteCategoriaTxt.setText(df.format(limCat));
            limiteFacturarTxt.setText(df.format(limFac));
            dispoFac = limFac - tf12;

            acumulado6Txt.setEditable(false);
            acumulado12Txt.setEditable(false);
            categoriaTxt.setEditable(false);
            limiteCategoriaTxt.setEditable(false);
            fechaInicioTxt.setText(sdf.format(tc.getFechaInicioActividades()));
            disponibleFacturarTxt.setText(df.format(dispoFac));
        }
    }

    private void limpiarTitular() {
        acumulado6Txt.setText("");
        acumulado12Txt.setText("");
        disponibleFacturarTxt.setText("");
        fechaInicioTxt.setText("");
        limiteFacturarTxt.setText("");
        limiteCategoriaTxt.setText("");
        categoriaTxt.setText("");
    }

    private void generarFactura() {
        int row = combo.getSelectedIndex();
        Persona per = titulares.get(row - 1);
        TitularCuit tit = null;
        try {
            tit = new TitularCuitService().getTitularDeCuitActivoByPersona(per);
        } catch (Exception ex) {
            Logger.getLogger(FacturaTrabajoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "NO SE PUDO COMPLETAR DATOS DEL TITULAR");
            return;
        }
        Integer tipoInsc = tit.getTipoInscipcion();
        Double gravado = 0.0;
        Double iva = 0.0;
        Double total = Double.valueOf(totalFacturaTxt.getText().replace(",", "."));
        if (tipoInsc == 1) {
            gravado = total / 1.21;
            iva = gravado * .21;
        }
        String cuitCliente = trabajo.getServicio().getConsorcio().getCuit();
        // El resultado debe tener mas datos, cae, fecha etc
        NuevoCae resultado = UtilFrame.enviarFacturaAfip(tit, cuitCliente, gravado, iva, total);
        if (resultado != null) {
            String aprobado = resultado.getEstado();
            if (aprobado.equals("N")) {
                JOptionPane.showMessageDialog(this, "COMPROBANTE RECHAZADO POR AFIP");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "VERIFIQUE QUE EL COMPROBANTE ESTE REGISTRADO EN AFIP");
            guardarComprobante();
            return;
        }
        String texto1 = detalleTxt.getText();
        String texto2 = otroTextoTxt.getText();
        // Para registrar faltan datos a enviar
        Integer registro = UtilFrame.registrarComprobante(resultado, tit, trabajo, gravado, iva, total, texto1, texto2);
        if (registro == 1) {
            JOptionPane.showMessageDialog(this, "COMPROBANTE REGISTRADO CORRECTAMENTE");
        } else {
            guardarComprobante();
        }
//        try {
//            File pdf = new PDFBuilder().armarFactura();
//            comprobante
////            DesktopApi.open(pdf);
//        } catch (DocumentException ex) {
//            Logger.getLogger(GenerarCertificadosFrame.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(GenerarCertificadosFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
        volver();
    }

    private void guardarComprobante() {
        
    }
}