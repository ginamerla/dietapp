package com.tortu.api.rest.mappers;

import com.tortu.api.models.Usuario;
import com.tortu.api.rest.resources.UsuarioResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioResourceMapperTest {

    private UsuarioResourceMapper usuarioResourceMapper;

    @Before
    public void init (){
        usuarioResourceMapper = new UsuarioResourceMapper();
    }

    /**
     * Prueba happy path
     */
    @Test
    public void map() {
        Usuario usuario = new Usuario();
        usuario.setNombre("testnombre");
        usuario.setEmail("emailtest");
        usuario.setIdUsuario(1);

        UsuarioResource actualResult = usuarioResourceMapper.map(usuario);

        assertNotNull(actualResult);
        assertEquals("testnombre",actualResult.getNombre());
        assertEquals("emailtest",actualResult.getEmail());
        assertEquals(1,actualResult.getId().intValue());
    }

    /**
     * Prueba con el modelo recibido como argumento nulo
     */
    @Test
    public void mapModelNull(){
        UsuarioResource actualResult = usuarioResourceMapper.map(null);
        assertNull(actualResult);
    }
}