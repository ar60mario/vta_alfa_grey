/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.util;

import ar.com.ventas.entities.Administrador;
import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.ComprobanteRenglones;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.FondoRecibo;
import ar.com.ventas.entities.NuevoCae;
import ar.com.ventas.entities.RenglonTrabajo;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.TitularCuit;
import ar.com.ventas.entities.Trabajo;
import ar.com.ventas.estructuras.Mes;
import ar.com.ventas.estructuras.TipoResponsable;
import ar.com.ventas.services.ComprobanteRenglonesService;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.ConfiguracionService;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.services.RenglonTrabajoService;
import ar.com.ventas.services.TitularCuitService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.WebColors;
import java.awt.Font;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.Math.rint;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import static java.lang.Math.rint;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author mcvalls
 */
public class PDFBuilder {

    private final BaseColor FONDO_BLANCO = WebColors.getRGBColor("#FFFFFF");
    private final BaseColor NEGRO = WebColors.getRGBColor("#000000");
    private final BaseColor GRIS = WebColors.getRGBColor("#2F4F4F");
    private Integer numeroFactura = 0;
    private DecimalFormat dfs = new DecimalFormat("0000");

    private DecimalFormat dfn = new DecimalFormat("00000000");
    private DecimalFormat df = new DecimalFormat("#0.00");
    private DecimalFormat dfc = new DecimalFormat("#0");
    private DecimalFormat df_ali = new DecimalFormat("#0.0");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
    private String encabezad0 = "SERVICIOS PROFESIONALES GENERALES";
    //private String encabezad0 = "SISTEMAS Y SERVICIOS INFORMATICOS";
    private final int BOLD = Font.BOLD;
    private final int PLAIN = Font.PLAIN;

    private static final int qrTamAncho = 150;
    private static final int qrTamAlto = 150;
    private static final String formato = "png";
    private static final String ruta = "c:/qr/codigoQR";
    private static final String extension = ".png";
    private static SimpleDateFormat sdf_qr = new SimpleDateFormat("yyyy-MM-dd");
    private final DecimalFormat df_qr = new DecimalFormat("00000000");
    private String url_qr = "https://www.afip.gob.ar/fe/qr/?p=";
    private String ver_qr = "1";
    private String fecha_qr;
    private String cuit_qr = "20142553202";
    private String puntoVenta_qr = "6";
    private String tipoComprobante_qr;
    private String numeroComprobante_qr;
    private String importe_qr;
    private String moneda_qr = "PES";
    private String cotiz_qr = "1";
    private String tipoDoc_qr;
    private String numeroDoc_qr;
    private String tipoCodigoAutoriz_qr = "E";
    private String nroCae_qr;
    private DecimalFormat dfT = new DecimalFormat("########0.00");

