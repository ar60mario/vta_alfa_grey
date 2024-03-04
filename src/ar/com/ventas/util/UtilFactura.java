/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.util;

import ar.com.ventas.entities.Abono;
import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.ComprobanteRenglones;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.CuentaCorrienteCliente;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.FondoRecibo;
import ar.com.ventas.entities.NuevoCae;
import ar.com.ventas.entities.RenglonAbono;
import ar.com.ventas.entities.RenglonTrabajoReparacion;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.TicketTime;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.estructuras.Mes;
import ar.com.ventas.services.AbonoService;
import ar.com.ventas.services.ComprobanteRenglonesService;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.ConfiguracionService;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.services.CuentaCorrienteClienteService;
import ar.com.ventas.services.TitularCuitService;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
public class UtilFactura {

    private static void llenarMeses() {
        for (Mes mes : Mes.values()) {
            meses.add(mes);
        }
    }

    private static List<Mes> meses = new ArrayList<>();
//    public static String saveComprobante(Consorcio cliente, TitularCuit tc, Abono abono, List<RenglonAbono> renglones, Date da1, Date da2, Date da3, Date da4, Integer ps) {
//        String codigoCategoria = tc.getCategoria();
//        Integer tipo_inscripcion = tc.getTipoInscipcion(); // 6-Monotributo
//        Rubro rubro = abono.getRubro();
//        String letra = "C";
//        if (tipo_inscripcion.equals(6)) {
//            letra = "C";
//        }
//        String resultado = "N";
//        if (letra.equals("C")) {
//            NuevoCae nuevoCae = UtilAfip.getNuevoCaeFcC(cliente, abono, da1, da2, da3, da4, ps);
////        TicketTime tt = UtilAfip.solicitarNuevoTicket(titu, certif, llave);
////        int ufc = UtilAfip.getUltimaFcC(ptoVta, cui1, tt.getToken(), tt.getSign());
////        int unc = UtilAfip.getUltimaNcC(ptoVta, cui1, tt.getToken(), tt.getSign());
//            if (nuevoCae != null) {
//                String aceptado = nuevoCae.getEstado();
//                if (aceptado.equals("A")) {
//                    Factura fc = new Factura();
//                    fc.setCliente(cliente);
//                    fc.setFecha(da1);
//                    fc.setCae(nuevoCae.getCae());
//                    fc.setFechaVencimCae(nuevoCae.getFechaCae());
//                    fc.setImporte(abono.getImporte());
//                    fc.setSucursal(cliente.getTitular().getSucursal());
//                    fc.setAbonoDesde(da2);
//                    fc.setAbonoHasta(da3);
//                    fc.setVencimientoFactura(da4);
//                    fc.setNumero(nuevoCae.getNumero());
//                    fc.setProductoServicio(ps);
//                    fc.setTipoDoc(11);
//                    fc.setRubro(rubro);
//                    List<RenglonFactura> renglonesFc = new ArrayList<>();
//                    for (RenglonAbono ra : renglones) {
//                        RenglonFactura rf = new RenglonFactura();
//                        rf.setFactura(fc);
//                        rf.setImporte(ra.getImporte());
//                        rf.setOrden(ra.getOrden());
//                        rf.setTexto(ra.getTexto());
//                        renglonesFc.add(rf);
//                    }
//                    try {
//                        new FacturaService().saveFacturaCompleta(fc, renglonesFc);
//                        new AbonoService().updateAbono(abono);
//                        resultado = "A";
//                    } catch (Exception ex) {
//                        Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        }
//        return resultado;
//    }

