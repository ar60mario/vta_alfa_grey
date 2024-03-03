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
public class Persona {
    private Long id;
    private Integer codigo;
    private String apellidoNombre;
    private String dni;
    private Boolean esTitularCuit;
    private Boolean esEmpleado;
    private Date fechaNacimiento;
    private Date fechaIngreso;
    private Date fechaBaja;
    private String cuil;
    private Integer estadoCivil;
    private String apellidoNombrePareja;
    private String dniPareja;
    private String claveFiscal;
    private Date fechaNacimientoPareja;
    private String telefono;
    private String mail;
    private String observaciones;
    private Boolean activo;
    private Domicilio domicilio;

    public Persona() {
    }

    public Persona(Long id, Integer codigo, String apellidoNombre, String dni, Boolean esTitularCuit, Boolean esEmpleado, Date fechaNacimiento, Date fechaIngreso, Date fechaBaja, String cuil, Integer estadoCivil, String apellidoNombrePareja, String dniPareja, String claveFiscal, Date fechaNacimientoPareja, String telefono, String mail, String observaciones, Boolean activo, Domicilio domicilio) {
        this.id = id;
        this.codigo = codigo;
        this.apellidoNombre = apellidoNombre;
        this.dni = dni;
        this.esTitularCuit = esTitularCuit;
        this.esEmpleado = esEmpleado;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.fechaBaja = fechaBaja;
        this.cuil = cuil;
        this.estadoCivil = estadoCivil;
        this.apellidoNombrePareja = apellidoNombrePareja;
        this.dniPareja = dniPareja;
        this.claveFiscal = claveFiscal;
        this.fechaNacimientoPareja = fechaNacimientoPareja;
        this.telefono = telefono;
        this.mail = mail;
        this.observaciones = observaciones;
        this.activo = activo;
        this.domicilio = domicilio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getApellidoNombre() {
        return apellidoNombre;
    }

    public void setApellidoNombre(String apellidoNombre) {
        this.apellidoNombre = apellidoNombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Boolean getEsTitularCuit() {
        return esTitularCuit;
    }

    public void setEsTitularCuit(Boolean esTitularCuit) {
        this.esTitularCuit = esTitularCuit;
    }

    public Boolean getEsEmpleado() {
        return esEmpleado;
    }

    public void setEsEmpleado(Boolean esEmpleado) {
        this.esEmpleado = esEmpleado;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public Integer getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Integer estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getApellidoNombrePareja() {
        return apellidoNombrePareja;
    }

    public void setApellidoNombrePareja(String apellidoNombrePareja) {
        this.apellidoNombrePareja = apellidoNombrePareja;
    }

    public String getDniPareja() {
        return dniPareja;
    }

    public void setDniPareja(String dniPareja) {
        this.dniPareja = dniPareja;
    }

    public String getClaveFiscal() {
        return claveFiscal;
    }

    public void setClaveFiscal(String claveFiscal) {
        this.claveFiscal = claveFiscal;
    }

    public Date getFechaNacimientoPareja() {
        return fechaNacimientoPareja;
    }

    public void setFechaNacimientoPareja(Date fechaNacimientoPareja) {
        this.fechaNacimientoPareja = fechaNacimientoPareja;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
    
    
}
