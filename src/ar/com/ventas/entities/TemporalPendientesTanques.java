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
public class TemporalPendientesTanques {
    private Long id;
    private String consorcio;
    private Date fechaLimpieza;
    private String bacteriologico;
    private String fisico;
    private String encargado;
    private String telefono;

    public TemporalPendientesTanques() {
    }

    public TemporalPendientesTanques(Long id, String consorcio, Date fechaLimpieza, String bacteriologico, String fisico, String encargado, String telefono) {
        this.id = id;
        this.consorcio = consorcio;
        this.fechaLimpieza = fechaLimpieza;
        this.bacteriologico = bacteriologico;
        this.fisico = fisico;
        this.encargado = encargado;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConsorcio() {
        return consorcio;
    }

    public void setConsorcio(String consorcio) {
        this.consorcio = consorcio;
    }

    public Date getFechaLimpieza() {
        return fechaLimpieza;
    }

    public void setFechaLimpieza(Date fechaLimpieza) {
        this.fechaLimpieza = fechaLimpieza;
    }

    public String getBacteriologico() {
        return bacteriologico;
    }

    public void setBacteriologico(String bacteriologico) {
        this.bacteriologico = bacteriologico;
    }

    public String getFisico() {
        return fisico;
    }

    public void setFisico(String fisico) {
        this.fisico = fisico;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
