/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.entities;

import java.util.Date;

/**
 *
 * @author Mario
 */
public class CuentaCorrienteCliente {
    private Long id;
    private Consorcio consorcio;
    private Date fecha;
    private Double debe;
    private Double haber;
    private Double saldo;
    private Integer tipoComprobante;
    private Comprobante comprobante;
    private Recibo recibo;

    /*
    Tipo comprobante
    1 FC 11
    2 NC 13
    3 ND
    4 RE
    5 RX
    */
    
    public CuentaCorrienteCliente() {
    }

    public CuentaCorrienteCliente(Long id, Consorcio consorcio, Date fecha, Double debe, Double haber, Double saldo, Integer tipoComprobante, Comprobante comprobante, Recibo recibo) {
        this.id = id;
        this.consorcio = consorcio;
        this.fecha = fecha;
        this.debe = debe;
        this.haber = haber;
        this.saldo = saldo;
        this.tipoComprobante = tipoComprobante;
        this.comprobante = comprobante;
        this.recibo = recibo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Consorcio getConsorcio() {
        return consorcio;
    }

    public void setConsorcio(Consorcio consorcio) {
        this.consorcio = consorcio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getDebe() {
        return debe;
    }

    public void setDebe(Double debe) {
        this.debe = debe;
    }

    public Double getHaber() {
        return haber;
    }

    public void setHaber(Double haber) {
        this.haber = haber;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(Integer tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public Recibo getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }

}
