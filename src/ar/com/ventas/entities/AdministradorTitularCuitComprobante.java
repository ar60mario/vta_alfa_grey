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
public class AdministradorTitularCuitComprobante {
    private Long id;
    private Administrador administrador;
    private TitularCuit titular;
    private Comprobante comprobante;

    public AdministradorTitularCuitComprobante() {
    }

    public AdministradorTitularCuitComprobante(Long id, Administrador administrador, TitularCuit titular, Comprobante comprobante) {
        this.id = id;
        this.administrador = administrador;
        this.titular = titular;
        this.comprobante = comprobante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public TitularCuit getTitular() {
        return titular;
    }

    public void setTitular(TitularCuit titular) {
        this.titular = titular;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }
    
    
}
