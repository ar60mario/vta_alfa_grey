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
public class ListadoCobranza implements Comparable<ListadoCobranza> {

    private Long id;
    private Consorcio consorcio;
    private Administrador administrador;
    private Comprobante comprobante;
    private Rubro rubro;
    private String orden;

    public ListadoCobranza() {
    }

    public ListadoCobranza(Long id, Consorcio consorcio, Administrador administrador, Comprobante comprobante, Rubro rubro, String orden) {
        this.id = id;
        this.consorcio = consorcio;
        this.administrador = administrador;
        this.comprobante = comprobante;
        this.rubro = rubro;
        this.orden = orden;
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

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    @Override
    public int compareTo(ListadoCobranza o) {
        String a = this.getOrden();
        String b = o.getOrden();
        return a.compareTo(b);
    }
}
