package com.tortu.api.models;

public class RecetaIngrediente {
    private Integer idRecetaIngrediente;
    private Integer idReceta;
    private Integer idIngrediente;
    private Integer idMedida;
    private Double cantidad;

    @Override
    public String toString() {
        return "RecetaIngrediente{" +
                "idRecetaIngrediente=" + idRecetaIngrediente +
                ", idReceta='" + idReceta + '\'' +
                ", idIngrediente='" + idIngrediente + '\'' +
                ", idMedida='" + idMedida + '\'' +
                ", cantidad='" + cantidad + '\'' +
                '}';
    }

    public Integer getIdRecetaIngrediente() {
        return idRecetaIngrediente;
    }

    public void setIdRecetaIngrediente(Integer idRecetaIngrediente) {
        this.idRecetaIngrediente = idRecetaIngrediente;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public Integer getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Integer idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public Integer getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Integer idMedida) {
        this.idMedida = idMedida;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
