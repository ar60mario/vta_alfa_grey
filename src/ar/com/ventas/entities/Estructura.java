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
public class Estructura {
    private Long id;
    private String nombre;
    private String textoFactura;
    private String observaciones;
    private Boolean activo;

    public Estructura() {
    }

    public Estructura(Long id, String nombre, String textoFactura, String observaciones, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.textoFactura = textoFactura;
        this.observaciones = observaciones;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTextoFactura() {
        return textoFactura;
    }

    public void setTextoFactura(String textoFactura) {
        this.textoFactura = textoFactura;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}