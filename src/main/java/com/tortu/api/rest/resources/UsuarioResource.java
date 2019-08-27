package com.tortu.api.rest.resources;

import java.util.Date;

/**
 * Esta clase representa el recurso (Rest) de un usuario.
 * @author visilva
 */
public class UsuarioResource {
    private String nombre;
    private String email;
    private Integer id;
    private Date fecha = new Date();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
