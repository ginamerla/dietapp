package com.tortu.api.rest.validators.layoutperiodoapi;

import com.tortu.api.models.LayoutPeriodo;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Implementacion del validador para crear un nuevo layoutPeriodo
 * El idPeriodo y/o el idLayout no pueden ser vacios/nulos
 */
@Component("createLayoutPeriodoValidator")
public class CreateLayoutPeriodoValidatorImpl implements GenericValidator<LayoutPeriodo> {
    @Override
    public void validate(LayoutPeriodo modelo) throws GeneralException {
        if(modelo==null){
            throw new GeneralException("El LayoutPeriodo es nulo");
        }
        if(modelo.getIdLayout()==null){
            throw new GeneralException("El idLayout del LayoutPeriodo es nulo");
        }
        if(modelo.getIdPeriodo()==null){
            throw new GeneralException("El idPeriodo del LayoutPeriodo es nulo");
        }
    }
}
