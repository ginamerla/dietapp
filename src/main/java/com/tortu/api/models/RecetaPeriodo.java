package com.tortu.api.models;

public class RecetaPeriodo {
    private Integer idRecetaPeriodo;
    private Integer idReceta;
    private Integer idPeriodo;

    @Override
    public String toString() {
        return "RecetaPeriodo{" +
                "idRecetaIngrediente=" + idRecetaPeriodo +
                ", idReceta='" + idReceta + '\'' +
                ", idPeriodo='" + idPeriodo + '\'' +
                '}';
    }

    public Integer getIdRecetaPeriodo() {
        return idRecetaPeriodo;
    }

    public void setIdRecetaPeriodo(Integer idRecetaPeriodo) {
        this.idRecetaPeriodo = idRecetaPeriodo;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }
}
