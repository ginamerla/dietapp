package com.tortu.api.rest.validators.recetasapi;

import com.tortu.api.models.Receta;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Valida los datos para actualizar una Receta
 */
@Component("updateRecetaValidator")
public class UpdateRecetaValidatorImpl implements GenericValidator<Receta> {
    /**
     * Al actualizar una receta ninguno de los campos deben estar vacios o nulos
     * @param modelo la receta que se quiere actualizar
     * @throws GeneralException cuando alguno de los datos requeridos es nulo/vacio
     */
    @Override
    public void validate(Receta modelo) throws GeneralException {
        if(modelo==null){
            throw new GeneralException("La RECETA es nulo");
        }
        if(modelo.getIdReceta()==null){
            throw new GeneralException("El ID de la receta es nulo");
        }
        if(StringUtils.isBlank(modelo.getNombre())){
            throw new GeneralException("El NOMBRE de la receta es nulo o vacio");
        }
    }
}
