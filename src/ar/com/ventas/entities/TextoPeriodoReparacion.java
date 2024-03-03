/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.entities;

/**
 *
 * @author argia
 */
public class TextoPeriodoReparacion {
    private Long id;
    private Consorcio consorcio;
    private Rubro rubro;
    private Boolean llevaTextoPeriodo;
    private Integer periodoMesActual;

    public TextoPeriodoReparacion() {
    }

    public TextoPeriodoReparacion(Long id, Consorcio consorcio, Rubro rubro, Boolean llevaTextoPeriodo, Integer periodoMesActual) {
        this.id = id;
        this.consorcio = consorcio;
        this.rubro = rubro;
        this.llevaTextoPeriodo = llevaTextoPeriodo;
        this.periodoMesActual = periodoMesActual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Consorcio getConsorcio() {
        return consorcio;
    }

    public void setConsorcio(Consorcio consorcio) {
        this.consorcio = consorcio;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public Boolean getLlevaTextoPeriodo() {
        return llevaTextoPeriodo;
    }

    public void setLlevaTextoPeriodo(Boolean llevaTextoPeriodo) {
        this.llevaTextoPeriodo = llevaTextoPeriodo;
    }

    public Integer getPeriodoMesActual() {
        return periodoMesActual;
    }

    public void setPeriodoMesActual(Integer periodoMesActual) {
        this.periodoMesActual = periodoMesActual;
    }
    
    
}
