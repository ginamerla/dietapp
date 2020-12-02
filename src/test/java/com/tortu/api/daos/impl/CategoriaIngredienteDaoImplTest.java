package com.tortu.api.daos.impl;

import com.tortu.api.daos.mappers.CategoriaIngredienteRowMapper;
import com.tortu.api.models.CategoriaIngrediente;
import com.tortu.api.utils.GeneralException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class CategoriaIngredienteDaoImplTest {

    @InjectMocks
    private CategoriaIngredienteDaoImpl categoriaIngredienteDaoImpl;
    @Mock
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Test
    public void save() {
        CategoriaIngrediente categoria = new CategoriaIngrediente();
        categoria.setNombre("x");
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyString())).thenReturn(1);

        categoriaIngredienteDaoImpl.save(categoria);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyString());
    }
    @Test(expected = GeneralException.class)
    public void saveException() {
        CategoriaIngrediente categoria = new CategoriaIngrediente();
//        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyString())).thenReturn(0);

        categoriaIngredienteDaoImpl.save(categoria);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyString());
    }

    @Test
    public void update() {
        CategoriaIngrediente categoria = new CategoriaIngrediente();
        categoria.setNombre("test");
        categoria.setIdCategoriaIngrediente(1);
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt())).thenReturn(1);

        categoriaIngredienteDaoImpl.update(categoria);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt());

    }
    @Test(expected = GeneralException.class)
    public void updateException() {
        CategoriaIngrediente categoria = new CategoriaIngrediente();
//        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt())).thenReturn(22);

        categoriaIngredienteDaoImpl.update(categoria);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt());

    }

    @Test
    public void delete() {
        Integer categoryID = 1;
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(1);

        categoriaIngredienteDaoImpl.delete(categoryID);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt());

    }
    @Test(expected = GeneralException.class)
    public void deleteException() {
        Integer categoryID = 1;
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(0);

        categoriaIngredienteDaoImpl.delete(categoryID);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt());

    }

    @Test
    public void findByiD() {
        CategoriaIngrediente expectedCategoria = new CategoriaIngrediente();

        Mockito.when(jdbcTemplate.queryForObject(Mockito.anyString(),Mockito.any(CategoriaIngredienteRowMapper.class), Mockito.anyInt())).thenReturn(expectedCategoria);

        CategoriaIngrediente categoriaResult = categoriaIngredienteDaoImpl.findByiD(1);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).queryForObject(Mockito.anyString(),Mockito.any(CategoriaIngredienteRowMapper.class), Mockito.anyInt());

        assertEquals(expectedCategoria.getIdCategoriaIngrediente(),categoriaResult.getIdCategoriaIngrediente());
    }

    @Test
    public void findAll() {
        List<CategoriaIngrediente> categoriaList = new ArrayList<>();
        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(CategoriaIngredienteRowMapper.class))).thenReturn(categoriaList);

        List<CategoriaIngrediente> result = categoriaIngredienteDaoImpl.findAll();

        Mockito.verify(jdbcTemplate,Mockito.times(1)).query(Mockito.anyString(), Mockito.any(CategoriaIngredienteRowMapper.class));

        assertEquals(categoriaList,result);
    }
}