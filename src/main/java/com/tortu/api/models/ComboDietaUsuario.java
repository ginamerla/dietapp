package com.tortu.api.models;

public class ComboDietaUsuario {
    private Integer idComboDietaUsuario;
    private Integer idDietaUsuario;
    private Integer idRecetaPeriodo;

    @Override
    public String toString() {
        return "ComboDietaUsuario{" +
                "idComboDietaUsuario=" + idComboDietaUsuario +
                ", idDietaUsuario='" + idDietaUsuario + '\'' +
                ", idRecetaPeriodo='" + idRecetaPeriodo + '\'' +
                '}';
    }

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
