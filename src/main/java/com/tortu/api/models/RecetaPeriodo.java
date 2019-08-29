package com.tortu.api.models;

public class RecetaPeriodo {
    private Integer idRecetaPeriodo;
    private Receta receta;
    private Periodo periodo;

    public Integer getIdRecetaPeriodo() {
        return idRecetaPeriodo;
    }

    public void setIdRecetaPeriodo(Integer idRecetaPeriodo) {
        this.idRecetaPeriodo = idRecetaPeriodo;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
}
