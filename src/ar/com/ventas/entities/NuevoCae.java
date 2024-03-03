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
public class NuevoCae {

    private Long cae;
    private Date fechaCae;
    private Date fechaPeriodoDesde;
    private Date fechaPeriodoHasta;
    private Date fechaVencimientoPago;
    private Date fechaVencimiento;
    private String estado;
    private String Observaciones;
    private String excepcion;
    private String errMsj;
    private Integer sucursal;
    private Integer numero;
    private String motivo;

    public NuevoCae() {
    }

    public NuevoCae(Long cae, Date fechaCae, Date fechaPeriodoDesde, Date fechaPeriodoHasta,
             Date fechaVencimientoPago, Date fechaVencimiento, String estado, String excepcion,
             String errMsj, Integer sucursal, Integer numero, String motivo, String Observaciones) {
        this.cae = cae;
        this.fechaCae = fechaCae;
        this.fechaPeriodoDesde = fechaPeriodoDesde;
        this.fechaPeriodoHasta = fechaPeriodoHasta;
        this.fechaVencimientoPago = fechaVencimientoPago;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
        this.Observaciones = Observaciones;
        this.excepcion = excepcion;
        this.errMsj = errMsj;
        this.sucursal = sucursal;
        this.numero = numero;
        this.motivo = motivo;
    }

    public Long getCae() {
        return cae;
    }

    public void setCae(Long cae) {
        this.cae = cae;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCae() {
        return fechaCae;
    }

    public void setFechaCae(Date fechaCae) {
        this.fechaCae = fechaCae;
    }

    public String getExcepcion() {
        return excepcion;
    }

    public void setExcepcion(String excepcion) {
        this.excepcion = excepcion;
    }

    public String getErrMsj() {
        return errMsj;
    }

    public void setErrMsj(String errMsj) {
        this.errMsj = errMsj;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFechaPeriodoDesde() {
        return fechaPeriodoDesde;
    }

    public void setFechaPeriodoDesde(Date fechaPeriodoDesde) {
        this.fechaPeriodoDesde = fechaPeriodoDesde;
    }

    public Date getFechaPeriodoHasta() {
        return fechaPeriodoHasta;
    }

    public void setFechaPeriodoHasta(Date fechaPeriodoHasta) {
        this.fechaPeriodoHasta = fechaPeriodoHasta;
    }

    public Date getFechaVencimientoPago() {
        return fechaVencimientoPago;
    }

    public void setFechaVencimientoPago(Date fechaVencimientoPago) {
        this.fechaVencimientoPago = fechaVencimientoPago;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}
