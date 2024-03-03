/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Abono;
import ar.com.ventas.entities.AbonoPendiente;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.util.UtilFrame;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class RenovarAndReasignarAbonoFrame extends javax.swing.JFrame {

    private AbonoPendiente ap;
    private DecimalFormat df = new DecimalFormat("#0.00");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private List<Comprobante> comprobantes;
    private Abono abono;
    private Rubro rubro;

    /**
     * Creates new form RenovarAndReasignarAbonoFrame
     *
     * @param ap
     */
    public RenovarAndReasignarAbonoFrame(AbonoPendiente ap) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(6); // this.MAXIMIZED_BOTH
        this.ap = ap;
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
        consorcioTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        importeAnteriorTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        importeNuevoTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        rubroTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        deTxt = new javax.swing.JTextField();
        alTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        asignarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("RENOVAR Y REASIGNAR ABONOS");

        jLabel1.setText("CONSORCIO:");

        consorcioTxt.setText("CONSORCIO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ABONO FINALIZADO");

        importeAnteriorTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeAnteriorTxt.setText("ANTERIOR");

        jLabel3.setText("IMPORTE NUEVO:");

        jLabel4.setText("IMPORTE ANTERIOR:");

        importeNuevoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeNuevoTxt.setText("NUEVO");
        importeNuevoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                importeNuevoTxtKeyPressed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CONSORCIO", "CUOTA", "CUOTAS", "IMPORTE", "TITULAR CUIT", "M"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel5.setText("RUBRO:");

        rubroTxt.setText("RUBRO");

        jLabel6.setText("DE:");

        deTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deTxt.setText("DE");
        deTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deTxtKeyPressed(evt);
            }
        });

        alTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        alTxt.setText("AL");
        alTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                alTxtKeyPressed(evt);
            }
        });

        jLabel7.setText("HASTA:");

        jLabel8.setText("<<< FECHA FACTURAS");

        asignarBtn.setText("ASIGNAR");
        asignarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarBtnActionPerformed(evt);
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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(consorcioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(importeAnteriorTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(importeNuevoTxt))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(rubroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)))))
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(asignarBtn)
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
                    .addComponent(consorcioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importeAnteriorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(rubroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(importeNuevoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asignarBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = alTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                buscar();
            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            alTxt.setText(fe);
        }
    }//GEN-LAST:event_alTxtKeyPressed

    private void deTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = deTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                alTxt.requestFocus();
            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            deTxt.setText(fe);
        }
    }//GEN-LAST:event_deTxtKeyPressed

    private void importeNuevoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importeNuevoTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!importeNuevoTxt.getText().isEmpty()) {
                deTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_importeNuevoTxtKeyPressed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void asignarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarBtnActionPerformed
        int row = tabla.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN CONSORCIO PARA REASIGNAR");
            return;
        }
        asignar(row);
    }//GEN-LAST:event_asignarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(RenovarAndReasignarAbonoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RenovarAndReasignarAbonoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RenovarAndReasignarAbonoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RenovarAndReasignarAbonoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RenovarAndReasignarAbonoFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alTxt;
    private javax.swing.JButton asignarBtn;
    private javax.swing.JTextField consorcioTxt;
    private javax.swing.JTextField deTxt;
    private javax.swing.JTextField importeAnteriorTxt;
    private javax.swing.JTextField importeNuevoTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField rubroTxt;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla() {

        if (comprobantes != null && !comprobantes.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (Comprobante co : comprobantes) {
                Integer codigo = co.getCodigoCliente();
                Consorcio consorcio = null;
                try {
                    consorcio = new ConsorcioService().getConsorcioByCodigo(codigo);
                } catch (Exception ex) {
                    Logger.getLogger(RenovarAndReasignarAbonoFrame.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                Domicilio dm = consorcio.getDomicilio();
                String calle = dm.getCalle() + " " + dm.getNumero();
                /*
                Consorcio consorcio = abono.getConsorcio();
        
        
        Rubro rubro = abono.getRubro();
        Administrador admin = consorcio.getAdministrador();
                 */
                Object o[] = new Object[6];
                o[0] = calle;
                o[1] = co.getCuotasPagadas().toString();
                o[2] = co.getCantidadCuotas().toString();
                o[3] = df.format(co.getTotal());
                o[4] = co.getRazonSocialTitular();
                if (co.getOriginal() != null) {
                    if (co.getOriginal()) {
                        o[5] = "ORIG";
                    } else {
                        o[5] = "ASIG";
                    }
                } else {
                    o[5] = "";
                }
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
    }

    private void cargarFrame() {
        abono = ap.getAbono();
        rubro = abono.getRubro();
        Consorcio consorcio = abono.getConsorcio();
        Domicilio dm = consorcio.getDomicilio();
        String calle = dm.getCalle() + " " + dm.getNumero();
        consorcioTxt.setText(calle);
        rubroTxt.setText(rubro.getDetalle());
        BigDecimal importe = new BigDecimal(df.format(abono.getImporte()).replace(",", "."));
        BigDecimal ctas = new BigDecimal(abono.getCuotas().toString());
        BigDecimal resu = importe.divide(ctas);
        Double resultado = resu.doubleValue();
        importeAnteriorTxt.setText(df.format(resultado));
        importeNuevoTxt.setText("");
        deTxt.setText("");
        alTxt.setText("");
        importeNuevoTxt.requestFocus();
    }

    private void buscar() {
        UtilFrame.limpiarTabla(tabla);
        comprobantes = null;
        Date de;
        Date al;
        try {
            de = sdf.parse(deTxt.getText());
            al = sdf.parse(alTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(RenovarAndReasignarAbonoFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        BigDecimal bd_imp = new BigDecimal(df.format(ap.getAbono().getImporte()).replace(",", "."));
        BigDecimal bd_cuo = new BigDecimal(ap.getAbono().getCuotas().toString());
        BigDecimal bd_tt = bd_imp.divide(bd_cuo);
        Double impo = Double.valueOf(importeNuevoTxt.getText());
        Integer cuot = 1;
        try {
            comprobantes = new ComprobanteService()
                    .getComprobEntrFechasIgualImporteIgualCuotaIgualRubro(de, al, impo, cuot, rubro);
        } catch (Exception ex) {
            Logger.getLogger(RenovarAndReasignarAbonoFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        System.out.println(comprobantes);
//        System.exit(0);
        llenarTabla();
    }

    private void volver() {
        AbonosPendientesFacturarFrame apff = new AbonosPendientesFacturarFrame();
        apff.setVisible(true);
        this.dispose();
    }

    private void asignar(int row) {
        Comprobante comp = comprobantes.get(row);
        
    }
}
