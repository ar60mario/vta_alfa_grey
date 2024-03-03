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
public enum CategoriasMonotributo {
    A("A",370000.00),
    B("B",550000.00),
    C("C",770000.00),
    D("D",1060000.00),
    E("E",1400000.00),
    F("F",1750000.00),
    G("G",2100000.00),
    H("H",2600000.00);
    
    private final String categoria;
    private final Double ingresosBrutos;
    
    CategoriasMonotributo(String categoria, Double ingresosBrutos){
        this.categoria=categoria;
        this.ingresosBrutos = ingresosBrutos;
    }
    
    public String getCategoria(){
        return categoria;
    }
    
    public Double getIngresosBrutos(){
        return ingresosBrutos;
    }
}
