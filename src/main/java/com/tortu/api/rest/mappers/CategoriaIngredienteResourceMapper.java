package com.tortu.api.rest.mappers;

import com.tortu.api.models.CategoriaIngrediente;
import com.tortu.api.rest.resources.CategoriaIngredienteResource;
import org.springframework.stereotype.Component;

/**
 * Implementacion del mapper del modelo a un resource
 */
@Component
public class CategoriaIngredienteResourceMapper implements DefaultResourceMapper<CategoriaIngrediente, CategoriaIngredienteResource> {
    @Override
    public CategoriaIngredienteResource map(CategoriaIngrediente model) {
        if(model==null){
            return null;
        }
        CategoriaIngredienteResource resource = new CategoriaIngredienteResource();
        resource.setIdCategoriaIngrediente(model.getIdCategoriaIngrediente());
        resource.setNombre(model.getNombre());
        return resource;
    }
}
