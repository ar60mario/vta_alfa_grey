/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Abono;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.ConsorcioMaster;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.estructuras.Mes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.AbonoService;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.ConsorcioMasterService;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.util.DesktopApi;
import ar.com.ventas.util.PDFBuilder;
import ar.com.ventas.util.UtilFrame;
import com.itextpdf.text.DocumentException;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Mario
 */
public class FacturasEntreFechasFrame extends javax.swing.JFrame {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat df = new DecimalFormat("#0.00");
    private DecimalFormat dfs = new DecimalFormat("0000");
    private DecimalFormat dfn = new DecimalFormat("00000000");
    private List<Comprobante> comprobantes;
    private List<Mes> meses;

    /**
     * Creates new form FacturasEntreFechasFrame
     */
    public FacturasEntreFechasFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
//        this.setLocationRelativeTo(null);
        setExtendedState(this.MAXIMIZED_BOTH);
        mostrarGeneradasChk.setVisible(false);
        llenarMeses();
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
        deTxt = new javax.swing.JTextField();
        alTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        volverBtn = new javax.swing.JButton();
        generarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        mostrarGeneradasChk = new javax.swing.JCheckBox();
        porFechaRb = new javax.swing.JRadioButton();
        porConsorcioRb = new javax.swing.JRadioButton();
        porNumeroRb = new javax.swing.JRadioButton();
        porTitularRb = new javax.swing.JRadioButton();
        excelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("GENERAR PDF DE FACTURAS");

        jLabel1.setText("DESDE:");

        deTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deTxt.setText("DESDE");
        deTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deTxtKeyPressed(evt);
            }
        });

        alTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        alTxt.setText("HASTA");
        alTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                alTxtKeyPressed(evt);
            }
        });

        jLabel2.setText("HASTA:");

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        generarBtn.setText("Generar PDF");
        generarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarBtnActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CONSORCIO", "RUBRO", "TITULAR", "FECHA", "CUOTA", "NUM.FC", "IMPORTE", "MASTER", "PDF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        mostrarGeneradasChk.setText("Mostrar las generadas");
        mostrarGeneradasChk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mostrarGeneradasChkKeyPressed(evt);
            }
        });

        porFechaRb.setText("Por Fecha");
        porFechaRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porFechaRbActionPerformed(evt);
            }
        });

        porConsorcioRb.setText("Por Consorcio");
        porConsorcioRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porConsorcioRbActionPerformed(evt);
            }
        });

        porNumeroRb.setText("Por Número");
        porNumeroRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porNumeroRbActionPerformed(evt);
            }
        });

        porTitularRb.setText("TitularCuit - Nro Fc");
        porTitularRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porTitularRbActionPerformed(evt);
            }
        });

        excelBtn.setText("Excel");
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(generarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(excelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(porFechaRb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(porConsorcioRb))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(porNumeroRb))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mostrarGeneradasChk)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(porTitularRb)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mostrarGeneradasChk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(porFechaRb)
                    .addComponent(porConsorcioRb)
                    .addComponent(porNumeroRb)
                    .addComponent(porTitularRb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(generarBtn)
                    .addComponent(excelBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = deTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                alTxt.requestFocus();
            } else {
                fe = UtilFrame.fecha(fe);
                deTxt.setText(fe);
            }
        }
    }//GEN-LAST:event_deTxtKeyPressed

    private void alTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = alTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                porFechaRb.setSelected(false);
                porConsorcioRb.setSelected(true);
                porNumeroRb.setSelected(false);
                porTitularRb.setSelected(false);
                ordenConso();
