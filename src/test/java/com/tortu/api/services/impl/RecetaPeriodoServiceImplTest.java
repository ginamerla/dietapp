package com.tortu.api.services.impl;

import com.tortu.api.daos.RecetaPeriodoDao;
import com.tortu.api.models.RecetaPeriodo;
import com.tortu.api.services.RecetaPeriodoService;
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
public class RecetaPeriodoServiceImplTest {

    @InjectMocks
    private RecetaPeriodoService service = new RecetaPeriodoServiceImpl();
    @Mock
    private RecetaPeriodoDao dao;

    @Test
    public void saveRecetaPeriodo() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        Mockito.doNothing().when(dao).save(recetaPeriodo);
        service.saveRecetaPeriodo(recetaPeriodo);
        Mockito.verify(dao,Mockito.times(1)).save(recetaPeriodo);
    }

    @Test
    public void updateRecetaPeriodo() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        recetaPeriodo.setIdRecetaPeriodo(1);
        Mockito.doNothing().when(dao).update(recetaPeriodo);
        service.updateRecetaPeriodo(recetaPeriodo);
        Mockito.verify(dao,Mockito.times(1)).update(recetaPeriodo);
    }
    @Test(expected = GeneralException.class)
    public void updateRecetaPeriodoException() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        service.updateRecetaPeriodo(recetaPeriodo);
    }

    @Test
    public void deleteRecetaPeriodo() {
        Integer idRecetaPeriodo=1;
        Mockito.doNothing().when(dao).delete(idRecetaPeriodo);
        service.deleteRecetaPeriodo(idRecetaPeriodo);
        Mockito.verify(dao,Mockito.times(1)).delete(idRecetaPeriodo);
    }
    @Test(expected = GeneralException.class)
    public void deleteRecetaPeriodoException() {
        Integer idRecetaPeriodo=null;
        service.deleteRecetaPeriodo(idRecetaPeriodo);
    }

    @Test
    public void findRecetaPeriodo() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        recetaPeriodo.setIdRecetaPeriodo(2);
        Mockito.when(dao.findByiD(recetaPeriodo.getIdRecetaPeriodo())).thenReturn(recetaPeriodo);
        RecetaPeriodo result = service.findRecetaPeriodo(recetaPeriodo.getIdRecetaPeriodo());
        Mockito.verify(dao,Mockito.times(1)).findByiD(recetaPeriodo.getIdRecetaPeriodo());
        assertEquals(recetaPeriodo.getIdRecetaPeriodo(), result.getIdRecetaPeriodo());
    }
    @Test(expected = GeneralException.class)
    public void findRecetaPeriodoException() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        service.findRecetaPeriodo(recetaPeriodo.getIdRecetaPeriodo());
    }
    @Test(expected = GeneralException.class)
    public void findRecetaPeriodoExceptionNotFound() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        recetaPeriodo.setIdRecetaPeriodo(2);
        Mockito.when(dao.findByiD(recetaPeriodo.getIdRecetaPeriodo())).thenReturn(null);
        service.findRecetaPeriodo(recetaPeriodo.getIdRecetaPeriodo());
        Mockito.verify(dao,Mockito.times(1)).findByiD(recetaPeriodo.getIdRecetaPeriodo());
    }

    @Test
    public void findAllRecetaPeriodo() {
        List<RecetaPeriodo> recetaPeriodoList = new ArrayList<>();
        recetaPeriodoList.add(new RecetaPeriodo());
        recetaPeriodoList.add(new RecetaPeriodo());
        Mockito.when(dao.findAll()).thenReturn(recetaPeriodoList);
        List<RecetaPeriodo> resultList = service.findAllRecetaPeriodo();
        Mockito.verify(dao,Mockito.times(1)).findAll();
        assertEquals(2,resultList.size());
    }
    @Test
    public void findAllRecetaPeriodoNullList() {
        Mockito.when(dao.findAll()).thenReturn(null);
        List<RecetaPeriodo> resultList = service.findAllRecetaPeriodo();
        Mockito.verify(dao,Mockito.times(1)).findAll();
        assertNotNull(resultList);
    }
}