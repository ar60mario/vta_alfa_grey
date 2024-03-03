/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.CuentaCorrienteCliente;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.Recibo;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.services.CuentaCorrienteClienteService;
import ar.com.ventas.util.UtilFrame;
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
public class CuentaCorrienteClienteFrame extends javax.swing.JFrame {

    private List<Consorcio> consorcios;
    private DecimalFormat df = new DecimalFormat("#0.00");
    private DecimalFormat dfs = new DecimalFormat("0000");
    private DecimalFormat dfn = new DecimalFormat("00000000");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private List<CuentaCorrienteCliente> ccc = null;
    private Date de;
    private Date al;
    private Consorcio co;

    /**
     * Creates new form CuentaCorrienteClienteFrame
     *
     * @param co
     * @param de
     * @param al
     */
    public CuentaCorrienteClienteFrame(Consorcio co, Date de, Date al) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(this.MAXIMIZED_BOTH);
        if (co == null) {
            limpiarCampos();
        } else {
            this.co = co;
            this.de = de;
            this.al = al;
            llenarCampos();
        }
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
        filtroTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        saldoTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        deTxt = new javax.swing.JTextField();
        alTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        volverBtn = new javax.swing.JButton();
        excelBtn = new javax.swing.JButton();
        verCpbteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CUENTA CORRIENTE POR CONSORCIO");

        jLabel1.setText("CONSORCIO:");

