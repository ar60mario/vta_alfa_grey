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
public enum TipoComprobante {
    C001("001", "FACTURA A"),
    C002("002", "NOTA DEBITO A"),
    C003("003", "NOTA CREDITO A"),
    C004("004", "RECIBO A"),
    C005("005", "NOTA VENTA CONTADO A"),
    C006("006", "FACTURA B"),
    C007("007", "NOTA DEBITO B"),
    C008("008", "NOTA CREDITO B"),
    C009("009", "RECIBO B"),
    C010("010", "NOTA VENTA CONTADO B"),
    C011("011", "FACTURA C"),
    C012("012", "NOTA DEBITO C"),
    C013("013", "NOTA CREDITO C"),
    C014("014", "RECIBO C"),
    C015("015", "NOTA VENTA CONTADO C");

    private final String codigo;
    private final String tipo;

    TipoComprobante(String codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }
}
