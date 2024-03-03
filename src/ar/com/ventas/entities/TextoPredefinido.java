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
public class TextoPredefinido {

    private Long id;
    private Integer codigo;
    private String textoCorto;
    private Boolean activo;

    public TextoPredefinido() {
    }

    public TextoPredefinido(Long id, Integer codigo, String textoCorto, Boolean activo) {
        this.id = id;
        this.codigo = codigo;
        this.textoCorto = textoCorto;
        this.activo = activo;
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

    public String getTextoCorto() {
        return textoCorto;
    }

    public void setTextoCorto(String textoCorto) {
        this.textoCorto = textoCorto;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}
