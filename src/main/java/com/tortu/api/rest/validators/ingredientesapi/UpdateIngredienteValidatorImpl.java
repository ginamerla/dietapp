package com.tortu.api.rest.validators.ingredientesapi;

import com.tortu.api.models.Ingrediente;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component("updateIngredienteValidator")
public class UpdateIngredienteValidatorImpl implements GenericValidator<Ingrediente> {
    /**
     * Valida la informacion para actualizar un ingrediente
     * El Id, el nombre y el id de la categoria no pueden ser vacios/nulos
     * @param modelo
     * @throws GeneralException
     */
    @Override
    public void validate(Ingrediente modelo) throws GeneralException {
        if(modelo==null){
            throw new GeneralException("El INGREDIENTE es nulo");
        }
        if(modelo.getIdIngrediente()==null){
            throw new GeneralException("El ID del ingrediente es nulo");
        }
        if(StringUtils.isBlank(modelo.getNombre())){
            throw new GeneralException("El NOMBRE del ingrediente es nulo o vacio");
        }
        if(modelo.getIdCategoriaIngrediente()==null){
            throw new GeneralException("El ID de la CATEGORIA es nulo");
        }

    }
}
