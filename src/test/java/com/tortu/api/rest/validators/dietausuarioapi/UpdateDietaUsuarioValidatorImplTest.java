package com.tortu.api.rest.validators.dietausuarioapi;

import com.tortu.api.models.DietaUsuario;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UpdateDietaUsuarioValidatorImplTest {

    private UpdateDietaUsuarioValidatorImpl updateDietaUsuarioValidator;
    @Before
    public void init(){
        updateDietaUsuarioValidator=new UpdateDietaUsuarioValidatorImpl();
    }
    @Test
    public void validate() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuario.setIdDietaUsuario(1);
        dietaUsuario.setIdUsuario(1);
        dietaUsuario.setDiaSemana("Lunes");

        updateDietaUsuarioValidator.validate(dietaUsuario);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionModelNull() {
        DietaUsuario dietaUsuario = null;

        updateDietaUsuarioValidator.validate(dietaUsuario);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionIdDietaUsuarioNull() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuario.setIdUsuario(1);
        dietaUsuario.setDiaSemana("Lunes");

        updateDietaUsuarioValidator.validate(dietaUsuario);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionIdUsuarioNull() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuario.setIdDietaUsuario(1);
        dietaUsuario.setDiaSemana("Lunes");

        updateDietaUsuarioValidator.validate(dietaUsuario);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionDiaSemanaEmpty() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuario.setIdDietaUsuario(1);
        dietaUsuario.setIdUsuario(1);
        dietaUsuario.setDiaSemana("");

        updateDietaUsuarioValidator.validate(dietaUsuario);
    }
    @Test(expected = GeneralException.class)
    public void validateExceptionDiaSemanaNull() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuario.setIdDietaUsuario(1);
        dietaUsuario.setIdUsuario(1);

        updateDietaUsuarioValidator.validate(dietaUsuario);
    }
}