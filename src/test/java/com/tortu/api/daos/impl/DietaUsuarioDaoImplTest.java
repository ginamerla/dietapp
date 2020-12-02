package com.tortu.api.daos.impl;

import com.tortu.api.daos.DietaUsuarioDao;
import com.tortu.api.daos.mappers.DietaUsuarioRowMapper;
import com.tortu.api.models.DietaUsuario;
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

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class DietaUsuarioDaoImplTest {
    @InjectMocks
    DietaUsuarioDao dietaUsuarioDao = new DietaUsuarioDaoImpl();
    @Mock
    JdbcTemplate jdbcTemplate;

    @Test
    public void save() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuario.setIdUsuario(1);
        dietaUsuario.setDiaSemana("test");
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString())).thenReturn(1);

        dietaUsuarioDao.save(dietaUsuario);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }
    @Test(expected = GeneralException.class)
    public void saveException() {
        DietaUsuario dietaUsuario = new DietaUsuario();
//        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString())).thenReturn(0);

        dietaUsuarioDao.save(dietaUsuario);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    public void update() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuario.setDiaSemana("x");
        dietaUsuario.setIdDietaUsuario(2);
        dietaUsuario.setIdUsuario(22);
        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString(), Mockito.anyInt())).thenReturn(1);

        dietaUsuarioDao.update(dietaUsuario);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString(), Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void updateException() {
        DietaUsuario dietaUsuario = new DietaUsuario();
//        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString(), Mockito.anyInt())).thenReturn(0);

        dietaUsuarioDao.update(dietaUsuario);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString(), Mockito.anyInt());
    }

    @Test
    public void delete() {
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(1);

        dietaUsuarioDao.delete(1);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void deleteException() {
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(0);

        dietaUsuarioDao.delete(1);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt());
    }

    @Test
    public void findByiD() {
        DietaUsuario expected = new DietaUsuario();
        Mockito.when(jdbcTemplate.queryForObject(Mockito.anyString(), Mockito.any(DietaUsuarioRowMapper.class), Mockito.anyInt())).thenReturn(expected);

        DietaUsuario actual = dietaUsuarioDao.findByiD(1);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).queryForObject(Mockito.anyString(), Mockito.any(DietaUsuarioRowMapper.class), Mockito.anyInt());
        assertEquals(expected,actual);
    }

    @Test
    public void findAll() {
        List<DietaUsuario> expectedList = new ArrayList<>();
        Mockito.when(jdbcTemplate.query(Mockito.anyString(),Mockito.any(DietaUsuarioRowMapper.class))).thenReturn(expectedList);

        List<DietaUsuario> actualList = dietaUsuarioDao.findAll();

        Mockito.verify(jdbcTemplate,Mockito.times(1)).query(Mockito.anyString(),Mockito.any(DietaUsuarioRowMapper.class));
        assertEquals(expectedList,actualList);
    }
    @Test
    public void findIdDietaUsuarioListByUser(){
        //TODO: Test pending
//        List<Integer> expectedList = new ArrayList<>();
//        Mockito.when(jdbcTemplate.queryForList(Mockito.anyString(), Mockito.any(Integer.class), Mockito.anyInt())).thenReturn(expectedList);
//
//        List<Integer> actualList = dietaUsuarioDao.findIdDietaUsuarioListByUser(1);
//
//        Mockito.verify(jdbcTemplate,Mockito.times(1)).queryForList(Mockito.anyString(), Mockito.any(Integer.class), Mockito.anyInt());
//        assertEquals(expectedList,actualList);
    }
}