    public static String saveFactura(Consorcio cliente, TitularCuit tc, Abono abono,
            List<RenglonAbono> renglones, Date da1, Date da2, Date da3, Date da4, Integer ps) {
//        String codigoCategoria = tc.getCategoria();
        Rubro rubro = abono.getRubro();
        System.out.println(cliente.getDomicilio().getCalle());
        System.out.println(tc);
        System.out.println(abono);
        System.out.println(renglones);
        System.out.println(da1);
        System.out.println(da2);
        System.out.println(da3);
        System.out.println(da4);
        System.out.println(ps);
        Administrador adm = cliente.getAdministrador();
        Long id_admin = adm.getId();
        String letra = "C";
//        Integer tipo_inscripcion = tc.getTipoInscipcion(); // 6-Monotributo
//        if (tipo_inscripcion.equals(6)) {
//            letra = "C";
//        }
        Integer tipoComprobante = 11;
        if (tc.getTipoInscipcion().equals(6)) {
            tipoComprobante = 11;
            letra = "C";
        }
        if (tc.getTipoInscipcion().equals(1)) {
            Integer inscrCons = cliente.getTipoInscripcion();
            if (inscrCons.equals(1)) {
                tipoComprobante = 1;
                letra = "A";
            }
            if (inscrCons.equals(6)) {
                tipoComprobante = 1;
                letra = "A";
            }
            if (inscrCons.equals(4)) {
                tipoComprobante = 6;
                letra = "B";
            }
            if (inscrCons.equals(5)) {
                tipoComprobante = 6;
                letra = "B";
            }
        }
        String resultado = "N";
        if (letra.equals("C")) {
            NuevoCae nuevoCae = UtilAfip.getNuevoCaeFcC(cliente, tc, abono, da1, da2, da3, da4, ps);
//        TicketTime tt = UtilAfip.solicitarNuevoTicket(titu, certif, llave);
//        int ufc = UtilAfip.getUltimaFcC(ptoVta, cui1, tt.getToken(), tt.getSign());
//        int unc = UtilAfip.getUltimaNcC(ptoVta, cui1, tt.getToken(), tt.getSign());
//            NuevoCae nuevoCae = new NuevoCae();
//            nuevoCae.setCae(123L);
//            nuevoCae.setErrMsj("");
//            nuevoCae.setEstado("A");
//            nuevoCae.setExcepcion("");
//            nuevoCae.setFechaCae(new Date());
//            nuevoCae.setFechaPeriodoDesde(da2);
//            nuevoCae.setFechaPeriodoHasta(da3);
//            nuevoCae.setFechaVencimiento(da4);
//            nuevoCae.setFechaVencimientoPago(da4);
//            nuevoCae.setMotivo("");
//            nuevoCae.setNumero(15000);
//            nuevoCae.setObservaciones("");
//            nuevoCae.setSucursal(99);

            DecimalFormat df = new DecimalFormat("#0.00");
            Double calculoCuota = abono.getImporte() / abono.getCuotas();
            String calculoString = df.format(calculoCuota).replace(",", ".");
            Double totalFacturaAfip = Double.valueOf(calculoString);
            if (nuevoCae != null) {
                String aceptado = nuevoCae.getEstado();
                if (aceptado.equals("A")) {
                    Comprobante fc = new Comprobante();
                    Domicilio dmC = cliente.getDomicilio();
                    Domicilio dmT = tc.getDomicilio();
                    fc.setCae(nuevoCae.getCae());
                    fc.setCalleNroPisoDtoCliente(dmC.getCalle() + " " + dmC.getNumero());
                    fc.setCantidadCuotas(abono.getCuotas());
                    fc.setCodigoCliente(cliente.getCodigo());
                    fc.setCodigoComprobante(11);
                    fc.setCodigoPostalAndLocalidadCliente(dmC.getCodigoPostal() + " " + dmC.getLocalidad());
                    fc.setCodigoPostalAndLocalidadTitular(dmT.getCodigoPostal() + " " + dmT.getLocalidad());
                    fc.setCuitCliente(cliente.getCuit());
                    fc.setCuitTitular(tc.getCuit());
                    fc.setCuotasPagadas(abono.getCuotaFacturada() + 1);
                    fc.setDomicilioTitular(dmT.getCalle() + " " + dmT.getNumero());
                    fc.setFecha(da1);
                    String textoP = "";
                    if (abono.getRubro().getCodigo().equals(3)) {
                        if (abono.getTextoPeriodo().equals(0)) {
                            textoP = UtilFrame.mesAnteriorEnLetras(new Date());
                        } else {
                            textoP = UtilFrame.mesActualEnLetras(new Date());
                        }
                    } else {
                        textoP = "";
                    }
                    fc.setId_administrador(id_admin);
                    fc.setPeriodo(textoP);
                    fc.setFechaInicioActividades(tc.getFechaInicioActividades());
                    fc.setFechaPeriodoDesde(da2);
                    fc.setFechaPeriodoHasta(da3);
                    fc.setFechaVencimientoCae(nuevoCae.getFechaCae());
                    fc.setFechaVencimientoPago(da4);
                    fc.setGravado(calculoCuota);
                    fc.setId_original(0L);
                    fc.setIibb(tc.getIibb());
                    fc.setIva(0.0);
                    fc.setLetra(letra);
                    fc.setLetraComprobanteAsociado(letra);
                    fc.setNumero(nuevoCae.getNumero());
                    fc.setNumeroComprobanteAsociado(0);
                    fc.setOriginal(true);
                    fc.setPagado(0.0);
                    fc.setPdfGenerado(false);
                    fc.setProductoServicio(ps);
                    fc.setProvinciaCliente(dmC.getProvincia());
                    fc.setProvinciaTitular(dmT.getProvincia());
                    fc.setRazonSocialCliente(cliente.getNombre());
                    fc.setRazonSocialTitular(tc.getPersona().getApellidoNombre());
                    fc.setRubro(rubro);
                    fc.setSucursal(tc.getSucursal());
                    fc.setSucursalComprobanteAsociado(0);
                    fc.setTexto1("");
                    fc.setTexto2("");

                    fc.setTipoComprobanteAsociado(0);
                    fc.setTipoDocumento(cliente.getDocumentoTipo());
                    fc.setTipoEmision(abono.getTipoFacturacion());
                    fc.setTipoInscripcion(cliente.getTipoInscripcion().toString());
                    fc.setTotal(totalFacturaAfip);
                    CuentaCorrienteCliente ccc = new CuentaCorrienteCliente();
                    ccc.setComprobante(fc);
                    ccc.setConsorcio(cliente);
                    ccc.setDebe(calculoCuota);
                    ccc.setFecha(da1);
                    ccc.setHaber(0.0);
                    ccc.setRecibo(null);
                    ccc.setTipoComprobante(11);
                    Double sal = cliente.getSaldo();
                    sal += calculoCuota;
                    cliente.setSaldo(sal);
                    ccc.setSaldo(sal);
                    List<ComprobanteRenglones> renglonesFc = new ArrayList<>();
                    for (RenglonAbono ra : renglones) {
                        ComprobanteRenglones rf = new ComprobanteRenglones();
                        rf.setComprobante(fc);
                        rf.setImporte(ra.getImporte());
//                        rf.setOrden(ra.getOrden());
                        rf.setDetalle(ra.getTexto());
                        renglonesFc.add(rf);
                    }
                    if (abono.getCuotaFacturada() != null) {
                        int cta = abono.getCuotaFacturada() + 1;
                        abono.setCuotaFacturada(cta);
                    } else {
                        abono.setCuotaFacturada(1);
                    }
                    abono.setPendiente(false);
                    try {
                        fc = new ComprobanteService().saveComprobante(fc);
                        for (ComprobanteRenglones ra : renglonesFc) {
                            ra.setComprobante(fc);
                            ra = new ComprobanteRenglonesService().saveRenglon(ra);
                        }
                        new AbonoService().updateAbono(abono);
                        new ConsorcioService().updateConsorcio(cliente);
                        ccc.setComprobante(fc);
                        new CuentaCorrienteClienteService().saveCuentaCorrienteCliente(ccc);

                        resultado = "A";
                    } catch (Exception ex) {
                        Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                Domicilio dm = cliente.getDomicilio();
                String calle = dm.getCalle() + " " + dm.getNumero();
                JOptionPane.showMessageDialog(null, "NO SE GENERO CAE NUEVO " + calle);
                resultado = "N";
            }
        } else {
            if (letra.equals("A")) {

            } else {
                // letra es B

            }
        }
        return resultado;
    }

    public static String saveFacturaReparacion(Consorcio cliente, TitularCuit tc,
            List<ComprobanteRenglones> renglones, Double total, Rubro rubro, Date da1, Date da4, Integer ps, Integer cuotas) {
//        Rubro rubro = abono.getRubro();
        Date da2 = da1;
        Date da3 = da1;
//        Abono abono = null;
        System.out.println(cliente.getDomicilio().getCalle());
        System.out.println(tc);
//        System.out.println(abono);
        System.out.println(renglones);
        System.out.println(da1);
        System.out.println(da2);
        System.out.println(da3);
        System.out.println(da4);
        System.out.println(ps);
        String letra = "C";
        Integer tipo_inscripcion = tc.getTipoInscipcion(); // 6-Monotributo
        if (tipo_inscripcion.equals(6)) {
            letra = "C";
        }
        String resultado = "N";
        if (letra.equals("C")) {
            NuevoCae nuevoCae = UtilAfip.getNuevoCaeFcCReparacion(cliente, tc, total, da1, da2, da3, da4, ps);
//        TicketTime tt = UtilAfip.solicitarNuevoTicket(titu, certif, llave);
//        int ufc = UtilAfip.getUltimaFcC(ptoVta, cui1, tt.getToken(), tt.getSign());
//        int unc = UtilAfip.getUltimaNcC(ptoVta, cui1, tt.getToken(), tt.getSign());
//            NuevoCae nuevoCae = new NuevoCae();
//            nuevoCae.setCae(123L);
//            nuevoCae.setErrMsj("");
//            nuevoCae.setEstado("A");
//            nuevoCae.setExcepcion("");
//            nuevoCae.setFechaCae(new Date());
//            nuevoCae.setFechaPeriodoDesde(da2);
//            nuevoCae.setFechaPeriodoHasta(da3);
//            nuevoCae.setFechaVencimiento(da4);
//            nuevoCae.setFechaVencimientoPago(da4);
//            nuevoCae.setMotivo("");
//            nuevoCae.setNumero(15000);
//            nuevoCae.setObservaciones("");
//            nuevoCae.setSucursal(99);

            DecimalFormat df = new DecimalFormat("#0.00");

            String calculoString = df.format(total).replace(",", ".");
            Double totalFacturaAfip = Double.valueOf(calculoString);
            if (nuevoCae != null) {
                String aceptado = nuevoCae.getEstado();
                if (aceptado.equals("A")) {
                    Comprobante fc = new Comprobante();
                    Domicilio dmC = cliente.getDomicilio();
                    Domicilio dmT = tc.getDomicilio();
                    Administrador ad = cliente.getAdministrador();
                    Long id_adm = ad.getId();
                    fc.setCae(nuevoCae.getCae());
                    fc.setCalleNroPisoDtoCliente(dmC.getCalle() + " " + dmC.getNumero());
                    fc.setCantidadCuotas(cuotas);
                    fc.setCodigoCliente(cliente.getCodigo());
                    fc.setCodigoComprobante(11);
                    fc.setCodigoPostalAndLocalidadCliente(dmC.getCodigoPostal() + " " + dmC.getLocalidad());
                    fc.setCodigoPostalAndLocalidadTitular(dmT.getCodigoPostal() + " " + dmT.getLocalidad());
                    fc.setCuitCliente(cliente.getCuit());
                    fc.setCuitTitular(tc.getCuit());
                    fc.setCuotasPagadas(1);
                    fc.setDomicilioTitular(dmT.getCalle() + " " + dmT.getNumero());
                    fc.setFecha(da1);
                    fc.setOriginal(true);
                    fc.setId_original(0L);
                    fc.setId_administrador(id_adm);
                    String textoP = "";
//                    if (rubro.getCodigo().equals(3)) {
//                        if (abono.getTextoPeriodo().equals(0)) {
//                            textoP = UtilFrame.mesAnteriorEnLetras(new Date());
//                        } else {
//                            textoP = UtilFrame.mesActualEnLetras(new Date());
//                        }
//                    } else {
//                        textoP = "";
//                    }
                    fc.setPeriodo(textoP);
                    fc.setFechaInicioActividades(tc.getFechaInicioActividades());
                    fc.setFechaPeriodoDesde(da2);
                    fc.setFechaPeriodoHasta(da3);
                    fc.setFechaVencimientoCae(nuevoCae.getFechaCae());
                    fc.setFechaVencimientoPago(da4);
                    fc.setGravado(total);
                    fc.setIibb(tc.getIibb());
                    fc.setIva(0.0);
                    fc.setLetra(letra);
                    fc.setLetraComprobanteAsociado(letra);
                    fc.setNumero(nuevoCae.getNumero());
                    fc.setNumeroComprobanteAsociado(0);
                    fc.setPagado(0.0);
                    fc.setPdfGenerado(false);
                    fc.setProductoServicio(ps);
                    fc.setProvinciaCliente(dmC.getProvincia());
                    fc.setProvinciaTitular(dmT.getProvincia());
                    fc.setRazonSocialCliente(cliente.getNombre());
                    fc.setRazonSocialTitular(tc.getPersona().getApellidoNombre());
                    fc.setRubro(rubro);
                    fc.setSucursal(tc.getSucursal());
                    fc.setSucursalComprobanteAsociado(0);
                    fc.setTexto1("");
                    fc.setTexto2("");

                    fc.setTipoComprobanteAsociado(0);
                    fc.setTipoDocumento(cliente.getDocumentoTipo());
                    fc.setTipoEmision(4);
                    fc.setTipoInscripcion(cliente.getTipoInscripcion().toString());
                    fc.setTotal(totalFacturaAfip);
                    fc.setPeriodoHabilitado(false);
                    if (cuotas > 1) {
                        fc.setCuotaSiguienteFacturada(false);
                    } else {
                        fc.setCuotaSiguienteFacturada(true);
                    }
                    CuentaCorrienteCliente ccc = new CuentaCorrienteCliente();
                    ccc.setComprobante(fc);
                    ccc.setConsorcio(cliente);
                    ccc.setDebe(totalFacturaAfip);
                    ccc.setFecha(da1);
                    ccc.setHaber(0.0);
                    ccc.setRecibo(null);
                    ccc.setTipoComprobante(11);
                    Double sal = cliente.getSaldo();
                    sal += totalFacturaAfip;
                    cliente.setSaldo(sal);
                    ccc.setSaldo(sal);
//                    List<ComprobanteRenglones> renglonesFc = new ArrayList<>();
//                    for (ComprobanteRenglones ra : renglones) {
//                        ComprobanteRenglones rf = new ComprobanteRenglones();
//                        rf.setComprobante(fc);
//                        rf.setImporte(ra.getImporte());
////                        rf.setOrden(ra.getOrden());
//                        rf.setDetalle(ra.getContenido());
//                        renglonesFc.add(rf);
//                    }
//                    if (abono.getCuotaFacturada() != null) {
//                        int cta = abono.getCuotaFacturada() + 1;
//                        abono.setCuotaFacturada(cta);
//                    } else {
//                        abono.setCuotaFacturada(1);
//                    }
//                    abono.setPendiente(false);
                    try {
                        fc = new ComprobanteService().saveComprobante(fc);
                        for (ComprobanteRenglones ra : renglones) {
                            ra.setComprobante(fc);
                            ra = new ComprobanteRenglonesService().saveRenglon(ra);
                        }
//                        new AbonoService().updateAbono(abono);
                        new ConsorcioService().updateConsorcio(cliente);
                        ccc.setComprobante(fc);
                        new CuentaCorrienteClienteService().saveCuentaCorrienteCliente(ccc);

                        resultado = "A";
                    } catch (Exception ex) {
                        Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return resultado;
    }

    public static String saveReciboReparacion(Consorcio cliente, FondoRecibo fr,
            List<ComprobanteRenglones> renglones, Double total, Rubro rubro, Date da1, Date da4, Integer ps, Integer cuotas) {
        Date da2 = da1;
        Date da3 = da1;
        String letra = "X";
        int num = 0;
        Configuracion cnfg = null;
        try {
            cnfg = new ConfiguracionService().getConfiguracion(1L);
        } catch (Exception ex) {
            Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        num = cnfg.getNroRx();
        num += 1;
        cnfg.setNroRx(num);
        String resultado = "N";

        DecimalFormat df = new DecimalFormat("#0.00");
        Administrador admin = cliente.getAdministrador();
        String calculoString = df.format(total).replace(",", ".");
        BigDecimal bd_total_rc = new BigDecimal(calculoString);
//        BigDecimal bd_cuotas = new BigDecimal(cuotas.toString());;
//        try {
//            bd_cuotas 
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "IMPORTE NO ES MULTIPLO DE CUOTAS");
//            return resultado;
//        }
//        BigDecimal bd_importe_cuota = bd_total_rc.divide(bd_cuotas);
        TitularCuit tc = fr.getTitular();
        Comprobante fc = new Comprobante();
        Domicilio dmC = cliente.getDomicilio();
        Domicilio dmT = fr.getTitular().getDomicilio();
        String textoP = "";
        fc.setCae(0L);
        fc.setCalleNroPisoDtoCliente(dmC.getCalle() + " " + dmC.getNumero());
        fc.setCantidadCuotas(cuotas);
        fc.setCodigoCliente(cliente.getCodigo());
        fc.setCodigoComprobante(5);
        fc.setCodigoPostalAndLocalidadCliente(dmC.getCodigoPostal() + " " + dmC.getLocalidad());
        fc.setCodigoPostalAndLocalidadTitular(dmT.getCodigoPostal() + " " + dmT.getLocalidad());
        fc.setCuitCliente(cliente.getCuit());
        fc.setCuitTitular(tc.getCuit());
        fc.setCuotasPagadas(1);
        if (cuotas > 1) {
            fc.setCuotaSiguienteFacturada(false);
        } else {
            fc.setCuotaSiguienteFacturada(true);
        }
        fc.setDomicilioTitular(dmT.getCalle() + " " + dmT.getNumero());
        fc.setFecha(da1);
        fc.setOriginal(false);

        fc.setPeriodo(textoP);
        fc.setFechaInicioActividades(null);
        fc.setFechaPeriodoDesde(da2);
        fc.setFechaPeriodoHasta(da3);
        fc.setFechaVencimientoCae(null);
        fc.setFechaVencimientoPago(da4);
        fc.setGravado(total);
        fc.setIibb("");
        fc.setIva(0.0);
        fc.setLetra(letra);
        fc.setLetraComprobanteAsociado("");
        fc.setNumero(num);
        fc.setNumeroComprobanteAsociado(0);
        fc.setPagado(0.0);
        fc.setPdfGenerado(false);
        fc.setProductoServicio(ps);
        fc.setProvinciaCliente(dmC.getProvincia());
        fc.setProvinciaTitular(dmT.getProvincia());
        fc.setRazonSocialCliente(cliente.getNombre());
        fc.setRazonSocialTitular("");
        fc.setRubro(rubro);
        fc.setSucursal(0);
        fc.setSucursalComprobanteAsociado(0);
        fc.setTexto1("");
        fc.setTexto2("");
        fc.setFondo(fr);
        fc.setTipoComprobanteAsociado(0);
        fc.setTipoDocumento(cliente.getDocumentoTipo());
        fc.setTipoEmision(4);
        fc.setTipoInscripcion("");
        fc.setTotal(bd_total_rc.doubleValue());
        fc.setId_administrador(admin.getId());
        fc.setPeriodoHabilitado(false);
        CuentaCorrienteCliente ccc = new CuentaCorrienteCliente();
        ccc.setComprobante(fc);
        ccc.setConsorcio(cliente);
        ccc.setDebe(bd_total_rc.doubleValue());
        ccc.setFecha(da1);
        ccc.setHaber(0.0);
        ccc.setRecibo(null);
        ccc.setTipoComprobante(11);
        Double sal = cliente.getSaldo();
        sal += bd_total_rc.doubleValue();
        cliente.setSaldo(sal);
        ccc.setSaldo(sal);

        try {
            fc = new ComprobanteService().saveComprobante(fc);
            for (ComprobanteRenglones ra : renglones) {
                ra.setComprobante(fc);
                ra = new ComprobanteRenglonesService().saveRenglon(ra);
            }
//                        new AbonoService().updateAbono(abono);
            new ConsorcioService().updateConsorcio(cliente);
            ccc.setComprobante(fc);
            new CuentaCorrienteClienteService().saveCuentaCorrienteCliente(ccc);
            new ConfiguracionService().updateConfiguracion(cnfg);
            resultado = "A";
        } catch (Exception ex) {
            Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR 510");
            resultado = "N";
        }

        return resultado;
    }

    public static String saveFacturaVinculada(Consorcio cliente, Consorcio consorcioVinculado,
            Abono abono, List<RenglonAbono> renglones) {

        DecimalFormat df = new DecimalFormat("#0.00");
        Rubro rubro = abono.getRubro();
        Double calculoCuota = abono.getImporte() / abono.getCuotas();
        String calculoString = df.format(calculoCuota).replace(",", ".");
        Double totalFacturaAfip = Double.valueOf(calculoString);
        Comprobante ultFcConsQueSeFactura;
        try {
            ultFcConsQueSeFactura = new ComprobanteService().getComprobantesByConsorcioAndRubro(cliente, rubro);
        } catch (Exception ex) {
            Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(cliente);
            System.out.println(consorcioVinculado);
            System.out.println(abono);
            System.out.println(renglones);
            System.out.println("1");
            return "X";
        }
        System.out.println(ultFcConsQueSeFactura);
        System.out.println(ultFcConsQueSeFactura.getFecha());
        System.out.println(ultFcConsQueSeFactura.getCalleNroPisoDtoCliente());
//        abono.get
//        System.exit(0);

        String cuitTc1 = ultFcConsQueSeFactura.getCuitTitular();

        Comprobante ultFcConsVinculado;
        try {
            ultFcConsVinculado = new ComprobanteService().getComprobantesByConsorcioAndRubro(consorcioVinculado, rubro);
        } catch (Exception ex) {
            Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(cliente);
            System.out.println(consorcioVinculado);
            System.out.println(abono);
            System.out.println(renglones);
            System.out.println("2");
            return "X";
        }
        String cuitTc2 = ultFcConsVinculado.getCuitTitular();
        Double importe;
        if (cuitTc1.equals(cuitTc2)) { // titulares iguales OK
            if (!verificarTitularActivo(cuitTc1)) {
                JOptionPane.showMessageDialog(null, "EL TITULAR ESTA INACTIVO "
                        + ultFcConsQueSeFactura.getCalleNroPisoDtoCliente());
                return "N";
            }

//            importe = ultFcConsVinculado.getTotal();
            //ultFcConsQueSeFactura
            importe = ultFcConsQueSeFactura.getTotal();
            if (totalFacturaAfip.equals(importe)) { // importes iguales OK
                Calendar cal2 = Calendar.getInstance();
                Integer mes2 = cal2.get(Calendar.MONTH);
                Calendar cal3 = Calendar.getInstance();
//                cal3.setTime(ultFcConsVinculado.getFecha());
                cal3.setTime(ultFcConsQueSeFactura.getFecha());
                Integer mes3 = cal3.get(Calendar.MONTH);
                if (!mes2.equals(mes3)) { // factura OTRO mes SALE
                    System.out.println(cal2);
                    System.out.println(cal3);
                    System.out.println(mes2);
                    System.out.println(mes3);
                    System.out.println(ultFcConsVinculado.getFecha());
                    System.out.println(cliente);
                    System.out.println(consorcioVinculado);
                    System.out.println(abono);
                    System.out.println(renglones);
                    System.out.println("3");
                    return "X";
                }
            } else {
                System.out.println(ultFcConsVinculado.getCalleNroPisoDtoCliente());
                JOptionPane.showMessageDialog(null, ultFcConsVinculado.getCalleNroPisoDtoCliente());
                System.out.println(ultFcConsVinculado.getId());
                System.out.println(ultFcConsVinculado.getTotal());
                System.out.println(importe);
                System.out.println(totalFacturaAfip);
                System.out.println(cliente);
                System.out.println(consorcioVinculado);
                System.out.println(abono);
                System.out.println(renglones);
                System.out.println("4");
                return "4";
            }
        } else {
            System.out.println("5");
            return "X";
        }
        TitularCuit tc = null;
        try {
            tc = new TitularCuitService().getTitularActivoByCuit(cuitTc2);
        } catch (Exception ex) {
            Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(cliente);
            System.out.println(consorcioVinculado);
            System.out.println(abono);
            System.out.println(renglones);
            System.out.println("6");
            return "X";
        }
        String letra = "C"; // 6-Monotributo
        String resultado = "N";
        if (letra.equals("C")) {
            if (abono.getCuotaFacturada() + 1 > abono.getCuotas()) {
                if (!rubro.getId().equals(4L)) {
                    System.out.println(abono.getCuotaFacturada());
                    System.out.println(abono.getCuotas());
                    System.out.println(cliente);
                    System.out.println(consorcioVinculado);
                    System.out.println(abono);
                    System.out.println(renglones);
                    System.out.println("7");
                    return "X";
                }
            }
            Comprobante fc = new Comprobante();
            Domicilio dmC = consorcioVinculado.getDomicilio();
            Domicilio dmT = tc.getDomicilio();
            Long id_adm = consorcioVinculado.getAdministrador().getId();
            fc.setCae(ultFcConsQueSeFactura.getCae());
            fc.setCalleNroPisoDtoCliente(dmC.getCalle() + " " + dmC.getNumero());
            fc.setCantidadCuotas(abono.getCuotas());
            fc.setCodigoCliente(consorcioVinculado.getCodigo());
            fc.setCodigoComprobante(11);
            fc.setCodigoPostalAndLocalidadCliente(dmC.getCodigoPostal() + " " + dmC.getLocalidad());
            fc.setCodigoPostalAndLocalidadTitular(dmT.getCodigoPostal() + " " + dmT.getLocalidad());
            fc.setCuitCliente(consorcioVinculado.getCuit());
            fc.setCuitTitular(tc.getCuit());
            fc.setCuotasPagadas(abono.getCuotaFacturada() + 1);
            fc.setDomicilioTitular(dmT.getCalle() + " " + dmT.getNumero());
            fc.setFecha(ultFcConsQueSeFactura.getFecha());
            String textoP = "";
            if (rubro.getCodigo().equals(3)) {
                if (abono.getTextoPeriodo().equals(0)) {
                    textoP = UtilFrame.mesAnteriorEnLetras(new Date());
                } else {
                    textoP = UtilFrame.mesActualEnLetras(new Date());
                }
            } else {
                textoP = "";
            }
            fc.setPeriodo(textoP);
            fc.setFechaInicioActividades(tc.getFechaInicioActividades());
            fc.setFechaPeriodoDesde(ultFcConsQueSeFactura.getFechaPeriodoDesde());
            fc.setFechaPeriodoHasta(ultFcConsQueSeFactura.getFechaPeriodoHasta());
            fc.setFechaVencimientoCae(ultFcConsQueSeFactura.getFechaVencimientoCae());
            fc.setFechaVencimientoPago(ultFcConsQueSeFactura.getFechaVencimientoPago());
            fc.setGravado(totalFacturaAfip);
            fc.setId_original(ultFcConsQueSeFactura.getId());
            fc.setId_administrador(id_adm);
            fc.setIibb(tc.getIibb());
            fc.setIva(0.0);
            fc.setLetra(letra);
            fc.setLetraComprobanteAsociado(letra);
            fc.setNumero(ultFcConsQueSeFactura.getNumero());
            fc.setNumeroComprobanteAsociado(0);
            fc.setPagado(0.0);
            fc.setPdfGenerado(false);
            fc.setOriginal(false);
            fc.setProductoServicio(ultFcConsQueSeFactura.getProductoServicio());
            fc.setProvinciaCliente(dmC.getProvincia());
            fc.setProvinciaTitular(dmT.getProvincia());
            fc.setRazonSocialCliente(consorcioVinculado.getNombre());
            fc.setRazonSocialTitular(tc.getPersona().getApellidoNombre());
            fc.setRubro(rubro);
            fc.setSucursal(tc.getSucursal());
            fc.setSucursalComprobanteAsociado(0);
            fc.setTexto1("");
            fc.setTexto2("");
            fc.setTipoComprobanteAsociado(0);
            fc.setTipoDocumento(consorcioVinculado.getDocumentoTipo());
            fc.setTipoEmision(abono.getTipoFacturacion());
            fc.setTipoInscripcion(consorcioVinculado.getTipoInscripcion().toString());
            fc.setTotal(totalFacturaAfip);
            CuentaCorrienteCliente ccc = new CuentaCorrienteCliente();
            ccc.setComprobante(fc);
            ccc.setConsorcio(consorcioVinculado);
            ccc.setDebe(totalFacturaAfip);
            ccc.setFecha(ultFcConsQueSeFactura.getFecha());
            ccc.setHaber(0.0);
            ccc.setRecibo(null);
            ccc.setTipoComprobante(11);
            Double sal = consorcioVinculado.getSaldo();
            sal += calculoCuota;
            consorcioVinculado.setSaldo(sal);
            ccc.setSaldo(sal);
            List<ComprobanteRenglones> renglonesFc = new ArrayList<>();
            for (RenglonAbono ra : renglones) {
                ComprobanteRenglones rf = new ComprobanteRenglones();
                rf.setComprobante(fc);
                rf.setImporte(ra.getImporte());
//                        rf.setOrden(ra.getOrden());
                rf.setDetalle(ra.getTexto());
                renglonesFc.add(rf);
            }
            if (abono.getCuotaFacturada() != null) {
                int cta = abono.getCuotaFacturada() + 1;
                abono.setCuotaFacturada(cta);
            } else {
                abono.setCuotaFacturada(1);
            }
            abono.setPendiente(false);
            try {
                fc = new ComprobanteService().saveComprobante(fc);
                for (ComprobanteRenglones ra : renglonesFc) {
                    ra.setComprobante(fc);
                    ra = new ComprobanteRenglonesService().saveRenglon(ra);
                }
                new AbonoService().updateAbono(abono);
                new ConsorcioService().updateConsorcio(consorcioVinculado);
                ccc.setComprobante(fc);
                new CuentaCorrienteClienteService().saveCuentaCorrienteCliente(ccc);

                resultado = "A";
            } catch (Exception ex) {
                Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(cliente);
                System.out.println(consorcioVinculado);
                System.out.println(abono);
                System.out.println(renglones);
                System.out.println("8");
                resultado = "X";
            }
        } else {
            System.out.println(cliente);
            System.out.println(consorcioVinculado);
            System.out.println(abono);
            System.out.println(renglones);
            System.out.println("9");
            return "X";
        }
        return resultado;
    }

    public static String saveCuotaSiguienteComprobanteRx(Consorcio cons, List<ComprobanteRenglones> renglones,
            Comprobante comprobanteAnterior, Comprobante comprobanteNuevo, CuentaCorrienteCliente ccc) {
        String retorno = "X";
        try {
            new ConsorcioService().updateConsorcio(cons);
            comprobanteNuevo = new ComprobanteService().saveComprobante(comprobanteNuevo);
            new ComprobanteService().updateComprobante(comprobanteAnterior);
            for (ComprobanteRenglones cr : renglones) {
                cr.setComprobante(comprobanteNuevo);
                new ComprobanteRenglonesService().saveRenglon(cr);
            }
            new CuentaCorrienteClienteService().saveCuentaCorrienteCliente(ccc);
            retorno = "A";
        } catch (Exception ex) {
            retorno = "X";
        }
        return retorno;
    }

    public static String saveReciboAbono(Abono abono, Consorcio cliente, FondoRecibo fr,
            List<ComprobanteRenglones> renglones, Double total, Rubro rubro,
            Date da1, Date da4, Integer ps, Integer cuota, Integer cuotas) {
        llenarMeses();
        Date da2 = da1;
        Date da3 = da1;
        String letra = "X";
        int num = 0;
        Configuracion cnfg = null;
        try {
            cnfg = new ConfiguracionService().getConfiguracion(1L);
        } catch (Exception ex) {
            Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        num = cnfg.getNroRx();
        num += 1;
        cnfg.setNroRx(num);
        String resultado = "N";
        Calendar cal = Calendar.getInstance();
        Integer mes = cal.get(Calendar.MONTH);

        DecimalFormat df = new DecimalFormat("#0.00");
        Administrador admin = cliente.getAdministrador();
        String calculoString = df.format(total).replace(",", ".");
        BigDecimal bd_total_rc = new BigDecimal(calculoString);
//        
        TitularCuit tc = fr.getTitular();
        Comprobante fc = new Comprobante();
        Domicilio dmC = cliente.getDomicilio();
        Domicilio dmT = fr.getTitular().getDomicilio();
        String textoP;
        if (abono.getTextoPeriodo() != null) {
            if (abono.getTextoPeriodo().equals(0)) {
                if (mes.equals(0)) {
                    mes = 11;
                } else {
                    mes -= 1;
                }
            }
        } else {
            mes -= 1;
        }
        textoP = meses.get(mes).getDetalle();
//        System.out.println(mes);
//        System.out.println(textoP);
//        System.out.println(abono.getTextoPeriodo());
//        System.exit(0);
        fc.setCae(0L);
        fc.setCalleNroPisoDtoCliente(dmC.getCalle() + " " + dmC.getNumero());
        fc.setCantidadCuotas(cuotas);
        fc.setCodigoCliente(cliente.getCodigo());
        fc.setCodigoComprobante(5);
        fc.setCodigoPostalAndLocalidadCliente(dmC.getCodigoPostal() + " " + dmC.getLocalidad());
        fc.setCodigoPostalAndLocalidadTitular(dmT.getCodigoPostal() + " " + dmT.getLocalidad());
        fc.setCuitCliente(cliente.getCuit());
        fc.setCuitTitular(tc.getCuit());
        fc.setCuotasPagadas(cuota);
        if (cuotas > 1) {
            fc.setCuotaSiguienteFacturada(false);
        } else {
            fc.setCuotaSiguienteFacturada(true);
        }
        fc.setDomicilioTitular(dmT.getCalle() + " " + dmT.getNumero());
        fc.setFecha(da1);
        fc.setOriginal(false);

        fc.setPeriodo(textoP);
        fc.setFechaInicioActividades(null);
        fc.setFechaPeriodoDesde(da2);
        fc.setFechaPeriodoHasta(da3);
        fc.setFechaVencimientoCae(null);
        fc.setFechaVencimientoPago(da4);
        fc.setGravado(total);
        fc.setIibb("");
        fc.setIva(0.0);
        fc.setLetra(letra);
        fc.setLetraComprobanteAsociado("");
        fc.setNumero(num);
        fc.setNumeroComprobanteAsociado(0);
        fc.setPagado(0.0);
        fc.setPdfGenerado(false);
        fc.setProductoServicio(ps);
        fc.setProvinciaCliente(dmC.getProvincia());
        fc.setProvinciaTitular(dmT.getProvincia());
        fc.setRazonSocialCliente(cliente.getNombre());
        fc.setRazonSocialTitular("");
        fc.setRubro(rubro);
        fc.setSucursal(0);
        fc.setSucursalComprobanteAsociado(0);
        fc.setTexto1("");
        fc.setTexto2("");
        fc.setFondo(fr);
        fc.setTipoComprobanteAsociado(0);
        fc.setTipoDocumento(cliente.getDocumentoTipo());
        fc.setTipoEmision(4);
        fc.setTipoInscripcion("");
        fc.setTotal(bd_total_rc.doubleValue());
        fc.setId_administrador(admin.getId());
        fc.setPeriodoHabilitado(false);
        CuentaCorrienteCliente ccc = new CuentaCorrienteCliente();
        ccc.setComprobante(fc);
        ccc.setConsorcio(cliente);
        ccc.setDebe(bd_total_rc.doubleValue());
        ccc.setFecha(da1);
        ccc.setHaber(0.0);
        ccc.setRecibo(null);
        ccc.setTipoComprobante(11);
        Double sal = cliente.getSaldo();
        sal += bd_total_rc.doubleValue();
        cliente.setSaldo(sal);
        ccc.setSaldo(sal);
        abono.setCuotaFacturada(cuota);
        try {
            fc = new ComprobanteService().saveComprobante(fc);
            for (ComprobanteRenglones ra : renglones) {
                ra.setComprobante(fc);
                ra = new ComprobanteRenglonesService().saveRenglon(ra);
            }
            new AbonoService().updateAbono(abono);
            new ConsorcioService().updateConsorcio(cliente);
            ccc.setComprobante(fc);
            new CuentaCorrienteClienteService().saveCuentaCorrienteCliente(ccc);
            new ConfiguracionService().updateConfiguracion(cnfg);
            resultado = "A";
        } catch (Exception ex) {
            Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR 510");
            resultado = "N";
        }

        return resultado;
    }

    private static boolean verificarTitularActivo(String cuitTc1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
