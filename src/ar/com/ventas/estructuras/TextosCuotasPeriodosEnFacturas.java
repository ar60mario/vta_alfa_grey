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
public enum TextosCuotasPeriodosEnFacturas {
    A(1,"MES ANTERIOR"),
    B(2,"MES ACTUAL");
    
    private final Integer codigo;
    private final String detalle;
    
    TextosCuotasPeriodosEnFacturas(Integer codigo, String detalle){
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
