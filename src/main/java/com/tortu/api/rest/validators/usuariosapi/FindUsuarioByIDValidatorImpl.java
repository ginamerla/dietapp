package com.tortu.api.rest.validators.usuariosapi;

import com.tortu.api.models.Usuario;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.springframework.stereotype.Component;

@Component("findUsuarioByIdValidator")
public class FindUsuarioByIDValidatorImpl implements GenericValidator<Usuario> {
    /**
     * Valida el ID del usuario que no sea nulo o cero
     * @param modelo
     * @throws GeneralException
     */
    @Override
    public void validate(Usuario modelo) throws GeneralException {
        if(modelo.getIdUsuario()==null){
            throw new GeneralException("El ID del usuario es nulo");
        }
        if(modelo.getIdUsuario().intValue()==0){
            throw new GeneralException("El ID del usuario es incorrecto(0)");
        }
    }
}
