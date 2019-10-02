package com.tortu.api.rest.validators.categoriasingredienteapi;

import com.tortu.api.models.CategoriaIngrediente;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Valida que todos los datos de categoria ingrediente sean validos para poder agregar una nueva
 */
@Component("createCategoriaIngredienteValidator")
public class CreateCategoriaIngredienteValidatorImpl implements GenericValidator<CategoriaIngrediente> {
    /**
     * Valida que los datos sean correctos
     * No es posible agregar una categoria con ID o nombre nulo
     * @param modelo
     * @throws GeneralException
     */
    @Override
    public void validate(CategoriaIngrediente modelo) throws GeneralException {
        if(modelo==null){
            throw new GeneralException("La CATEGORIA_INGREDIENTE es nula");
        }
        if(StringUtils.isBlank(modelo.getNombre())){
            throw new GeneralException("El NOMBRE de la categoria_ingrediente es nulo o vacio");
        }
    }
}
