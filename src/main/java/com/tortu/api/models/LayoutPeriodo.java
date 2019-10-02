package com.tortu.api.models;

public class LayoutPeriodo {
    private Integer idLayoutPeriodo;
    private Integer idLayout;
    private Integer idPeriodo;

    @Override
    public String toString() {
        return "LayoutPeriodo{" +
                "idLayoutPeriodo=" + idLayoutPeriodo +
                ", idLayout='" + idLayout + '\'' +
                ", idPeriodo='" + idPeriodo + '\'' +
                '}';
    }

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
