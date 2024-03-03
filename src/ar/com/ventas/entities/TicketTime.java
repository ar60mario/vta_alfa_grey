/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.entities;

import java.util.Date;

/**
 *
 * @author Mario
 */
public class TicketTime {
    private Long id;
    private Date fecha;
    private Integer hora;
    private Integer minuto;
    private Integer segundo;
    private String token;
    private String sign;
    private String exception;
    private TitularCuit titular;

    public TicketTime() {
    }

    public TicketTime(Long id, Date fecha, Integer hora, Integer minuto, Integer segundo
            , String token, String sign, TitularCuit titular, String exception) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
        this.token = token;
        this.sign = sign;
        this.exception = exception;
        this.titular = titular;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public Integer getMinuto() {
        return minuto;
    }

    public void setMinuto(Integer minuto) {
        this.minuto = minuto;
    }

    public Integer getSegundo() {
        return segundo;
    }

    public void setSegundo(Integer segundo) {
        this.segundo = segundo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public TitularCuit getTitular() {
        return titular;
    }

    public void setTitular(TitularCuit titular) {
        this.titular = titular;
    }
    
}
