package com.tortu.api.rest.validators.usuariosapi;

import com.tortu.api.models.Usuario;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.springframework.stereotype.Component;

@Component("createUsuarioValidator")
public class CreateUsuarioValidatorImpl implements GenericValidator <Usuario> {
    /**
     * Al crear un usuario se debe validar que el nombre y el email no esten vacios/nulos.
     * @param usuario
     */
    @Override
    public void validate(Usuario usuario) throws GeneralException {
        if(usuario == null){
            throw new GeneralException("El USUARIO es nulo");
        }
        if(usuario.getNombre()==null){
            throw new GeneralException("El NOMBRE del usuario es nulo");
        }
        if(usuario.getNombre().isEmpty()){
            throw new GeneralException("El NOMBRE del usuario esta vacio");
        }
        if(usuario.getEmail()==null){
            throw new GeneralException("El EMAIL del usuario es nulo");
        }
        if (usuario.getEmail().isEmpty()) {
            throw new GeneralException("El EMAIL del usuario esta vacio");
        }
    }

}

