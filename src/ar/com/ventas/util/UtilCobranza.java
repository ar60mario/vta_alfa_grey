/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.util;

import ar.com.ventas.entities.Comprobante;
import ar.com.ventas.entities.Consorcio;
import ar.com.ventas.entities.CuentaCorrienteCliente;
import ar.com.ventas.entities.RcCo;
import ar.com.ventas.entities.Recibo;
import ar.com.ventas.services.ComprobanteService;
import ar.com.ventas.services.ConsorcioService;
import ar.com.ventas.services.CuentaCorrienteClienteService;
import ar.com.ventas.services.RcCoService;
import ar.com.ventas.services.ReciboService;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class UtilCobranza {

    private static DecimalFormat df = new DecimalFormat("#0.00");
    private static DecimalFormat dfs = new DecimalFormat("0000");
    private static DecimalFormat dfn = new DecimalFormat("00000000");

    public static Integer aplicarCobranzaByComprobante(Comprobante comprobante, Double cobrado) {

        Integer nro;
        try {
            nro = new ReciboService().getCodigoSiguiente();
        } catch (Exception ex) {
            Logger.getLogger(UtilCobranza.class.getName()).log(Level.SEVERE, null, ex);
            return 2;
        }
        Integer codigoConsorcio = comprobante.getCodigoCliente();
        Consorcio consorcio = null;
        try {
            consorcio = new ConsorcioService().getConsorcioByCodigo(codigoConsorcio);
        } catch (Exception ex) {
            Logger.getLogger(UtilCobranza.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
        String cuo = comprobante.getCuotasPagadas().toString();
        String nuf = dfs.format(comprobante.getSucursal()) + "-"
                + dfn.format(comprobante.getNumero());
        Recibo rc = new Recibo();
        RcCo rc_co = new RcCo();
        CuentaCorrienteCliente ccc = new CuentaCorrienteCliente();
        BigDecimal saldo = new BigDecimal(df.format(consorcio.getSaldo()).replace(",", "."));
        BigDecimal cobro = new BigDecimal(df.format(cobrado).replace(",", "."));
        BigDecimal totalComprobante = new BigDecimal(df.format(comprobante.getTotal()).replace(",", "."));
        BigDecimal cobroAntes = new BigDecimal(df.format(comprobante.getPagado()).replace(",", "."));
        BigDecimal dif = (totalComprobante.subtract(cobroAntes)).subtract(cobro);
        if(dif.doubleValue() >= 0.00){
            BigDecimal n_saldo = saldo.subtract(cobro);
            comprobante.setPagado(cobroAntes.add(cobro).doubleValue());
            rc.setConsorcio(consorcio);
            rc.setFecha(new Date());
            rc.setImporte(cobro.doubleValue());
            rc.setReferencia("COBRANZA_FC_" + nuf + "_" + cuo);
            rc.setNumero(nro);
            rc.setAplicado(cobro.doubleValue());
            rc_co.setComprobante(comprobante);
            rc_co.setRecibo(rc);
            rc_co.setTotalComprobante(totalComprobante.doubleValue());
            rc_co.setTotalRecibo(cobro.doubleValue());
            ccc.setComprobante(comprobante);
            ccc.setConsorcio(consorcio);
            ccc.setDebe(0.0);
            ccc.setFecha(new Date());
            ccc.setHaber(cobro.doubleValue());
            ccc.setSaldo(n_saldo.doubleValue());
            ccc.setTipoComprobante(14);
            consorcio.setSaldo(n_saldo.doubleValue());
            try {
                new ConsorcioService().updateConsorcio(consorcio);
                rc = new ReciboService().saveRecibo(rc);
                new ComprobanteService().updateComprobante(comprobante);
                ccc.setRecibo(rc);
                new CuentaCorrienteClienteService().saveCuentaCorrienteCliente(ccc);
                new RcCoService().saveRecibo(rc_co);
            } catch (Exception ex) {
                Logger.getLogger(UtilCobranza.class.getName()).log(Level.SEVERE, null, ex);
                return 2;
            }
        }
        return 0;
    }
}
