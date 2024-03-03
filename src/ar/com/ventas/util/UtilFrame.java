/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.util;

import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.CuentaCorrienteCliente;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.NuevoCae;
import ar.com.ventas.entities.Persona;
import ar.com.ventas.entities.Recibo;
import ar.com.ventas.entities.RenglonTrabajo;
import ar.com.ventas.entities.RenglonTrabajoReparacion;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.Servicio;
import ar.com.ventas.entities.TipoFactura;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.entities.Trabajo;
import ar.com.ventas.estructuras.FormaDeFacturacion;
import ar.com.ventas.estructuras.Mes;
import ar.com.ventas.estructuras.TipoResponsable;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.services.TitularCuitService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class UtilFrame {

    private static final DecimalFormat df_qr = new DecimalFormat("00000000");
    private final static SimpleDateFormat qr_sdf = new SimpleDateFormat("yyyy/MM/dd");
    private static final SimpleDateFormat sdf_qr = new SimpleDateFormat("yyyy-MM-dd");
    private static final DecimalFormat df = new DecimalFormat("#0.00");
    private static String qr_fecha;
    private static String qr_cuit_emisor;
    private static String qr_ptoVta;
    private static String qr_tipoCmpbte;
    private static String qr_nroCmpbte;
    private static final DecimalFormat qr_df = new DecimalFormat("#0.00");
    private static String qr_importe;
    private static final String qr_moneda = "PES";
    private static final String qr_cotiz = "1";
    private static String qr_tipoDocReceptor;
    private static String qr_nroDocReceptor;
    private final String qr_tipoCodAutoriz = "E";
    private static String qr_codigoAutoriz;
    private static final String qr_url = "https://www.afip.gob.ar/fe/qr/?p=";
    private static final String qr_version = "1";
    private static String url_qr = "https://www.afip.gob.ar/fe/qr/?p=";
    private static final int qrTamAncho = 100;
    private static final int qrTamAlto = 100;
    private static final String formato = "png";
    private static final String ruta = "c:/alfa_sistema/qr/codigoQR";
    private static final String extension = ".png";

    public static List<TipoFactura> getComboTipoFactura() {
        List<TipoFactura> lista = new ArrayList<>();
        TipoFactura tipo = new TipoFactura();
        tipo.setCodigo(0);
        tipo.setDetalle("");
        int x= 1;
        lista.add(tipo);
        for (FormaDeFacturacion fdf : FormaDeFacturacion.values()) {
            tipo = new TipoFactura();
            tipo.setCodigo(x);
            tipo.setDetalle(fdf.getDetalle());
            lista.add(tipo);
            x += 1;
        }
        return lista;
    }

    public static String crearQr(TitularCuit titular, Consorcio cliente, Comprobante iv) {

        String fecha = qr_sdf.format(iv.getFecha());
        String pVenta = titular.getSucursal().toString();
        String codigoTipoCmpbt = iv.getCodigoComprobante().toString();
        String cuitT = titular.getCuit();
        String cuitC = iv.getCuitCliente();
        String priT = "";
        String medT = "";
        String finT = "";
        String priC = "";
        String medC = "";
        String finC = "";
        priC = cuitC.substring(0, 2);
        medC = cuitC.substring(3, 11);
        finC = cuitC.substring(12, 13);
        priT = cuitT.substring(0, 2);
        medT = cuitT.substring(3, 11);
        finT = cuitT.substring(12, 13);

        qr_fecha = fecha;

        qr_cuit_emisor = priT + medT + finT;
        qr_ptoVta = pVenta;
        qr_tipoCmpbte = codigoTipoCmpbt;

        qr_nroCmpbte = iv.getNumero().toString();
        qr_importe = qr_df.format(iv.getTotal()).replace(",", ".");
        qr_tipoDocReceptor = iv.getTipoDocumento();
        qr_nroDocReceptor = priC + medC + finC;
        qr_codigoAutoriz = iv.getCae().toString();

        String data = qr_url
                + "{\"ver\"" + ":" + qr_version
                + ",\"fecha\"" + ":" + "\"" + qr_fecha + "\""
                + ",\"cuit\"" + ":" + qr_cuit_emisor
                + ",\"ptoVta\"" + ":" + qr_ptoVta
                + ",\"tipoCmp\"" + ":" + qr_tipoCmpbte
                + ",\"nroCmp\"" + ":" + qr_nroCmpbte
                + ",\"importe\"" + ":" + qr_importe
                + ",\"moneda\"" + ":\"" + qr_moneda + "\""
                + ",\"ctz\"" + ":" + qr_cotiz
                + ",\"tipoDocRec\"" + ":" + qr_tipoDocReceptor
                + ",\"nroDocRec\"" + ":" + qr_nroDocReceptor
                + ",\"tipoCodAut\"" + ":\"" + qr_codigoAutoriz + "\""
                + ",\"codAut\"" + ":" + qr_codigoAutoriz + "}";
        /*
        String data = "{\"ver\"" + ":" + qr_version
                + ",\"fecha\"" + ":" + "\"" + qr_fecha + "\""
                + ",\"cuit\"" + ":" + qr_cuit_emisor
                + ",\"ptoVta\"" + ":" + qr_ptoVta
                + ",\"tipoCmp\"" + ":" + qr_tipoCmpbte
                + ",\"nroCmp\"" + ":" + qr_nroCmpbte
                + ",\"importe\"" + ":" + qr_importe
                + ",\"moneda\"" + ":\"" + qr_moneda + "\""
                + ",\"ctz\"" + ":" + qr_cotiz
                + ",\"tipoDocRec\"" + ":" + qr_tipoDocReceptor
                + ",\"nroDocRec\"" + ":" + qr_nroDocReceptor
                + ",\"tipoCodAut\"" + ":\"" + qr_codigoAutoriz + "\""
                + ",\"codAut\"" + ":" + qr_codigoAutoriz + "}";
        System.out.println(data);
        
//        String modeloFcPapel = fc.getCodigoComprobante().toString();
//        int lgo = cui.length();
//        int lgoT = cuit_1.length();
//        if (lgo != 13) {
//            cui = "0000000000000" + cui;
//            int lgo1 = cui.length();
//            fin = cui.substring(lgo1 - 11, lgo1);
//        }
//        if (lgo > 11) {
//        }
//
//        if (lgoT != 13) {
//            cuit_1 = "0000000000000" + cuit_1;
//            int lgo1T = cuit_1.length();
//            finT = cuit_1.substring(lgo1T - 11, lgo1T);
//        }
//        if (lgoT > 11) {
//        }
//        String cuit_qr = priT + medT + finT;
//        String fecha_qr = sdf_qr.format(fecha);
//        String numeroDoc_qr = pri + med + fin;
        
        
                + ",\"fecha\":\"" + fecha_qr + "\""
                + ",\"cuit\":" + cuit_qr
                + ",\"ptoVta\":" + puntoVenta_qr
                + ",\"tipoCmp\":" + tipoComprobante_qr
                + ",\"nroCmp\":" + numeroComprobante_qr
                + ",\"importe\":" + importe_qr
                + ",\"moneda\":\"" + moneda_qr + "\""
                + ",\"ctz\":" + cotiz_qr
                + ",\"tipoDocRec\":" + tipoDoc_qr
                + ",\"nroDocRec\":" + numeroDoc_qr
                + ",\"tipoCodAut\":\"" + tipoCodigoAutoriz_qr + "\""
                + ",\"codAut\":" + nroCae_qr + "}";
         */

 /*
        private final String qr_url = "https://www.afip.gob.ar/fe/qr/";
    private final String qr_version = "1";
    private final SimpleDateFormat qr_sdf = new SimpleDateFormat("yyyy/MM/dd");
    private final String qr_cuit_emisor = "20339518409"; //SANTORO GASTON MATEO
    private final String qr_ptoVta = "2";
    private final String qr_tipoCmpbte = "6"; // ver estructuras
    private String qr_nroCmpbte;
    private String qr_importe;
    private final String qr_moneda="PES";
    private final String qr_cotiz="1";
    private String qr_tipoDocReceptor;
    private String qr_nroDocReceptor;
    private final String qr_tipoCodAutoriz="E";
    private String qr_codigoAutoriz;
         */
        return data;
    }

    public static JTable limpiarTabla(JTable tabla) {
        int rows = tabla.getRowCount();
        if (rows > 0) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (int i = 0; i < rows; i++) {
                tbl.removeRow(0);
            }
            tabla.setModel(tbl);
        }
        return tabla;
    }

