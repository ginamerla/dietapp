package com.tortu.api.rest.resources;

/**
 * Representa el resource (REST) de una receta
 */
public class RecetaResource {

    private Integer idReceta;
    private String nombre;

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
