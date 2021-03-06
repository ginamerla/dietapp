package com.tortu.api.models;

/**
 * Modelo CategorIngrediente
 */
public class CategoriaIngrediente {
    private Integer idCategoriaIngrediente;
    private String nombre;

    @Override
    public String toString() {
        return "CategoriaIngrediente{" +
                "idUsuario=" + idCategoriaIngrediente +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public Integer getIdCategoriaIngrediente() {
        return idCategoriaIngrediente;
    }

    public void setIdCategoriaIngrediente(Integer idCategoriaIngrediente) {
        this.idCategoriaIngrediente = idCategoriaIngrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
