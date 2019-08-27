package com.tortu.api.services.impl;

import com.tortu.api.models.Usuario;
import com.tortu.api.services.UsuarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Unit test para el FakeUsuario service class.
 * @author visilva
 */
@RunWith(MockitoJUnitRunner.class)
public class FakeUsuarioServiceImplTest {

    @InjectMocks
    private UsuarioService usuarioService = new FakeUsuarioServiceImpl();

    @Test
    public void obtenerUsuarioPorId() {
        Usuario result = usuarioService.obtenerUsuarioPorId(1);
        assertNotNull(result);
        assertEquals(result.getEmail(), "papol@gmail.com");
        assertEquals(result.getIdUsuario().intValue(), 1);
        assertEquals(result.getNombre(), "papol");
    }
}