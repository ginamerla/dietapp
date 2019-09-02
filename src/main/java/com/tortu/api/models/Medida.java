package com.tortu.api.models;

public class Medida {
    private Integer idMedida;
    private String medida;

    @Override
    public String toString() {
        return "Medida{" +
                "idMedida=" + idMedida +
                ", medida='" + medida + '\'' +
                '}';
    }

    public Integer getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Integer idMedida) {
        this.idMedida = idMedida;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
}
