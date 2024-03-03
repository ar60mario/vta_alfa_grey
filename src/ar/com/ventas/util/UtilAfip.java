/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.util;

import ar.com.ventas.entities.Abono;
import ar.com.ventas.entities.CertificadosAfip;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.NuevoCae;
import ar.com.ventas.entities.TicketTime;
import ar.com.ventas.entities.TicketToken;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.services.CertificadosAfipService;
import ar.com.ventas.services.TicketTimeService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class UtilAfip {

    private static final DecimalFormat df_qr = new DecimalFormat("00000000");
    private static final DecimalFormat df = new DecimalFormat("#0.00");
    private static final DecimalFormat df4 = new DecimalFormat("0000");
//    private static final String formato = "png";
    private static final int qr_TamAncho = 200;
    private static TicketTime tkt = null;
    private static String token;
    private static String sign;
    private static String wsd1 = "https://wsaa.afip.gov.ar/ws/services/LoginCms";
    private static String wsd2 = "https://servicios1.afip.gov.ar/wsfev1/service.asmx?WSDL"; // produccion
    private static String excepcion = "";
    public static ActiveXComponent wsfev1 = new ActiveXComponent("WSFEv1");
    private static final SimpleDateFormat fechaWs = new SimpleDateFormat("yyyyMMdd");
    private final int qr_TamAlto = 200;
    private final String qr_formato = "png";
    private final String qr_ruta = "c:/SYSTEM/qr/codigoQR";
    private final String qr_extension = ".png";
    private static final String qr_url = "https://www.afip.gob.ar/fe/qr/?p=";
    private static final String qr_version = "1";
    private final static SimpleDateFormat qr_sdf = new SimpleDateFormat("yyyy/MM/dd");
    private final static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
    private static final Integer tst = 0; // si esta en 1 es test
    private static int xxx = 0; // 0 esta en test
    private static ActiveXComponent wsaa = new ActiveXComponent("WSAA");

    private static TicketTime generarTicket(String certif, String llave) {
        TicketTime tt1 = new TicketTime();
        Date fecha = new Date();
        int hora = 0;
        int minutos = 0;
        int segundos = 0;
        Dispatch.call(wsaa, "Autenticar",
                new Variant("wsfe"),
                new Variant(certif),
                new Variant(llave),
                new Variant(wsd1));
        String excepcion = Dispatch.get(wsaa, "Excepcion").toString();
        String token = Dispatch.get(wsaa, "Token").toString();
        String sign = Dispatch.get(wsaa, "Sign").toString();
        tt1.setFecha(fecha);
        tt1.setHora(hora);
        tt1.setMinuto(minutos);
        tt1.setSegundo(segundos);
        tt1.setToken(token);
        tt1.setSign(sign);
        tt1.setException(excepcion);
        return tt1;
    }

    private void generarQR(String data, Integer numeroFactura) throws Exception {
//        int qrTamAncho = 200;
//        int qrTamAlto = 200;
//        String extension = ".png";
//        String ruta = "c://SYSTEM//qr";
//        String url_qr = "https://www.afip.gob.ar/fe/qr/?p=";
        String cadenaCodificada = Base64.getEncoder().encodeToString(data.getBytes());
        BitMatrix matriz;
        Writer writer = new QRCodeWriter();
        try {
            matriz = writer.encode(qr_url + cadenaCodificada, BarcodeFormat.QR_CODE, qr_TamAncho, qr_TamAlto);
        } catch (WriterException e) {
            e.printStackTrace(System.err);
            return;
        }
        BufferedImage imagen = new BufferedImage(qr_TamAncho,
                qr_TamAlto, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < qr_TamAlto; y++) {
            for (int x = 0; x < qr_TamAncho; x++) {
                int valor = (matriz.get(x, y) ? 0 : 1) & 0xff;
                imagen.setRGB(x, y, (valor == 0 ? 0 : 0xFFFFFF));
            }
        }
        FileOutputStream qrCode;
        String nf_qr = df_qr.format(numeroFactura);
        qrCode = new FileOutputStream(qr_ruta + nf_qr + qr_extension);
        ImageIO.write(imagen, qr_formato, qrCode);
        qrCode.close();
    }

    public static TicketToken solicitarTicket(TitularCuit titular, Date fecha, Integer hora, Integer minutos, Integer segundos) {
        CertificadosAfip ca = null;
        String certificado = "";
        String llave = "";
        try {
            ca = new CertificadosAfipService().getCertificadoByTitular(titular);

        } catch (Exception ex) {
            Logger.getLogger(UtilFrame.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        if (ca != null) {
            certificado = ca.getCertificado();
            llave = ca.getLlave();
            String wsd3 = "https://wsaa.afip.gov.ar/ws/services/LoginCms";
            Dispatch.call(wsaa, "Autenticar",
                    new Variant("wsfe"),
                    new Variant(certificado),
                    new Variant(llave),
                    new Variant(wsd3));
//            99
            excepcion = Dispatch.get(wsaa, "Excepcion").toString();
            token = Dispatch.get(wsaa, "Token").toString();
            sign = Dispatch.get(wsaa, "Sign").toString();
            try {
                tkt = new TicketTimeService().getTicketByTitular(titular);

            } catch (Exception ex) {
                Logger.getLogger(UtilFrame.class
                        .getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERROR Nro.628 GENERANDO CERTIFICADOS DE ACCESO");
                return null;
            }
            tkt.setFecha(fecha);
            tkt.setHora(hora);
            tkt.setMinuto(minutos);
            tkt.setSegundo(segundos);
            tkt.setTitular(titular);
//            tkt.setSign(sign);
//            tkt.setToken(token);
//            System.out.println(fecha);
//            System.out.println(hora);
//            System.out.println(minutos);
//            System.out.println(segundos);
//            System.out.println(titular.getCuit());
//            System.out.println(sign);
//            System.out.println(token);
//            System.out.println(excepcion);
//            System.out.println("DOS");
            try {
                new TicketTimeService().updateTicket(tkt);

            } catch (Exception ex) {
                Logger.getLogger(UtilFrame.class
                        .getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "No se pudo guardar Ticket");
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR Nro.612 VERIFIQUE CONFIGURAR LOS CERTIFICADOS DEL TITULAR");
            return null;
        }
        TicketToken tt = new TicketToken();
        tt.setId(1L);
        tt.setSign(sign);
        tt.setToken(token);
        return tt;
    }

//    public static TicketToken solicitarNuevoTicket(TitularCuit titular, Date fecha, Integer hora, Integer minutos, Integer segundos) {
//        CertificadosAfip ca = null;
//        String certificado = "";
//        String llave = "";
//        try {
//            ca = new CertificadosAfipService().getCertificadoByTitular(titular);
//
//        } catch (Exception ex) {
//            Logger.getLogger(UtilFrame.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//        String wsd3 = "https://wsaa.afip.gov.ar/ws/services/LoginCms";
//        if (ca != null) {
//            certificado = ca.getCertificado();
//            llave = ca.getLlave();
//            Dispatch.call(wsaa, "Autenticar",
//                    new Variant("wsfe"),
//                    new Variant(certificado),
//                    new Variant(llave),
//                    new Variant(wsd3));
////            99
//            excepcion = Dispatch.get(wsaa, "Excepcion").toString();
//            token = Dispatch.get(wsaa, "Token").toString();
//            sign = Dispatch.get(wsaa, "Sign").toString();
////            System.out.println(fecha);
////            System.out.println(hora);
////            System.out.println(minutos);
////            System.out.println(segundos);
////            System.out.println(titular.getCuit());
////            System.out.println(sign);
////            System.out.println(token);
////            System.out.println("UNO");
//            tkt = new TicketTime();
//            tkt.setFecha(fecha);
//            tkt.setHora(hora);
//            tkt.setMinuto(minutos);
//            tkt.setSegundo(segundos);
//            tkt.setTitular(titular);
////            tkt.setToken(token);
////            tkt.setSign(sign);
//            try {
//                new TicketTimeService().saveTicket(tkt);
//
//            } catch (Exception ex) {
//                Logger.getLogger(UtilFrame.class
//                        .getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(null, "No se pudo guardar nuevo Ticket");
//                return null;
//            }
//            TicketToken tt = new TicketToken();
//            tt.setId(1L);
//            tt.setSign(sign);
//            tt.setToken(token);
//            return tt;
//        } else {
//            return null;
//        }
//    }
//    public static NuevoCae enviarFacturaAfip2(TitularCuit titular, Consorcio consorcio, Double total, Date fechaFactura, TicketTime tkt) {
////        System.exit(0);
//        NuevoCae nc = new NuevoCae();
//        nc.setCae(1L);
//        nc.setFechaCae(fechaFactura);
//        nc.setFechaVencimiento(fechaFactura);
//        nc.setNumero(2);
//        nc.setSucursal(titular.getSucursal());
//        int suc = titular.getSucursal();
//        String cuitX = titular.getCuit();
//        String cuitT = cuitX.substring(0, 2) + cuitX.substring(3, 11) + cuitX.substring(12, 13);
//        Date caeVencim = new Date();
//        String letra = "B";
//        Date fws = fechaFactura;
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(fws);
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
//        Date fws_1 = calendar.getTime();
////        calendar = Calendar.getInstance();
//        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
//        Date fws_2 = calendar.getTime();
//        calendar = Calendar.getInstance();
//        calendar.setTime(fws);
//        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
//        calendar.set(calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
//        Date fws_3 = calendar.getTime();
//        String fws_1_str = new SimpleDateFormat("yyyyMMdd").format(fws_1);
//        String fws_2_str = new SimpleDateFormat("yyyyMMdd").format(fws_2);
//        String fws_3_str = new SimpleDateFormat("yyyyMMdd").format(fws_3);
////        System.out.println(fws_1_str);
////        System.out.println(fws_2_str);
////        System.out.println(fws_3_str);
////        System.exit(0);
//        TicketToken tt = new TicketToken();
//
//        if (tst == 0) {
//            // asignar cae AFIP
//            try {
//
//                Calendar cal = Calendar.getInstance();
//                Date fecha = cal.getTime();
//                int hora = cal.get(Calendar.HOUR_OF_DAY);
//                int minutos = cal.get(Calendar.MINUTE);
//                int segundos = cal.get(Calendar.SECOND);
//                tkt = new TicketTimeService().getTicketByTitular(titular);
//
//                if (tkt != null) {
//                    if (fecha != tkt.getFecha()) {
//                        tt = solicitarTicket(titular, fecha, hora, minutos, segundos);
//                    } else if (hora != tkt.getHora()) {
//                        if (hora == tkt.getHora() + 1) {
//                            if (minutos > tkt.getMinuto()) {
//                                tt = solicitarTicket(titular, fecha, hora, minutos, segundos);
//                            } else {
//                                int xMinuto = 60 - tkt.getMinuto();
//                                if ((xMinuto + minutos) > 30) {
//                                    tt = solicitarTicket(titular, fecha, hora, minutos, segundos);
//                                }
//                            }
//                        } else {
//                            tt = solicitarTicket(titular, fecha, hora, minutos, segundos);
//                        }
//                    } else if (minutos - tkt.getMinuto() > 30) {
//                        tt = solicitarTicket(titular, fecha, hora, minutos, segundos);
//                    }
//                }
//                sign = tt.getSign();
//                token = tt.getToken();
//                tkt.setSign(sign);
//                tkt.setToken(token);
//
////                LibraryLoader.loadJacobLibrary();
////                wsaa = new ActiveXComponent("WSAA");
////                System.out.println(Dispatch.get(wsaa, "InstallDir").toString()
////                        + " "
////                        + Dispatch.get(wsaa, "Version").toString()
////                );
////                
////                Dispatch.call(wsaa, "Autenticar",
////                        new Variant("wsfe"),
////                        new Variant(token),
////                        new Variant(sign),
////                        /*
////                    new Variant(userdir + "/nuevo2018_6851c538ff621621.crt"),
////                    new Variant(userdir + "/clave_privada_20142553202_201811010137.key"),
////                         */
////                        new Variant(wsd2));
//                ActiveXComponent wsfev1 = new ActiveXComponent("WSFEv1");
//                Dispatch.put(wsfev1, "Cuit", new Variant(cuitT));
//                Dispatch.put(wsfev1, "Token", new Variant(token));
//                Dispatch.put(wsfev1, "Sign", new Variant(sign));
//                String cache = "";
//                String wsd3 = "https://servicios1.afip.gov.ar/wsfev1/service.asmx?WSDL";
//                Dispatch.call(wsfev1, "Conectar",
//                        new Variant(cache),
//                        new Variant(wsd3)
//                );
//                String tipo_cbte = "11";
//                String tipoComprob = tipo_cbte;
//                String pto_vta = String.valueOf(suc); // Sucursal declarada WS
//                String sucursalFacturaPapel = df4.format(suc);
//                System.out.println(suc);
//                System.out.println(pto_vta);
//                System.out.println(tipo_cbte);
//                System.out.println(cuitT);
//                System.out.println(wsfev1);
//                System.out.println(tkt);
//                System.out.println(tkt.getSign());
//                System.out.println(tkt.getToken());
//
//                Variant ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
//                        new Variant(tipo_cbte),
//                        new Variant(pto_vta));
//                System.out.println(ult);
////                System.exit(0);
//                excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
//
////                        System.out.println(wsfev1);
////                        //JOptionPane.showMessageDialog(this, "Ult.Comprb." + ult.toString());
////                        System.out.println("Ult.Comprb." + ult.toString());
////                int numf = Integer.valueOf(ult.toString());
//                int numf = Integer.parseInt(ult.toString());
//                nc.setNumero(numf + 1);
////                if (numf != comprobanteNumero) {
////                    nc.setEstado("N");
////                    nc.setMotivo("EN AFIP HAY UN NUMERO DIFERENTE AL DEL SISTEMA");
////                    JOptionPane.showMessageDialog(null, "No coinciden los numeros");
////                    return nc;
////                }
////                        System.out.println(numf);
////                        System.exit(0);
//                String fechaWs = new SimpleDateFormat("yyyyMMdd").format(fws);
//                String concepto = "2";// 1 PRODUCTO, 2 SERVICIO, 3 PRODUCTO Y SERVICIO
//                String cui = consorcio.getCuit();
//                String cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
//                String tipoD = String.valueOf(consorcio.getDocumentoTipo());
//                String tipo_doc = tipoD, nro_doc = cuit1; //tipo y numero
//                int cbte_nro = numf,
//                        cbt_desde = cbte_nro,
//                        cbt_hasta = cbte_nro;
//                String numeroFacturaPapel = String.valueOf(cbte_nro);
//                String letraFacturaPapel = "C";
////                numf = cbte_nro;
////                int comprobanteNumero = numf;
//                int largo = ("00000000" + numeroFacturaPapel).length();
//                numeroFacturaPapel = ("00000000" + numeroFacturaPapel).substring(largo - 8, largo);
//                Double importeAbono = total; //100.50
//                String imp_total = df.format(importeAbono).toString().replaceAll("\\,", "\\.");//"124.00";
//                String imp_tot_conc = "0.00";
//                BigDecimal gravado = new BigDecimal(imp_total);
//                BigDecimal tot4I = gravado;
////                MathContext mc = new MathContext(5);
////                gravado = gravado.divide(new BigDecimal("1.21"), mc);
//                Double grav = gravado.doubleValue();
//                gravado = new BigDecimal(df.format(grav).replace(",", "."));
//                BigDecimal iv4 = new BigDecimal("0.00"); //tot4I.subtract(gravado);
//                String imp_neto = df.format(gravado.doubleValue()).replaceAll("\\,", "\\.");
//                String imp_iva = df.format(iv4.doubleValue()).replaceAll("\\,", "\\.");
//                int internos = 0; // es el entero del total de impuestos
//                String imp_trib = "", imp_op_ex = "0";
//                imp_trib = "0.00";
//
//                //String f_vencim = new SimpleDateFormat("yyyyMMdd").format(fws);
//                //String f_desde = new SimpleDateFormat("yyyyMMdd").format(fws);
//                //String f_hasta = new SimpleDateFormat("yyyyMMdd").format(fws);
//                String fecha_cbte = fechaWs, fecha_venc_pago = fws_3_str;
//                String fecha_serv_desde = fws_1_str, fecha_serv_hasta = fws_2_str; // AQUI COLOCAR LAS FECHAS CALCULADAS
//                String moneda_id = "PES", moneda_ctz = "1.000";
//
//                int xxx = 1;
//                if (xxx != 0) {
//                    Variant ok = Dispatch.call(wsfev1, "CrearFactura",
//                            new Variant(concepto), new Variant(tipo_doc),
//                            new Variant(nro_doc), new Variant(tipo_cbte),
//                            new Variant(pto_vta),
//                            new Variant(cbt_desde), new Variant(cbt_hasta),
//                            new Variant(imp_total), new Variant(imp_tot_conc),
//                            new Variant(imp_neto), new Variant(imp_iva),
//                            new Variant(imp_trib), new Variant(imp_op_ex),
//                            new Variant(fecha_cbte), new Variant(fecha_venc_pago),
//                            new Variant(fecha_serv_desde), new Variant(fecha_serv_hasta),
//                            new Variant(moneda_id), new Variant(moneda_ctz));
//                    if (internos > 0) {
//                        Variant tributo_id = new Variant(99),
//                                tributo_desc = new Variant("Otros Impuestos"),
//                                tributo_base_imp = new Variant("0.00"),
//                                tributo_alic = new Variant("0.00"),
//                                tributo_importe = new Variant(imp_trib);
//                        Dispatch.call(wsfev1, "AgregarTributo",
//                                tributo_id, tributo_desc, tributo_base_imp,
//                                tributo_alic, tributo_importe);
//                    }
////                    Variant iva_id = new Variant(5),
////                            iva_base_imp = new Variant(imp_neto),
////                            iva_importe = new Variant(imp_iva);
////                    Dispatch.call(wsfev1, "AgregarIva",
////                            iva_id, iva_base_imp, iva_importe);
//                    Dispatch.put(wsfev1, "Reprocesar", new Variant(false));
//                    Variant cae = Dispatch.call(wsfev1, "CAESolicitar");
//                    String requ = Dispatch.get(wsfev1, "XmlRequest").toString();
//                    String resp = Dispatch.get(wsfev1, "XmlResponse").toString();
//                    excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
//                    String errmsg = Dispatch.get(wsfev1, "ErrMsg").toString();
//                    String obs = Dispatch.get(wsfev1, "Obs").toString();
//                    String vto = Dispatch.get(wsfev1, "Vencimiento").toString();
//                    SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
//                    //caeVencim = sd.parse(vto);
//                    String resultado = Dispatch.get(wsfev1, "Resultado").toString();
//                    if (!resultado.equals("A")) {
//                        nc.setMotivo("Obs: " + obs + "\nError: " + errmsg);
//                        JOptionPane.showMessageDialog(null, "Obs: " + obs + "\nError: " + errmsg);
//                        return nc;
//                    }
//                    if (vto != "" && vto != null) {
//                        caeVencim = sd.parse(vto);
////                        String vencCae = vto.substring(6, 8) + "/" + vto.substring(4, 6) + "/" + vto.substring(0, 4);
//                    }
//                    Long caeLng = Long.valueOf(cae.toString());
//                    nc.setCae(caeLng);
//                    nc.setFechaVencimiento(caeVencim);
//                    nc.setFechaPeriodoDesde(fws_1);
//                    nc.setFechaPeriodoHasta(fws_2);
//                    nc.setFechaVencimientoPago(fws_3);
////                    caeLong = Long.valueOf(cae.toString());
//                    String ruta1 = "c:/system/cmp/" + tipoComprob
//                            + letraFacturaPapel + sucursalFacturaPapel
//                            + numeroFacturaPapel + ".xm1";
//                    String ruta2 = "c:/system/cmp/" + tipoComprob
//                            + letraFacturaPapel + sucursalFacturaPapel
//                            + numeroFacturaPapel + ".xm2";
//                    File archivo1 = new File(ruta1);
//                    File archivo2 = new File(ruta2);
//                    BufferedWriter bw1, bw2;
//                    bw1 = new BufferedWriter(new FileWriter(archivo1));
//                    bw2 = new BufferedWriter(new FileWriter(archivo2));
//                    bw1.write(requ);
//                    bw2.write(resp);
//                    bw1.close();
//                    bw2.close();
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e);
//                e.printStackTrace();
//                return nc;
//            }
//        } else {
//            nc.setFechaVencimiento(caeVencim);
//            nc.setEstado("A");
//            nc.setFechaCae(new Date());
//            nc.setFechaPeriodoDesde(new Date());
//            nc.setFechaPeriodoHasta(new Date());
//            nc.setFechaVencimiento(new Date());
//            nc.setFechaVencimientoPago(new Date());
//            nc.setNumero(548975);
//            nc.setSucursal(1);
//        }
//        return nc;
//    }
    public static NuevoCae enviarFacturaAfip(TitularCuit titularCuit, String cuitCliente, Double gravado, Double iva, Double total) {
        NuevoCae ncae = new NuevoCae();
        ncae.setEstado("A");
        ncae.setCae(1234567890123456L);
        Date fechaVencimiento = new Date();
        ncae.setFechaVencimiento(fechaVencimiento);
        ncae.setSucursal(titularCuit.getSucursal());
        ncae.setFechaCae(new Date());
        ncae.setNumero(1532);
        if (tst == 0) {

        }
        return ncae;
    }

    public static NuevoCae getNuevoCaeFcC(Consorcio cliente, TitularCuit titular, Abono abono, Date da1, Date da2, Date da3, Date da4, Integer ps) {
        NuevoCae nc = null;
        String ptoVta = titular.getSucursal().toString();

        String concepto = ps.toString(); // producto y servicio
        String cuiCli = cliente.getCuit();
        String cuiTit = titular.getCuit();
        String tipo_cbte = "11";
        if (cuiCli.length() != 13) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE EL CUIT CLIENTE, DEBE TENER GUIONES");
            return nc;
        }
        if (cuiTit.length() == 0) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE EL CUIT TITULAR, NO DEBE ESTAR VACIO");
            return nc;
        }
        String tipo_doc = cliente.getDocumentoTipo();
        String nro_doc_cliente = cuiCli.substring(0, 2) + cuiCli.substring(3, 11) + cuiCli.substring(12, 13);
        String nro_doc_titular = cuiTit.substring(0, 2) + cuiTit.substring(3, 11) + cuiTit.substring(12, 13);
        CertificadosAfip certificado = null;
        try {
            certificado = new CertificadosAfipService().getCertificadoByTitular(titular);
        } catch (Exception ex) {
            Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "NO SE PUEDE OBTENER CERTIFICADOS AFIP");
            return nc;
        }
        if (certificado != null) {
            String certif = certificado.getCertificado();
            String llave = certificado.getLlave();
            TicketTime tt = UtilAfip.solicitarNuevoTicket(titular, certif, llave);
            String tkn = tt.getToken();
            String sgn = tt.getSign();
            Integer cbte_nro = UtilAfip.getUltimaFcC(ptoVta, nro_doc_titular, tkn, sgn);
            cbte_nro += 1;
            int cbt_desde = cbte_nro, cbt_hasta = cbte_nro;
            Double importeAbono = abono.getImporte() / abono.getCuotas();
            String imp_total = df.format(importeAbono).replaceAll("\\,", "\\.");//"124.00";
            String imp_tot_conc = "0.00";
            String imp_neto = imp_total;
            String imp_iva = "0.00";
            String imp_trib = "0.00", imp_op_ex = "0";
            String fecha_cbte = fechaWs.format(da1);
            String fecha_venc_pago = fechaWs.format(da4);
            String fecha_serv_desde = fechaWs.format(da2), fecha_serv_hasta = fechaWs.format(da3);
            String moneda_id = "PES", moneda_ctz = "1.000";

            if (xxx != 0) {
                Variant ok = Dispatch.call(wsfev1, "CrearFactura",
                        new Variant(concepto), new Variant(tipo_doc),
                        new Variant(nro_doc_cliente), new Variant(tipo_cbte),
                        new Variant(ptoVta),
                        new Variant(cbt_desde), new Variant(cbt_hasta),
                        new Variant(imp_total), new Variant(imp_tot_conc),
                        new Variant(imp_neto), new Variant(imp_iva),
                        new Variant(imp_trib), new Variant(imp_op_ex),
                        new Variant(fecha_cbte), new Variant(fecha_venc_pago),
                        new Variant(fecha_serv_desde), new Variant(fecha_serv_hasta),
                        new Variant(moneda_id), new Variant(moneda_ctz));
                Dispatch.put(wsfev1, "Reprocesar", new Variant(true));
                Variant cae = Dispatch.call(wsfev1, "CAESolicitar");
                String requ = Dispatch.get(wsfev1, "XmlRequest").toString();
                String resp = Dispatch.get(wsfev1, "XmlResponse").toString();
                String excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
                String errmsg = Dispatch.get(wsfev1, "ErrMsg").toString();
                String obs = Dispatch.get(wsfev1, "Obs").toString();
                String vto = Dispatch.get(wsfev1, "Vencimiento").toString();
                SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
                Date caeVencim = new Date();
                String resultado = Dispatch.get(wsfev1, "Resultado").toString();
                if (!resultado.equals("A")) {
                    JOptionPane.showMessageDialog(null, "Obs: " + obs + "\nError: " + errmsg);
                    nc = null;
                    return nc;
                }
                //99
                if (vto != "" && vto != null) {
                    try {
                        caeVencim = sd.parse(vto);
                        System.out.println("                >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>              99");
                        System.out.println(vto);
                        System.out.println("                _X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X              99");
                    } catch (ParseException ex) {
                        Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String vencCae = vto.substring(6, 8) + "/" + vto.substring(4, 6) + "/" + vto.substring(0, 4);
                }
                Long caeLong = Long.valueOf(cae.toString());

                nc = new NuevoCae();

                nc.setCae(caeLong);
                nc.setErrMsj(errmsg);
                nc.setEstado(resultado);
                nc.setExcepcion(excepcion);
                nc.setFechaCae(caeVencim);
                nc.setMotivo("");
                nc.setNumero(cbt_desde);
                nc.setObservaciones(obs);
                nc.setSucursal(titular.getSucursal());

                String ruta1 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm1";
                String ruta2 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm2";
                File archivo1 = new File(ruta1);
                File archivo2 = new File(ruta2);
                BufferedWriter bw1, bw2;
                try {
                    bw1 = new BufferedWriter(new FileWriter(archivo1));
                    bw2 = new BufferedWriter(new FileWriter(archivo2));
                    bw1.write(requ);
                    bw2.write(resp);
                    bw1.close();
                    bw2.close();
                } catch (IOException ex) {
                    Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERROR GRABANDO ARCHIVOS XML");
                    return nc;
                }
            } else {
                // aqui esta en test
                String requ = "datos del comprobante afip enviado";
                String resp = "respuesta del servidor afip";

                nc = new NuevoCae();
                nc.setCae(123456789L);
                nc.setErrMsj("_E_");
                nc.setEstado("A");
                nc.setExcepcion("_");
                nc.setFechaCae(new Date());
                nc.setMotivo("_m_");
                nc.setNumero(cbt_desde);
                nc.setObservaciones("OBSRV");
                nc.setSucursal(titular.getSucursal());
                String ruta1 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm1";
                String ruta2 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm2";
                File archivo1 = new File(ruta1);
                File archivo2 = new File(ruta2);
                BufferedWriter bw1, bw2;
                try {
                    bw1 = new BufferedWriter(new FileWriter(archivo1));
                    bw2 = new BufferedWriter(new FileWriter(archivo2));
                    bw1.write(requ);
                    bw2.write(resp);
                    bw1.close();
                    bw2.close();
                } catch (IOException ex) {
                    Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERROR GRABANDO ARCHIVOS XML");
                    return nc;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERRORR 94 - EN CERTIFICADOS");
            return nc;
        }
        return nc;
        /*
        int  = Integer.parseInt(ult.toString()) + 1,
                                
                        numeroFacturaPapel = String.valueOf(cbte_nro);
                        numf = cbte_nro;
                        comprobanteNumero = cbte_nro;
                        int largo = ("00000000" + numeroFacturaPapel).length();
                        numeroFacturaPapel = ("00000000" + numeroFacturaPapel).substring(largo - 8, largo);
                        
                        
                        String imp_tot_conc = "0.00";
                        String imp_neto = df.format(f.getGravado()).toString().replaceAll("\\,", "\\.");
                        String imp_iva = df.format(f.getIva()).toString().replaceAll("\\,", "\\.");
                        int internos = (int) rint(f.getImpuesto() * 100);
                        String imp_trib = "", imp_op_ex = "0";
                        if (internos > 0) {
                            imp_trib = df.format(f.getImpuesto()).toString().replaceAll("\\,", "\\.");
                        } else {
                            imp_trib = "0.00";
                        }
                        String fecha_cbte = fechaWs, fecha_venc_pago = "";
                        String fecha_serv_desde = "", fecha_serv_hasta = "";
                        String moneda_id = "PES", moneda_ctz = "1.000";

                        int xxx = 1;
                        if (xxx != 0) {
                            Variant ok = Dispatch.call(wsfev1, "CrearFactura",
                                    new Variant(concepto), new Variant(tipo_doc),
                                    new Variant(nro_doc), new Variant(tipo_cbte),
                                    new Variant(pto_vta),
                                    new Variant(cbt_desde), new Variant(cbt_hasta),
                                    new Variant(imp_total), new Variant(imp_tot_conc),
                                    new Variant(imp_neto), new Variant(imp_iva),
                                    new Variant(imp_trib), new Variant(imp_op_ex),
                                    new Variant(fecha_cbte), new Variant(fecha_venc_pago),
                                    new Variant(fecha_serv_desde), new Variant(fecha_serv_hasta),
                                    new Variant(moneda_id), new Variant(moneda_ctz));
                            if (internos > 0) {
                                Variant tributo_id = new Variant(99),
                                        tributo_desc = new Variant("Otros Impuestos"),
                                        tributo_base_imp = new Variant("0.00"),
                                        tributo_alic = new Variant("0.00"),
                                        tributo_importe = new Variant(imp_trib);
                                Dispatch.call(wsfev1, "AgregarTributo",
                                        tributo_id, tributo_desc, tributo_base_imp,
                                        tributo_alic, tributo_importe);
                            }
                            Variant iva_id = new Variant(5),
                                    iva_base_imp = new Variant(imp_neto),
                                    iva_importe = new Variant(imp_iva);
                            Dispatch.call(wsfev1, "AgregarIva",
                                    iva_id, iva_base_imp, iva_importe);
                            Dispatch.put(wsfev1, "Reprocesar", new Variant(false));
                            Variant cae = Dispatch.call(wsfev1, "CAESolicitar");
                            String requ = Dispatch.get(wsfev1, "XmlRequest").toString();
                            String resp = Dispatch.get(wsfev1, "XmlResponse").toString();
                            excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
                            String errmsg = Dispatch.get(wsfev1, "ErrMsg").toString();
                            String obs = Dispatch.get(wsfev1, "Obs").toString();
                            String vto = Dispatch.get(wsfev1, "Vencimiento").toString();
                            SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
                            //caeVencim = sd.parse(vto);
                            String resultado = Dispatch.get(wsfev1, "Resultado").toString();
                            if (!resultado.equals("A")) {
                                JOptionPane.showMessageDialog(this, "Obs: " + obs + "\nError: " + errmsg);
                                return;
                            }
                            if (vto != "" && vto != null) {
                                caeVencim = sd.parse(vto);
                                vencCae = vto.substring(6, 8) + "/" + vto.substring(4, 6) + "/" + vto.substring(0, 4);
                            }
                            caeLong = Long.valueOf(cae.toString());
                            String ruta1 = "c:/ventas/compmartin/" + tipoComprob
                                    + letraFacturaPapel + sucursalFacturaPapel
                                    + numeroFacturaPapel + ".xm1";
                            String ruta2 = "c:/ventas/compmartin/" + tipoComprob
                                    + letraFacturaPapel + sucursalFacturaPapel
                                    + numeroFacturaPapel + ".xm2";
                            File archivo1 = new File(ruta1);
                            File archivo2 = new File(ruta2);
                            BufferedWriter bw1, bw2;
                            bw1 = new BufferedWriter(new FileWriter(archivo1));
                            bw2 = new BufferedWriter(new FileWriter(archivo2));
                            bw1.write(requ);
                            bw2.write(resp);
                            bw1.close();
                            bw2.close();
                        }
         */
//        return nc;
    }

    public static NuevoCae getNuevoCaeFcB(Consorcio cliente, TitularCuit titular, Abono abono, Date da1, Date da2, Date da3, Date da4, Integer ps) {
        NuevoCae nc = null;
        String ptoVta = titular.getSucursal().toString();

        String concepto = ps.toString(); // producto y servicio
        String cuiCli = cliente.getCuit();
        String cuiTit = titular.getCuit();
        String tipo_cbte = "6";
        if (cuiCli.length() != 13) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE EL CUIT CLIENTE, DEBE TENER GUIONES");
            return nc;
        }
        if (cuiTit.length() == 0) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE EL CUIT TITULAR, NO DEBE ESTAR VACIO");
            return nc;
        }
        String tipo_doc = cliente.getDocumentoTipo();
        String nro_doc_cliente = cuiCli.substring(0, 2) + cuiCli.substring(3, 11) + cuiCli.substring(12, 13);
        String nro_doc_titular = cuiTit.substring(0, 2) + cuiTit.substring(3, 11) + cuiTit.substring(12, 13);
        CertificadosAfip certificado = null;
        try {
            certificado = new CertificadosAfipService().getCertificadoByTitular(titular);
        } catch (Exception ex) {
            Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "NO SE PUEDE OBTENER CERTIFICADOS AFIP");
            return nc;
        }
        if (certificado != null) {
            String certif = certificado.getCertificado();
            String llave = certificado.getLlave();
            TicketTime tt = UtilAfip.solicitarNuevoTicket(titular, certif, llave);
            String tkn = tt.getToken();
            String sgn = tt.getSign();
            Integer cbte_nro = UtilAfip.getUltimaFcB(ptoVta, nro_doc_titular, tkn, sgn);
            cbte_nro += 1;
            int cbt_desde = cbte_nro, cbt_hasta = cbte_nro;
            Double importeAbono = abono.getImporte() / abono.getCuotas();
            String imp_total = df.format(importeAbono).replaceAll("\\,", "\\.");//"124.00";
            String imp_tot_conc = "0.00";
            String imp_neto = imp_total;
            String imp_iva = "0.00";
            String imp_trib = "0.00", imp_op_ex = "0";
            String fecha_cbte = fechaWs.format(da1);
            String fecha_venc_pago = fechaWs.format(da4);
            String fecha_serv_desde = fechaWs.format(da2), fecha_serv_hasta = fechaWs.format(da3);
            String moneda_id = "PES", moneda_ctz = "1.000";

            if (xxx != 0) {
                Variant ok = Dispatch.call(wsfev1, "CrearFactura",
                        new Variant(concepto), new Variant(tipo_doc),
                        new Variant(nro_doc_cliente), new Variant(tipo_cbte),
                        new Variant(ptoVta),
                        new Variant(cbt_desde), new Variant(cbt_hasta),
                        new Variant(imp_total), new Variant(imp_tot_conc),
                        new Variant(imp_neto), new Variant(imp_iva),
                        new Variant(imp_trib), new Variant(imp_op_ex),
                        new Variant(fecha_cbte), new Variant(fecha_venc_pago),
                        new Variant(fecha_serv_desde), new Variant(fecha_serv_hasta),
                        new Variant(moneda_id), new Variant(moneda_ctz));
                Dispatch.put(wsfev1, "Reprocesar", new Variant(true));
                Variant cae = Dispatch.call(wsfev1, "CAESolicitar");
                String requ = Dispatch.get(wsfev1, "XmlRequest").toString();
                String resp = Dispatch.get(wsfev1, "XmlResponse").toString();
                String excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
                String errmsg = Dispatch.get(wsfev1, "ErrMsg").toString();
                String obs = Dispatch.get(wsfev1, "Obs").toString();
                String vto = Dispatch.get(wsfev1, "Vencimiento").toString();
                SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
                Date caeVencim = new Date();
                String resultado = Dispatch.get(wsfev1, "Resultado").toString();
                if (!resultado.equals("A")) {
                    JOptionPane.showMessageDialog(null, "Obs: " + obs + "\nError: " + errmsg);
                    nc = null;
                    return nc;
                }
                //99
                if (vto != "" && vto != null) {
                    try {
                        caeVencim = sd.parse(vto);
                        System.out.println("                >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>              99");
                        System.out.println(vto);
                        System.out.println("                _X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X              99");
                    } catch (ParseException ex) {
                        Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String vencCae = vto.substring(6, 8) + "/" + vto.substring(4, 6) + "/" + vto.substring(0, 4);
                }
                Long caeLong = Long.valueOf(cae.toString());

                nc = new NuevoCae();

                nc.setCae(caeLong);
                nc.setErrMsj(errmsg);
                nc.setEstado(resultado);
                nc.setExcepcion(excepcion);
                nc.setFechaCae(caeVencim);
                nc.setMotivo("");
                nc.setNumero(cbt_desde);
                nc.setObservaciones(obs);
                nc.setSucursal(titular.getSucursal());

                String ruta1 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm1";
                String ruta2 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm2";
                File archivo1 = new File(ruta1);
                File archivo2 = new File(ruta2);
                BufferedWriter bw1, bw2;
                try {
                    bw1 = new BufferedWriter(new FileWriter(archivo1));
                    bw2 = new BufferedWriter(new FileWriter(archivo2));
                    bw1.write(requ);
                    bw2.write(resp);
                    bw1.close();
                    bw2.close();
                } catch (IOException ex) {
                    Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERROR GRABANDO ARCHIVOS XML");
                    return nc;
                }
            } else {
                // aqui esta en test
                String requ = "datos del comprobante afip enviado";
                String resp = "respuesta del servidor afip";

                nc = new NuevoCae();
                nc.setCae(123456789L);
                nc.setErrMsj("_E_");
                nc.setEstado("A");
                nc.setExcepcion("_");
                nc.setFechaCae(new Date());
                nc.setMotivo("_m_");
                nc.setNumero(cbt_desde);
                nc.setObservaciones("OBSRV");
                nc.setSucursal(titular.getSucursal());
                String ruta1 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm1";
                String ruta2 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm2";
                File archivo1 = new File(ruta1);
                File archivo2 = new File(ruta2);
                BufferedWriter bw1, bw2;
                try {
                    bw1 = new BufferedWriter(new FileWriter(archivo1));
                    bw2 = new BufferedWriter(new FileWriter(archivo2));
                    bw1.write(requ);
                    bw2.write(resp);
                    bw1.close();
                    bw2.close();
                } catch (IOException ex) {
                    Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERROR GRABANDO ARCHIVOS XML");
                    return nc;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERRORR 94 - EN CERTIFICADOS");
            return nc;
        }
        return nc;
    }

    public static NuevoCae getNuevoCaeFcA(Consorcio cliente, TitularCuit titular, Abono abono, Date da1, Date da2, Date da3, Date da4, Integer ps) {
        NuevoCae nc = null;
        // a desarrollar
        System.exit(0);
        String ptoVta = titular.getSucursal().toString();

        String concepto = ps.toString(); // producto y servicio
        String cuiCli = cliente.getCuit();
        String cuiTit = titular.getCuit();
        String tipo_cbte = "6";
        if (cuiCli.length() != 13) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE EL CUIT CLIENTE, DEBE TENER GUIONES");
            return nc;
        }
        if (cuiTit.length() == 0) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE EL CUIT TITULAR, NO DEBE ESTAR VACIO");
            return nc;
        }
        String tipo_doc = cliente.getDocumentoTipo();
        String nro_doc_cliente = cuiCli.substring(0, 2) + cuiCli.substring(3, 11) + cuiCli.substring(12, 13);
        String nro_doc_titular = cuiTit.substring(0, 2) + cuiTit.substring(3, 11) + cuiTit.substring(12, 13);
        CertificadosAfip certificado = null;
        try {
            certificado = new CertificadosAfipService().getCertificadoByTitular(titular);
        } catch (Exception ex) {
            Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "NO SE PUEDE OBTENER CERTIFICADOS AFIP");
            return nc;
        }
        if (certificado != null) {
            String certif = certificado.getCertificado();
            String llave = certificado.getLlave();
            TicketTime tt = UtilAfip.solicitarNuevoTicket(titular, certif, llave);
            String tkn = tt.getToken();
            String sgn = tt.getSign();
            Integer cbte_nro = UtilAfip.getUltimaFcB(ptoVta, nro_doc_titular, tkn, sgn);
            cbte_nro += 1;
            int cbt_desde = cbte_nro, cbt_hasta = cbte_nro;
            Double importeAbono = abono.getImporte() / abono.getCuotas();
            String imp_total = df.format(importeAbono).replaceAll("\\,", "\\.");//"124.00";
            String imp_tot_conc = "0.00";
            String imp_neto = imp_total;
            String imp_iva = "0.00";
            String imp_trib = "0.00", imp_op_ex = "0";
            String fecha_cbte = fechaWs.format(da1);
            String fecha_venc_pago = fechaWs.format(da4);
            String fecha_serv_desde = fechaWs.format(da2), fecha_serv_hasta = fechaWs.format(da3);
            String moneda_id = "PES", moneda_ctz = "1.000";

            if (xxx != 0) {
                Variant ok = Dispatch.call(wsfev1, "CrearFactura",
                        new Variant(concepto), new Variant(tipo_doc),
                        new Variant(nro_doc_cliente), new Variant(tipo_cbte),
                        new Variant(ptoVta),
                        new Variant(cbt_desde), new Variant(cbt_hasta),
                        new Variant(imp_total), new Variant(imp_tot_conc),
                        new Variant(imp_neto), new Variant(imp_iva),
                        new Variant(imp_trib), new Variant(imp_op_ex),
                        new Variant(fecha_cbte), new Variant(fecha_venc_pago),
                        new Variant(fecha_serv_desde), new Variant(fecha_serv_hasta),
                        new Variant(moneda_id), new Variant(moneda_ctz));
                Dispatch.put(wsfev1, "Reprocesar", new Variant(true));
                Variant cae = Dispatch.call(wsfev1, "CAESolicitar");
                String requ = Dispatch.get(wsfev1, "XmlRequest").toString();
                String resp = Dispatch.get(wsfev1, "XmlResponse").toString();
                String excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
                String errmsg = Dispatch.get(wsfev1, "ErrMsg").toString();
                String obs = Dispatch.get(wsfev1, "Obs").toString();
                String vto = Dispatch.get(wsfev1, "Vencimiento").toString();
                SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
                Date caeVencim = new Date();
                String resultado = Dispatch.get(wsfev1, "Resultado").toString();
                if (!resultado.equals("A")) {
                    JOptionPane.showMessageDialog(null, "Obs: " + obs + "\nError: " + errmsg);
                    nc = null;
                    return nc;
                }
                //99
                if (vto != "" && vto != null) {
                    try {
                        caeVencim = sd.parse(vto);
                        System.out.println("                >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>              99");
                        System.out.println(vto);
                        System.out.println("                _X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X              99");
                    } catch (ParseException ex) {
                        Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String vencCae = vto.substring(6, 8) + "/" + vto.substring(4, 6) + "/" + vto.substring(0, 4);
                }
                Long caeLong = Long.valueOf(cae.toString());

                nc = new NuevoCae();

                nc.setCae(caeLong);
                nc.setErrMsj(errmsg);
                nc.setEstado(resultado);
                nc.setExcepcion(excepcion);
                nc.setFechaCae(caeVencim);
                nc.setMotivo("");
                nc.setNumero(cbt_desde);
                nc.setObservaciones(obs);
                nc.setSucursal(titular.getSucursal());

                String ruta1 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm1";
                String ruta2 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm2";
                File archivo1 = new File(ruta1);
                File archivo2 = new File(ruta2);
                BufferedWriter bw1, bw2;
                try {
                    bw1 = new BufferedWriter(new FileWriter(archivo1));
                    bw2 = new BufferedWriter(new FileWriter(archivo2));
                    bw1.write(requ);
                    bw2.write(resp);
                    bw1.close();
                    bw2.close();
                } catch (IOException ex) {
                    Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERROR GRABANDO ARCHIVOS XML");
                    return nc;
                }
            } else {
                // aqui esta en test
                String requ = "datos del comprobante afip enviado";
                String resp = "respuesta del servidor afip";

                nc = new NuevoCae();
                nc.setCae(123456789L);
                nc.setErrMsj("_E_");
                nc.setEstado("A");
                nc.setExcepcion("_");
                nc.setFechaCae(new Date());
                nc.setMotivo("_m_");
                nc.setNumero(cbt_desde);
                nc.setObservaciones("OBSRV");
                nc.setSucursal(titular.getSucursal());
                String ruta1 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm1";
                String ruta2 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm2";
                File archivo1 = new File(ruta1);
                File archivo2 = new File(ruta2);
                BufferedWriter bw1, bw2;
                try {
                    bw1 = new BufferedWriter(new FileWriter(archivo1));
                    bw2 = new BufferedWriter(new FileWriter(archivo2));
                    bw1.write(requ);
                    bw2.write(resp);
                    bw1.close();
                    bw2.close();
                } catch (IOException ex) {
                    Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERROR GRABANDO ARCHIVOS XML");
                    return nc;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERRORR 94 - EN CERTIFICADOS");
            return nc;
        }
        return nc;
    }

    public static NuevoCae getNuevoCaeFcAReparacion(Consorcio cliente, TitularCuit titular, Double total, Date da1, Date da2, Date da3, Date da4, Integer ps) {
        NuevoCae nc = null;
        String ptoVta = titular.getSucursal().toString();

        // a desarrollar
        System.exit(0);

        String concepto = ps.toString(); // producto y servicio
        String cuiCli = cliente.getCuit();
        String cuiTit = titular.getCuit();
        String tipo_cbte = "11";
        if (cuiCli.length() != 13) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE EL CUIT CLIENTE, DEBE TENER GUIONES");
            return nc;
        }
        if (cuiTit.length() == 0) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE EL CUIT TITULAR, NO DEBE ESTAR VACIO");
            return nc;
        }
        String tipo_doc = cliente.getDocumentoTipo();
        String nro_doc_cliente = cuiCli.substring(0, 2) + cuiCli.substring(3, 11) + cuiCli.substring(12, 13);
        String nro_doc_titular = cuiTit.substring(0, 2) + cuiTit.substring(3, 11) + cuiTit.substring(12, 13);
        CertificadosAfip certificado = null;
        try {
            certificado = new CertificadosAfipService().getCertificadoByTitular(titular);
        } catch (Exception ex) {
            Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "NO SE PUEDE OBTENER CERTIFICADOS AFIP");
            return nc;
        }
        if (certificado != null) {
            String certif = certificado.getCertificado();
            String llave = certificado.getLlave();
            TicketTime tt = UtilAfip.solicitarNuevoTicket(titular, certif, llave);
            String tkn = tt.getToken();
            String sgn = tt.getSign();
            Integer cbte_nro = UtilAfip.getUltimaFcC(ptoVta, nro_doc_titular, tkn, sgn);
            cbte_nro += 1;
            int cbt_desde = cbte_nro, cbt_hasta = cbte_nro;
            Double importeAbono = total;
            String imp_total = df.format(importeAbono).replaceAll("\\,", "\\.");//"124.00";
            String imp_tot_conc = "0.00";
            String imp_neto = imp_total;
            String imp_iva = "0.00";
            String imp_trib = "0.00", imp_op_ex = "0";
            String fecha_cbte = fechaWs.format(da1);
            String fecha_venc_pago = fechaWs.format(da4);
            String fecha_serv_desde = fechaWs.format(da2), fecha_serv_hasta = fechaWs.format(da3);
            String moneda_id = "PES", moneda_ctz = "1.000";
            int xxx = 1;
            if (xxx != 0) {
                Variant ok = Dispatch.call(wsfev1, "CrearFactura",
                        new Variant(concepto), new Variant(tipo_doc),
                        new Variant(nro_doc_cliente), new Variant(tipo_cbte),
                        new Variant(ptoVta),
                        new Variant(cbt_desde), new Variant(cbt_hasta),
                        new Variant(imp_total), new Variant(imp_tot_conc),
                        new Variant(imp_neto), new Variant(imp_iva),
                        new Variant(imp_trib), new Variant(imp_op_ex),
                        new Variant(fecha_cbte), new Variant(fecha_venc_pago),
                        new Variant(fecha_serv_desde), new Variant(fecha_serv_hasta),
                        new Variant(moneda_id), new Variant(moneda_ctz));
                Dispatch.put(wsfev1, "Reprocesar", new Variant(true));
                Variant cae = Dispatch.call(wsfev1, "CAESolicitar");
                String requ = Dispatch.get(wsfev1, "XmlRequest").toString();
                String resp = Dispatch.get(wsfev1, "XmlResponse").toString();
                String excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
                String errmsg = Dispatch.get(wsfev1, "ErrMsg").toString();
                String obs = Dispatch.get(wsfev1, "Obs").toString();
                String vto = Dispatch.get(wsfev1, "Vencimiento").toString();
                SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
                Date caeVencim = new Date();
                String resultado = Dispatch.get(wsfev1, "Resultado").toString();
                if (!resultado.equals("A")) {
                    JOptionPane.showMessageDialog(null, "Obs: " + obs + "\nError: " + errmsg);
                    nc = null;
                    return nc;
                }
                //99
                if (vto != "" && vto != null) {
                    try {
                        caeVencim = sd.parse(vto);
                        System.out.println("                >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>              99");
                        System.out.println(vto);
                        System.out.println("                _X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X              99");
                    } catch (ParseException ex) {
                        Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    }
//                    String vencCae = vto.substring(6, 8) + "/" + vto.substring(4, 6) + "/" + vto.substring(0, 4);
                }
                Long caeLong = Long.valueOf(cae.toString());

                nc = new NuevoCae();

                nc.setCae(caeLong);
                nc.setErrMsj(errmsg);
                nc.setEstado(resultado);
                nc.setExcepcion(excepcion);
                nc.setFechaCae(caeVencim);
                nc.setMotivo("");
                nc.setNumero(cbte_nro);
                nc.setObservaciones(obs);
                nc.setSucursal(titular.getSucursal());

                String ruta1 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm1";
                String ruta2 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm2";
                File archivo1 = new File(ruta1);
                File archivo2 = new File(ruta2);
                BufferedWriter bw1, bw2;
                try {
                    bw1 = new BufferedWriter(new FileWriter(archivo1));
                    bw2 = new BufferedWriter(new FileWriter(archivo2));
                    bw1.write(requ);
                    bw2.write(resp);
                    bw1.close();
                    bw2.close();
                } catch (IOException ex) {
                    Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERROR GRABANDO ARCHIVOS XML");
                    return nc;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERRORR 94 - EN CERTIFICADOS");
            return nc;
        }
        return nc;
    }

    public static NuevoCae getNuevoCaeFcBReparacion(Consorcio cliente, TitularCuit titular, Double total, Date da1, Date da2, Date da3, Date da4, Integer ps) {
        NuevoCae nc = null;
        String ptoVta = titular.getSucursal().toString();

        // a desarrollar
        System.exit(0);

        String concepto = ps.toString(); // producto y servicio
        String cuiCli = cliente.getCuit();
        String cuiTit = titular.getCuit();
        String tipo_cbte = "11";
        if (cuiCli.length() != 13) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE EL CUIT CLIENTE, DEBE TENER GUIONES");
            return nc;
        }
        if (cuiTit.length() == 0) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE EL CUIT TITULAR, NO DEBE ESTAR VACIO");
            return nc;
        }
        String tipo_doc = cliente.getDocumentoTipo();
        String nro_doc_cliente = cuiCli.substring(0, 2) + cuiCli.substring(3, 11) + cuiCli.substring(12, 13);
        String nro_doc_titular = cuiTit.substring(0, 2) + cuiTit.substring(3, 11) + cuiTit.substring(12, 13);
        CertificadosAfip certificado = null;
        try {
            certificado = new CertificadosAfipService().getCertificadoByTitular(titular);
        } catch (Exception ex) {
            Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "NO SE PUEDE OBTENER CERTIFICADOS AFIP");
            return nc;
        }
        if (certificado != null) {
            String certif = certificado.getCertificado();
            String llave = certificado.getLlave();
            TicketTime tt = UtilAfip.solicitarNuevoTicket(titular, certif, llave);
            String tkn = tt.getToken();
            String sgn = tt.getSign();
            Integer cbte_nro = UtilAfip.getUltimaFcC(ptoVta, nro_doc_titular, tkn, sgn);
            cbte_nro += 1;
            int cbt_desde = cbte_nro, cbt_hasta = cbte_nro;
            Double importeAbono = total;
            String imp_total = df.format(importeAbono).replaceAll("\\,", "\\.");//"124.00";
            String imp_tot_conc = "0.00";
            String imp_neto = imp_total;
            String imp_iva = "0.00";
            String imp_trib = "0.00", imp_op_ex = "0";
            String fecha_cbte = fechaWs.format(da1);
            String fecha_venc_pago = fechaWs.format(da4);
            String fecha_serv_desde = fechaWs.format(da2), fecha_serv_hasta = fechaWs.format(da3);
            String moneda_id = "PES", moneda_ctz = "1.000";
            int xxx = 1;
            if (xxx != 0) {
                Variant ok = Dispatch.call(wsfev1, "CrearFactura",
                        new Variant(concepto), new Variant(tipo_doc),
                        new Variant(nro_doc_cliente), new Variant(tipo_cbte),
                        new Variant(ptoVta),
                        new Variant(cbt_desde), new Variant(cbt_hasta),
                        new Variant(imp_total), new Variant(imp_tot_conc),
                        new Variant(imp_neto), new Variant(imp_iva),
                        new Variant(imp_trib), new Variant(imp_op_ex),
                        new Variant(fecha_cbte), new Variant(fecha_venc_pago),
                        new Variant(fecha_serv_desde), new Variant(fecha_serv_hasta),
                        new Variant(moneda_id), new Variant(moneda_ctz));
                Dispatch.put(wsfev1, "Reprocesar", new Variant(true));
                Variant cae = Dispatch.call(wsfev1, "CAESolicitar");
                String requ = Dispatch.get(wsfev1, "XmlRequest").toString();
                String resp = Dispatch.get(wsfev1, "XmlResponse").toString();
                String excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
                String errmsg = Dispatch.get(wsfev1, "ErrMsg").toString();
                String obs = Dispatch.get(wsfev1, "Obs").toString();
                String vto = Dispatch.get(wsfev1, "Vencimiento").toString();
                SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
                Date caeVencim = new Date();
                String resultado = Dispatch.get(wsfev1, "Resultado").toString();
                if (!resultado.equals("A")) {
                    JOptionPane.showMessageDialog(null, "Obs: " + obs + "\nError: " + errmsg);
                    nc = null;
                    return nc;
                }
                //99
                if (vto != "" && vto != null) {
                    try {
                        caeVencim = sd.parse(vto);
                        System.out.println("                >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>              99");
                        System.out.println(vto);
                        System.out.println("                _X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X              99");
                    } catch (ParseException ex) {
                        Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    }
//                    String vencCae = vto.substring(6, 8) + "/" + vto.substring(4, 6) + "/" + vto.substring(0, 4);
                }
                Long caeLong = Long.valueOf(cae.toString());

                nc = new NuevoCae();

                nc.setCae(caeLong);
                nc.setErrMsj(errmsg);
                nc.setEstado(resultado);
                nc.setExcepcion(excepcion);
                nc.setFechaCae(caeVencim);
                nc.setMotivo("");
                nc.setNumero(cbte_nro);
                nc.setObservaciones(obs);
                nc.setSucursal(titular.getSucursal());

                String ruta1 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm1";
                String ruta2 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm2";
                File archivo1 = new File(ruta1);
                File archivo2 = new File(ruta2);
                BufferedWriter bw1, bw2;
                try {
                    bw1 = new BufferedWriter(new FileWriter(archivo1));
                    bw2 = new BufferedWriter(new FileWriter(archivo2));
                    bw1.write(requ);
                    bw2.write(resp);
                    bw1.close();
                    bw2.close();
                } catch (IOException ex) {
                    Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERROR GRABANDO ARCHIVOS XML");
                    return nc;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERRORR 94 - EN CERTIFICADOS");
            return nc;
        }
        return nc;
    }

    public static NuevoCae getNuevoCaeFcCReparacion(Consorcio cliente, TitularCuit titular, Double total, Date da1, Date da2, Date da3, Date da4, Integer ps) {
        NuevoCae nc = null;
        String ptoVta = titular.getSucursal().toString();

        String concepto = ps.toString(); // producto y servicio
        String cuiCli = cliente.getCuit();
        String cuiTit = titular.getCuit();
        String tipo_cbte = "11";
        if (cuiCli.length() != 13) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE EL CUIT CLIENTE, DEBE TENER GUIONES");
            return nc;
        }
        if (cuiTit.length() == 0) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE EL CUIT TITULAR, NO DEBE ESTAR VACIO");
            return nc;
        }
        String tipo_doc = cliente.getDocumentoTipo();
        String nro_doc_cliente = cuiCli.substring(0, 2) + cuiCli.substring(3, 11) + cuiCli.substring(12, 13);
        String nro_doc_titular = cuiTit.substring(0, 2) + cuiTit.substring(3, 11) + cuiTit.substring(12, 13);
        CertificadosAfip certificado = null;
        try {
            certificado = new CertificadosAfipService().getCertificadoByTitular(titular);
        } catch (Exception ex) {
            Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "NO SE PUEDE OBTENER CERTIFICADOS AFIP");
            return nc;
        }
        if (certificado != null) {
            String certif = certificado.getCertificado();
            String llave = certificado.getLlave();
            TicketTime tt = UtilAfip.solicitarNuevoTicket(titular, certif, llave);
            String tkn = tt.getToken();
            String sgn = tt.getSign();
            Integer cbte_nro = UtilAfip.getUltimaFcC(ptoVta, nro_doc_titular, tkn, sgn);
            cbte_nro += 1;
            int cbt_desde = cbte_nro, cbt_hasta = cbte_nro;
            Double importeAbono = total;
            String imp_total = df.format(importeAbono).replaceAll("\\,", "\\.");//"124.00";
            String imp_tot_conc = "0.00";
            String imp_neto = imp_total;
            String imp_iva = "0.00";
            String imp_trib = "0.00", imp_op_ex = "0";
            String fecha_cbte = fechaWs.format(da1);
            String fecha_venc_pago = fechaWs.format(da4);
            String fecha_serv_desde = fechaWs.format(da2), fecha_serv_hasta = fechaWs.format(da3);
            String moneda_id = "PES", moneda_ctz = "1.000";
            int xxx = 1;
            if (xxx != 0) {
                Variant ok = Dispatch.call(wsfev1, "CrearFactura",
                        new Variant(concepto), new Variant(tipo_doc),
                        new Variant(nro_doc_cliente), new Variant(tipo_cbte),
                        new Variant(ptoVta),
                        new Variant(cbt_desde), new Variant(cbt_hasta),
                        new Variant(imp_total), new Variant(imp_tot_conc),
                        new Variant(imp_neto), new Variant(imp_iva),
                        new Variant(imp_trib), new Variant(imp_op_ex),
                        new Variant(fecha_cbte), new Variant(fecha_venc_pago),
                        new Variant(fecha_serv_desde), new Variant(fecha_serv_hasta),
                        new Variant(moneda_id), new Variant(moneda_ctz));
                Dispatch.put(wsfev1, "Reprocesar", new Variant(true));
                Variant cae = Dispatch.call(wsfev1, "CAESolicitar");
                String requ = Dispatch.get(wsfev1, "XmlRequest").toString();
                String resp = Dispatch.get(wsfev1, "XmlResponse").toString();
                String excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
                String errmsg = Dispatch.get(wsfev1, "ErrMsg").toString();
                String obs = Dispatch.get(wsfev1, "Obs").toString();
                String vto = Dispatch.get(wsfev1, "Vencimiento").toString();
                SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
                Date caeVencim = new Date();
                String resultado = Dispatch.get(wsfev1, "Resultado").toString();
                if (!resultado.equals("A")) {
                    JOptionPane.showMessageDialog(null, "Obs: " + obs + "\nError: " + errmsg);
                    nc = null;
                    return nc;
                }
                //99
                if (vto != "" && vto != null) {
                    try {
                        caeVencim = sd.parse(vto);
                        System.out.println("                >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>              99");
                        System.out.println(vto);
                        System.out.println("                _X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X              99");
                    } catch (ParseException ex) {
                        Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    }
//                    String vencCae = vto.substring(6, 8) + "/" + vto.substring(4, 6) + "/" + vto.substring(0, 4);
                }
                Long caeLong = Long.valueOf(cae.toString());

                nc = new NuevoCae();

                nc.setCae(caeLong);
                nc.setErrMsj(errmsg);
                nc.setEstado(resultado);
                nc.setExcepcion(excepcion);
                nc.setFechaCae(caeVencim);
                nc.setMotivo("");
                nc.setNumero(cbte_nro);
                nc.setObservaciones(obs);
                nc.setSucursal(titular.getSucursal());

                String ruta1 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm1";
                String ruta2 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm2";
                File archivo1 = new File(ruta1);
                File archivo2 = new File(ruta2);
                BufferedWriter bw1, bw2;
                try {
                    bw1 = new BufferedWriter(new FileWriter(archivo1));
                    bw2 = new BufferedWriter(new FileWriter(archivo2));
                    bw1.write(requ);
                    bw2.write(resp);
                    bw1.close();
                    bw2.close();
                } catch (IOException ex) {
                    Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERROR GRABANDO ARCHIVOS XML");
                    return nc;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERRORR 94 - EN CERTIFICADOS");
            return nc;
        }
        return nc;
    }

    public static TicketTime solicitarNuevoTicket(TitularCuit titular, String certif, String llave) {
        TicketTime tkt = null;
        Date fecha = new Date();
        try {
            tkt = new TicketTimeService().getTicketByTitular(titular);
        } catch (Exception ex) {
            Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (tkt == null) {
            tkt = generarTicket(certif, llave);
            tkt.setTitular(titular);
//            System.out.println(tkt.getToken());
//            System.out.println(tkt.getSign());
//            System.out.println(tkt.getException());
            try {
                new TicketTimeService().saveTicket(tkt);
                return tkt;
            } catch (Exception ex) {
                Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "No se pudo guardar nuevo Ticket");
            }
        } else {
            if (fecha != tkt.getFecha()) {
                TicketTime tkt2 = generarTicket(certif, llave);
                tkt.setSign(tkt2.getSign());
                tkt.setException(tkt2.getException());
                tkt.setHora(tkt2.getHora());
                tkt.setMinuto(tkt2.getMinuto());
                tkt.setSegundo(tkt2.getSegundo());
                tkt.setToken(tkt2.getToken());
//                System.out.println(tkt.getToken());
//                System.out.println(tkt.getSign());
//                System.out.println(tkt.getException());
                try {
                    new TicketTimeService().updateTicket(tkt);
                    return tkt;
                } catch (Exception ex) {
                    Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "No se pudo guardar nuevo Ticket");
                }
            } else {
                Calendar ca1 = Calendar.getInstance();
                int hs1 = ca1.get(Calendar.HOUR_OF_DAY);
                int hs = hs1 * 100;
                int mi1 = ca1.get(Calendar.MINUTE);
                int ho_mi_1 = hs + mi1;
                int hs2 = tkt.getHora();
                int hs_1 = hs2 * 100;
                int mi2 = tkt.getMinuto();
                int ho_mi_2 = hs_1 + mi2;
                int tiempo = ho_mi_1 - ho_mi_2;
                if (tiempo > 30) {
                    TicketTime tkt2 = generarTicket(certif, llave);
                    tkt.setSign(tkt2.getSign());
                    tkt.setException(tkt2.getException());
                    tkt.setHora(tkt2.getHora());
                    tkt.setMinuto(tkt2.getMinuto());
                    tkt.setSegundo(tkt2.getSegundo());
                    tkt.setToken(tkt2.getToken());
//                    System.out.println(tkt.getToken());
//                    System.out.println(tkt.getSign());
//                    System.out.println(tkt.getException());
                    try {
                        new TicketTimeService().updateTicket(tkt);
                        return tkt;
                    } catch (Exception ex) {
                        Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "No se pudo guardar nuevo Ticket");
                        return null;
                    }
                } else {
                    return tkt;
                }
            }
        }
        return null;
    }

    public static Integer getUltimaFcC(String ptoVta, String cui1, String token, String sign) {
        int fc;
        Dispatch.put(wsfev1, "Cuit", new Variant(cui1));
        Dispatch.put(wsfev1, "Token", new Variant(token));
        Dispatch.put(wsfev1, "Sign", new Variant(sign));
        String cache = "";
        Dispatch.call(wsfev1, "Conectar",
                new Variant(cache),
                new Variant(wsd2)
        );
        String tipo_cbte = "11"; // FACTURAS
        Variant ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
                new Variant(tipo_cbte),
                new Variant(ptoVta));
