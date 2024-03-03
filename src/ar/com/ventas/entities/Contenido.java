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
public class Contenido {
    private Long id;
    private Servicio trabajo;
    private Long concepto;
    private String contenido;

    public Contenido() {
    }

    public Contenido(Long id, Servicio trabajo, Long concepto, String contenido) {
        this.id = id;
        this.trabajo = trabajo;
        this.concepto = concepto;
        this.contenido = contenido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Servicio getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Servicio trabajo) {
        this.trabajo = trabajo;
    }

    public Long getConcepto() {
        return concepto;
    }

    public void setConcepto(Long concepto) {
        this.concepto = concepto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
}
