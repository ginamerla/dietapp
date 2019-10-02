package com.tortu.api.rest.mappers;

import com.tortu.api.models.Ingrediente;
import com.tortu.api.rest.resources.IngredienteResource;
import org.springframework.stereotype.Component;

/**
 * Implementacion del convertidor que mapea las propiedades de Ingrediente con el recurso para la capa REST
 */
@Component
public class IngredienteResourceMapper implements DefaultResourceMapper<Ingrediente, IngredienteResource> {
    @Override
    public IngredienteResource map(Ingrediente model) {
        if(model==null){
            return null;
        }
        IngredienteResource resource = new IngredienteResource();
        resource.setIdIngrediente(model.getIdIngrediente());
        resource.setNombre(model.getNombre());
        resource.setIdCategoriaIngrediente(model.getIdCategoriaIngrediente());
        return resource;
    }
}
