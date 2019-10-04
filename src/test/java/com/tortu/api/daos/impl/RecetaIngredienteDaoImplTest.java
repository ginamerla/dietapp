package com.tortu.api.daos.impl;

import com.tortu.api.daos.mappers.RecetaIngredienteRowMapper;
import com.tortu.api.models.RecetaIngrediente;
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
public class RecetaIngredienteDaoImplTest {

    @InjectMocks
    private RecetaIngredienteDaoImpl recetaIngredienteDao;
    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    public void save() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyDouble(),Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(1);
        recetaIngredienteDao.save(recetaIngrediente);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyDouble(),Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void saveException() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyDouble(),Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(0);
        recetaIngredienteDao.save(recetaIngrediente);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyDouble(),Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt());
    }

    @Test
    public void update() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyDouble(), Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(1);
        recetaIngredienteDao.update(recetaIngrediente);
        Mockito.verify(jdbcTemplate, Mockito.times(1)).update(Mockito.anyString(),Mockito.anyDouble(), Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void updateException() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyDouble(), Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(0);
        recetaIngredienteDao.update(recetaIngrediente);
        Mockito.verify(jdbcTemplate, Mockito.times(1)).update(Mockito.anyString(),Mockito.anyDouble(), Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt());
    }

    @Test
    public void delete() {
        Integer id=30;
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt())).thenReturn(1);
        recetaIngredienteDao.delete(id);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void deleteException() {
        Integer id=30;
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt())).thenReturn(0);
        recetaIngredienteDao.delete(id);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyInt());
    }

    @Test
    public void findByiD() {
        Integer id=34;
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setIdRecetaIngrediente(id);
        Mockito.when(jdbcTemplate.queryForObject(Mockito.anyString(), Mockito.any(RecetaIngredienteRowMapper.class), Mockito.anyInt())).thenReturn(recetaIngrediente);
        RecetaIngrediente result = recetaIngredienteDao.findByiD(id);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).queryForObject(Mockito.anyString(), Mockito.any(RecetaIngredienteRowMapper.class), Mockito.anyInt());
        assertEquals(recetaIngrediente.getIdRecetaIngrediente(), result.getIdRecetaIngrediente());
    }

    @Test
    public void findAll() {
        List<RecetaIngrediente> expectedList = new ArrayList<>();
        expectedList.add(new RecetaIngrediente());
        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(RecetaIngredienteRowMapper.class))).thenReturn(expectedList);
        List<RecetaIngrediente> actualList = recetaIngredienteDao.findAll();
        Mockito.verify(jdbcTemplate,Mockito.times(1)).query(Mockito.anyString(), Mockito.any(RecetaIngredienteRowMapper.class));
        assertEquals(expectedList.size(), actualList.size());

    }
}