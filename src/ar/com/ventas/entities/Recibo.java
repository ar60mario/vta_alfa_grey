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
public class Recibo {
    private Long id;
    private Date fecha;
    private Double importe;
    private Double aplicado;
    private Consorcio consorcio;
    private Integer numero;
    private String referencia;

    public Recibo() {
    }

    public Recibo(Long id, Date fecha, Double importe, Double aplicado, Consorcio consorcio, Integer numero, String referencia) {
        this.id = id;
        this.fecha = fecha;
        this.importe = importe;
        this.aplicado = aplicado;
        this.consorcio = consorcio;
        this.numero = numero;
        this.referencia = referencia;
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

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getAplicado() {
        return aplicado;
    }

    public void setAplicado(Double aplicado) {
        this.aplicado = aplicado;
    }

    public Consorcio getConsorcio() {
        return consorcio;
    }

    public void setConsorcio(Consorcio consorcio) {
        this.consorcio = consorcio;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
}
