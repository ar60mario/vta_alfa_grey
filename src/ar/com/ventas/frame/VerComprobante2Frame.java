/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.Recibo;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.services.ComprobanteRenglonesService;
import ar.com.ventas.util.UtilFrame;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author argia
 */
public class VerComprobante2Frame extends javax.swing.JFrame {

    private Recibo recibo;
    private Consorcio co;
    private Date de;
    private Date al;
    private DecimalFormat df = new DecimalFormat("#0.00");
    private DecimalFormat dfs = new DecimalFormat("0000");
    private DecimalFormat dfn = new DecimalFormat("00000000");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form VerComprobanteFrame
     */
    public VerComprobante2Frame(Recibo recibo, Consorcio co, Date de, Date al) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(this.MAXIMIZED_BOTH);
        this.recibo = recibo;
        this.co = co;
        this.de = de;
        this.al = al;
        llenarFrame();
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
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        administradorTxt = new javax.swing.JTextField();
        consorcioTxt = new javax.swing.JTextField();
        fechaTxt = new javax.swing.JTextField();
        volverBtn = new javax.swing.JButton();
        totalTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        numFacturaTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("RECIBO");

        jLabel1.setText("FECHA:");

        jLabel2.setText("CONSORCIO:");

        jLabel5.setText("ADMINISTRADOR:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DETALLE", "IMPORTE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(300);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        jLabel6.setText("TOTAL:");

        administradorTxt.setText("ADMINISTRADOR");

        consorcioTxt.setText("CONSORCIO");

        fechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaTxt.setText("FECHA");

        volverBtn.setText("VOLVER");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        totalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalTxt.setText("TOTAL");

        jLabel10.setText("NUMERO:");

        numFacturaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numFacturaTxt.setText("NUM.FACTURA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(administradorTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                            .addComponent(consorcioTxt)
                            .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(numFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(consorcioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(numFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(administradorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(volverBtn)
                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VerComprobante2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerComprobante2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerComprobante2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerComprobante2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerComprobante2Frame(null, null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField administradorTxt;
    private javax.swing.JTextField consorcioTxt;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numFacturaTxt;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField totalTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarFrame() {
        Domicilio dm = co.getDomicilio();
        String calle = dm.getCalle() + " " + dm.getNumero();
//        String rubro = recibo.getRubro().getDetalle();
//        String titular = comprobante.getRazonSocialTitular();
        String adm = co.getAdministrador().getNombreAdministrador();
//        if (comprobante.getPeriodo() != null) {
//            periodoTxt.setText(comprobante.getPeriodo());
//        } else {
//            periodoTxt.setText("");
//        }
        UtilFrame.limpiarTabla(tabla);
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
        Object o[] = new Object[2];
        o[0] = recibo.getReferencia();
        o[1]= df.format(recibo.getImporte());
        tbl.addRow(o);
        tabla.setModel(tbl);
        String nf = recibo.getNumero().toString();
//        List<ComprobanteRenglones> renglones = null;
//        try {
//            renglones = new ComprobanteRenglonesService().getRenglonesPorComprobante(comprobante);
//        } catch (Exception ex) {
//            Logger.getLogger(VerComprobante2Frame.class.getName()).log(Level.SEVERE, null, ex);
//        }
        fechaTxt.setText(sdf.format(recibo.getFecha()));
        consorcioTxt.setText(calle);
//        rubroTxt.setText(rubro);
//        titularTxt.setText(titular);
        administradorTxt.setText(adm);
        totalTxt.setText(df.format(recibo.getImporte()));
//        cuotaTxt.setText(comprobante.getCuotasPagadas().toString());
//        cuotasTxt.setText(comprobante.getCantidadCuotas().toString());
        numFacturaTxt.setText(nf);
//        if (renglones != null && !renglones.isEmpty()) {
//            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
//            for (ComprobanteRenglones cr : renglones) {
//                Object o[] = new Object[2];
//                o[0] = cr.getDetalle();
//                o[1] = df.format(cr.getImporte());
//                tbl.addRow(o);
//            }
//            tabla.setModel(tbl);
//        }
    }

    private void volver() {
        CuentaCorrienteClienteFrame cccf = new CuentaCorrienteClienteFrame(co, de, al);
        cccf.setVisible(true);
        this.dispose();
    }
}
