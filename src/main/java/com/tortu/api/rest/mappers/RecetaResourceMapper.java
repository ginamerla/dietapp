package com.tortu.api.rest.mappers;

import com.tortu.api.models.Receta;
import com.tortu.api.rest.resources.RecetaResource;
import org.springframework.stereotype.Component;

/**
 * Implementacion del convertidor (mappeador) del modelo RECETA a un recurso REST de la clase Receta
 */
@Component
public class RecetaResourceMapper implements DefaultResourceMapper<Receta, RecetaResource> {

    @Override
    public RecetaResource map(Receta model) {
        if(model == null){
            return null;
        }
        RecetaResource resource = new RecetaResource();
        resource.setIdReceta(model.getIdReceta());
        resource.setNombre(model.getNombre());
        return resource;
    }
}