    private String getFileNameFc(String cons) {
        String filename = "Fc_"
                + cons;
        return filename;
    }

//    private String getFileNameFormattedNc(Factura cons) {
//        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
//        String filename = "Nc_"
//                + cons.getCliente().getDireccion().getCalle()
//                + "-" + cons.getCliente().getDireccion().getNumero()
//                + "C" + dfs.format(cons.getSucursal())
//                + dfn.format(cons.getNumero())
//                + "_" + sdf.format(cons.getFecha());
//        return filename;
//    }
    private void generarQR(String data) throws Exception {
        String cadenaCodificada = Base64.getEncoder().encodeToString(data.getBytes());
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

    /*
                armarFacturaC(titular, consorcio, tabla, iv.getNumero(), nuevoCae, total);
     */
    public File armarFacturaC(TitularCuit titular, Consorcio consorcio, JTable tabla, Integer numeroFactura,
            NuevoCae nuevoCae, Double importe)
            throws FileNotFoundException, DocumentException, Exception {
        Date fecha = nuevoCae.getFechaCae();
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 10, 10, 10);
        pdf.setMarginMirroringTopBottom(true);
        String archPdf = "c:/SYSTEM/data/FACTURAS//fc_C_"
                + titular.getCuit()
                //                + "_" + puntoVenta_qr
                + "_" + dfn.format(numeroFactura)
                + ".pdf";

        FileOutputStream ficheroPdf = new FileOutputStream(archPdf); // + fileNameFormatted + ".pdf");

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();

        // INICIO ENCABEZADO FACTURA
//        String fex = sdf.format(iv.getFecha());
        String fex = sdf.format(fecha);

        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 11, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        PdfPTable numCpte = new PdfPTable(3);
        numCpte.setWidthPercentage(100);
        float[] ancho0 = new float[3];
        ancho0[0] = 100;//350
        ancho0[1] = 35;
        ancho0[2] = 104;
//        ancho0[3] = 90;
//        ancho0[4] = 90;
//        ancho0[5] = 90;
        String p_vta = "Punto de Venta: " + dfs.format(titular.getSucursal())
                + "    Comp. Nro: " + dfn.format(numeroFactura);
        Domicilio dm = titular.getDomicilio();
        String d_comer = dm.getCalle() + " " + dm.getNumero();
        String d_come1 = dm.getCodigoPostal() + " " + dm.getLocalidad();
        numCpte.setWidths(ancho0);
        PdfPCell numCpte1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell numCpte2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell numCpte3 = new PdfPCell(new Paragraph(p_vta, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell numCpte4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
        PdfPCell numCpte5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
        PdfPCell numCpte6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
        PdfPCell numCpte7 = new PdfPCell(new Paragraph("Razón Social: " + titular.getPersona().getApellidoNombre(), FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell numCpte8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell numCpte9 = new PdfPCell(new Paragraph("Fecha Emisión: " + fex, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell numCpte10 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
        PdfPCell numCpte11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
        PdfPCell numCpte12 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 7, Font.PLAIN, NEGRO)));
        PdfPCell numCpte13 = new PdfPCell(new Paragraph("Domicilio Comercial: " + d_comer, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell numCpte14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell numCpte15 = new PdfPCell(new Paragraph("C.U.I.T.: " + titular.getCuit(), FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell numCpte16 = new PdfPCell(new Paragraph(d_come1, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell numCpte17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell numCpte18 = new PdfPCell(new Paragraph("Ingresos Brutos: " + titular.getIibb(), FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell numCpte19 = new PdfPCell(new Paragraph("Condición Frente al IVA:  Responsable Monotributo", FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell numCpte20 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell numCpte21 = new PdfPCell(new Paragraph("Fecha Inicio Actividades " + sdf.format(titular.getFechaInicioActividades()), FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));

        numCpte1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        numCpte2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        numCpte7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte8.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte11.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte14.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte19.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte20.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        numCpte21.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        numCpte.addCell(numCpte1).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte2).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte3).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte4).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte5).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte6).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte7).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte8).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte9).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte10).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte11).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte12).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte13).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte14).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte15).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte16).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte17).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte18).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte19).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte20).setBorder(PdfPCell.NO_BORDER);
        numCpte.addCell(numCpte21).setBorder(PdfPCell.NO_BORDER);

        pdf.add(numCpte);

        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 3, PLAIN, FONDO_BLANCO)));

        PdfPTable fechas = new PdfPTable(6);
        fechas.setWidthPercentage(95);
        float[] fech = new float[6];
        fech[0] = 30;
        fech[1] = 10;
        fech[2] = 10;
        fech[3] = 10;
        fech[4] = 30;
        fech[5] = 10;

        fechas.setWidths(fech);

        PdfPCell fe1 = new PdfPCell(new Paragraph("FECHA PERIODO DESDE:", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell fe2 = new PdfPCell(new Paragraph(sdf.format(nuevoCae.getFechaPeriodoDesde()), FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell fe3 = new PdfPCell(new Paragraph("HASTA:", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell fe4 = new PdfPCell(new Paragraph(sdf.format(nuevoCae.getFechaPeriodoHasta()), FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell fe5 = new PdfPCell(new Paragraph("FECHA VENCIMIENTO PAGO:", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell fe6 = new PdfPCell(new Paragraph(sdf.format(nuevoCae.getFechaVencimientoPago()), FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));

        fe1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        fe2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        fe3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        fe4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        fe5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        fe6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        fechas.addCell(fe1).setBorder(PdfPCell.NO_BORDER);
        fechas.addCell(fe2).setBorder(PdfPCell.NO_BORDER);
        fechas.addCell(fe3).setBorder(PdfPCell.NO_BORDER);
        fechas.addCell(fe4).setBorder(PdfPCell.NO_BORDER);
        fechas.addCell(fe5).setBorder(PdfPCell.NO_BORDER);
        fechas.addCell(fe6).setBorder(PdfPCell.NO_BORDER);

        pdf.add(fechas);

        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        PdfPTable encabezado = new PdfPTable(2);
        encabezado.setWidthPercentage(100);
        float[] ancho1 = new float[2];
        ancho1[0] = 85;
        ancho1[1] = 155;

        encabezado.setWidths(ancho1);
        Domicilio dm_c = consorcio.getDomicilio();
        String r_s = consorcio.getNombre() + " "
                + dm_c.getCalle() + " "
                + dm_c.getNumero();

        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("C.U.I.T:   " + consorcio.getCuit(), FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph("Apellido y Nombre / Razón Social:  " + r_s, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);

        PdfPTable cliente = new PdfPTable(2);
        cliente.setWidthPercentage(100);
        float[] ancho2 = new float[2];
        ancho2[0] = 125;
        ancho2[1] = 115;

        cliente.setWidths(ancho2);
        String direc0 = dm_c.getCalle() + " "
                + dm_c.getNumero();
        String direc1 = dm.getCodigoPostal() + " "
                + dm_c.getLocalidad();
        int cond_0 = consorcio.getTipoInscripcion();
//        TipoResponsable[] t_responsable = TipoResponsable.values();
        String condi = "";
        for (TipoResponsable tr : TipoResponsable.values()) {
            int co = tr.getCodigo();
            if (co == cond_0) {
                condi = tr.getDescripcion();
            }
        }

        PdfPCell cliente1 = new PdfPCell(new Paragraph("Condición Frente al IVA:   " + condi, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell cliente2 = new PdfPCell(new Paragraph("Domicilio:  " + direc0, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell cliente3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, Font.PLAIN, NEGRO)));
        PdfPCell cliente4 = new PdfPCell(new Paragraph(direc1, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell cliente5 = new PdfPCell(new Paragraph("Condición de Venta:  Contado", FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell cliente6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));

        cliente1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        cliente2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        cliente3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        cliente4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        cliente5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        cliente6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        cliente.addCell(cliente1).setBorder(PdfPCell.NO_BORDER);
        cliente.addCell(cliente2).setBorder(PdfPCell.NO_BORDER);
        cliente.addCell(cliente3).setBorder(PdfPCell.NO_BORDER);
        cliente.addCell(cliente4).setBorder(PdfPCell.NO_BORDER);
        cliente.addCell(cliente5).setBorder(PdfPCell.NO_BORDER);
        cliente.addCell(cliente6).setBorder(PdfPCell.NO_BORDER);

        pdf.add(cliente);

        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));

        Integer col = 2;

        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[2];
        anchos[0] = 360;
        anchos[1] = 90;

        PdfPTable tablaDetalle = new PdfPTable(2);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        int rows = tabla.getRowCount();
        int coun = 0;
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                PdfPTable tablaProd = new PdfPTable(2);
                tablaProd.setWidthPercentage(100);
                tablaProd.setWidths(anchos);
                PdfPCell tablaProd1 = new PdfPCell(new Paragraph(tabla.getValueAt(i, 0).toString(), FontFactory.getFont("arial", 12, Font.PLAIN, NEGRO)));
                PdfPCell tablaProd2;
                if (!tabla.getValueAt(i, 1).toString().isEmpty()) {
                    Double importeTotal = Double.valueOf(tabla.getValueAt(i, 1).toString().replace(",", "."));
                    String strImporteTotal = df.format(importeTotal);
                    tablaProd2 = new PdfPCell(new Paragraph(strImporteTotal, FontFactory.getFont("arial", 11, Font.PLAIN, NEGRO)));
                } else {
                    tablaProd2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, Font.PLAIN, NEGRO)));
                }
                tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
                tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
                pdf.add(tablaProd);
                coun += 1;
            }
        }

        for (int i = 1; i < 23 - coun; i++) {
            PdfPTable tablaProd = new PdfPTable(2);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            PdfPCell tP1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
        }

        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));

        Date fechaCae = nuevoCae.getFechaVencimiento();
        Long cae = nuevoCae.getCae();

        String totFc = dfT.format(importe);
        String totOtro = dfT.format(0);
        String totFact = dfT.format(importe);
        String f_venc_cae = sdf.format(fechaCae);
        String cae_nro = dfc.format(cae);

        String vto = sdf2.format(new Date());
        String cuit1;
        String tpd = "80";
        String cui = titular.getCuit();
        if (tpd.equals("96")) {
            cuit1 = cui.trim();
            tpd = "96";
        } else {
            cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
        }
        int x = 0;
        if (tpd.equals("96")) {
            String s = "0000000000" + cuit1;
            int lar = s.length();
            cuit1 = s.substring(lar - 11, lar);
        }

        Integer suma1 = 0;
        Integer suma2 = 0;
        String sucu = dfs.format(1);
        String cae2 = cae.toString();
        int largo = cae2.length();
        String txtCadenaRP = "";
        if (largo > 8) {
            String cadena = cuit1 + "0" + tpd + sucu + cae2 + vto;
            for (int i = 0; i < 39; i++) {
                if (x == 0) {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma1 += num;
                    x = 1;
                } else {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma2 += num;
                    x = 0;
                }
            }
            suma1 = suma1 * 3;
            int total = suma1 + suma2;
            int dv = (int) (rint(total / 10 + .9) * 10);
            dv = dv - total;
            cadena += String.valueOf(dv);

            for (int i = 0; i < 40; i = i + 2) {
                String charNum = cadena.substring(i, i + 2);
                int numChar = Integer.valueOf(charNum);
                if (numChar < 50) {
                    numChar += 48;
                } else {
                    numChar += 142;
                }
                char c = (char) numChar;
                txtCadenaRP = txtCadenaRP + c;
            }
        }
        txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;

        PdfPTable pieFc = new PdfPTable(3);
        pieFc.setWidthPercentage(90);

        float[] anchosP = new float[3];
        anchosP[0] = 80;
        anchosP[1] = 90;
        anchosP[2] = 45;
        pieFc.setWidths(anchosP);

        PdfPCell pieFc1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph("Subtotal:  $", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(totFc, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));

        PdfPCell pieFc4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        PdfPCell pieFc7 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc8 = new PdfPCell(new Paragraph("Importe Otros Tributos:  $", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell pieFc9 = new PdfPCell(new Paragraph(totOtro, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));

        PdfPCell pieFc10 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc12 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        PdfPCell pieFc13 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc14 = new PdfPCell(new Paragraph("Importe Total:  $", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell pieFc15 = new PdfPCell(new Paragraph(totFact, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));

        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieFc6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieFc7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc8.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieFc9.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieFc10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc11.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieFc12.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieFc13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc14.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieFc15.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc6).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc7).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc8).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc9).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc10).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc11).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc12).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc13).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc14).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc15).setBorder(PdfPCell.NO_BORDER);

        pdf.add(pieFc);

        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        PdfPTable pieCaeFc = new PdfPTable(3);
        pieCaeFc.setWidthPercentage(100);

        float[] anchosC = new float[3];
        anchosC[0] = 75;
        anchosC[1] = 100;
        anchosC[2] = 40;
        pieCaeFc.setWidths(anchosC);

        PdfPCell pieCaeFc1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, Font.PLAIN, NEGRO)));
        PdfPCell pieCaeFc2 = new PdfPCell(new Paragraph("CAE N°:", FontFactory.getFont("arial", 11, Font.PLAIN, NEGRO)));
        PdfPCell pieCaeFc3 = new PdfPCell(new Paragraph(cae_nro, FontFactory.getFont("arial", 11, Font.PLAIN, NEGRO)));
        PdfPCell pieCaeFc4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 6, Font.PLAIN, NEGRO)));
        PdfPCell pieCaeFc5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 6, Font.PLAIN, NEGRO)));
        PdfPCell pieCaeFc6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 6, Font.PLAIN, NEGRO)));
        PdfPCell pieCaeFc7 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, Font.PLAIN, NEGRO)));
        PdfPCell pieCaeFc8 = new PdfPCell(new Paragraph("Fecha Vencimiento CAE:", FontFactory.getFont("arial", 11, Font.PLAIN, NEGRO)));
        PdfPCell pieCaeFc9 = new PdfPCell(new Paragraph(f_venc_cae, FontFactory.getFont("arial", 11, Font.PLAIN, NEGRO)));

        pieCaeFc1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieCaeFc2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieCaeFc3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieCaeFc4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieCaeFc5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieCaeFc6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieCaeFc7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieCaeFc8.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieCaeFc9.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        pieCaeFc.addCell(pieCaeFc1).setBorder(PdfPCell.NO_BORDER);
        pieCaeFc.addCell(pieCaeFc2).setBorder(PdfPCell.NO_BORDER);
        pieCaeFc.addCell(pieCaeFc3).setBorder(PdfPCell.NO_BORDER);
        pieCaeFc.addCell(pieCaeFc4).setBorder(PdfPCell.NO_BORDER);
        pieCaeFc.addCell(pieCaeFc5).setBorder(PdfPCell.NO_BORDER);
        pieCaeFc.addCell(pieCaeFc6).setBorder(PdfPCell.NO_BORDER);
        pieCaeFc.addCell(pieCaeFc7).setBorder(PdfPCell.NO_BORDER);
        pieCaeFc.addCell(pieCaeFc8).setBorder(PdfPCell.NO_BORDER);
        pieCaeFc.addCell(pieCaeFc9).setBorder(PdfPCell.NO_BORDER);

        pdf.add(pieCaeFc);

        com.itextpdf.text.Font font = FontFactory.getFont("C:/SYSTEM/fonts/PF_I2OF5_TXT.ttf",
                BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
        BaseFont baseFont = font.getBaseFont();
        com.itextpdf.text.Font nf = new com.itextpdf.text.Font(baseFont, 15);
//        PdfPCell pieFc6 = new PdfPCell(new Paragraph(txtCadenaRP, nf));

        Image imagen = Image.getInstance("c:/SYSTEM/qr/codigoQR00000000" + ".png");
//        Image img2 = Image.getInstance("c:/SYSTEM/qr/afip.png");
        Image img3 = Image.getInstance("c:/SYSTEM/png/fc02.jpg");
        imagen.setAbsolutePosition(1f, 1f);
        img3.setAbsolutePosition(2f, 50f);
//        imagen.setAbsolutePosition(1f, 0f);

//        pdf.add(img2);
        pdf.add(img3);
        pdf.add(imagen);

//pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.close();
        return new File(archPdf);
//        String nr0 = dfn.format(iv.getNumero());
//        String fileNameFormatted = getFileNameFormatted(iv);
//        Document pdf = new Document();
//        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
//        pdf.setPageSize(hojaA4);
//        pdf.setMargins(10, 50, 30, 30);
//        pdf.setMarginMirroringTopBottom(true);
//        String archPdf = "c:/alfa_sistema/data/facturas/fc_C_"
//                + titular.getCuit()
////                + "_" + puntoVenta_qr
////                + "_" + numeroComprobante_qr
//                + ".pdf";
//        FileOutputStream ficheroPdf = new FileOutputStream(archPdf); // + fileNameFormatted + ".pdf");
//
//        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
//        writer.setInitialLeading(20);
//
//        // ABRO EL DOCUMENTO
//        pdf.open();
//
//        // INICIO ENCABEZADO FACTURA
////        String fex = sdf.format(iv.getFecha());
//        String fex = sdf.format(new Date());
//
//        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
//        
//        PdfPTable numCpte = new PdfPTable(3);
//        numCpte.setWidthPercentage(100);
//        float[] ancho0 = new float[3];
//        ancho0[0] = 435;
//        ancho0[1] = 140;
//        ancho0[2] = 120;
////        ancho0[3] = 90;
////        ancho0[4] = 90;
////        ancho0[5] = 90;
//        numCpte.setWidths(ancho0);
//        PdfPCell numCpte1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
//        PdfPCell numCpte2 = new PdfPCell(new Paragraph(dfs.format(titular.getSucursal()), FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
//        PdfPCell numCpte3 = new PdfPCell(new Paragraph(dfn.format(numeroFactura), FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
//        numCpte1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//        numCpte2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//        numCpte3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//        numCpte.addCell(numCpte1).setBorder(PdfPCell.NO_BORDER);
//        numCpte.addCell(numCpte2).setBorder(PdfPCell.NO_BORDER);
//        numCpte.addCell(numCpte3).setBorder(PdfPCell.NO_BORDER);
//        pdf.add(numCpte);
//        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
//        
//        PdfPTable encabezado = new PdfPTable(3);
//        encabezado.setWidthPercentage(100);
//
//        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph(titular.getPersona().getApellidoNombre(), FontFactory.getFont("arial", 14, Font.BOLD, NEGRO)));
//        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("Dirección: ", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
//        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph("Fecha: " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
//        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("San Martin", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
//        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph("C.U.I.T.: ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("BUENOS AIRES", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
//        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph("C.M.: ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
////        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
////        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph("Inicio Actividad: ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//
//        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
////        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
////        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
////        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
////        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
////        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
////        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//
//        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
////        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.BOX);
////        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
////        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
////        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
////        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
////        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);
//
//        pdf.add(encabezado);
//        // FIN ENCABEZADO
//
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

//        String nombre = iv.getCliente().getRazonSocial();
//        String direcc = iv.getCliente().getDireccion().getCalle();
//        if (iv.getCliente().getDireccion().getNumero() != null) {
//            direcc += " " + iv.getCliente().getDireccion().getNumero();
//        }
//        if (iv.getCliente().getDireccion().getLocalidad() != null) {
//            direcc += " - " + iv.getCliente().getDireccion().getLocalidad();
//        }
//        if (iv.getCliente().getDireccion().getProvincia() != null) {
//            direcc += " - " + iv.getCliente().getDireccion().getProvincia();
//        }
//        String cod_cli = iv.getCliente().getCodigo().toString();
//        String cui2 = iv.getCliente().getCuit();
//        String cat_iva;
//        if (iv.getCliente().getCategoriaAfip().equals(1)) {
//            cat_iva = "Responsable Inscripto";
//        } else {
//            if (iv.getCliente().getCategoriaAfip().equals(2)) {
//                cat_iva = "Responsable Monotributo";
//            } else {
//                if (iv.getCliente().getCategoriaAfip().equals(3)) {
//                    cat_iva = "Responsable Exento";
//                } else {
//                    cat_iva = "Consumidor Final";
//                }
//            }
//        }
//        PdfPTable client = new PdfPTable(2);
//        client.setWidthPercentage(100);
//        //PdfPCell celdaClient1 = new PdfPCell(new Paragraph("Razón Social: " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("Razón Social: ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        //PdfPCell celdaClient2 = new PdfPCell(new Paragraph("Cliente nro.: " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell celdaClient2 = new PdfPCell(new Paragraph("Cliente nro.: ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        //PdfPCell celdaClient3 = new PdfPCell(new Paragraph("Dirección: " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("Dirección: ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        //PdfPCell celdaClient4 = new PdfPCell(new Paragraph("Inscripción nro.: " + cat_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell celdaClient4 = new PdfPCell(new Paragraph("Inscripción nro.: ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        //PdfPCell celdaClient5 = new PdfPCell(new Paragraph("C.U.I.T. nro.: " + cui2, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell celdaClient5 = new PdfPCell(new Paragraph("C.U.I.T. nro.: ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell celdaClient6 = new PdfPCell(new Paragraph("Condición Venta: CONTADO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//
//        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//
//        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
//        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
//        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
//        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
//        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
//        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
//        pdf.add(client);
//
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
//
//        Integer col = 5;
//        if(iv.getCliente().getCategoriaDeIva().equals(1)){
//            col = 7;
//        }
//        PdfPTable detalle = new PdfPTable(col);
//        detalle.setWidthPercentage(100);
//
//        float[] anchos = new float[2];
//        anchos[0] = 360;
//        anchos[1] = 90;
////        anchos[2] = 360;
////        anchos[3] = 90;
////        anchos[4] = 90;
//        //anchos[5] = 90;
//
//        PdfPTable tablaDetalle = new PdfPTable(2);
//        tablaDetalle.setWidthPercentage(100);
//        tablaDetalle.setWidths(anchos);
//
//        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
////        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
////        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
////        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        //PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("SUGERIDO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//
//        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
////        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
////        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
////        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//        //celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//
//        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
//        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
////        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
////        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
////        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
//        //tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
//        pdf.add(tablaDetalle);
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));
//
//        int rows = tabla.getRowCount();
//        int coun = 0;
//        for (int i = 0; i < rows; i++) {
//            PdfPTable tablaProd = new PdfPTable(2);
//            tablaProd.setWidthPercentage(100);
//            tablaProd.setWidths(anchos);
////            coun += 1;
////            String c_nt = String.valueOf(coun);
//            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(tabla.getValueAt(i, 0).toString(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(tabla.getValueAt(i, 1).toString(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
//            pdf.add(tablaProd);
//            coun += 1;
//        }
//            PdfPTable tablaProd = new PdfPTable(2);
//            tablaProd.setWidthPercentage(100);
//            tablaProd.setWidths(anchos);
//            coun += 1;
//            String c_nt = String.valueOf(coun);
//            //String c_ntd = String.valueOf(re.getCantidad());
//            String prec;
//            if (re.getImporte() > 1) {
//                prec = df.format(re.getImporte());
//            } else {
//                prec = " ";
//            }
//// re.getCantidad());
//            //String tota = df.format(re.getTotal());
//            //String suge = df.format(re.getSugerido());
//            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(" " + re.getTexto(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            //PdfPCell tablaProd6 = new PdfPCell(new Paragraph(suge, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//
//            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            //tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//
//            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
//            //tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);
//
//            pdf.add(tablaProd);
////            
//        }
//        for (int i = 1; i < 41 - coun; i++) {
//            PdfPTable tablaProd = new PdfPTable(2);
//            tablaProd.setWidthPercentage(100);
//            tablaProd.setWidths(anchos);
////            String nro_lin = String.valueOf(i + coun);
//            PdfPCell tP1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
////            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
////            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
////            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            //PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
////            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
////            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
////            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            //tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
////            tablaProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
////            tablaProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
////            tablaProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
//            //tablaProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
//            pdf.add(tablaProd);
////            
////            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
//        }
//
//        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
//
//        PdfPTable pieFc = new PdfPTable(2);
//        pieFc.setWidthPercentage(100);
//
//        String totFc = df.format(importe);
//        String impu = "";
//        String f_venc_cae = sdf.format(fecha);
//        String cae_nro = dfc.format(cae);
////        if (iv.getImpuesto() > 0.00) {
////            impu = "Total Impuesto: " + df.format(iv.getImpuesto());
////        }
//
////        String tpd = iv.getCliente().getTipoDoc().toString();
//        String vto = sdf2.format(new Date());
//        String cuit1;
//        String tpd = "80";
//        String cui = titular.getCuit();
//        if (tpd.equals("96")) {
//            cuit1 = cui.trim();
//            tpd = "96";
//        } else {
//            cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
//        }
//        int x = 0;
//        if (tpd.equals("96")) {
//            String s = "0000000000" + cuit1;
//            int lar = s.length();
//            cuit1 = s.substring(lar - 11, lar);
//        }
//
//        Integer suma1 = 0;
//        Integer suma2 = 0;
//        String sucu = dfs.format(1);
//        String cae2 = cae.toString();
//        int largo = cae2.length();
//        String txtCadenaRP = "";
//        if (largo > 8) {
//            String cadena = cuit1 + "0" + tpd + sucu + cae2 + vto;
//            for (int i = 0; i < 39; i++) {
//                if (x == 0) {
//                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
//                    suma1 += num;
//                    x = 1;
//                } else {
//                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
//                    suma2 += num;
//                    x = 0;
//                }
//            }
//            suma1 = suma1 * 3;
//            int total = suma1 + suma2;
//            int dv = (int) (rint(total / 10 + .9) * 10);
//            dv = dv - total;
//            cadena += String.valueOf(dv);
//
//            for (int i = 0; i < 40; i = i + 2) {
//                String charNum = cadena.substring(i, i + 2);
//                int numChar = Integer.valueOf(charNum);
//                if (numChar < 50) {
//                    numChar += 48;
//                } else {
//                    numChar += 142;
//                }
//                char c = (char) numChar;
//                txtCadenaRP = txtCadenaRP + c;
//            }
//        }
//        txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;
//
//        PdfPCell pieFc1 = new PdfPCell(new Paragraph(impu, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell pieFc2 = new PdfPCell(new Paragraph("Total Factura:  " + totFc, FontFactory.getFont("arial", 10, Font.BOLD, NEGRO)));
//        PdfPCell pieFc3 = new PdfPCell(new Paragraph("Fecha Vencimiento CAE:  " + f_venc_cae, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell pieFc4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell pieFc5 = new PdfPCell(new Paragraph("CAE nro.:  " + cae_nro, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//
//        com.itextpdf.text.Font font = FontFactory.getFont("C:/alfa_sistema/fonts/PF_I2OF5_TXT.ttf",
//                BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
//        BaseFont baseFont = font.getBaseFont();
//        com.itextpdf.text.Font nf = new com.itextpdf.text.Font(baseFont, 15);
//        PdfPCell pieFc6 = new PdfPCell(new Paragraph(txtCadenaRP, nf));
//
//        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//
//        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
//        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
//        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
//        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
//        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
//        pieFc.addCell(pieFc6).setBorder(PdfPCell.NO_BORDER);
//        pdf.add(pieFc);
//        Image imagen = Image.getInstance("c:/SYSTEM/qr/CodigoQR" + dfn.format(numeroFactura) + ".png");
//        Image img2 = Image.getInstance("c:/SYSTEM/qr/afip.png");
//        Image img3 = Image.getInstance("c:/alfa_sistema/img/fc02.jpg");
////        imagen.setAbsolutePosition(10f, 50f);
//        img3.setAbsolutePosition(0f, 20f);
////        imagen.setAbsolutePosition(1f, 0f);
////        pdf.add(imagen);
////        pdf.add(img2);
//        pdf.add(img3);
//
////pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
//        pdf.close();
//        return new File(archPdf);
    }

    public void armarFactura(Comprobante comprobante) throws FileNotFoundException, DocumentException, Exception {
        Document pdf = new Document();
        String cuitTitu = comprobante.getCuitTitular();
        TitularCuit titular = null;
        titular = new TitularCuitService().getTitularActivoByCuit(cuitTitu);
        String logo;
        try {
            logo = titular.getLogo();
        } catch (Exception ex) {
            System.out.println(comprobante.getId());
            System.out.println(comprobante.getNumero());
            System.out.println(comprobante.getCodigoComprobante());
            System.out.println(comprobante.getCalleNroPisoDtoCliente());
            JOptionPane.showMessageDialog(null, "TITULAR SIN LOGO DEFINIDO");
            return;
        }

        if (logo == null) {
            JOptionPane.showMessageDialog(null, "TITULAR SIN LOGO DEFINIDO_null");
            return;
        }
        if (logo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "TITULAR SIN LOGO DEFINIDO_empty");
            return;
        }
        Consorcio consorcio = null;
        consorcio = new ConsorcioService().getConsorcioByCodigo(comprobante.getCodigoCliente());
        Administrador administrador = consorcio.getAdministrador();
        Rubro rubro = comprobante.getRubro();
//        System.out.println(logo);
//        System.exit(0);
//        Configuracion confi = new ConfiguracionService().getConfiguracion(1L);
//        int orden = comprobante.getNumero();
//        confi.setNroFc(orden);
//        new ConfiguracionService().updateConfiguracion(confi);
        Rectangle hojaA4 = new Rectangle((float) 695, (float) 935);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(15, 40, 19, 5);//30 izq aba arri der
        pdf.setMarginMirroringTopBottom(true);

        String adm = administrador.getNombreAdministrador();
        Domicilio dm = consorcio.getDomicilio();
        String calle = dm.getCalle() + " " + dm.getNumero();
        String rubrx = rubro.getDetalle();
        String cuotx = comprobante.getCuotasPagadas().toString();
        String numF = comprobante.getNumero().toString();
        adm = UtilFrame.getNombreSinEspacios(adm);
        calle = UtilFrame.getNombreSinEspacios(calle);
        rubrx = UtilFrame.getNombreSinEspacios(rubrx);

        File carpeta = new File("c:/alfa_sistema/data/facturas/" + adm);
        if (!carpeta.exists()) {
//            if(carpeta.mkdirs()){
            carpeta.mkdirs();
//                JOptionPane.showMessageDialog(null, "ERROR");
            ////                System.exit(0);
            //            }
        }

        String fileName = getFileNameFc(calle
                + "_" + rubrx + "_cuota_" + cuotx + "_Fc_" + numF);

        System.out.println(fileName);
//        System.exit(0);

        FileOutputStream ficheroPdf = new FileOutputStream("c:/alfa_sistema/data/facturas/" + adm + "/" + fileName + ".pdf"); // + fileNameFormatted + ".pdf");

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();

        // INICIO ENCABEZADO FACTURA
//        String fex = sdf.format(iv.getFecha());
        String fex = sdf.format(comprobante.getFecha());
        String nroS = dfs.format(comprobante.getSucursal());
        String nroN = dfn.format(comprobante.getNumero());
        String rsT = comprobante.getRazonSocialTitular();
        String dmT = comprobante.getDomicilioTitular();
        String cuiT = comprobante.getCuitTitular();
        String cpT = comprobante.getCodigoPostalAndLocalidadTitular();
