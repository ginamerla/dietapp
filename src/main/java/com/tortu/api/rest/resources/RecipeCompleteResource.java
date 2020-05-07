package com.tortu.api.rest.resources;

import java.util.List;

/**
 * Representa el recurso para crear una receta completa
 */
public class RecipeCompleteResource {
    private String recipeName;
    private Integer periodId;
    private List<RecipeIngredientResource> ingredientResourceList;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    public List<RecipeIngredientResource> getIngredientResourceList() {
        return ingredientResourceList;
    }

    public void setIngredientResourceList(List<RecipeIngredientResource> ingredientResourceList) {
        this.ingredientResourceList = ingredientResourceList;
    }
}
