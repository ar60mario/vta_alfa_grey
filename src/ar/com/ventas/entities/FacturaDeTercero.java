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
public class FacturaDeTercero {
    private Long id;
    private Date fecha;
    private Integer numero;
    private String proveedor;
    private Double total;
    private Double importeCobrado;
    private Boolean cobrada;
    private Boolean entregada;
    private Consorcio consorcio;

    public FacturaDeTercero() {
    }

    public FacturaDeTercero(Long id, Date fecha, Integer numero, String proveedor, Double total, Double importeCobrado, Boolean cobrada, Boolean entregada, Consorcio consorcio) {
        this.id = id;
        this.fecha = fecha;
        this.numero = numero;
        this.proveedor = proveedor;
        this.total = total;
        this.importeCobrado = importeCobrado;
        this.cobrada = cobrada;
        this.entregada = entregada;
        this.consorcio = consorcio;
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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getImporteCobrado() {
        return importeCobrado;
    }

    public void setImporteCobrado(Double importeCobrado) {
        this.importeCobrado = importeCobrado;
    }

    public Boolean getCobrada() {
        return cobrada;
    }

    public void setCobrada(Boolean cobrada) {
        this.cobrada = cobrada;
    }

    public Boolean getEntregada() {
        return entregada;
    }

    public void setEntregada(Boolean entregada) {
        this.entregada = entregada;
    }

    public Consorcio getConsorcio() {
        return consorcio;
    }

    public void setConsorcio(Consorcio consorcio) {
        this.consorcio = consorcio;
    }

}