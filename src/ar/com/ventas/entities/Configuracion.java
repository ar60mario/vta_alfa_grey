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
public class Configuracion {

    private Long id;
    private Integer nroRecibo;
    private Integer nroCertificado;
    private Integer nroRenovaciones;
    private Integer nroLaboratorio;
    private Integer nroPersonas;
    private Integer nroFc;
    private Integer nroRx;

    public Configuracion() {
    }

    public Configuracion(Integer nroFc, Long id, Integer nroRecibo, Integer nroCertificado, Integer nroRenovaciones, Integer nroLaboratorio, Integer nroPersonas, Integer nroRx) {
        this.id = id;
        this.nroRecibo = nroRecibo;
        this.nroCertificado = nroCertificado;
        this.nroRenovaciones = nroRenovaciones;
        this.nroLaboratorio = nroLaboratorio;
        this.nroPersonas = nroPersonas;
        this.nroFc=nroFc;
        this.nroRx = nroRx;
    }

    public Integer getNroFc() {
        return nroFc;
    }

    public void setNroFc(Integer nroFc) {
        this.nroFc = nroFc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNroRecibo() {
        return nroRecibo;
    }

    public void setNroRecibo(Integer nroRecibo) {
        this.nroRecibo = nroRecibo;
    }

    public Integer getNroCertificado() {
        return nroCertificado;
    }

    public void setNroCertificado(Integer nroCertificado) {
        this.nroCertificado = nroCertificado;
    }

    public Integer getNroRenovaciones() {
        return nroRenovaciones;
    }

    public void setNroRenovaciones(Integer nroRenovaciones) {
        this.nroRenovaciones = nroRenovaciones;
    }
    
    public Integer getNroLaboratorio() {
        return nroLaboratorio;
    }

    public void setNroLaboratorio(Integer nroLaboratorio) {
        this.nroLaboratorio = nroLaboratorio;
    }
    
    public Integer getNroPersonas() {
        return nroPersonas;
    }

    public void setNroPersonas(Integer nroPersonas) {
        this.nroPersonas = nroPersonas;
    }

    public Integer getNroRx() {
        return nroRx;
    }

    public void setNroRx(Integer nroRx) {
        this.nroRx = nroRx;
    }

}
