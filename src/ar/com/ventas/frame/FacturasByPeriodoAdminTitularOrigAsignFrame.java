package ar.com.ventas.frame;

import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.AdministradorService;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.util.UtilFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
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
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class FacturasByPeriodoAdminTitularOrigAsignFrame extends javax.swing.JFrame {

    private List<Comprobante> facturas;
    private List<Comprobante> comprobantes;
    private JPanel contentPanel;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private final DecimalFormat df = new DecimalFormat("#,##0.00");

    public FacturasByPeriodoAdminTitularOrigAsignFrame() {
        initComponents();
        limpiarCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        deTxt = new javax.swing.JTextField();
        alTxt = new javax.swing.JTextField();
        excelBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("FACTURAS ENTRE PERIODOS POR ADMIN - TITULAR - RUBRO -ORIG Y ASIG");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Consorcio", "Administrador", "Rubro", "Titular", "Fecha", "Cuota", "Cant.ctas.", "Nro.Fc", "Importe", "O/A"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel1.setText("Desde:");

        jLabel2.setText("Hasta:");

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

        excelBtn.setText("Excel");
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(excelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(excelBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            desde();
        }
    }//GEN-LAST:event_deTxtKeyPressed

    private void alTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            hasta();
        }
    }//GEN-LAST:event_alTxtKeyPressed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void excelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelBtnActionPerformed
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
            java.util.logging.Logger.getLogger(FacturasByPeriodoAdminTitularOrigAsignFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturasByPeriodoAdminTitularOrigAsignFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturasByPeriodoAdminTitularOrigAsignFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturasByPeriodoAdminTitularOrigAsignFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturasByPeriodoAdminTitularOrigAsignFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alTxt;
    private javax.swing.JTextField deTxt;
    private javax.swing.JButton excelBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        UtilFrame.limpiarTabla(tabla);
        JFrame jFrame = FacturasByPeriodoAdminTitularOrigAsignFrame.this;
        contentPanel = panel;
        contentPanel.setBackground(new java.awt.Color(Constantes.getR(),
                Constantes.getG(), Constantes.getB()));
        jFrame.setLocationRelativeTo(null);
        jFrame.setExtendedState(this.MAXIMIZED_BOTH);
        String str0 = "INFORMES"; // + " " + str1;
        contentPanel.setBorder(new EmptyBorder(5, 5, 100, 5));
        contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),
                str0, TitledBorder.LEFT, TitledBorder.BELOW_BOTTOM));
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jFrame.setTitle("FACTURAS ENTRE PERIODOS POR ADMIN - TITULAR - RUBRO -ORIG Y ASIG");
        setContentPane(contentPanel);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                volver();
            }
        });
        deTxt.setText("");
        alTxt.setText("");
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void desde() {
        String fe = deTxt.getText();
        int largo = fe.length();
        if (largo == 10) {
            alTxt.requestFocus();
        } else {
            fe = UtilFrame.fecha(fe);
            deTxt.setText(fe);
        }
    }

    private void hasta() {
        String fe = alTxt.getText();
        int largo = fe.length();
        if (largo == 10) {
            buscar();
        } else {
            fe = UtilFrame.fecha(fe);
            alTxt.setText(fe);
        }
    }

    private void buscar() {
        UtilFrame.limpiarTabla(tabla);
        Date de;
        Date al;
        comprobantes = null;
        try {
            de = sdf.parse(deTxt.getText());
            al = sdf.parse(alTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(FacturasByPeriodoAdminTitularOrigAsignFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR EN FECHAS");
            return;
        }
        try {
            comprobantes = new ComprobanteService().getComprobantesEntreFechasOrdrConsorcio(de, al);
        } catch (Exception ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR EN COMPROBANTES");
            return;
        }
        llenarTabla();
    }

    private void llenarTabla() {
        UtilFrame.limpiarTabla(tabla);
        if (comprobantes != null && !comprobantes.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (Comprobante c : comprobantes) {
                String original;
                if (c.getOriginal()) {
                    original = "O";
                } else {
                    original = "A";
                }
                Long id_admin = c.getId_administrador();
                Administrador admin;
                try {
                    admin = new AdministradorService().getAdministradorById(id_admin);
                } catch (Exception ex) {
                    Logger.getLogger(FacturasByPeriodoAdminTitularOrigAsignFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "ERROR Nro. 317 - ADMINISTRADOR");
                    return;
                }
                String nombreAdmin = admin.getRazonSocial() + " "
                        + admin.getNombreAdministrador();
                String comprob = c.getLetra() + " "
                        + c.getSucursal().toString() + " "
                        + c.getNumero().toString();
                Integer cuotas = 0;
                Integer cuota = 0;
                if (c.getRubro().getCodigo().equals(1)) {
                    if (c.getCantidadCuotas() > 1) {
                        cuota = c.getCuotasPagadas();
                        cuotas = c.getCantidadCuotas();
                    }
                }
                if (c.getRubro().getCodigo().equals(2)) {
                    if (c.getCantidadCuotas() > 1) {
                        cuota = c.getCuotasPagadas();
                        cuotas = c.getCantidadCuotas();
                    }
                }
                if (c.getRubro().getCodigo().equals(6)) {
                    if (c.getCantidadCuotas() > 1) {
                        cuota = c.getCuotasPagadas();
                        cuotas = c.getCantidadCuotas();
                    }
                }
                if (c.getRubro().getCodigo().equals(9)) {
                    if (c.getCantidadCuotas() > 1) {
                        cuota = c.getCuotasPagadas();
                        cuotas = c.getCantidadCuotas();
                    }
                }
                Object o[] = new Object[10];
                o[0] = c.getCalleNroPisoDtoCliente();
                o[1] = nombreAdmin;
                o[2] = c.getRubro().getDetalle();
                o[3] = c.getRazonSocialTitular();
                o[4] = sdf.format(c.getFecha());
                o[5] = cuota;
                o[6] = cuotas;
                o[7] = comprob;
                o[8] = df.format(c.getTotal());
                o[9] = original;
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
    }

    private void excel() {
        String ruta = "C:/alfa_sistema/data/excel/fc_x_periodo.xls";
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
            hoja1.addCell(new jxl.write.Label(1, 1, "ADMINISTRADOR"));
            hoja1.addCell(new jxl.write.Label(2, 1, "RUBRO"));
            hoja1.addCell(new jxl.write.Label(3, 1, "TITULAR"));
            hoja1.addCell(new jxl.write.Label(4, 1, "FECHA"));
            hoja1.addCell(new jxl.write.Label(5, 1, "CUOTA"));
            hoja1.addCell(new jxl.write.Label(6, 1, "CANTIDAD DE CUOTAS"));
            hoja1.addCell(new jxl.write.Label(7, 1, "NUMERO FACTURA"));
            hoja1.addCell(new jxl.write.Label(8, 1, "IMPORTE"));
            hoja1.addCell(new jxl.write.Label(9, 1, "O/A"));
            int y = 2;
            for (Comprobante c : comprobantes) {
                String original;
                if (c.getOriginal()) {
                    original = "O";
                } else {
                    original = "A";
                }
                Long id_admin = c.getId_administrador();
                Administrador admin;
                try {
                    admin = new AdministradorService().getAdministradorById(id_admin);
                } catch (Exception ex) {
                    Logger.getLogger(FacturasByPeriodoAdminTitularOrigAsignFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "ERROR Nro. 317 - ADMINISTRADOR");
                    return;
                }
                String nombreAdmin = admin.getRazonSocial() + " "
                        + admin.getNombreAdministrador();
                String comprob = c.getLetra() + " "
                        + c.getSucursal().toString() + " "
                        + c.getNumero().toString();
                Integer cuotas = 0;
                Integer cuota = 0;
                if (c.getRubro().getCodigo().equals(1)) {
                    if (c.getCantidadCuotas() > 1) {
                        cuota = c.getCuotasPagadas();
                        cuotas = c.getCantidadCuotas();
                    }
                }
                if (c.getRubro().getCodigo().equals(2)) {
                    if (c.getCantidadCuotas() > 1) {
                        cuota = c.getCuotasPagadas();
                        cuotas = c.getCantidadCuotas();
                    }
                }
                if (c.getRubro().getCodigo().equals(6)) {
                    if (c.getCantidadCuotas() > 1) {
                        cuota = c.getCuotasPagadas();
                        cuotas = c.getCantidadCuotas();
                    }
                }
                if (c.getRubro().getCodigo().equals(9)) {
                    if (c.getCantidadCuotas() > 1) {
                        cuota = c.getCuotasPagadas();
                        cuotas = c.getCantidadCuotas();
                    }
                }
                Double newTotal = UtilFrame.redondearDouble(c.getTotal());
                hoja1.addCell(new jxl.write.Label(0, y, c.getCalleNroPisoDtoCliente()));
                hoja1.addCell(new jxl.write.Label(1, y, nombreAdmin));
                hoja1.addCell(new jxl.write.Label(2, y, c.getRubro().getDetalle()));
                hoja1.addCell(new jxl.write.Label(3, y, c.getRazonSocialTitular()));
                hoja1.addCell(new jxl.write.Label(4, y, sdf.format(c.getFecha())));
                hoja1.addCell(new jxl.write.Number(5, y, cuota));
                hoja1.addCell(new jxl.write.Number(6, y, cuotas));
                hoja1.addCell(new jxl.write.Label(7, y, comprob));
                hoja1.addCell(new jxl.write.Number(8, y, newTotal));
                hoja1.addCell(new jxl.write.Label(9, y, original));
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
            JOptionPane.showMessageDialog(this, "Error: 473");
        } catch (WriteException ex) {
            Logger.getLogger(FacturasEntreFechasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: 474");
        }
        JOptionPane.showMessageDialog(this, "Excel creado correctamente");
    }
}