//                llenarTabla();
//                mostrarGeneradasChk.requestFocus();
            } else {
                fe = UtilFrame.fecha(fe);
                alTxt.setText(fe);
            }
        }
    }//GEN-LAST:event_alTxtKeyPressed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void mostrarGeneradasChkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mostrarGeneradasChkKeyPressed
        if (evt.getKeyCode() == 10) {
            llenarTabla();
        }
    }//GEN-LAST:event_mostrarGeneradasChkKeyPressed

    private void generarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarBtnActionPerformed
        int rowCount = tabla.getSelectedRowCount();
        if (rowCount > 1) {
            pdf2(rowCount);
        } else {
            int row = tabla.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN COMPROBANTE PARA GENERAR PDF");
                return;
            }
            Comprobante comprobante = comprobantes.get(row);
            pdf(comprobante);
        }
        JOptionPane.showMessageDialog(this, "PDF GENERADO");
    }//GEN-LAST:event_generarBtnActionPerformed

    private void porFechaRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porFechaRbActionPerformed
        porFechaRb.setSelected(true);
        porConsorcioRb.setSelected(false);
        porNumeroRb.setSelected(false);
        porTitularRb.setSelected(false);
        ordenFecha();
    }//GEN-LAST:event_porFechaRbActionPerformed

    private void porConsorcioRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porConsorcioRbActionPerformed
        porFechaRb.setSelected(false);
        porConsorcioRb.setSelected(true);
        porNumeroRb.setSelected(false);
        porTitularRb.setSelected(false);
        ordenConso();
    }//GEN-LAST:event_porConsorcioRbActionPerformed

    private void porNumeroRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porNumeroRbActionPerformed
        porFechaRb.setSelected(false);
        porConsorcioRb.setSelected(false);
        porNumeroRb.setSelected(true);
        porTitularRb.setSelected(false);
        ordenNumero();
    }//GEN-LAST:event_porNumeroRbActionPerformed

    private void porTitularRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porTitularRbActionPerformed
        porFechaRb.setSelected(false);
        porConsorcioRb.setSelected(false);
        porNumeroRb.setSelected(false);
        porTitularRb.setSelected(true);
        ordenTitular();
    }//GEN-LAST:event_porTitularRbActionPerformed

    private void excelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelBtnActionPerformed
        int rows = tabla.getRowCount();
        if (rows < 1) {
            JOptionPane.showMessageDialog(this, "TABLA VACIA");
            return;
        }
        excel();
    }//GEN-LAST:event_excelBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturasEntreFechasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alTxt;
    private javax.swing.JTextField deTxt;
    private javax.swing.JButton excelBtn;
    private javax.swing.JButton generarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox mostrarGeneradasChk;
    private javax.swing.JRadioButton porConsorcioRb;
    private javax.swing.JRadioButton porFechaRb;
    private javax.swing.JRadioButton porNumeroRb;
    private javax.swing.JRadioButton porTitularRb;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void ordenFecha() {
        UtilFrame.limpiarTabla(tabla);
        Date de = new Date();
        Date al = new Date();
        try {
            de = sdf.parse(deTxt.getText());
            al = sdf.parse(alTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR EN FECHAS");
            return;
        }
        comprobantes = null;
        if (mostrarGeneradasChk.isSelected()) {
            try {
                comprobantes = new ComprobanteService().getComprobantesEntrFechas(de, al);
            } catch (Exception ex) {
                Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                comprobantes = new ComprobanteService().getComprobantesEntreFechasSinPdf(de, al);
            } catch (Exception ex) {
                Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        llenarTabla();
    }

    private void ordenNumero() {
        UtilFrame.limpiarTabla(tabla);
        Date de = new Date();
        Date al = new Date();
        try {
            de = sdf.parse(deTxt.getText());
            al = sdf.parse(alTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR EN FECHAS");
            return;
        }
        comprobantes = null;
//        if (mostrarGeneradasChk.isSelected()) {
        try {
            comprobantes = new ComprobanteService().getComprobantesEntrFechasOrdenNumero(de, al);
        } catch (Exception ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
//        } else {
//            try {
//                comprobantes = new ComprobanteService().getComprobantesEntreFechasSinPdf(de, al);
//            } catch (Exception ex) {
//                Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        llenarTabla();
    }

    private void ordenConso() {
        UtilFrame.limpiarTabla(tabla);
        Date de = new Date();
        Date al = new Date();
        try {
            de = sdf.parse(deTxt.getText());
            al = sdf.parse(alTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR EN FECHAS");
            return;
        }
        comprobantes = null;
//        if (mostrarGeneradasChk.isSelected()) {
        try {
            comprobantes = new ComprobanteService().getComprobantesEntrFechasOrdenConso(de, al);
        } catch (Exception ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
//        } else {
//            try {
//                comprobantes = new ComprobanteService().getComprobantesEntreFechasSinPdf(de, al);
//            } catch (Exception ex) {
//                Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        llenarTabla();
    }

    private void llenarTabla() {
//        tabla = UtilFrame.limpiarTabla(tabla);
        UtilFrame.limpiarTabla(tabla);
        if (comprobantes != null && !comprobantes.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (Comprobante co : comprobantes) {
                Object o[] = new Object[9];
                String cli = co.getCalleNroPisoDtoCliente();
                Integer codigoCliente = co.getCodigoCliente();
                Consorcio conso = null;
                try {
                    conso = new ConsorcioService().getConsorcioByCodigo(codigoCliente);
                } catch (Exception ex) {
                    Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                Rubro ru = co.getRubro();
                o[0] = cli;
                if (co.getRubro() != null) {
                    o[1] = co.getRubro().getDetalle();
                }
                o[2] = co.getRazonSocialTitular();
                o[3] = sdf.format(co.getFecha());
                String cpbte = "ND ";
                if (co.getCodigoComprobante() == 11) {
                    cpbte = "FC ";
                }
                if (co.getCodigoComprobante() == 13) {
                    cpbte = "NC ";
                }
                cpbte += co.getLetra() + " " + dfs.format(co.getSucursal())
                        + "-" + dfn.format(co.getNumero());
                o[5] = cpbte;

                o[6] = df.format(co.getTotal());
                Abono ab = null;
                try {
                    ab = new AbonoService().getUltimoAbonoByConsorcioAndRubro(conso, ru);
                } catch (Exception ex) {
                    Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (ab != null) {
                    if (co.getRubro().getCodigo().equals(2)) {
                        o[4] = co.getCuotasPagadas().toString();
                    }
                    if (co.getRubro().getCodigo().equals(3)) {
                        o[4] = co.getPeriodo();
                    }
                    if (co.getRubro().getCodigo().equals(6)) {
                        o[4] = co.getCuotasPagadas().toString();
                    }
                } else {
                    if (co.getLetra().equals("X")) {
                        o[4] = co.getCuotasPagadas().toString();
                    } else {
                        o[4] = "-";
                    }
                }
                ConsorcioMaster cm = null;
                System.out.println(co.getRubro());
                System.out.println(conso);
                try {
                    cm = new ConsorcioMasterService().getConsorcioMasterByRubroAndConsorcio(co.getRubro(), conso);
                } catch (Exception ex) {
                    //Logger.getLogger(CuentaCorrienteAdministradorFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
//                if (cm != null) {
//                    Integer ma = cm.getMaster();
//                    if (ma.equals(0)) {
//                        o[7] = "M";
//                    } else {
//                        o[7] = "A";
//                    }
//                } else {
//                    o[7] = "M";
//                }
                if (co.getOriginal() != null) {
//                    Integer ma = cm.getMaster();
                    if (co.getOriginal()) {
                        o[7] = "M";
                    } else {
                        o[7] = "A";
                    }
                } else {
                    o[7] = "M";
                }
                //o[6]=co.get;
                if (co.getPdfGenerado()) {
                    o[8] = "SI";
                } else {
                    o[8] = "NO";
                }
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
    }

    private void limpiarCampos() {
        deTxt.setText("");
        alTxt.setText("");
        mostrarGeneradasChk.setSelected(true);
        mostrarGeneradasChk.setVisible(false);
        porFechaRb.setSelected(false);
        porConsorcioRb.setSelected(true);
        porNumeroRb.setSelected(false);
        porTitularRb.setSelected(false);
    }

    private void pdf(Comprobante comprobante) {
        String data = UtilFrame.generaQr(comprobante);
        try {
            if (!comprobante.getCodigoComprobante().equals(5)) {
                UtilFrame.generarQR(data, comprobante.getNumero());
            }
        } catch (Exception ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR EN QR");
            return;
        }
        try {
//            File pdf = new PDFBuilder().armarFactura(comprobante);
            if (!comprobante.getCodigoComprobante().equals(5)) {
                new PDFBuilder().armarFactura(comprobante);
            } else {
                new PDFBuilder().armarReciboX(comprobante);
            }
            //comprobante //
            //DesktopApi.open(pdf);
        } catch (DocumentException ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pdf2(int rowCount) {
        int row[] = tabla.getSelectedRows();
        for (int x = 0; x < rowCount; x++) {
            pdf(comprobantes.get(row[x]));
        }
    }

    private void ordenTitular() {
        UtilFrame.limpiarTabla(tabla);
        Date de = new Date();
        Date al = new Date();
        try {
            de = sdf.parse(deTxt.getText());
            al = sdf.parse(alTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR EN FECHAS");
            return;
        }
        comprobantes = null;
//        if (mostrarGeneradasChk.isSelected()) {
        try {
            comprobantes = new ComprobanteService().getComprobantesEntrFechasOrdenTitular(de, al);
        } catch (Exception ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
//        } else {
//            try {
//                comprobantes = new ComprobanteService().getComprobantesEntreFechasSinPdf(de, al);
//            } catch (Exception ex) {
//                Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        llenarTabla();
    }

    private void llenarMeses() {
        meses = new ArrayList<>();
        for (Mes m : Mes.values()) {
            meses.add(m);
        }
    }

    private void excel() {
        String ruta = "C:/alfa_sistema/data/excel/facturas.xls";
        File archivo = new File(ruta);
        if (archivo.exists()) {
            archivo.delete();
        }
        try {
            archivo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        WritableWorkbook libro = null;
        try {
            libro = Workbook.createWorkbook(archivo);
        } catch (IOException ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        WritableSheet hoja1 = libro.createSheet("FACTURAS", 0);

        try {
            hoja1.addCell(new jxl.write.Label(0, 0, "ALFA SANEAMIENTOS"));
            hoja1.addCell(new jxl.write.Label(0, 1, "CONSORCIO"));
            hoja1.addCell(new jxl.write.Label(1, 1, "RUBRO"));
            hoja1.addCell(new jxl.write.Label(2, 1, "TITULAR"));
            hoja1.addCell(new jxl.write.Label(3, 1, "FECHA"));
            hoja1.addCell(new jxl.write.Label(4, 1, "CUOTA"));
            hoja1.addCell(new jxl.write.Label(5, 1, "NUMERO FACTURA"));
            hoja1.addCell(new jxl.write.Label(6, 1, "IMPORTE"));
            hoja1.addCell(new jxl.write.Label(7, 1, "MASTER"));
            hoja1.addCell(new jxl.write.Label(8, 1, "PDF"));
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            int y = 2;
            int rows = tabla.getRowCount();
            for (int i = 0; i < rows; i++) {
                hoja1.addCell(new jxl.write.Label(0, y, tbl.getValueAt(i, 0).toString()));
                hoja1.addCell(new jxl.write.Label(1, y, tbl.getValueAt(i, 1).toString()));
                hoja1.addCell(new jxl.write.Label(2, y, tbl.getValueAt(i, 2).toString()));
                hoja1.addCell(new jxl.write.Label(3, y, tbl.getValueAt(i, 3).toString()));
                if (tbl.getValueAt(i, 4) != null) {
                    hoja1.addCell(new jxl.write.Label(4, y, tbl.getValueAt(i, 4).toString()));
                } else {
                    hoja1.addCell(new jxl.write.Label(4, y, ""));
                }
                hoja1.addCell(new jxl.write.Label(5, y, tbl.getValueAt(i, 5).toString()));
                if (tbl.getValueAt(i, 6) != " ") {
                    hoja1.addCell(new jxl.write.Number(6, y, Double.valueOf(df.format(Double.valueOf(tbl.getValueAt(i, 6).toString().replace(",", "."))).replace(",", "."))));
                } else {
                    hoja1.addCell(new jxl.write.Label(6, y, ""));
                }
//                hoja1.addCell(new jxl.write.Label(6, y, tbl.getValueAt(i, 6).toString()));
                hoja1.addCell(new jxl.write.Label(7, y, tbl.getValueAt(i, 7).toString()));
                hoja1.addCell(new jxl.write.Label(8, y, tbl.getValueAt(i, 8).toString()));
                y += 1;

            }

        } catch (WriteException ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error configurando Excel");
        }
        try {
            libro.write();
            libro.close();
        } catch (IOException ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: 528");
        } catch (WriteException ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: 529");
        }
        JOptionPane.showMessageDialog(this, "Excel creado correctamente");
    }

}
