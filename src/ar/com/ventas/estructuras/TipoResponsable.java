/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.estructuras;

/**
 *
 * @author Mario
 */
public enum TipoResponsable {
    INSCRIPTO(1,"RESPONSABLE INSCRIPTO"),
    EXENTO(4,"EXENTO"),
    CONSUMFINAL(5,"CONSUMIDOR FINAL"),
    MONOTRIBUTO(6,"RESPONSABLE MONOTRIBUTO");
    
    private final Integer codigo;
    private final String descripcion;
    
    TipoResponsable(Integer codigo, String descripcion){
        this.codigo=codigo;
        this.descripcion=descripcion;
    }
    
    public Integer getCodigo(){
        return codigo;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
}
