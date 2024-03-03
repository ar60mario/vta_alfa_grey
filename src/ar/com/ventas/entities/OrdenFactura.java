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
public class OrdenFactura {

    private Long id;
    private Trabajo trabajo;
    private Double importe;
    private Integer cantidadCuotas;
    private Boolean cobranzaPorRecibo;
    private String textoFactura;
    private Boolean activo;

    public OrdenFactura() {
    }

    public OrdenFactura(Long id, Trabajo trabajo, Double importe, Integer cantidadCuotas, Boolean cobranzaPorRecibo, String textoFactura, Boolean activo) {
        this.id = id;
        this.trabajo = trabajo;
        this.importe = importe;
        this.cantidadCuotas = cantidadCuotas;
        this.cobranzaPorRecibo = cobranzaPorRecibo;
        this.textoFactura = textoFactura;
        this.activo = activo;
    }

    public String getTextoFactura() {
        return textoFactura;
    }

    public void setTextoFactura(String textoFactura) {
        this.textoFactura = textoFactura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trabajo getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Integer getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(Integer cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public Boolean getCobranzaPorRecibo() {
        return cobranzaPorRecibo;
    }

    public void setCobranzaPorRecibo(Boolean cobranzaPorRecibo) {
        this.cobranzaPorRecibo = cobranzaPorRecibo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}
