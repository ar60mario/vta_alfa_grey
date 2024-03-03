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
public class ConsorcioMaster {
    private Long id;
    private Integer master;
    private Consorcio consorcio;
    private Rubro rubro;
    private Boolean activo;

    public ConsorcioMaster() {
    }

    public ConsorcioMaster(Long id, Integer master, Consorcio consorcio, Rubro rubro, Boolean activo) {
        this.id = id;
        this.master = master;
        this.consorcio = consorcio;
        this.rubro = rubro;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaster() {
        return master;
    }

    public void setMaster(Integer master) {
        this.master = master;
    }

    public Consorcio getConsorcio() {
        return consorcio;
    }

    public void setConsorcio(Consorcio consorcio) {
        this.consorcio = consorcio;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    
}
