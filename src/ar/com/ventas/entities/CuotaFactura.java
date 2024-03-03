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
public class CuotaFactura {

    private Long id;
    private Comprobante comprobante;
    private Date fechaDeVencimiento;
    private Double importeCuota;
    private Double importePagado;
    private boolean cancelada;

    public CuotaFactura() {
    }

    public CuotaFactura(Long id, Comprobante comprobante, Date fechaDeVencimiento, Double importeCuota, Double importePagado, boolean cancelada) {
        this.id = id;
        this.comprobante = comprobante;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.importeCuota = importeCuota;
        this.importePagado = importePagado;
        this.cancelada = cancelada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public Date getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(Date fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public Double getImporteCuota() {
        return importeCuota;
    }

    public void setImporteCuota(Double importeCuota) {
        this.importeCuota = importeCuota;
    }

    public Double getImportePagado() {
        return importePagado;
    }

    public void setImportePagado(Double importePagado) {
        this.importePagado = importePagado;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

}
