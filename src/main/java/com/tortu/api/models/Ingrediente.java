package com.tortu.api.models;

public class Ingrediente {
    private Integer idIngrediente;
    private String nombre;
    private Integer idCategoriaIngrediente;

    @Override
    public String toString() {
        return "Ingrediente{" +
                "idIngrediente=" + idIngrediente +
                ", nombre='" + nombre + '\'' +
                ", categoriaIngrediente='" + idCategoriaIngrediente + '\'' +
                '}';
    }

    public Integer getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Integer idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoriaIngrediente() {
        return idCategoriaIngrediente;
    }

    public void setIdCategoriaIngrediente(Integer idCategoriaIngrediente) {
        this.idCategoriaIngrediente = idCategoriaIngrediente;
    }
}
