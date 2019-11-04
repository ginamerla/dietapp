package com.tortu.api.rest.validators.recetaingredienteapi;

import com.tortu.api.models.RecetaIngrediente;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpdateRecetaIngredienteValidatorImplTest {

    private UpdateRecetaIngredienteValidatorImpl updateValidator;
    @Before
    public void init(){
        updateValidator=new UpdateRecetaIngredienteValidatorImpl();

    }

    @Test
    public void validate() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setIdRecetaIngrediente(23);
        recetaIngrediente.setIdReceta(65);
        recetaIngrediente.setIdIngrediente(98);
        recetaIngrediente.setIdMedida(5);
        recetaIngrediente.setCantidad(54d);

        updateValidator.validate(recetaIngrediente);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionNull() {
        RecetaIngrediente recetaIngrediente = null;
        updateValidator.validate(recetaIngrediente);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionIdRecetaNull() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setIdRecetaIngrediente(23);
        recetaIngrediente.setIdIngrediente(98);
        recetaIngrediente.setIdMedida(5);
        recetaIngrediente.setCantidad(54d);

        updateValidator.validate(recetaIngrediente);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionIdIngredienteNull() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setIdRecetaIngrediente(23);
        recetaIngrediente.setIdReceta(65);
        recetaIngrediente.setIdMedida(5);
        recetaIngrediente.setCantidad(54d);

        updateValidator.validate(recetaIngrediente);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionIdMedidaNull() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setIdRecetaIngrediente(23);
        recetaIngrediente.setIdReceta(65);
        recetaIngrediente.setIdIngrediente(98);
        recetaIngrediente.setCantidad(54d);

        updateValidator.validate(recetaIngrediente);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionCantidadNull() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setIdRecetaIngrediente(23);
        recetaIngrediente.setIdReceta(65);
        recetaIngrediente.setIdIngrediente(98);
        recetaIngrediente.setIdMedida(5);

        updateValidator.validate(recetaIngrediente);
    }
}