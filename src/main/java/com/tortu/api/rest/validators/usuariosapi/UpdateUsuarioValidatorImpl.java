package com.tortu.api.rest.validators.usuariosapi;

import com.tortu.api.models.Usuario;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Valida los datos para actualizar un Usuario
 */
@Component("updateUsuarioValidator")
public class UpdateUsuarioValidatorImpl implements GenericValidator<Usuario> {
    /**
     * Al actualizar un usuario se debe validar que los nuevos datos no vengan nulos
     * No es posible dejar alguno de los campos en blanco
     * @param modelo el usuario que se quiere actualizar
     * @throws GeneralException cuando alguno de los datos requeridos es nulo/vacio
     */
    @Override
    public void validate(Usuario modelo) throws GeneralException {
        if(modelo == null){
            throw new GeneralException("El USUARIO es nulo");
        }
        if(modelo.getIdUsuario()==null){
            throw new GeneralException("El ID del usuario es nulo");
        }
        if(StringUtils.isBlank(modelo.getNombre())){
            throw new GeneralException("El NOMBRE del usuario es nulo/vacio");
        }
        if(StringUtils.isBlank(modelo.getEmail())) {
            throw new GeneralException("El EMAIL del usuario es nulo/vacio");
        }
    }
}
