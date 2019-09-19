package com.tortu.api.rest.validators.recetasapi;

import com.tortu.api.models.Receta;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class UpdateRecetaValidatorImplTest {

    private UpdateRecetaValidatorImpl updateRecetaValidator;

    @Before
    public void init(){
        updateRecetaValidator = new UpdateRecetaValidatorImpl();
    }

    @Test
    public void validate() {
        Receta receta = new Receta();
        receta.setIdReceta(1);
        receta.setNombre("Licuado");

        updateRecetaValidator.validate(receta);
    }

    @Test(expected = GeneralException.class)
    public void validateRecetaNull(){
        Receta receta = null;

        updateRecetaValidator.validate(receta);
    }

    @Test(expected = GeneralException.class)
    public void validateRecetaIdNull(){
        Receta receta = new Receta();

        updateRecetaValidator.validate(receta);
    }

    @Test(expected = GeneralException.class)
    public void validateRecetaNombreEmpty(){
        Receta receta = new Receta();
        receta.setIdReceta(1);
        receta.setNombre("");
        updateRecetaValidator.validate(receta);
    }

    @Test(expected = GeneralException.class)
    public void validateRecetaNombreNull(){
        Receta receta = new Receta();
        receta.setIdReceta(1);

        updateRecetaValidator.validate(receta);
    }
}