package com.tortu.api.models;

public class DietaUsuario {
    private Integer idDietaUsuario;
    private Integer idUsuario;
    private String diaSemana;

    @Override
    public String toString() {
        return "DietaUsuario{" +
                "idDietaUsuario=" + idDietaUsuario +
                ", usuario='" + idUsuario + '\'' +
                ", diaSemana='" + diaSemana + '\'' +
                '}';
    }

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
