package com.tortu.api.rest.resources;

/**
 * Representa el recurso para la capa de REST de un ingrediente
 */
public class IngredienteResource {
    private Integer idIngrediente;
    private String nombre;
    private Integer idCategoriaIngrediente;

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
