package com.tortu.api.rest.resources;

/**
 * Recurso que representa al modelo RecetaIngrediente en la capa REST
 */
public class RecetaIngredienteResource {
    private Integer idRecetaIngrediente;
    private Integer idReceta;
    private Integer idIngrediente;
    private Integer idMedida;
    private Double cantidad;

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
