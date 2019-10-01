package com.tortu.api.rest.validators.layoutperiodoapi;

import com.tortu.api.models.LayoutPeriodo;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.springframework.stereotype.Component;

/**
 * Implmentacion del validador para actualizar un LayoutPeriodo
 */
@Component("updateLayoutPeriodoValidator")
public class UpdateLayoutPeriodoValidatorImpl implements GenericValidator<LayoutPeriodo> {
    /**
     * Al actualizar un LayoutPeriodo ninguno de los campos puede ser vacio/nulo
     * @param modelo el Layout_Periodo que se va a actualizar
     * @throws GeneralException cuando alguno de los campos requeridos es vacio/nulo
     */
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
