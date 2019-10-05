package com.tortu.api.rest.resources;

/**
 * Representa el recurso RecetaPeriodo para la capa de REST
 */
public class RecetaPeriodoResource {
    private Integer idRecetaPeriodo;
    private Integer idReceta;
    private Integer idPeriodo;

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
