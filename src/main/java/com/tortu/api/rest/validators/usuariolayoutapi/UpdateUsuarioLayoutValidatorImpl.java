package com.tortu.api.rest.validators.usuariolayoutapi;

import com.tortu.api.models.UsuarioLayout;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.springframework.stereotype.Component;

/**
 * Valida los campos para actualizar un UsuarioLayout
 */
@Component("updateUsuarioLayoutValidator")
public class UpdateUsuarioLayoutValidatorImpl implements GenericValidator<UsuarioLayout> {
    /**
     * Al momento de actualizar un UsuarioLayout Ninguno de los campos puede ser vacio/nulo
     * @param modelo el UsuarioLayout que se quiere actualizar
     * @throws GeneralException cuando alguno de los campos requeridos es vacio/nulo
     */
    @Override
    public void validate(UsuarioLayout modelo) throws GeneralException {
        if(modelo==null){
            throw new GeneralException("El UsuarioLayout es nulo");
        }
        if(modelo.getIdUsuarioLayout()==null){
            throw new GeneralException("El id del UsuarioLayout es nulo");
        }
        if(modelo.getIdUsuario()==null){
            throw new GeneralException("El idUsuario del UsuarioLayout es nulo");
        }
        if(modelo.getIdLayout()==null){
            throw new GeneralException("El idLayout del UsuarioLayout es nulo");
        }
        if(modelo.getFecha()==null){
            throw new GeneralException("La fecha del UsuarioLayout es nulo");
        }
    }
}
