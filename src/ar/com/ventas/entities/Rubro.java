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
public class Rubro {

    private Long id;
    private Integer codigo;
    private String detalle;
    private Double importe;
    private Estructura estructura;
    private String textoEnFactura;
    private Boolean esAbono;
    private Boolean activo;

    public Rubro() {
    }

    public Rubro(Long id, Integer codigo, String detalle, Double importe, Estructura estructura, String textoEnFactura, Boolean esAbono, Boolean activo) {
        this.id = id;
        this.codigo = codigo;
        this.detalle = detalle;
        this.importe = importe;
        this.estructura = estructura;
        this.textoEnFactura = textoEnFactura;
        this.esAbono=esAbono;
        this.activo = activo;
    }

    public String getTextoEnFactura() {
        return textoEnFactura;
    }

    public void setTextoEnFactura(String textoEnFactura) {
        this.textoEnFactura = textoEnFactura;
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

    public Estructura getEstructura() {
        return estructura;
    }

    public void setEstructura(Estructura estructura) {
        this.estructura = estructura;
    }

    public Boolean getEsAbono() {
        return esAbono;
    }

    public void setEsAbono(Boolean esAbono) {
        this.esAbono = esAbono;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}
