package com.tortu.api.services.impl;

import com.tortu.api.daos.DietaUsuarioDao;
import com.tortu.api.models.DietaUsuario;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.DietaUsuarioService;
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
public class DietaUsuarioServiceImplTest {

    @InjectMocks
    DietaUsuarioService dietaUsuarioService = new DietaUsuarioServiceImpl();
    @Mock
    DietaUsuarioDao dietaUsuarioDao;

    @Test
    public void saveDietaUsuario() {
        DietaUsuario expectedDietaUsuario = new DietaUsuario();
        Mockito.doNothing().when(dietaUsuarioDao).save(expectedDietaUsuario);

        dietaUsuarioService.saveDietaUsuario(expectedDietaUsuario);

        Mockito.verify(dietaUsuarioDao, Mockito.times(1)).save(expectedDietaUsuario);
    }
    @Test(expected = GeneralException.class)
    public void saveDietaUsuarioException() {
        DietaUsuario expectedDietaUsuario = new DietaUsuario();
        Mockito.doThrow(GeneralException.class).when(dietaUsuarioDao).save(expectedDietaUsuario);
        dietaUsuarioService.saveDietaUsuario(expectedDietaUsuario);
        Mockito.verify(dietaUsuarioDao, Mockito.times(1)).save(expectedDietaUsuario);
    }

    @Test
    public void updateDietaUsuario() {
        DietaUsuario expectedDietaUsuario = new DietaUsuario();
        expectedDietaUsuario.setIdDietaUsuario(1);
        Mockito.doNothing().when(dietaUsuarioDao).update(expectedDietaUsuario);

        dietaUsuarioService.updateDietaUsuario(expectedDietaUsuario);

        Mockito.verify(dietaUsuarioDao,Mockito.times(1)).update(expectedDietaUsuario);
       // assertEquals(expectedDietaUsuario,actualDietaUsuario);
    }
    @Test(expected = GeneralException.class)
    public void updateDietaUsuarioExceptionIdNull() {
        DietaUsuario expectedDietaUsuario = new DietaUsuario();
        dietaUsuarioService.updateDietaUsuario(expectedDietaUsuario);

    }
    @Test(expected = GeneralException.class)
    public void updateDietaUsuarioException() {
        DietaUsuario expectedDietaUsuario = new DietaUsuario();
        Mockito.doThrow(GeneralException.class).when(dietaUsuarioDao).update(expectedDietaUsuario);
        dietaUsuarioService.updateDietaUsuario(expectedDietaUsuario);
    }

    @Test
    public void findDietaUsuario() {
        Integer idDietaUsuario = 1;
        DietaUsuario expectedDietaUsuario = new DietaUsuario();
        expectedDietaUsuario.setIdDietaUsuario(idDietaUsuario);
        Mockito.when(dietaUsuarioDao.findByiD(idDietaUsuario)).thenReturn(expectedDietaUsuario);

        DietaUsuario actualDietaUsuario = dietaUsuarioService.findDietaUsuario(idDietaUsuario);

        Mockito.verify(dietaUsuarioDao,Mockito.times(1)).findByiD(idDietaUsuario);
        assertEquals(expectedDietaUsuario,actualDietaUsuario);
    }
    @Test(expected = GeneralException.class)
    public void findDietaUsuarioExceptionIdNull() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuarioService.findDietaUsuario(dietaUsuario.getIdDietaUsuario());
    }

    @Test
    public void findAllDietaUsuario() {
        List<DietaUsuario> expectedList = new ArrayList<>();
        Mockito.when(dietaUsuarioDao.findAll()).thenReturn(expectedList);

        List<DietaUsuario> actualList = dietaUsuarioService.findAllDietaUsuario();

        Mockito.verify(dietaUsuarioDao,Mockito.times(1)).findAll();
        assertEquals(expectedList,actualList);
    }
    @Test
    public void findAllDietaUsuarioEmptyList() {
        Mockito.when(dietaUsuarioDao.findAll()).thenReturn(null);

        List<DietaUsuario> actualList = dietaUsuarioService.findAllDietaUsuario();

        Mockito.verify(dietaUsuarioDao,Mockito.times(1)).findAll();
        assertNotNull(actualList);
    }

    @Test
    public void deleteDietaUsuario() {
        Integer idDietaUsuario = 1;
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuario.setIdDietaUsuario(idDietaUsuario);
        Mockito.doNothing().when(dietaUsuarioDao).delete(dietaUsuario.getIdUsuario());

        dietaUsuarioService.deleteDietaUsuario(dietaUsuario.getIdDietaUsuario());
    }
    @Test(expected = GeneralException.class)
    public void deleteDietaUsuarioExceptionIdNull() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuarioService.deleteDietaUsuario(dietaUsuario.getIdDietaUsuario());
    }
    @Test(expected = GeneralException.class)
    public void deleteDietaUsuarioException() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        Mockito.doThrow(GeneralException.class).when(dietaUsuarioDao).delete(dietaUsuario.getIdUsuario());
        dietaUsuarioService.deleteDietaUsuario(dietaUsuario.getIdDietaUsuario());
    }
}