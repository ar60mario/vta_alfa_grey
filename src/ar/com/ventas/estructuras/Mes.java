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
public enum Mes {
    ENERO(0, "ENERO"),
    FEBRERO(1,"FEBRERO"),
    MARZO(2,"MARZO"),
    ABRIL(3,"ABRIL"),
    MAYO(4,"MAYO"),
    JUNIO(5,"JUNIO"),
    JULIO(6,"JULIO"),
    AGOSTO(7,"AGOSTO"),
    SETIEMBRE(8,"SEPTIEMBRE"),
    OCTUBRE(9,"OCTUBRE"),
    NOVIEMBRE(10,"NOVIEMBRE"),
    DICIEMBRE(11,"DICIEMBRE");
    
    private final Integer codigo;
    private final String detalle;
    
    Mes(Integer codigo, String detalle){
        this.codigo=codigo;
        this.detalle=detalle;
    }
    
    public Integer getCodigo(){
        return codigo;
    }
    
    public String getDetalle(){
        return detalle;
    }
}
