/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.main;

import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.ComprobanteRenglones;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.NuevoCae;
import ar.com.ventas.entities.RenglonAbono;
import ar.com.ventas.entities.TicketTime;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.estructuras.Constantes;
import ar.com.ventas.estructuras.Mes;
import ar.com.ventas.frame.AbmAbonosFrame;
import ar.com.ventas.frame.TrabajosPendientesFrame;
import ar.com.ventas.frame.VerFacturasParaAjustarPeriodoFrame;
import ar.com.ventas.frame.AbmAdministradorFrame;
import ar.com.ventas.frame.AbmConsorcioFrame;
import ar.com.ventas.frame.AbmFondosRecibosFrame;
import ar.com.ventas.frame.AbmImportesFrame;
import ar.com.ventas.frame.AbmMonotributoFrame;
import ar.com.ventas.frame.AbmPersonaFrame;
import ar.com.ventas.frame.AbmPreciosFrame;
import ar.com.ventas.frame.AbmRubrosFrame;
import ar.com.ventas.frame.AbmTextoPredefinidoFrame;
import ar.com.ventas.frame.AbonosPendienteFacturarFrame;
import ar.com.ventas.frame.AsignadasAndOriginalesFrame;
import ar.com.ventas.frame.AsignadosPorRubroFrame;
import ar.com.ventas.frame.AsignarFacturaFrame;
import ar.com.ventas.frame.BackupFrame;
import ar.com.ventas.frame.CertificadosAfipFrame;
import ar.com.ventas.frame.CobranzaEntreFechasFrame;
import ar.com.ventas.frame.ComprobantesPorTitularFrame;
import ar.com.ventas.frame.CrearEstructuraFrame;
import ar.com.ventas.frame.CuentaCorrienteAdministradorFrame;
import ar.com.ventas.frame.CuentaCorrienteClienteFrame;
import ar.com.ventas.frame.CuentaCorrienteClienteFrame1;
import ar.com.ventas.frame.CuotaAbonoFrame;
import ar.com.ventas.frame.CuotaSiguienteReparacionesFrame;
import ar.com.ventas.frame.CuotasFrame;
import ar.com.ventas.frame.DefinirCamposEstructuraFrame;
import ar.com.ventas.frame.FacturaReparacion2Frame;
import ar.com.ventas.frame.FacturarAbonos2Frame;
import ar.com.ventas.frame.FacturarAbonosFrame;
import ar.com.ventas.frame.FacturasByConsorcioEntreFechasFrame;
import ar.com.ventas.frame.FacturasEntreFechasFrame;
import ar.com.ventas.frame.FacturasTerceroFrame;
import ar.com.ventas.frame.GenerarCertificadosFrame;
import ar.com.ventas.frame.HabilitarPeriodoParaFacturarFrame;
import ar.com.ventas.frame.HabilitarPeriodoParaFacturarReparacionesFrame;
import ar.com.ventas.frame.ListadoParaCobranzaFrame;
import ar.com.ventas.frame.ModificarServiciosFrame;
import ar.com.ventas.frame.NewJFrame;
import ar.com.ventas.frame.NotaCreditoFrame;
import ar.com.ventas.frame.NuevoPeriodoFrame;
import ar.com.ventas.frame.NuevoServicioFrame;
import ar.com.ventas.frame.NuevoTrabajoFrame;
import ar.com.ventas.frame.ReciboAbonos2Frame;
import ar.com.ventas.frame.ReciboReparacion2Frame;
import ar.com.ventas.frame.RecibosFinDeAnioFrame;
import ar.com.ventas.frame.ReconstruirAbonoFacturaFrame;
import ar.com.ventas.frame.ReconstruirComprobanteTitularAdministradorFrame;
import ar.com.ventas.frame.RecuperarDeAfipFrame;
import ar.com.ventas.frame.RenovacionesFrame;
import ar.com.ventas.frame.RenovarAbonosVencidosFrame;
import ar.com.ventas.frame.ServiciosPorAdministracionAndConsorcioFrame;
import ar.com.ventas.frame.ServiciosPorConsorcioFrame;
import ar.com.ventas.frame.ServiciosSinTrabajosFrame;
import ar.com.ventas.frame.SinRenglonesFrame;
import ar.com.ventas.frame.TestAfipFrame;
import ar.com.ventas.frame.TestImporteAbonoFrame;
import ar.com.ventas.frame.TrabajosPendientesDeFacturarFrame;
import ar.com.ventas.frame.TrabajosPorPersonaFrame;
import ar.com.ventas.frame.TrabajosRealizadosFrame;
import ar.com.ventas.frame.VencimientoAbonosPorPeriodoFrame;
import ar.com.ventas.frame.VentasPorTitularFrame;
import ar.com.ventas.services.AbonoService;
import ar.com.ventas.services.ComprobanteRenglonesService;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.services.RenglonAbonoService;
import ar.com.ventas.services.TicketTimeService;
import ar.com.ventas.services.TitularCuitService;
import ar.com.ventas.util.PDFBuilder;
import ar.com.ventas.util.UtilAbonos;
import ar.com.ventas.util.UtilAfip;
import ar.com.ventas.util.UtilFrame;
import com.itextpdf.text.DocumentException;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.LibraryLoader;
import com.jacob.com.Variant;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class MainFrame extends javax.swing.JFrame {

    private int i = 1;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        this.setLocationRelativeTo(null);
//        setExtendedState(6); // this.MAXIMIZED_BOTH
        pdfBtn.setVisible(false);
        altaServiciosBtn.setVisible(false);
        modificarTrabajosMnu.setVisible(false);
        certificadosMnu.setVisible(false);
        nuevoPeriodoMnu.setVisible(false);
        fechaTxt.setVisible(false);
        mesTxt.setVisible(false);
        mesLetraBtn.setVisible(false);
        tstPeriodoBtn.setVisible(false);
        cuotasAbonosBtn.setVisible(false);
        cuotasBtn.setVisible(false);
        ncBtn.setVisible(true);
        mesBtn.setVisible(false);
        carpetaBtn.setVisible(false);
        carpetaTxt.setVisible(false);
        nombreBtn.setVisible(false);
        co_ti_adBtn.setVisible(false);
        go2Btn.setVisible(false);
        renglonesAbonosBtn.setVisible(false);
        abonoFacturaBtn.setVisible(false);
        testImporteAbonoMnu.setVisible(false);
        sinRenglonesBtn.setVisible(true);
        recibosAlFinDeAnioBtn.setVisible(false);
        tstBtn.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salirBtn = new javax.swing.JButton();
        facturaTercerosBtn = new javax.swing.JButton();
        altaServiciosBtn = new javax.swing.JButton();
        serviciosBtn = new javax.swing.JButton();
        pdfBtn = new javax.swing.JButton();
        renovacionesBtn = new javax.swing.JButton();
        cuentaCorrienteClienteBtn = new javax.swing.JButton();
        facturaReparacionBtn = new javax.swing.JButton();
        facturarAbonosBtn = new javax.swing.JButton();
        cuentaCorrienteAdministracionBtn = new javax.swing.JButton();
        tstPeriodoBtn = new javax.swing.JButton();
        fechaTxt = new javax.swing.JTextField();
        cuotasBtn = new javax.swing.JButton();
        cuotasAbonosBtn = new javax.swing.JButton();
        ncBtn = new javax.swing.JButton();
        mesBtn = new javax.swing.JButton();
        mesTxt = new javax.swing.JTextField();
        mesLetraBtn = new javax.swing.JButton();
        carpetaBtn = new javax.swing.JButton();
        carpetaTxt = new javax.swing.JTextField();
        abonoFacturaBtn = new javax.swing.JButton();
        co_ti_adBtn = new javax.swing.JButton();
        nombreBtn = new javax.swing.JButton();
        go2Btn = new javax.swing.JButton();
        asignadosPorRubroBtn = new javax.swing.JButton();
        renglonesAbonosBtn = new javax.swing.JButton();
        reciboReparacionBtn = new javax.swing.JButton();
        sinRenglonesBtn = new javax.swing.JButton();
        recibosAbonosBtn = new javax.swing.JButton();
        recibosAlFinDeAnioBtn = new javax.swing.JButton();
        tstBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        abmAbonosMnu = new javax.swing.JMenuItem();
        abmAdministradorMnu = new javax.swing.JMenuItem();
        abmCategoriasMonotributoMnu = new javax.swing.JMenuItem();
        certificadosAfipMnu = new javax.swing.JMenuItem();
        abmConsorcioMnu = new javax.swing.JMenuItem();
        abmFondosRecibosReparaMnu = new javax.swing.JMenuItem();
        abmImportesMnu = new javax.swing.JMenuItem();
        abmPersonaMnu = new javax.swing.JMenuItem();
        abmPreciosMnu = new javax.swing.JMenuItem();
        abmServicioMnu = new javax.swing.JMenuItem();
        taxtosPredefinidosMnu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        backupMnu = new javax.swing.JMenuItem();
        crearEstructuraMnu = new javax.swing.JMenuItem();
        definirCamposEstructuraMnu = new javax.swing.JMenuItem();
        modificarServiciosMnu = new javax.swing.JMenuItem();
        modificarTrabajosMnu = new javax.swing.JMenuItem();
        nuevoPeriodoMnu = new javax.swing.JMenuItem();
        pendientesDeFacturarMnu = new javax.swing.JMenuItem();
        facturasEntreFechasMnu = new javax.swing.JMenuItem();
        testAfipMnu = new javax.swing.JMenuItem();
        recuperarDeAfipMnu = new javax.swing.JMenuItem();
        asignarFacturaMnu = new javax.swing.JMenuItem();
        renovarAbonosMnu = new javax.swing.JMenuItem();
        habilitarPeriodoParaFacturarMnu = new javax.swing.JMenuItem();
        habilitarPeriodoReparacionesMnu = new javax.swing.JMenuItem();
        ajustarPeriodoEnFcMnu = new javax.swing.JMenuItem();
        cuotaSiguienteReparacionMnu = new javax.swing.JMenuItem();
        testImporteAbonoMnu = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        trabajosPendientesMnu = new javax.swing.JMenuItem();
        certificadosMnu = new javax.swing.JMenuItem();
        trabajosRealizadosMnu = new javax.swing.JMenuItem();
        trabajosPorPersonaMnu = new javax.swing.JMenuItem();
        serviciosPorConsorcioMnu = new javax.swing.JMenuItem();
        serviciosPorAdministracionAndConsorcioMnu = new javax.swing.JMenuItem();
        ventasPorTitularEntreFechasMnu = new javax.swing.JMenuItem();
        facturasByConsorcioEntreFechasMnu = new javax.swing.JMenuItem();
        cobranzaPorFechaMnu = new javax.swing.JMenuItem();
        abonosPendientesFacturarMnu = new javax.swing.JMenuItem();
        vencimientoAbonosPorPeriodoMnu = new javax.swing.JMenuItem();
        listadoParaCobranzaMnu = new javax.swing.JMenuItem();
        comprobantesPorTitularMnu = new javax.swing.JMenuItem();
        asignadasAndOriginalesMnu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        versionMnu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ALFA");

        salirBtn.setText("Salir");
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        facturaTercerosBtn.setText("Factura Terceros");
        facturaTercerosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaTercerosBtnActionPerformed(evt);
            }
        });

        altaServiciosBtn.setText("Alta Servicios");
        altaServiciosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaServiciosBtnActionPerformed(evt);
            }
        });

        serviciosBtn.setText("Carga Trabajos");
        serviciosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviciosBtnActionPerformed(evt);
            }
        });

        pdfBtn.setText("PDF");
        pdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfBtnActionPerformed(evt);
            }
        });

        renovacionesBtn.setText("Renovaciones");
        renovacionesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renovacionesBtnActionPerformed(evt);
            }
        });

        cuentaCorrienteClienteBtn.setText("Cta Corriente Cliente");
        cuentaCorrienteClienteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuentaCorrienteClienteBtnActionPerformed(evt);
            }
        });

        facturaReparacionBtn.setText("Factura Reparaciones");
        facturaReparacionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaReparacionBtnActionPerformed(evt);
            }
        });

        facturarAbonosBtn.setText("Facturar Abonos");
        facturarAbonosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturarAbonosBtnActionPerformed(evt);
            }
        });

        cuentaCorrienteAdministracionBtn.setText("Cta Corriente Administración");
        cuentaCorrienteAdministracionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuentaCorrienteAdministracionBtnActionPerformed(evt);
            }
        });

        tstPeriodoBtn.setText("Período");
        tstPeriodoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tstPeriodoBtnActionPerformed(evt);
            }
        });

        fechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaTxt.setText("FECHA");

        cuotasBtn.setText("CUOTAS");
        cuotasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuotasBtnActionPerformed(evt);
            }
        });

        cuotasAbonosBtn.setText("CUOTAS EN ABONOS");
        cuotasAbonosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuotasAbonosBtnActionPerformed(evt);
            }
        });

        ncBtn.setText("Nota de Crédito");
        ncBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ncBtnActionPerformed(evt);
            }
        });

        mesBtn.setText("mes");
        mesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesBtnActionPerformed(evt);
            }
        });

        mesTxt.setText("MES");

        mesLetraBtn.setText("MES");
        mesLetraBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesLetraBtnActionPerformed(evt);
            }
        });

        carpetaBtn.setText("Carpeta");
        carpetaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carpetaBtnActionPerformed(evt);
            }
        });

        carpetaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        carpetaTxt.setText("CARPETA");

        abonoFacturaBtn.setText("AbonoFactura");
        abonoFacturaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abonoFacturaBtnActionPerformed(evt);
            }
        });

        co_ti_adBtn.setText("Comprobante Titular Administrador");
        co_ti_adBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                co_ti_adBtnActionPerformed(evt);
            }
        });

        nombreBtn.setText("Nombre");
        nombreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreBtnActionPerformed(evt);
            }
        });

        go2Btn.setText("go2");
        go2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go2BtnActionPerformed(evt);
            }
        });

        asignadosPorRubroBtn.setText("Asignados por Rubro");
        asignadosPorRubroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignadosPorRubroBtnActionPerformed(evt);
            }
        });

        renglonesAbonosBtn.setText("Rngl Abonos");
        renglonesAbonosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renglonesAbonosBtnActionPerformed(evt);
            }
        });

        reciboReparacionBtn.setText("Recibos Reparac");
        reciboReparacionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reciboReparacionBtnActionPerformed(evt);
            }
        });

        sinRenglonesBtn.setText("BUSCAR SIN RENGLONES");
        sinRenglonesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinRenglonesBtnActionPerformed(evt);
            }
        });

        recibosAbonosBtn.setText("Recibos de Abonos");
        recibosAbonosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recibosAbonosBtnActionPerformed(evt);
            }
        });

        recibosAlFinDeAnioBtn.setText("RECIBOS AL 31.12.2023");
        recibosAlFinDeAnioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recibosAlFinDeAnioBtnActionPerformed(evt);
            }
        });

        tstBtn.setText("tst");
        tstBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tstBtnActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        abmAbonosMnu.setText("ABM Abonos");
        abmAbonosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abmAbonosMnuActionPerformed(evt);
            }
        });
        jMenu1.add(abmAbonosMnu);

        abmAdministradorMnu.setText("ABM Administrador");
        abmAdministradorMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abmAdministradorMnuActionPerformed(evt);
            }
        });
        jMenu1.add(abmAdministradorMnu);

        abmCategoriasMonotributoMnu.setText("ABM Categorías Monotributo");
        abmCategoriasMonotributoMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abmCategoriasMonotributoMnuActionPerformed(evt);
            }
        });
        jMenu1.add(abmCategoriasMonotributoMnu);

        certificadosAfipMnu.setText("ABM Certificados AFIP");
        certificadosAfipMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                certificadosAfipMnuActionPerformed(evt);
            }
        });
        jMenu1.add(certificadosAfipMnu);

        abmConsorcioMnu.setText("ABM Consorcio");
        abmConsorcioMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abmConsorcioMnuActionPerformed(evt);
            }
        });
        jMenu1.add(abmConsorcioMnu);

        abmFondosRecibosReparaMnu.setText("ABM Fondos Recibos Reparac");
        abmFondosRecibosReparaMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abmFondosRecibosReparaMnuActionPerformed(evt);
            }
        });
        jMenu1.add(abmFondosRecibosReparaMnu);

        abmImportesMnu.setText("ABM Pago por Trabajos");
        abmImportesMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abmImportesMnuActionPerformed(evt);
            }
        });
        jMenu1.add(abmImportesMnu);

        abmPersonaMnu.setText("ABM Persona");
        abmPersonaMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abmPersonaMnuActionPerformed(evt);
            }
        });
        jMenu1.add(abmPersonaMnu);

        abmPreciosMnu.setText("ABM Precios");
        abmPreciosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abmPreciosMnuActionPerformed(evt);
            }
        });
        jMenu1.add(abmPreciosMnu);

        abmServicioMnu.setText("ABM Rubros");
        abmServicioMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abmServicioMnuActionPerformed(evt);
            }
        });
        jMenu1.add(abmServicioMnu);

        taxtosPredefinidosMnu.setText("ABM Textos Fc Predefinidos");
        taxtosPredefinidosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taxtosPredefinidosMnuActionPerformed(evt);
            }
        });
        jMenu1.add(taxtosPredefinidosMnu);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Herramientas");

        backupMnu.setText("Backup");
        backupMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupMnuActionPerformed(evt);
            }
        });
        jMenu3.add(backupMnu);

        crearEstructuraMnu.setText("Crear Estructura");
        crearEstructuraMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearEstructuraMnuActionPerformed(evt);
            }
        });
        jMenu3.add(crearEstructuraMnu);

        definirCamposEstructuraMnu.setText("Definir Campos Estructura");
        definirCamposEstructuraMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                definirCamposEstructuraMnuActionPerformed(evt);
            }
        });
        jMenu3.add(definirCamposEstructuraMnu);

        modificarServiciosMnu.setText("Modificar Servicios");
        modificarServiciosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarServiciosMnuActionPerformed(evt);
            }
        });
        jMenu3.add(modificarServiciosMnu);

        modificarTrabajosMnu.setText("Modificar Trabajos");
        modificarTrabajosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarTrabajosMnuActionPerformed(evt);
            }
        });
        jMenu3.add(modificarTrabajosMnu);

        nuevoPeriodoMnu.setText("Nuevo Período");
        nuevoPeriodoMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoPeriodoMnuActionPerformed(evt);
            }
        });
        jMenu3.add(nuevoPeriodoMnu);

        pendientesDeFacturarMnu.setText("Trabajos Pendientes de Facturar");
        pendientesDeFacturarMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendientesDeFacturarMnuActionPerformed(evt);
            }
        });
        jMenu3.add(pendientesDeFacturarMnu);

        facturasEntreFechasMnu.setText("Facturas entre Fechas");
        facturasEntreFechasMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturasEntreFechasMnuActionPerformed(evt);
            }
        });
        jMenu3.add(facturasEntreFechasMnu);

        testAfipMnu.setText("Test Afip");
        testAfipMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testAfipMnuActionPerformed(evt);
            }
        });
        jMenu3.add(testAfipMnu);

        recuperarDeAfipMnu.setText("Recuperar de Afip");
        recuperarDeAfipMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recuperarDeAfipMnuActionPerformed(evt);
            }
        });
        jMenu3.add(recuperarDeAfipMnu);

        asignarFacturaMnu.setText("Asignar Factura");
        asignarFacturaMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarFacturaMnuActionPerformed(evt);
            }
        });
        jMenu3.add(asignarFacturaMnu);

        renovarAbonosMnu.setText("Renovar Abonos Vencidos");
        renovarAbonosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renovarAbonosMnuActionPerformed(evt);
            }
        });
        jMenu3.add(renovarAbonosMnu);

        habilitarPeriodoParaFacturarMnu.setText("Habilitar Período para Facturar Abonos");
        habilitarPeriodoParaFacturarMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarPeriodoParaFacturarMnuActionPerformed(evt);
            }
        });
        jMenu3.add(habilitarPeriodoParaFacturarMnu);

        habilitarPeriodoReparacionesMnu.setText("Habilitar Período para Facturar Reparaciones");
        habilitarPeriodoReparacionesMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarPeriodoReparacionesMnuActionPerformed(evt);
            }
        });
        jMenu3.add(habilitarPeriodoReparacionesMnu);

        ajustarPeriodoEnFcMnu.setText("Ajustar Período en Factura y Abono");
        ajustarPeriodoEnFcMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustarPeriodoEnFcMnuActionPerformed(evt);
            }
        });
        jMenu3.add(ajustarPeriodoEnFcMnu);

        cuotaSiguienteReparacionMnu.setText("Cuota Siguiente en Reparaciones");
        cuotaSiguienteReparacionMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuotaSiguienteReparacionMnuActionPerformed(evt);
            }
        });
        jMenu3.add(cuotaSiguienteReparacionMnu);

        testImporteAbonoMnu.setText("Test IMPORTE ABONO");
        testImporteAbonoMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testImporteAbonoMnuActionPerformed(evt);
            }
        });
        jMenu3.add(testImporteAbonoMnu);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Informes");

        trabajosPendientesMnu.setText("Trabajos Pendientes");
        trabajosPendientesMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trabajosPendientesMnuActionPerformed(evt);
            }
        });
        jMenu4.add(trabajosPendientesMnu);

        certificadosMnu.setText("Certificados");
        certificadosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                certificadosMnuActionPerformed(evt);
            }
        });
        jMenu4.add(certificadosMnu);

        trabajosRealizadosMnu.setText("Trabajos Realizados");
        trabajosRealizadosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trabajosRealizadosMnuActionPerformed(evt);
            }
        });
        jMenu4.add(trabajosRealizadosMnu);

        trabajosPorPersonaMnu.setText("Trabajos x Personas");
        trabajosPorPersonaMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trabajosPorPersonaMnuActionPerformed(evt);
            }
        });
        jMenu4.add(trabajosPorPersonaMnu);

        serviciosPorConsorcioMnu.setText("Servicios por Consorcio");
        serviciosPorConsorcioMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviciosPorConsorcioMnuActionPerformed(evt);
            }
        });
        jMenu4.add(serviciosPorConsorcioMnu);

        serviciosPorAdministracionAndConsorcioMnu.setText("Servicios x Administracion x Consorcio");
        serviciosPorAdministracionAndConsorcioMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviciosPorAdministracionAndConsorcioMnuActionPerformed(evt);
            }
        });
        jMenu4.add(serviciosPorAdministracionAndConsorcioMnu);

        ventasPorTitularEntreFechasMnu.setText("Ventas Originales entre Fechas x Titular");
        ventasPorTitularEntreFechasMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasPorTitularEntreFechasMnuActionPerformed(evt);
            }
        });
        jMenu4.add(ventasPorTitularEntreFechasMnu);

        facturasByConsorcioEntreFechasMnu.setText("Facturas Por Consorcio Entre Fechas");
        facturasByConsorcioEntreFechasMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturasByConsorcioEntreFechasMnuActionPerformed(evt);
            }
        });
        jMenu4.add(facturasByConsorcioEntreFechasMnu);

        cobranzaPorFechaMnu.setText("Cobranza por fecha");
        cobranzaPorFechaMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cobranzaPorFechaMnuActionPerformed(evt);
            }
        });
        jMenu4.add(cobranzaPorFechaMnu);

        abonosPendientesFacturarMnu.setText("Abonos Pendientes de Facturar");
        abonosPendientesFacturarMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abonosPendientesFacturarMnuActionPerformed(evt);
            }
        });
        jMenu4.add(abonosPendientesFacturarMnu);

        vencimientoAbonosPorPeriodoMnu.setText("Vencimiento de Abonos Por Período");
        vencimientoAbonosPorPeriodoMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vencimientoAbonosPorPeriodoMnuActionPerformed(evt);
            }
        });
        jMenu4.add(vencimientoAbonosPorPeriodoMnu);

        listadoParaCobranzaMnu.setText("Listados Para Cobranza");
        listadoParaCobranzaMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadoParaCobranzaMnuActionPerformed(evt);
            }
        });
        jMenu4.add(listadoParaCobranzaMnu);

        comprobantesPorTitularMnu.setText("COMPROBANTES POR TITULAR");
        comprobantesPorTitularMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprobantesPorTitularMnuActionPerformed(evt);
            }
        });
        jMenu4.add(comprobantesPorTitularMnu);

        asignadasAndOriginalesMnu.setText("ASIGNADAS Y ORIGINALES");
        asignadasAndOriginalesMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignadasAndOriginalesMnuActionPerformed(evt);
            }
        });
        jMenu4.add(asignadasAndOriginalesMnu);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("?");

        versionMnu.setText("Versión");
        versionMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                versionMnuActionPerformed(evt);
            }
        });
        jMenu2.add(versionMnu);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(asignadosPorRubroBtn)
                                .addGap(18, 18, 18)
                                .addComponent(co_ti_adBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(facturaTercerosBtn)
                                .addGap(18, 18, 18)
                                .addComponent(serviciosBtn)
                                .addGap(18, 18, 18)
                                .addComponent(renovacionesBtn)))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(go2Btn)
                                        .addGap(18, 18, 18)
                                        .addComponent(carpetaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nombreBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(mesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cuotasBtn))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(carpetaBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(mesLetraBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(tstPeriodoBtn))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cuentaCorrienteClienteBtn)
                                .addGap(18, 18, 18)
                                .addComponent(cuentaCorrienteAdministracionBtn)
                                .addGap(18, 18, 18)
                                .addComponent(ncBtn)
                                .addGap(18, 18, 18)
                                .addComponent(pdfBtn)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(abonoFacturaBtn)
                                .addGap(18, 18, 18)
                                .addComponent(renglonesAbonosBtn)
                                .addGap(18, 18, 18)
                                .addComponent(cuotasAbonosBtn)
                                .addGap(18, 18, 18)
                                .addComponent(mesBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(facturaReparacionBtn)
                                    .addComponent(facturarAbonosBtn)
                                    .addComponent(sinRenglonesBtn))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(recibosAbonosBtn)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(reciboReparacionBtn)
                                                .addGap(147, 147, 147)
                                                .addComponent(altaServiciosBtn))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(recibosAlFinDeAnioBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(tstBtn)))))
                        .addContainerGap(388, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(salirBtn)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sinRenglonesBtn)
                    .addComponent(recibosAlFinDeAnioBtn)
                    .addComponent(tstBtn))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asignadosPorRubroBtn)
                    .addComponent(co_ti_adBtn)
                    .addComponent(go2Btn)
                    .addComponent(carpetaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreBtn)
                    .addComponent(mesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuotasBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abonoFacturaBtn)
                    .addComponent(renglonesAbonosBtn)
                    .addComponent(cuotasAbonosBtn)
                    .addComponent(mesBtn)
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carpetaBtn)
                    .addComponent(mesLetraBtn)
                    .addComponent(tstPeriodoBtn))
                .addGap(132, 132, 132)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(facturarAbonosBtn)
                    .addComponent(recibosAbonosBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(facturaReparacionBtn)
                    .addComponent(altaServiciosBtn)
                    .addComponent(reciboReparacionBtn))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(facturaTercerosBtn)
                    .addComponent(serviciosBtn)
                    .addComponent(renovacionesBtn)
                    .addComponent(pdfBtn)
                    .addComponent(cuentaCorrienteClienteBtn)
                    .addComponent(cuentaCorrienteAdministracionBtn)
                    .addComponent(ncBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salirBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        salir();
    }//GEN-LAST:event_salirBtnActionPerformed

    private void facturaTercerosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaTercerosBtnActionPerformed
        facturaTerceros();
    }//GEN-LAST:event_facturaTercerosBtnActionPerformed

    private void abmAdministradorMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abmAdministradorMnuActionPerformed
        abmAdministrador();
    }//GEN-LAST:event_abmAdministradorMnuActionPerformed

    private void abmConsorcioMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abmConsorcioMnuActionPerformed
        abmConsorcio();
    }//GEN-LAST:event_abmConsorcioMnuActionPerformed

    private void abmPersonaMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abmPersonaMnuActionPerformed
        abmPersona();
    }//GEN-LAST:event_abmPersonaMnuActionPerformed

    private void abmCategoriasMonotributoMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abmCategoriasMonotributoMnuActionPerformed
        abmMonotributo();
    }//GEN-LAST:event_abmCategoriasMonotributoMnuActionPerformed

    private void backupMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupMnuActionPerformed
        backup();
    }//GEN-LAST:event_backupMnuActionPerformed

    private void abmServicioMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abmServicioMnuActionPerformed
        abmRubros();
    }//GEN-LAST:event_abmServicioMnuActionPerformed

    private void crearEstructuraMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearEstructuraMnuActionPerformed
        crearEstructura();
    }//GEN-LAST:event_crearEstructuraMnuActionPerformed

    private void definirCamposEstructuraMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_definirCamposEstructuraMnuActionPerformed
        definirCampos();
    }//GEN-LAST:event_definirCamposEstructuraMnuActionPerformed

    private void versionMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_versionMnuActionPerformed
        versionF();
    }//GEN-LAST:event_versionMnuActionPerformed

    private void altaServiciosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaServiciosBtnActionPerformed
        servicios();
    }//GEN-LAST:event_altaServiciosBtnActionPerformed

    private void abmPreciosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abmPreciosMnuActionPerformed
        abmPrecios();
    }//GEN-LAST:event_abmPreciosMnuActionPerformed

    private void serviciosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviciosBtnActionPerformed
        trabajos();
    }//GEN-LAST:event_serviciosBtnActionPerformed

    private void pdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfBtnActionPerformed
        pdf1();
    }//GEN-LAST:event_pdfBtnActionPerformed

    private void modificarServiciosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarServiciosMnuActionPerformed
        modificarServicios();
    }//GEN-LAST:event_modificarServiciosMnuActionPerformed

    private void modificarTrabajosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarTrabajosMnuActionPerformed
        modificarTrabajos();
    }//GEN-LAST:event_modificarTrabajosMnuActionPerformed

    private void trabajosPendientesMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trabajosPendientesMnuActionPerformed
        trabajosPendientes();
    }//GEN-LAST:event_trabajosPendientesMnuActionPerformed

    private void nuevoPeriodoMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoPeriodoMnuActionPerformed
        nuevoPeriodo();
    }//GEN-LAST:event_nuevoPeriodoMnuActionPerformed

    private void certificadosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_certificadosMnuActionPerformed
        certificados();
    }//GEN-LAST:event_certificadosMnuActionPerformed

    private void renovacionesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renovacionesBtnActionPerformed
        renovaciones();
    }//GEN-LAST:event_renovacionesBtnActionPerformed

    private void trabajosRealizadosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trabajosRealizadosMnuActionPerformed
        trabajosRealizados();
    }//GEN-LAST:event_trabajosRealizadosMnuActionPerformed

    private void trabajosPorPersonaMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trabajosPorPersonaMnuActionPerformed
        trabajosPorPersona();
    }//GEN-LAST:event_trabajosPorPersonaMnuActionPerformed

    private void abmImportesMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abmImportesMnuActionPerformed
        abmImportes();
    }//GEN-LAST:event_abmImportesMnuActionPerformed

    private void pendientesDeFacturarMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendientesDeFacturarMnuActionPerformed
        pendientesDeFacturar();
    }//GEN-LAST:event_pendientesDeFacturarMnuActionPerformed

    private void serviciosPorConsorcioMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviciosPorConsorcioMnuActionPerformed
        serviciosPorConsorcio();
    }//GEN-LAST:event_serviciosPorConsorcioMnuActionPerformed

    private void serviciosPorAdministracionAndConsorcioMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviciosPorAdministracionAndConsorcioMnuActionPerformed
        serviciosPorAdministracionAndConsorcio();
    }//GEN-LAST:event_serviciosPorAdministracionAndConsorcioMnuActionPerformed

    private void ventasPorTitularEntreFechasMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasPorTitularEntreFechasMnuActionPerformed
        ventasPorTitular();
    }//GEN-LAST:event_ventasPorTitularEntreFechasMnuActionPerformed

    private void facturasByConsorcioEntreFechasMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturasByConsorcioEntreFechasMnuActionPerformed
        facturasByConsorcioEntreFechas();
    }//GEN-LAST:event_facturasByConsorcioEntreFechasMnuActionPerformed

    private void cuentaCorrienteClienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuentaCorrienteClienteBtnActionPerformed
        ctaCteCliente();
    }//GEN-LAST:event_cuentaCorrienteClienteBtnActionPerformed

    private void cobranzaPorFechaMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cobranzaPorFechaMnuActionPerformed
        cobranzaEntreFechas();
    }//GEN-LAST:event_cobranzaPorFechaMnuActionPerformed

    private void facturasEntreFechasMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturasEntreFechasMnuActionPerformed
        facturasEntreFechas();
    }//GEN-LAST:event_facturasEntreFechasMnuActionPerformed

    private void facturaReparacionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaReparacionBtnActionPerformed
        facturaReparacion();
    }//GEN-LAST:event_facturaReparacionBtnActionPerformed

    private void certificadosAfipMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_certificadosAfipMnuActionPerformed
        certificadosAfip();
    }//GEN-LAST:event_certificadosAfipMnuActionPerformed

    private void testAfipMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testAfipMnuActionPerformed
        tstAfip();
    }//GEN-LAST:event_testAfipMnuActionPerformed

    private void facturarAbonosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturarAbonosBtnActionPerformed
        facturarAbonos2();
    }//GEN-LAST:event_facturarAbonosBtnActionPerformed

    private void cuentaCorrienteAdministracionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuentaCorrienteAdministracionBtnActionPerformed
        ctaCteAdmin();
    }//GEN-LAST:event_cuentaCorrienteAdministracionBtnActionPerformed

    private void taxtosPredefinidosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taxtosPredefinidosMnuActionPerformed
        textosPredefinidos();
    }//GEN-LAST:event_taxtosPredefinidosMnuActionPerformed

    private void abmAbonosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abmAbonosMnuActionPerformed
        abmAbonos();
    }//GEN-LAST:event_abmAbonosMnuActionPerformed

    private void abonosPendientesFacturarMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abonosPendientesFacturarMnuActionPerformed
        abonosPendientesFacturar();
    }//GEN-LAST:event_abonosPendientesFacturarMnuActionPerformed

    private void vencimientoAbonosPorPeriodoMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vencimientoAbonosPorPeriodoMnuActionPerformed
        vencimientoAbonosPorPeriodo();
    }//GEN-LAST:event_vencimientoAbonosPorPeriodoMnuActionPerformed

    private void tstPeriodoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tstPeriodoBtnActionPerformed
        verifPeriodo();
    }//GEN-LAST:event_tstPeriodoBtnActionPerformed

    private void recuperarDeAfipMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recuperarDeAfipMnuActionPerformed
        recuperarFromAfip();
    }//GEN-LAST:event_recuperarDeAfipMnuActionPerformed

    private void asignarFacturaMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarFacturaMnuActionPerformed
        asignarFactura();
    }//GEN-LAST:event_asignarFacturaMnuActionPerformed

    private void cuotasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuotasBtnActionPerformed
        cuotas();
    }//GEN-LAST:event_cuotasBtnActionPerformed

    private void cuotasAbonosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuotasAbonosBtnActionPerformed
        cuotasAbonos();
    }//GEN-LAST:event_cuotasAbonosBtnActionPerformed

    private void ncBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ncBtnActionPerformed
        notaCredito();
    }//GEN-LAST:event_ncBtnActionPerformed

    private void listadoParaCobranzaMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadoParaCobranzaMnuActionPerformed
        listadoParaCobranza();
    }//GEN-LAST:event_listadoParaCobranzaMnuActionPerformed

    private void mesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesBtnActionPerformed
        List<String> meses = new ArrayList<>();
        int i = 0;
        for (Mes m : Mes.values()) {
            String mes = m.getDetalle();
            meses.add(mes);
        }
        for (String st : meses) {
            System.out.println(st);
        }
        System.exit(0);
    }//GEN-LAST:event_mesBtnActionPerformed

    private void mesLetraBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesLetraBtnActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = new Date();
        try {
            fecha = sdf.parse(fechaTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        mesTxt.setText(UtilFrame.mesAnteriorEnLetras(fecha));
    }//GEN-LAST:event_mesLetraBtnActionPerformed

    private void carpetaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carpetaBtnActionPerformed
        String carp = "c:/alfa_y/facturas/" + carpetaTxt.getText();
        File carpeta = new File(carp);
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                JOptionPane.showMessageDialog(this, "YES");
                System.exit(0);
            }
        }
    }//GEN-LAST:event_carpetaBtnActionPerformed

    private void abonoFacturaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abonoFacturaBtnActionPerformed
        abonoFactura();
    }//GEN-LAST:event_abonoFacturaBtnActionPerformed

    private void co_ti_adBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_co_ti_adBtnActionPerformed
        coTiAd();
    }//GEN-LAST:event_co_ti_adBtnActionPerformed

    private void nombreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreBtnActionPerformed
        nombre();
    }//GEN-LAST:event_nombreBtnActionPerformed

    private void renovarAbonosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renovarAbonosMnuActionPerformed
        renovarAbonosVencidos();
    }//GEN-LAST:event_renovarAbonosMnuActionPerformed

    private void habilitarPeriodoParaFacturarMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habilitarPeriodoParaFacturarMnuActionPerformed
        habilitar();
    }//GEN-LAST:event_habilitarPeriodoParaFacturarMnuActionPerformed

    private void go2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go2BtnActionPerformed
        Date hoy = new Date();
        Date antes = new Date();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 15);
        antes = cal.getTime();
        System.out.println(hoy);
        System.out.println(antes);
        int dif = UtilAbonos.getDiferenciaEntreFechas(hoy, antes);
        System.out.println(dif);
    }//GEN-LAST:event_go2BtnActionPerformed

    private void asignadosPorRubroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignadosPorRubroBtnActionPerformed
        asignadosPorRubro();
    }//GEN-LAST:event_asignadosPorRubroBtnActionPerformed

    private void renglonesAbonosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renglonesAbonosBtnActionPerformed
