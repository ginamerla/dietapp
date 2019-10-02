package com.tortu.api.rest.validators.categoriasingredienteapi;

import com.tortu.api.models.CategoriaIngrediente;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;

public class UpdateCategoriaIngredienteValidatorImplTest {

    private UpdateCategoriaIngredienteValidatorImpl updateCategoriaIngredienteValidator;

    @Before
    public void init (){
        updateCategoriaIngredienteValidator = new UpdateCategoriaIngredienteValidatorImpl();
    }
    @Test
    public void validate() {
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        categoriaIngrediente.setNombre("Prueba Categoria Nombre");
        categoriaIngrediente.setIdCategoriaIngrediente(1);

        updateCategoriaIngredienteValidator.validate(categoriaIngrediente);
    }

    @Test(expected = GeneralException.class)
    public void validateExceptionModelNull() {
        CategoriaIngrediente categoriaIngrediente = null;
        updateCategoriaIngredienteValidator.validate(categoriaIngrediente);
    }

    @Test(expected = GeneralException.class)
    public void validateExceptionIdNull() {
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        updateCategoriaIngredienteValidator.validate(categoriaIngrediente);
    }

    @Test(expected = GeneralException.class)
    public void validateExceptionNombreNull() {
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        categoriaIngrediente.setIdCategoriaIngrediente(1);

        updateCategoriaIngredienteValidator.validate(categoriaIngrediente);
    }

    @Test(expected = GeneralException.class)
    public void validateExceptionNombreEmpty() {
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        categoriaIngrediente.setNombre("");
        categoriaIngrediente.setIdCategoriaIngrediente(1);

        updateCategoriaIngredienteValidator.validate(categoriaIngrediente);
    }
}