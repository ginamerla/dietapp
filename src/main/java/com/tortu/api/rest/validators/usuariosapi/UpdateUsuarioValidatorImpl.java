package com.tortu.api.rest.validators.usuariosapi;

import com.tortu.api.models.Usuario;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.springframework.stereotype.Component;

@Component("updateUsuarioValidator")
public class UpdateUsuarioValidatorImpl implements GenericValidator<Usuario> {
    /**
     * Al actualizar un usuario se debe validar que los nuevos datos no vengan nulos
     * No es posible dejar alguno de los campos en blanco
     * @param modelo
     * @throws GeneralException
     */
    @Override
    public void validate(Usuario modelo) throws GeneralException {
        if(modelo.getIdUsuario()==null){
            throw new GeneralException("El ID del usuario es nulo");
        }
        if(modelo.getEmail()==null){
            throw new GeneralException("El EMAIL del usuario es nulo");
        }
        if(modelo.getEmail().isEmpty()){
            throw new GeneralException("El EMAIL del usuario esta vacio");
        }
        if(modelo.getNombre()==null){
            throw new GeneralException("El NOMBRE del usuario es nulo");
        }
        if(modelo.getNombre().isEmpty()){
            throw new GeneralException("El NOMBRE del usuario esta vacio");
        }
    }
}
