package com.tortu.api.rest.validators.categoriasingredienteapi;

import com.tortu.api.models.CategoriaIngrediente;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;

public class CreateCategoriaIngredienteValidatorImplTest {

    private CreateCategoriaIngredienteValidatorImpl createCategoriaIngredienteValidator;

    @Before
    public void init(){
        createCategoriaIngredienteValidator = new CreateCategoriaIngredienteValidatorImpl();
    }

    @Test
    public void validate() {
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        categoriaIngrediente.setIdCategoriaIngrediente(1);
        categoriaIngrediente.setNombre("Nombre Categoria");

        createCategoriaIngredienteValidator.validate(categoriaIngrediente);
    }

    @Test(expected = GeneralException.class)
    public void validateExceptionModelNull(){
        CategoriaIngrediente categoriaIngrediente = null;
        createCategoriaIngredienteValidator.validate(categoriaIngrediente);
    }

    @Test(expected = GeneralException.class)
    public void validateCategoriaIngredienteExceptionNombreNull(){
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        createCategoriaIngredienteValidator.validate(categoriaIngrediente);
    }

    @Test(expected = GeneralException.class)
    public void validateCategoriaIngredienteExceptionNombreEmpty(){
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        categoriaIngrediente.setNombre("");
        createCategoriaIngredienteValidator.validate(categoriaIngrediente);
    }
}