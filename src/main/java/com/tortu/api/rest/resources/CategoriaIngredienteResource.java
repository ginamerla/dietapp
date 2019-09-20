package com.tortu.api.rest.resources;

/**
 * Clase que representa el recurso (de la capa rest) del modelo (categoria_ingrediente)
 */
public class CategoriaIngredienteResource {
    private Integer idCategoriaIngrediente;
    private String nombre;

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
