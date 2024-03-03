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
public class TipoFactura {
    private Long id;
    private String detalle;
    private Integer Codigo;

    public TipoFactura() {
    }

    public TipoFactura(Long id, String detalle, Integer Codigo) {
        this.id = id;
        this.detalle = detalle;
        this.Codigo = Codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Integer getCodigo() {
        return Codigo;
    }

    public void setCodigo(Integer Codigo) {
        this.Codigo = Codigo;
    }
    
    
}
