package com.tortu.api.rest.mappers;

import com.tortu.api.dto.ShoppingIngredientDTO;
import com.tortu.api.rest.resources.ShoppingIngredientResource;
import org.springframework.stereotype.Component;

/**
 * Implementacion del convertidor que mapea las propiedades de la lista de ingredientes con el recurso de la capa REST
 */
@Component
public class ShoppingIngredientResourceMapper implements DefaultResourceMapper<ShoppingIngredientDTO, ShoppingIngredientResource> {
    @Override
    public ShoppingIngredientResource map(ShoppingIngredientDTO model) {
        if(model==null){
            return null;
        }
        ShoppingIngredientResource resource = new ShoppingIngredientResource();
        resource.setCategory(model.getCategory());
        resource.setIdIngredient(model.getIdIngredient());
        resource.setItem(model.getItem());
        resource.setQuantity(model.getQuantity());
        resource.setUnit(model.getUnit());
        return resource;
    }
}
