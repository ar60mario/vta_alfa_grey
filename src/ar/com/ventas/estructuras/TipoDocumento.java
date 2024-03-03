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
public enum TipoDocumento {
    CEDU("00", "CEDULA IDENTIDAD"),
    CUIT("80", "CUIT"),
    CUIL("86", "CUIL"),
    CDI("87", "CDI"),
    PASA("94", "PASAPORTE"),
    DNI("96", "DNI"),
    CONSFINAL("99", "SIN IDENTIFICAR-VENTA GLOBAL CONS.FINAL");

    private final String codigo;
    private final String documento;
    
    TipoDocumento(String codigo, String documento){
        this.codigo=codigo;
        this.documento = documento;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public String getDocumento(){
        return documento;
    }
}
