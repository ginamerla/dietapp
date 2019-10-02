package com.tortu.api.daos.impl;

import com.tortu.api.daos.LayoutPeriodoDao;
import com.tortu.api.daos.mappers.LayoutPeriodoRowMapper;
import com.tortu.api.models.Layout;
import com.tortu.api.models.LayoutPeriodo;
import com.tortu.api.rest.validators.GenericValidator;
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
public class LayoutPeriodoDaoImplTest {

    @InjectMocks
    LayoutPeriodoDao layoutPeriodoDao = new LayoutPeriodoDaoImpl();
    @Mock
    JdbcTemplate jdbcTemplate;

    @Test
    public void save() {
        LayoutPeriodo layoutPeriodo = new LayoutPeriodo();
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt(),Mockito.anyInt())).thenReturn(1);
        layoutPeriodoDao.save(layoutPeriodo);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyInt(),Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void saveException() {
        LayoutPeriodo layoutPeriodo = new LayoutPeriodo();
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt(),Mockito.anyInt())).thenReturn(0);
        layoutPeriodoDao.save(layoutPeriodo);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyInt(),Mockito.anyInt());
    }

    @Test
    public void update() {
        LayoutPeriodo layoutPeriodo = new LayoutPeriodo();
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(1);
        layoutPeriodoDao.update(layoutPeriodo);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void updateException() {
        LayoutPeriodo layoutPeriodo = new LayoutPeriodo();
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(0);
        layoutPeriodoDao.update(layoutPeriodo);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    public void delete() {
        Integer id=1;
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(1);
        layoutPeriodoDao.delete(id);
    }
    @Test(expected = GeneralException.class)
    public void deleteException() {
        Integer id=1;
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(0);
        layoutPeriodoDao.delete(id);
    }

    @Test
    public void findByiD() {
        Integer id=1;
        LayoutPeriodo expected = new LayoutPeriodo();
        expected.setIdLayoutPeriodo(1);
        Mockito.when(jdbcTemplate.queryForObject(Mockito.anyString(),Mockito.any(LayoutPeriodoRowMapper.class), Mockito.anyInt())).thenReturn(expected);
        LayoutPeriodo actual = layoutPeriodoDao.findByiD(id);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).queryForObject(Mockito.anyString(),Mockito.any(LayoutPeriodoRowMapper.class), Mockito.anyInt());
        assertEquals(expected.getIdLayoutPeriodo(),actual.getIdLayoutPeriodo());
    }

    @Test
    public void findAll() {
        List<LayoutPeriodo>expectedList = new ArrayList<>();
        expectedList.add(new LayoutPeriodo());
        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(LayoutPeriodoRowMapper.class))).thenReturn(expectedList);
        List<LayoutPeriodo> resultList = layoutPeriodoDao.findAll();
        Mockito.verify(jdbcTemplate,Mockito.times(1)).query(Mockito.anyString(), Mockito.any(LayoutPeriodoRowMapper.class));
        assertEquals(expectedList.get(0),resultList.get(0));
    }
}