//        renglones();
    }//GEN-LAST:event_renglonesAbonosBtnActionPerformed

    private void reciboReparacionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reciboReparacionBtnActionPerformed
        reciboReparacion();
    }//GEN-LAST:event_reciboReparacionBtnActionPerformed

    private void abmFondosRecibosReparaMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abmFondosRecibosReparaMnuActionPerformed
        abmFondosRecibosReparac();
    }//GEN-LAST:event_abmFondosRecibosReparaMnuActionPerformed

    private void ajustarPeriodoEnFcMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustarPeriodoEnFcMnuActionPerformed
        ajustarPeriodoEnFactura();
    }//GEN-LAST:event_ajustarPeriodoEnFcMnuActionPerformed

    private void cuotaSiguienteReparacionMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuotaSiguienteReparacionMnuActionPerformed
        cuotaSiguienteReparacion();
    }//GEN-LAST:event_cuotaSiguienteReparacionMnuActionPerformed

    private void testImporteAbonoMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testImporteAbonoMnuActionPerformed
        testImporteAbono();
    }//GEN-LAST:event_testImporteAbonoMnuActionPerformed

    private void habilitarPeriodoReparacionesMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habilitarPeriodoReparacionesMnuActionPerformed
        habilitarCuotaReparaciones();
    }//GEN-LAST:event_habilitarPeriodoReparacionesMnuActionPerformed

    private void sinRenglonesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinRenglonesBtnActionPerformed
        buscarSinRenglones();
        
    }//GEN-LAST:event_sinRenglonesBtnActionPerformed

    private void recibosAbonosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recibosAbonosBtnActionPerformed
        recibosAbonos();
    }//GEN-LAST:event_recibosAbonosBtnActionPerformed

    private void recibosAlFinDeAnioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recibosAlFinDeAnioBtnActionPerformed
        recAFinDeAnio();
    }//GEN-LAST:event_recibosAlFinDeAnioBtnActionPerformed

    private void tstBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tstBtnActionPerformed
        tst();
    }//GEN-LAST:event_tstBtnActionPerformed

    private void comprobantesPorTitularMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprobantesPorTitularMnuActionPerformed
        comprobantesPorTitular();
    }//GEN-LAST:event_comprobantesPorTitularMnuActionPerformed

    private void asignadasAndOriginalesMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignadasAndOriginalesMnuActionPerformed
        asignadasAndOriginales();
    }//GEN-LAST:event_asignadasAndOriginalesMnuActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abmAbonosMnu;
    private javax.swing.JMenuItem abmAdministradorMnu;
    private javax.swing.JMenuItem abmCategoriasMonotributoMnu;
    private javax.swing.JMenuItem abmConsorcioMnu;
    private javax.swing.JMenuItem abmFondosRecibosReparaMnu;
    private javax.swing.JMenuItem abmImportesMnu;
    private javax.swing.JMenuItem abmPersonaMnu;
    private javax.swing.JMenuItem abmPreciosMnu;
    private javax.swing.JMenuItem abmServicioMnu;
    private javax.swing.JButton abonoFacturaBtn;
    private javax.swing.JMenuItem abonosPendientesFacturarMnu;
    private javax.swing.JMenuItem ajustarPeriodoEnFcMnu;
    private javax.swing.JButton altaServiciosBtn;
    private javax.swing.JMenuItem asignadasAndOriginalesMnu;
    private javax.swing.JButton asignadosPorRubroBtn;
    private javax.swing.JMenuItem asignarFacturaMnu;
    private javax.swing.JMenuItem backupMnu;
    private javax.swing.JButton carpetaBtn;
    private javax.swing.JTextField carpetaTxt;
    private javax.swing.JMenuItem certificadosAfipMnu;
    private javax.swing.JMenuItem certificadosMnu;
    private javax.swing.JButton co_ti_adBtn;
    private javax.swing.JMenuItem cobranzaPorFechaMnu;
    private javax.swing.JMenuItem comprobantesPorTitularMnu;
    private javax.swing.JMenuItem crearEstructuraMnu;
    private javax.swing.JButton cuentaCorrienteAdministracionBtn;
    private javax.swing.JButton cuentaCorrienteClienteBtn;
    private javax.swing.JMenuItem cuotaSiguienteReparacionMnu;
    private javax.swing.JButton cuotasAbonosBtn;
    private javax.swing.JButton cuotasBtn;
    private javax.swing.JMenuItem definirCamposEstructuraMnu;
    private javax.swing.JButton facturaReparacionBtn;
    private javax.swing.JButton facturaTercerosBtn;
    private javax.swing.JButton facturarAbonosBtn;
    private javax.swing.JMenuItem facturasByConsorcioEntreFechasMnu;
    private javax.swing.JMenuItem facturasEntreFechasMnu;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JButton go2Btn;
    private javax.swing.JMenuItem habilitarPeriodoParaFacturarMnu;
    private javax.swing.JMenuItem habilitarPeriodoReparacionesMnu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem listadoParaCobranzaMnu;
    private javax.swing.JButton mesBtn;
    private javax.swing.JButton mesLetraBtn;
    private javax.swing.JTextField mesTxt;
    private javax.swing.JMenuItem modificarServiciosMnu;
    private javax.swing.JMenuItem modificarTrabajosMnu;
    private javax.swing.JButton ncBtn;
    private javax.swing.JButton nombreBtn;
    private javax.swing.JMenuItem nuevoPeriodoMnu;
    private javax.swing.JButton pdfBtn;
    private javax.swing.JMenuItem pendientesDeFacturarMnu;
    private javax.swing.JButton reciboReparacionBtn;
    private javax.swing.JButton recibosAbonosBtn;
    private javax.swing.JButton recibosAlFinDeAnioBtn;
    private javax.swing.JMenuItem recuperarDeAfipMnu;
    private javax.swing.JButton renglonesAbonosBtn;
    private javax.swing.JButton renovacionesBtn;
    private javax.swing.JMenuItem renovarAbonosMnu;
    private javax.swing.JButton salirBtn;
    private javax.swing.JButton serviciosBtn;
    private javax.swing.JMenuItem serviciosPorAdministracionAndConsorcioMnu;
    private javax.swing.JMenuItem serviciosPorConsorcioMnu;
    private javax.swing.JButton sinRenglonesBtn;
    private javax.swing.JMenuItem taxtosPredefinidosMnu;
    private javax.swing.JMenuItem testAfipMnu;
    private javax.swing.JMenuItem testImporteAbonoMnu;
    private javax.swing.JMenuItem trabajosPendientesMnu;
    private javax.swing.JMenuItem trabajosPorPersonaMnu;
    private javax.swing.JMenuItem trabajosRealizadosMnu;
    private javax.swing.JButton tstBtn;
    private javax.swing.JButton tstPeriodoBtn;
    private javax.swing.JMenuItem vencimientoAbonosPorPeriodoMnu;
    private javax.swing.JMenuItem ventasPorTitularEntreFechasMnu;
    private javax.swing.JMenuItem versionMnu;
    // End of variables declaration//GEN-END:variables

    private void salir() {
        int a = JOptionPane.showConfirmDialog(this, "CONFIRME SALIR DEL SISTEMA",
                "Atención", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }

    private void facturaTerceros() {
        FacturasTerceroFrame ftf = new FacturasTerceroFrame();
        ftf.setVisible(true);
        this.dispose();
    }

    private void abmAdministrador() {
        AbmAdministradorFrame aaf = new AbmAdministradorFrame();
        aaf.setVisible(true);
        this.dispose();
    }

    private void abmConsorcio() {
        AbmConsorcioFrame acf = new AbmConsorcioFrame();
        acf.setVisible(true);
        this.dispose();
    }

    private void abmPersona() {
        AbmPersonaFrame apf = new AbmPersonaFrame();
        apf.setVisible(true);
        this.dispose();
    }

    private void abmMonotributo() {
        AbmMonotributoFrame amf = new AbmMonotributoFrame();
        amf.setVisible(true);
        this.dispose();
    }

    private void backup() {
        BackupFrame bf = new BackupFrame();
        bf.setVisible(true);
        this.dispose();
    }

    private void abmRubros() {
        AbmRubrosFrame asf = new AbmRubrosFrame();
        asf.setVisible(true);
        this.dispose();
    }

    private void crearEstructura() {
        CrearEstructuraFrame cef = new CrearEstructuraFrame();
        cef.setVisible(true);
        this.dispose();
    }

    private void definirCampos() {
        DefinirCamposEstructuraFrame dcef = new DefinirCamposEstructuraFrame();
        dcef.setVisible(true);
        this.dispose();
    }

    private void versionF() {
        VersionFrame vf = new VersionFrame();
        vf.setVisible(true);
        this.dispose();
    }

    private void servicios() {
        NuevoServicioFrame ntf = new NuevoServicioFrame();
        ntf.setVisible(true);
        this.dispose();
    }

    private void abmPrecios() {
        AbmPreciosFrame apf = new AbmPreciosFrame();
        apf.setVisible(true);
        this.dispose();
    }

    private void trabajos() {
        NuevoTrabajoFrame asf = new NuevoTrabajoFrame();
        asf.setVisible(true);
        this.dispose();
    }

    private void pdf1() {
        try {
            new PDFBuilder().armarFacturaC();
        } catch (DocumentException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificarServicios() {
        ModificarServiciosFrame msf = new ModificarServiciosFrame();
        msf.setVisible(true);
        this.dispose();
    }

    private void modificarTrabajos() {
//        ModificarTrabajosFrame mtf = new ModificarTrabajosFrame();
//        mtf.setVisible(true);
//        this.dispose();
    }

    private void trabajosPendientes() {
        TrabajosPendientesFrame tpf = new TrabajosPendientesFrame();
        tpf.setVisible(true);
        this.dispose();
    }

    private void nuevoPeriodo() {
        NuevoPeriodoFrame npf = new NuevoPeriodoFrame();
        npf.setVisible(true);
        this.dispose();
    }

    private void certificados() {
        GenerarCertificadosFrame gcf = new GenerarCertificadosFrame();
        gcf.setVisible(true);
        this.dispose();
    }

    private void renovaciones() {
        RenovacionesFrame rf = new RenovacionesFrame();
        rf.setVisible(true);
        this.dispose();
    }

    private void trabajosRealizados() {
        TrabajosRealizadosFrame trf = new TrabajosRealizadosFrame();
        trf.setVisible(true);
        this.dispose();
    }

    private void trabajosPorPersona() {
        TrabajosPorPersonaFrame txpf = new TrabajosPorPersonaFrame();
        txpf.setVisible(true);
        this.dispose();
    }

    private void abmImportes() {
        AbmImportesFrame aif = new AbmImportesFrame();
        aif.setVisible(true);
        this.dispose();
    }

    private void serviciosSinTrabajos() {
        ServiciosSinTrabajosFrame sstf = new ServiciosSinTrabajosFrame();
        sstf.setVisible(true);
        this.dispose();
    }

    private void pendientesDeFacturar() {
        TrabajosPendientesDeFacturarFrame tpdf = new TrabajosPendientesDeFacturarFrame();
        tpdf.setVisible(true);
        this.dispose();
    }

    private void serviciosPorConsorcio() {
        ServiciosPorConsorcioFrame spcf = new ServiciosPorConsorcioFrame();
        spcf.setVisible(true);
        this.dispose();
    }

    private void serviciosPorAdministracionAndConsorcio() {
        ServiciosPorAdministracionAndConsorcioFrame spacf = new ServiciosPorAdministracionAndConsorcioFrame();
        spacf.setVisible(true);
        this.dispose();
    }

    private void ventasPorTitular() {
        VentasPorTitularFrame vxcf = new VentasPorTitularFrame();
        vxcf.setVisible(true);
        this.dispose();
    }

    private void facturasByConsorcioEntreFechas() {
        FacturasByConsorcioEntreFechasFrame fefbcf = new FacturasByConsorcioEntreFechasFrame();
        fefbcf.setVisible(true);
        this.dispose();
    }

    private void ctaCteCliente() {
        if (i == 0) {
            CuentaCorrienteClienteFrame1 cccf = new CuentaCorrienteClienteFrame1();
            cccf.setVisible(true);
        } else {
            CuentaCorrienteClienteFrame cccf = new CuentaCorrienteClienteFrame(null, null, null);
            cccf.setVisible(true);
            // ESTÁ ESTA OPCION - 1
        }
        this.dispose();
    }

    private void cobranzaEntreFechas() {
        CobranzaEntreFechasFrame ceff = new CobranzaEntreFechasFrame();
        ceff.setVisible(true);
        this.dispose();
    }

    private void facturasEntreFechas() {
        FacturasEntreFechasFrame feff = new FacturasEntreFechasFrame();
        feff.setVisible(true);
        this.dispose();
    }

    private void facturaReparacion() {
        FacturaReparacion2Frame fr = new FacturaReparacion2Frame();
        fr.setVisible(true);
        this.dispose();
    }

    private void certificadosAfip() {
        CertificadosAfipFrame ca = new CertificadosAfipFrame();
        ca.setVisible(true);
        this.dispose();
    }

    private void tstAfip() {
        TestAfipFrame taf = new TestAfipFrame();
        taf.setVisible(true);
        this.dispose();
    }

//    private void facturarAbonos() {
//        FacturarAbonosFrame faf = new FacturarAbonosFrame();
//        faf.setVisible(true);
//        this.dispose();
//    }
    private void textosPredefinidos() {
        AbmTextoPredefinidoFrame atpf = new AbmTextoPredefinidoFrame();
        atpf.setVisible(true);
        this.dispose();
    }

    private void abmAbonos() {
        AbmAbonosFrame aaf = new AbmAbonosFrame();
        aaf.setVisible(true);
        this.dispose();
    }

    private void ctaCteAdmin() {
        CuentaCorrienteAdministradorFrame ccaf = new CuentaCorrienteAdministradorFrame(null, null, null);
        ccaf.setVisible(true);
        this.dispose();
    }

    private void abonosPendientesFacturar() {
        AbonosPendienteFacturarFrame apff = new AbonosPendienteFacturarFrame();
        apff.setVisible(true);
        this.dispose();
    }

    private void vencimientoAbonosPorPeriodo() {
        VencimientoAbonosPorPeriodoFrame vappf = new VencimientoAbonosPorPeriodoFrame();
        vappf.setVisible(true);
        this.dispose();
    }

    private void verifPeriodo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMM");
        Calendar cal = Calendar.getInstance();
        Date fecha = new Date();
        String periodo1 = sdf2.format(fecha);
//        String nf = "31/01/2022";
//        try {
//            fecha = sdf.parse(nf);
//        } catch (ParseException ex) {
//            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
        cal.setTime(fecha);
        cal.set(Calendar.DAY_OF_MONTH, 1);
//        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
        fecha = cal.getTime();
        String periodo2 = sdf2.format(fecha);
        System.out.println(fecha);
        System.out.println(periodo1);
        System.out.println(periodo2);
        int p1 = Integer.valueOf(periodo1);
        int p2 = Integer.valueOf(periodo2);
        System.out.println(p1 > p2);
        System.exit(0);
    }

    private void recuperarFromAfip() {
        RecuperarDeAfipFrame rdaf = new RecuperarDeAfipFrame();
        rdaf.setVisible(true);
        this.dispose();
    }

    private void cuotas() {
        CuotasFrame cf = new CuotasFrame();
        cf.setVisible(true);
        this.dispose();
    }

    private void cuotasAbonos() {
        CuotaAbonoFrame caf = new CuotaAbonoFrame();
        caf.setVisible(true);
        this.dispose();
    }

    private void notaCredito() {
        NotaCreditoFrame ncf = new NotaCreditoFrame();
        ncf.setVisible(true);
        this.dispose();
    }

    private void asignarFactura() {
        AsignarFacturaFrame aff = new AsignarFacturaFrame();
        aff.setVisible(true);
        this.dispose();
    }

    private void listadoParaCobranza() {
        ListadoParaCobranzaFrame lpcf = new ListadoParaCobranzaFrame();
        lpcf.setVisible(true);
        this.dispose();
    }

    private void abonoFactura() {
        ReconstruirAbonoFacturaFrame raff = new ReconstruirAbonoFacturaFrame();
        raff.setVisible(true);
        this.dispose();
    }

    private void coTiAd() {
        ReconstruirComprobanteTitularAdministradorFrame rctaf = new ReconstruirComprobanteTitularAdministradorFrame();
        rctaf.setVisible(true);
        this.dispose();
    }

    private void nombre() {
        Consorcio consorcio = null; //371
        try {
            consorcio = new ConsorcioService().getConsorcioByCodigo(371);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Domicilio dm = consorcio.getDomicilio();
        String calle = dm.getCalle() + " " + dm.getNumero();
        System.out.println(calle);
        String calle2 = UtilFrame.getNombreSinEspacios(calle);
        mesTxt.setText(calle2);
    }

    private void renovarAbonosVencidos() {
        RenovarAbonosVencidosFrame ravf = new RenovarAbonosVencidosFrame();
        ravf.setVisible(true);
        this.dispose();
    }

    private void habilitar() {
        HabilitarPeriodoParaFacturarFrame hppff = new HabilitarPeriodoParaFacturarFrame();
        hppff.setVisible(true);
        this.dispose();
    }

    private void facturarAbonos2() {
        FacturarAbonos2Frame fa2f = new FacturarAbonos2Frame();
        fa2f.setVisible(true);
        this.dispose();
    }

    private void asignadosPorRubro() {
        AsignadosPorRubroFrame aprf = new AsignadosPorRubroFrame();
        aprf.setVisible(true);
        this.dispose();
    }

    private void renglones() {
        List<Comprobante> abonos = null;
        List<Comprobante> abonosSinRengl = new ArrayList<>();
        try {
            abonos = new ComprobanteService().getComprobantesActivos();
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (abonos != null && !abonos.isEmpty()) {
            for (Comprobante ab : abonos) {
                List<ComprobanteRenglones> renglones = null;
                Double tt1=0.0;
                try {
                    renglones = new ComprobanteRenglonesService().getRenglonesPorComprobante(ab);
                } catch (Exception ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (renglones == null || renglones.isEmpty()) {
                    abonosSinRengl.add(ab);
                } else {
//                    for(RenglonAbono r1:renglones){
//                        
//                    }
                }
            }
            for (Comprobante abo : abonosSinRengl) {
                System.out.println(abo.getId());
            }
        }
    }

    private void reciboReparacion() {
        ReciboReparacion2Frame fr = new ReciboReparacion2Frame();
        fr.setVisible(true);
        this.dispose();
    }

    private void abmFondosRecibosReparac() {
        AbmFondosRecibosFrame afrf = new AbmFondosRecibosFrame();
        afrf.setVisible(true);
        this.dispose();
    }

    private void ajustarPeriodoEnFactura() {
        VerFacturasParaAjustarPeriodoFrame vfpapf = new VerFacturasParaAjustarPeriodoFrame();
        vfpapf.setVisible(true);
        this.dispose();
    }

    private void cuotaSiguienteReparacion() {
        CuotaSiguienteReparacionesFrame csrf = new CuotaSiguienteReparacionesFrame();
        csrf.setVisible(true);
        this.dispose();
    }

    private void testImporteAbono() {
        TestImporteAbonoFrame tiaf = new TestImporteAbonoFrame();
        tiaf.setVisible(true);
        this.dispose();
    }

    private void habilitarCuotaReparaciones() {
        HabilitarPeriodoParaFacturarReparacionesFrame hppfrf = new HabilitarPeriodoParaFacturarReparacionesFrame();
        hppfrf.setVisible(true);
        this.dispose();
    }

    private void recibosAbonos() {
        ReciboAbonos2Frame ra2f = new ReciboAbonos2Frame();
        ra2f.setVisible(true);
        this.dispose();
    }

    private void recAFinDeAnio() {
        RecibosFinDeAnioFrame rfdaf = new RecibosFinDeAnioFrame();
        rfdaf.setVisible(true);
        this.dispose();
    }

    private void buscarSinRenglones() {
        SinRenglonesFrame srf = new SinRenglonesFrame();
        srf.setVisible(true);
        this.dispose();
    }

    private void tst() {
        NewJFrame nf = new NewJFrame();
        nf.setVisible(true);
        this.dispose();
    }

    private void comprobantesPorTitular() {
        ComprobantesPorTitularFrame cptf = new ComprobantesPorTitularFrame();
        cptf.setVisible(true);
        this.dispose();
    }

    private void asignadasAndOriginales() {
        AsignadasAndOriginalesFrame aof = new AsignadasAndOriginalesFrame();
        aof.setVisible(true);
        this.dispose();
    }
}
