package com.tortu.api.models;

public class RecetaIngrediente {
    private Integer idRecetaIngrediente;
    private Receta receta;
    private Ingrediente ingrediente;
    private Medida medida;
    private Double cantidad;

    public Integer getIdRecetaIngrediente() {
        return idRecetaIngrediente;
    }

    public void setIdRecetaIngrediente(Integer idRecetaIngrediente) {
        this.idRecetaIngrediente = idRecetaIngrediente;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Medida getMedida() {
        return medida;
    }

    public void setMedida(Medida medida) {
        this.medida = medida;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
