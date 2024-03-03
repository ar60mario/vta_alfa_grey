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
public class RenglonAbono {
    private Long id;
    private Integer orden;
    private String texto;
    private Double importe;
    private Abono abono;

    public RenglonAbono() {
    }

    public RenglonAbono(Long id, Integer orden, String texto, Double importe, Abono abono) {
        this.id = id;
        this.orden = orden;
        this.texto = texto;
        this.importe = importe;
        this.abono = abono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Abono getAbono() {
        return abono;
    }

    public void setAbono(Abono abono) {
        this.abono = abono;
    }
    
}
