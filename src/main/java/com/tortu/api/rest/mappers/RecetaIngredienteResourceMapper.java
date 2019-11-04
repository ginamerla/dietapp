package com.tortu.api.rest.mappers;

import com.tortu.api.models.RecetaIngrediente;
import com.tortu.api.rest.resources.RecetaIngredienteResource;
import org.springframework.stereotype.Component;

/**
 * Asigna las propiedades del modelo RecetaIngrediente con su recurso
 */
@Component
public class RecetaIngredienteResourceMapper implements DefaultResourceMapper<RecetaIngrediente, RecetaIngredienteResource> {
    @Override
    public RecetaIngredienteResource map(RecetaIngrediente model) {
        if(model==null){
            return null;
        }
        RecetaIngredienteResource resource = new RecetaIngredienteResource();
        resource.setIdRecetaIngrediente(model.getIdRecetaIngrediente());
        resource.setIdReceta(model.getIdReceta());
        resource.setIdIngrediente(model.getIdIngrediente());
        resource.setIdMedida(model.getIdMedida());
        resource.setCantidad(model.getCantidad());
        return resource;
    }
}