//        String provT = comprobante.getProvinciaTitular();
        String iibbT = comprobante.getIibb();
        String fiA = sdf.format(comprobante.getFechaInicioActividades());
        PdfPTable encabezado = new PdfPTable(3);
        float[] anchos = new float[3];
        anchos[0] = 52;
        anchos[1] = 8;
        anchos[2] = 40;
        encabezado.setWidthPercentage(100);
        encabezado.setWidths(anchos);

        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("Punto de Venta: " + nroS + " Comp.Nro: " + nroN, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph("Fecha de Emisión: " + fex, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("Razón Social: " + rsT, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("Domicilio Comercial: " + dmT, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph("CUIT: " + cuiT, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph(" " + cpT, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph("Ingresos Brutos: " + iibbT, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph("Fecha Inicio de Actividades: " + fiA, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);//BOX
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);
        for (int i = 0; i < 3; i++) {
            pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        }
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));
        pdf.add(encabezado);

        String cuiC = comprobante.getCuitCliente();
//        String tipoInscripcionCliente = comprobante.getTipoInscripcion();
        String rsC = comprobante.getRazonSocialCliente();
        String doC = comprobante.getCalleNroPisoDtoCliente();
        String cpC = comprobante.getCodigoPostalAndLocalidadCliente();

        String cat = "";
        if (comprobante.getTipoInscripcion().equals("5")) {
            cat = "CONSUMIDOR FINAL";
        }

        PdfPTable cabeceraConsorcio = new PdfPTable(4);
        float[] ancho1 = new float[4];
        ancho1[0] = 17;
        ancho1[1] = 38;
        ancho1[2] = 13;
        ancho1[3] = 37;
        cabeceraConsorcio.setWidthPercentage(100);
        cabeceraConsorcio.setWidths(ancho1);

        PdfPCell celdaConsorcio1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 14, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio2 = new PdfPCell(new Paragraph(cuiC, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 14, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio4 = new PdfPCell(new Paragraph(rsC, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 14, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio6 = new PdfPCell(new Paragraph(cat, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio7 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 14, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio8 = new PdfPCell(new Paragraph(doC, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio9 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 14, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio10 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 14, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio12 = new PdfPCell(new Paragraph(cpC, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        celdaConsorcio1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaConsorcio6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaConsorcio7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio8.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio11.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        cabeceraConsorcio.addCell(celdaConsorcio1).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio2).setBorder(PdfPCell.NO_BORDER);//BOX
        cabeceraConsorcio.addCell(celdaConsorcio3).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio4).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio5).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio6).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio7).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio8).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio9).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio10).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio11).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio12).setBorder(PdfPCell.NO_BORDER);

        PdfPTable fechas = new PdfPTable(6);
        float[] ancho3 = new float[6];
        ancho3[0] = 24;
        ancho3[1] = 17;
        ancho3[2] = 13;
        ancho3[3] = 12;
        ancho3[4] = 26;
        ancho3[5] = 11;
        fechas.setWidthPercentage(100);
        fechas.setWidths(ancho3);

        PdfPCell tablaFecha1 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", 12, Font.PLAIN, NEGRO)));
        PdfPCell tablaFecha2 = new PdfPCell(new Paragraph(sdf.format(comprobante.getFechaPeriodoDesde()), FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell tablaFecha3 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", 12, Font.PLAIN, NEGRO)));
        PdfPCell tablaFecha4 = new PdfPCell(new Paragraph(sdf.format(comprobante.getFechaPeriodoHasta()), FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell tablaFecha5 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", 12, Font.PLAIN, NEGRO)));
        PdfPCell tablaFecha6 = new PdfPCell(new Paragraph(sdf.format(comprobante.getFechaVencimientoPago()), FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        tablaFecha1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tablaFecha2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tablaFecha3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tablaFecha4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tablaFecha5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tablaFecha6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        fechas.addCell(tablaFecha1).setBorder(PdfPCell.NO_BORDER);
        fechas.addCell(tablaFecha2).setBorder(PdfPCell.NO_BORDER);
        fechas.addCell(tablaFecha3).setBorder(PdfPCell.NO_BORDER);
        fechas.addCell(tablaFecha4).setBorder(PdfPCell.NO_BORDER);
        fechas.addCell(tablaFecha5).setBorder(PdfPCell.NO_BORDER);
        fechas.addCell(tablaFecha6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(fechas);
//        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 10, PLAIN, FONDO_BLANCO)));
        for (int i = 0; i < 3; i++) {
            pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 7, PLAIN, FONDO_BLANCO)));
        }
        pdf.add(cabeceraConsorcio);

        for (int i = 0; i < 5; i++) {
            pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        }

        Integer col = 2;

        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos2 = new float[col];
        anchos2[0] = 75;
        anchos2[1] = 25;

        List<ComprobanteRenglones> renglones = null;
        renglones = new ComprobanteRenglonesService().getRenglonesPorComprobante(comprobante);

        int coun = 0;
        for (ComprobanteRenglones re : renglones) {
            PdfPTable tablaProd = new PdfPTable(2);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos2);
            coun += 1;

            String prec;
            if (re.getImporte() > 1) {
                prec = df.format(re.getImporte());
            } else {
                prec = " ";
            }
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(re.getDetalle(), FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
        }
//        System.out.println(comprobante.getRubro());
//        System.out.println(comprobante.getCuotasPagadas());
//        99
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 11, PLAIN, FONDO_BLANCO)));
        Rubro rr = comprobante.getRubro();
//        System.out.println(rr.getEsAbono());
//        System.exit(0);
        if (!rr.getEsAbono()) {
            if (!comprobante.getCantidadCuotas().equals(1)) {
                pdf.add(new Paragraph("CUOTA: " + comprobante.getCuotasPagadas().toString()
                        + " DE " + comprobante.getCantidadCuotas().toString(),
                        FontFactory.getFont("arial", 11, BOLD, NEGRO)));
            } else {
                pdf.add(new Paragraph("",
                        FontFactory.getFont("arial", 11, BOLD, NEGRO)));
            }
        } else {
            if (rr.getCodigo().equals(2) || rr.getCodigo().equals(10)) {
                if (!comprobante.getCantidadCuotas().equals(1)) {
                    pdf.add(new Paragraph("CUOTA: " + comprobante.getCuotasPagadas().toString()
                            + " DE " + comprobante.getCantidadCuotas().toString(),
                            FontFactory.getFont("arial", 11, BOLD, NEGRO)));
                } else {
                    pdf.add(new Paragraph("",
                            FontFactory.getFont("arial", 11, BOLD, NEGRO)));
                }
            } else {
                pdf.add(new Paragraph("CORRESPONDIENTE AL MES DE: " + comprobante.getPeriodo(),
                        FontFactory.getFont("arial", 11, BOLD, NEGRO)));
            }
        }

        for (int i = 1; i < 18 - coun; i++) {
            pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 11, PLAIN, FONDO_BLANCO)));
        }
//        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        PdfPTable pieFc = new PdfPTable(2);
        pieFc.setWidthPercentage(90);
        pieFc.setWidths(anchos2);

        String totFc = df.format(comprobante.getTotal());
        String impu = "";
        String f_venc_cae = sdf.format(comprobante.getFechaVencimientoCae());
        String cae_nro = dfc.format(comprobante.getCae());

        PdfPCell pieFc1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph(totFc, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell pieFc2a = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2b = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.PLAIN, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph("    " + cae_nro, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell pieFc4a = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4b = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, Font.PLAIN, NEGRO)));
        PdfPCell pieFc6 = new PdfPCell(new Paragraph("    " + f_venc_cae, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));

        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2a).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2b).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4a).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4b).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2a).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2b).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4a).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4b).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pieFc);

        if (titular.getLogo() != null || !titular.getLogo().isEmpty()) {
            if (comprobante.getCodigoComprobante().equals(11)) {
                Image imagen = Image.getInstance(logo);
                imagen.setAbsolutePosition(5f, 0f);
                pdf.add(imagen);
            } else {
                logo.replace("fc0", "nc0");
                Image imagen = Image.getInstance(logo);
                imagen.setAbsolutePosition(5f, 0f);
                pdf.add(imagen);
            }
        } else {
            JOptionPane.showMessageDialog(null, "TITULAR SIN IMAGEN DE LOGO");
//            return;
        }
        Image img = Image.getInstance("c:/alfa_sistema/qr/codigoQR" + nroN + ".png");

        img.setAbsolutePosition(20f, 140f);

        pdf.add(img);

        pdf.close();

        comprobante.setPdfGenerado(true);
        new ComprobanteService().updateComprobante(comprobante);
//        return; // new File("c:/emitank/fc_pdf/" + fileName + ".pdf");
    }

    public void armarReciboX(Comprobante comprobante) throws FileNotFoundException, DocumentException, Exception {
        Document pdf = new Document();
        String cuitTitu = comprobante.getCuitTitular();
        TitularCuit titular = null;
        titular = new TitularCuitService().getTitularActivoByCuit(cuitTitu);
        FondoRecibo fr = comprobante.getFondo();
        String logo;
        try {
            logo = fr.getUbicacion();
        } catch (Exception ex) {
            System.out.println(comprobante.getId());
            System.out.println(comprobante.getNumero());
            System.out.println(comprobante.getCodigoComprobante());
            System.out.println(comprobante.getCalleNroPisoDtoCliente());
            JOptionPane.showMessageDialog(null, "TITULAR SIN LOGO DEFINIDO");
            return;
        }

        if (logo == null) {
            JOptionPane.showMessageDialog(null, "TITULAR SIN LOGO DEFINIDO_null");
            return;
        }
        if (logo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "TITULAR SIN LOGO DEFINIDO_empty");
            return;
        }
        Consorcio consorcio = null;
        consorcio = new ConsorcioService().getConsorcioByCodigo(comprobante.getCodigoCliente());
        Administrador administrador = consorcio.getAdministrador();
        Rubro rubro = comprobante.getRubro();
//        System.out.println(logo);
//        System.exit(0);
//        Configuracion confi = new ConfiguracionService().getConfiguracion(1L);
//        int orden = comprobante.getNumero();
//        confi.setNroFc(orden);
//        new ConfiguracionService().updateConfiguracion(confi);
        Rectangle hojaA4 = new Rectangle((float) 695, (float) 935);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(15, 40, 19, 5);//30 izq aba arri der
        pdf.setMarginMirroringTopBottom(true);

        String adm = administrador.getNombreAdministrador();
        Domicilio dm = consorcio.getDomicilio();
        String calle = dm.getCalle() + " " + dm.getNumero();
        String rubrx = rubro.getDetalle();
        String cuotx = comprobante.getCuotasPagadas().toString();
        String numF = comprobante.getNumero().toString();
        adm = UtilFrame.getNombreSinEspacios(adm);
        calle = UtilFrame.getNombreSinEspacios(calle);
        rubrx = UtilFrame.getNombreSinEspacios(rubrx);

        File carpeta = new File("c:/alfa_sistema/data/facturas/" + adm);
        if (!carpeta.exists()) {
//            if(carpeta.mkdirs()){
            carpeta.mkdirs();
//                JOptionPane.showMessageDialog(null, "ERROR");
            ////                System.exit(0);
            //            }
        }

        String fileName = getFileNameFc(calle
                + "_" + rubrx + "_cuota_" + cuotx + "_Fc_" + numF);

        System.out.println(fileName);
//        System.exit(0);

        FileOutputStream ficheroPdf = new FileOutputStream("c:/alfa_sistema/data/facturas/" + adm + "/" + fileName + ".pdf"); // + fileNameFormatted + ".pdf");

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();

        // INICIO ENCABEZADO FACTURA
//        String fex = sdf.format(iv.getFecha());
        String fex = sdf.format(comprobante.getFecha());
        String nroS = dfs.format(comprobante.getSucursal());
        String nroN = dfn.format(comprobante.getNumero());
//        String rsT = comprobante.getRazonSocialTitular();
        String dmT = comprobante.getDomicilioTitular();
        String cuiT = comprobante.getCuitTitular();
//        String cpT = comprobante.getCodigoPostalAndLocalidadTitular();
//        String provT = comprobante.getProvinciaTitular();
//        String iibbT = comprobante.getIibb();
//        String fiA = sdf.format(comprobante.getFechaInicioActividades());
        PdfPTable encabezado = new PdfPTable(3);
        float[] anchos = new float[3];
        anchos[0] = 52;
        anchos[1] = 8;
        anchos[2] = 40;
        encabezado.setWidthPercentage(100);
        encabezado.setWidths(anchos);

        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("Punto de Venta: " + nroS + " Comp.Nro: " + nroN, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph("Fecha de Emisión: " + fex, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("Domicilio Comercial: " + dmT, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph("CUIT: " + cuiT, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);//BOX
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);
        for (int i = 0; i < 3; i++) {
            pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        }
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));
        pdf.add(encabezado);

        String cuiC = comprobante.getCuitCliente();
//        String tipoInscripcionCliente = comprobante.getTipoInscripcion();
        String rsC = comprobante.getRazonSocialCliente();
        String doC = comprobante.getCalleNroPisoDtoCliente();
        String cpC = comprobante.getCodigoPostalAndLocalidadCliente();

        String cat = "";
        if (comprobante.getTipoInscripcion().equals("5")) {
            cat = "CONSUMIDOR FINAL";
        }

        PdfPTable cabeceraConsorcio = new PdfPTable(4);
        float[] ancho1 = new float[4];
        ancho1[0] = 17;
        ancho1[1] = 38;
        ancho1[2] = 13;
        ancho1[3] = 37;
        cabeceraConsorcio.setWidthPercentage(100);
        cabeceraConsorcio.setWidths(ancho1);

        PdfPCell celdaConsorcio1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 14, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio2 = new PdfPCell(new Paragraph(cuiC, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 14, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio4 = new PdfPCell(new Paragraph(rsC, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 14, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio6 = new PdfPCell(new Paragraph(cat, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio7 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 14, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio8 = new PdfPCell(new Paragraph(doC, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio9 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 14, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio10 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 14, Font.BOLD, NEGRO)));
        PdfPCell celdaConsorcio12 = new PdfPCell(new Paragraph(cpC, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        celdaConsorcio1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaConsorcio6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaConsorcio7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio8.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio11.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaConsorcio12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        cabeceraConsorcio.addCell(celdaConsorcio1).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio2).setBorder(PdfPCell.NO_BORDER);//BOX
        cabeceraConsorcio.addCell(celdaConsorcio3).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio4).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio5).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio6).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio7).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio8).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio9).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio10).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio11).setBorder(PdfPCell.NO_BORDER);
        cabeceraConsorcio.addCell(celdaConsorcio12).setBorder(PdfPCell.NO_BORDER);

        PdfPTable fechas = new PdfPTable(6);
        float[] ancho3 = new float[6];
        ancho3[0] = 24;
        ancho3[1] = 17;
        ancho3[2] = 13;
        ancho3[3] = 12;
        ancho3[4] = 26;
        ancho3[5] = 11;
        fechas.setWidthPercentage(100);
        fechas.setWidths(ancho3);

        PdfPCell tablaFecha1 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", 12, Font.PLAIN, NEGRO)));
        PdfPCell tablaFecha2 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell tablaFecha3 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", 12, Font.PLAIN, NEGRO)));
        PdfPCell tablaFecha4 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell tablaFecha5 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", 12, Font.PLAIN, NEGRO)));
        PdfPCell tablaFecha6 = new PdfPCell(new Paragraph("", FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        tablaFecha1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tablaFecha2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tablaFecha3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tablaFecha4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tablaFecha5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tablaFecha6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        fechas.addCell(tablaFecha1).setBorder(PdfPCell.NO_BORDER);
        fechas.addCell(tablaFecha2).setBorder(PdfPCell.NO_BORDER);
        fechas.addCell(tablaFecha3).setBorder(PdfPCell.NO_BORDER);
        fechas.addCell(tablaFecha4).setBorder(PdfPCell.NO_BORDER);
        fechas.addCell(tablaFecha5).setBorder(PdfPCell.NO_BORDER);
        fechas.addCell(tablaFecha6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(fechas);
//        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 10, PLAIN, FONDO_BLANCO)));
        for (int i = 0; i < 3; i++) {
            pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 7, PLAIN, FONDO_BLANCO)));
        }
        pdf.add(cabeceraConsorcio);

        for (int i = 0; i < 5; i++) {
            pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        }

        Integer col = 2;

        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos2 = new float[col];
        anchos2[0] = 75;
        anchos2[1] = 25;

        List<ComprobanteRenglones> renglones = null;
        renglones = new ComprobanteRenglonesService().getRenglonesPorComprobante(comprobante);

        int coun = 0;
        for (ComprobanteRenglones re : renglones) {
            PdfPTable tablaProd = new PdfPTable(2);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos2);
            coun += 1;

            String prec;
            if (re.getImporte() > 1) {
                prec = df.format(re.getImporte());
            } else {
                prec = " ";
            }
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(re.getDetalle(), FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
        }

        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 11, PLAIN, FONDO_BLANCO)));
        Rubro rr = comprobante.getRubro();
