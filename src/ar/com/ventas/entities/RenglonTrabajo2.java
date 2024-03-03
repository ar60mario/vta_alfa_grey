/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.entities;

import ar.com.ventas.estructuras.CampoEstructura;
import ar.com.ventas.estructuras.CampoEstructura2;
import java.util.Date;

/**
 *
 * @author Mario
 */
public class RenglonTrabajo2 {
    private Long id;
    private Trabajo trabajo;
    private Date fecha;
    private Integer codigoCampo;
    private String campo;
    private String contenido;
    private Boolean activo;
    private CampoEstructura2 campoEstructura;

    public RenglonTrabajo2() {
    }

    public RenglonTrabajo2(Long id, Trabajo trabajo, Date fecha, Integer codigoCampo, String campo, String contenido, Boolean activo) {
        this.id = id;
        this.trabajo = trabajo;
        this.fecha = fecha;
        this.codigoCampo = codigoCampo;
        this.campo = campo;
        this.contenido = contenido;
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public CampoEstructura2 getCampoEstructura() {
        return campoEstructura;
    }

    public void setCampoEstructura(CampoEstructura2 campoEstructura) {
        this.campoEstructura = campoEstructura;
    }
    
    
}
