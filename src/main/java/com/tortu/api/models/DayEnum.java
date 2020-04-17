package com.tortu.api.models;

/**
 * Dias de la semana default que se tomaran en cuenta para la dieta semanal.
 */
public enum DayEnum {
    LUNES("Lunes"),
    MARTES("Martes"),
    MIERCOLES("Miercoles"),
    JUEVES("Jueves"),
    VIERNES("Viernes");

    private String id;

    private DayEnum(String id){
        this.id=id;
    }

    public String getId() {
        return id;
    }
}
