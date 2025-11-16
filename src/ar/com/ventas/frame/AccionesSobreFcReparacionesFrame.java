package ar.com.ventas.frame;

import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.RubroService;
import ar.com.ventas.util.UtilFrame;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class AccionesSobreFcReparacionesFrame extends javax.swing.JFrame {

    private List<Rubro> rubros;
    private List<Comprobante> comprobantes;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat df = new DecimalFormat("$#,##0.00");
    private JPanel contentPanel;

    public AccionesSobreFcReparacionesFrame() {
        initComponents();
        limpiarCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        deTxt = new javax.swing.JTextField();
        alTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        volverBtn = new javax.swing.JButton();
        terminarBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        numeroTxt = new javax.swing.JTextField();
        modificarBtn = new javax.swing.JButton();
        habilitarBtn = new javax.swing.JButton();
        cerrarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ACCIONES SOBRE COMPROBANTES DE REPARACIONES");

        jLabel1.setText("Desde:");

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

        jLabel2.setText("Hasta:");

        jLabel3.setText("Rubro:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboKeyPressed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Número", "Domicilio", "Importe", "Cuota", "Cuotas", "Habilitado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
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
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(10);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(300);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(10);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(5);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(5);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(10);
        }

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        terminarBtn.setText("Terminar");
        terminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Cuota nro.:");

        numeroTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numeroTxt.setText("NRO");
        numeroTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numeroTxtKeyPressed(evt);
            }
        });

        modificarBtn.setText("Modificar");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });
        modificarBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                modificarBtnKeyPressed(evt);
            }
        });

        habilitarBtn.setText("Habilitar");
        habilitarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarBtnActionPerformed(evt);
            }
        });

        cerrarBtn.setText("Cerrar");
        cerrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(terminarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(habilitarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(cerrarBtn)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modificarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(terminarBtn)
                    .addComponent(jLabel4)
                    .addComponent(numeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificarBtn)
                    .addComponent(habilitarBtn)
                    .addComponent(cerrarBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
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
                combo.addFocusListener(null);
                combo.showPopup();
                combo.requestFocus();
            } else {
                fe = UtilFrame.fecha(fe);
                alTxt.setText(fe);
            }
        }
    }//GEN-LAST:event_alTxtKeyPressed

    private void comboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboKeyPressed
        int row = combo.getSelectedIndex();
        if (row > 0) {
            if (evt.getKeyCode() == 10) {
                Rubro rubro = rubros.get(row - 1);
                cargarComprobantesBy(rubro);
            }
        }
    }//GEN-LAST:event_comboKeyPressed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void terminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarBtnActionPerformed
        int row = tabla.getSelectedRow();
        if (row >= 0) {
            try {
                Comprobante co = comprobantes.get(row);
                co.setCuotasPagadas(co.getCantidadCuotas());
                co.setPeriodoHabilitado(false);
                co.setCuotaSiguienteFacturada(true);
                new ComprobanteService().updateComprobante(co);
                llenarTabla();
            } catch (Exception ex) {
                Logger.getLogger(AccionesSobreFcReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro. 267 - COMPROBANTE");
            }
        }
    }//GEN-LAST:event_terminarBtnActionPerformed

    private void numeroTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (numeroTxt.getText().isEmpty()) {
                modificarBtn.requestFocus();
            }
        }
    }//GEN-LAST:event_numeroTxtKeyPressed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        int row = tabla.getSelectedRow();
        if (row >= 0) {
            try {
                Comprobante co = comprobantes.get(row);
                Integer numero = Integer.valueOf(numeroTxt.getText());
                co.setCuotasPagadas(numero);
                co.setPeriodoHabilitado(true);
                co.setCuotaSiguienteFacturada(false);
                new ComprobanteService().updateComprobante(co);
                llenarTabla();
            } catch (Exception ex) {
                Logger.getLogger(AccionesSobreFcReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro. 267 - COMPROBANTE");
            }
        }
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void modificarBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modificarBtnKeyPressed
        int row = tabla.getSelectedRow();
        if (row >= 0) {
            if (evt.getKeyCode() == 10) {
                try {
                    Comprobante co = comprobantes.get(row);
                    Integer numero = Integer.valueOf(numeroTxt.getText());
                    co.setCuotasPagadas(numero);
                    co.setPeriodoHabilitado(true);
                    co.setCuotaSiguienteFacturada(false);
                    new ComprobanteService().updateComprobante(co);
                    llenarTabla();
                } catch (Exception ex) {
                    Logger.getLogger(AccionesSobreFcReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "ERROR Nro. 267 - COMPROBANTE");
                }
            }
        }
    }//GEN-LAST:event_modificarBtnKeyPressed

    private void habilitarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habilitarBtnActionPerformed
        int row = tabla.getSelectedRow();
        if (row >= 0) {
            Comprobante co = comprobantes.get(row);
            co.setPeriodoHabilitado(true);
            try {
                new ComprobanteService().updateComprobante(co);
                llenarTabla();
            } catch (Exception ex) {
                Logger.getLogger(AccionesSobreFcReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro. 267 - COMPROBANTE");
            }
        }
    }//GEN-LAST:event_habilitarBtnActionPerformed

    private void cerrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarBtnActionPerformed
        int row = tabla.getSelectedRow();
        if (row >= 0) {
            Comprobante co = comprobantes.get(row);
            co.setPeriodoHabilitado(false);
            try {
                new ComprobanteService().updateComprobante(co);
                llenarTabla();
            } catch (Exception ex) {
                Logger.getLogger(AccionesSobreFcReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro. 267 - COMPROBANTE");
            }
        }
    }//GEN-LAST:event_cerrarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AccionesSobreFcReparacionesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccionesSobreFcReparacionesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccionesSobreFcReparacionesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccionesSobreFcReparacionesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccionesSobreFcReparacionesFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alTxt;
    private javax.swing.JButton cerrarBtn;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField deTxt;
    private javax.swing.JButton habilitarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JTextField numeroTxt;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tabla;
    private javax.swing.JButton terminarBtn;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        contentPanel = panel;
        contentPanel.setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        JFrame jFrame = AccionesSobreFcReparacionesFrame.this;
        jFrame.setLocationRelativeTo(null);
        String str0 = "ALFA";
        contentPanel.setBorder(new EmptyBorder(5, 5, 100, 5));
        contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),
                str0, TitledBorder.LEFT, TitledBorder.BELOW_BOTTOM));
        jFrame.setDefaultCloseOperation(3);
        setContentPane(contentPanel);

        deTxt.setText("");
        alTxt.setText("");
        numeroTxt.setText("");
        UtilFrame.limpiarTabla(tabla);
        rubros = null;
        try {
            rubros = new RubroService().getAllRubrosReparacionesActivos();
        } catch (Exception ex) {
            Logger.getLogger(AccionesSobreFcReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR Nro. 208 - RUBROS");
            return;
        }
        combo.removeAllItems();
        combo.addItem("");
        if (rubros != null && !rubros.isEmpty()) {
            for (Rubro r : rubros) {
                combo.addItem(r.getDetalle());
            }
        }
    }

    private void cargarComprobantesBy(Rubro rubro) {
        Date de = new Date();
        Date al = new Date();
        try {
            de = sdf.parse(deTxt.getText());
            al = sdf.parse(alTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(AccionesSobreFcReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR Nro. 247 - FECHAS");
            return;
        }
        comprobantes = null;
        try {
            comprobantes = new ComprobanteService().getComprobantesEntrFechasAndRubro(de, al, rubro);
        } catch (Exception ex) {
            Logger.getLogger(AccionesSobreFcReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR Nro. 256 - COMPROBANTES");
            return;
        }
        llenarTabla();
    }

    private void llenarTabla() {
        UtilFrame.limpiarTabla(tabla);
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
        for (Comprobante co : comprobantes) {
            Object o[] = new Object[7];
            o[0] = sdf.format(co.getFecha());
            o[1] = co.getNumero();
            o[2] = co.getCalleNroPisoDtoCliente();
            o[3] = df.format(co.getTotal());
            o[4] = co.getCuotasPagadas();
            o[5] = co.getCantidadCuotas();
            if (co.getPeriodoHabilitado()) {
                o[6] = "Habilitado";
            } else {
                o[6] = "Cerrado";
            }
            tbl.addRow(o);
        }
        tabla.setModel(tbl);
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }
}
