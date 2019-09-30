package com.tortu.api.rest.mappers;

import com.tortu.api.models.DietaUsuario;
import com.tortu.api.rest.resources.DietaUsuarioResource;
import org.springframework.stereotype.Component;

/**
 * Implementacion del mapper de la Dieta_Usuario que mappea las propiedades del modelo con el recurso REST
 */
@Component
public class DietaUsuarioResourceMapper implements DefaultResourceMapper<DietaUsuario, DietaUsuarioResource> {
    @Override
    public DietaUsuarioResource map(DietaUsuario model) {
        if(model==null){
            return null;
        }
        DietaUsuarioResource dietaUsuarioResource = new DietaUsuarioResource();
        dietaUsuarioResource.setIdDietaUsuario(model.getIdDietaUsuario());
        dietaUsuarioResource.setIdUsuario(model.getIdUsuario());
        dietaUsuarioResource.setDiaSemana(model.getDiaSemana());
        return dietaUsuarioResource;
    }
}
