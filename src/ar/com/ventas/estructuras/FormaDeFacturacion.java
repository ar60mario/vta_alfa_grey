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
public enum FormaDeFacturacion {
    FC1(1, "NO VALIDO"),
    FC2(2, "Un Recibo o Factura x Cuota"),
    FC3(3, "Un Rc o Fc unico por mes Reparacion/Matafuegos"),
    FC4(4, "NO VALIDO"),
    FC5(5, "NO VALIDO");
    
    private final Integer codigo;
    private final String detalle;
    
    FormaDeFacturacion(Integer codigo, String detalle){
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
