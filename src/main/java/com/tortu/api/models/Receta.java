package com.tortu.api.models;

public class Receta {
    private Integer idReceta;
    private String nombre;

    @Override
    public String toString() {
        return "Receta{" +
                "idReceta=" + idReceta +
                ", nombre='" + nombre + '\'' +
                '}';
    }

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
