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
public class Consorcio {
    private Long id;
    private Integer codigo;
    private String nombre;
    private String documentoTipo;
    private String cuit;
    private Integer tipoInscripcion;
    private String encargado;
    private String horarioEncargado;
    private String telefonoEncargado;
    private String encargado1;
    private String horarioEncargado1;
    private String telefonoEncargado1;
    private String telefonoPorteria;
    private String telefonoConsejo;
    private Integer cantidadDepartamentos;
    private Integer cantidadPisos;
    private Boolean activo;
    private String observaciones;
    private Domicilio domicilio;
    private Administrador administrador;
    private Double saldo;

    public Consorcio() {
    }

    public Consorcio(Long id, Integer codigo, String nombre, String documentoTipo, String cuit, Integer tipoInscripcion, String encargado, String horarioEncargado, String telefonoEncargado, String encargado1, String horarioEncargado1, String telefonoEncargado1, String telefonoPorteria, String telefonoConsejo, Integer cantidadDepartamentos, Integer cantidadPisos, Boolean activo, String observaciones, Domicilio domicilio, Administrador administrador, Double saldo) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.documentoTipo = documentoTipo;
        this.cuit = cuit;
        this.tipoInscripcion = tipoInscripcion;
        this.encargado = encargado;
        this.horarioEncargado = horarioEncargado;
        this.telefonoEncargado = telefonoEncargado;
        this.encargado1 = encargado1;
        this.horarioEncargado1 = horarioEncargado1;
        this.telefonoEncargado1 = telefonoEncargado1;
        this.telefonoPorteria = telefonoPorteria;
        this.telefonoConsejo = telefonoConsejo;
        this.cantidadDepartamentos = cantidadDepartamentos;
        this.cantidadPisos = cantidadPisos;
        this.activo = activo;
        this.observaciones = observaciones;
        this.domicilio = domicilio;
        this.administrador = administrador;
        this.saldo = saldo;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumentoTipo() {
        return documentoTipo;
    }

    public void setDocumentoTipo(String documentoTipo) {
        this.documentoTipo = documentoTipo;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public Integer getTipoInscripcion() {
        return tipoInscripcion;
    }

    public void setTipoInscripcion(Integer tipoInscripcion) {
        this.tipoInscripcion = tipoInscripcion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getHorarioEncargado() {
        return horarioEncargado;
    }

    public void setHorarioEncargado(String horarioEncargado) {
        this.horarioEncargado = horarioEncargado;
    }

    public String getTelefonoEncargado() {
        return telefonoEncargado;
    }

    public void setTelefonoEncargado(String telefonoEncargado) {
        this.telefonoEncargado = telefonoEncargado;
    }

    public String getEncargado1() {
        return encargado1;
    }

    public void setEncargado1(String encargado1) {
        this.encargado1 = encargado1;
    }

    public String getHorarioEncargado1() {
        return horarioEncargado1;
    }

    public void setHorarioEncargado1(String horarioEncargado1) {
        this.horarioEncargado1 = horarioEncargado1;
    }

    public String getTelefonoEncargado1() {
        return telefonoEncargado1;
    }

    public void setTelefonoEncargado1(String telefonoEncargado1) {
        this.telefonoEncargado1 = telefonoEncargado1;
    }

    public String getTelefonoPorteria() {
        return telefonoPorteria;
    }

    public void setTelefonoPorteria(String telefonoPorteria) {
        this.telefonoPorteria = telefonoPorteria;
    }

    public String getTelefonoConsejo() {
        return telefonoConsejo;
    }

    public void setTelefonoConsejo(String telefonoConsejo) {
        this.telefonoConsejo = telefonoConsejo;
    }

    public Integer getCantidadDepartamentos() {
        return cantidadDepartamentos;
    }

    public void setCantidadDepartamentos(Integer cantidadDepartamentos) {
        this.cantidadDepartamentos = cantidadDepartamentos;
    }

    public Integer getCantidadPisos() {
        return cantidadPisos;
    }

    public void setCantidadPisos(Integer cantidadPisos) {
        this.cantidadPisos = cantidadPisos;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}