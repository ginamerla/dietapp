package com.tortu.api.services.impl;

import com.tortu.api.daos.RecetaDao;
import com.tortu.api.models.Receta;
import com.tortu.api.utils.GeneralException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RecetaServiceImplTest {

    @InjectMocks
    RecetaServiceImpl recetaService = new RecetaServiceImpl();

    @Mock
    RecetaDao recetaDao;

//    @Test
//    public void saveReceta() {
//        Receta receta = new Receta();
//
//        Mockito.doNothing().when(recetaDao).save(receta);
//
//        recetaService.saveReceta(receta);
//
//        Mockito.verify(recetaDao,Mockito.times(1)).save(receta);
//
//    }
    @Test(expected = GeneralException.class)
    public void saveRecetaException() {
        Receta receta = new Receta();
        Mockito.doThrow(GeneralException.class).when(recetaDao).save(receta);
        recetaService.saveReceta(receta);
        Mockito.verify(recetaDao,Mockito.times(1)).save(receta);
    }

    @Test
    public void updateReceta() {
        Receta receta = new Receta();
        receta.setIdReceta(1);
        Mockito.doNothing().when(recetaDao).update(receta);
        recetaService.updateReceta(receta);
        Mockito.verify(recetaDao,Mockito.times(1)).update(receta);
    }

    @Test(expected = GeneralException.class)
    public void updateRecetaExceptionNull(){
        Receta receta = new Receta();
        recetaService.updateReceta(receta);
    }
    @Test(expected = GeneralException.class)
    public void updateRecetaException(){
        Receta receta = new Receta();
//        Mockito.doThrow(GeneralException.class).when(recetaDao).update(receta);
        recetaService.updateReceta(receta);
    }

    @Test
    public void findReceta() {
        Receta expected = new Receta();
        expected.setIdReceta(1);
        Mockito.when(recetaDao.findByiD(Mockito.anyInt())).thenReturn(expected);
        Receta result = recetaService.findReceta(expected.getIdReceta());
        Mockito.verify(recetaDao,Mockito.times(1)).findByiD(Mockito.anyInt());
        assertEquals(expected,result);
    }

    @Test(expected = GeneralException.class)
    public void findRecetaNullException() {
        Receta receta = new Receta();
        recetaService.findReceta(receta.getIdReceta());
    }

    @Test
    public void findAllRecetas() {
        List<Receta> expectedList = new ArrayList<>();

        Mockito.when(recetaDao.findAll()).thenReturn(expectedList);

        List<Receta> result = recetaService.findAllRecetas();

        Mockito.verify(recetaDao,Mockito.times(1)).findAll();

        assertEquals(expectedList,result);
    }

    @Test
    public void findAllRecetasResultNotNull(){
        List<Receta> expectedList = null;
        Mockito.when(recetaDao.findAll()).thenReturn(expectedList);

        List<Receta> result = recetaService.findAllRecetas();

        Mockito.verify(recetaDao,Mockito.times(1)).findAll();

        assertNotNull(result);
    }

    @Test
    public void deleteReceta() {
        Mockito.doNothing().when(recetaDao).delete(Mockito.anyInt());

        recetaService.deleteReceta(1);

        Mockito.verify(recetaDao,Mockito.times(1)).delete(Mockito.anyInt());
    }

    @Test(expected = GeneralException.class)
    public void deleteRecetaExceptionNull(){
        recetaService.deleteReceta(null);
    }
    @Test(expected = GeneralException.class)
    public void deleteRecetaException(){
//        Mockito.doThrow(GeneralException.class).when(recetaDao).delete(Mockito.anyInt());
        recetaService.deleteReceta(null);
    }
}