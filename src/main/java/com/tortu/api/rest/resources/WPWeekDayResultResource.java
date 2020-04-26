package com.tortu.api.rest.resources;

import java.util.List;

public class  WPWeekDayResultResource {
    private String weekDay;
    private List<WPRecipeResultResource> recipeResultList;

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public List<WPRecipeResultResource> getRecipeResultList() {
        return recipeResultList;
    }

    public void setRecipeResultList(List<WPRecipeResultResource> recipeResultList) {
        this.recipeResultList = recipeResultList;
    }
}
