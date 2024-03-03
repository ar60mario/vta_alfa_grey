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
public class ComprobanteRenglones {
    private Long id;
    private Comprobante comprobante;
    private String detalle;
    private Double importe;

    public ComprobanteRenglones() {
    }

    public ComprobanteRenglones(Long id, Comprobante comprobante, String detalle, Double importe) {
        this.id = id;
        this.comprobante = comprobante;
        this.detalle = detalle;
        this.importe = importe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
    
}
