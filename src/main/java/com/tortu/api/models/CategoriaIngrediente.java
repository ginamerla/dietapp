package com.tortu.api.models;

/**
 * Modelo CategorIngrediente
 */
public class CategoriaIngrediente {
    private Integer idUsuario;
    private String nombre;

    @Override
    public String toString() {
        return "CategoriaIngrediente{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
