package com.tortu.api.rest.validators.categoriasingredienteapi;

import com.tortu.api.models.CategoriaIngrediente;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Valida que los datos sean validos para actualizar la categoria_ingrediente
 */
@Component("updateCategoriaIngredienteValidator")
public class UpdateCategoriaIngredienteValidatorImpl implements GenericValidator<CategoriaIngrediente> {
    /**
     * Valida que los datos sean correctos
     * El id o el nombre de la categoria no puede ser nulo
     * @param modelo
     * @throws GeneralException
     */
    @Override
    public void validate(CategoriaIngrediente modelo) throws GeneralException {
        if(modelo==null){
            throw new GeneralException("La CATEGORIA_INGREDIENTE es nula");
        }
        if(modelo.getIdCategoriaIngrediente()==null){
            throw new GeneralException("El ID de categoria_ingrediente es nulo");
        }
        if(StringUtils.isBlank(modelo.getNombre())){
            throw new GeneralException("El NOMBRE de categoria_ingrediente es nulo o vacio");
        }
    }
}
