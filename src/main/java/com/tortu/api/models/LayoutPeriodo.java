package com.tortu.api.models;

public class LayoutPeriodo {
    private Integer idLayoutPeriodo;
    private Layout layout;
    private Periodo periodo;

    @Override
    public String toString() {
        return "LayoutPeriodo{" +
                "idLayoutPeriodo=" + idLayoutPeriodo +
                ", layout='" + layout + '\'' +
                ", periodo='" + periodo + '\'' +
                '}';
    }

    public Integer getIdLayoutPeriodo() {
        return idLayoutPeriodo;
    }

    public void setIdLayoutPeriodo(Integer idLayoutPeriodo) {
        this.idLayoutPeriodo = idLayoutPeriodo;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
}
