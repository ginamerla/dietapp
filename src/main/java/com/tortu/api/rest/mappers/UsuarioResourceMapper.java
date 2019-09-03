package com.tortu.api.rest.mappers;

import com.tortu.api.models.Usuario;
import com.tortu.api.rest.resources.UsuarioResource;
import org.springframework.stereotype.Component;

/**
 * Implementacion del convertidor del modelo usuario a un recurso rest de la clase Usuario.
 * @author visilva
 */
@Component
public class UsuarioResourceMapper implements DefaultResourceMapper<Usuario, UsuarioResource> {
    @Override
    public UsuarioResource map(Usuario model) {
        if (model == null) {
            return null;
        }
        UsuarioResource resource = new UsuarioResource();
        resource.setId(model.getIdUsuario());
        resource.setEmail(model.getEmail());
        resource.setNombre(model.getNombre());
        return resource;
    }
}
