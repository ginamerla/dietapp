package com.tortu.api.rest.validators.recetasapi;

import com.tortu.api.models.Receta;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateRecetaValidatorImplTest {

    private CreateRecetaValidatorImpl createRecetaValidator;

    @Before
    public void init(){
        createRecetaValidator = new CreateRecetaValidatorImpl();
    }

    /**
     * Happy path
     */
    @Test
    public void validate() {
        Receta receta = new Receta();
        receta.setIdReceta(1);
        receta.setNombre("Banana Bowl");

        createRecetaValidator.validate(receta);
    }

    @Test(expected = GeneralException.class)
    public void validateRecetaNull(){
        Receta receta = null;

        createRecetaValidator.validate(receta);
    }

    @Test(expected = GeneralException.class)
    public void validateNombreEmpty(){
        Receta receta = new Receta();
        receta.setIdReceta(1);
        receta.setNombre("");

        createRecetaValidator.validate(receta);
    }

    @Test(expected = GeneralException.class)
    public void validateNombreNull(){
        Receta receta = new Receta();
        receta.setIdReceta(1);

        createRecetaValidator.validate(receta);
    }
}