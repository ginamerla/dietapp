package com.tortu.api.rest.validators.recetaperiodoapi;

import com.tortu.api.models.RecetaPeriodo;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpdateRecetaPeriodoValidatorImplTest {

    private UpdateRecetaPeriodoValidatorImpl updateValidator;
    @Before
    public void init(){
        updateValidator = new UpdateRecetaPeriodoValidatorImpl();
    }
    @Test
    public void validate() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        recetaPeriodo.setIdRecetaPeriodo(47);
        recetaPeriodo.setIdReceta(29);
        recetaPeriodo.setIdPeriodo(9);
        updateValidator.validate(recetaPeriodo);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionModelNull() {
        RecetaPeriodo recetaPeriodo = null;
        updateValidator.validate(recetaPeriodo);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionIdRecetaPeriodoNull() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        recetaPeriodo.setIdReceta(29);
        recetaPeriodo.setIdPeriodo(9);
        updateValidator.validate(recetaPeriodo);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionIdRecetaNull() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        recetaPeriodo.setIdRecetaPeriodo(47);
        recetaPeriodo.setIdPeriodo(9);
        updateValidator.validate(recetaPeriodo);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionIdPeriodoNull() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        recetaPeriodo.setIdRecetaPeriodo(47);
        recetaPeriodo.setIdReceta(29);
        updateValidator.validate(recetaPeriodo);
    }
}