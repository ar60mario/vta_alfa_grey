/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.TitularCuitService;
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
public class VentasPorTitularFrame extends javax.swing.JFrame {

    private List<TitularCuit> titulares;
    private List<Comprobante> comprobantes;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat df = new DecimalFormat("#0.00");

    /**
     * Creates new form VentasPorConsorcioFrame
     */
    public VentasPorTitularFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(this.MAXIMIZED_BOTH);
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
        combo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        volverBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        deTxt = new javax.swing.JTextField();
        alTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        excelBtn = new javax.swing.JButton();
        todosChk = new javax.swing.JCheckBox();
        actualizarBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("VENTAS POR TITULAR DE CUIT ENTRE FECHAS");

        jLabel1.setText("TITULAR:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID.CMPR", "FECHA", "NUMERO", "RUBRO", "IMPORTE", "ORIG", "ID.ORG"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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

        jLabel2.setText("DESDE FECHA:");

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

        jLabel3.setText("HASTA FECHA:");

        excelBtn.setText("EXCEL");
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelBtnActionPerformed(evt);
            }
        });

        todosChk.setText("TODOS");

        actualizarBtn.setText("ACTUALIZAR");
        actualizarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("ORIGINAL:");

        idTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idTxt.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(excelBtn)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(actualizarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(todosChk)))
                        .addGap(0, 286, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(todosChk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(excelBtn)
                    .addComponent(actualizarBtn)
                    .addComponent(jLabel4)
                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        int row = combo.getSelectedIndex();
        if (row > 0) {
            TitularCuit titular = titulares.get(row - 1);
            buscarTitular(titular);
        }
    }//GEN-LAST:event_comboActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

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
                combo.addFocusListener(null);
                combo.showPopup();
                combo.requestFocus();
            }
            fe = UtilFrame.fecha(fe);
            alTxt.setText(fe);
        }
    }//GEN-LAST:event_alTxtKeyPressed

    private void excelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelBtnActionPerformed
        excel();
    }//GEN-LAST:event_excelBtnActionPerformed

    private void actualizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarBtnActionPerformed
        int row = tabla.getSelectedRow();
        int rowCount = tabla.getSelectedRowCount();
        if (rowCount > 1) {
            JOptionPane.showMessageDialog(this, "SELECCIONE SOLO UNA FACTURA");
            return;
        }
        asignar(row);
        idTxt.setText("");
    }//GEN-LAST:event_actualizarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(VentasPorTitularFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentasPorTitularFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentasPorTitularFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentasPorTitularFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentasPorTitularFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarBtn;
    private javax.swing.JTextField alTxt;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField deTxt;
    private javax.swing.JButton excelBtn;
    private javax.swing.JTextField idTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JCheckBox todosChk;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarCombo() {
        deTxt.setText("");
        alTxt.setText("");
        idTxt.setText("");
        combo.removeAllItems();
        combo.addItem("");
        titulares = null;
        try {
            titulares = new TitularCuitService().getAllTitularDeCuitActivos();
        } catch (Exception ex) {
            Logger.getLogger(VentasPorTitularFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (titulares != null && !titulares.isEmpty()) {
            for (TitularCuit tc : titulares) {
                String nombre = tc.getPersona().getApellidoNombre();
                combo.addItem(nombre);
            }
        }
    }

    private void buscarTitular(TitularCuit titular) {
        Date de = new Date();
        Date al = new Date();
        try {
            de = sdf.parse(deTxt.getText());
            al = sdf.parse(alTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(VentasPorTitularFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR UNA FECHA VALIDA");
            return;
        }
        comprobantes = null;
        try {
            if (todosChk.isSelected()) {
                comprobantes = new ComprobanteService().getComprobantesEntrFechasByTitular(titular, de, al);
            } else {
                comprobantes = new ComprobanteService().getComprobantesOriginalEntrFechasByTitular(titular, de, al);
            }
        } catch (Exception ex) {
            Logger.getLogger(VentasPorTitularFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        cargarTabla();

    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void excel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void asignar(int row) {
        Comprobante co = comprobantes.get(row);
        Long idC = Long.valueOf(idTxt.getText());
        co.setOriginal(false);
        co.setId_original(idC);
        try {
            new ComprobanteService().updateComprobante(co);
        } catch (Exception ex) {
            Logger.getLogger(VentasPorTitularFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        comprobantes.remove(row);
        cargarTabla();
    }

    private void cargarTabla() {
        UtilFrame.limpiarTabla(tabla);
        Double totalTi = 0.0;
        if (comprobantes != null && !comprobantes.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (Comprobante co : comprobantes) {
                Object o[] = new Object[7];
                o[0] = co.getId();
                o[1] = sdf.format(co.getFecha());
                o[2] = co.getNumero();
                o[3] = co.getRubro().getDetalle();
                o[4] = df.format(co.getTotal());
                String og;
                Long lg;
                if (co.getOriginal() != null) {
                    if (co.getOriginal()) {
                        og = "ORIG";
                        lg = 0L;
                    } else {
                        og = "ASIG";
                        lg = co.getId_original();
                    }
                } else {
                    og = "";
                    lg = 0L;
                }
                o[5] = og;
                o[6] = lg;
                totalTi += co.getTotal();
                tbl.addRow(o);
            }
            Object o[] = new Object[5];
            o[1] = "TOTAL >>>";
            o[4] = df.format(totalTi);
            tbl.addRow(o);
            tabla.setModel(tbl);
        }
    }
}
