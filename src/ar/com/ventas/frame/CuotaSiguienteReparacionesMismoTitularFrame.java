package ar.com.ventas.frame;

import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.ComprobanteRenglones;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.CuentaCorrienteCliente;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ComprobanteRenglonesService;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.ConfiguracionService;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.services.CuentaCorrienteClienteService;
import ar.com.ventas.services.TitularCuitService;
import ar.com.ventas.util.UtilFactura;
import ar.com.ventas.util.UtilFrame;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CuotaSiguienteReparacionesMismoTitularFrame extends javax.swing.JFrame {

    private List<Comprobante> comprobantes;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat df = new DecimalFormat("#0.00");

    public CuotaSiguienteReparacionesMismoTitularFrame() {
        initComponents();
        
//        setExtendedState(6); // this.MAXIMIZED_BOTH
        buscar();
        llenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        generarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        sacarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("GENERAR CUOTAS SIGUIENTE EN REPARACIONES");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FECHA", "CONSORCIO", "ADMIN", "RUBRO", "CUOTA", "CUOTAS", "IMPORTE", "ORG/ASG", "TITULAR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        generarBtn.setText("GENERAR TODO");
        generarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("VOLVER");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        sacarBtn.setText("SACAR");
        sacarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sacarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(generarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(sacarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generarBtn)
                    .addComponent(volverBtn)
                    .addComponent(sacarBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarBtnActionPerformed
        generar();
    }//GEN-LAST:event_generarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void sacarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sacarBtnActionPerformed
        sacar();
    }//GEN-LAST:event_sacarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CuotaSiguienteReparacionesMismoTitularFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CuotaSiguienteReparacionesMismoTitularFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CuotaSiguienteReparacionesMismoTitularFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CuotaSiguienteReparacionesMismoTitularFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CuotaSiguienteReparacionesMismoTitularFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton generarBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sacarBtn;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

//    private void generar() {
//        int row = tabla.getSelectedRow();
//        int rows = tabla.getSelectedRowCount();
//        if (row < 0) {
//            JOptionPane.showMessageDialog(this, "SELECCIONE UN CONSORCIO PARA FACTURAR");
//            return;
//        }
//        if (rows > 1) {
//            JOptionPane.showMessageDialog(this, "SELECCIONE UN CONSORCIO PARA FACTURAR");
//            return;
//        }
//        
//        if (comprobantes != null && !comprobantes.isEmpty()) {
//            Comprobante co = comprobantes.get(row);
//            FacturaReparacionDeFacturaFrame frdff = new FacturaReparacionDeFacturaFrame(co);
//            frdff.setVisible(true);
//            this.dispose();
//        }
//    }
    private void generar() {
        if (comprobantes != null && !comprobantes.isEmpty()) {
            for (Comprobante co : comprobantes) {
                if (co.getTipoEmision().equals(4)) {
                    if (co.getLetra().equals("C")) {
                        JOptionPane.showMessageDialog(this, "ERROR TIPO EMISION "
                                + co.getId()
                                + co.getCalleNroPisoDtoCliente());
                        return;
                    }
                    int num = 0;
                    Configuracion cnfg = null;
                    try {
                        cnfg = new ConfiguracionService().getConfiguracion(1L);
                    } catch (Exception ex) {
                        Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
                        return;
                    }
                    num = cnfg.getNroRx();
                    num += 1;
                    cnfg.setNroRx(num);
                    List<ComprobanteRenglones> crs = null;
                    try {
                        crs = new ComprobanteRenglonesService().getRenglonesPorComprobante(co);
                    } catch (Exception ex) {
                        Logger.getLogger(CuotaSiguienteReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "ERROR Nro. 229 - RENGLONES\n"+
                                co.getCalleNroPisoDtoCliente()+"\n"+
                                co.getTotal()+"\n"+
                                co.getCuotasPagadas());
                        return;
                    }
                    List<ComprobanteRenglones> crs2 = new ArrayList<>();
                    for (ComprobanteRenglones cr : crs) {
                        ComprobanteRenglones cr1 = new ComprobanteRenglones();
                        cr1.setDetalle(cr.getDetalle());
                        cr1.setImporte(cr.getImporte());
                        crs2.add(cr1);
                    }
                    Comprobante co2 = new Comprobante();
                    co2.setCae(co.getCae());
                    co2.setCalleNroPisoDtoCliente(co.getCalleNroPisoDtoCliente());
                    co2.setCantidadCuotas(co.getCantidadCuotas());
                    co2.setCodigoCliente(co.getCodigoCliente());
                    co2.setCodigoComprobante(co.getCodigoComprobante());
                    co2.setCodigoPostalAndLocalidadCliente(co.getCodigoPostalAndLocalidadCliente());
                    co2.setCodigoPostalAndLocalidadTitular(co.getCodigoPostalAndLocalidadTitular());
                    co2.setCuitCliente(co.getCuitCliente());
                    String cuit = co.getCuitTitular();
                    co2.setCuitTitular(cuit);

                    co2.setCuotaSiguienteFacturada(false);
                    co.setCuotaSiguienteFacturada(true);
                    co2.setCuotasPagadas(co.getCuotasPagadas() + 1);
                    co2.setDomicilioTitular(co.getDomicilioTitular());
                    co2.setFecha(new Date());
                    co2.setFechaInicioActividades(co.getFechaInicioActividades());
                    Date fe0 = new Date(); //co.getFechaPeriodoDesde();
                    Date fe1;
                    Date fe2;
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(fe0);
                    cal.set(Calendar.DAY_OF_MONTH, 1);
                    //cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
                    fe1 = cal.getTime();
                    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
                    fe2 = cal.getTime();
                    System.out.println(sdf.format(fe0));
                    System.out.println(sdf.format(fe1));
                    System.out.println(sdf.format(fe2));
                    System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
                    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
                    System.out.println(cal.getTime());
//                    System.exit(0);
                    co2.setFechaPeriodoDesde(fe1);
                    co2.setFechaPeriodoHasta(fe2);
                    co2.setFechaVencimientoCae(new Date());
                    co2.setFechaVencimientoPago(fe2);
                    co2.setFondo(co.getFondo());
                    co2.setGravado(co.getGravado());
                    co2.setId_administrador(co.getId_administrador());
                    co2.setId_original(co.getId_original());
                    co2.setIibb(co.getIibb());
                    co2.setIva(co.getIva());
                    co2.setLetra(co.getLetra());
                    co2.setLetraComprobanteAsociado(co.getLetraComprobanteAsociado());
                    co2.setNumero(num);
                    co2.setNumeroComprobanteAsociado(0);
                    co2.setOriginal(co.getOriginal());
                    co2.setPagado(0.0);
                    co2.setPdfGenerado(false);
                    co2.setPeriodo("");
                    co2.setPeriodoHabilitado(false);
                    co2.setProductoServicio(co.getProductoServicio());
                    co2.setProvinciaCliente(co.getProvinciaCliente());
                    co2.setProvinciaTitular(co.getProvinciaTitular());
                    co2.setRazonSocialCliente(co.getRazonSocialCliente());
                    co2.setRazonSocialTitular(co.getRazonSocialTitular());
                    co2.setRubro(co.getRubro());
                    co2.setSucursal(co.getSucursal());
                    co2.setSucursalComprobanteAsociado(co.getSucursalComprobanteAsociado());
                    co2.setTexto1("");
                    co2.setTexto2("");
                    co2.setTipoComprobanteAsociado(co.getNumeroComprobanteAsociado());
                    co2.setTipoDocumento(co.getTipoDocumento());
                    co2.setTipoEmision(co.getTipoEmision());
                    co2.setTipoInscripcion(co.getTipoInscripcion());
                    co2.setTotal(co.getTotal());
                    co.setPeriodoHabilitado(false);
                    co.setCuotaSiguienteFacturada(true);
//                    co.setCuotasPagadas(co.getCuotasPagadas() + 1);
                    Integer codigoCliente = co.getCodigoCliente();
                    Consorcio consorcio = null;
                    try {
                        consorcio = new ConsorcioService().getConsorcioByCodigo(codigoCliente);
                    } catch (Exception ex) {
                        Logger.getLogger(CuotaSiguienteReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
                        return;
                    }
                    Double saldo = consorcio.getSaldo();
                    saldo += co.getTotal();
                    CuentaCorrienteCliente ccc = new CuentaCorrienteCliente();
                    ccc.setComprobante(co2);
                    ccc.setConsorcio(consorcio);
                    ccc.setDebe(co.getTotal());
                    ccc.setHaber(0.0);
                    ccc.setFecha(new Date());
                    ccc.setSaldo(saldo);
                    ccc.setTipoComprobante(11);
                    consorcio.setSaldo(saldo);
                    try {
                        co2 = new ComprobanteService().saveComprobante(co2);
                        new ComprobanteService().updateComprobante(co);
                        ccc.setComprobante(co2);
                        new CuentaCorrienteClienteService().saveCuentaCorrienteCliente(ccc);
                        new ConsorcioService().updateConsorcio(consorcio);
                        new ConfiguracionService().updateConfiguracion(cnfg);
                        for (ComprobanteRenglones c1 : crs2) {
                            c1.setComprobante(co2);
                            new ComprobanteRenglonesService().saveRenglon(c1);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(CuotaSiguienteReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "ERROR");
                    }
                }

//                999
                if (co.getTipoEmision().equals(2)) {
                    if (co.getLetra().equals("X")) {
                        JOptionPane.showMessageDialog(this, "ERROR EN COMPROBANTE "
                                + co.getCalleNroPisoDtoCliente());
                        return;
                    }
                    if (co.getCuotasPagadas() == null) {
                        JOptionPane.showMessageDialog(this, "ERROR EN NRO. CUOTA PARA GENERAR SIGUIENTE"
                                + co.getCalleNroPisoDtoCliente());
                        return;
                    }
                    if (co.getCantidadCuotas() == null) {
                        JOptionPane.showMessageDialog(this, "ERROR EN NRO. CUOTA PARA GENERAR SIGUIENTE"
                                + co.getCalleNroPisoDtoCliente());
                        return;
                    }
                    List<ComprobanteRenglones> crs = null;
                    try {
                        crs = new ComprobanteRenglonesService().getRenglonesPorComprobante(co);
                    } catch (Exception ex) {
                        Logger.getLogger(CuotaSiguienteReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
                        return;
                    }
                    List<ComprobanteRenglones> crs2 = new ArrayList<>();
                    for (ComprobanteRenglones cr : crs) {
                        ComprobanteRenglones cr1 = new ComprobanteRenglones();
                        cr1.setDetalle(cr.getDetalle());
                        cr1.setImporte(cr.getImporte());
                        crs2.add(cr1);
                    }
                    Comprobante co2 = new Comprobante();
//                    co2.setCae(co.getCae());
                    co2.setCalleNroPisoDtoCliente(co.getCalleNroPisoDtoCliente());
                    co2.setCantidadCuotas(co.getCantidadCuotas());
                    co2.setCodigoCliente(co.getCodigoCliente());
                    co2.setCodigoComprobante(co.getCodigoComprobante());
                    co2.setCodigoPostalAndLocalidadCliente(co.getCodigoPostalAndLocalidadCliente());
                    co2.setCodigoPostalAndLocalidadTitular(co.getCodigoPostalAndLocalidadTitular());
                    co2.setCuitCliente(co.getCuitCliente());
                    String cuit = co.getCuitTitular();
//                    System.out.println(cuit);
//                    System.exit(0);
                    TitularCuit tc;
                    try {
                        tc = new TitularCuitService().getTitularActivoByCuit(cuit);
                        System.out.println(tc.getCuit());
                        System.out.println(tc.getSucursal());
                        System.out.println(tc.getPersona().getApellidoNombre());

                    } catch (Exception ex) {
//                        Logger.getLogger(CuotaSiguienteReparacionesMismoTitularFrame.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "ERROR CUIT TITULAR " + co.getCalleNroPisoDtoCliente());
                        return;
                    }
//                    System.exit(0);
                    co2.setCuitTitular(cuit);
                    Integer cuots = co.getCuotasPagadas();
                    Integer cant_cuotas = co.getCantidadCuotas();
                    cuots += 1;
                    if (cuots.equals(cant_cuotas)) {
                        co2.setCuotaSiguienteFacturada(true);
                    } else {
                        co2.setCuotaSiguienteFacturada(false);
                    }
                    co.setCuotaSiguienteFacturada(true);
                    co.setPeriodoHabilitado(false);
                    co2.setCuotasPagadas(cuots);
                    co2.setPeriodoHabilitado(false);
                    co2.setDomicilioTitular(co.getDomicilioTitular());
                    co2.setFecha(new Date());
                    co2.setFechaInicioActividades(new Date()); // co.getFechaInicioActividades()
                    Date fe0 = new Date();//co.getFechaPeriodoDesde();
                    Date fe1;
                    Date fe2;
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(fe0);
                    cal.set(Calendar.DAY_OF_MONTH, 1);
//                    cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 2);
                    fe1 = cal.getTime();
                    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
                    fe2 = cal.getTime();
                    System.out.println(sdf.format(fe0));
                    System.out.println(sdf.format(fe1));
                    System.out.println(sdf.format(fe2));
                    System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
                    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
                    System.out.println(cal.getTime());
//                    System.exit(0);
                    co2.setFechaPeriodoDesde(fe1);
                    co2.setFechaPeriodoHasta(fe2);
//                    co2.setFechaVencimientoCae(new Date());
                    co2.setFechaVencimientoPago(fe2);
                    System.out.println(fe0);
                    System.out.println(fe1);
                    System.out.println(fe2);
//                    System.exit(0);
                    co2.setFondo(co.getFondo());
                    co2.setGravado(co.getGravado());
                    co2.setId_administrador(co.getId_administrador());
                    co2.setId_original(0L);
                    co2.setIibb(co.getIibb());
                    co2.setIva(co.getIva());
                    co2.setLetra(co.getLetra());
                    co2.setLetraComprobanteAsociado(co.getLetraComprobanteAsociado());
//                    co2.setCuotaSiguienteFacturada(false);
                    co2.setNumeroComprobanteAsociado(0);
                    co2.setOriginal(true);
                    co2.setPagado(0.0);
                    co2.setPdfGenerado(false);
                    co2.setPeriodo("");
                    co2.setProductoServicio(co.getProductoServicio());
                    co2.setProvinciaCliente(co.getProvinciaCliente());
                    co2.setProvinciaTitular(co.getProvinciaTitular());
                    co2.setRazonSocialCliente(co.getRazonSocialCliente());
                    co2.setRazonSocialTitular(co.getRazonSocialTitular());
                    co2.setRubro(co.getRubro());
                    co2.setSucursal(co.getSucursal());
                    co2.setSucursalComprobanteAsociado(co.getSucursalComprobanteAsociado());
                    co2.setTexto1("");
                    co2.setTexto2("");
                    co2.setTipoComprobanteAsociado(co.getNumeroComprobanteAsociado());
                    co2.setTipoDocumento(co.getTipoDocumento());
                    co2.setTipoEmision(co.getTipoEmision());
                    co2.setTipoInscripcion(co.getTipoInscripcion());
                    co2.setTotal(co.getTotal());
                    Integer codigoCliente = co.getCodigoCliente();
                    Consorcio consorcio;
                    try {
                        consorcio = new ConsorcioService().getConsorcioByCodigo(codigoCliente);
                    } catch (Exception ex) {
                        Logger.getLogger(CuotaSiguienteReparacionesFrame.class.getName()).log(Level.SEVERE, null, ex);
                        return;
                    }
                    Double saldo = consorcio.getSaldo();
                    saldo += co.getTotal();
                    CuentaCorrienteCliente ccc = new CuentaCorrienteCliente();
                    ccc.setComprobante(co2);
                    ccc.setConsorcio(consorcio);
                    ccc.setDebe(co.getTotal());
                    ccc.setHaber(0.0);
                    ccc.setFecha(new Date());
                    ccc.setSaldo(saldo);
                    ccc.setTipoComprobante(11);
                    consorcio.setSaldo(saldo);
                    int ps = 3;
//                    Integer.valueOf(cuotasTxt.getText());

                    String resultado = UtilFactura.saveFacturaReparacion2(consorcio, tc,
                            crs2, co.getTotal(), co.getRubro(), new Date(), fe2,
                            ps, co.getCantidadCuotas(), cuots, co2, co, ccc);
                    if (!resultado.equals("A")) {
                        JOptionPane.showMessageDialog(this, "ERROR REGISTRANDO COMPROBANTE/n"+
                                co.getCalleNroPisoDtoCliente()+"/n"+
                                co.getTotal()+"/n"+
                                co.getCuotasPagadas());
                    }

                }

            }
            JOptionPane.showMessageDialog(this, "COMPROBANTE REGISTRADO CORRECTAMENTE");
            volver();
        }
    }

    private void sacar() {
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
        int cantidadSeleccionada = tabla.getSelectedRowCount();
        int a[] = tabla.getSelectedRows();
        if (cantidadSeleccionada < 1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN CONSORCIO PARA SACER");
            return;
        }
        for (int n = cantidadSeleccionada - 1; n > -1; n--) {
            tbl.removeRow(a[n]);
            comprobantes.remove(a[n]);
        }
        llenarTabla();
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void buscar() {
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
        comprobantes = null;
        try {
            comprobantes = new ComprobanteService().getComprobantesActivosReparacionCuotaSiguiente2();
        } catch (Exception ex) {
            Logger.getLogger(CuotaSiguienteReparacionesMismoTitularFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarTabla() {
        UtilFrame.limpiarTabla(tabla);
        if (comprobantes != null && !comprobantes.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (Comprobante co : comprobantes) {
                Integer cod = co.getCodigoCliente();
                Consorcio cons = null;
                try {
                    cons = new ConsorcioService().getConsorcioByCodigo(cod);
                } catch (Exception ex) {
                    Logger.getLogger(CuotaSiguienteReparacionesMismoTitularFrame.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                Administrador adm = cons.getAdministrador();
                Object o[] = new Object[9];
                o[0] = sdf.format(co.getFecha());
                o[1] = co.getCalleNroPisoDtoCliente();
                o[2] = adm.getNombreAdministrador();
                o[3] = co.getRubro().getDetalle();
                o[4] = co.getCuotasPagadas();
                o[5] = co.getCantidadCuotas();
                o[6] = df.format(co.getTotal());
                if (co.getTipoEmision().equals(4)) {
                    o[7] = "N/A";
                } else {
                    if (co.getOriginal() != null) {
                        if (co.getOriginal()) {
                            o[7] = "ORIG";
                        } else {
                            o[7] = "ASIG";
                        }
                    } else {
                        o[7] = "ORIG";
                    }
                }
                o[8] = co.getRazonSocialTitular();
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
    }
}
