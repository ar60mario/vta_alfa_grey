/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.AdministradorService;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.util.LectorDeExcel;
import ar.com.ventas.util.UtilFrame;
import ar.com.ventas.util.UtilTablaConsorcios;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Mario
 */
public class AbmConsorcioFrame extends javax.swing.JFrame {

    private List<Consorcio> consorcios;
    private List<Administrador> administradores;
    private Boolean filtro = true;

    /**
     * Creates new form AbmConsorcioFrame
     */
    public AbmConsorcioFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(this.MAXIMIZED_BOTH);
        limpiarCampos();
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        nuevoBtn = new javax.swing.JButton();
        modificarBtn = new javax.swing.JButton();
        inactivosBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        exportarExcelBtn = new javax.swing.JButton();
        importarExcelBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        numeroTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboA = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ABM CONSORCIOS");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "NOMBRE", "CUIT", "TELEFONO CONSEJO", "ADMINISTRADOR", "ENCARGADO", "TELEFONO ENCARGADO"
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
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        nuevoBtn.setText("Nuevo");
        nuevoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoBtnActionPerformed(evt);
            }
        });

        modificarBtn.setText("Modificar");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });

        inactivosBtn.setText("Consorcios Inactivos");
        inactivosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactivosBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre a Buscar:");

        nombreTxt.setText("NOMBRE");
        nombreTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreTxtKeyPressed(evt);
            }
        });

        exportarExcelBtn.setText("Exportar a Excel");
        exportarExcelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarExcelBtnActionPerformed(evt);
            }
        });

        importarExcelBtn.setText("Inportar de Excel");
        importarExcelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarExcelBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Numero a Buscar:");

        numeroTxt.setText("NUMERO");
        numeroTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numeroTxtKeyPressed(evt);
            }
        });

        jLabel3.setText("Filtrar Administrador:");

        comboA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1071, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nuevoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(modificarBtn)
                        .addGap(47, 47, 47)
                        .addComponent(inactivosBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exportarExcelBtn)
                        .addGap(18, 18, 18)
                        .addComponent(importarExcelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(comboA, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(numeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(comboA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevoBtn)
                    .addComponent(modificarBtn)
                    .addComponent(inactivosBtn)
                    .addComponent(volverBtn)
                    .addComponent(exportarExcelBtn)
                    .addComponent(importarExcelBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoBtnActionPerformed
        nuevo();
    }//GEN-LAST:event_nuevoBtnActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        modificar();
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void inactivosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inactivosBtnActionPerformed
        inactivos();
    }//GEN-LAST:event_inactivosBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void nombreTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (nombreTxt.getText().isEmpty()) {
                filtro = true;
                numeroTxt.requestFocus();
            } else {
                filtro = false;
                llenarTabla();
            }
        }
    }//GEN-LAST:event_nombreTxtKeyPressed

    private void exportarExcelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarExcelBtnActionPerformed
        exportar();
    }//GEN-LAST:event_exportarExcelBtnActionPerformed

    private void importarExcelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarExcelBtnActionPerformed
        importar();
    }//GEN-LAST:event_importarExcelBtnActionPerformed

    private void comboAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAActionPerformed
        int rowA = comboA.getSelectedIndex();
        if (rowA > 0) {
            limpiarCampos();
            llenarTablaAdmin(rowA);
        }
    }//GEN-LAST:event_comboAActionPerformed

    private void numeroTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (numeroTxt.getText().isEmpty()) {
                filtro = true;
                nombreTxt.requestFocus();
            } else {
                filtro = false;
                llenarTabla2();
            }
        }
    }//GEN-LAST:event_numeroTxtKeyPressed

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
            java.util.logging.Logger.getLogger(AbmConsorcioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbmConsorcioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbmConsorcioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbmConsorcioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbmConsorcioFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboA;
    private javax.swing.JButton exportarExcelBtn;
    private javax.swing.JButton importarExcelBtn;
    private javax.swing.JButton inactivosBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JButton nuevoBtn;
    private javax.swing.JTextField numeroTxt;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla() {
        UtilFrame.limpiarTabla(tabla);
        administradores = null;
        try {
            administradores = new AdministradorService().getAllAdministradoresActivos();
        } catch (Exception ex) {
            Logger.getLogger(AbmConsorcioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        comboA.removeAllItems();
        comboA.addItem("");
        if (administradores != null && !administradores.isEmpty()) {
            for (Administrador ad : administradores) {
                comboA.addItem(ad.getRazonSocial());
            }
        }
        consorcios = null;
        if (filtro) {
            try {
                consorcios = new ConsorcioService().getAllConsorciosActivos();
            } catch (Exception ex) {
                Logger.getLogger(AbmConsorcioFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            String texto = nombreTxt.getText();
            try {
                consorcios = new ConsorcioService().getAllConsorciosActivosByFiltro(texto);
            } catch (Exception ex) {
                Logger.getLogger(AbmConsorcioFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fillTable(consorcios);
//        if (consorcios != null && !consorcios.isEmpty()) {
//            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
//            for (Consorcio consorcio : consorcios) {
//                Object o[] = new Object[7];
//                o[0] = consorcio.getNombre() + " "
//                        + consorcio.getDomicilio().getCalle() + " "
//                        + consorcio.getDomicilio().getNumero();
//                o[1] = consorcio.getCuit();
//                o[2] = consorcio.getTelefonoConsejo();
//                o[3] = consorcio.getAdministrador().getRazonSocial();
//                o[4] = consorcio.getEncargado();
//                o[5] = consorcio.getTelefonoEncargado();
//                if (consorcio.getActivo()) {
//                    o[6] = "ACTIVO";
//                } else {
//                    o[6] = "INACTIVO";
//                }
//                tbl.addRow(o);
//            }
//            tabla.setModel(tbl);
//        }
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void inactivos() {
        ConsorciosInactivosFrame cif = new ConsorciosInactivosFrame();
        cif.setVisible(true);
        this.dispose();
    }

    private void modificar() {
        int row = tabla.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNO PARA MODIFICAR");
            return;
        }
        Consorcio co = consorcios.get(row);
        ModificarConsorcioFrame mcf = new ModificarConsorcioFrame(co);
        mcf.setVisible(true);
        this.dispose();
    }

    private void nuevo() {
        NuevoConsorcioFrame ncf = new NuevoConsorcioFrame();
        ncf.setVisible(true);
        this.dispose();
    }

    private void exportar() {
        String rutaArchivo = "c:/alfa_systema/informes/consorcios.xls";
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
        consorcios = null;
        try {
            consorcios = new ConsorcioService().getAllConsorciosActivos();
        } catch (Exception ex) {
            Logger.getLogger(AbmConsorcioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (consorcios != null && !consorcios.isEmpty()) {
            try {
                archivo.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(AbmConsorcioFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            WritableWorkbook libro = null;
            try {
                libro = Workbook.createWorkbook(archivo);
            } catch (IOException ex) {
                Logger.getLogger(AbmConsorcioFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            WritableSheet hoja1 = libro.createSheet("Consorcios Activos", 0);
            try {
                hoja1.addCell(new jxl.write.Label(0, 0, "ALFA"));
                hoja1.addCell(new jxl.write.Label(0, 1, "ID"));
                hoja1.addCell(new jxl.write.Label(1, 1, "RAZON SOCIAL"));
                hoja1.addCell(new jxl.write.Label(2, 1, "CALLE"));
                hoja1.addCell(new jxl.write.Label(3, 1, "NUMERO"));
                hoja1.addCell(new jxl.write.Label(4, 1, "CUIT"));
                int y = 2;
                int rows = consorcios.size();
                for (int i = 0; i < rows; i++) {
                    hoja1.addCell(new jxl.write.Label(0, y, consorcios.get(i).getId().toString()));
                    hoja1.addCell(new jxl.write.Label(1, y, consorcios.get(i).getNombre()));
                    hoja1.addCell(new jxl.write.Label(2, y,
                            consorcios.get(i).getDomicilio().getCalle()));
                    hoja1.addCell(new jxl.write.Label(3, y, consorcios.get(i).getDomicilio().getNumero()));
                    hoja1.addCell(new jxl.write.Label(4, y, consorcios.get(i).getCuit()));
                    y += 1;
                }
            } catch (WriteException ex) {
                Logger.getLogger(AbmConsorcioFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error configurando Excel");
            }
            try {
                libro.write();
                libro.close();
            } catch (IOException ex) {
                Logger.getLogger(AbmConsorcioFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error: 313");
            } catch (WriteException ex) {
                Logger.getLogger(AbmConsorcioFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error: 314");
            }
            JOptionPane.showMessageDialog(this, "Excel creado correctamente");
            llenarTabla();
        }
    }

    private void importar() {
        JFileChooser selector = new JFileChooser();
        selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        if (archivo != null) {
            try {
                LectorDeExcel.leerConsorcios(archivo);
            } catch (BiffException ex) {
                Logger.getLogger(AbmConsorcioFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(AbmConsorcioFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void llenarTablaAdmin(int r) {
        UtilFrame.limpiarTabla(tabla);

        Administrador administrador = administradores.get(r - 1);
        consorcios = null;
        try {
            consorcios = new ConsorcioService().getAllConsorciosActivosByAdministrador(administrador);
        } catch (Exception ex) {
            Logger.getLogger(AbmConsorcioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        fillTable(consorcios);
//        if (consorcios != null && !consorcios.isEmpty()) {
//            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
//            
//            for (Consorcio consorcio : consorcios) {
//                Integer cod = consorcio.getCodigo();
//                Object o[] = new Object[8];
//                o[0]=cod;
//                o[1] = consorcio.getNombre() + " "
//                        + consorcio.getDomicilio().getCalle() + " "
//                        + consorcio.getDomicilio().getNumero();
//                o[2]=consorcio.getCuit();
//                o[3] = consorcio.getTelefonoConsejo();
//                o[4] = consorcio.getAdministrador().getRazonSocial();
//                o[5] = consorcio.getEncargado();
//                o[6] = consorcio.getTelefonoEncargado();
//                System.out.println(consorcio.getMaster());
//                System.exit(0);
//                if (consorcio.getMaster().equals(0)) {
//                    
//                    
//                    o[7] = "MASTER";
//                } else {
//                    o[7] = "ASIGNADO";
//                }
//                tbl.addRow(o);
//            }
//            tabla.setModel(tbl);
//        }
    }

    private void limpiarCampos() {
        nombreTxt.setText("");
        numeroTxt.setText("");
    }

    private void llenarTabla2() {
        UtilFrame.limpiarTabla(tabla);
        nombreTxt.setText("");
        comboA.setSelectedIndex(0);
        String numero = numeroTxt.getText();
        try {
            consorcios = new ConsorcioService().getAllConsorciosActivosByNumero(numero);
        } catch (Exception ex) {
            Logger.getLogger(AbmConsorcioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        fillTable(consorcios);
    }

    private void fillTable(List<Consorcio> consorcios2) {
        if (consorcios2 != null && !consorcios2.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
//            UtilTablaConsorcios utc = new UtilTablaConsorcios();
//            tabla.setDefaultRenderer(tabla.getColumnClass(0), utc);
            for (Consorcio consorcio : consorcios2) {
                
                Object o[] = new Object[7];
                o[0] = consorcio.getCodigo();
                o[1] = consorcio.getNombre() + " "
                        + consorcio.getDomicilio().getCalle() + " "
                        + consorcio.getDomicilio().getNumero();
                o[2] = consorcio.getCuit();
                o[3] = consorcio.getTelefonoConsejo();
                o[4] = consorcio.getAdministrador().getRazonSocial();
                o[5] = consorcio.getEncargado();
                o[6] = consorcio.getTelefonoEncargado();
//                if (consorcio.getMaster().equals(0)) {
//                    o[7] = "MASTER";
//                } else {
//                    o[7] = "ASIGNADO";
//                }
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
    }

}
