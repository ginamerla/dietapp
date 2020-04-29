package com.tortu.api.dto;

import com.tortu.api.rest.resources.WPRecipeResultResource;

import java.util.List;

public class WeeklyPlanDTO {
    private String weekDay;
    private List<WPRecipeResultResource> recipeList;

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public List<WPRecipeResultResource> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<WPRecipeResultResource> recipeList) {
        this.recipeList = recipeList;
    }
}
