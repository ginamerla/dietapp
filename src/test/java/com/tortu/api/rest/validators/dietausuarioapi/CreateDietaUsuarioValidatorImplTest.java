package com.tortu.api.rest.validators.dietausuarioapi;

import com.tortu.api.models.DietaUsuario;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;

public class CreateDietaUsuarioValidatorImplTest {

    private CreateDietaUsuarioValidatorImpl createDietaUsarioValidator;
    @Before
    public void init(){
        createDietaUsarioValidator = new CreateDietaUsuarioValidatorImpl();
    }
    @Test
    public void validate() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuario.setIdUsuario(1);
        dietaUsuario.setDiaSemana("Lunes");

        createDietaUsarioValidator.validate(dietaUsuario);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionModelNull() {
        DietaUsuario dietaUsuario = null;
        createDietaUsarioValidator.validate(dietaUsuario);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionIdUsuarioNull() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuario.setDiaSemana("Lunes");

        createDietaUsarioValidator.validate(dietaUsuario);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionDiaSemanaEmpty() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuario.setIdUsuario(1);
        dietaUsuario.setDiaSemana("");

        createDietaUsarioValidator.validate(dietaUsuario);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionDiaSemanaNull() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuario.setIdUsuario(1);

        createDietaUsarioValidator.validate(dietaUsuario);
    }
}