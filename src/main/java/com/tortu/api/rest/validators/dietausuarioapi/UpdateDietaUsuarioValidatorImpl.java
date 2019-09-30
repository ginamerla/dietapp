package com.tortu.api.rest.validators.dietausuarioapi;

import com.tortu.api.models.DietaUsuario;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component("updateDietaUsuarioValidator")
public class UpdateDietaUsuarioValidatorImpl implements GenericValidator<DietaUsuario> {
    /**
     * AL actualizar la dieta_usuario el ID_DIETA_USUARIO, ID_USUARIO y/o DIA_SEMANA no pueden ser vacios/nulos
      * @param modelo
     * @throws GeneralException
     */
    @Override
    public void validate(DietaUsuario modelo) throws GeneralException {
        if(modelo==null){
            throw new GeneralException("La DIETA_USUARIO es nulo");
        }
        if(modelo.getIdDietaUsuario()==null){
            throw new GeneralException("El ID de la dieta_usuario es nulo");
        }
        if(modelo.getIdUsuario()==null){
            throw new GeneralException("el ID_USUARIO de la dieta_usuario es nulo");
        }
        if(StringUtils.isBlank(modelo.getDiaSemana())){
            throw new GeneralException("El DIA_SEMANA de la dieta_usuario es nulo/vacio");
        }
    }
}
