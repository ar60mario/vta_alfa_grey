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
public class CategoriaMonotributo {
    private Long id;
    private String categoria;
    private Date fechaActualizacion;
    private Double ingresosBrutos;
    private Boolean activo;

    public CategoriaMonotributo() {
    }

    public CategoriaMonotributo(Long id, String categoria, Date fechaActualizacion, Double ingresosBrutos, Boolean activo) {
        this.id = id;
        this.categoria = categoria;
        this.fechaActualizacion = fechaActualizacion;
        this.ingresosBrutos = ingresosBrutos;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Double getIngresosBrutos() {
        return ingresosBrutos;
    }

    public void setIngresosBrutos(Double ingresosBrutos) {
        this.ingresosBrutos = ingresosBrutos;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    
}