//    public static JTable agregarLinea(JTable tabla) {
//        int cols = tabla.getColumnCount();
//        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
//        Object o[] = new Object[cols];
//        for (int i = 0; i < cols; i++) {
//            o[i] = "";
//        }
//        tbl.addRow(o);
//        tabla.setModel(tbl);
//        return tabla;
//    }
    public static JTable borrarLinea(JTable tabla, int row) {
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
        tbl.removeRow(row);
        tabla.setModel(tbl);
        return tabla;
    }

    public static JTable agregarLinea(int cols, JTable tabla) {
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
        Object o[] = new Object[cols];
        for (int i = 0; i < cols; i++) {
            o[i] = "";
        }
        tbl.addRow(o);
        tabla.setModel(tbl);
        return tabla;
    }

    public static JTable eliminarLinea(JTable tabla, int row) {
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
        tbl.removeRow(row);
        tabla.setModel(tbl);
        return tabla;
    }

    public static String getNombreSinEspacios(String calle) {
        int largo = calle.length();
        String str0 = "";
        for (int i = 0; i < largo; i++) {
            if (calle.substring(i, i + 1).equals(" ")) {
                str0 += "_";
            } else {
                if (calle.substring(i, i + 1).equals("/")) {
                    str0 += "-";
                } else {
                    str0 += calle.substring(i, i + 1);
                }
            }
        }
        return str0.trim();
    }

    public static String fecha(String fe) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int largo = fe.length();
        String fe1 = fe;
        String str = sdf.format(new Date());
        if (fe.equals("")) {
            fe = sdf.format(new Date());
        } else {
            if (largo == 2) {
                fe = fe1 + str.substring(2, 10);
            } else {
                if (largo == 5) {
                    fe = fe1 + str.substring(5, 10);
                }
            }
        }
        return fe;
    }

    public static Double totalFacturado6(Persona p) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date hoy = new Date();
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar3 = Calendar.getInstance();
        calendar2.setTime(hoy);
        calendar3.setTime(hoy);
        calendar2.set(Calendar.MONTH, calendar2.get(Calendar.MONTH) - 6);
        calendar2.set(Calendar.DAY_OF_MONTH, 1);
        calendar3.set(Calendar.MONTH, calendar3.get(Calendar.MONTH) - 1);
        calendar3.set(Calendar.DAY_OF_MONTH, calendar3.getActualMaximum(Calendar.DAY_OF_MONTH));
