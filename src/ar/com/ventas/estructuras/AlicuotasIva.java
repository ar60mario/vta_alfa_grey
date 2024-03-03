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
public enum AlicuotasIva {
    CODIGO3("0003",0.0F),
    CODIGO4("0004",10.5F),
    CODIGO5("0005",21.0F),
    CODIGO6("0006",27.0F),
    CODIGO8("0008",5.0F),
    CODIGO9("0009",2.5F);
    
    private final String codigo;
    private final Float alicuota;
    
    AlicuotasIva(String codigo, Float alicuota){
        this.codigo=codigo;
        this.alicuota = alicuota;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public Float getAlicuota(){
        return alicuota;
    }
}
