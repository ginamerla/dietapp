package com.tortu.api.rest.resources;

/**
 * Representa el modelo ComboDietaUsuario en la capa REST
 */
public class ComboDietaUsuarioResource {
    private Integer idComboDietaUsuario;
    private Integer idDietaUsuario;
    private Integer idRecetaPeriodo;

    public Integer getIdComboDietaUsuario() {
        return idComboDietaUsuario;
    }

    public void setIdComboDietaUsuario(Integer idComboDietaUsuario) {
        this.idComboDietaUsuario = idComboDietaUsuario;
    }

    public Integer getIdDietaUsuario() {
        return idDietaUsuario;
    }

    public void setIdDietaUsuario(Integer idDietaUsuario) {
        this.idDietaUsuario = idDietaUsuario;
    }

    public Integer getIdRecetaPeriodo() {
        return idRecetaPeriodo;
    }

    public void setIdRecetaPeriodo(Integer idRecetaPeriodo) {
        this.idRecetaPeriodo = idRecetaPeriodo;
    }
}
