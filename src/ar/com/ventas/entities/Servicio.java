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
public class Servicio {

    private Long id;
    private Date fecha;
    private Consorcio consorcio;
    private Rubro rubro;
    private Integer cantidadCuotas;
    private Integer periodicidad;
    private String caracteristicas;
    private Double importe;
    private Boolean fisicoQuimico;
    private Boolean bacteriologico;
    private Date ultimoTrabajo;
    private Boolean trabajoCreado;
    private Importe importe1;
    private Importe importe2;
    private Boolean activo;

    public Servicio() {
    }

    public Servicio(Long id, Date fecha, Consorcio consorcio, Rubro rubro, Integer cantidadCuotas, Integer periodicidad, String caracteristicas, Double importe, Boolean fisicoQuimico, Boolean bacteriologico, Date ultimoTrabajo, Boolean trabajoCreado, Importe importe1, Importe importe2, Boolean activo) {
        this.id = id;
        this.fecha = fecha;
        this.consorcio = consorcio;
        this.rubro = rubro;
        this.cantidadCuotas = cantidadCuotas;
        this.periodicidad = periodicidad;
        this.caracteristicas = caracteristicas;
        this.importe = importe;
        this.fisicoQuimico = fisicoQuimico;
        this.bacteriologico = bacteriologico;
        this.ultimoTrabajo = ultimoTrabajo;
        this.trabajoCreado = trabajoCreado;
        this.importe1 = importe1;
        this.importe2 = importe2;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Integer getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(Integer cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public Integer getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(Integer periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Boolean getFisicoQuimico() {
        return fisicoQuimico;
    }

    public void setFisicoQuimico(Boolean fisicoQuimico) {
        this.fisicoQuimico = fisicoQuimico;
    }

    public Boolean getBacteriologico() {
        return bacteriologico;
    }

    public void setBacteriologico(Boolean bacteriologico) {
        this.bacteriologico = bacteriologico;
    }

    public Date getUltimoTrabajo() {
        return ultimoTrabajo;
    }

    public void setUltimoTrabajo(Date ultimoTrabajo) {
        this.ultimoTrabajo = ultimoTrabajo;
    }

    public Boolean getTrabajoCreado() {
        return trabajoCreado;
    }

    public void setTrabajoCreado(Boolean trabajoCreado) {
        this.trabajoCreado = trabajoCreado;
    }

    public Importe getImporte1() {
        return importe1;
    }

    public void setImporte1(Importe importe1) {
        this.importe1 = importe1;
    }

    public Importe getImporte2() {
        return importe2;
    }

    public void setImporte2(Importe importe2) {
        this.importe2 = importe2;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}