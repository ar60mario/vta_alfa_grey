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
public class TitularCuit {

    private Long id;
    private String nombreFantasia;
    private Date fechaInicioActividades;
    private String cuit;
    private String iibb;
    private String telefono;
    private String mail;
    private Integer tipoInscipcion;
    private Integer sucursal;
    private Integer ultimoNroFcA;
    private Integer ultimoNroFcB;
    private Integer ultimoNroFcC;
    private Integer ultimoNroNcA;
    private Integer ultimoNroNcB;
    private Integer ultimoNroNcC;
    private Integer ultimoNroRc;
    private Integer ultimoNroPp;
    private String observaciones;
    private Boolean activo;
    private String categoria;
    private Double limiteFacturar;
    private Persona persona;
    private Domicilio domicilio;
    private String logo;

    public TitularCuit() {
    }

    public TitularCuit(Long id, String nombreFantasia, Date fechaInicioActividades, String cuit, String iibb, String telefono, String mail, Integer tipoInscipcion, Integer sucursal, Integer ultimoNroFcA, Integer ultimoNroFcB, Integer ultimoNroFcC, Integer ultimoNroNcA, Integer ultimoNroNcB, Integer ultimoNroNcC, Integer ultimoNroRc, Integer ultimoNroPp, String observaciones, Boolean activo, String categoria, Double limiteFacturar, Persona persona, Domicilio domicilio, String logo) {
        this.id = id;
        this.nombreFantasia = nombreFantasia;
        this.fechaInicioActividades = fechaInicioActividades;
        this.cuit = cuit;
        this.iibb = iibb;
        this.telefono = telefono;
        this.mail = mail;
        this.tipoInscipcion = tipoInscipcion;
        this.sucursal = sucursal;
        this.ultimoNroFcA = ultimoNroFcA;
        this.ultimoNroFcB = ultimoNroFcB;
        this.ultimoNroFcC = ultimoNroFcC;
        this.ultimoNroNcA = ultimoNroNcA;
        this.ultimoNroNcB = ultimoNroNcB;
        this.ultimoNroNcC = ultimoNroNcC;
        this.ultimoNroRc = ultimoNroRc;
        this.ultimoNroPp = ultimoNroPp;
        this.observaciones = observaciones;
        this.activo = activo;
        this.categoria = categoria;
        this.limiteFacturar = limiteFacturar;
        this.persona = persona;
        this.domicilio = domicilio;
        this.logo = logo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    public Date getFechaInicioActividades() {
        return fechaInicioActividades;
    }

    public void setFechaInicioActividades(Date fechaInicioActividades) {
        this.fechaInicioActividades = fechaInicioActividades;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getIibb() {
        return iibb;
    }

    public void setIibb(String iibb) {
        this.iibb = iibb;
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

    public Integer getTipoInscipcion() {
        return tipoInscipcion;
    }

    public void setTipoInscipcion(Integer tipoInscipcion) {
        this.tipoInscipcion = tipoInscipcion;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getUltimoNroFcA() {
        return ultimoNroFcA;
    }

    public void setUltimoNroFcA(Integer ultimoNroFcA) {
        this.ultimoNroFcA = ultimoNroFcA;
    }

    public Integer getUltimoNroFcB() {
        return ultimoNroFcB;
    }

    public void setUltimoNroFcB(Integer ultimoNroFcB) {
        this.ultimoNroFcB = ultimoNroFcB;
    }

    public Integer getUltimoNroFcC() {
        return ultimoNroFcC;
    }

    public void setUltimoNroFcC(Integer ultimoNroFcC) {
        this.ultimoNroFcC = ultimoNroFcC;
    }

    public Integer getUltimoNroNcA() {
        return ultimoNroNcA;
    }

    public void setUltimoNroNcA(Integer ultimoNroNcA) {
        this.ultimoNroNcA = ultimoNroNcA;
    }

    public Integer getUltimoNroNcB() {
        return ultimoNroNcB;
    }

    public void setUltimoNroNcB(Integer ultimoNroNcB) {
        this.ultimoNroNcB = ultimoNroNcB;
    }

    public Integer getUltimoNroNcC() {
        return ultimoNroNcC;
    }

    public void setUltimoNroNcC(Integer ultimoNroNcC) {
        this.ultimoNroNcC = ultimoNroNcC;
    }

    public Integer getUltimoNroRc() {
        return ultimoNroRc;
    }

    public void setUltimoNroRc(Integer ultimoNroRc) {
        this.ultimoNroRc = ultimoNroRc;
    }

    public Integer getUltimoNroPp() {
        return ultimoNroPp;
    }

    public void setUltimoNroPp(Integer ultimoNroPp) {
        this.ultimoNroPp = ultimoNroPp;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getLimiteFacturar() {
        return limiteFacturar;
    }

    public void setLimiteFacturar(Double limiteFacturar) {
        this.limiteFacturar = limiteFacturar;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

}
