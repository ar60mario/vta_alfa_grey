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
public enum EstadoCivil {
    SOLTERO("Soltero",1),
    CASADO("Casado",2),
    SEPARADO("Separado",3),
    DIVORCIADO("Divorciado",4),
    VIUDO("Viudo",5);

    private final String estado;
    private final Integer codigo;

    EstadoCivil(String estado, Integer codigo) {
        this.estado = estado;
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }
    
    public String getEstado() {
        return estado;
    }
}
