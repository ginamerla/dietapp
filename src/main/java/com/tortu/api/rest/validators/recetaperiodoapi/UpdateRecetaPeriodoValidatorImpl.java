package com.tortu.api.rest.validators.recetaperiodoapi;

import com.tortu.api.models.RecetaPeriodo;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Valida los datos para actualizar un RecetaPeriodo
 */
@Component("updateRecetaPeriodoValidator")
public class UpdateRecetaPeriodoValidatorImpl implements GenericValidator<RecetaPeriodo> {
    private static final Logger LOG = LoggerFactory.getLogger(UpdateRecetaPeriodoValidatorImpl.class);
    /**
     * Al actualizar un RecetaPeriodo no es posible dejar ninguno de los campos en blanco/nulos
     * @param modelo RecetaPeriodo que se quiere actualizar
     * @throws GeneralException cuando alguno de los campos requerido es vacio/nulo
     */
    @Override
    public void validate(RecetaPeriodo modelo) throws GeneralException {
        if(modelo==null){
            LOG.error("RecetaPeriodo es nulo");
            throw new GeneralException("El RecetaPeriodo es nulo");
        }
        if(modelo.getIdRecetaPeriodo()==null){
            LOG.error("idRecetaPeriodo es nulo");
            throw new GeneralException("El ID de RecetaPeriodo es nulo");
        }
        if(modelo.getIdReceta()==null){
            LOG.error("idReceta es nulo");
            throw new GeneralException("El ID_RECETA de RecetaPeriodo es nulo");
        }
        if(modelo.getIdPeriodo()==null){
            LOG.error("idPeriodo es nulo");
            throw new GeneralException("El ID_PERIODO de RecetaPeriodo es nulo");
        }
    }
}
