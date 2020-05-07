package com.tortu.api.services.impl;

import com.tortu.api.daos.IngredienteDao;
import com.tortu.api.models.Ingrediente;
import com.tortu.api.models.Receta;
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
public class IngredienteServiceImplTest {

    @InjectMocks
    private IngredienteServiceImpl ingredienteService = new IngredienteServiceImpl();

    @Mock
    private IngredienteDao ingredienteDao;

//    @Test
//    public void saveIngrediente() {
//        Ingrediente ingrediente = new Ingrediente();
//        Mockito.doNothing().when(ingredienteDao).save(ingrediente);
//        ingredienteService.saveIngrediente(ingrediente);
//        Mockito.verify(ingredienteDao,Mockito.times(1)).save(ingrediente);
//    }
    @Test(expected = GeneralException.class)
    public void saveIngredienteException() {
        Ingrediente ingrediente = new Ingrediente();
        Mockito.doThrow(GeneralException.class).when(ingredienteDao).save(ingrediente);
        ingredienteService.saveIngrediente(ingrediente);
        Mockito.verify(ingredienteDao,Mockito.times(1)).save(ingrediente);
    }

    @Test
    public void updateIngrediente() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        Mockito.doNothing().when(ingredienteDao).update(ingrediente);
        ingredienteService.updateIngrediente(ingrediente);
        Mockito.verify(ingredienteDao,Mockito.times(1)).update(ingrediente);
    }
    @Test(expected = GeneralException.class)
    public void updateIngredienteExceptionIdNull() {
        Ingrediente ingrediente = new Ingrediente();
        ingredienteService.updateIngrediente(ingrediente);
    }
    @Test(expected = GeneralException.class)
    public void updateIngredienteException() {
        Ingrediente ingrediente = new Ingrediente();
        Mockito.doThrow(GeneralException.class).when(ingredienteDao).update(ingrediente);
        ingredienteService.updateIngrediente(ingrediente);
        Mockito.verify(ingredienteService,Mockito.times(1)).updateIngrediente(ingrediente);
    }

    @Test
    public void findIngrediente() {
        Integer idIngrediente = 1;
        Ingrediente ingredienteExpected = new Ingrediente();
        Mockito.when(ingredienteDao.findByiD(idIngrediente)).thenReturn(ingredienteExpected);
        Ingrediente ingredienteResult = ingredienteService.findIngrediente(idIngrediente);
        Mockito.verify(ingredienteDao,Mockito.times(1)).findByiD(idIngrediente);
        assertEquals(ingredienteExpected,ingredienteResult);
    }
    @Test(expected = GeneralException.class)
    public void findIngredienteExcptionIdNull() {
        Ingrediente ingredienteExpected = new Ingrediente();
        ingredienteService.findIngrediente(ingredienteExpected.getIdIngrediente());
    }

    @Test
    public void findAllIngredientes() {
        List<Ingrediente> ingredienteList = new ArrayList<>();
        Mockito.when(ingredienteDao.findAll()).thenReturn(ingredienteList);
        List<Ingrediente> actualList = ingredienteService.findAllIngredientes();
        Mockito.verify(ingredienteDao,Mockito.times(1)).findAll();
        assertEquals(ingredienteList,actualList);
    }
    @Test
    public void findAllIngredientesListBlank() {
        Mockito.when(ingredienteDao.findAll()).thenReturn(null);
        List<Ingrediente> actualList = ingredienteService.findAllIngredientes();
        Mockito.verify(ingredienteDao,Mockito.times(1)).findAll();
        assertNotNull(actualList);
    }

    @Test
    public void deleteIngrediente() {
        Integer idIngrediente=1;
        Mockito.doNothing().when(ingredienteDao).delete(idIngrediente);
        ingredienteService.deleteIngrediente(idIngrediente);
        Mockito.verify(ingredienteDao,Mockito.times(1)).delete(idIngrediente);
    }
    @Test(expected = GeneralException.class)
    public void deleteIngredienteExceptionIdNull() {
        Integer idIngrediente=null;
        ingredienteService.deleteIngrediente(idIngrediente);
    }
    @Test(expected = GeneralException.class)
    public void deleteIngredienteException() {
        Integer idIngrediente=null;
        Mockito.doThrow(GeneralException.class).when(ingredienteDao).delete(idIngrediente);
        ingredienteService.deleteIngrediente(idIngrediente);
        Mockito.verify(ingredienteService,Mockito.times(1)).deleteIngrediente(idIngrediente);
    }
}