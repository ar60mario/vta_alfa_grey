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
public class Hijo {
    private Long id;
    private String apellidoNombre;
    private Date nacimiento;
    private String dni;
    private String cuil;
    private String otroPadre;
    private Boolean activo;
    private Persona padre;

    public Hijo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellidoNombre() {
        return apellidoNombre;
    }

    public void setApellidoNombre(String apellidoNombre) {
        this.apellidoNombre = apellidoNombre;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getOtroPadre() {
        return otroPadre;
    }

    public void setOtroPadre(String otroPadre) {
        this.otroPadre = otroPadre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Persona getPadre() {
        return padre;
    }

    public void setPadre(Persona padre) {
        this.padre = padre;
    }

    public Hijo(Long id, String apellidoNombre, Date nacimiento, String dni, String cuil, String otroPadre, Boolean activo, Persona padre) {
        this.id = id;
        this.apellidoNombre = apellidoNombre;
        this.nacimiento = nacimiento;
        this.dni = dni;
        this.cuil = cuil;
        this.otroPadre = otroPadre;
        this.activo = activo;
        this.padre = padre;
    }
    
}
