/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.entities;

/**
 *
 * @author Mario
 */
public class RcCo {
    private Long id;
    private Double totalRecibo;
    private Double totalComprobante;
    private Double aplicadoRecibo;
    private Double aplicadoComprobante;
    private Recibo recibo;
    private Comprobante comprobante;

    public RcCo() {
    }

    public RcCo(Long id, Double totalRecibo, Double totalComprobante, Recibo recibo, Comprobante comprobante) {
        this.id = id;
        this.totalRecibo = totalRecibo;
        this.totalComprobante = totalComprobante;
        this.recibo = recibo;
        this.comprobante = comprobante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalRecibo() {
        return totalRecibo;
    }

    public void setTotalRecibo(Double totalRecibo) {
        this.totalRecibo = totalRecibo;
    }

    public Double getTotalComprobante() {
        return totalComprobante;
    }

    public void setTotalComprobante(Double totalComprobante) {
        this.totalComprobante = totalComprobante;
    }

    public Recibo getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }
    
}
