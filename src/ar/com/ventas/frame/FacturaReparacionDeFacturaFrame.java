package ar.com.ventas.frame;

import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.ComprobanteRenglones;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.CuentaCorrienteCliente;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ComprobanteRenglonesService;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.services.RubroService;
import ar.com.ventas.services.TitularCuitService;
import ar.com.ventas.util.DesktopApi;
import ar.com.ventas.util.PDFBuilder;
import ar.com.ventas.util.UtilFactura;
import ar.com.ventas.util.UtilFrame;
import com.itextpdf.text.DocumentException;
import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FacturaReparacionDeFacturaFrame extends javax.swing.JFrame {

    private Comprobante comprobante;
    private Date fecha = new Date();
    private List<Consorcio> consorcios;
    private Consorcio consorcio;
    private TitularCuit titular;
    private List<TitularCuit> titulares;
    private DecimalFormat df = new DecimalFormat("#0.00");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private List<Rubro> rubros;
    private List<ComprobanteRenglones> renglones;

    /**
     * @param comprobante
     */
    public FacturaReparacionDeFacturaFrame(Comprobante comprobante) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
        this.comprobante = comprobante;
        limpiarCampos();
        completarFrame();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        calleTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        numeroTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        fechaTxt = new javax.swing.JTextField();
        agregarLineaBtn = new javax.swing.JButton();
        eliminarLineaBtn = new javax.swing.JButton();
        calcularBtn = new javax.swing.JButton();
        totalTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboT = new javax.swing.JComboBox<>();
        volverBtn = new javax.swing.JButton();
        grabarBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        comboR = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        fechaVencimTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        recibo_x_Rb = new javax.swing.JRadioButton();
        facturaRb = new javax.swing.JRadioButton();
        cuotasTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("FACTURA REPARACION");

        jLabel1.setText("Consorcio:");

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

        calleTxt.setText("CALLE");
        calleTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                calleTxtKeyPressed(evt);
            }
        });

        jLabel2.setText("Buscar por Calle:");

        jLabel3.setText("Buscar Por Número:");

        numeroTxt.setText("NUMERO");
        numeroTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numeroTxtKeyPressed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DETALLE", "IMPORTE"
            }
        ));
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(500);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        jLabel4.setText("FECHA:");

        fechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaTxt.setText("FECHA");
        fechaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaTxtKeyPressed(evt);
            }
        });

        agregarLineaBtn.setText("Agregar Línea");
        agregarLineaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarLineaBtnActionPerformed(evt);
            }
        });

        eliminarLineaBtn.setText("Eliminar Línea");
        eliminarLineaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarLineaBtnActionPerformed(evt);
            }
        });

        calcularBtn.setText("Calcular");
        calcularBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularBtnActionPerformed(evt);
            }
        });

        totalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalTxt.setText("TOTAL");

        jLabel5.setText("TITULAR:");

        comboT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        grabarBtn.setText("Grabar");
        grabarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("RUBRO:");

        comboR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRActionPerformed(evt);
            }
        });
        comboR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboRKeyPressed(evt);
            }
        });

        jLabel7.setText("FECHA VENCIM:");

        fechaVencimTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaVencimTxt.setText("F.VENC");
        fechaVencimTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaVencimTxtKeyPressed(evt);
            }
        });

        jLabel8.setText("CUOTA:");

        recibo_x_Rb.setText("Recibo X");
        recibo_x_Rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recibo_x_RbActionPerformed(evt);
            }
        });

        facturaRb.setText("Factura");
        facturaRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaRbActionPerformed(evt);
            }
        });

        cuotasTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cuotasTxt.setText("CU");
        cuotasTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cuotasTxtKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(grabarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(agregarLineaBtn)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(83, 83, 83))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(eliminarLineaBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(recibo_x_Rb)
                                        .addGap(18, 18, 18)
                                        .addComponent(facturaRb)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(calcularBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(calleTxt)
                                                .addComponent(numeroTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(212, 212, 212)
                                                    .addComponent(jLabel4)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(fechaTxt))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel6)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(comboR, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(fechaVencimTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(18, 18, 18)
                                            .addComponent(cuotasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(98, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(calleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(fechaVencimTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(numeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(comboR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cuotasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarLineaBtn)
                    .addComponent(eliminarLineaBtn)
                    .addComponent(calcularBtn)
                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recibo_x_Rb)
                    .addComponent(facturaRb))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(grabarBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calleTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calleTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (calleTxt.getText().isEmpty()) {
                numeroTxt.requestFocus();
            } else {
                buscarPorCalle();
            }
        }
    }//GEN-LAST:event_calleTxtKeyPressed

    private void numeroTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (numeroTxt.getText().isEmpty()) {
                calleTxt.requestFocus();
            } else {
                buscarPorNumero();
            }
        }
    }//GEN-LAST:event_numeroTxtKeyPressed

    private void comboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboKeyPressed
        int row = combo.getSelectedIndex();
        if (row > 0) {
            if (evt.getKeyCode() == 10) {
                consorcio = consorcios.get(row - 1);
                tabla.setEnabled(true);
                agregarLineaBtn.setEnabled(true);
                eliminarLineaBtn.setEnabled(true);
                calcularBtn.setEnabled(true);
                comboR.addFocusListener(null);
                comboR.showPopup();
                comboR.requestFocus();
            }
        }
    }//GEN-LAST:event_comboKeyPressed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        if (evt.getModifiers() == 16) {
            int row = combo.getSelectedIndex();
            if (row > 0) {
                consorcio = consorcios.get(row - 1);
                tabla.setEnabled(true);
                agregarLineaBtn.setEnabled(true);
                eliminarLineaBtn.setEnabled(true);
                calcularBtn.setEnabled(true);
                comboR.addFocusListener(null);
                comboR.showPopup();
                comboR.requestFocus();
            }
        }
    }//GEN-LAST:event_comboActionPerformed

    private void fechaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = fechaTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                if (tabla.isEnabled()) {
//                    tabla = UtilFrame.agregarLinea(tabla);
//                    tabla = UtilFrame.agregarLinea(tabla);
                }
                fechaVencimTxt.requestFocus();
            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            fechaTxt.setText(fe);
        }
    }//GEN-LAST:event_fechaTxtKeyPressed

    private void agregarLineaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarLineaBtnActionPerformed
        if (tabla.isEnabled()) {
            tabla = UtilFrame.agregarLinea(2, tabla);
        }
    }//GEN-LAST:event_agregarLineaBtnActionPerformed

    private void eliminarLineaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarLineaBtnActionPerformed
        int row = tabla.getSelectedRow();
        if (tabla.isEnabled()) {
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA LINEA PARA ELIMINAR");
                return;
            }
            tabla = UtilFrame.eliminarLinea(tabla, row);
        }
    }//GEN-LAST:event_eliminarLineaBtnActionPerformed

    private void calcularBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularBtnActionPerformed
        calcular();
    }//GEN-LAST:event_calcularBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void grabarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarBtnActionPerformed
        if (facturaRb.isSelected()) {
            grabar();
        } else {
            grabar2();
        }
    }//GEN-LAST:event_grabarBtnActionPerformed

    private void comboTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTActionPerformed
        int row = comboT.getSelectedIndex();
        if (row > 0) {
            titular = titulares.get(row - 1);
            grabarBtn.setEnabled(true);
        } else {
            grabarBtn.setEnabled(false);
        }
    }//GEN-LAST:event_comboTActionPerformed

    private void fechaVencimTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaVencimTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = fechaVencimTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                if (tabla.isEnabled()) {
//                    tabla = UtilFrame.agregarLinea(tabla);
//                    tabla = UtilFrame.agregarLinea(tabla);
                }
                cuotasTxt.requestFocus();
            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            fechaVencimTxt.setText(fe);
        }
    }//GEN-LAST:event_fechaVencimTxtKeyPressed

    private void recibo_x_RbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recibo_x_RbActionPerformed
        recibo_x_Rb.setSelected(true);
        facturaRb.setSelected(false);
        comboT.setEditable(false);
    }//GEN-LAST:event_recibo_x_RbActionPerformed

    private void facturaRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaRbActionPerformed
        recibo_x_Rb.setSelected(false);
        facturaRb.setSelected(true);
        comboT.setEditable(true);
    }//GEN-LAST:event_facturaRbActionPerformed

    private void cuotasTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cuotasTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            agregarLineaBtn.requestFocus();
        }
    }//GEN-LAST:event_cuotasTxtKeyPressed

    private void comboRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRActionPerformed
        if (evt.getModifiers() == 16) {
            int rowR = comboR.getSelectedIndex();
            if (rowR > 0) {
                fechaTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_comboRActionPerformed

    private void comboRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboRKeyPressed
        if (evt.getKeyCode() == 10) {
            int rowR = comboR.getSelectedIndex();
            if (rowR > 0) {
                fechaTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_comboRKeyPressed

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
            java.util.logging.Logger.getLogger(FacturaReparacionDeFacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaReparacionDeFacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaReparacionDeFacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaReparacionDeFacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturaReparacionDeFacturaFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarLineaBtn;
    private javax.swing.JButton calcularBtn;
    private javax.swing.JTextField calleTxt;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JComboBox<String> comboR;
    private javax.swing.JComboBox<String> comboT;
    private javax.swing.JTextField cuotasTxt;
    private javax.swing.JButton eliminarLineaBtn;
    private javax.swing.JRadioButton facturaRb;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JTextField fechaVencimTxt;
    private javax.swing.JButton grabarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numeroTxt;
    private javax.swing.JRadioButton recibo_x_Rb;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField totalTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        calleTxt.setText("");
        numeroTxt.setText("");
        fechaTxt.setText("");
        fechaVencimTxt.setText("");
        cuotasTxt.setText("");
        totalTxt.setText("");
        tabla.setEnabled(false);
        agregarLineaBtn.setVisible(false);
        eliminarLineaBtn.setVisible(false);
        grabarBtn.setEnabled(false);
        calcularBtn.setEnabled(true);
        combo.removeAllItems();
        comboT.removeAllItems();
        comboT.addItem("");
        comboR.removeAllItems();
        comboR.addItem("");
        titulares = null;
        facturaRb.setSelected(false);
        recibo_x_Rb.setSelected(false);
        recibo_x_Rb.setVisible(false);
        facturaRb.setSelected(true);
        facturaRb.setVisible(false);
        try {
            titulares = new TitularCuitService().getAllTitularDeCuitActivos();
        } catch (Exception ex) {
            Logger.getLogger(FacturaReparacionDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (titulares != null && !titulares.isEmpty()) {
            for (TitularCuit tc : titulares) {
                comboT.addItem(tc.getPersona().getApellidoNombre());
            }
        }
        rubros = null;
        try {
            rubros = new RubroService().getAllRubrosReparacionesActivos();
        } catch (Exception ex) {
            Logger.getLogger(FacturaReparacionDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (rubros != null && !rubros.isEmpty()) {
            for (Rubro r : rubros) {
                comboR.addItem(r.getDetalle());
            }
        }
        comboT.requestFocus();
    }

    private void buscarPorCalle() {
        consorcios = null;
        combo.removeAllItems();
        combo.addItem("");
        String filtro = calleTxt.getText();
        try {
            consorcios = new ConsorcioService().getAllConsorciosActivosByFiltro(filtro);
        } catch (Exception ex) {
            Logger.getLogger(FacturaReparacionDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (consorcios != null && !consorcios.isEmpty()) {
            for (Consorcio c : consorcios) {
                Domicilio dm = c.getDomicilio();
                combo.addItem(dm.getCalle() + " " + dm.getNumero());
            }
            combo.addFocusListener(null);
            combo.showPopup();
            combo.requestFocus();
        }
    }

    private void buscarPorNumero() {
        combo.removeAllItems();
        combo.addItem("");
        String nro = numeroTxt.getText();
        consorcios = null;
        try {
            consorcios = new ConsorcioService().getAllConsorciosActivosByNumero(nro);
        } catch (Exception ex) {
            Logger.getLogger(FacturaReparacionDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (consorcios != null && !consorcios.isEmpty()) {
            for (Consorcio c : consorcios) {
                Domicilio dm = c.getDomicilio();
                combo.addItem(dm.getCalle() + " " + dm.getNumero());
            }
            combo.addFocusListener(null);
            combo.showPopup();
            combo.requestFocus();
        }
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void calcular() {
        int rows = tabla.getRowCount();
        if (rows < 1) {
            JOptionPane.showMessageDialog(this, "DEBE TENER MINIMO UNA LINEA LA FACTURA");
            return;
        }
        BigDecimal total = new BigDecimal("0.00");
        for (int i = 0; i < rows; i++) {
            if (!tabla.getValueAt(i, 1).toString().isEmpty()) {
                total = total.add(new BigDecimal(tabla.getValueAt(i, 1).toString().replace(",", ".")));
            }
        }
        totalTxt.setText(df.format(total));
        grabarBtn.setEnabled(true);
        if (facturaRb.isSelected()) {
            llenarComboT();
        }
    }

    private void grabar() {
        if (validar()) {
            if (comprobante.getLetra().equals("X")) {
                JOptionPane.showMessageDialog(this, "ERROR EN COMPROBANTE "
                        + comprobante.getCalleNroPisoDtoCliente());
                return;
            }
            if (comprobante.getCuotasPagadas() == null) {
                JOptionPane.showMessageDialog(this, "ERROR EN NRO. CUOTA PARA GENERAR SIGUIENTE"
                        + comprobante.getCalleNroPisoDtoCliente());
                return;
            }
            if (comprobante.getCantidadCuotas() == null) {
                JOptionPane.showMessageDialog(this, "ERROR EN NRO. CUOTA PARA GENERAR SIGUIENTE"
                        + comprobante.getCalleNroPisoDtoCliente());
                return;
            }
            List<ComprobanteRenglones> renglones2 = new ArrayList<>();
            int rows = tabla.getRowCount();
            int row4 = comboR.getSelectedIndex();
            int rowT = comboT.getSelectedIndex();
            Double total = 0.0;
            fecha = new Date();
            Date fechaVencim;
            try {
                fecha = sdf.parse(fechaTxt.getText());
                fechaVencim = sdf.parse(fechaVencimTxt.getText());
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "ERROR EN FECHA");
                return;
            }
            for (int i = 0; i < rows; i++) {
                ComprobanteRenglones rtr = new ComprobanteRenglones();
                rtr.setDetalle(tabla.getValueAt(i, 0).toString());
                BigDecimal db0;
                if (!tabla.getValueAt(i, 1).toString().isEmpty()) {
                    db0 = new BigDecimal(tabla.getValueAt(i, 1).toString().replace(",", "."));
                } else {
                    db0 = new BigDecimal("0.00");
                }
                Double dd = db0.doubleValue();
                rtr.setImporte(dd);
                total += dd;
                renglones2.add(rtr);

            }
            int ps = 3;
            Integer cantidad_cuotas = comprobante.getCantidadCuotas();
            Integer cuots = comprobante.getCuotasPagadas();
            cuots += 1;
            if (cuots.equals(cantidad_cuotas)) {
                comprobante.setCuotaSiguienteFacturada(true);
            } else {
                comprobante.setCuotaSiguienteFacturada(false);
            }
            comprobante.setPeriodoHabilitado(false);
            Comprobante co2 = new Comprobante();
            co2.setCalleNroPisoDtoCliente(comprobante.getCalleNroPisoDtoCliente());
            co2.setCantidadCuotas(comprobante.getCantidadCuotas());
            co2.setCodigoCliente(comprobante.getCodigoCliente());
            co2.setCodigoPostalAndLocalidadCliente(comprobante.getCodigoPostalAndLocalidadCliente());

            co2.setCuitCliente(comprobante.getCuitCliente());
            TitularCuit tc = titulares.get(rowT);
            String cuit = tc.getCuit();
            Domicilio dm = tc.getDomicilio();
            String domicilio_titular = dm.getCalle() + " "
                    + dm.getNumero() + " "
                    + dm.getPisoDto();
            String codigo_localidad = dm.getCodigoPostal() + " "
                    + dm.getLocalidad();
            Date fechaInicioActivi = tc.getFechaInicioActividades();
            co2.setCuitTitular(cuit);
            co2.setCuotasPagadas(cuots);
            co2.setPeriodoHabilitado(false);
            co2.setDomicilioTitular(domicilio_titular);
            co2.setFechaInicioActividades(fechaInicioActivi);
            co2.setCodigoPostalAndLocalidadTitular(codigo_localidad);
            Date fe0 = new Date();
            Date fe1;
            Date fe2;
            Calendar cal = Calendar.getInstance();
            cal.setTime(fe0);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            fe1 = cal.getTime();
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            fe2 = cal.getTime();
            co2.setFechaPeriodoDesde(fe1);
            co2.setFechaPeriodoHasta(fe2);
            co2.setFechaVencimientoPago(fe2);
            co2.setFondo(comprobante.getFondo());
            co2.setGravado(comprobante.getGravado());
            co2.setId_administrador(comprobante.getId_administrador());
            co2.setId_original(0L);
            co2.setIibb(comprobante.getIibb());
            co2.setIva(comprobante.getIva());
            co2.setLetra(comprobante.getLetra());
            co2.setLetraComprobanteAsociado(comprobante.getLetraComprobanteAsociado());
            co2.setOriginal(true);
            co2.setPagado(0.0);
            co2.setPdfGenerado(false);
            co2.setPeriodo("");
            co2.setProductoServicio(comprobante.getProductoServicio());
            co2.setProvinciaCliente(comprobante.getProvinciaCliente());
            co2.setProvinciaTitular(tc.getDomicilio().getProvincia());
            co2.setRazonSocialCliente(comprobante.getRazonSocialCliente());
            co2.setRazonSocialTitular(tc.getPersona().getApellidoNombre());
            co2.setRubro(comprobante.getRubro());
            co2.setSucursal(tc.getSucursal());
            co2.setSucursalComprobanteAsociado(0);
            co2.setTipoComprobanteAsociado(0);
            co2.setTipoDocumento(comprobante.getTipoDocumento());
            co2.setTexto1("");
            co2.setTexto2("");
            co2.setTipoEmision(comprobante.getTipoEmision());
            co2.setTipoInscripcion(comprobante.getTipoInscripcion());
            co2.setTotal(comprobante.getTotal());
            Integer codigoCliente = comprobante.getCodigoCliente();
            Consorcio consorcio;
            try {
                consorcio = new ConsorcioService().getConsorcioByCodigo(codigoCliente);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ERROR CUIT CONSORCIO"
                        + comprobante.getCalleNroPisoDtoCliente());
                return;
            }
            Double saldo = consorcio.getSaldo();
            saldo += comprobante.getTotal();
            CuentaCorrienteCliente ccc = new CuentaCorrienteCliente();
            ccc.setComprobante(co2);
            ccc.setConsorcio(consorcio);
            ccc.setDebe(comprobante.getTotal());
            ccc.setHaber(0.0);
            ccc.setFecha(new Date());
            ccc.setSaldo(saldo);
            ccc.setTipoComprobante(11);
            consorcio.setSaldo(saldo);
            int prs = 3;
            String resultado = UtilFactura.saveFacturaReparacion2(consorcio, titular,
                    renglones2, total, rubros.get(row4 - 1), fecha, fechaVencim,
                    prs, cantidad_cuotas, cuots, co2, comprobante, ccc);
            if (resultado.equals("A")) {
                JOptionPane.showMessageDialog(this, "COMPROBANTE REGISTRADO CORRECTAMENTE");
            } else {
                JOptionPane.showMessageDialog(this, "ERROR REGISTRANDO COMPROBANTE");
            }
            volver();
        }
    }

    private void llenarComboT() {

        if (titulares != null && !titulares.isEmpty()) {

            comboT.addFocusListener(null);
            comboT.showPopup();
            comboT.requestFocus();
        }
    }

    private boolean validar() {
//        int row1 = combo.getSelectedIndex();
        int row2 = comboT.getSelectedIndex();
        int row3 = tabla.getRowCount();
        int row4 = comboR.getSelectedIndex();
//        if (row1 < 1) {
//            JOptionPane.showMessageDialog(this, "ERROR DEBE ELEGIR UN CONSORCIO PARA EMITIR FACTURA");
//            combo.requestFocus();
//            return false;
//        }
        if (row2 < 1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN TITULAR DE CUIT PARA EMITIR FACTURA");
            comboT.requestFocus();
            return false;
        }
        if (row3 < 1) {
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR UN TEXTO PARA EMITIR FACTURA");
            tabla.requestFocus();
            return false;
        }
        if (row4 < 1) {
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR UN RUBRO PARA EMITIR FACTURA");
            tabla.requestFocus();
            return false;
        }
        if (fechaTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR UNA FECHA PARA EMITIR FACTURA");
            fechaTxt.requestFocus();
            return false;
        }
        if (fechaVencimTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DEBE INGRESAR UN VENCIMIENTO PARA EMITIR FACTURA");
            fechaVencimTxt.requestFocus();
            return false;
        }
        return true;
    }

//    private void crearPdf(NuevoCae nuevo, TitularCuit titular, Consorcio consorcio, Double gravado, Double iva, Double total, List<RenglonTrabajoReparacion> renglones, Integer cuotas) {
//        Integer numeroFactura = nuevo.getNumero();
//        Long cae = nuevo.getCae();
//        Date fechaCae = nuevo.getFechaVencimiento();
//        Date fecha = nuevo.getFecha();
//        try {
//            File pdf = new PDFBuilder().armarFacturaC(titular,
//                        consorcio, tabla, iv.getNumero(), nuevoCae, total);
////armarFacturaC(titular,
////                    consorcio, tabla, numeroFactura, cae,
////                    fechaCae, total, fecha);
//            DesktopApi.open(pdf);
//        } catch (DocumentException ex) {
//            Logger.getLogger(FacturaReparacionFrame.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(this, "ERROR 647");
//        } catch (Exception ex) {
//            Logger.getLogger(FacturaReparacionFrame.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(this, "ERROR 650");
//        }
//        volver();
//    }
//    private void generarPdf(NuevoCae nuevoCae, IvaVentas iv) {
//        cae = nuevoCae.getCae();
//        fechaCae = nuevoCae.getFechaVencimiento();
//        fecha = nuevoCae.getFecha();
//        String a = nuevoCae.getEstado();
//        if (a.equals("A")) {
//            aprobado = true;
//        } else {
//            aprobado = false;
//        }
//        String data = UtilFrame.crearQr(titular, consorcio, iv);
//        if (aprobado) {
//            try {
//                File pdf = new PDFBuilder().armarFacturaC(titular,
//                        consorcio, tabla, iv.getNumero(), nuevoCae, total);
//                iv.setPdfGenerado(true);
//                new IvaVentasService().updateIvaVentas(iv);
//                DesktopApi.open(pdf);
//            } catch (DocumentException ex) {
//                Logger.getLogger(FacturaReparacionFrame.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(this, "ERROR 531");
//            } catch (Exception ex) {
//                Logger.getLogger(FacturaReparacionFrame.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(this, "ERROR 534");
//            }
////            volver();
//        } else {
//            JOptionPane.showMessageDialog(this, "COMPROBANTE NO APROBADO POR AFIP");
////            return;
//        }
//    }
    private void grabar2() {

    }

    private void completarFrame() {
        fechaTxt.setText(sdf.format(fecha));
        fechaVencimTxt.setText(UtilFrame.getFechaFinMes(sdf.format(fecha)));
        Integer codigo = comprobante.getCodigoCliente();
        consorcio = null;
        try {
            consorcio = new ConsorcioService().getConsorcioByCodigo(codigo);
        } catch (Exception ex) {
            Logger.getLogger(FacturaReparacionDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Integer rowC = 1;
        combo.addItem("");
        Domicilio dm = consorcio.getDomicilio();
        String calle = dm.getCalle();
        String numero = dm.getNumero();
        combo.addItem(calle + " " + numero);
        combo.setSelectedIndex(rowC);

        Integer cuota = comprobante.getCuotasPagadas() + 1;

        cuotasTxt.setText(cuota.toString());
        renglones = null;

        try {
            renglones = new ComprobanteRenglonesService().getRenglonesPorComprobante(comprobante);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR EN RENGLONES");
            return;
        }

//        System.out.println(renglones);
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
        if (renglones
                != null && !renglones.isEmpty()) {
            for (ComprobanteRenglones cr : renglones) {
                Object o[] = new Object[2];
                o[0] = cr.getDetalle();
                o[1] = df.format(cr.getImporte());
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
        Rubro ru = comprobante.getRubro();
        int rowR = 1;
        for (Rubro r_u : rubros) {
            if (r_u.getId().equals(ru.getId())) {
                comboR.setSelectedIndex(rowR);
            }
            rowR += 1;
        }

    }
}
