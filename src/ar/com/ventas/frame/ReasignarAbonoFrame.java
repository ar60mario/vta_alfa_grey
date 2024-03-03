/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Abono;
import ar.com.ventas.entities.AbonoPendiente;
import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.AdministradorTitularCuitComprobante;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.ConsorcioMaster;
import ar.com.ventas.entities.CuentaCorrienteCliente;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.services.AbonoService;
import ar.com.ventas.services.AdministradorTitularCuitComprobanteService;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.ConsorcioMasterService;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.services.CuentaCorrienteClienteService;
import ar.com.ventas.services.TitularCuitService;
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
public class ReasignarAbonoFrame extends javax.swing.JFrame {

    private AbonoPendiente ap;
    private List<Comprobante> comprobantes;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat df = new DecimalFormat("#0.00");
    private ConsorcioMaster cm;
    private Rubro rubro = null;

    /**
     * Creates new form ReasignarAbonoFrame
     */
    public ReasignarAbonoFrame(AbonoPendiente ap, ConsorcioMaster cm) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
//        this.setLocationRelativeTo(null);
        setExtendedState(6); // this.MAXIMIZED_BOTH
        //AbonosPendientesFacturarFrame
        this.ap = ap;
        this.cm = cm;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        asignarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        administradorTxt = new javax.swing.JTextField();
        consorcioTxt = new javax.swing.JTextField();
        rubroTxt = new javax.swing.JTextField();
        cuotaTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        deTxt = new javax.swing.JTextField();
        alTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        importeTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CONSORCIO:");

        jLabel2.setText("ADMINISTRADOR:");

        jLabel3.setText("RUBRO:");

        jLabel4.setText("CUOTA:");