//        System.out.println(comprobante.getRubro());
//        System.out.println(comprobante.getCuotasPagadas());
//        System.out.println(rr.getEsAbono());
//        System.exit(0);
//        99
        if (!rr.getEsAbono()) {
            if (!comprobante.getCantidadCuotas().equals(1)) {
                pdf.add(new Paragraph("CUOTA: " + comprobante.getCuotasPagadas().toString()
                        + " DE " + comprobante.getCantidadCuotas().toString(),
                        FontFactory.getFont("arial", 11, BOLD, NEGRO)));
            } else {
                pdf.add(new Paragraph("",
                        FontFactory.getFont("arial", 11, BOLD, NEGRO)));
            }
        } else {
            if (rr.getCodigo().equals(2) || rr.getCodigo().equals(10)) {
                if (!comprobante.getCantidadCuotas().equals(1)) {
                    pdf.add(new Paragraph("CUOTA: " + comprobante.getCuotasPagadas().toString()
                            + " DE " + comprobante.getCantidadCuotas().toString(),
                            FontFactory.getFont("arial", 11, BOLD, NEGRO)));
                } else {
                    pdf.add(new Paragraph("",
                            FontFactory.getFont("arial", 11, BOLD, NEGRO)));
                }
            } else {
                pdf.add(new Paragraph("CORRESPONDIENTE AL MES DE: " + comprobante.getPeriodo(),
                        FontFactory.getFont("arial", 11, BOLD, NEGRO)));
            }
        }

        for (int i = 1; i < 18 - coun; i++) {
            pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 11, PLAIN, FONDO_BLANCO)));
        }
//        pdf.add(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        PdfPTable pieFc = new PdfPTable(2);
        pieFc.setWidthPercentage(90);
        pieFc.setWidths(anchos2);

        String totFc = df.format(comprobante.getTotal());
        String impu = "";
//        String f_venc_cae = sdf.format(comprobante.getFechaVencimientoCae());
//        String cae_nro = dfc.format(comprobante.getCae());

        PdfPCell pieFc1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph(totFc, FontFactory.getFont("arial", 12, Font.BOLD, NEGRO)));
        PdfPCell pieFc2a = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2b = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 12, Font.PLAIN, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph("    ", FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));
        PdfPCell pieFc4a = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4b = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 11, Font.PLAIN, NEGRO)));
        PdfPCell pieFc6 = new PdfPCell(new Paragraph("    ", FontFactory.getFont("arial", 11, Font.BOLD, NEGRO)));

        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2a).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2b).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4a).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4b).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2a).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2b).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4a).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4b).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pieFc);

        if (titular.getLogo() != null || !titular.getLogo().isEmpty()) {
            Image imagen = Image.getInstance(logo);
            imagen.setAbsolutePosition(5f, 0f);
            pdf.add(imagen);
        } else {
            JOptionPane.showMessageDialog(null, "TITULAR SIN IMAGEN DE LOGO");
//            return;
        }
//        Image img = Image.getInstance("c:/alfa_sistema/qr/codigoQR" + nroN + ".png");

//        img.setAbsolutePosition(20f, 140f);
//
//        pdf.add(img);
        pdf.close();

        comprobante.setPdfGenerado(true);
        new ComprobanteService().updateComprobante(comprobante);
