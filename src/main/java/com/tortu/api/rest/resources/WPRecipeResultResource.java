package com.tortu.api.rest.resources;

import java.util.List;

public class WPRecipeResultResource {
    private String recipeName;
    private String period;
    private List<WPIngredientResultResource> ingredientResultList;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<WPIngredientResultResource> getIngredientResultList() {
        return ingredientResultList;
    }

    public void setIngredientResultList(List<WPIngredientResultResource> ingredientResultList) {
        this.ingredientResultList = ingredientResultList;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
