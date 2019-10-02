package com.tortu.api.models;

import java.util.Date;

/**
 * Modelo UsuarioLayout.  Representa la entidad usuario_layout en BD
 */
public class UsuarioLayout {
    private Integer idUsuarioLayout;
    private Integer idUsuario;
    private Integer idLayout;
    private Date fecha;

    @Override
    public String toString() {
        return "UsuarioLayout{" +
                "idUsuarioLayout=" + idUsuarioLayout +
                ", usuario='" + idUsuario + '\'' +
                ", layout='" + idLayout + '\'' +
                ", fecha='" + fecha + '\''+
                '}';
    }

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
