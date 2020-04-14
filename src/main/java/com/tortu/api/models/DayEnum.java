package com.tortu.api.models;

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
