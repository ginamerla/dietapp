package com.tortu.api.rest.validators.usuariosapi;

import com.tortu.api.models.Usuario;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FindUsuarioByIDValidatorImplTest {

    private FindUsuarioByIDValidatorImpl findUsuarioByIDValidator;

    @Before
    public void init(){
        findUsuarioByIDValidator = new FindUsuarioByIDValidatorImpl();
    }

    /**
     * Happy Path
     * Prueba que valida que el usuario contenga un id valido
     */
    @Test
    public void validate() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);

        findUsuarioByIDValidator.validate(usuario);
    }
    /**
     * Prueba que valida la excepcion cuando el usuario es nulo
     */
    @Test(expected = GeneralException.class)
    public void validateExceptionUserNull() {
        Usuario usuario = null;

        findUsuarioByIDValidator.validate(usuario);
    }
    /**
     * Prueba que valida la excepcion cuando el id el usuario es nulo
     */
    @Test(expected = GeneralException.class)
    public void validateExceptionIdNull() {
        Usuario usuario = new Usuario();

        findUsuarioByIDValidator.validate(usuario);
    }
}