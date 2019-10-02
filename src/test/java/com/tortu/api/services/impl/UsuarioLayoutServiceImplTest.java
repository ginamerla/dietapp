package com.tortu.api.services.impl;

import com.tortu.api.daos.UsuarioDao;
import com.tortu.api.daos.UsuarioLayoutDao;
import com.tortu.api.models.Usuario;
import com.tortu.api.models.UsuarioLayout;
import com.tortu.api.utils.GeneralException;
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
public class UsuarioLayoutServiceImplTest {
@InjectMocks
private UsuarioLayoutServiceImpl usuarioLayoutService = new UsuarioLayoutServiceImpl();
@Mock
private UsuarioLayoutDao dao;

    @Test
    public void saveUsuarioLayout() {
        UsuarioLayout usuarioLayout = new UsuarioLayout();
        Mockito.doNothing().when(dao).save(usuarioLayout);
        usuarioLayoutService.saveUsuarioLayout(usuarioLayout);
        Mockito.verify(dao,Mockito.times(1)).save(usuarioLayout);
    }

    @Test
    public void updateUsuarioLayout() {
        UsuarioLayout usuarioLayout = new UsuarioLayout();
        usuarioLayout.setIdUsuarioLayout(1);
        Mockito.doNothing().when(dao).update(usuarioLayout);
        usuarioLayoutService.updateUsuarioLayout(usuarioLayout);
        Mockito.verify(dao,Mockito.times(1)).update(usuarioLayout);
    }
    @Test(expected = GeneralException.class)
    public void updateUsuarioLayoutExceptionIdNull() {
        UsuarioLayout usuarioLayout = new UsuarioLayout();
        usuarioLayoutService.updateUsuarioLayout(usuarioLayout);
    }

    @Test
    public void findUsuarioLayout() {
        UsuarioLayout expected = new UsuarioLayout();
        expected.setIdUsuarioLayout(1);
        Mockito.when(dao.findByiD(Mockito.anyInt())).thenReturn(expected);
        UsuarioLayout result = usuarioLayoutService.findUsuarioLayout(expected.getIdUsuarioLayout());
        Mockito.verify(dao,Mockito.times(1)).findByiD(Mockito.anyInt());
        assertEquals(expected,result);
    }
    @Test(expected = GeneralException.class)
    public void findUsuarioLayoutExceptionIdNull() {
        UsuarioLayout usuarioLayout = new UsuarioLayout();
        usuarioLayoutService.findUsuarioLayout(usuarioLayout.getIdUsuarioLayout());
    }

    @Test
    public void findAllUsuarioLayout() {
        List<UsuarioLayout> expectedList = new ArrayList<>();
        Mockito.when(dao.findAll()).thenReturn(expectedList);
        List<UsuarioLayout> resultList = usuarioLayoutService.findAllUsuarioLayout();
        Mockito.verify(dao,Mockito.times(1)).findAll();
        assertEquals(expectedList,resultList);
    }
    @Test
    public void findAllUsuarioLayoutEmptyList() {
        Mockito.when(dao.findAll()).thenReturn(null);
        List<UsuarioLayout> resultList = usuarioLayoutService.findAllUsuarioLayout();
        Mockito.verify(dao,Mockito.times(1)).findAll();
        assertNotNull(resultList);
    }

    @Test
    public void deleteUsuarioLayout() {
        Integer id=1;
        Mockito.doNothing().when(dao).delete(id);
        usuarioLayoutService.deleteUsuarioLayout(id);
        Mockito.verify(dao,Mockito.times(1)).delete(id);
    }
    @Test(expected = GeneralException.class)
    public void deleteUsuarioLayoutExceptionIdNull() {
        Integer id=null;
        usuarioLayoutService.deleteUsuarioLayout(id);
    }
    @Test(expected = GeneralException.class)
    public void deleteUsuarioLayoutException() {
        Integer id=1;
        Mockito.doThrow(GeneralException.class).when(dao).delete(id);
        usuarioLayoutService.deleteUsuarioLayout(id);
        Mockito.verify(dao,Mockito.times(1)).delete(id);
    }
}