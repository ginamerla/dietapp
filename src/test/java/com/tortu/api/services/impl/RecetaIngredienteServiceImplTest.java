package com.tortu.api.services.impl;

import com.tortu.api.daos.RecetaIngredienteDao;
import com.tortu.api.models.RecetaIngrediente;
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
public class RecetaIngredienteServiceImplTest {

    @InjectMocks
    private RecetaIngredienteServiceImpl recetaIngredienteService;
    @Mock
    private RecetaIngredienteDao dao;

    @Test
    public void saveRecetaIngrediente() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        Mockito.doNothing().when(dao).save(recetaIngrediente);
        recetaIngredienteService.saveRecetaIngrediente(recetaIngrediente);
        Mockito.verify(dao,Mockito.times(1)).save(recetaIngrediente);
    }

    @Test
    public void updateRecetaIngrediente() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setIdRecetaIngrediente(23);
        Mockito.doNothing().when(dao).update(recetaIngrediente);
        recetaIngredienteService.updateRecetaIngrediente(recetaIngrediente);
        Mockito.verify(dao,Mockito.times(1)).update(recetaIngrediente);
    }
    @Test(expected = GeneralException.class)
    public void updateRecetaIngredienteException() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngredienteService.updateRecetaIngrediente(recetaIngrediente);
    }

    @Test
    public void deleteRecetaIngrediente() {
        Integer id=34;
        Mockito.doNothing().when(dao).delete(id);
        recetaIngredienteService.deleteRecetaIngrediente(id);
        Mockito.verify(dao,Mockito.times(1)).delete(id);
    }
    @Test(expected = GeneralException.class)
    public void deleteRecetaIngredienteException() {
        Integer id=null;
        Mockito.doNothing().when(dao).delete(id);
        recetaIngredienteService.deleteRecetaIngrediente(id);
        Mockito.verify(dao,Mockito.times(1)).delete(id);
    }

    @Test
    public void findRecetaIngrediente() {
        Integer id=43;
        RecetaIngrediente expected = new RecetaIngrediente();
        expected.setIdRecetaIngrediente(id);
        Mockito.when(dao.findByiD(id)).thenReturn(expected);
        RecetaIngrediente actual = recetaIngredienteService.findRecetaIngrediente(id);
        Mockito.verify(dao,Mockito.times(1)).findByiD(id);
        assertEquals(expected.getIdRecetaIngrediente(), actual.getIdRecetaIngrediente());
    }
    @Test(expected = GeneralException.class)
    public void findRecetaIngredienteException() {
        Integer id=43;
        Mockito.when(dao.findByiD(id)).thenReturn(null);
        RecetaIngrediente actual = recetaIngredienteService.findRecetaIngrediente(id);
        Mockito.verify(dao,Mockito.times(1)).findByiD(id);
    }

    @Test
    public void findAllRecetaIngrediente() {
        List<RecetaIngrediente> expectedList = new ArrayList<>();
        expectedList.add(new RecetaIngrediente());
        Mockito.when(dao.findAll()).thenReturn(expectedList);
        List<RecetaIngrediente> actual = recetaIngredienteService.findAllRecetaIngrediente();
        Mockito.verify(dao,Mockito.times(1)).findAll();
        assertEquals(1, actual.size());
    }
    @Test
    public void findAllRecetaIngredienteEmptyList() {
        List<RecetaIngrediente> expectedList = new ArrayList<>();
        Mockito.when(dao.findAll()).thenReturn(expectedList);
        List<RecetaIngrediente> actual = recetaIngredienteService.findAllRecetaIngrediente();
        Mockito.verify(dao,Mockito.times(1)).findAll();
        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }
}