package com.tortu.api.rest.validators.ingredientesapi;

import com.tortu.api.models.Ingrediente;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpdateIngredienteValidatorImplTest {

    private UpdateIngredienteValidatorImpl updateIngredienteValidator;

    @Before
    public void init(){
        updateIngredienteValidator = new UpdateIngredienteValidatorImpl();
    }

    @Test
    public void validate() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        ingrediente.setNombre("Tomate");
        ingrediente.setIdCategoriaIngrediente(1);
        updateIngredienteValidator.validate(ingrediente);
    }

    @Test(expected = GeneralException.class)
    public void validateExceptionModelNull() {
        Ingrediente ingrediente = null;
        updateIngredienteValidator.validate(ingrediente);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionIdIngredienteNull() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre("Tomate");
        ingrediente.setIdCategoriaIngrediente(1);
        updateIngredienteValidator.validate(ingrediente);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionNombreNull() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        ingrediente.setIdCategoriaIngrediente(1);
        updateIngredienteValidator.validate(ingrediente);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionNombreEmpty() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        ingrediente.setNombre("");
        ingrediente.setIdCategoriaIngrediente(1);
        updateIngredienteValidator.validate(ingrediente);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionIdCategoriaIngredienteNull() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        ingrediente.setNombre("Tomate");
        updateIngredienteValidator.validate(ingrediente);
    }
}