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
public class AbonoFactura {

    private Long id;
    private Abono abono;
    private Comprobante comprobante;
    private TitularCuit titular;
    private Boolean activo;

    public AbonoFactura() {
    }

    public AbonoFactura(Long id, Abono abono, Comprobante comprobante, TitularCuit titular, Boolean activo) {
        this.id = id;
        this.abono = abono;
        this.comprobante = comprobante;
        this.titular = titular;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Abono getAbono() {
        return abono;
    }

    public void setAbono(Abono abono) {
        this.abono = abono;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public TitularCuit getTitular() {
        return titular;
    }

    public void setTitular(TitularCuit titular) {
        this.titular = titular;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}