package com.tortu.api.rest.mappers;

import com.tortu.api.models.ComboDietaUsuario;
import com.tortu.api.rest.resources.ComboDietaUsuarioResource;
import org.springframework.stereotype.Component;

/**
 * Asigna las propiedades del modelo ComboDietaUsuario con las de su recurso para la capa REST
 */
@Component
public class ComboDietaUsuarioResourceMapper implements DefaultResourceMapper<ComboDietaUsuario, ComboDietaUsuarioResource>{

    @Override
    public ComboDietaUsuarioResource map(ComboDietaUsuario model) {
        if(model==null){
            return null;
        }
        ComboDietaUsuarioResource resource = new ComboDietaUsuarioResource();
        resource.setIdComboDietaUsuario(model.getIdComboDietaUsuario());
        resource.setIdDietaUsuario(model.getIdDietaUsuario());
        resource.setIdRecetaPeriodo(model.getIdRecetaPeriodo());
        return resource;
    }
}
