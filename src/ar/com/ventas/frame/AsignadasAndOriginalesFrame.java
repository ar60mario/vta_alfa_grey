/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.AdministradorService;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.util.UtilFrame;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author argia
 */
public class AsignadasAndOriginalesFrame extends javax.swing.JFrame {

    private List<Comprobante> comprobantes;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat df = new DecimalFormat("#0.00");
    private Boolean filtradas = false;

    /**
     * Creates new form AsignadasAndOriginalesFrame
     */
    public AsignadasAndOriginalesFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(6); // this.MAXIMIZED_BOTH
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

        volverBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        numeroTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        buscarBtn = new javax.swing.JButton();
        convertirOriginalBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("COMPROBANTES ASIGNADOS Y ORIGINALES");

        volverBtn.setText("VOLVER");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("NÚMERO COMPROBANTE:");

        numeroTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
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
                "FECHA", "CONSORCIO", "CUIT", "TIPO-NRO", "IMPORTE", "ADMINISTRADOR", "TITULAR", "O/A"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        buscarBtn.setText("BUSCAR");
        buscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBtnActionPerformed(evt);
            }
        });

        convertirOriginalBtn.setText("CONVERTIR A ORIGINAL");
        convertirOriginalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertirOriginalBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buscarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(convertirOriginalBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(numeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(numeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(buscarBtn)
                    .addComponent(convertirOriginalBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        buscar();
    }//GEN-LAST:event_buscarBtnActionPerformed

    private void numeroTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!numeroTxt.getText().isEmpty()) {
                buscarCmpbtePorNumero();
            }
        }
    }//GEN-LAST:event_numeroTxtKeyPressed

    private void convertirOriginalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertirOriginalBtnActionPerformed
        convertirOriginal();
    }//GEN-LAST:event_convertirOriginalBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AsignadasAndOriginalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignadasAndOriginalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignadasAndOriginalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignadasAndOriginalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsignadasAndOriginalesFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarBtn;
    private javax.swing.JButton convertirOriginalBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numeroTxt;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        numeroTxt.setText("");
    }

    private void buscarCmpbtePorNumero() {
        Integer nroFc = Integer.valueOf(numeroTxt.getText());
        comprobantes = null;
        UtilFrame.limpiarTabla(tabla);
        try {
            comprobantes = new ComprobanteService().getAllComprobantesByNro(nroFc);
        } catch (Exception ex) {
            Logger.getLogger(AsignadasAndOriginalesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        llenarTabla();

    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void buscar() {
        int row = tabla.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONE UN COMPROBANTE PARA BUSCAR");
            return;
        }
        Comprobante comprob = comprobantes.get(row);
        if (comprob.getOriginal() != null) {
            comprobantes = null;
            Long ide;
            if (comprob.getOriginal()) {
                ide = comprob.getId();
            } else {
                ide = comprob.getId_original();
            }
            try {
                comprobantes = new ComprobanteService().getAllComprobantesAsignadosPorIdOriginal(ide);
            } catch (Exception ex) {
                Logger.getLogger(AsignadasAndOriginalesFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        filtradas = true;
        llenarTabla();
    }

    private void llenarTabla() {
        UtilFrame.limpiarTabla(tabla);
        if (comprobantes != null && !comprobantes.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (Comprobante co : comprobantes) {
                String adm = "";
                if (co.getId_administrador() != null) {
                    Long id_adm = co.getId_administrador();
                    Administrador admi = null;
                    try {
                        admi = new AdministradorService().getAdministradorById(id_adm);
                    } catch (Exception ex) {
                        Logger.getLogger(AsignadasAndOriginalesFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (admi != null) {
                        adm = admi.getNombreAdministrador();
                    }
                }
                Object o[] = new Object[8];
                o[0] = sdf.format(co.getFecha());
                o[1] = co.getCalleNroPisoDtoCliente();
                o[2] = co.getCuitCliente();
                o[3] = co.getLetra() + " " + co.getNumero().toString();
                o[4] = df.format(co.getTotal());
                o[5] = adm;
                if (co.getRazonSocialTitular() != null) {
                    o[6] = co.getRazonSocialTitular();
                }
                if (co.getOriginal() != null) {
                    if (co.getOriginal()) {
                        o[7] = "ORG";
                    } else {
                        o[7] = "ASG";
                    }
                } else {
                    o[7] = "X";
                }
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
    }

    private void convertirOriginal() {
        int row = tabla.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONE UN COMPROBANTE PARA CONVERTIR EN ORIGINAL");
            return;
        }
        if (filtradas) {
            Comprobante compr = comprobantes.get(row);
            if (compr.getOriginal() != null) {
                if (compr.getOriginal()) {
                    JOptionPane.showMessageDialog(this, "YA ES ORIGINAL");
                    return;
                }
                Long nuevoId = compr.getId();
                for (Comprobante com : comprobantes) {
                    com.setOriginal(false);
                    com.setId_original(nuevoId);
                }
                compr.setOriginal(true);
                compr.setId_original(0L);
                try {
                    new ComprobanteService().updateListaComprobantes(comprobantes);
                    JOptionPane.showMessageDialog(this, "COMPROBANTES ACTUALIZADOS");
                } catch (Exception ex) {
                    Logger.getLogger(AsignadasAndOriginalesFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "ERROR");
                    return;
                }
                volver();
            }
        } else {
            JOptionPane.showMessageDialog(this, "PRIMERO DEBE BUSCAR PARA FILTRAR COMPROBANTES");
        }
    }
}