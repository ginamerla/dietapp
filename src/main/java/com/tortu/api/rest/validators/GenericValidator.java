package com.tortu.api.rest.validators;

import com.tortu.api.utils.GeneralException;

public interface GenericValidator <T>{
    /**
     * Valida un objeto "modelo"
     * @param modelo
     */
   public void validate(T modelo) throws GeneralException;

}
