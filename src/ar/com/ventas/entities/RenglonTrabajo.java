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
public class RenglonTrabajo {
    private Long id;
    private Trabajo trabajo;
    private Integer orden;
    private Date fecha;
    private Integer codigoCampo;
    private String campo;
    private String contenido;
    private Boolean visible;
    private Boolean activo;

    public RenglonTrabajo() {
    }

    public RenglonTrabajo(Long id, Trabajo trabajo, Integer orden, Date fecha, Integer codigoCampo, String campo, String contenido, Boolean visible, Boolean activo) {
        this.id = id;
        this.trabajo = trabajo;
        this.orden = orden;
        this.fecha = fecha;
        this.codigoCampo = codigoCampo;
        this.campo = campo;
        this.contenido = contenido;
        this.visible = visible;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trabajo getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
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

    public Integer getCodigoCampo() {
        return codigoCampo;
    }

    public void setCodigoCampo(Integer codigoCampo) {
        this.codigoCampo = codigoCampo;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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