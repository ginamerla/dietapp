package com.tortu.api.services.impl;

import com.tortu.api.daos.LayoutPeriodoDao;
import com.tortu.api.models.LayoutPeriodo;
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
public class LayoutPeriodoServiceImplTest {

    @InjectMocks
    private LayoutPeriodoServiceImpl service;
    @Mock
    private LayoutPeriodoDao dao;

//    @Test
//    public void saveLayoutPeriodo() {
//        LayoutPeriodo layoutPeriodo = new LayoutPeriodo();
//        Mockito.doNothing().when(dao).save(layoutPeriodo);
//        service.saveLayoutPeriodo(layoutPeriodo);
//        Mockito.verify(dao,Mockito.times(1)).save(layoutPeriodo);
//    }

    @Test
    public void updateLayoutPeriodo() {
        LayoutPeriodo layoutPeriodo = new LayoutPeriodo();
        layoutPeriodo.setIdLayoutPeriodo(1);
        Mockito.doNothing().when(dao).update(layoutPeriodo);
        service.updateLayoutPeriodo(layoutPeriodo);
        Mockito.verify(dao,Mockito.times(1)).update(layoutPeriodo);
    }

    @Test
    public void deleteLayoutPeriodo() {
        Integer id=1;
        Mockito.doNothing().when(dao).delete(id);
        service.deleteLayoutPeriodo(id);
        Mockito.verify(dao,Mockito.times(1)).delete(id);
    }
    @Test(expected = GeneralException.class)
    public void deleteLayoutPeriodoException() {
        Integer id=null;
//        Mockito.doNothing().when(dao).delete(id);
        service.deleteLayoutPeriodo(id);
        Mockito.verify(dao,Mockito.times(1)).delete(id);
    }

    @Test
    public void findLayoutPeriodo() {
        Integer id=1;
        LayoutPeriodo expected = new LayoutPeriodo();
        Mockito.when(dao.findByiD(id)).thenReturn(expected);
        LayoutPeriodo actual = service.findLayoutPeriodo(id);
        Mockito.verify(dao,Mockito.times(1)).findByiD(id);
        assertEquals(expected,actual);
    }
    @Test(expected = GeneralException.class)
    public void findLayoutPeriodoExceptionIdNull() {
        Integer id=null;
        LayoutPeriodo actual = service.findLayoutPeriodo(id);
    }
    @Test(expected = GeneralException.class)
    public void findLayoutPeriodoExceptionNotFound() {
        Integer id=1;
        LayoutPeriodo expected = null;
        Mockito.when(dao.findByiD(id)).thenReturn(expected);
        service.findLayoutPeriodo(id);
        Mockito.verify(dao,Mockito.times(1)).findByiD(id);
    }

    @Test
    public void findAllLayoutPeriodo() {
        List<LayoutPeriodo> expected = new ArrayList<>();
        expected.add(new LayoutPeriodo());
        Mockito.when(dao.findAll()).thenReturn(expected);
        List<LayoutPeriodo> actual = service.findAllLayoutPeriodo();
        Mockito.verify(dao,Mockito.times(1)).findAll();
        assertEquals(expected.size(),actual.size());
    }
    @Test
    public void findAllLayoutPeriodoListNull() {
        Mockito.when(dao.findAll()).thenReturn(null);
        List<LayoutPeriodo> actual = service.findAllLayoutPeriodo();
        Mockito.verify(dao,Mockito.times(1)).findAll();
        assertNotNull(actual);
    }
}