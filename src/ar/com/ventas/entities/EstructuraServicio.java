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
public class EstructuraServicio {
    private Long id;
    private Estructura estructura;
    private Integer orden;
    private Integer campoEstructura;
    private String contenido;
    private Boolean visible;
    private Boolean activo;

    public EstructuraServicio() {
    }

    public EstructuraServicio(Long id, Integer orden,Estructura estructura, Integer campoEstructura, String contenido, Boolean visible, Boolean activo) {
        this.id = id;
        this.estructura = estructura;
        this.orden=orden;
        this.campoEstructura = campoEstructura;
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

    public Estructura getEstructura() {
        return estructura;
    }

    public void setEstructura(Estructura estructura) {
        this.estructura = estructura;
    }

    public Integer getCampoEstructura() {
        return campoEstructura;
    }

    public void setCampoEstructura(Integer campoEstructura) {
        this.campoEstructura = campoEstructura;
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
    
    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
    
    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}