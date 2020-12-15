package com.tortu.api.rest.resources;

import lombok.Data;

@Data
public class PopularRecipeResource {
    private String recipeName;
    private int recipeCount;
}
