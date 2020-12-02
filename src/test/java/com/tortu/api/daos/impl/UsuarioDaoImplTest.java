package com.tortu.api.daos.impl;

import com.tortu.api.daos.mappers.UsuarioRowMapper;
import com.tortu.api.models.Usuario;
import com.tortu.api.utils.GeneralException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioDaoImplTest {

    @InjectMocks
    private UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();

    @Mock
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    /**
     * Prueba que se guarde el usuario
     * Happy path
     */
    @Test
    public void save() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setNombre("Test Name");
        usuario.setEmail("mail@test.com");

        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(1);

        usuarioDao.save(usuario);

        Mockito.verify(jdbcTemplate, Mockito.times(1)).update(Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
    }
    @Test(expected = GeneralException.class)
    public void saveException() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setNombre("Test Name");
        usuario.setEmail("mail@test.com");
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(0);
        usuarioDao.save(usuario);
        Mockito.verify(jdbcTemplate, Mockito.times(1)).update(Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
    }

    /**
     * Prueba actualizar el usuario
     * Happy Path
     */
    @Test
    public void update() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setNombre("Test Name");
        usuario.setEmail("mail@test.com");

        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyString(),Mockito.anyString(), Mockito.anyInt())).thenReturn(1);

        usuarioDao.update(usuario);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyString(),Mockito.anyString(), Mockito.anyInt());

    }
    @Test(expected = GeneralException.class)
    public void updateException() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setNombre("Test Name");
        usuario.setEmail("mail@test.com");
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyString(),Mockito.anyString(), Mockito.anyInt())).thenReturn(0);
        usuarioDao.update(usuario);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyString(),Mockito.anyString(), Mockito.anyInt());
    }

    /**
     * Prueba el eliminar un usuario con el ID
     * Happy path
     */
    @Test
    public void delete() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);

        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt())).thenReturn(1);

        usuarioDao.delete(usuario.getIdUsuario());

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt());

    }
    @Test(expected = GeneralException.class)
    public void deleteException() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt())).thenReturn(0);
        usuarioDao.delete(usuario.getIdUsuario());
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt());
    }

    /**
     * Prueba el obtener un usuario por ID
     * Happpy path
     */
    @Test
    public void findByiD() {
        Usuario expected = new Usuario();

        Mockito.when(jdbcTemplate.queryForObject(Mockito.anyString(),Mockito.any(UsuarioRowMapper.class),Mockito.anyInt())).thenReturn(expected);

        Usuario result = usuarioDao.findByiD(1);

        Mockito.verify(jdbcTemplate, Mockito.times(1)).queryForObject(Mockito.anyString(),Mockito.any(UsuarioRowMapper.class),Mockito.anyInt());

        assertEquals(expected.getIdUsuario(),result.getIdUsuario());
    }

    /**
     * Prueba el obtener todos los usuarios
     * Happy path
     */
    @Test
    public void findAll() {
        List<Usuario> expected = new ArrayList<>();

        Mockito.when(jdbcTemplate.query(Mockito.anyString(),Mockito.any(UsuarioRowMapper.class))).thenReturn(expected);

        List<Usuario> result = usuarioDao.findAll();

        Mockito.verify(jdbcTemplate, Mockito.times(1)).query(Mockito.anyString(), Mockito.any(UsuarioRowMapper.class));

        assertEquals(expected, result);
    }

}