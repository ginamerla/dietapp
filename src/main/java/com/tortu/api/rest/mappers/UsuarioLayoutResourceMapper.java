package com.tortu.api.rest.mappers;

import com.tortu.api.models.UsuarioLayout;
import com.tortu.api.rest.resources.UsuarioLayoutResource;
import org.springframework.stereotype.Component;

/**
 * Clase que mapea las propiedades del modelo con su recurso de la capa REST
 */
@Component
public class UsuarioLayoutResourceMapper implements DefaultResourceMapper<UsuarioLayout, UsuarioLayoutResource> {

    @Override
    public UsuarioLayoutResource map(UsuarioLayout model) {
        if(model==null){
            return null;
        }
        UsuarioLayoutResource resource = new UsuarioLayoutResource();
        resource.setIdUsuarioLayout(model.getIdUsuarioLayout());
        resource.setIdUsuario(model.getIdUsuario());
        resource.setIdLayout(model.getIdLayout());
        resource.setFecha(model.getFecha());
        return resource;
    }
}
