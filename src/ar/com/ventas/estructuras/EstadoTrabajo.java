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
public enum EstadoTrabajo {
    PENDIENTE(1,"Trabajo pendiente de Realización"),
    ENPROCESO(2,"Trabajo Comenzado"),
    TERMINADO(3,"Trabajo Terminado y Entregado");
    
    private final Integer codigo;
    private final String detalle;
    
    EstadoTrabajo(Integer codigo, String detalle){
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
