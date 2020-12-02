package com.tortu.api.daos.impl;

import com.tortu.api.daos.RecetaPeriodoDao;
import com.tortu.api.daos.mappers.RecetaPeriodoRowMapper;
import com.tortu.api.models.RecetaPeriodo;
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
public class RecetaPeriodoDaoImplTest {
    @InjectMocks
    private RecetaPeriodoDao dao = new RecetaPeriodoDaoImpl();
    @Mock
    JdbcTemplate jdbcTemplate;

//    @Test
//    public void save() {
//        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
//        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt())).thenReturn(1);
//        dao.save(recetaPeriodo);
//        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt());
//    }
//    @Test(expected = GeneralException.class)
//    public void saveException() {
//        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
//        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt())).thenReturn(0);
//        dao.save(recetaPeriodo);
//        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt());
//    }

    @Test
    public void update() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        recetaPeriodo.setIdPeriodo(2);
        recetaPeriodo.setIdReceta(24);
        recetaPeriodo.setIdRecetaPeriodo(2);
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(1);
        dao.update(recetaPeriodo);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void updateException() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
//        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(0);
        dao.update(recetaPeriodo);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt());
    }

    @Test
    public void delete() {
        Integer id=1;
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(1);
        dao.delete(id);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void deleteException() {
        Integer id=1;
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(0);
        dao.delete(id);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt());
    }

    @Test
    public void findByiD() {
        Integer id=1;
        RecetaPeriodo rp = new RecetaPeriodo();
        rp.setIdPeriodo(id);
        Mockito.when(jdbcTemplate.queryForObject(Mockito.anyString(), Mockito.any(RecetaPeriodoRowMapper.class), Mockito.anyInt())).thenReturn(rp);
        RecetaPeriodo recetaPeriodo = dao.findByiD(id);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).queryForObject(Mockito.anyString(), Mockito.any(RecetaPeriodoRowMapper.class), Mockito.anyInt());
        assertEquals(rp.getIdPeriodo(),recetaPeriodo.getIdPeriodo());
    }

    @Test
    public void findAll() {
        List<RecetaPeriodo> recetaPeriodoList = new ArrayList<>();
        recetaPeriodoList.add(new RecetaPeriodo());
        recetaPeriodoList.add(new RecetaPeriodo());
        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(RecetaPeriodoRowMapper.class))).thenReturn(recetaPeriodoList);
        List<RecetaPeriodo> resultList = dao.findAll();
        assertEquals(recetaPeriodoList.size(), resultList.size());
    }
    @Test
    public void findRecetaPeriodoIdListByPeriodoReceta(){
        //TODO: Test pending
    }
}