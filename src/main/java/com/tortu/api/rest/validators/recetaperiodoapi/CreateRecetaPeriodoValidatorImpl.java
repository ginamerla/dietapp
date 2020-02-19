package com.tortu.api.rest.validators.recetaperiodoapi;

import com.tortu.api.models.RecetaPeriodo;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Valida la informacion necesaria para crear un nuevo Receta_Periodo
 */
@Component("createRecetaPeriodoValidator")
public class CreateRecetaPeriodoValidatorImpl implements GenericValidator<RecetaPeriodo> {
    private static final Logger LOG = LoggerFactory.getLogger(CreateRecetaPeriodoValidatorImpl.class);
    /**
     * Al crear un nuevo RecetaPeriodo no es posible dejar alguno de los campos vacios o nulos
     * @param modelo RecetaPeriodo que se quiere crear
     * @throws GeneralException cuando alguno de los campos requeridos es vacio/nulo
     */
    @Override
    public void validate(RecetaPeriodo modelo) throws GeneralException {
        if(modelo==null){
            LOG.error("RecetaPeriodo is null");
            throw new GeneralException("RecetaPeriodo es nulo");
        }
        if(modelo.getIdReceta()==null){
            LOG.error("idReceta is null");
            throw new GeneralException("ID_RECETA es nulo");
        }
        if(modelo.getIdPeriodo()==null){
            LOG.error("idPeriodo is null");
            throw new GeneralException("ID_PERIODO es nulo");
        }
    }
}
