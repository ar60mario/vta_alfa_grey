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
public class Administrador {
    private Long id;
    private Integer codigo;
    private String cuit;
    private String razonSocial;
    private String nombreAdministrador;
    private String telefonoAdministracion;
    private String contacto;
    private String telefono;
    private String contacto1;
    private String telefono1;
    private String telefono2;
    private String contacto2;
    private String mail;
    private String observaciones;
    private Boolean activo;
    private Boolean pagaMesCorriente;
    private Domicilio domicilio;

    public Administrador() {
    }

    public Administrador(Long id, Integer codigo, String cuit, String razonSocial, String nombreAdministrador, String telefonoAdministracion, String contacto, String telefono, String contacto1, String telefono1, String telefono2, String contacto2, String mail, String observaciones, Boolean activo, Boolean pagaMesCorriente, Domicilio domicilio) {
        this.id = id;
        this.codigo = codigo;
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.nombreAdministrador = nombreAdministrador;
        this.telefonoAdministracion = telefonoAdministracion;
        this.contacto = contacto;
        this.telefono = telefono;
        this.contacto1 = contacto1;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.contacto2 = contacto2;
        this.mail = mail;
        this.observaciones = observaciones;
        this.activo = activo;
        this.pagaMesCorriente = pagaMesCorriente;
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

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    public String getTelefonoAdministracion() {
        return telefonoAdministracion;
    }

    public void setTelefonoAdministracion(String telefonoAdministracion) {
        this.telefonoAdministracion = telefonoAdministracion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContacto1() {
        return contacto1;
    }

    public void setContacto1(String contacto1) {
        this.contacto1 = contacto1;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getContacto2() {
        return contacto2;
    }

    public void setContacto2(String contacto2) {
        this.contacto2 = contacto2;
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

    public Boolean getPagaMesCorriente() {
        return pagaMesCorriente;
    }

    public void setPagaMesCorriente(Boolean pagaMesCorriente) {
        this.pagaMesCorriente = pagaMesCorriente;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
    
}