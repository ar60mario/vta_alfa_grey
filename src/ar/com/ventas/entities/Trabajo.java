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
public class Trabajo {

    private Long id;
    private Date fecha;
    private Servicio servicio;
    private Integer cuota;
    private String textoEnFactura;
    private Boolean facturaEmitida;
    private Boolean reciboEmitido;
    private Boolean pdfGenerado;
    private Boolean renovado;
    private Boolean activo;

    public Trabajo() {
    }

    public Trabajo(Long id, Date fecha, Servicio servicio, Integer cuota, String textoEnFactura, Boolean facturaEmitida, Boolean reciboEmitido, Boolean pdfGenerado, Boolean renovado, Boolean activo) {
        this.id = id;
        this.fecha = fecha;
        this.servicio = servicio;
        this.cuota = cuota;
        this.textoEnFactura = textoEnFactura;
        this.facturaEmitida = facturaEmitida;
        this.reciboEmitido = reciboEmitido;
        this.pdfGenerado = pdfGenerado;
        this.renovado = renovado;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Integer getCuota() {
        return cuota;
    }

    public void setCuota(Integer cuota) {
        this.cuota = cuota;
    }

    public String getTextoEnFactura() {
        return textoEnFactura;
    }

    public void setTextoEnFactura(String textoEnFactura) {
        this.textoEnFactura = textoEnFactura;
    }

    public Boolean getFacturaEmitida() {
        return facturaEmitida;
    }

    public void setFacturaEmitida(Boolean facturaEmitida) {
        this.facturaEmitida = facturaEmitida;
    }

    public Boolean getReciboEmitido() {
        return reciboEmitido;
    }

    public void setReciboEmitido(Boolean reciboEmitido) {
        this.reciboEmitido = reciboEmitido;
    }

    public Boolean getPdfGenerado() {
        return pdfGenerado;
    }

    public void setPdfGenerado(Boolean pdfGenerado) {
        this.pdfGenerado = pdfGenerado;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setRenovado(Boolean renovado) {
        this.renovado = renovado;
    }

    public Boolean getRenovado() {
        return renovado;
    }
}
