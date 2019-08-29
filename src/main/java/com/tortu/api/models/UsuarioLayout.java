package com.tortu.api.models;

import java.util.Date;

public class UsuarioLayout {
    private Integer idUsuarioLayout;
    private Usuario usuario;
    private Layout layout;
    private Date fecha;

    public Integer getIdUsuarioLayout() {
        return idUsuarioLayout;
    }

    public void setIdUsuarioLayout(Integer idUsuarioLayout) {
        this.idUsuarioLayout = idUsuarioLayout;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