//        String fe2 = sdf.format(calendar2.getTime());
//        String fe3 = sdf.format(calendar3.getTime());
        Date fe02 = calendar2.getTime();
        Date fe03 = calendar3.getTime();
//        System.out.println(fe2); //6 meses
//        System.out.println(fe3);
        Double totalFacturado = 0.0;
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = new ComprobanteService().getComprobantesEntrFechas(fe02, fe03);
        } catch (Exception ex) {
            Logger.getLogger(UtilFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (comprobantes != null && !comprobantes.isEmpty()) {
            for (Comprobante co : comprobantes) {
                totalFacturado += co.getTotal();
            }
        }
        return totalFacturado;
    }

    public static Double totalFacturado12(Persona p) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date hoy = new Date();
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar3 = Calendar.getInstance();
        calendar1.setTime(hoy);
        calendar3.setTime(hoy);
        calendar1.set(Calendar.YEAR, calendar1.get(Calendar.YEAR) - 1);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        calendar3.set(Calendar.MONTH, calendar3.get(Calendar.MONTH) - 1);
        calendar3.set(Calendar.DAY_OF_MONTH, calendar3.getActualMaximum(Calendar.DAY_OF_MONTH));
//        String fe1 = sdf.format(calendar1.getTime());
//        String fe3 = sdf.format(calendar3.getTime());
        Date fe01 = calendar1.getTime();
        Date fe03 = calendar3.getTime();
//        System.out.println(fe1); //12 meses
//        System.out.println(fe3);
        Double totalFacturado = 0.0;
        List<Comprobante> comprobantes = null;
        try {
            comprobantes = new ComprobanteService().getComprobantesEntrFechas(fe01, fe03);
        } catch (Exception ex) {
            Logger.getLogger(UtilFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (comprobantes != null && !comprobantes.isEmpty()) {
            for (Comprobante co : comprobantes) {
                totalFacturado += co.getTotal();
            }
        }
        return totalFacturado;
    }

    public static NuevoCae enviarFacturaAfip(TitularCuit titularCuit, String cuitCliente, Double gravado, Double iva, Double total) {
        NuevoCae ncae = new NuevoCae();
        ncae.setEstado("A");
        ncae.setCae(1234567890123456L);
        Date fechaVencimiento = new Date();
        ncae.setFechaVencimiento(fechaVencimiento);
        ncae.setSucursal(titularCuit.getSucursal());
        ncae.setFechaCae(new Date());
        ncae.setNumero(1532);
        return ncae;
    }

    public static Integer registrarComprobante(NuevoCae resultado, TitularCuit titular, Trabajo trabajo, Double gravado, Double iva, Double total, String texto1, String texto2) {
        Long cae = resultado.getCae();
        Date fecha = resultado.getFechaCae();
        Date fechaInicioActividades = titular.getFechaInicioActividades();
        Date fechaVencimientoCae = resultado.getFechaVencimiento();
        String iibb = titular.getIibb();
        String letra;
        Consorcio consorcio = trabajo.getServicio().getConsorcio();
        Integer cantidadCuotas = trabajo.getServicio().getCantidadCuotas();
        Domicilio dmCliente = consorcio.getDomicilio();
        Domicilio dmTitular = titular.getDomicilio();
        String cpCliente = dmCliente.getCodigoPostal() + " " + dmCliente.getLocalidad();
        String cpTitular = dmTitular.getCodigoPostal() + " " + dmTitular.getLocalidad();
        String calleNroPisoDtoCliente = dmCliente.getCalle() + " "
                + dmCliente.getNumero();
        if (dmCliente.getPisoDto() != null) {
            calleNroPisoDtoCliente = calleNroPisoDtoCliente + " " + dmCliente.getPisoDto();
        }
        String domicilioTitular = dmTitular.getCalle();
        String provinciaCliente = dmCliente.getProvincia();
        String provinciaTitular = dmTitular.getProvincia();
        String razonSocialCliente = consorcio.getNombre();
        String razonSocialTitular = titular.getPersona().getApellidoNombre();
        Integer tInscr = titular.getTipoInscipcion();
        Integer codigoComprobante;
        if (tInscr.equals(1)) {
            codigoComprobante = 6;
            letra = "B";
        } else {
            codigoComprobante = 11;
            letra = "C";
        }
        Rubro rubro = trabajo.getServicio().getRubro();
        String cuitCliente = consorcio.getCuit();
        String cuitTitular = titular.getCuit();
        //1 es inscripto fc B(6)  6 es monotributo fc C(11)
        Comprobante comprobante = new Comprobante();
        comprobante.setCae(cae);
        comprobante.setPdfGenerado(false);
        comprobante.setCalleNroPisoDtoCliente(calleNroPisoDtoCliente);
        comprobante.setCantidadCuotas(cantidadCuotas);
        comprobante.setCodigoComprobante(codigoComprobante);
        comprobante.setCodigoPostalAndLocalidadCliente(cpCliente);
        comprobante.setCodigoPostalAndLocalidadTitular(cpTitular);
        comprobante.setCuitCliente(cuitCliente);
        comprobante.setCuitTitular(cuitTitular);
        comprobante.setCuotasPagadas(0);
        comprobante.setDomicilioTitular(domicilioTitular);
        comprobante.setFecha(fecha);
        comprobante.setFechaInicioActividades(fechaInicioActividades);
        comprobante.setFechaVencimientoCae(fechaVencimientoCae);
        comprobante.setGravado(gravado);
        comprobante.setIibb(iibb);
        comprobante.setIva(iva);
        comprobante.setLetra(letra);
        comprobante.setLetraComprobanteAsociado("");
        comprobante.setNumero(resultado.getNumero());
        comprobante.setNumeroComprobanteAsociado(0);
        comprobante.setPagado(gravado);
        comprobante.setProvinciaCliente(provinciaCliente);
        comprobante.setProvinciaTitular(provinciaTitular);
        comprobante.setRazonSocialCliente(razonSocialCliente);
        comprobante.setRazonSocialTitular(razonSocialTitular);
        comprobante.setRubro(rubro);
        comprobante.setSucursal(resultado.getSucursal());
        comprobante.setSucursalComprobanteAsociado(0);
        comprobante.setTipoComprobanteAsociado(0);
        comprobante.setTipoEmision(1);
        int pos = 0;
        String tipoInscripcion = "";
        for (TipoResponsable tr : TipoResponsable.values()) {
            if (tr.getCodigo().equals(consorcio.getTipoInscripcion())) {
                tipoInscripcion = tr.getDescripcion();
            }
        }
        comprobante.setTipoInscripcion(tipoInscripcion);
        comprobante.setTotal(total);
        comprobante.setTexto1(texto1);
        comprobante.setTexto2(texto2);
        trabajo.setFacturaEmitida(true);
        Double saldo = consorcio.getSaldo();
        if (consorcio.getSaldo() != null) {
            saldo += total;
        } else {
            saldo = total;
        }
        consorcio.setSaldo(saldo);
        CuentaCorrienteCliente ccc = new CuentaCorrienteCliente();
        ccc.setFecha(fecha);
        ccc.setComprobante(comprobante);
        ccc.setConsorcio(consorcio);
        ccc.setDebe(total);
        ccc.setHaber(0.0);
        ccc.setSaldo(saldo);
        ccc.setRecibo(null);
        ccc.setTipoComprobante(1);
        Servicio servicio = trabajo.getServicio();
        servicio.setImporte(total);
        try {
            new ComprobanteService().saveComprobanteAndCtaCteAndConso(comprobante, consorcio, ccc, trabajo, servicio);
        } catch (Exception ex) {
            Logger.getLogger(UtilFrame.class.getName()).log(Level.SEVERE, null, ex);
            return 2;
        }
        return 1;
    }

    public static Integer registrarComprobanteReparaion(NuevoCae resultado, TitularCuit titular, Consorcio consorcio, Double gravado, Double iva, Double total, List<RenglonTrabajoReparacion> renglones, Integer cuotas) {
        Long cae = resultado.getCae();
        Date fecha = resultado.getFechaCae();
        Date fechaInicioActividades = titular.getFechaInicioActividades();
        Date fechaVencimientoCae = resultado.getFechaVencimiento();
        String iibb = titular.getIibb();
        String letra;
        Domicilio dmCliente = consorcio.getDomicilio();
        Domicilio dmTitular = titular.getDomicilio();
        String cpCliente = dmCliente.getCodigoPostal() + " " + dmCliente.getLocalidad();
        String cpTitular = dmTitular.getCodigoPostal() + " " + dmTitular.getLocalidad();
        String calleNroPisoDtoCliente = dmCliente.getCalle() + " "
                + dmCliente.getNumero();
        if (dmCliente.getPisoDto() != null) {
            calleNroPisoDtoCliente = calleNroPisoDtoCliente + " " + dmCliente.getPisoDto();
        }
        String domicilioTitular = dmTitular.getCalle();
        String provinciaCliente = dmCliente.getProvincia();
        String provinciaTitular = dmTitular.getProvincia();
        String razonSocialCliente = consorcio.getNombre();
        String razonSocialTitular = titular.getPersona().getApellidoNombre();
        Integer tInscr = titular.getTipoInscipcion();
        Integer codigoComprobante;
        if (tInscr.equals(1)) {
            codigoComprobante = 6;
            letra = "B";
        } else {
            codigoComprobante = 11;
            letra = "C";
        }
        String cuitCliente = consorcio.getCuit();
        String cuitTitular = titular.getCuit();
        //1 es inscripto fc B(6)  6 es monotributo fc C(11)
        Comprobante comprobante = new Comprobante();
        comprobante.setCae(cae);
        comprobante.setPdfGenerado(false);
        comprobante.setCalleNroPisoDtoCliente(calleNroPisoDtoCliente);
        comprobante.setCantidadCuotas(cuotas);
        comprobante.setCodigoComprobante(codigoComprobante);
        comprobante.setCodigoPostalAndLocalidadCliente(cpCliente);
        comprobante.setCodigoPostalAndLocalidadTitular(cpTitular);
        comprobante.setCuitCliente(cuitCliente);
        comprobante.setCuitTitular(cuitTitular);
        comprobante.setCuotasPagadas(0);
        comprobante.setDomicilioTitular(domicilioTitular);
        comprobante.setFecha(fecha);
        comprobante.setFechaInicioActividades(fechaInicioActividades);
        comprobante.setFechaVencimientoCae(fechaVencimientoCae);
        comprobante.setGravado(gravado);
        comprobante.setIibb(iibb);
        comprobante.setIva(iva);
        comprobante.setLetra(letra);
        comprobante.setLetraComprobanteAsociado("");
        comprobante.setNumero(resultado.getNumero());
        comprobante.setNumeroComprobanteAsociado(0);
        comprobante.setPagado(0.0);
        comprobante.setProvinciaCliente(provinciaCliente);
        comprobante.setProvinciaTitular(provinciaTitular);
        comprobante.setRazonSocialCliente(razonSocialCliente);
        comprobante.setRazonSocialTitular(razonSocialTitular);
        comprobante.setSucursal(resultado.getSucursal());
        comprobante.setSucursalComprobanteAsociado(0);
        comprobante.setTipoComprobanteAsociado(0);
        comprobante.setTipoEmision(1);
        String tipoInscripcion = "";
        for (TipoResponsable tr : TipoResponsable.values()) {
            if (tr.getCodigo().equals(consorcio.getTipoInscripcion())) {
                tipoInscripcion = tr.getDescripcion();
            }
        }
        comprobante.setTipoInscripcion(tipoInscripcion);
        comprobante.setTotal(total);
//        comprobante.setTexto1(texto1);
//        comprobante.setTexto2(texto2);
        Double saldo = consorcio.getSaldo();
        if (consorcio.getSaldo() != null) {
            saldo += total;
        } else {
            saldo = total;
        }
        consorcio.setSaldo(saldo);
        CuentaCorrienteCliente ccc = new CuentaCorrienteCliente();
        ccc.setFecha(fecha);
        ccc.setComprobante(comprobante);
        ccc.setConsorcio(consorcio);
        ccc.setDebe(total);
        ccc.setHaber(0.0);
        ccc.setSaldo(saldo);
        ccc.setRecibo(null);
        ccc.setTipoComprobante(1);
        try {
            //       new ComprobanteService().saveComprobanteAndCtaCteAndConso2(comprobante, consorcio, ccc, renglones);
        } catch (Exception ex) {
            Logger.getLogger(UtilFrame.class.getName()).log(Level.SEVERE, null, ex);
            return 2;
        }
        return 1;
    }

    public static Integer asignarPagoToConsorcio(Consorcio co, Date fe, Double im) {
        Double saldo = 0.0;
        if (co.getSaldo() != null) {
            saldo = co.getSaldo();
            saldo -= im;
            co.setSaldo(saldo);
        }
        Recibo rc = new Recibo();
        rc.setConsorcio(co);
        rc.setFecha(fe);
        rc.setImporte(im);
        try {
            new ConsorcioService().asignarPagoToConsorcio(co, rc);
        } catch (Exception ex) {
            Logger.getLogger(UtilFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    public static Date getFechaMesSiguiente(Date fecha) {
        Date fechaSiguiente = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        if (dia > 28) {
            dia = 28;
            cal.set(cal.DAY_OF_MONTH, dia);
        }
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
        fechaSiguiente = cal.getTime();
        return fechaSiguiente;
    }

    public static String getFechaPrimero(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechax = new Date();
        if (!fecha.isEmpty()) {
            try {
                fechax = sdf.parse(fecha);
            } catch (ParseException ex) {
                Logger.getLogger(UtilFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechax);
//        int dia = cal.get(Calendar.DAY_OF_MONTH);
//        if(dia > 28){
//            dia = 28;
//            cal.set(cal.DAY_OF_MONTH, dia);
//        }
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date fecha1 = cal.getTime();
        String f2 = sdf.format(fecha1);
        return f2;
    }

    public static String getFechaFinMes(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechax = new Date();
        if (!fecha.isEmpty()) {
            try {
                fechax = sdf.parse(fecha);
            } catch (ParseException ex) {
                Logger.getLogger(UtilFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Date fecha2;
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechax);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
//        if(dia > 28){
//            dia = 28;
//            cal.set(cal.DAY_OF_MONTH, dia);
//        }
//        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
        fecha2 = cal.getTime();
        String f2 = sdf.format(fecha2);
        return f2;
    }
    
    public static Date getFechaAnioAtras(Date fechaAnual) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaAnual);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-11);
        return cal.getTime();
    }

    public static String generaQr(Comprobante fc) {
        Integer codigoCliente = fc.getCodigoCliente();
        String cuitTitular = fc.getCuitTitular();
        Consorcio consorcio = null;
        TitularCuit titular = null;
        try {
            consorcio = new ConsorcioService().getConsorcioByCodigo(codigoCliente);
            titular = new TitularCuitService().getTitularActivoByCuit(fc.getCuitTitular());
        } catch (Exception ex) {
            Logger.getLogger(UtilFrame.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        String priT = cuitTitular.substring(0, 2);
        String medT = cuitTitular.substring(3, 11);
        String finT = cuitTitular.substring(12, 13);
        String data;
        String ver_qr = "1";
        Date fecha = fc.getFecha();
        String cuit_qr = priT + medT + finT;
        String cui = fc.getCuitCliente();
        String tipoComprobante = fc.getCodigoComprobante().toString();
        String pri = "";
        String med = "";
        String fin = "";
        int lgo = cui.length();
        if (lgo != 13) {
            cui = "0000000000000" + cui;
            int lgo1 = cui.length();
            fin = cui.substring(lgo1 - 11, lgo1);
        }
        if (lgo > 11) {
            pri = cui.substring(0, 2);
            med = cui.substring(3, 11);
            fin = cui.substring(12, 13);
        }
        String numeroDoc_qr = pri + med + fin;
        if (pri.equals("00")) {
            numeroDoc_qr = "0";
        }
        String fecha_qr = sdf_qr.format(fecha);
        String tipoComprobante_qr = tipoComprobante;
        String numeroComprobante_qr = fc.getNumero().toString();
        String importe_qr = df.format(fc.getTotal()).replace(",", ".");
        String tipoDoc_qr = fc.getTipoDocumento();
        String nroCae_qr = fc.getCae().toString();
        String puntoVenta_qr = fc.getSucursal().toString();
        String moneda_qr = "PES";
        String cotiz_qr = "1";
        String tipoCodigoAutoriz_qr = "E";
        data = "{\"ver\":" + ver_qr
                + ",\"fecha\":\"" + fecha_qr + "\""
                + ",\"cuit\":" + cuit_qr
                + ",\"ptoVta\":" + puntoVenta_qr
                + ",\"tipoCmp\":" + tipoComprobante_qr
                + ",\"nroCmp\":" + numeroComprobante_qr
                + ",\"importe\":" + importe_qr
                + ",\"moneda\":\"" + moneda_qr + "\""
                + ",\"ctz\":" + cotiz_qr
                + ",\"tipoDocRec\":" + tipoDoc_qr
                + ",\"nroDocRec\":" + numeroDoc_qr
                + ",\"tipoCodAut\":\"" + tipoCodigoAutoriz_qr + "\""
                + ",\"codAut\":" + nroCae_qr + "}";
        System.out.println(data);
//        System.exit(0);
        return data;
    }

    public static void generarQR(String data, Integer numeroFactura) throws Exception {
        String cadenaCodificada = Base64.getEncoder().encodeToString(data.getBytes("UTF-8"));
        BitMatrix matriz;
        Writer writer = new QRCodeWriter();
        try {
            matriz = writer.encode(url_qr + cadenaCodificada, BarcodeFormat.QR_CODE, qrTamAncho, qrTamAlto);
        } catch (WriterException e) {
            e.printStackTrace(System.err);
            return;
        }
        BufferedImage imagen = new BufferedImage(qrTamAncho,
                qrTamAlto, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < qrTamAlto; y++) {
            for (int x = 0; x < qrTamAncho; x++) {
                int valor = (matriz.get(x, y) ? 0 : 1) & 0xff;
                imagen.setRGB(x, y, (valor == 0 ? 0 : 0xFFFFFF));
            }
        }
        FileOutputStream qrCode;
        String nf_qr = df_qr.format(numeroFactura);
        qrCode = new FileOutputStream(ruta + nf_qr + extension);
        ImageIO.write(imagen, formato, qrCode);
        qrCode.close();
    }

    public static String mesActualEnLetras(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        List<String> meses = new ArrayList<>();
        for (Mes m : Mes.values()) {
            meses.add(m.getDetalle());
        }
        int me = cal.get(Calendar.MONTH);
        String mes = meses.get(me);

        return mes;
    }

    public static String mesAnteriorEnLetras(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
        List<String> meses = new ArrayList<>();
        for (Mes m : Mes.values()) {
            meses.add(m.getDetalle());
        }
        int me = cal.get(Calendar.MONTH);
        String mes = meses.get(me);

        return mes;
    }
}
