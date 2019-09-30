package com.tortu.api.rest.validators.ingredientesapi;

import com.tortu.api.models.Ingrediente;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component("createIngredienteValidator")
public class CreateIngredienteValidatorImpl implements GenericValidator<Ingrediente> {
    /**
     * Valida los datos al crear un nuevo ingrediente
     * El nombre y el id de la categoria no pueden estar vacios
     * @param modelo
     * @throws GeneralException
     */
    @Override
    public void validate(Ingrediente modelo) throws GeneralException {
        if(modelo==null){
            throw new GeneralException("El INGREDIENTE es nulo");
        }
        if(StringUtils.isBlank(modelo.getNombre())){
            throw new GeneralException(("El NOMBRE del ingrediente esta vacio o nulo"));
        }
        if(modelo.getIdCategoriaIngrediente()==null){
            throw new GeneralException("El ID de la CATEGORIA es nulo");
        }
    }
}
