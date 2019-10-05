package com.tortu.api.rest.validators.recetaperiodoapi;

import com.tortu.api.models.RecetaPeriodo;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateRecetaPeriodoValidatorImplTest {

    private CreateRecetaPeriodoValidatorImpl createValidator;
    @Before
    public void init(){
        createValidator = new CreateRecetaPeriodoValidatorImpl();
    }

    @Test
    public void validate() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        recetaPeriodo.setIdReceta(29);
        recetaPeriodo.setIdPeriodo(9);
        createValidator.validate(recetaPeriodo);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionModelNull() {
        RecetaPeriodo recetaPeriodo = null;
        createValidator.validate(recetaPeriodo);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionIdRecetaNull() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        recetaPeriodo.setIdPeriodo(9);
        createValidator.validate(recetaPeriodo);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionIdPeriodoNull() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        recetaPeriodo.setIdReceta(29);
        createValidator.validate(recetaPeriodo);
    }
}