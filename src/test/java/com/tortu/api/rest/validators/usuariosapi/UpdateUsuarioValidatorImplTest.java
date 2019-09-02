package com.tortu.api.rest.validators.usuariosapi;

import com.tortu.api.models.Usuario;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UpdateUsuarioValidatorImplTest {

    private UpdateUsuarioValidatorImpl updateUsuarioValidator;

    @Before
    public void init(){
        updateUsuarioValidator = new UpdateUsuarioValidatorImpl();
    }

    /**
     * Prueba Happy Path
     * Valida que el usuario tenga todos los datos para poder ser actualizado
     */
    @Test
    public void validate() {
        Usuario usuarioTest = new Usuario();
        usuarioTest.setIdUsuario(1);
        usuarioTest.setNombre("Nombre Actualizado");
        usuarioTest.setEmail("email_nuevo@gmail.com");

        updateUsuarioValidator.validate(usuarioTest);
    }

    /**
     * Prueba que valida la excepcion cuando el usuario es nulo
     */
    @Test(expected = GeneralException.class)
    public void validateExceptionUsuarioNull() {
        Usuario usuarioTest = null;

        updateUsuarioValidator.validate(usuarioTest);
    }

    /**
     * Prueba que valida la excepcion cuando el id del usuario es nulo
     */
    @Test(expected = GeneralException.class)
    public void validateExceptionIdNull() {
        Usuario usuarioTest = new Usuario();

        updateUsuarioValidator.validate(usuarioTest);
    }

    /**
     * Prueba que valida la excepcion cuando el nombre es nulo/vacio
     */
    @Test(expected = GeneralException.class)
    public void validateExceptionNombreBlank() {
        Usuario usuarioTest = new Usuario();
        usuarioTest.setIdUsuario(1);

        updateUsuarioValidator.validate(usuarioTest);
    }

    /**
     * Prueba que valida la excepcion cuando el email es nulo/vacio
     */
    @Test(expected = GeneralException.class)
    public void validateExceptionEmailBlank() {
        Usuario usuarioTest = new Usuario();
        usuarioTest.setIdUsuario(1);
        usuarioTest.setNombre("Nombre de Prueba");
        usuarioTest.setEmail("");

        updateUsuarioValidator.validate(usuarioTest);
    }
}