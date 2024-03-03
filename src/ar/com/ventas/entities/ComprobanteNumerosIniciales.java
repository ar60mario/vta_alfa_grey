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
public class ComprobanteNumerosIniciales {
    private Long id;
    private TitularCuit titular;
    private Integer nroCpbte;

    public ComprobanteNumerosIniciales() {
    }

    public ComprobanteNumerosIniciales(Long id, TitularCuit titular, Integer nroCpbte) {
        this.id = id;
        this.titular = titular;
        this.nroCpbte = nroCpbte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TitularCuit getTitular() {
        return titular;
    }

    public void setTitular(TitularCuit titular) {
        this.titular = titular;
    }

    public Integer getNroCpbte() {
        return nroCpbte;
    }

    public void setNroCpbte(Integer nroCpbte) {
        this.nroCpbte = nroCpbte;
    }
    
    
}
