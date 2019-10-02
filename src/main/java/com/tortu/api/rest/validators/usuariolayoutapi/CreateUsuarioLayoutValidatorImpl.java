package com.tortu.api.rest.validators.usuariolayoutapi;

import com.tortu.api.models.UsuarioLayout;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.springframework.stereotype.Component;

/**
 * Valida los datos de UsuarioLayout para crear uno nuevo

 */
@Component("createUsuarioLayoutValidator")
public class CreateUsuarioLayoutValidatorImpl implements GenericValidator<UsuarioLayout> {
    /**
     * Valida El idUsuario, idLayout y/o fecha no pueden ser nulos o vacios
     * @param modelo el UsuarioLayout que se quiere crear
     * @throws GeneralException cuando alguno de los datos requeridos es nulo/vacio
     */
    @Override
    public void validate(UsuarioLayout modelo) throws GeneralException {
        if(modelo== null){
            throw new GeneralException("El UsuarioLayout es nulo");
        }
        if(modelo.getIdUsuario()==null){
            throw new GeneralException("El idUsuario es nulo");
        }
        if(modelo.getIdLayout()==null){
            throw new GeneralException("El idLayout es nulo");
        }
        if(modelo.getFecha()==null){
            throw new GeneralException("La fecha es nula");
        }
    }
}
