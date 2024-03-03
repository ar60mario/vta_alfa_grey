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
public class ConsorcioFactura {
    private Long id;
    private Comprobante comprobante;
    private Consorcio consorcio;

    public ConsorcioFactura() {
    }

    public ConsorcioFactura(Long id, Comprobante comprobante, Consorcio consorcio) {
        this.id = id;
        this.comprobante = comprobante;
        this.consorcio = consorcio;
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

    public Consorcio getConsorcio() {
        return consorcio;
    }

    public void setConsorcio(Consorcio consorcio) {
        this.consorcio = consorcio;
    }
    
    
}
