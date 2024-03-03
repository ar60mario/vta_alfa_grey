/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.util;

import ar.com.ventas.entities.Abono;
import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.CuentaCorrienteCliente;
import ar.com.ventas.entities.CuotaFactura;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.ComprobanteRenglones;
import ar.com.ventas.entities.NuevoCae;
import ar.com.ventas.entities.RenglonAbono;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.frame.FacturaReparacion2Frame;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.RenglonAbonoService;
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
public class UtilAbonos {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public static Comprobante grabarComprobantePorMes(NuevoCae nuevoCae, Consorcio consorcio, TitularCuit titular, Date fecha, Abono abono) {
        Administrador adm = consorcio.getAdministrador();
        int pmc = 0;
        if (adm.getPagaMesCorriente() != null) {
            if (adm.getPagaMesCorriente()) {
                pmc = 1;
            }
        }
        Comprobante iv = new Comprobante();
        iv.setCae(nuevoCae.getCae());
        iv.setFechaPeriodoDesde(nuevoCae.getFechaPeriodoDesde());
        iv.setFechaPeriodoHasta(nuevoCae.getFechaPeriodoHasta());
        iv.setFechaVencimientoPago(nuevoCae.getFechaVencimientoPago());
        int tipoCompr = 0;
        iv.setRubro(abono.getRubro());
        String cuit = consorcio.getCuit();
        String cuitTitular = titular.getCuit();
        Domicilio dmT = titular.getDomicilio();
        Domicilio dmC = consorcio.getDomicilio();
        fecha = nuevoCae.getFechaCae();
        String letra = "C";
//            try {
//                fecha = sdf.parse(fechaTxt.getText());
//            } catch (ParseException ex) {
//                Logger.getLogger(FacturaReparacionFrame.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(this, "ERROR GRABANDO COMPROBANTE\nVERIFIQUE FECHA");
//                return;
//            }
        if (titular.getTipoInscipcion() == 6) {
            tipoCompr = 11;
            letra = "C";
        }
        Date fechaCae = nuevoCae.getFechaVencimiento();
        Integer numeroFactura = nuevoCae.getNumero();
        List<ComprobanteRenglones> ivr = new ArrayList<>();
        List<RenglonAbono> renglones = null;
        try {
            renglones = new RenglonAbonoService().getRenglonAbonosByAbono(abono);
        } catch (Exception ex) {
            Logger.getLogger(UtilAbonos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (renglones != null && !renglones.isEmpty()) {
            for (RenglonAbono ra : renglones) {
                ComprobanteRenglones ivr0 = new ComprobanteRenglones();
                ivr0.setDetalle(ra.getTexto());
                ivr0.setImporte(ra.getImporte());
            }
        }
        iv.setCodigoComprobante(tipoCompr);
        iv.setTipoComprobanteAsociado(0);
        iv.setCuitCliente(cuit);
        iv.setCuitTitular(cuitTitular);
        iv.setCalleNroPisoDtoCliente(dmC.getCalle() + " " + dmC.getNumero());
        iv.setCodigoPostalAndLocalidadCliente(dmC.getCodigoPostal() + " "
                + dmC.getLocalidad());
        iv.setCodigoPostalAndLocalidadTitular(dmT.getCodigoPostal() + " "
                + dmT.getLocalidad());
        iv.setProvinciaCliente(dmC.getProvincia());
        iv.setProvinciaTitular(dmT.getProvincia());
        iv.setDomicilioTitular(dmT.getCalle() + " " + dmT.getNumero());
        iv.setFecha(fecha);
        iv.setFechaInicioActividades(titular.getFechaInicioActividades());
        iv.setFechaVencimientoCae(fechaCae);
//        int caCu = comboC.getSelectedIndex();
        int f = abono.getCuotas();
        iv.setCantidadCuotas(1);
        Double total = abono.getImporte() / f;
        iv.setCuotasPagadas(0);
        iv.setIibb(titular.getIibb());
        iv.setLetra(letra);
        iv.setNumero(numeroFactura);
        iv.setNumeroComprobanteAsociado(0);
        iv.setRazonSocialCliente(consorcio.getNombre());
        iv.setRazonSocialTitular(titular.getPersona().getApellidoNombre());
        iv.setSucursal(titular.getSucursal());
        iv.setSucursalComprobanteAsociado(0);
        iv.setTipoInscripcion(titular.getTipoInscipcion().toString());
        iv.setTotal(total);
        iv.setTipoDocumento(consorcio.getDocumentoTipo());
//        Double cuota = total / f;
//        System.out.println(f);
        List<CuotaFactura> cuotas = new ArrayList<>();
        Date fechaCuota = fecha;
        Date fecha2;
        for (int i = 0; i < f; i++) {
            CuotaFactura cf = new CuotaFactura();
            cf.setCancelada(false);
            if (pmc == 1) {
                fecha2 = fechaCuota;
                fechaCuota = UtilFrame.getFechaMesSiguiente(fechaCuota);
            } else {
                fechaCuota = UtilFrame.getFechaMesSiguiente(fechaCuota);
                fecha2 = fechaCuota;
            }
            cf.setFechaDeVencimiento(fecha2);
            cf.setImporteCuota(total);
            cf.setImportePagado(0.00);
            cuotas.add(cf);
        }
        CuentaCorrienteCliente ccc = new CuentaCorrienteCliente();
        ccc.setConsorcio(consorcio);
        ccc.setDebe(total);
        ccc.setFecha(fecha);
        ccc.setHaber(0.0);
        ccc.setComprobante(iv);
        ccc.setRecibo(null);
        if (consorcio.getSaldo() != null) {
//        System.out.println(consorcio);
//        System.out.println(consorcio.getSaldo());
//        System.out.println(total);
//        System.exit(0);
            ccc.setSaldo(consorcio.getSaldo() + total);
            consorcio.setSaldo(consorcio.getSaldo() + total);
        } else {
            ccc.setSaldo(total);
            consorcio.setSaldo(total);
        }
        ccc.setTipoComprobante(tipoCompr);
//        try {
//            new CuentaCorrienteClienteService().saveCuentaCorrienteCliente(ccc);
//        } catch (Exception ex) {
//            Logger.getLogger(FacturaReparacionFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        try {
//            new ConsorcioService().updateConsorcio(consorcio);
//        } catch (Exception ex) {
//            Logger.getLogger(FacturaReparacionFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try {
            //    new ComprobanteService().saveComprobanteAndCtaCteAndConso(iv, ivr, consorcio, ccc, cuotas);
//            grabado = true;
        } catch (Exception ex) {
            Logger.getLogger(FacturaReparacion2Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR GRABANDO COMPROBANTE");
        }
//            UtilFrame.generarQr(iv);
        return iv;
    }

    public static Comprobante grabarComprobante(NuevoCae nuevoCae, Consorcio consorcio,
            TitularCuit titular, Date fecha, Abono abono) {
        Administrador adm = consorcio.getAdministrador();
        int pmc = 0;
        if (adm.getPagaMesCorriente() != null) {
            if (adm.getPagaMesCorriente()) {
                pmc = 1;
            }
        }
        Comprobante iv = new Comprobante();
        iv.setCae(nuevoCae.getCae());
        iv.setFechaPeriodoDesde(nuevoCae.getFechaPeriodoDesde());
        iv.setFechaPeriodoHasta(nuevoCae.getFechaPeriodoHasta());
        iv.setFechaVencimientoPago(nuevoCae.getFechaVencimientoPago());
        int tipoCompr = 0;
//        int rowR = comboR.getSelectedIndex() - 1;
        iv.setRubro(abono.getRubro());
        String cuit = consorcio.getCuit();
        String cuitTitular = titular.getCuit();
        Domicilio dmT = titular.getDomicilio();
        Domicilio dmC = consorcio.getDomicilio();
        fecha = nuevoCae.getFechaCae();
        String letra = "C";
//            try {
//                fecha = sdf.parse(fechaTxt.getText());
//            } catch (ParseException ex) {
//                Logger.getLogger(FacturaReparacionFrame.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(this, "ERROR GRABANDO COMPROBANTE\nVERIFIQUE FECHA");
//                return;
//            }
        if (titular.getTipoInscipcion() == 6) {
            tipoCompr = 11;
            letra = "C";
        }
        Date fechaCae = nuevoCae.getFechaVencimiento();
        Integer numeroFactura = nuevoCae.getNumero();
        List<ComprobanteRenglones> ivr = new ArrayList<>();
        List<RenglonAbono> renglones = null;
        try {
            renglones = new RenglonAbonoService().getRenglonAbonosByAbono(abono);
        } catch (Exception ex) {
            Logger.getLogger(UtilAbonos.class.getName()).log(Level.SEVERE, null, ex);
        }
//        int rows = tabla.getRowCount();
        for (RenglonAbono ra : renglones) {
            ComprobanteRenglones ivr0 = new ComprobanteRenglones();
            ivr0.setDetalle(ra.getTexto());
            ivr0.setImporte(ra.getImporte());
//            if (!tabla.getValueAt(i, 1).equals("")) {
//                String imp = tabla.getValueAt(i, 1).toString().replace(",", ".");
//                Double impor = Double.valueOf(imp);
//                ivr0.setImporte(impor);
//                ivr.add(ivr0);
//            } else {
//                ivr0.setImporte(0.0);
//                ivr.add(ivr0);
//            }
        }
        iv.setCodigoComprobante(tipoCompr);
        iv.setTipoComprobanteAsociado(0);
        iv.setCuitCliente(cuit);
        iv.setCuitTitular(cuitTitular);
        iv.setCalleNroPisoDtoCliente(dmC.getCalle() + " " + dmC.getNumero());
        iv.setCodigoPostalAndLocalidadCliente(dmC.getCodigoPostal() + " "
                + dmC.getLocalidad());
        iv.setCodigoPostalAndLocalidadTitular(dmT.getCodigoPostal() + " "
                + dmT.getLocalidad());
        iv.setProvinciaCliente(dmC.getProvincia());
        iv.setProvinciaTitular(dmT.getProvincia());
        iv.setDomicilioTitular(dmT.getCalle() + " " + dmT.getNumero());
        iv.setFecha(fecha);
        iv.setFechaInicioActividades(titular.getFechaInicioActividades());
        iv.setFechaVencimientoCae(fechaCae);
        int caCu = abono.getCuotas();
        Double total = abono.getImporte();
        iv.setCantidadCuotas(caCu);
        iv.setCuotasPagadas(0);
        iv.setIibb(titular.getIibb());
        iv.setLetra(letra);
        iv.setNumero(numeroFactura);
        iv.setNumeroComprobanteAsociado(0);
        iv.setRazonSocialCliente(consorcio.getNombre());
        iv.setRazonSocialTitular(titular.getPersona().getApellidoNombre());
        iv.setSucursal(titular.getSucursal());
        iv.setSucursalComprobanteAsociado(0);
        iv.setTipoInscripcion(titular.getTipoInscipcion().toString());
        iv.setTotal(abono.getImporte());
        iv.setTipoDocumento(consorcio.getDocumentoTipo());

        int f = caCu;
        Double cuota = total / f;
//        System.out.println(f);
        List<CuotaFactura> cuotas = new ArrayList<>();
        Date fechaCuota = fecha;
        Date fecha2;
        for (int i = 0; i < f; i++) {
            CuotaFactura cf = new CuotaFactura();
            cf.setCancelada(false);
            if (pmc == 1) {
                fecha2 = fechaCuota;
                fechaCuota = UtilFrame.getFechaMesSiguiente(fechaCuota);
            } else {
                fechaCuota = UtilFrame.getFechaMesSiguiente(fechaCuota);
                fecha2 = fechaCuota;
            }
            cf.setFechaDeVencimiento(fecha2);
            cf.setImporteCuota(total);
            cf.setImportePagado(0.00);
            cuotas.add(cf);
        }
        CuentaCorrienteCliente ccc = new CuentaCorrienteCliente();
        ccc.setComprobante(null);
        ccc.setConsorcio(consorcio);
        ccc.setDebe(total);
        ccc.setFecha(fecha);
        ccc.setHaber(0.0);
        ccc.setComprobante(iv);
        ccc.setRecibo(null);
        if (consorcio.getSaldo() != null) {

            ccc.setSaldo(consorcio.getSaldo() + total);
            consorcio.setSaldo(consorcio.getSaldo() + total);
        } else {
            ccc.setSaldo(total);
            consorcio.setSaldo(total);
        }
        ccc.setTipoComprobante(tipoCompr);

        try {
            //   new ComprobanteService().saveComprobanteAndCtaCteAndConso(iv, ivr, consorcio, ccc, cuotas);
//            grabado = true;
        } catch (Exception ex) {
            Logger.getLogger(FacturaReparacion2Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR GRABANDO COMPROBANTE");
        }
//            UtilFrame.generarQr(iv);
        return iv;
    }

    public static Integer getDiferenciaEntreFechas(Date d2, Date d3) {
        int x = 0;
        Calendar cal2 = Calendar.getInstance();
        Calendar cal3 = Calendar.getInstance();
        cal2.setTime(d2);
        cal3.setTime(d3);
        cal2.set(Calendar.DAY_OF_MONTH, 1);
        cal3.set(Calendar.DAY_OF_MONTH, 1);
        int difA = cal2.get(Calendar.YEAR) - cal3.get(Calendar.YEAR);
        x = difA * 12 + cal2.get(Calendar.MONTH) - cal3.get(Calendar.MONTH);
        
        return x;
    }
    
    
    public static Boolean getEstaEnFrecuencia(Date fecha) {
        Date now = new Date();
        String fechaFin = sdf.format(now);
        String nowFin = UtilFrame.getFechaFinMes(fechaFin);
        
        String fechaIni = sdf.format(fecha);
        String fechaInicio = UtilFrame.getFechaPrimero(fechaIni);
        
        Date de;
        Date al;
        
        try {
            de = sdf.parse(fechaInicio);
            al = sdf.parse(nowFin);
        } catch (ParseException ex) {
            Logger.getLogger(UtilAbonos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        System.out.println(de);
        System.out.println(al);
        System.out.println(al.compareTo(de));
        
        
        
        
        return true;
    }
}