        filtroTxt.setText("FILTRO");
        filtroTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filtroTxtKeyPressed(evt);
            }
        });

        jLabel2.setText("FILTRO:");

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

        jLabel3.setText("SALDO:");

        saldoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        saldoTxt.setText("SALDO");

        jLabel4.setText("DESDE:");

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

        jLabel5.setText("HASTA:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FECHA", "COMPROBANTE", "DEBE", "HABER", "SALDO", "ORG/ASG", "RUBRO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        excelBtn.setText("Excel");
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelBtnActionPerformed(evt);
            }
        });

        verCpbteBtn.setText("Ver Cpbte");
        verCpbteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCpbteBtnActionPerformed(evt);
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
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(filtroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(saldoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 365, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(excelBtn)
                        .addGap(18, 18, 18)
                        .addComponent(verCpbteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(saldoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(excelBtn)
                    .addComponent(verCpbteBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filtroTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!filtroTxt.getText().isEmpty()) {
                llenarCombo();
            }
        }
    }//GEN-LAST:event_filtroTxtKeyPressed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        if (evt.getModifiers() == 16) {
            int row = combo.getSelectedIndex();
            if (row > 0) {
                datosConsorcio(row);
            }
        }
    }//GEN-LAST:event_comboActionPerformed

    private void comboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboKeyPressed
        if (evt.getKeyCode() == 10) {
            int row = combo.getSelectedIndex();
            if (row > 0) {
                datosConsorcio(row);
            }
        }
    }//GEN-LAST:event_comboKeyPressed

    private void deTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = deTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                alTxt.requestFocus();
            }
            fe = UtilFrame.fecha(fe);
            deTxt.setText(fe);
        }

    }//GEN-LAST:event_deTxtKeyPressed

    private void alTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = alTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                llenarTabla();
            }
            fe = UtilFrame.fecha(fe);
            alTxt.setText(fe);
        }
    }//GEN-LAST:event_alTxtKeyPressed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void excelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelBtnActionPerformed
        excel();
    }//GEN-LAST:event_excelBtnActionPerformed

    private void verCpbteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCpbteBtnActionPerformed
        verCpbte();
    }//GEN-LAST:event_verCpbteBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CuentaCorrienteClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CuentaCorrienteClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CuentaCorrienteClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CuentaCorrienteClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CuentaCorrienteClienteFrame(null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alTxt;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField deTxt;
    private javax.swing.JButton excelBtn;
    private javax.swing.JTextField filtroTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField saldoTxt;
    private javax.swing.JTable tabla;
    private javax.swing.JButton verCpbteBtn;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        filtroTxt.setText("");
        saldoTxt.setText("");
        deTxt.setText("");
        alTxt.setText("");
        combo.removeAllItems();
        combo.addItem("");
    }

    private void llenarCombo() {
        String filtro = filtroTxt.getText();
        consorcios = null;
        try {
            consorcios = new ConsorcioService().getAllConsorciosActivosByFiltro(filtro);
        } catch (Exception ex) {
            Logger.getLogger(CuentaCorrienteClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        combo.removeAllItems();
        combo.addItem("");
        if (consorcios != null && !consorcios.isEmpty()) {
            for (Consorcio co : consorcios) {
                Domicilio dm = co.getDomicilio();
                String cons = dm.getCalle() + " " + dm.getNumero();
                combo.addItem(cons);
            }
            combo.addFocusListener(null);
            combo.showPopup();
            combo.requestFocus();
        }
    }

    private void datosConsorcio(int row) {
        Consorcio consorcio = consorcios.get(row - 1);
        if (consorcio.getSaldo() != null) {
            saldoTxt.setText(df.format(consorcio.getSaldo()));
//            System.out.println(consorcio.getSaldo());
//            System.out.println(consorcio.getDomicilio().getCalle());
//            System.exit(0);
        } else {
            saldoTxt.setText("0.00");
        }
        UtilFrame.limpiarTabla(tabla);
        deTxt.requestFocus();
    }

    private void llenarTabla() {
        int row = combo.getSelectedIndex();
        de = new Date();
        al = new Date();
        try {
            de = sdf.parse(deTxt.getText());
            al = sdf.parse(alTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(CuentaCorrienteClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (row > 0) {
            Consorcio consorcio = consorcios.get(row - 1);
            co = consorcio;
            UtilFrame.limpiarTabla(tabla);
            if (consorcio.getSaldo() != null) {
                saldoTxt.setText(df.format(consorcio.getSaldo()));
            } else {
                saldoTxt.setText("0.00");
            }
            ccc = null;
            try {
                ccc = new CuentaCorrienteClienteService().getCuentaCorrienteClienteByClienteEntreFechas(consorcio, de, al);
            } catch (Exception ex) {
                Logger.getLogger(CuentaCorrienteClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (ccc != null && !ccc.isEmpty()) {
                DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
                for (CuentaCorrienteCliente cc : ccc) {
                    Object o[] = new Object[7];
                    o[0] = sdf.format(cc.getFecha());
                    int tipo = cc.getTipoComprobante();
                    String cpbte = "RC ";
                    if (tipo == 11) {
                        cpbte = "FC ";
                    }
                    if (tipo == 13) {
                        cpbte = "NC ";
                    }
                    if (tipo == 11) {
                        cpbte += cc.getComprobante().getLetra() + " "
                                + dfs.format(cc.getComprobante().getSucursal()) + "-"
                                + dfn.format(cc.getComprobante().getNumero());
                        Rubro ru = cc.getComprobante().getRubro();
                        if (cc.getComprobante().getOriginal() != null) {
                            if (cc.getComprobante().getOriginal()) {
                                o[5] = "ORG";
                            } else {
                                o[5] = "ASG";
                            }
                            o[6] = ru.getDetalle();
                        }
                    }
                    if(tipo == 14){
                        cpbte += cc.getRecibo().getReferencia();
                    }
                    if(tipo == 13){
                        cpbte += cc.getComprobante().getLetra() + " "
                                + dfs.format(cc.getComprobante().getSucursal()) + "-"
                                + dfn.format(cc.getComprobante().getNumero());
                    }
                    o[1] = cpbte;
                    o[2] = df.format(cc.getDebe());
                    o[3] = df.format(cc.getHaber());
                    o[4] = df.format(cc.getSaldo());

                    tbl.addRow(o);
                }
                tabla.setModel(tbl);
            }
        }
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

//    private void ingresarCobranza() {
//        int row = combo.getSelectedIndex();
//        if (row > 0) {
//            Consorcio consorcio = consorcios.get(row - 1);
//            Date fecha = new Date();
//            try {
//                fecha = sdf.parse(fechaPagoTxt.getText());
//            } catch (ParseException ex) {
//                Logger.getLogger(CuentaCorrienteClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(this, "ERROR EN LA FECHA");
//                return;
//            }
//            Double impt;
//            try {
//                impt = Double.valueOf(importeAbonadoTxt.getText().replace(",", "."));
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(this, "ERROR EN IMPORTE");
//                return;
//            }
//            int v = UtilFrame.asignarPagoToConsorcio(consorcio, fecha, impt);
//            if (v == 1) {
//                importeAbonadoTxt.setText("");
//                fechaPagoTxt.setText("");
//                volverBtn.requestFocus();
//                JOptionPane.showMessageDialog(this, "RECIBO GUARDADO CORRECTAMENTE");
//                llenarTabla();
//                return;
//            }
//            JOptionPane.showMessageDialog(this, "ERROR GUARDANDO RECIBO");
//        }
//    }
    private void excel() {

    }

    private void verCpbte() {
        int row = tabla.getSelectedRow();
        int rows = tabla.getSelectedRowCount();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONES UN COMPROBANTE PARA VER");
            return;
        }
        if (rows > 1) {
            JOptionPane.showMessageDialog(this, "SELECCIONES SOLAMENTE UN COMPROBANTE PARA VER");
            return;
        }
        CuentaCorrienteCliente cc = ccc.get(row);
        Integer tipo = cc.getTipoComprobante();
        if (tipo.equals(11)) {
            Comprobante c = ccc.get(row).getComprobante();
            VerComprobanteFrame vcf = new VerComprobanteFrame(c, co, de, al);
            vcf.setVisible(true);
            this.dispose();
        }
        if (tipo.equals(13)) {
            Comprobante c = ccc.get(row).getComprobante();
            VerComprobante3Frame vcf = new VerComprobante3Frame(c, co, de, al);
            vcf.setVisible(true);
            this.dispose();
        }
        if (tipo.equals(14)){
            Recibo r = cc.getRecibo();
            VerComprobante2Frame vcf = new VerComprobante2Frame(r, co, de, al);
            vcf.setVisible(true);
            this.dispose();
        }
    }

    private void llenarCampos() {
        filtroTxt.setText("");
        saldoTxt.setText(df.format(co.getSaldo()));
        deTxt.setText(sdf.format(de));
        alTxt.setText(sdf.format(al));
        combo.removeAllItems();
        combo.addItem("");
        consorcios = null;
        try {
            consorcios = new ConsorcioService().getAllConsorciosActivos();
        } catch (Exception ex) {
            Logger.getLogger(CuentaCorrienteClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (consorcios != null && !consorcios.isEmpty()) {
            int pos = 0;
            Long id1 = co.getId();
            int r = 1;
            for (Consorcio c : consorcios) {
                Long id2 = c.getId();
                if (id1.equals(id2)) {
                    pos = r;
                }
                r += 1;
                Domicilio dm = c.getDomicilio();
                String calle = dm.getCalle() + " " + dm.getNumero();
                combo.addItem(calle);
            }
            combo.setSelectedIndex(pos);
            llenarTabla();
            filtroTxt.requestFocus();
        }
    }
}
