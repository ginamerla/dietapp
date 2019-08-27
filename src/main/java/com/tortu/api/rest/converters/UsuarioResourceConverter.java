package com.tortu.api.rest.converters;

import com.tortu.api.models.Usuario;
import com.tortu.api.rest.resources.UsuarioResource;
import org.springframework.stereotype.Component;

/**
 * Implementacion del convertidor del modelo usuario a un recurso rest de la clase Usuario.
 * @author visilva
 */
@Component
public class UsuarioResourceConverter implements DefaultResourceConverter<Usuario, UsuarioResource> {
    @Override
    public UsuarioResource convert(Usuario model) {
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
