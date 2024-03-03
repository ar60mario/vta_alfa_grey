/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.entities;

/**
 *
 * @author Mario
 */
public class AbonoPendiente {

    private Long id;
    private Abono abono;
    private Consorcio consorcioVinculado;
    private Abono abonoMaster;
    private Comprobante comprobante;
    private Comprobante comprobanteMaster;
    private TitularCuit titular;

    public AbonoPendiente() {
    }

    public AbonoPendiente(Long id, Abono abono, Consorcio consorcioVinculado, Abono abonoMaster, Comprobante comprobante, Comprobante comprobanteMaster, TitularCuit titular) {
        this.id = id;
        this.abono = abono;
        this.consorcioVinculado = consorcioVinculado;
        this.abonoMaster = abonoMaster;
        this.comprobante = comprobante;
        this.comprobanteMaster = comprobanteMaster;
        this.titular = titular;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Abono getAbono() {
        return abono;
    }

    public void setAbono(Abono abono) {
        this.abono = abono;
    }

    public Consorcio getConsorcioVinculado() {
        return consorcioVinculado;
    }

    public void setConsorcioVinculado(Consorcio consorcioVinculado) {
        this.consorcioVinculado = consorcioVinculado;
    }

    public Abono getAbonoMaster() {
        return abonoMaster;
    }

    public void setAbonoMaster(Abono abonoMaster) {
        this.abonoMaster = abonoMaster;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public Comprobante getComprobanteMaster() {
        return comprobanteMaster;
    }

    public void setComprobanteMaster(Comprobante comprobanteMaster) {
        this.comprobanteMaster = comprobanteMaster;
    }

    public TitularCuit getTitular() {
        return titular;
    }

    public void setTitular(TitularCuit titular) {
        this.titular = titular;
    }

}