//        String excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
        fc = Integer.valueOf(ult.toString());
        return fc;
    }

    public static Integer getUltimaFcB(String ptoVta, String cui1, String token, String sign) {
        int fc;
        Dispatch.put(wsfev1, "Cuit", new Variant(cui1));
        Dispatch.put(wsfev1, "Token", new Variant(token));
        Dispatch.put(wsfev1, "Sign", new Variant(sign));
        String cache = "";
        Dispatch.call(wsfev1, "Conectar",
                new Variant(cache),
                new Variant(wsd2)
        );
        String tipo_cbte = "6"; // FACTURAS B
        Variant ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
                new Variant(tipo_cbte),
                new Variant(ptoVta));
//        String excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
        fc = Integer.valueOf(ult.toString());
        return fc;
    }

    public static Integer getUltimaFcA(String ptoVta, String cui1, String token, String sign) {
        int fc;
        Dispatch.put(wsfev1, "Cuit", new Variant(cui1));
        Dispatch.put(wsfev1, "Token", new Variant(token));
        Dispatch.put(wsfev1, "Sign", new Variant(sign));
        String cache = "";
        Dispatch.call(wsfev1, "Conectar",
                new Variant(cache),
                new Variant(wsd2)
        );
        String tipo_cbte = "1"; // FACTURAS B
        Variant ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
                new Variant(tipo_cbte),
                new Variant(ptoVta));
