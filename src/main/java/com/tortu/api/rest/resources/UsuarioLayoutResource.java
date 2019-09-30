package com.tortu.api.rest.resources;

import java.util.Date;

/**
 * Representa el recurso de UsuarioLayout para la capa REST
 */
public class UsuarioLayoutResource {
    private Integer idUsuarioLayout;
    private Integer idUsuario;
    private Integer idLayout;
    private Date fecha;

    public Integer getIdUsuarioLayout() {
        return idUsuarioLayout;
    }

    public void setIdUsuarioLayout(Integer idUsuarioLayout) {
        this.idUsuarioLayout = idUsuarioLayout;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdLayout() {
        return idLayout;
    }

    public void setIdLayout(Integer idLayout) {
        this.idLayout = idLayout;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
