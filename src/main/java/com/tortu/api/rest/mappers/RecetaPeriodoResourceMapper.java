package com.tortu.api.rest.mappers;

import com.tortu.api.models.RecetaPeriodo;
import com.tortu.api.rest.resources.RecetaPeriodoResource;
import org.springframework.stereotype.Component;

/**
 * Asigna las propiedades del modelo RecetaPeriodo al recurso para la capa de REST
 */
@Component
public class RecetaPeriodoResourceMapper implements DefaultResourceMapper<RecetaPeriodo, RecetaPeriodoResource> {
    @Override
    public RecetaPeriodoResource map(RecetaPeriodo model) {
        if(model==null){
            return null;
        }
        RecetaPeriodoResource recetaPeriodoResource = new RecetaPeriodoResource();
        recetaPeriodoResource.setIdRecetaPeriodo(model.getIdRecetaPeriodo());
        recetaPeriodoResource.setIdReceta(model.getIdReceta());
        recetaPeriodoResource.setIdPeriodo(model.getIdPeriodo());
        return recetaPeriodoResource;
    }
}
