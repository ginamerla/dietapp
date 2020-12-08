package com.tortu.api.rest.validators.usuariosapi;

import com.tortu.api.models.Usuario;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Valida los datos para crear un nuevo Usuario
 */
@Component("createUsuarioValidator")
public class CreateUsuarioValidatorImpl implements GenericValidator <Usuario> {
    /**
     * Al crear un usuario se debe validar que el nombre y el email no esten vacios/nulos.
     * @param usuario que se quiere crear
     * @throws GeneralException cuando alguno de los datos requeridos es nulo/vacio
     */
    @Override
    public void validate(Usuario usuario) throws GeneralException {
        if(usuario==null){
            throw new GeneralException("El USUARIO es nulo");
        }

        if(StringUtils.isBlank(usuario.getNombre())){
            throw new GeneralException("El NOMBRE del usuario es nulo o vacio");
        }

        if(StringUtils.isBlank(usuario.getEmail())){
            throw new GeneralException("El EMAIL del usuario es nulo o vacio");
        }

    }

}

