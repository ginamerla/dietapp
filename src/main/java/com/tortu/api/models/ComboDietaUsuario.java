package com.tortu.api.models;

public class ComboDietaUsuario {
    private Integer idComboDietaUsuario;
    private DietaUsuario dietaUsuario;
    private RecetaPeriodo recetaPeriodo;

    public Integer getIdComboDietaUsuario() {
        return idComboDietaUsuario;
    }

    public void setIdComboDietaUsuario(Integer idComboDietaUsuario) {
        this.idComboDietaUsuario = idComboDietaUsuario;
    }

    public DietaUsuario getDietaUsuario() {
        return dietaUsuario;
    }

    public void setDietaUsuario(DietaUsuario dietaUsuario) {
        this.dietaUsuario = dietaUsuario;
    }

    public RecetaPeriodo getRecetaPeriodo() {
        return recetaPeriodo;
    }

    public void setRecetaPeriodo(RecetaPeriodo recetaPeriodo) {
        this.recetaPeriodo = recetaPeriodo;
    }
}
