package com.tortu.api.rest.resources;

/**
 * Representa un rescurso para la capa REST del modelo LayoutPeriodo
 */
public class LayoutPeriodoResource {
    private Integer idLayoutPeriodo;
    private Integer idLayout;
    private Integer idPeriodo;

    public Integer getIdLayoutPeriodo() {
        return idLayoutPeriodo;
    }

    public void setIdLayoutPeriodo(Integer idLayoutPeriodo) {
        this.idLayoutPeriodo = idLayoutPeriodo;
    }

    public Integer getIdLayout() {
        return idLayout;
    }

    public void setIdLayout(Integer idLayout) {
        this.idLayout = idLayout;
    }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }
}
