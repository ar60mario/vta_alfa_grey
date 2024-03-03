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
public class RenglonTrabajoReparacion {
    private Long id;
    private Comprobante comprobante;
    private Integer orden;
    private Date fecha;
    private String contenido;
    private Double importe;
    private Boolean visible;
    private Boolean activo;

    public RenglonTrabajoReparacion() {
    }

    public RenglonTrabajoReparacion(Long id, Comprobante comprobante, Integer orden, Date fecha, String contenido, Double importe, Boolean visible, Boolean activo) {
        this.id = id;
        this.comprobante = comprobante;
        this.orden = orden;
        this.fecha = fecha;
        this.contenido = contenido;
        this.importe = importe;
        this.visible = visible;
        this.activo = activo;
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

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}