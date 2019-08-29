package com.tortu.api.models;

public class DietaUsuario {
    private Integer idDietaUsuario;
    private Usuario usuario;
    private String diaSemana;

    public Integer getIdDietaUsuario() {
        return idDietaUsuario;
    }

    public void setIdDietaUsuario(Integer idDietaUsuario) {
        this.idDietaUsuario = idDietaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }
}
