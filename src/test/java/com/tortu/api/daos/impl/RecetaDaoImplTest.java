package com.tortu.api.daos.impl;

import com.tortu.api.daos.RecetaDao;
import com.tortu.api.daos.mappers.RecetaRowMapper;
import com.tortu.api.models.Receta;
import com.tortu.api.models.Usuario;
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

/**
 * Pruebas del DAO
 * Solo Happy Path por que se esta suponiendo que las validaciones estan en todas las capas superiores
 */
@RunWith(MockitoJUnitRunner.class)
public class RecetaDaoImplTest {


    @InjectMocks
    private RecetaDaoImpl recetaDao = new RecetaDaoImpl();

    @Mock
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    /**
     * Prueba Happy Path
     */
    @Test
    public void save() {
        Receta receta = new Receta();
        receta.setNombre("Banana bowl");
        receta.setIdReceta(1);

        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyString())).thenReturn(1);

        recetaDao.save(receta);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyString());
    }
    @Test(expected = GeneralException.class)
    public void saveException() {
        Receta receta = new Receta();
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyString())).thenReturn(0);
        recetaDao.save(receta);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyString());
    }

    @Test
    public void update() {
        Receta receta = new Receta();
        receta.setNombre("Bowl de Platano");
        receta.setIdReceta(1);

        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt())).thenReturn(1);

        recetaDao.update(receta);

        Mockito.verify(jdbcTemplate, Mockito.times(1))
                .update(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt());

    }
    @Test(expected = GeneralException.class)
    public void updateException() {
        Receta receta = new Receta();
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt())).thenReturn(0);
        recetaDao.update(receta);
        Mockito.verify(jdbcTemplate, Mockito.times(1))
                .update(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt());

    }

    @Test
    public void delete() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);

        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt())).thenReturn(1);

        recetaDao.delete(usuario.getIdUsuario());

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void deleteException() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt())).thenReturn(0);
        recetaDao.delete(usuario.getIdUsuario());
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt());
    }

    @Test
    public void findByiD() {
        Receta recetaResult = new Receta();
        Mockito.when(jdbcTemplate.queryForObject(Mockito.anyString(), Mockito.any(RecetaRowMapper.class),Mockito.anyInt())).thenReturn(recetaResult);

        Receta receta = recetaDao.findByiD(1);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).queryForObject(Mockito.anyString(), Mockito.any(RecetaRowMapper.class),Mockito.anyInt());

        assertEquals(recetaResult.getIdReceta(),receta.getIdReceta());
    }

    @Test
    public void findAll() {
        List<Receta> expected = new ArrayList<>();

        Mockito.when(jdbcTemplate.query(Mockito.anyString(),Mockito.any(RecetaRowMapper.class))).thenReturn(expected);

        List<Receta> resultList = recetaDao.findAll();

        Mockito.verify(jdbcTemplate,Mockito.times(1)).query(Mockito.anyString(),Mockito.any(RecetaRowMapper.class));

        assertEquals(expected,resultList);
    }
}