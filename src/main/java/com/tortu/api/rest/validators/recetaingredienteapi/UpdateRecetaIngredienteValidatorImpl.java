package com.tortu.api.rest.validators.recetaingredienteapi;

import com.tortu.api.models.RecetaIngrediente;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Valida los datos de RecetaIngrediente para actualizar
 */
@Component("updateRecetaIngredienteValidator")
public class UpdateRecetaIngredienteValidatorImpl implements GenericValidator<RecetaIngrediente> {
    private static final Logger LOG= LoggerFactory.getLogger(UpdateRecetaIngredienteValidatorImpl.class);
    /**
     * Al actualizar un RecetaIngrediente ninguna de las propiedades puede ser vacio/nulo
     * @param modelo RecetaIngrediente que se quiere actualizar
     * @throws GeneralException cuando alguno de los campos requeridos es vacio/nulo
     */
    @Override
    public void validate(RecetaIngrediente modelo) throws GeneralException {
        if(modelo==null){
            LOG.error("RecetaIngrediente es nulo");
            throw new GeneralException("El RecetaIngrediente que se quiere actualizar es nulo");
        }
        if(modelo.getIdRecetaIngrediente()==null){
            LOG.error("idRecetaIngrediente es nulo");
            throw new GeneralException("El ID_RECETA_INGREDIENTE del RecetaIngrediente que se quiere actualizar es nulo");
        }
        if(modelo.getIdReceta()==null){
            LOG.error("idReceta es nulo");
            throw new GeneralException("El ID_RECETA del RecetaIngrediente que se quiere actualizar es nulo");
        }
        if(modelo.getIdIngrediente()==null){
            LOG.error("idIngrediente es nulo");
            throw new GeneralException("El ID_INGREDIENTE del RecetaIngrediente que se quiere actualizar es nulo");
        }
        if(modelo.getIdMedida()==null){
            LOG.error("idMedida es nulo");
            throw new GeneralException("El ID_MEDIDA del RecetaIngrediente que se quiere actualizar es nulo");
        }
        if(modelo.getCantidad()==null){
            LOG.error("cantidad es nulo");
            throw new GeneralException("La CANTIDAD del RecetaIngrediente que se quiere actualizar es nulo");
        }
    }
}
