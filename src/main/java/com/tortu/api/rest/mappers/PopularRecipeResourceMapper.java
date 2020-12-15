package com.tortu.api.rest.mappers;

import com.tortu.api.dto.PopularRecipe;
import com.tortu.api.rest.resources.PopularRecipeResource;
import org.springframework.stereotype.Component;

@Component
public class PopularRecipeResourceMapper implements DefaultResourceMapper<PopularRecipe, PopularRecipeResource> {

    @Override
    public PopularRecipeResource map(PopularRecipe model) {
        PopularRecipeResource resource = new PopularRecipeResource();
        resource.setRecipeName(model.getRecipeName());
        resource.setRecipeCount(model.getRecipeCount());
        return resource;
    }
}