//        return; // new File("c:/emitank/fc_pdf/" + fileName + ".pdf");
    }

    public File armarFacturaC() throws FileNotFoundException, DocumentException, Exception {
        // crear QR
        numeroFactura = 300;
        //Cliente clienteFactura = iv.getCliente();
        Date fecha = new Date();
        String modeloFcPapel = "011";
        String cui = "20-14";
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
        fecha_qr = sdf_qr.format(fecha);
        numeroDoc_qr = pri + med + fin;
        tipoComprobante_qr = modeloFcPapel;
        numeroComprobante_qr = "3520";
        importe_qr = df.format(1200.50);
        tipoDoc_qr = "80";
        nroCae_qr = "66442943128010";
        String data = "{\"ver\":" + ver_qr
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
        try {
            generarQR(data);
        } catch (Exception ex) {
            Logger.getLogger(PDFBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        // fin crear QR
//        String nr0 = dfn.format(iv.getNumero());
//        String fileNameFormatted = getFileNameFormatted(iv);
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 50, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        FileOutputStream ficheroPdf = new FileOutputStream("c:/facturas_sys/fc.pdf"); // + fileNameFormatted + ".pdf");

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();

        // INICIO ENCABEZADO FACTURA
        String cod = "011";;
//        String fex = sdf.format(iv.getFecha());
        String fex = sdf.format(new Date());
        String nro = "C ";
//                + dfs.format(iv.getSucursal()) + "-"
//                + dfn.format(iv.getNumero());
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph(encabezad0, FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph("C", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("FACTURA", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Razón Social: Mario Enrique Gianotti", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("Cod.: " + cod, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph("Número: " + nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("Dirección: 109 Paso 1927", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph("Fecha: " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("CP. 1650 - San Martin", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph("C.U.I.T.: 20-14255320-2", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("BUENOS AIRES", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph("C.M.: 901-067583-0", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph("Inicio Actividad: 01/05/2013", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.BOX);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

//        String nombre = iv.getCliente().getRazonSocial();
//        String direcc = iv.getCliente().getDireccion().getCalle();
//        if (iv.getCliente().getDireccion().getNumero() != null) {
//            direcc += " " + iv.getCliente().getDireccion().getNumero();
//        }
//        if (iv.getCliente().getDireccion().getLocalidad() != null) {
//            direcc += " - " + iv.getCliente().getDireccion().getLocalidad();
//        }
//        if (iv.getCliente().getDireccion().getProvincia() != null) {
//            direcc += " - " + iv.getCliente().getDireccion().getProvincia();
//        }
//        String cod_cli = iv.getCliente().getCodigo().toString();
//        String cui2 = iv.getCliente().getCuit();
//        String cat_iva;
//        if (iv.getCliente().getCategoriaAfip().equals(1)) {
//            cat_iva = "Responsable Inscripto";
//        } else {
//            if (iv.getCliente().getCategoriaAfip().equals(2)) {
//                cat_iva = "Responsable Monotributo";
//            } else {
//                if (iv.getCliente().getCategoriaAfip().equals(3)) {
//                    cat_iva = "Responsable Exento";
//                } else {
//                    cat_iva = "Consumidor Final";
//                }
//            }
//        }
        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        //PdfPCell celdaClient1 = new PdfPCell(new Paragraph("Razón Social: " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("Razón Social: ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        //PdfPCell celdaClient2 = new PdfPCell(new Paragraph("Cliente nro.: " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph("Cliente nro.: ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        //PdfPCell celdaClient3 = new PdfPCell(new Paragraph("Dirección: " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("Dirección: ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        //PdfPCell celdaClient4 = new PdfPCell(new Paragraph("Inscripción nro.: " + cat_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph("Inscripción nro.: ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        //PdfPCell celdaClient5 = new PdfPCell(new Paragraph("C.U.I.T. nro.: " + cui2, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph("C.U.I.T. nro.: ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph("Condición Venta: CONTADO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        Integer col = 5;
//        if(iv.getCliente().getCategoriaDeIva().equals(1)){
//            col = 7;
//        }
        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[5];
        anchos[0] = 30;
        anchos[1] = 20;
        anchos[2] = 360;
        anchos[3] = 90;
        anchos[4] = 90;
        //anchos[5] = 90;

        PdfPTable tablaDetalle = new PdfPTable(5);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        //PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("SUGERIDO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        //celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        //tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        int coun = 0;
//        for (RenglonFactura re : rf) {
//            PdfPTable tablaProd = new PdfPTable(5);
//            tablaProd.setWidthPercentage(100);
//            tablaProd.setWidths(anchos);
//            coun += 1;
//            String c_nt = String.valueOf(coun);
//            //String c_ntd = String.valueOf(re.getCantidad());
//            String prec;
//            if (re.getImporte() > 1) {
//                prec = df.format(re.getImporte());
//            } else {
//                prec = " ";
//            }
//// re.getCantidad());
//            //String tota = df.format(re.getTotal());
//            //String suge = df.format(re.getSugerido());
//            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(" " + re.getTexto(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            //PdfPCell tablaProd6 = new PdfPCell(new Paragraph(suge, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//
//            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            //tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//
//            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
//            //tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);
//
//            pdf.add(tablaProd);
////            
//        }
        for (int i = 1; i < 41 - coun; i++) {
            PdfPTable tablaProd = new PdfPTable(5);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
//            String nro_lin = String.valueOf(i + coun);
            PdfPCell tP1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            //PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            //tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
            //tablaProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
            pdf.add(tablaProd);
//            
//            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        }

        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        PdfPTable pieFc = new PdfPTable(2);
        pieFc.setWidthPercentage(100);

        String totFc = df.format(1500.25);
        String impu = "";
        String f_venc_cae = sdf.format(new Date());
        String cae_nro = dfc.format(1234567890);
//        if (iv.getImpuesto() > 0.00) {
//            impu = "Total Impuesto: " + df.format(iv.getImpuesto());
//        }

//        String tpd = iv.getCliente().getTipoDoc().toString();
        String vto = sdf2.format(new Date());
        String cuit1;
        String tpd = "80";
        if (tpd.equals("96")) {
            cuit1 = cui.trim();
            tpd = "96";
        } else {
            cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
        }
        int x = 0;
        if (tpd.equals("96")) {
            String s = "0000000000" + cuit1;
            int lar = s.length();
            cuit1 = s.substring(lar - 11, lar);
        }

        Integer suma1 = 0;
        Integer suma2 = 0;
        String sucu = dfs.format(1);
        String cae = "66442938063104";
        int largo = cae.length();
        String txtCadenaRP = "";
        if (largo > 8) {
            String cadena = cuit1 + "0" + tpd + sucu + cae + vto;
            for (int i = 0; i < 39; i++) {
                if (x == 0) {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma1 += num;
                    x = 1;
                } else {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma2 += num;
                    x = 0;
                }
            }
            suma1 = suma1 * 3;
            int total = suma1 + suma2;
            int dv = (int) (rint(total / 10 + .9) * 10);
            dv = dv - total;
            cadena += String.valueOf(dv);

            for (int i = 0; i < 40; i = i + 2) {
                String charNum = cadena.substring(i, i + 2);
                int numChar = Integer.valueOf(charNum);
                if (numChar < 50) {
                    numChar += 48;
                } else {
                    numChar += 142;
                }
                char c = (char) numChar;
                txtCadenaRP = txtCadenaRP + c;
            }
        }
        txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;

        PdfPCell pieFc1 = new PdfPCell(new Paragraph(impu, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph("Total Factura:  " + totFc, FontFactory.getFont("arial", 10, Font.BOLD, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph("Fecha Vencimiento CAE:  " + f_venc_cae, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc5 = new PdfPCell(new Paragraph("CAE nro.:  " + cae_nro, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        com.itextpdf.text.Font font = FontFactory.getFont("C:/ventas/PF_I2OF5_TXT.ttf",
                BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
        BaseFont baseFont = font.getBaseFont();
        com.itextpdf.text.Font nf = new com.itextpdf.text.Font(baseFont, 15);
        PdfPCell pieFc6 = new PdfPCell(new Paragraph(txtCadenaRP, nf));

        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pieFc);

        Image imagen = Image.getInstance("c:/qr/CodigoQR" + "ABC" + ".png");
        Image img2 = Image.getInstance("c:/qr/afip.png");
        imagen.setAbsolutePosition(10f, 50f);
        img2.setAbsolutePosition(230f, 140f);
        pdf.add(imagen);
        pdf.add(img2);

//pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.close();
        return new File("c:/facturas_sys/fc.pdf");
    }

//    public File armarNc(Factura iv, List<RenglonFactura> rf) throws FileNotFoundException, DocumentException, Exception {
//        // crear QR
//        numeroFactura = iv.getNumero();
//        Cliente clienteFactura = iv.getCliente();
//        Date fecha = iv.getFecha();
//        String modeloFcPapel = iv.getTipoDoc().toString();
//        String cui = clienteFactura.getCuit();
//        String pri = "";
//        String med = "";
//        String fin = "";
//        int lgo = cui.length();
//        if (lgo != 13) {
//            cui = "0000000000000" + cui;
//            int lgo1 = cui.length();
//            fin = cui.substring(lgo1 - 11, lgo1);
//        }
//        if (lgo > 11) {
//            pri = cui.substring(0, 2);
//            med = cui.substring(3, 11);
//            fin = cui.substring(12, 13);
//        }
//        fecha_qr = sdf_qr.format(fecha);
//        numeroDoc_qr = pri + med + fin;
//        tipoComprobante_qr = modeloFcPapel;
//        numeroComprobante_qr = iv.getNumero().toString();
//        importe_qr = df.format(iv.getImporte());
//        tipoDoc_qr = clienteFactura.getTipoDoc().toString();
//        nroCae_qr = iv.getCae().toString();
//        String data = "{\"ver\":" + ver_qr
//                + ",\"fecha\":\"" + fecha_qr + "\""
//                + ",\"cuit\":" + cuit_qr
//                + ",\"ptoVta\":" + puntoVenta_qr
//                + ",\"tipoCmp\":" + tipoComprobante_qr
//                + ",\"nroCmp\":" + numeroComprobante_qr
//                + ",\"importe\":" + importe_qr
//                + ",\"moneda\":\"" + moneda_qr + "\""
//                + ",\"ctz\":" + cotiz_qr
//                + ",\"tipoDocRec\":" + tipoDoc_qr
//                + ",\"nroDocRec\":" + numeroDoc_qr
//                + ",\"tipoCodAut\":\"" + tipoCodigoAutoriz_qr + "\""
//                + ",\"codAut\":" + nroCae_qr + "}";
//        try {
//            generarQR(data);
//        } catch (Exception ex) {
//            Logger.getLogger(PDFBuilder.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        // fin crear QR
//        String nr0 = dfn.format(iv.getNumero());
//        String fileNameFormatted = getFileNameFormattedNc(iv);
//        Document pdf = new Document();
//        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
//        pdf.setPageSize(hojaA4);
//        pdf.setMargins(10, 50, 30, 30);
//        pdf.setMarginMirroringTopBottom(true);
//
//        FileOutputStream ficheroPdf = new FileOutputStream("c:/facturas_sys/" + fileNameFormatted + ".pdf");
//
//        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
//        writer.setInitialLeading(20);
//
//        // ABRO EL DOCUMENTO
//        pdf.open();
//
//        // INICIO ENCABEZADO FACTURA
//        String cod = "013";;
//        String fex = sdf.format(iv.getFecha());
//        String nro = "C "
//                + dfs.format(iv.getSucursal()) + "-"
//                + dfn.format(iv.getNumero());
//        PdfPTable encabezado = new PdfPTable(3);
//        encabezado.setWidthPercentage(100);
//        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph(encabezad0, FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
//        //PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("SERVICIOS PROFESIONALES GENERALES", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
//        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph("C", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
//        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("NOTA DE CREDITO", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
//        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Razón Social: Mario Enrique Gianotti", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
//        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("Cod.: " + cod, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph("Número: " + nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("Dirección: 109 Paso 1927", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
//        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph("Fecha: " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
//        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("CP. 1650 - San Martin", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
//        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph("C.U.I.T.: 20-14255320-2", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("BUENOS AIRES", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
//        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph("C.M.: 901-067583-0", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph("Inicio Actividad: 01/05/2013", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//
//        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//
//        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
//        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);
//
//        pdf.add(encabezado);
//        // FIN ENCABEZADO
//
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
//
//        String nombre = iv.getCliente().getRazonSocial();
//        String direcc = iv.getCliente().getDireccion().getCalle();
//        if (iv.getCliente().getDireccion().getNumero() != null) {
//            direcc += " " + iv.getCliente().getDireccion().getNumero();
//        }
//        if (iv.getCliente().getDireccion().getLocalidad() != null) {
//            direcc += " - " + iv.getCliente().getDireccion().getLocalidad();
//        }
//        if (iv.getCliente().getDireccion().getProvincia() != null) {
//            direcc += " - " + iv.getCliente().getDireccion().getProvincia();
//        }
//        String cod_cli = iv.getCliente().getCodigo().toString();
//        String cui2 = iv.getCliente().getCuit();
//        String cat_iva;
//        String piso;
//        String n_ref;
//        if(iv.getNumeroReferencia() != null){
//            n_ref = "Numero Referencia: C 0006-" + dfn.format(iv.getNumeroReferencia());
//        } else {
//            n_ref ="";
//        }
//        if(iv.getCliente().getDireccion().getPisoDto() != null){
//            piso = iv.getCliente().getDireccion().getPisoDto();
//        } else {
//            piso = "";
//        }
//        
//        if (iv.getCliente().getCategoriaAfip().equals(1)) {
//            cat_iva = "Responsable Inscripto";
//        } else {
//            if (iv.getCliente().getCategoriaAfip().equals(2)) {
//                cat_iva = "Responsable Monotributo";
//            } else {
//                if (iv.getCliente().getCategoriaAfip().equals(3)) {
//                    cat_iva = "Responsable Exento";
//                } else {
//                    cat_iva = "Consumidor Final";
//                }
//            }
//        }
//        PdfPTable client = new PdfPTable(2);
//        client.setWidthPercentage(100);
//        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("Razón Social: " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell celdaClient2 = new PdfPCell(new Paragraph("Cliente nro.: " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("Dirección: " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//        PdfPCell celdaClient4 = new PdfPCell(new Paragraph("Inscripción nro.: " + cat_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell celdaClient5 = new PdfPCell(new Paragraph("Piso/Dto.: " + piso, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell celdaClient6 = new PdfPCell(new Paragraph("Condición Venta: CONTADO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell celdaClient7 = new PdfPCell(new Paragraph("C.U.I.T. nro.: " + cui2, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell celdaClient8 = new PdfPCell(new Paragraph(n_ref, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//
//        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaClient7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        celdaClient8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//
//        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
//        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
//        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
//        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
//        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
//        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
//        client.addCell(celdaClient7).setBorder(PdfPCell.NO_BORDER);
//        client.addCell(celdaClient8).setBorder(PdfPCell.NO_BORDER);
//        pdf.add(client);
//
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
//
//        Integer col = 5;
////        if(iv.getCliente().getCategoriaDeIva().equals(1)){
////            col = 7;
////        }
//        PdfPTable detalle = new PdfPTable(col);
//        detalle.setWidthPercentage(100);
//
//        float[] anchos = new float[5];
//        anchos[0] = 30;
//        anchos[1] = 20;
//        anchos[2] = 360;
//        anchos[3] = 90;
//        anchos[4] = 90;
//        //anchos[5] = 90;
//
//        PdfPTable tablaDetalle = new PdfPTable(5);
//        tablaDetalle.setWidthPercentage(100);
//        tablaDetalle.setWidths(anchos);
//
//        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        //PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("SUGERIDO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//
//        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//        //celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//
//        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
//        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
//        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
//        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
//        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
//        //tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
//        pdf.add(tablaDetalle);
//
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));
//
//        int coun = 0;
//        for (RenglonFactura re : rf) {
//            PdfPTable tablaProd = new PdfPTable(5);
//            tablaProd.setWidthPercentage(100);
//            tablaProd.setWidths(anchos);
//            coun += 1;
//            String c_nt = String.valueOf(coun);
//            //String c_ntd = String.valueOf(re.getCantidad());
//            String prec;
//            if (re.getImporte() > 1) {
//                prec = df.format(re.getImporte());
//            } else {
//                prec = " ";
//            }
//// re.getCantidad());
//            //String tota = df.format(re.getTotal());
//            //String suge = df.format(re.getSugerido());
//            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(" " + re.getTexto(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            //PdfPCell tablaProd6 = new PdfPCell(new Paragraph(suge, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//
//            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            //tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//
//            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
//            //tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);
//
//            pdf.add(tablaProd);
////            
//        }
//        for (int i = 1; i < 41 - coun; i++) {
//            PdfPTable tablaProd = new PdfPTable(5);
//            tablaProd.setWidthPercentage(100);
//            tablaProd.setWidths(anchos);
//            String nro_lin = String.valueOf(i + coun);
//            PdfPCell tP1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            //PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
//            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            //tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
//            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
//            tablaProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
//            //tablaProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
//            pdf.add(tablaProd);
////            
////            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
//        }
//
//        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
//
//        PdfPTable pieFc = new PdfPTable(2);
//        pieFc.setWidthPercentage(100);
//
//        String totFc = df.format(iv.getImporte());
//        String impu = "";
//        String f_venc_cae = sdf.format(iv.getFechaVencimCae());
//        String cae_nro = dfc.format(iv.getCae());
////        if (iv.getImpuesto() > 0.00) {
////            impu = "Total Impuesto: " + df.format(iv.getImpuesto());
////        }
//
//        String tpd = iv.getCliente().getTipoDoc().toString();
//        String vto = sdf2.format(iv.getFechaVencimCae());
//        String cuit1;
//        tpd = "80";
//        if (tpd.equals("96")) {
//            cuit1 = cui.trim();
//            tpd = "96";
//        } else {
//            cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
//        }
//        int x = 0;
//        if (tpd.equals("96")) {
//            String s = "0000000000" + cuit1;
//            int lar = s.length();
//            cuit1 = s.substring(lar - 11, lar);
//        }
//
//        Integer suma1 = 0;
//        Integer suma2 = 0;
//        String sucu = dfs.format(iv.getSucursal());
//        String cae = iv.getCae().toString();
//        int largo = cae.length();
//        String txtCadenaRP = "";
//        if (largo > 8) {
//            String cadena = cuit1 + "0" + tpd + sucu + cae + vto;
//            for (int i = 0; i < 39; i++) {
//                if (x == 0) {
//                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
//                    suma1 += num;
//                    x = 1;
//                } else {
//                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
//                    suma2 += num;
//                    x = 0;
//                }
//            }
//            suma1 = suma1 * 3;
//            int total = suma1 + suma2;
//            int dv = (int) (rint(total / 10 + .9) * 10);
//            dv = dv - total;
//            cadena += String.valueOf(dv);
//
//            for (int i = 0; i < 40; i = i + 2) {
//                String charNum = cadena.substring(i, i + 2);
//                int numChar = Integer.valueOf(charNum);
//                if (numChar < 50) {
//                    numChar += 48;
//                } else {
//                    numChar += 142;
//                }
//                char c = (char) numChar;
//                txtCadenaRP = txtCadenaRP + c;
//            }
//        }
//        txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;
//
//        PdfPCell pieFc1 = new PdfPCell(new Paragraph(impu, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell pieFc2 = new PdfPCell(new Paragraph("Total Factura:  " + totFc, FontFactory.getFont("arial", 10, Font.BOLD, NEGRO)));
//        PdfPCell pieFc3 = new PdfPCell(new Paragraph("Fecha Vencimiento CAE:  " + f_venc_cae, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell pieFc4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell pieFc5 = new PdfPCell(new Paragraph("CAE nro.:  " + cae_nro, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//
//        com.itextpdf.text.Font font = FontFactory.getFont("C:/ventas/PF_I2OF5_TXT.ttf",
//                BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
//        BaseFont baseFont = font.getBaseFont();
//        com.itextpdf.text.Font nf = new com.itextpdf.text.Font(baseFont, 15);
//        PdfPCell pieFc6 = new PdfPCell(new Paragraph(txtCadenaRP, nf));
//
//        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//
//        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
//        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
//        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
//        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
//        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
//        pieFc.addCell(pieFc6).setBorder(PdfPCell.NO_BORDER);
//        pdf.add(pieFc);
//
//        Image imagen = Image.getInstance("c:/qr/CodigoQR" + nr0 + ".png");
//        Image img2 = Image.getInstance("c:/qr/afip.png");
//        imagen.setAbsolutePosition(10f, 50f);
//        img2.setAbsolutePosition(230f, 140f);
//        pdf.add(imagen);
//        pdf.add(img2);
//        
////pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
//        pdf.close();
//        return new File(fileNameFormatted);
//    }

    /*
    public File armarRemito(Remito iv, List<RenglonRemito> rf) throws FileNotFoundException, DocumentException, Exception {
        String fileNameFormatted = getFileNameFormatted2(iv);
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 50, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        FileOutputStream ficheroPdf = new FileOutputStream("c:/facturas_sys/" + fileNameFormatted + ".pdf");

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();
        //JOptionPane.showMessageDialog(null, "El archivo esta GRABADO");

        // INICIO ENCABEZADO FACTURA
        String cod = "091";
//        if (iv.getLetra().equals("A")) {
//            cod = "001";
//        } else {
//            cod = "006";
//        }
        String fex = sdf.format(iv.getFecha());
        String nro = iv.getLetra() + " "
                + dfs.format(iv.getNumeroSucursal()) + "-"
                + dfn.format(iv.getNumeroFactura());
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("FADALTI ADRIEL CARLOS", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph("R", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("REMITO", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Razón Social: Fadalti Adriel Carlos", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("Cod.: " + cod, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph("Número: " + nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("Dirección: POTOSÍ 1566", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph("Fecha: " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("CP. 1678 - CASEROS", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph("C.U.I.T.: 23-32956044-9", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("BUENOS AIRES", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph("Ing.Brutos Nro.: 23-32956044-9", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph("Inicio Actividad: 01/01/2013", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String nombre = iv.getCliente().getRazonSocial();
        String direcc = iv.getCliente().getDomicilio().getCalle();
        if (iv.getCliente().getDomicilio().getNumero() != null) {
            direcc += " " + iv.getCliente().getDomicilio().getNumero();
        }
        if (iv.getCliente().getDomicilio().getLocalidad() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getLocalidad();
        }
        if (iv.getCliente().getDomicilio().getProvincia() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getProvincia();
        }
        String cod_cli = iv.getCliente().getCodigo();
        String cui = iv.getCliente().getCuit();
        String cat_iva;
        if (iv.getCliente().getCategoriaDeIva().equals(1)) {
            cat_iva = "Responsable Inscripto";
        } else {
            if (iv.getCliente().getCategoriaDeIva().equals(2)) {
                cat_iva = "Responsable Monotributo";
            } else {
                if (iv.getCliente().getCategoriaDeIva().equals(3)) {
                    cat_iva = "Responsable Exento";
                } else {
                    cat_iva = "Consumidor Final";
                }
            }
        }
        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("Razón Social: " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph("Cliente nro.: " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("Dirección: " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph("Inscripción nro.: " + cat_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph("C.U.I.T. nro.: " + cui, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        Integer col = 6;
//        if(iv.getCliente().getCategoriaDeIva().equals(1)){
//            col = 7;
//        }
        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[6];
        anchos[0] = 20;
        anchos[1] = 30;
        anchos[2] = 280;
        anchos[3] = 90;
        anchos[4] = 90;
        anchos[5] = 90;

        PdfPTable tablaDetalle = new PdfPTable(6);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("CANT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("UNITARIO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("SUGERIDO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        int coun = 0;
        for (RenglonRemito re : rf) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            coun += 1;
            String c_nt = String.valueOf(coun);
            String c_ntd = String.valueOf(re.getCantidad());
            String prec = df.format(re.getTotal() / re.getCantidad());
            String tota = df.format(re.getTotal());
            String suge = df.format(re.getSugerido());
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(c_ntd, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(" " + re.getDescripcion(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(tota, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd6 = new PdfPCell(new Paragraph(suge, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
//            
        }
        for (int i = 1; i < 41 - coun; i++) {
            PdfPTable tblProd = new PdfPTable(6);
            tblProd.setWidthPercentage(100);
            tblProd.setWidths(anchos);
            String nro_lin = String.valueOf(i + coun);
            PdfPCell tP1 = new PdfPCell(new Paragraph(nro_lin, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tblProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tblProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
            tblProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
            tblProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
            tblProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
            tblProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
            pdf.add(tblProd);
//
//            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        }

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        PdfPTable pieFc = new PdfPTable(2);
        pieFc.setWidthPercentage(100);

        String totFc = df.format(iv.getTotal());
        String impu = "";
//        String f_venc_cae = sdf.format(iv.getFechaCae());
//        String cae_nro = dfc.format(iv.getCae());
        if (iv.getImpuesto() > 0.00) {
            impu = "Total Impuesto: " + df.format(iv.getImpuesto());
        }
        PdfPCell pieFc1 = new PdfPCell(new Paragraph(impu, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph("Total Remito:  " + totFc, FontFactory.getFont("arial", 10, Font.BOLD, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell pieFc5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

//        com.itextpdf.text.Font font = FontFactory.getFont("C:/windows/fonts/PF_I2OF5_TXT.ttf",
//                BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
//        BaseFont baseFont = font.getBaseFont();
//        com.itextpdf.text.Font nf = new com.itextpdf.text.Font(baseFont, 15);
//        PdfPCell pieFc6 = new PdfPCell(new Paragraph(txtCadenaRP, nf));
        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
//        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
//        pieFc.addCell(pieFc6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pieFc);

        pdf.close();
        return new File(fileNameFormatted);
    }
     */
 /*
    private String getFileNameFormatted2(Remito cons) {

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String filename = "Remito_R_Social_"
                + cons.getCliente().getRazonSocial()
                + cons.getLetra() + dfs.format(cons.getNumeroSucursal())
                + dfn.format(cons.getNumeroFactura())
                + "_" + sdf.format(cons.getFecha());
        return filename;
    }
     */
 /*
    public File armarFacturaA(Factura iv, List<RenglonFactura> rf) throws FileNotFoundException, DocumentException, Exception {
        String fileNameFormatted = getFileNameFormatted(iv);
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 50, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        FileOutputStream ficheroPdf = new FileOutputStream("c:/facturas_sys/" + fileNameFormatted + ".pdf");

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();
        //JOptionPane.showMessageDialog(null, "El archivo esta GRABADO");

        // INICIO ENCABEZADO FACTURA
        String cod;
        if (iv.getLetra().equals("A")) {
            cod = "001";
        } else {
            cod = "006";
        }
        String fex = sdf.format(iv.getFecha());
        String nro = iv.getLetra() + " "
                + dfs.format(iv.getNumeroSucursal()) + "-"
                + dfn.format(iv.getNumeroFactura());
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("FADALTI ADRIEL CARLOS", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph(iv.getLetra(), FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("FACTURA", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Razón Social: Fadalti Adriel Carlos", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("Cod.: " + cod, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph("Número: " + nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("Dirección: POTOSÍ 1566", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph("Fecha: " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("CP. 1678 - CASEROS", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph("C.U.I.T.: 23-32956044-9", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("BUENOS AIRES", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph("Ing.Brutos Nro.: 23-32956044-9", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph("Inicio Actividad: 01/01/2013", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String nombre = iv.getCliente().getRazonSocial();
        String direcc = iv.getCliente().getDomicilio().getCalle();
        if (iv.getCliente().getDomicilio().getNumero() != null) {
            direcc += " " + iv.getCliente().getDomicilio().getNumero();
        }
        if (iv.getCliente().getDomicilio().getLocalidad() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getLocalidad();
        }
        if (iv.getCliente().getDomicilio().getProvincia() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getProvincia();
        }
        String cod_cli = iv.getCliente().getCodigo();
        String cui = iv.getCliente().getCuit();
        String cat_iva;
        if (iv.getCliente().getCategoriaDeIva().equals(1)) {
            cat_iva = "Responsable Inscripto";
        } else {
            if (iv.getCliente().getCategoriaDeIva().equals(2)) {
                cat_iva = "Responsable Monotributo";
            } else {
                if (iv.getCliente().getCategoriaDeIva().equals(3)) {
                    cat_iva = "Responsable Exento";
                } else {
                    cat_iva = "Consumidor Final";
                }
            }
        }
        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("Razón Social: " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph("Cliente nro.: " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("Dirección: " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph("Inscripción nro.: " + cat_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph("C.U.I.T. nro.: " + cui, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph("Condición Venta: CONTADO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        Integer col = 6;
//        if(iv.getCliente().getCategoriaDeIva().equals(1)){
//            col = 7;
//        }
        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[6];
        anchos[0] = 20;
        anchos[1] = 30;
        anchos[2] = 280;
        anchos[3] = 90;
        anchos[4] = 90;
        anchos[5] = 90;

        PdfPTable tablaDetalle = new PdfPTable(6);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("CANT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("UNITARIO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("IMPUESTO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));

        int coun = 0;
        for (RenglonFactura re : rf) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            coun += 1;
            String c_nt = String.valueOf(coun);
            String c_ntd = String.valueOf(re.getCantidad());
            String prec = df.format(re.getTotal() / re.getCantidad());
            String tota = df.format(re.getTotal());
            String impu = df.format(re.getImpuesto());
            String suge = df.format(re.getSugerido());
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(c_ntd, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(" " + re.getDescripcion(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(impu, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd6 = new PdfPCell(new Paragraph(tota, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
//            
        }
        for (int i = 0; i < 41 - coun; i++) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            String nro_lin = String.valueOf(i + coun);
            PdfPCell tP1 = new PdfPCell(new Paragraph(nro_lin, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
            pdf.add(tablaProd);
//            
//            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        }

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));

        PdfPTable tpieFc = new PdfPTable(4);
        tpieFc.setWidthPercentage(100);
        
        PdfPTable pieFc = new PdfPTable(4);
        pieFc.setWidthPercentage(100);

        PdfPTable cpieFc = new PdfPTable(2);
        cpieFc.setWidthPercentage(100);
        
        PdfPTable dpieFc = new PdfPTable(2);
        dpieFc.setWidthPercentage(100);
        
        String totFc = df.format(iv.getTotal());
        String tot_iva = df.format(iv.getIva());
        String sub_tot = df.format(iv.getGravado());
        String impu = "";
        String f_venc_cae = sdf.format(iv.getFechaCae());
        String cae_nro = dfc.format(iv.getCae());
        if (iv.getImpuesto() > 0.00) {
            impu = "Total Impuesto: " + df.format(iv.getImpuesto());
        }

        String tpd = iv.getCliente().getTipo();
        String vto = sdf2.format(iv.getFechaCae());
        String cuit1;
        tpd = "80";
        if (tpd.equals("96")) {
            cuit1 = cui.trim();
            tpd = "96";
        } else {
            cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
        }
        int x = 0;
        if (tpd.equals("96")) {
            String s = "0000000000" + cuit1;
            int lar = s.length();
            cuit1 = s.substring(lar - 11, lar);
        }
        Integer suma1 = 0;
        Integer suma2 = 0;
        String sucu = dfs.format(iv.getNumeroSucursal());
        String cae = iv.getCae().toString();
        int largo = cae.length();
        String txtCadenaRP = "";
        if (largo > 8) {
            String cadena = cuit1 + "0" + tpd + sucu + cae + vto;
            for (int i = 0; i < 39; i++) {
                if (x == 0) {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma1 += num;
                    x = 1;
                } else {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma2 += num;
                    x = 0;
                }
            }
            suma1 = suma1 * 3;
            int total = suma1 + suma2;
            int dv = (int) (rint(total / 10 + .9) * 10);
            dv = dv - total;
            cadena += String.valueOf(dv);

            for (int i = 0; i < 40; i = i + 2) {
                String charNum = cadena.substring(i, i + 2);
                int numChar = Integer.valueOf(charNum);
                if (numChar < 50) {
                    numChar += 48;
                } else {
                    numChar += 142;
                }
                char c = (char) numChar;
                txtCadenaRP = txtCadenaRP + c;
            }
        }
        
        txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;

        PdfPCell tpieFc1 = new PdfPCell(new Paragraph("SUBTOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell tpieFc2 = new PdfPCell(new Paragraph("IMPUESTO", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell tpieFc3 = new PdfPCell(new Paragraph("IVA 21%", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell tpieFc4 = new PdfPCell(new Paragraph("TOTAL FC", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        
        tpieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tpieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tpieFc3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tpieFc4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        
        tpieFc.addCell(tpieFc1).setBorder(PdfPCell.NO_BORDER);
        tpieFc.addCell(tpieFc2).setBorder(PdfPCell.NO_BORDER);
        tpieFc.addCell(tpieFc3).setBorder(PdfPCell.NO_BORDER);
        tpieFc.addCell(tpieFc4).setBorder(PdfPCell.NO_BORDER);
        
        pdf.add(tpieFc);
        
        PdfPCell pieFc1 = new PdfPCell(new Paragraph(sub_tot, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph(impu, FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(tot_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph(totFc, FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        
        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        
        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
        
        pdf.add(pieFc);
        
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        
        PdfPCell cpieFc1 = new PdfPCell(new Paragraph("Fecha Vencimiento CAE:  " + f_venc_cae, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell cpieFc2 = new PdfPCell(new Paragraph("CAE nro.:  " + cae_nro, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        cpieFc1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        cpieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        
        cpieFc.addCell(cpieFc1).setBorder(PdfPCell.NO_BORDER);
        cpieFc.addCell(cpieFc2).setBorder(PdfPCell.NO_BORDER);
        
        pdf.add(cpieFc);
        
        com.itextpdf.text.Font font = FontFactory.getFont("C:/windows/fonts/PF_I2OF5_TXT.ttf",
                BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
        BaseFont baseFont = font.getBaseFont();
        com.itextpdf.text.Font nf = new com.itextpdf.text.Font(baseFont, 15);
        
        PdfPCell dpieFc1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell dpieFc2 = new PdfPCell(new Paragraph(txtCadenaRP, nf));

        dpieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        dpieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        
        dpieFc.addCell(dpieFc1).setBorder(PdfPCell.NO_BORDER);
        dpieFc.addCell(dpieFc2).setBorder(PdfPCell.NO_BORDER);
        
        pdf.add(dpieFc);
        
        pdf.close();
        return new File(fileNameFormatted);
    }
    
    public File armarFacturaPanificadosA(IvaVentas iv, List<RenglonFactura> rf) throws FileNotFoundException, DocumentException, Exception {
        String fileNameFormatted = getFileNameFormatted(iv);
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 50, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        FileOutputStream ficheroPdf = new FileOutputStream("c:/facturas_sys/" + fileNameFormatted + ".pdf");

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();
        //JOptionPane.showMessageDialog(null, "El archivo esta GRABADO");

        // INICIO ENCABEZADO FACTURA
        String cod;
        if (iv.getLetra().equals("A")) {
            cod = "001";
        } else {
            cod = "006";
        }
        String fex = sdf.format(iv.getFecha());
        String nro = iv.getLetra() + " "
                + dfs.format(iv.getNumeroSucursal()) + "-"
                + dfn.format(iv.getNumeroFactura());
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("FADALTI ADRIEL CARLOS", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph(iv.getLetra(), FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("FACTURA", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Razón Social: Fadalti Adriel Carlos", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("Cod.: " + cod, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph("Número: " + nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("Dirección: POTOSÍ 1566", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph("Fecha: " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("CP. 1678 - CASEROS", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph("C.U.I.T.: 23-32956044-9", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("BUENOS AIRES", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph("Ing.Brutos Nro.: 23-32956044-9", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph("Inicio Actividad: 01/01/2013", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String nombre = iv.getCliente().getRazonSocial();
        String direcc = iv.getCliente().getDomicilio().getCalle();
        if (iv.getCliente().getDomicilio().getNumero() != null) {
            direcc += " " + iv.getCliente().getDomicilio().getNumero();
        }
        if (iv.getCliente().getDomicilio().getLocalidad() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getLocalidad();
        }
        if (iv.getCliente().getDomicilio().getProvincia() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getProvincia();
        }
        String cod_cli = iv.getCliente().getCodigo();
        String cui = iv.getCliente().getCuit();
        String cat_iva;
        if (iv.getCliente().getCategoriaDeIva().equals(1)) {
            cat_iva = "Responsable Inscripto";
        } else {
            if (iv.getCliente().getCategoriaDeIva().equals(2)) {
                cat_iva = "Responsable Monotributo";
            } else {
                if (iv.getCliente().getCategoriaDeIva().equals(3)) {
                    cat_iva = "Responsable Exento";
                } else {
                    cat_iva = "Consumidor Final";
                }
            }
        }
        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("Razón Social: " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph("Cliente nro.: " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("Dirección: " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph("Inscripción nro.: " + cat_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph("C.U.I.T. nro.: " + cui, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph("Condición Venta: CONTADO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        Integer col = 6;
//        if(iv.getCliente().getCategoriaDeIva().equals(1)){
//            col = 7;
//        }
        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[6];
        anchos[0] = 20;
        anchos[1] = 30;
        anchos[2] = 280;
        anchos[3] = 90;
        anchos[4] = 90;
        anchos[5] = 90;

        PdfPTable tablaDetalle = new PdfPTable(6);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("CANT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("UNITARIO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("% IVA", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));

        int coun = 0;
        for (RenglonFactura re : rf) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            coun += 1;
            String c_nt = String.valueOf(coun);
            String c_ntd = String.valueOf(re.getCantidad());
            String prec = df.format(re.getTotal() / re.getCantidad());
            String tota = df.format(re.getTotal());
            String alic = df_ali.format(re.getProducto().getAlicuotaIva().getAlicuota());
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(c_ntd, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(" " + re.getDescripcion(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(alic, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd6 = new PdfPCell(new Paragraph(tota, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
//            
        }
        for (int i = 0; i < 41 - coun; i++) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            String nro_lin = String.valueOf(i + coun);
            PdfPCell tP1 = new PdfPCell(new Paragraph(nro_lin, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
            pdf.add(tablaProd);
//            
//            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        }

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));

        PdfPTable tpieFc = new PdfPTable(5);
        tpieFc.setWidthPercentage(100);
        
        PdfPTable pieFc = new PdfPTable(5);
        pieFc.setWidthPercentage(100);

        PdfPTable cpieFc = new PdfPTable(2);
        cpieFc.setWidthPercentage(100);
        
        PdfPTable dpieFc = new PdfPTable(2);
        dpieFc.setWidthPercentage(100);
        
        String totFc = df.format(iv.getTotal());
        String tot_iva = df.format(iv.getIva());
        String tot_iva_10 = df.format(iv.getIva10_5());
        String tot_iva_27 = df.format(iv.getIva27());
        String sub_tot = df.format(iv.getGravado() + iv.getGravado0() + iv.getGravado10_5() + iv.getGravado27());
        String f_venc_cae = sdf.format(iv.getFechaCae());
        String cae_nro = dfc.format(iv.getCae());
//        if (iv.getImpuesto() > 0.00) {
//            impu = "Total Impuesto: " + df.format(iv.getImpuesto());
//        }

        String tpd = iv.getCliente().getTipo();
        String vto = sdf2.format(iv.getFechaCae());
        String cuit1;
        tpd = "80";
        if (tpd.equals("96")) {
            cuit1 = cui.trim();
            tpd = "96";
        } else {
            cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
        }
        int x = 0;
        if (tpd.equals("96")) {
            String s = "0000000000" + cuit1;
            int lar = s.length();
            cuit1 = s.substring(lar - 11, lar);
        }
        Integer suma1 = 0;
        Integer suma2 = 0;
        String sucu = dfs.format(iv.getNumeroSucursal());
        String cae = iv.getCae().toString();
        int largo = cae.length();
        String txtCadenaRP = "";
        if (largo > 8) {
            String cadena = cuit1 + "0" + tpd + sucu + cae + vto;
            for (int i = 0; i < 39; i++) {
                if (x == 0) {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma1 += num;
                    x = 1;
                } else {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma2 += num;
                    x = 0;
                }
            }
            suma1 = suma1 * 3;
            int total = suma1 + suma2;
            int dv = (int) (rint(total / 10 + .9) * 10);
            dv = dv - total;
            cadena += String.valueOf(dv);

            for (int i = 0; i < 40; i = i + 2) {
                String charNum = cadena.substring(i, i + 2);
                int numChar = Integer.valueOf(charNum);
                if (numChar < 50) {
                    numChar += 48;
                } else {
                    numChar += 142;
                }
                char c = (char) numChar;
                txtCadenaRP = txtCadenaRP + c;
            }
        }
        
        txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;

        PdfPCell tpieFc1 = new PdfPCell(new Paragraph("SUBTOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell tpieFc2 = new PdfPCell(new Paragraph("IVA 10.5%", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell tpieFc3 = new PdfPCell(new Paragraph("IVA 21%", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell tpieFc4 = new PdfPCell(new Paragraph("IVA 27%", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell tpieFc5 = new PdfPCell(new Paragraph("TOTAL FC", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        
        tpieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tpieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tpieFc3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tpieFc4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tpieFc5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        
        tpieFc.addCell(tpieFc1).setBorder(PdfPCell.NO_BORDER);
        tpieFc.addCell(tpieFc2).setBorder(PdfPCell.NO_BORDER);
        tpieFc.addCell(tpieFc3).setBorder(PdfPCell.NO_BORDER);
        tpieFc.addCell(tpieFc4).setBorder(PdfPCell.NO_BORDER);
        tpieFc.addCell(tpieFc5).setBorder(PdfPCell.NO_BORDER);
        
        pdf.add(tpieFc);
        
        PdfPCell pieFc1 = new PdfPCell(new Paragraph(sub_tot, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph(tot_iva_10, FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(tot_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph(tot_iva_27, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc5 = new PdfPCell(new Paragraph(totFc, FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        
        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        
        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
        
        pdf.add(pieFc);
        
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        
        PdfPCell cpieFc1 = new PdfPCell(new Paragraph("Fecha Vencimiento CAE:  " + f_venc_cae, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell cpieFc2 = new PdfPCell(new Paragraph("CAE nro.:  " + cae_nro, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        cpieFc1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        cpieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        
        cpieFc.addCell(cpieFc1).setBorder(PdfPCell.NO_BORDER);
        cpieFc.addCell(cpieFc2).setBorder(PdfPCell.NO_BORDER);
        
        pdf.add(cpieFc);
        
        com.itextpdf.text.Font font = FontFactory.getFont("C:/windows/fonts/PF_I2OF5_TXT.ttf",
                BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
        BaseFont baseFont = font.getBaseFont();
        com.itextpdf.text.Font nf = new com.itextpdf.text.Font(baseFont, 15);
        
        PdfPCell dpieFc1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell dpieFc2 = new PdfPCell(new Paragraph(txtCadenaRP, nf));

        dpieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        dpieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        
        dpieFc.addCell(dpieFc1).setBorder(PdfPCell.NO_BORDER);
        dpieFc.addCell(dpieFc2).setBorder(PdfPCell.NO_BORDER);
        
        pdf.add(dpieFc);
        
        pdf.close();
        return new File(fileNameFormatted);
    }
     */
    public File armarCertificado(Trabajo trabajo) throws FileNotFoundException, DocumentException, Exception {
        Document pdf = new Document();
        Domicilio dm = trabajo.getServicio().getConsorcio().getDomicilio();
        String calleConsorcio = dm.getCalle() + " " + dm.getNumero();
        String fecha = sdf.format(trabajo.getFecha());

        String fileNameFormatted = "c://emitank//pdf//certificado.pdf";
        FileOutputStream ficheroPdf = new FileOutputStream(fileNameFormatted);
        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 50, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        pdf.open();
        //titulos 
        PdfPTable hoja = new PdfPTable(1);
        hoja.setWidthPercentage(100);
        PdfPTable detalle = new PdfPTable(2);
        detalle.setWidthPercentage(95);
        float[] anchos = new float[2];
        anchos[0] = 65;
        anchos[1] = 35;
        PdfPTable tablaDetalle = new PdfPTable(2);
        tablaDetalle.setWidthPercentage(95);
        tablaDetalle.setWidths(anchos);
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        String l1 = "Besares 1717 - (1111) Capital Federal";
        String l2 = " ";
        String l3 = "Tel: 4704-0685 - Cel.:15-4427-1411";
        String l4 = " ";
        String l5 = "REG. DE ACTIV. DIR. GRAL. DE POL. Y CTROL. AMBIENT. G.C.B.A.:";
        String l6 = " ";
        String l7 = "LIMP. Y DESINF. DE TANQUES DE AGUA POTABLE N° 592";
        String l8 = " ";
        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph(l1, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph(l2, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph(l3, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph(l4, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph(l5, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph(l6, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos7 = new PdfPCell(new Paragraph(l7, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        PdfPCell celdaTitulos8 = new PdfPCell(new Paragraph(l8, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaTitulos7.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos8.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos7).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos8).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        //banner
        PdfPTable tablaBanner = new PdfPTable(1);
        float[] anchos1 = new float[1];
        anchos1[0] = 95;
        tablaBanner.setWidthPercentage(95);
        tablaBanner.setWidths(anchos1);
        String b1 = "CERTIFICADO DE LIMPIEZA Y DESINFECCIÓN";
        String b2 = "DE TANQUES DE AGUA POTABLE";
        PdfPCell celdaBanner1 = new PdfPCell(new Paragraph(b1, FontFactory.getFont("times new roman",
                28, Font.BOLD, NEGRO)));
        PdfPCell celdaBanner2 = new PdfPCell(new Paragraph(b2, FontFactory.getFont("times new roman",
                28, Font.BOLD, NEGRO)));
        celdaBanner1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaBanner2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaBanner1.setVerticalAlignment(PdfPCell.ALIGN_TOP);
        celdaBanner2.setVerticalAlignment(PdfPCell.ALIGN_TOP);
        celdaBanner2.setPaddingBottom(10);
        celdaBanner1.setBorderWidthTop(2);
        celdaBanner1.setBorderColor(BaseColor.RED);
        celdaBanner2.setBorderWidthBottom(2);
        celdaBanner2.setBorderColor(BaseColor.RED);

        tablaBanner.addCell(celdaBanner1).setBorder(PdfPCell.TOP);
        tablaBanner.addCell(celdaBanner2).setBorder(PdfPCell.BOTTOM);

        pdf.add(tablaBanner);
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));

        // contenido
        PdfPTable tablaContenido = new PdfPTable(1);
        float[] anchos2 = new float[1];
        anchos2[0] = 95;
        tablaContenido.setWidthPercentage(95);
        tablaContenido.setWidths(anchos2);

        PdfPTable tablaContenido1 = new PdfPTable(1);
        float[] anchos3 = new float[1];
        anchos3[0] = 95;
        tablaContenido1.setWidthPercentage(95);
        tablaContenido1.setWidths(anchos3);

        String me[] = new String[12];
        int ro = 0;
        for (Mes me1 : Mes.values()) {
            me[ro] = me1.toString();
            System.out.println(me1);
            ro += 1;
        }
//System.exit(0);
        String dia;
        String mes;
        String anio;
        int y = Calendar.getInstance().get(Calendar.YEAR);
        int d = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int m = Calendar.getInstance().get(Calendar.MONTH);
        dia = dfc.format(d);
        mes = me[m - 1];
        anio = dfs.format(y);
        String c0 = "EMPRESA EMITANK – CUIT: 20-22653797-0";
        String c1 = "Se deja constancia que el día " + fecha
                + " se ha procedido a realizar la Limpieza y Desinfección";
        String c2 = "de los Tanques de Agua Potable en el inmueble ubicado en: ";
        String c3 = calleConsorcio + " de la Ciudad Autónoma de Buenos Aires.";
        String c4 = "Producto utilizado y concentración: HIPOCLORITO DE SODIO (55 g/l)";

        PdfPTable cuadro = new PdfPTable(4);
        float[] anchosCuadro = new float[4];
        anchosCuadro[0] = 23;
        anchosCuadro[1] = 23;
        anchosCuadro[2] = 23;
        anchosCuadro[3] = 23;
        cuadro.setWidthPercentage(95);
        cuadro.setWidths(anchosCuadro);

        String c4_ta = "FORMULA";
        String c4_tb = "NRO.INSCRIPCION";
        String c4_tc = "FABRICANTE";
        String c4_td = "ORIGEN";

        String c4_a = "NACLO";
        String c4_b = "250022";
        String c4_c = "CLOROS ARGENTINA";
        String c4_d = "ARGENTINA";

        PdfPCell cuadro1 = new PdfPCell(new Paragraph(c4_ta, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        PdfPCell cuadro2 = new PdfPCell(new Paragraph(c4_tb, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        PdfPCell cuadro3 = new PdfPCell(new Paragraph(c4_tc, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        PdfPCell cuadro4 = new PdfPCell(new Paragraph(c4_td, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        cuadro1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        cuadro1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro2.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro3.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro4.setVerticalAlignment(PdfPCell.ALIGN_CENTER);

        PdfPCell cuadro1d = new PdfPCell(new Paragraph(c4_a, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        PdfPCell cuadro2d = new PdfPCell(new Paragraph(c4_b, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        PdfPCell cuadro3d = new PdfPCell(new Paragraph(c4_c, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        PdfPCell cuadro4d = new PdfPCell(new Paragraph(c4_d, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        cuadro1d.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro2d.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro3d.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro4d.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        cuadro1d.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro2d.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro3d.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro4d.setVerticalAlignment(PdfPCell.ALIGN_CENTER);

        cuadro1.setPaddingBottom(6);
        cuadro2.setPaddingBottom(6);
        cuadro3.setPaddingBottom(6);
        cuadro4.setPaddingBottom(6);
        cuadro1d.setPaddingBottom(6);
        cuadro2d.setPaddingBottom(6);
        cuadro3d.setPaddingBottom(6);
        cuadro4d.setPaddingBottom(6);

//        cuadro1d.setBorderWidthLeft(2);
//        cuadro1d.setBorderWidthRight(2);
//        cuadro1d.setBorderWidthTop(2);
        cuadro1.setBorderWidth(2);
        cuadro2.setBorderWidth(2);
        cuadro3.setBorderWidth(2);
        cuadro4.setBorderWidth(2);
        cuadro1d.setBorderWidth(2);
        cuadro2d.setBorderWidth(2);
        cuadro3d.setBorderWidth(2);
        cuadro4d.setBorderWidth(2);
//        cuadro4d.setBorderWidthLeft(2);
//        cuadro4d.setBorderWidthRight(2);
//        cuadro4d.setBorderWidthTop(2);

        cuadro1.setBorderColor(NEGRO);
        cuadro2.setBorderColor(NEGRO);
        cuadro3.setBorderColor(NEGRO);
        cuadro4.setBorderColor(NEGRO);

        cuadro.addCell(cuadro1).setBorder(PdfPCell.BOX);
        cuadro.addCell(cuadro2).setBorder(PdfPCell.BOX);
        cuadro.addCell(cuadro3).setBorder(PdfPCell.BOX);
        cuadro.addCell(cuadro4).setBorder(PdfPCell.BOX);
        cuadro.addCell(cuadro1d).setBorder(PdfPCell.BOX);
        cuadro.addCell(cuadro2d).setBorder(PdfPCell.BOX);
        cuadro.addCell(cuadro3d).setBorder(PdfPCell.BOX);
        cuadro.addCell(cuadro4d).setBorder(PdfPCell.BOX);

        String c5 = "INFORME DEL ESTADO DE EL/LOS TANQUES: BUENO";
        String c6 = "RESULTADO DE LOS ENSAYOS BACTERIOLÓGICOS: POTABLE";
        String c7 = "SE ADJUNTA PROTOCOLO DE LOS ANÁLISIS BACTERIOLÓGICOS";
        String c8 = "Se otorga el presente Certificado de Limpieza y Desinfección de Tanques";
        String c9 = "de Agua Potable a los " + dia + " días del mes de " + mes + " de " + anio;

        PdfPCell celdaContenidoVacio = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial",
                9, Font.BOLD, FONDO_BLANCO)));
        PdfPCell celdaContenido0 = new PdfPCell(new Paragraph(c0, FontFactory.getFont("arial",
                22, Font.BOLD, NEGRO)));
        PdfPCell celdaContenido1 = new PdfPCell(new Paragraph(c1, FontFactory.getFont("arial",
                12, Font.PLAIN, NEGRO)));
        PdfPCell celdaContenido2 = new PdfPCell(new Paragraph(c2, FontFactory.getFont("arial",
                12, Font.PLAIN, NEGRO)));
        PdfPCell celdaContenido3 = new PdfPCell(new Paragraph(c3, FontFactory.getFont("arial",
                12, Font.PLAIN, NEGRO)));
        PdfPCell celdaContenido4 = new PdfPCell(new Paragraph(c4, FontFactory.getFont("arial",
                12, Font.PLAIN, NEGRO)));
        PdfPCell celdaContenido5 = new PdfPCell(new Paragraph(c5, FontFactory.getFont("arial",
                12, Font.PLAIN, NEGRO)));
        PdfPCell celdaContenido6 = new PdfPCell(new Paragraph(c6, FontFactory.getFont("arial",
                12, Font.PLAIN, NEGRO)));
        PdfPCell celdaContenido7 = new PdfPCell(new Paragraph(c7, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaContenido8 = new PdfPCell(new Paragraph(c8, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaContenido9 = new PdfPCell(new Paragraph(c9, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));

        celdaContenidoVacio.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaContenido0.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido8.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        tablaContenido1.addCell(celdaContenido0).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenido1).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenido2).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenido3).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenido4).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaContenido1);
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(cuadro);
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenido5).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenido6).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenido7).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenido8).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenido9).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaContenido);

        Image imagen = Image.getInstance("c://emitank//logo//firma_emitank.png");
        imagen.setAbsolutePosition(420f, 100f);
        pdf.add(imagen);
        Image imagen1 = Image.getInstance("c://emitank//logo//logo_emitank.png");
        imagen1.setAbsolutePosition(420f, 870f);
        pdf.add(imagen1);

        //
        pdf.close();
        return new File(fileNameFormatted);
    }

    public File armarCertificado2(Trabajo trabajo) throws FileNotFoundException, DocumentException, Exception {
        Document pdf = new Document();
        List<RenglonTrabajo> renglones = null;
        renglones = new RenglonTrabajoService().getRenglonesByTrabajoActivo(trabajo);
        Boolean fisico = false;
        Boolean bacterio = false;
        for (RenglonTrabajo rt : renglones) {
            if (rt.getCodigoCampo().equals(15)) {
                if (rt.getContenido().equals("SI")) {
                    bacterio = true;
                }
            }
            if (rt.getCodigoCampo().equals(16)) {
                if (rt.getContenido().equals("SI")) {
                    fisico = true;
                }
            }
        }
        Domicilio dm = trabajo.getServicio().getConsorcio().getDomicilio();
        String calleConsorcio = dm.getCalle() + " " + dm.getNumero();
        String fecha = sdf.format(trabajo.getFecha());
        String fecha2 = sdf2.format(trabajo.getFecha());
        String dm2 = dm.getCalle() + "_" + dm.getNumero().replace("/", "-");
        Administrador adm = trabajo.getServicio().getConsorcio().getAdministrador();
        String dm3 = adm.getRazonSocial().replaceAll(" ", "_");
        String fileNameFormatted = "c://emitank//pdf//CERTIFICADO" + "_" + dm3 + "_" + dm2 + "_" + fecha2 + ".pdf";
        FileOutputStream ficheroPdf = new FileOutputStream(fileNameFormatted);
        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);
        pdf.setPageSize(hojaA4);
        pdf.setMargins(20, 20, 20, 20);
        pdf.setMarginMirroringTopBottom(true);

        pdf.open();
        //titulos 
        PdfPTable hoja = new PdfPTable(1);
        hoja.setWidthPercentage(100);

        PdfPTable detalle = new PdfPTable(2);
        detalle.setWidthPercentage(90);
        float[] anchos = new float[2];
        anchos[0] = 60;
        anchos[1] = 30;

        PdfPTable tablaDetalle = new PdfPTable(2);
        tablaDetalle.setWidthPercentage(95);
        tablaDetalle.setWidths(anchos);

        hoja.getDefaultCell().setBorderColorLeft(BaseColor.RED);
        hoja.getDefaultCell().setBorderColorRight(BaseColor.RED);
        hoja.getDefaultCell().setBorderColorTop(BaseColor.RED);
        hoja.getDefaultCell().setBorderWidthTop(4);
        hoja.getDefaultCell().setBorderWidthLeft(4);
        hoja.getDefaultCell().setBorderWidthRight(4);
        hoja.getDefaultCell().setBorderWidthBottom(0);

        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        hoja.getDefaultCell().setBorderColorLeft(BaseColor.RED);
        hoja.getDefaultCell().setBorderColorRight(BaseColor.RED);
        hoja.getDefaultCell().setBorderWidthTop(0);
        hoja.getDefaultCell().setBorderWidthLeft(4);
        hoja.getDefaultCell().setBorderWidthRight(4);
        hoja.getDefaultCell().setBorderWidthBottom(0);

        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        String l1 = "Besares 1717 - (1111) Capital Federal";
        String l2 = " ";
        String l3 = "Tel: 4704-0685 - Cel.:15-4427-1411";
        String l4 = " ";
        String l5 = "REG. DE ACTIV. DIR. GRAL. DE POL. Y CTROL. AMBIENT. G.C.B.A.:";
        String l6 = " ";
        String l7 = "LIMP. Y DESINF. DE TANQUES DE AGUA POTABLE N° 592";
        String l8 = " ";
        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph(l1, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph(l2, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph(l3, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph(l4, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph(l5, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph(l6, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos7 = new PdfPCell(new Paragraph(l7, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        PdfPCell celdaTitulos8 = new PdfPCell(new Paragraph(l8, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaTitulos7.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos8.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos7).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos8).setBorder(PdfPCell.NO_BORDER);

        hoja.addCell(tablaDetalle);
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        hoja.getDefaultCell().setBorderColorLeft(BaseColor.RED);
        hoja.getDefaultCell().setBorderColorRight(BaseColor.RED);
//        hoja.getDefaultCell().setBorderColorTop(BaseColor.RED);
        hoja.getDefaultCell().setBorderWidthTop(0);
        hoja.getDefaultCell().setBorderWidthLeft(4);
        hoja.getDefaultCell().setBorderWidthRight(4);
        hoja.getDefaultCell().setBorderWidthBottom(0);

//        pdf.add(tablaDetalle);
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        //banner
        PdfPTable tablaBanner = new PdfPTable(1);
        float[] anchos1 = new float[1];
        anchos1[0] = 90;
        tablaBanner.setWidthPercentage(90);
        tablaBanner.setWidths(anchos1);
        String b1 = "CERTIFICADO DE LIMPIEZA Y DESINFECCIÓN";
        String b2 = "DE TANQUES DE AGUA POTABLE";
        PdfPCell celdaBanner1 = new PdfPCell(new Paragraph(b1, FontFactory.getFont("times new roman",
                28, Font.BOLD, NEGRO)));
        PdfPCell celdaBanner2 = new PdfPCell(new Paragraph(b2, FontFactory.getFont("times new roman",
                28, Font.BOLD, NEGRO)));
        celdaBanner1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaBanner2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaBanner1.setVerticalAlignment(PdfPCell.ALIGN_TOP);
        celdaBanner2.setVerticalAlignment(PdfPCell.ALIGN_TOP);
        celdaBanner2.setPaddingBottom(10);
        celdaBanner1.setBorderWidthTop(2);
        celdaBanner1.setBorderColor(BaseColor.RED);
        celdaBanner2.setBorderWidthBottom(2);
        celdaBanner2.setBorderColor(BaseColor.RED);

        tablaBanner.addCell(celdaBanner1).setBorder(PdfPCell.TOP);
        tablaBanner.addCell(celdaBanner2).setBorder(PdfPCell.BOTTOM);

//        pdf.add(tablaBanner);
        hoja.addCell(tablaBanner);

        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        hoja.getDefaultCell().setBorderColorLeft(BaseColor.RED);
        hoja.getDefaultCell().setBorderColorRight(BaseColor.RED);
//        hoja.getDefaultCell().setBorderColorTop(BaseColor.RED);
        hoja.getDefaultCell().setBorderWidthTop(0);
        hoja.getDefaultCell().setBorderWidthLeft(4);
        hoja.getDefaultCell().setBorderWidthRight(4);
        hoja.getDefaultCell().setBorderWidthBottom(0);

//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        // contenido
        PdfPTable tablaContenido = new PdfPTable(1);
        float[] anchos2 = new float[1];
        anchos2[0] = 95;
        tablaContenido.setWidthPercentage(95);
        tablaContenido.setWidths(anchos2);

        PdfPTable tablaContenido1 = new PdfPTable(1);
        float[] anchos3 = new float[1];
        anchos3[0] = 95;
        tablaContenido1.setWidthPercentage(95);
        tablaContenido1.setWidths(anchos3);

        String me[] = new String[12];
        int ro = 0;
        for (Mes me1 : Mes.values()) {
            me[ro] = me1.toString();
            System.out.println(me1);
            ro += 1;
        }
//System.exit(0);
        String dia;
        String mes;
        String anio;
        int y = Calendar.getInstance().get(Calendar.YEAR);
        int d = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int m = Calendar.getInstance().get(Calendar.MONTH);
        dia = dfc.format(d);
        mes = me[m - 1];
        anio = dfs.format(y);
        String c0 = " EMPRESA EMITANK – CUIT: 20-22653797-0";
        String c1 = " Se deja constancia que el día " + fecha
                + " se ha procedido a realizar la Limpieza y Desinfección";
        String c2 = " de los Tanques de Agua Potable en el inmueble ubicado en: ";
        String c3 = " " + calleConsorcio + " de la Ciudad Autónoma de Buenos Aires.";
        String c4 = " Producto utilizado y concentración: HIPOCLORITO DE SODIO (55 g/l)";

        PdfPTable cuadro = new PdfPTable(4);
        float[] anchosCuadro = new float[4];
        anchosCuadro[0] = 20;
        anchosCuadro[1] = 20;
        anchosCuadro[2] = 20;
        anchosCuadro[3] = 20;
        cuadro.setWidthPercentage(80);
        cuadro.setWidths(anchosCuadro);

        String c4_ta = "FORMULA";
        String c4_tb = "NRO.INSCRIPCION";
        String c4_tc = "FABRICANTE";
        String c4_td = "ORIGEN";

        String c4_a = "NACLO";
        String c4_b = "250022";
        String c4_c = "CLOROS ARGENTINA";
        String c4_d = "ARGENTINA";

        PdfPCell cuadro1 = new PdfPCell(new Paragraph(c4_ta, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        PdfPCell cuadro2 = new PdfPCell(new Paragraph(c4_tb, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        PdfPCell cuadro3 = new PdfPCell(new Paragraph(c4_tc, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        PdfPCell cuadro4 = new PdfPCell(new Paragraph(c4_td, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        cuadro1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        cuadro1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro2.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro3.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro4.setVerticalAlignment(PdfPCell.ALIGN_CENTER);

        PdfPCell cuadro1d = new PdfPCell(new Paragraph(c4_a, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        PdfPCell cuadro2d = new PdfPCell(new Paragraph(c4_b, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        PdfPCell cuadro3d = new PdfPCell(new Paragraph(c4_c, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        PdfPCell cuadro4d = new PdfPCell(new Paragraph(c4_d, FontFactory.getFont("arial",
                11, Font.BOLD, NEGRO)));
        cuadro1d.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro2d.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro3d.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro4d.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        cuadro1d.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro2d.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro3d.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cuadro4d.setVerticalAlignment(PdfPCell.ALIGN_CENTER);

        cuadro1.setPaddingBottom(6);
        cuadro2.setPaddingBottom(6);
        cuadro3.setPaddingBottom(6);
        cuadro4.setPaddingBottom(6);
        cuadro1d.setPaddingBottom(6);
        cuadro2d.setPaddingBottom(6);
        cuadro3d.setPaddingBottom(6);
        cuadro4d.setPaddingBottom(6);

//        cuadro1d.setBorderWidthLeft(2);
//        cuadro1d.setBorderWidthRight(2);
//        cuadro1d.setBorderWidthTop(2);
        cuadro1.setBorderWidth(2);
        cuadro2.setBorderWidth(2);
        cuadro3.setBorderWidth(2);
        cuadro4.setBorderWidth(2);
        cuadro1d.setBorderWidth(2);
        cuadro2d.setBorderWidth(2);
        cuadro3d.setBorderWidth(2);
        cuadro4d.setBorderWidth(2);
//        cuadro4d.setBorderWidthLeft(2);
//        cuadro4d.setBorderWidthRight(2);
//        cuadro4d.setBorderWidthTop(2);

        cuadro1.setBorderColor(NEGRO);
        cuadro2.setBorderColor(NEGRO);
        cuadro3.setBorderColor(NEGRO);
        cuadro4.setBorderColor(NEGRO);

        cuadro.addCell(cuadro1).setBorder(PdfPCell.BOX);
        cuadro.addCell(cuadro2).setBorder(PdfPCell.BOX);
        cuadro.addCell(cuadro3).setBorder(PdfPCell.BOX);
        cuadro.addCell(cuadro4).setBorder(PdfPCell.BOX);
        cuadro.addCell(cuadro1d).setBorder(PdfPCell.BOX);
        cuadro.addCell(cuadro2d).setBorder(PdfPCell.BOX);
        cuadro.addCell(cuadro3d).setBorder(PdfPCell.BOX);
        cuadro.addCell(cuadro4d).setBorder(PdfPCell.BOX);

        String c5 = " INFORME DEL ESTADO DE EL/LOS TANQUES: BUENO";
        String c6 = " RESULTADO DE LOS ENSAYOS BACTERIOLÓGICOS: POTABLE";
        String c7 = " SE ADJUNTA PROTOCOLO DE LOS ANÁLISIS BACTERIOLÓGICOS";
        String c8 = " Se otorga el presente Certificado de Limpieza y Desinfección de Tanques";
        String c9 = " de Agua Potable a los " + dia + " días del mes de " + mes + " de " + anio;

        PdfPCell celdaContenidoVacio = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial",
                9, Font.BOLD, FONDO_BLANCO)));
        PdfPCell celdaContenido0 = new PdfPCell(new Paragraph(c0, FontFactory.getFont("arial",
                22, Font.BOLD, NEGRO)));
        PdfPCell celdaContenido1 = new PdfPCell(new Paragraph(c1, FontFactory.getFont("arial",
                12, Font.PLAIN, NEGRO)));
        PdfPCell celdaContenido2 = new PdfPCell(new Paragraph(c2, FontFactory.getFont("arial",
                12, Font.PLAIN, NEGRO)));
        PdfPCell celdaContenido3 = new PdfPCell(new Paragraph(c3, FontFactory.getFont("arial",
                12, Font.PLAIN, NEGRO)));
        PdfPCell celdaContenido4 = new PdfPCell(new Paragraph(c4, FontFactory.getFont("arial",
                12, Font.PLAIN, NEGRO)));
        PdfPCell celdaContenido5 = new PdfPCell(new Paragraph(c5, FontFactory.getFont("arial",
                12, Font.PLAIN, NEGRO)));
        PdfPCell celdaContenido6 = new PdfPCell(new Paragraph(c6, FontFactory.getFont("arial",
                12, Font.PLAIN, NEGRO)));
        PdfPCell celdaContenido7 = new PdfPCell(new Paragraph(c7, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaContenido8 = new PdfPCell(new Paragraph(c8, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaContenido9 = new PdfPCell(new Paragraph(c9, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));

        celdaContenidoVacio.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaContenido0.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido8.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        tablaContenido1.addCell(celdaContenido0).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenido1).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenido2).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenido3).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido1.addCell(celdaContenido4).setBorder(PdfPCell.NO_BORDER);

        hoja.addCell(tablaContenido1);

        hoja.getDefaultCell().setBorderColorLeft(BaseColor.RED);
        hoja.getDefaultCell().setBorderColorRight(BaseColor.RED);
        hoja.getDefaultCell().setBorderWidthTop(0);
        hoja.getDefaultCell().setBorderWidthLeft(4);
        hoja.getDefaultCell().setBorderWidthRight(4);
        hoja.getDefaultCell().setBorderWidthBottom(0);

        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

//        pdf.add(tablaContenido1);
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
//        pdf.add(cuadro);
        hoja.addCell(cuadro);

        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        hoja.getDefaultCell().setBorderColorLeft(BaseColor.RED);
        hoja.getDefaultCell().setBorderColorRight(BaseColor.RED);
        hoja.getDefaultCell().setBorderWidthTop(0);
        hoja.getDefaultCell().setBorderWidthLeft(4);
        hoja.getDefaultCell().setBorderWidthRight(4);
        hoja.getDefaultCell().setBorderWidthBottom(0);

//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
//        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenido5).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenido6).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenido7).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenido8).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenidoVacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenido9).setBorder(PdfPCell.NO_BORDER);

        hoja.addCell(tablaContenido);

        hoja.getDefaultCell().setBorderColorLeft(BaseColor.RED);
        hoja.getDefaultCell().setBorderColorRight(BaseColor.RED);
        hoja.getDefaultCell().setBorderWidthTop(0);
        hoja.getDefaultCell().setBorderWidthLeft(4);
        hoja.getDefaultCell().setBorderWidthRight(4);
        hoja.getDefaultCell().setBorderWidthBottom(0);

        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
//        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));
//        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));

        hoja.getDefaultCell().setBorderColorLeft(BaseColor.RED);
        hoja.getDefaultCell().setBorderColorRight(BaseColor.RED);
        hoja.getDefaultCell().setBorderWidthTop(0);
        hoja.getDefaultCell().setBorderWidthLeft(4);
        hoja.getDefaultCell().setBorderWidthRight(4);
        hoja.getDefaultCell().setBorderWidthBottom(0);

        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));

        hoja.getDefaultCell().setBorderColorLeft(BaseColor.RED);
        hoja.getDefaultCell().setBorderColorRight(BaseColor.RED);
        hoja.getDefaultCell().setBorderColorBottom(BaseColor.RED);
        hoja.getDefaultCell().setBorderWidthTop(0);
        hoja.getDefaultCell().setBorderWidthLeft(4);
        hoja.getDefaultCell().setBorderWidthRight(4);
        hoja.getDefaultCell().setBorderWidthBottom(4);

        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 12, PLAIN, FONDO_BLANCO)));

        pdf.add(hoja);

        Image imagen = Image.getInstance("c://emitank//logo//firma_emitank.png");
        imagen.setAbsolutePosition(420f, 100f);
        pdf.add(imagen);
        Image imagen1 = Image.getInstance("c://emitank//logo//logo_emitank.png");
        imagen1.setAbsolutePosition(420f, 870f);
        pdf.add(imagen1);

        pdf.close();
        return new File(fileNameFormatted);
    }

    public File testCertificado() throws FileNotFoundException, DocumentException, Exception {
        Document pdf = new Document();

        String fileNameFormatted = "c://emitank//pdf//certif.pdf";
        FileOutputStream ficheroPdf = new FileOutputStream(fileNameFormatted);
        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);
        pdf.setPageSize(hojaA4);
        pdf.setMargins(20, 20, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        pdf.open();
        //titulos 
        PdfPTable hoja = new PdfPTable(1);
        hoja.setWidthPercentage(100);
        float[] ancho = new float[1];
        ancho[0] = 80;
        hoja.setWidths(ancho);

        PdfPTable detalle = new PdfPTable(2);
        detalle.setWidthPercentage(90);
        float[] anchos = new float[2];
        anchos[0] = 60;
        anchos[1] = 30;
        detalle.setWidths(anchos);
        PdfPCell space0 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial",
                11, Font.PLAIN, FONDO_BLANCO)));
        space0.setBorderWidthTop(4);
        space0.setBorderWidthLeft(4);
        space0.setBorderWidthRight(4);
        space0.setBorderWidthBottom(0);
        space0.setBorderColor(BaseColor.RED);
        PdfPCell space1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial",
                11, Font.PLAIN, FONDO_BLANCO)));
        space1.setBorderWidthTop(0);
        space1.setBorderWidthLeft(4);
        space1.setBorderWidthRight(4);
        space1.setBorderWidthBottom(0);
        space1.setBorderColor(BaseColor.RED);

        hoja.addCell(space0);
        hoja.addCell(space1);

        Image imagen = Image.getInstance("c://emitank//logo//firma_emitank.png");
        imagen.setAbsolutePosition(420f, 100f);

        String l1 = "Besares 1717 - (1111) Capital Federal";
        String l2 = " ";
        String l3 = "Tel: 4704-0685 - Cel.:15-4427-1411";
        String l4 = " ";
        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph(l1, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph(l2, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph(l3, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph(l4, FontFactory.getFont("arial",
                11, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        detalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        detalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        detalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        detalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);

        hoja.getDefaultCell().setBorderColorLeft(BaseColor.RED);
        hoja.getDefaultCell().setBorderColorRight(BaseColor.RED);
        hoja.getDefaultCell().setBorderWidthTop(0);
        hoja.getDefaultCell().setBorderWidthLeft(4);
        hoja.getDefaultCell().setBorderWidthRight(4);
        hoja.getDefaultCell().setBorderWidthBottom(0);

        hoja.addCell(detalle);

        pdf.add(hoja);
//        pdf.add(detalle);
        pdf.add(imagen);
        pdf.close();
        return new File(fileNameFormatted);
    }

    public File armarCertificado3(Trabajo trabajo) throws FileNotFoundException, DocumentException, Exception {
        Document pdf = new Document();
        List<RenglonTrabajo> renglones = null;
        renglones = new RenglonTrabajoService().getRenglonesByTrabajoActivo(trabajo);
        Boolean fisico = false;
        Boolean bacterio = false;
        for (RenglonTrabajo rt : renglones) {
            if (rt.getCodigoCampo().equals(15)) {
                if (rt.getContenido().equals("SI")) {
                    bacterio = true;
                }
            }
            if (rt.getCodigoCampo().equals(16)) {
                if (rt.getContenido().equals("SI")) {
                    fisico = true;
                }
            }
        }
        Domicilio dm = trabajo.getServicio().getConsorcio().getDomicilio();
        String calleConsorcio = dm.getCalle() + " " + dm.getNumero();
        String fecha = sdf.format(trabajo.getFecha());
        String fecha2 = sdf2.format(trabajo.getFecha());
        String dm2 = dm.getCalle() + "_" + dm.getNumero().replace("/", "-");
        Administrador adm = trabajo.getServicio().getConsorcio().getAdministrador();
        String dm3 = adm.getRazonSocial().replaceAll(" ", "_");
        String fileNameFormatted = "c://SYSTEM//CERTIFICADOS//CERTIFICADO" + "_" + dm3 + "_" + dm2 + "_" + fecha2 + ".pdf";
        FileOutputStream ficheroPdf = new FileOutputStream(fileNameFormatted);
        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);
        pdf.setPageSize(hojaA4);
        pdf.setMargins(20, 20, 20, 20);
        pdf.setMarginMirroringTopBottom(true);

        pdf.open();

        PdfPTable hoja = new PdfPTable(1);
        hoja.setWidthPercentage(100);

        float[] anchos = new float[2];
        anchos[0] = 60;
        anchos[1] = 30;

        PdfPTable tablaDetalle = new PdfPTable(2);
        tablaDetalle.setWidthPercentage(95);
        tablaDetalle.setWidths(anchos);

        hoja.getDefaultCell().setBorderWidthTop(0);
        hoja.getDefaultCell().setBorderWidthLeft(0);
        hoja.getDefaultCell().setBorderWidthRight(0);
        hoja.getDefaultCell().setBorderWidthBottom(0);

        for (int i = 0; i < 36; i++) {
            hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        }
        hoja.addCell(new Paragraph(" ", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        // contenido
        PdfPTable tablaContenido = new PdfPTable(1);
        float[] anchos2 = new float[1];
        anchos2[0] = 95;
        tablaContenido.setWidthPercentage(95);
        tablaContenido.setWidths(anchos2);

        String me[] = new String[12];
        int ro = 0;
        for (Mes me1 : Mes.values()) {
            me[ro] = me1.toString();
            ro += 1;
        }
        String dia;
        String mes;
        String anio;
        int y = Calendar.getInstance().get(Calendar.YEAR);
        int d = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int m = Calendar.getInstance().get(Calendar.MONTH);
        dia = dfc.format(d);

        anio = dfs.format(y);
//        if(m < 1){
//            m = 12;
//            y -= 1;
//        }
        mes = me[m];
        String c1 = "                                                                  " + fecha;
        String c3 = "    " + calleConsorcio + " de la Ciudad Autónoma de Buenos Aires.";
        String c5 = "     RESULTADO DE LOS ENSAYOS BACTERIOLOGICOS: POTABLE";
        String c6 = "     RESULTADO DE LOS ENSAYOS FISICO QUIMICO: POTABLE";
        String c9 = "                                " + dia + " días del mes de " + mes + " de " + anio;

        PdfPCell vacio = new PdfPCell(new Paragraph(" ", FontFactory.getFont("c://SYSTEM//FONTS//baskvill.ttf",
                16, Font.BOLD, FONDO_BLANCO)));
        PdfPCell vacio_x2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("c://SYSTEM//FONTS//baskvill.ttf",
                12, Font.BOLD, FONDO_BLANCO)));
        PdfPCell vacio_x3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("c://SYSTEM//FONTS//baskvill.ttf",
                8, Font.BOLD, FONDO_BLANCO)));
        PdfPCell vacio_x = new PdfPCell(new Paragraph(" ", FontFactory.getFont("c://SYSTEM//FONTS//baskvill.ttf",
                9, Font.BOLD, FONDO_BLANCO)));
        PdfPCell vacio_x1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("c://SYSTEM//FONTS//baskvill.ttf",
                10, Font.BOLD, FONDO_BLANCO)));
        PdfPCell celdaContenido1 = new PdfPCell(new Paragraph(c1, FontFactory.getFont("c://SYSTEM//FONTS//baskvill.ttf",
                15, Font.BOLD, GRIS)));
        PdfPCell celdaContenido3 = new PdfPCell(new Paragraph(c3, FontFactory.getFont("c://SYSTEM//FONTS//baskvill.ttf",
                18, Font.BOLD, GRIS)));
        PdfPCell celdaContenido5 = new PdfPCell(new Paragraph(c5, FontFactory.getFont("c://SYSTEM//FONTS//baskvill.ttf",
                16, Font.BOLD, GRIS)));
        PdfPCell celdaContenido6 = new PdfPCell(new Paragraph(c6, FontFactory.getFont("c://SYSTEM//FONTS//baskvill.ttf",
                16, Font.BOLD, GRIS)));
        PdfPCell celdaContenido9 = new PdfPCell(new Paragraph(c9, FontFactory.getFont("c://SYSTEM//FONTS//baskvill.ttf",
                15, Font.BOLD, GRIS)));

        celdaContenido1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaContenido9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        tablaContenido.addCell(celdaContenido1).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(vacio_x).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(vacio_x1).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenido3).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(vacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(vacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(vacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(vacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(vacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(vacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(vacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(vacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(vacio_x2).setBorder(PdfPCell.NO_BORDER);

        if (bacterio) {
            tablaContenido.addCell(celdaContenido5).setBorder(PdfPCell.NO_BORDER);
        } else {
            tablaContenido.addCell(vacio).setBorder(PdfPCell.NO_BORDER);
        }
        tablaContenido.addCell(vacio_x).setBorder(PdfPCell.NO_BORDER);
        if (fisico) {
            tablaContenido.addCell(celdaContenido6).setBorder(PdfPCell.NO_BORDER);
        } else {
            tablaContenido.addCell(vacio).setBorder(PdfPCell.NO_BORDER);
        }
        tablaContenido.addCell(vacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(vacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(vacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(vacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(vacio_x3).setBorder(PdfPCell.NO_BORDER);
//        tablaContenido.addCell(vacio).setBorder(PdfPCell.NO_BORDER);
        tablaContenido.addCell(celdaContenido9).setBorder(PdfPCell.NO_BORDER);

        hoja.addCell(tablaContenido);

        pdf.add(hoja);

        Image imagen = Image.getInstance("c://SYSTEM//BASE//base_certificado.png");
        imagen.setAbsolutePosition(1f, 0f);
        pdf.add(imagen);

        pdf.close();
        return new File(fileNameFormatted);
    }
}
