package com.tortu.api.rest.validators.ingredientesapi;

import com.tortu.api.models.Ingrediente;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class CreateIngredienteValidatorImplTest {

    private CreateIngredienteValidatorImpl createIngredienteValidator;
    @Before
    public void init(){
        createIngredienteValidator = new CreateIngredienteValidatorImpl();
    }
    @Test
    public void validate() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        ingrediente.setNombre("Tomate");
        ingrediente.setIdCategoriaIngrediente(1);

        createIngredienteValidator.validate(ingrediente);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionModelNull() {
        Ingrediente ingrediente = null;
        createIngredienteValidator.validate(ingrediente);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionNombreNull() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        ingrediente.setIdCategoriaIngrediente(1);
        createIngredienteValidator.validate(ingrediente);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionNombreEmpty() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        ingrediente.setNombre("");
        ingrediente.setIdCategoriaIngrediente(1);
        createIngredienteValidator.validate(ingrediente);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionCategoriaIngredienteNull() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        ingrediente.setNombre("Tomate");
        ingrediente.setIdCategoriaIngrediente(null);
        createIngredienteValidator.validate(ingrediente);
    }
}