//        String excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
        fc = Integer.valueOf(ult.toString());
        return fc;
    }

    public static NuevoCae getNuevoCaeNcC(Consorcio cliente, TitularCuit titular, Abono abono, Date da1, Date da2, Date da3, Date da4, Integer ps) {
        NuevoCae nc = null;
        String ptoVta = titular.getSucursal().toString();

        String concepto = ps.toString(); // producto y servicio
        String cuiCli = cliente.getCuit();
        String cuiTit = titular.getCuit();
        String tipo_cbte = "13";
        if (cuiCli.length() != 13) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE EL CUIT CLIENTE, DEBE TENER GUIONES");
            return nc;
        }
        if (cuiTit.length() == 0) {
            JOptionPane.showMessageDialog(null, "VERIFIQUE EL CUIT TITULAR, NO DEBE ESTAR VACIO");
            return nc;
        }
        String tipo_doc = cliente.getDocumentoTipo();
        String nro_doc_cliente = cuiCli.substring(0, 2) + cuiCli.substring(3, 11) + cuiCli.substring(12, 13);
        String nro_doc_titular = cuiTit.substring(0, 2) + cuiTit.substring(3, 11) + cuiTit.substring(12, 13);
        CertificadosAfip certificado = null;
        try {
            certificado = new CertificadosAfipService().getCertificadoByTitular(titular);
        } catch (Exception ex) {
            Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "NO SE PUEDE OBTENER CERTIFICADOS AFIP");
            return nc;
        }
        if (certificado != null) {
            String certif = certificado.getCertificado();
            String llave = certificado.getLlave();
            TicketTime tt = UtilAfip.solicitarNuevoTicket(titular, certif, llave);
            String tkn = tt.getToken();
            String sgn = tt.getSign();
            Integer cbte_nro = 0;
            cbte_nro += 1;
            int cbt_desde = cbte_nro, cbt_hasta = cbte_nro;
            Double importeAbono = abono.getImporte(); // / abono.getCuotas();
            String imp_total = df.format(importeAbono).replaceAll("\\,", "\\.");//"124.00";
            String imp_tot_conc = "0.00";
            String imp_neto = imp_total;
            String imp_iva = "0.00";
            String imp_trib = "0.00", imp_op_ex = "0";
            String fecha_cbte = fechaWs.format(da1);
            String fecha_venc_pago = fechaWs.format(da4);
            String fecha_serv_desde = fechaWs.format(da2), fecha_serv_hasta = fechaWs.format(da3);
            String moneda_id = "PES", moneda_ctz = "1.000";
            int xxx = 1;
            if (xxx != 0) {
                Variant ok = Dispatch.call(wsfev1, "CrearFactura",
                        new Variant(concepto), new Variant(tipo_doc),
                        new Variant(nro_doc_cliente), new Variant(tipo_cbte),
                        new Variant(ptoVta),
                        new Variant(cbt_desde), new Variant(cbt_hasta),
                        new Variant(imp_total), new Variant(imp_tot_conc),
                        new Variant(imp_neto), new Variant(imp_iva),
                        new Variant(imp_trib), new Variant(imp_op_ex),
                        new Variant(fecha_cbte), new Variant(fecha_venc_pago),
                        new Variant(fecha_serv_desde), new Variant(fecha_serv_hasta),
                        new Variant(moneda_id), new Variant(moneda_ctz));
                Variant cbte_asoc_tipo = new Variant("11"),
                        cbte_asoc_pto_vta = new Variant("10"),
                        cbte_asoc_nro = new Variant(1);
                Dispatch.call(wsfev1, "AgregarCmpAsoc",
                        cbte_asoc_tipo, cbte_asoc_pto_vta, cbte_asoc_nro);
                Dispatch.put(wsfev1, "Reprocesar", new Variant(true));
                Variant cae = Dispatch.call(wsfev1, "CAESolicitar");
                String requ = Dispatch.get(wsfev1, "XmlRequest").toString();
                String resp = Dispatch.get(wsfev1, "XmlResponse").toString();
                String excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
                String errmsg = Dispatch.get(wsfev1, "ErrMsg").toString();
                String obs = Dispatch.get(wsfev1, "Obs").toString();
                String vto = Dispatch.get(wsfev1, "Vencimiento").toString();
                SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
                Date caeVencim = new Date();
                String resultado = Dispatch.get(wsfev1, "Resultado").toString();
                if (!resultado.equals("A")) {
                    JOptionPane.showMessageDialog(null, "Obs: " + obs + "\nError: " + errmsg);
                    nc = null;
                    return nc;
                }
                //99
                if (vto != "" && vto != null) {
                    try {
                        caeVencim = sd.parse(vto);
                        System.out.println("                >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>              99");
                        System.out.println(vto);
                        System.out.println("                _X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X_X              99");
                    } catch (ParseException ex) {
                        Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String vencCae = vto.substring(6, 8) + "/" + vto.substring(4, 6) + "/" + vto.substring(0, 4);
                }
                Long caeLong = Long.valueOf(cae.toString());

                nc = new NuevoCae();

                nc.setCae(caeLong);
                nc.setErrMsj(errmsg);
                nc.setEstado(resultado);
                nc.setExcepcion(excepcion);
                nc.setFechaCae(caeVencim);
                nc.setMotivo("");
                nc.setNumero(cbte_nro);
                nc.setObservaciones(obs);
                nc.setSucursal(titular.getSucursal());

                String ruta1 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm1";
                String ruta2 = "c:/alfa_sistema/cmp/" + tipo_cbte + cuiTit
                        + "C" + ptoVta
                        + cbt_desde + ".xm2";
                File archivo1 = new File(ruta1);
                File archivo2 = new File(ruta2);
                BufferedWriter bw1, bw2;
                try {
                    bw1 = new BufferedWriter(new FileWriter(archivo1));
                    bw2 = new BufferedWriter(new FileWriter(archivo2));
                    bw1.write(requ);
                    bw2.write(resp);
                    bw1.close();
                    bw2.close();
                } catch (IOException ex) {
                    Logger.getLogger(UtilAfip.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERROR GRABANDO ARCHIVOS XML");
                    return nc;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERRORR 94 - EN CERTIFICADOS");
            return nc;
        }
        return nc;
    }

}
