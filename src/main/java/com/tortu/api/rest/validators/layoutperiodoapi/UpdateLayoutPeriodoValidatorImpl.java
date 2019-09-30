package com.tortu.api.rest.validators.layoutperiodoapi;

import com.tortu.api.models.LayoutPeriodo;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.springframework.stereotype.Component;

/**
 * Implmentacion del validador para actualizar un LayoutPeriodo
 * Ninguno de los campos pueden ser vacios/nulos
 */
@Component("updateLayoutPeriodoValidator")
public class UpdateLayoutPeriodoValidatorImpl implements GenericValidator<LayoutPeriodo> {
    @Override
    public void validate(LayoutPeriodo modelo) throws GeneralException {
        if(modelo==null){
            throw new GeneralException("El LayoutPeriodo es nulo");
        }
        if(modelo.getIdLayoutPeriodo()==null){
            throw new GeneralException("El id del LayoutPeriodo es nulo");
        }
        if(modelo.getIdLayout()==null){
            throw new GeneralException("El idLayout del LayoutPeriodo es nulo");
        }
        if(modelo.getIdPeriodo()==null){
            throw new GeneralException("El idPeriodo del LayoutPeriodo es nulo");
        }
    }
}
