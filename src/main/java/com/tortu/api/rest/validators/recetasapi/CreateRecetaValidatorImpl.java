package com.tortu.api.rest.validators.recetasapi;

import com.tortu.api.models.Receta;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Valida los campos para crear una nueva receta
 */
@Component("createRecetaValidator")
public class CreateRecetaValidatorImpl implements GenericValidator<Receta> {
    /**
     * Al crear una nueva receta el nombre no puede estar vacio/nulo
     * @param modelo la receta que se quiere guardar
     * @throws GeneralException cuando alguno de los datos requeridos es nulo/vacio
     */
    @Override
    public void validate(Receta modelo) throws GeneralException {
        if(modelo==null){
            throw new GeneralException("La RECETA es nulo");
        }
        if(StringUtils.isBlank(modelo.getNombre())){
            throw new GeneralException("El NOMBRE de la receta esta vacio'nulo");
        }
    }
}
