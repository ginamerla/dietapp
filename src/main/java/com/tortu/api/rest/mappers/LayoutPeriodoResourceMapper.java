package com.tortu.api.rest.mappers;

import com.tortu.api.models.LayoutPeriodo;
import com.tortu.api.rest.resources.LayoutPeriodoResource;
import org.springframework.stereotype.Component;

/**
 * Mapea las propiedades del modelo con las del recurso para la capa rest
 */
@Component
public class LayoutPeriodoResourceMapper implements DefaultResourceMapper<LayoutPeriodo, LayoutPeriodoResource> {
    @Override
    public LayoutPeriodoResource map(LayoutPeriodo model) {
        if(model==null){
            return null;
        }
        LayoutPeriodoResource resource = new LayoutPeriodoResource();
        resource.setIdLayoutPeriodo(model.getIdLayoutPeriodo());
        resource.setIdLayout(model.getIdLayout());
        resource.setIdPeriodo(model.getIdPeriodo());
        return resource;
    }
}
