package com.tortu.api.rest.resources;

/**
 * Clase que representa el recurso REST del modelo Dieta_Usuario
 */
public class DietaUsuarioResource {
    private Integer idDietaUsuario;
    private Integer idUsuario;
    private String diaSemana;

    public Integer getIdDietaUsuario() {
        return idDietaUsuario;
    }

    public void setIdDietaUsuario(Integer idDietaUsuario) {
        this.idDietaUsuario = idDietaUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }
}
