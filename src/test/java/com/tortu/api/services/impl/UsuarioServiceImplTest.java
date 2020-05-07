package com.tortu.api.services.impl;

import com.tortu.api.daos.UsuarioDao;
import com.tortu.api.models.Usuario;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceImplTest {

    @InjectMocks
    private UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();

    @Mock
    private UsuarioDao usuarioDao;

    /**
     * Prueba que guarda un usuario
     * Happy path
     */
//    @Test
//    public void saveUsuario() {
//        Usuario usuarioTest = new Usuario();
//
//        Mockito.doNothing().when(usuarioDao).save(usuarioTest);
//        usuarioService.saveUsuario(usuarioTest);
//        Mockito.verify(usuarioDao,Mockito.times(1)).save(usuarioTest);
//    }
    @Test(expected = GeneralException.class)
    public void saveUsuarioException() {
        Usuario usuarioTest = new Usuario();
        Mockito.doThrow(GeneralException.class).when(usuarioDao).save(usuarioTest);
        usuarioService.saveUsuario(usuarioTest);
        Mockito.verify(usuarioDao,Mockito.times(1)).save(usuarioTest);
    }

    /**
     * Prueba actualizar un usuario en base a su id
     * Happy path
     */
    @Test
    public void updateUsuario() {
        Usuario usuarioTest = new Usuario();
        usuarioTest.setIdUsuario(1);

        Mockito.doNothing().when(usuarioDao).update(usuarioTest);
        usuarioService.updateUsuario(usuarioTest);
        Mockito.verify(usuarioDao, Mockito.times(1)).update(usuarioTest);
    }

    /**
     * Prueba que valida la excepcion al actualizar cuando el id es nulo
     */
    @Test(expected = GeneralException.class)
    public void updateUsuarioIdNull(){
        Usuario userTest = new Usuario();
        usuarioService.updateUsuario(userTest);
    }

    /**
     * Prueba para obtener un usuario con el id
     * Happy Path
     */
    @Test
    public void findUsuario() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);

        Usuario expected = new Usuario();
        expected.setNombre("Nombre Esperado");

        Mockito.when(usuarioDao.findByiD(usuario.getIdUsuario())).thenReturn(expected);
        Usuario result = usuarioService.findUsuario(usuario.getIdUsuario());

        // revisa la llamada del mock (DAO) se hace por cada mock
        Mockito.verify(usuarioDao,Mockito.times(1)).findByiD(usuario.getIdUsuario());

        assertEquals(expected.getNombre(), result.getNombre());
    }

    /**
     * Prueba que valida la excepcion cuando el id del usuario es nulo
     */
    @Test(expected = GeneralException.class)
    public void findUsuarioIdNull(){
        Usuario usuarioPrueba = new Usuario();
        usuarioService.findUsuario(usuarioPrueba.getIdUsuario());
    }

    /**
     * Prueba el obtener la lista de usuarios
     * Happy path
     */
    @Test
    public void findAllUsuarios() {
        List<Usuario> expectedList = new ArrayList<>();
        expectedList.add(new Usuario());
        expectedList.add(new Usuario());

        Mockito.when(usuarioDao.findAll()).thenReturn(expectedList);
        List<Usuario> resultList = usuarioService.findAllUsuarios();
        Mockito.verify(usuarioDao, Mockito.times(1)).findAll();

        assertEquals(expectedList.get(1),resultList.get(1));
    }

    /**
     * Prueba el obtener una lista de usuarios cuando la lista regresa en blanco o nula
     */
    @Test
    public void findAllUsuariosBlankList() {
        Mockito.when(usuarioDao.findAll()).thenReturn(null);
        List<Usuario> resultList = usuarioService.findAllUsuarios();
        Mockito.verify(usuarioDao, Mockito.times(1)).findAll();

        assertNotNull(resultList);
    }

    /**
     * Prueba eliminar un usuario con el id enviado
     * Happy Path
     */
    @Test
    public void deleteUsuario() {
        Usuario usuarioTest = new Usuario();
        usuarioTest.setIdUsuario(1);

        Mockito.doNothing().when(usuarioDao).delete(usuarioTest.getIdUsuario());
        usuarioService.deleteUsuario(usuarioTest.getIdUsuario());
        Mockito.verify(usuarioDao,Mockito.times(1)).delete(usuarioTest.getIdUsuario());
    }

    /**
     * Prueba que valida la excepcion al eliminar un usuario cuando el id es nulo
     */
    @Test(expected = GeneralException.class)
    public void deleteUsuarioIdNull() {
        Usuario usuarioTest = new Usuario();
        usuarioService.deleteUsuario(usuarioTest.getIdUsuario());
    }
}