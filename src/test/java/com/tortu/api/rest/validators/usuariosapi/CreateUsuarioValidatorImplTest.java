package com.tortu.api.rest.validators.usuariosapi;

import com.tortu.api.models.Usuario;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateUsuarioValidatorImplTest {

    private CreateUsuarioValidatorImpl createUsuarioValidator;

    @Before
    public void init(){
        createUsuarioValidator = new CreateUsuarioValidatorImpl();
    }

    /**
     * Prueba happy path
     * El usuario tiene los datos necesarios para crearse:
     * Nombre e email
     */
    @Test
    public void validate() {
        Usuario usuarioTest = new Usuario();
        usuarioTest.setNombre("Nombre de Prueba");
        usuarioTest.setEmail("correo de prueba@gmail.com");

        createUsuarioValidator.validate(usuarioTest);
    }

    /**
     * Prueba que valida la excepcion cuando el usuario es nulo
     */
    @Test(expected = GeneralException.class)
    public void validateExceptionUserNull() {
        Usuario usuarioTest = null;

        createUsuarioValidator.validate(usuarioTest);
    }

    /**
     * Prueba que valida la excepcion cuando el nombre del usuario es nulo
     */
    @Test(expected = GeneralException.class)
    public void validateExceptionNombreNull() {
        Usuario usuarioTest = new Usuario();
        usuarioTest.setEmail("correo de prueba@gmail.com");

        createUsuarioValidator.validate(usuarioTest);
    }
    /**
     * Prueba que valida la excepcion cuando el nombre del usuario esta vacio
     */
    @Test(expected = GeneralException.class)
    public void validateExceptionNombreEmpty() {
        Usuario usuarioTest = new Usuario();
        usuarioTest.setNombre("");
        usuarioTest.setEmail("correo de prueba@gmail.com");

        createUsuarioValidator.validate(usuarioTest);
    }
    /**
     * Prueba que valida la excepcion cuando el email del usuario es nulo
     */
    @Test(expected = GeneralException.class)
    public void validateExceptionEmailNull() {
        Usuario usuarioTest = new Usuario();
        usuarioTest.setNombre("Nombre de prueba");

        createUsuarioValidator.validate(usuarioTest);
    }
    /**
     * Prueba que valida la excepcion cuando el email del usuario esta vacio
     */
    @Test(expected = GeneralException.class)
    public void validateExceptionEmailEmpty() {
        Usuario usuarioTest = new Usuario();
        usuarioTest.setNombre("Nombre De Prueba");
        usuarioTest.setEmail("");

        createUsuarioValidator.validate(usuarioTest);
    }
}