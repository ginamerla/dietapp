package com.tortu.api.rest.validators.layoutperiodoapi;

import com.tortu.api.models.LayoutPeriodo;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class CreateLayoutPeriodoValidatorImplTest {

    private CreateLayoutPeriodoValidatorImpl validator;
    @Before
    public void init(){
        validator = new CreateLayoutPeriodoValidatorImpl();
    }
    @Test
    public void validate() {
        LayoutPeriodo layoutPeriodo = new LayoutPeriodo();
        layoutPeriodo.setIdLayoutPeriodo(1);
        layoutPeriodo.setIdLayout(1);
        layoutPeriodo.setIdPeriodo(1);
        validator.validate(layoutPeriodo);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionIdModelNull() {
        LayoutPeriodo layoutPeriodo = null;
        validator.validate(layoutPeriodo);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionIdLayoutNull() {
        LayoutPeriodo layoutPeriodo = new LayoutPeriodo();
        layoutPeriodo.setIdLayoutPeriodo(1);
        layoutPeriodo.setIdPeriodo(1);
        validator.validate(layoutPeriodo);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionIdPeriodoNull() {
        LayoutPeriodo layoutPeriodo = new LayoutPeriodo();
        layoutPeriodo.setIdLayoutPeriodo(1);
        layoutPeriodo.setIdLayout(1);
        validator.validate(layoutPeriodo);
    }
}