        jLabel5.setText("SELECCIONE FACTURA A ASIGNAR:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CONSORCIO", "CUOTA", "CUOTAS", "IMPORTE", "TITULAR_CUIT", "M"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        asignarBtn.setText("Asignar");
        asignarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        administradorTxt.setText("ADMINISTRADOR");

        consorcioTxt.setText("CONSORCIO");

        rubroTxt.setText("RUBRO");

        cuotaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cuotaTxt.setText("CUOTA");

        jLabel6.setText("DE FECHA:");

        jLabel7.setText("A FECHA:");

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

        jLabel8.setText("IMPORTE:");

        importeTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeTxt.setText("IMPORTE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(asignarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(administradorTxt)
                            .addComponent(consorcioTxt)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rubroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel4)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cuotaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(importeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 105, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(consorcioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(administradorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rubroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cuotaTxt)
                    .addComponent(jLabel8)
                    .addComponent(importeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asignarBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

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

    private void alTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = alTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                llenarTabla();
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

    private void asignarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarBtnActionPerformed
        int row = tabla.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "DEBE ELEGIR A QUIEN ASIGNAR EL ABONO");
            return;
        }
        Comprobante co = comprobantes.get(row);
        asignar(co);
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
            java.util.logging.Logger.getLogger(ReasignarAbonoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReasignarAbonoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReasignarAbonoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReasignarAbonoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReasignarAbonoFrame(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField administradorTxt;
    private javax.swing.JTextField alTxt;
    private javax.swing.JButton asignarBtn;
    private javax.swing.JTextField consorcioTxt;
    private javax.swing.JTextField cuotaTxt;
    private javax.swing.JTextField deTxt;
    private javax.swing.JTextField importeTxt;
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

    private void llenarFrame() {
        Abono abono = ap.getAbono();
        Consorcio consorcio = abono.getConsorcio();
        Domicilio dm = consorcio.getDomicilio();
        String calle = dm.getCalle() + " " + dm.getNumero();
        rubro = abono.getRubro();
        Administrador admin = consorcio.getAdministrador();
        consorcioTxt.setText(calle);
        administradorTxt.setText(admin.getNombreAdministrador());
        rubroTxt.setText(rubro.getDetalle());
        cuotaTxt.setText(abono.getCuotaFacturada().toString());
        importeTxt.setText(df.format(abono.getImporte()));
        deTxt.setText("");
        alTxt.setText("");

        deTxt.requestFocus();
//        comprobantes = null;
//        comprobantes = new 
    }

    private void volver() {
        AbonosPendientesFacturarFrame apff = new AbonosPendientesFacturarFrame();
        apff.setVisible(true);
        this.dispose();
    }

    private void llenarTabla() {
        UtilFrame.limpiarTabla(tabla);
        comprobantes = null;
        Date de;
        Date al;
        try {
            de = sdf.parse(deTxt.getText());
            al = sdf.parse(alTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ReasignarAbonoFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        BigDecimal bd_imp = new BigDecimal(df.format(ap.getAbono().getImporte()).replace(",", "."));
        BigDecimal bd_cuo = new BigDecimal(ap.getAbono().getCuotas().toString());
        BigDecimal bd_tt = bd_imp.divide(bd_cuo);
        Double impo = bd_tt.doubleValue();
        Integer cuot = ap.getAbono().getCuotaFacturada();
        try {
            comprobantes = new ComprobanteService()
                    .getComprobEntrFechasIgualImporteIgualCuotaIgualRubro(de, al, impo, cuot, rubro);
        } catch (Exception ex) {
            Logger.getLogger(ReasignarAbonoFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        System.out.println(comprobantes);
//        System.exit(0);
        if (comprobantes != null && !comprobantes.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (Comprobante co : comprobantes) {
                Integer codigo = co.getCodigoCliente();
                Consorcio consorcio = null;
                try {
                    consorcio = new ConsorcioService().getConsorcioByCodigo(codigo);
                } catch (Exception ex) {
                    Logger.getLogger(ReasignarAbonoFrame.class.getName()).log(Level.SEVERE, null, ex);
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
                o[5] = "";
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
    }

    private void asignar(Comprobante comprobanteToReasignar) {
        String cuitTitular = comprobanteToReasignar.getCuitTitular();
        Integer codigo = comprobanteToReasignar.getCodigoCliente();
        Consorcio cons = null;
        try {
            cons = new ConsorcioService().getConsorcioByCodigo(codigo);
        } catch (Exception ex) {
            Logger.getLogger(ReasignarAbonoFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        Administrador admin = cons.getAdministrador();
        List<AdministradorTitularCuitComprobante> atc = null;
        try {
            atc = new AdministradorTitularCuitComprobanteService().getExistenFacturas(comprobanteToReasignar, cuitTitular, admin);
        } catch (Exception ex) {
            Logger.getLogger(ReasignarAbonoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!atc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "EXISTE FACTURA PARA ESTE ADMINISTRADOR\nELIJA OTRO COMPROBANTE");
            return;
        }
        TitularCuit tc = null;
        try {
            tc = new TitularCuitService().getTitularActivoByCuit(cuitTitular);
        } catch (Exception ex) {
            Logger.getLogger(ReasignarAbonoFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        Abono abono = ap.getAbono();
        Double importe = comprobanteToReasignar.getTotal();
        Rubro ru = abono.getRubro();
        Consorcio cons_nuevo = abono.getConsorcio();
        Double saldo_nuevo = cons_nuevo.getSaldo();
        Domicilio dm_nuevo = cons_nuevo.getDomicilio();
        String calle = dm_nuevo.getCalle() + " " + dm_nuevo.getNumero();
        int cuotas = abono.getCuotas();
        int cuotasPagadas = abono.getCuotaFacturada() + 1;
        abono.setCuotaFacturada(cuotasPagadas);
        AdministradorTitularCuitComprobante atc1 = new AdministradorTitularCuitComprobante();
        atc1.setAdministrador(admin);
        atc1.setComprobante(comprobanteToReasignar);
        atc1.setTitular(tc);
        Comprobante comprob_nuevo = new Comprobante();
        comprob_nuevo.setCae(comprobanteToReasignar.getCae());
        comprob_nuevo.setCalleNroPisoDtoCliente(calle);
        comprob_nuevo.setCantidadCuotas(cuotas);
        comprob_nuevo.setCodigoCliente(cons_nuevo.getCodigo());
        comprob_nuevo.setCodigoComprobante(comprobanteToReasignar.getCodigoComprobante());
        comprob_nuevo.setCodigoPostalAndLocalidadCliente(dm_nuevo.getCodigoPostal()
                + " " + dm_nuevo.getLocalidad());
        comprob_nuevo.setCodigoPostalAndLocalidadTitular(comprobanteToReasignar
                .getCodigoPostalAndLocalidadTitular());
        comprob_nuevo.setCuitCliente(comprobanteToReasignar.getCuitCliente());
        comprob_nuevo.setCuitTitular(cuitTitular);
        comprob_nuevo.setCuotasPagadas(cuotasPagadas);
        comprob_nuevo.setDomicilioTitular(comprobanteToReasignar.getDomicilioTitular());
        comprob_nuevo.setFecha(comprobanteToReasignar.getFecha());
        comprob_nuevo.setFechaInicioActividades(comprobanteToReasignar.getFechaInicioActividades());
        comprob_nuevo.setFechaPeriodoDesde(comprobanteToReasignar.getFechaPeriodoDesde());
        comprob_nuevo.setFechaPeriodoHasta(comprobanteToReasignar.getFechaPeriodoHasta());
        comprob_nuevo.setFechaVencimientoCae(comprobanteToReasignar.getFechaVencimientoCae());
        comprob_nuevo.setFechaVencimientoPago(comprobanteToReasignar.getFechaVencimientoPago());
        comprob_nuevo.setGravado(importe);
        comprob_nuevo.setIibb(comprobanteToReasignar.getIibb());
        comprob_nuevo.setIva(0.0);
        comprob_nuevo.setLetra(comprobanteToReasignar.getLetra());
        comprob_nuevo.setLetraComprobanteAsociado(comprobanteToReasignar.getLetraComprobanteAsociado());
        comprob_nuevo.setNumero(comprobanteToReasignar.getNumero());
        comprob_nuevo.setNumeroComprobanteAsociado(comprobanteToReasignar.getNumeroComprobanteAsociado());
        comprob_nuevo.setOriginal(false);
        comprob_nuevo.setPagado(0.00);
        comprob_nuevo.setPdfGenerado(false);
        comprob_nuevo.setPeriodo("");
        comprob_nuevo.setProductoServicio(comprobanteToReasignar.getProductoServicio());
        comprob_nuevo.setProvinciaCliente(dm_nuevo.getProvincia());
        comprob_nuevo.setProvinciaTitular(comprobanteToReasignar.getProvinciaTitular());
        comprob_nuevo.setRazonSocialCliente(cons_nuevo.getNombre());
        comprob_nuevo.setRazonSocialTitular(comprobanteToReasignar.getRazonSocialTitular());
        comprob_nuevo.setRubro(ru);
        comprob_nuevo.setSucursal(comprobanteToReasignar.getSucursal());
        comprob_nuevo.setSucursalComprobanteAsociado(comprobanteToReasignar.getSucursalComprobanteAsociado());
        comprob_nuevo.setTexto1("");
        comprob_nuevo.setTexto2("");
        comprob_nuevo.setTipoComprobanteAsociado(comprobanteToReasignar.getTipoComprobanteAsociado());
        comprob_nuevo.setTipoDocumento(comprobanteToReasignar.getTipoDocumento());
        comprob_nuevo.setTipoEmision(comprobanteToReasignar.getTipoEmision());
        comprob_nuevo.setTipoInscripcion(comprobanteToReasignar.getTipoInscripcion());
        comprob_nuevo.setTotal(importe);
        CuentaCorrienteCliente ccc = new CuentaCorrienteCliente();
        saldo_nuevo += importe;
        cons_nuevo.setSaldo(saldo_nuevo);
        ccc.setConsorcio(cons_nuevo);
        ccc.setDebe(importe);
        ccc.setHaber(0.0);
        ccc.setRecibo(null);
        ccc.setSaldo(saldo_nuevo);
        ccc.setTipoComprobante(comprobanteToReasignar.getCodigoComprobante());
        ccc.setFecha(comprobanteToReasignar.getFecha());
        try {
            new AbonoService().updateAbono(abono);
            comprob_nuevo = new ComprobanteService().saveComprobante(comprob_nuevo);
            ccc.setComprobante(comprob_nuevo);
            new CuentaCorrienteClienteService().saveCuentaCorrienteCliente(ccc);
            new ConsorcioService().updateConsorcio(cons_nuevo);
            System.out.println("OK_0");
            if (cm != null) {
                new ConsorcioMasterService().deleteConsorcioActivoMaster(cm);
                System.out.println("OK_1");
            }
        } catch (Exception ex) {
            System.out.println(cm);
            System.out.println(abono.getId());
            System.out.println(comprob_nuevo.getId());
            System.out.println(ccc.getId());
            System.out.println(cons_nuevo.getId());
            JOptionPane.showMessageDialog(this, "ERROR 547");
            return;
        }
        JOptionPane.showMessageDialog(this, "CORRECTO");
        volver();
    }
}