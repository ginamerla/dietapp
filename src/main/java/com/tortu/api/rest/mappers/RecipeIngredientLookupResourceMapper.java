package com.tortu.api.rest.mappers;

import com.tortu.api.dto.RecipeIngredientLookupDTO;
import com.tortu.api.rest.resources.RecipeIngredientLookupResource;
import org.springframework.stereotype.Component;

/**
 * Implementacion del mapeador del recurso con el DTO
 */
@Component
public class RecipeIngredientLookupResourceMapper implements DefaultResourceMapper<RecipeIngredientLookupDTO, RecipeIngredientLookupResource> {
    @Override
    public RecipeIngredientLookupResource map(RecipeIngredientLookupDTO model) {
        if(model==null){
            return null;
        }
        RecipeIngredientLookupResource resource = new RecipeIngredientLookupResource();
        resource.setIngredient(model.getIngrediente());
        resource.setPeriod(model.getPeriodo());
        resource.setRecipeName(model.getReceta());
        resource.setQuantity(model.getCantidad());
        resource.setUnit(model.getMedida());
        return resource;
    }
}
