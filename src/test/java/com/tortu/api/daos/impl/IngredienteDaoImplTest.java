package com.tortu.api.daos.impl;

import com.tortu.api.daos.IngredienteDao;
import com.tortu.api.daos.mappers.IngredienteRowMapper;
import com.tortu.api.models.Ingrediente;
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
public class IngredienteDaoImplTest {

    @InjectMocks
    private IngredienteDaoImpl ingredienteDao = new IngredienteDaoImpl();
    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    public void save() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdCategoriaIngrediente(23);
        ingrediente.setNombre("test");
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt())).thenReturn(1);

        ingredienteDao.save(ingrediente);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void saveException() {
        Ingrediente ingrediente = new Ingrediente();

//        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyString(), Mockito.anyInt())).thenReturn(0);

        ingredienteDao.save(ingrediente);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyString(), Mockito.anyInt());
    }

    @Test
    public void update() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre("x");
        ingrediente.setIdCategoriaIngrediente(2);
        ingrediente.setIdIngrediente(23);
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(1);

        ingredienteDao.update(ingrediente);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void updateException() {
        Ingrediente ingrediente = new Ingrediente();
//        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(0);

        ingredienteDao.update(ingrediente);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt());
    }

    @Test
    public void delete() {
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt())).thenReturn(1);

        ingredienteDao.delete(1);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void deleteException() {
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt())).thenReturn(0);

        ingredienteDao.delete(1);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyInt());
    }

    @Test
    public void findByiD() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);

        Mockito.when(jdbcTemplate.queryForObject(Mockito.anyString(),Mockito.any(IngredienteRowMapper.class),Mockito.anyInt())).thenReturn(ingrediente);

        Ingrediente result = ingredienteDao.findByiD(ingrediente.getIdIngrediente());

        Mockito.verify(jdbcTemplate,Mockito.times(1)).queryForObject(Mockito.anyString(),Mockito.any(IngredienteRowMapper.class),Mockito.anyInt());
        assertEquals(ingrediente.getIdIngrediente(), result.getIdIngrediente());

    }

    @Test
    public void findAll() {
        List<Ingrediente> expectedList = new ArrayList<>();

        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(IngredienteRowMapper.class))).thenReturn(expectedList);

        List<Ingrediente> resultList = ingredienteDao.findAll();

        Mockito.verify(jdbcTemplate,Mockito.times(1)).query(Mockito.anyString(), Mockito.any(IngredienteRowMapper.class));
        assertEquals(expectedList,resultList);
    }
}