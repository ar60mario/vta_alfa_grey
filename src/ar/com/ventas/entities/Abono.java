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
public class Abono {

    private Long id;
    private Integer codigo;
    private Date fechaInicio;
    private Date fechaPeriodo;
    private Integer textoPeriodo;
    private Boolean activo;
    private Boolean renovado;
    private Boolean pendiente;
    private Double importe;
    private Integer cuotas;
    private Integer cuotaFacturada;
    private Integer frecuencia;
    private Integer tipoFacturacion;
    private Consorcio consorcio;
    private Integer original;
    private TitularCuit titular;
    private Rubro rubro;


    /*
    frecuencia
    1- todos los meses
    2- mes por medio
    6- cada 6 meses
    etc desde fechaInicio
    
    tipo de Facturacion
    1- 1 fc y varios recibos
    2- 1 fc x mes
    3- 1 rc x mes
    4- fc unica (reparacion)
    5- rc unico (reparacion-matafuego)

    Nota: factura/recibo unico puede estar dividida en cuotas, pero no se renueva como los abonos. 
    
    original
    1-original
    2-asignado
    3 null
     */
    public Abono() {
    }

    public Abono(Long id, Integer codigo, Date fechaInicio, Date fechaPeriodo, Boolean activo,
            Boolean renovado, Boolean pendiente, Double importe, Integer cuotas, Integer cuotaFacturada,
            Integer frecuencia, Integer tipoFacturacion, Consorcio consorcio,
            Rubro rubro, Integer textoPeriodo, TitularCuit titular, Integer original) {
        this.id = id;
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaPeriodo = fechaPeriodo;
        this.activo = activo;
        this.renovado = renovado;
        this.pendiente = pendiente;
        this.importe = importe;
        this.cuotas = cuotas;
        this.cuotaFacturada = cuotaFacturada;
        this.frecuencia = frecuencia;
        this.tipoFacturacion = tipoFacturacion;
        this.consorcio = consorcio;
        this.rubro = rubro;
        this.original = original;
        this.titular = titular;
        this.textoPeriodo = textoPeriodo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaPeriodo() {
        return fechaPeriodo;
    }

    public void setFechaPeriodo(Date fechaPeriodo) {
        this.fechaPeriodo = fechaPeriodo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getRenovado() {
        return renovado;
    }

    public void setRenovado(Boolean renovado) {
        this.renovado = renovado;
    }

    public Boolean getPendiente() {
        return pendiente;
    }

    public void setPendiente(Boolean pendiente) {
        this.pendiente = pendiente;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }

    public Integer getCuotaFacturada() {
        return cuotaFacturada;
    }

    public void setCuotaFacturada(Integer cuotaFacturada) {
        this.cuotaFacturada = cuotaFacturada;
    }

    public Integer getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Integer getTipoFacturacion() {
        return tipoFacturacion;
    }

    public void setTipoFacturacion(Integer tipoFacturacion) {
        this.tipoFacturacion = tipoFacturacion;
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

    public Integer getOriginal() {
        return original;
    }

    public void setOriginal(Integer original) {
        this.original = original;
    }

    public TitularCuit getTitular() {
        return titular;
    }

    public void setTitular(TitularCuit titular) {
        this.titular = titular;
    }

    public Integer getTextoPeriodo() {
        return textoPeriodo;
    }

    public void setTextoPeriodo(Integer textoPeriodo) {
        this.textoPeriodo = textoPeriodo;
    }

}
