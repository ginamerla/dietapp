package com.tortu.api.rest.validators.dietausuarioapi;

import com.tortu.api.models.DietaUsuario;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Validador para crear un nuevo DIETA_USUARIO
 */
@Component("createDietaUsuarioValidator")
public class CreateDietaUsuarioValidatorImpl implements GenericValidator<DietaUsuario> {
    /**
     * Al crear una nueva dieta_usuario el ID y el DIA_SEMANA no pueden ser nulos/vacios
     * @param modelo
     * @throws GeneralException
     */
    @Override
    public void validate(DietaUsuario modelo) throws GeneralException {
        if(modelo==null){
            throw new GeneralException("La DIETA_USUARIO es nulo");
        }
        if(modelo.getIdUsuario()==null){
            throw new GeneralException("El ID del Usuario es nulo");
        }
        if(StringUtils.isBlank(modelo.getDiaSemana())){
            throw new GeneralException("El DIA_SEMANA de la dieta_usuario es nulo o vacio");
        }
    }
}
