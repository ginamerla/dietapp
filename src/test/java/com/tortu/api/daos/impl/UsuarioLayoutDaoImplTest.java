package com.tortu.api.daos.impl;

import com.tortu.api.daos.mappers.UsuarioLayoutRowMapper;
import com.tortu.api.models.UsuarioLayout;
import com.tortu.api.utils.GeneralException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioLayoutDaoImplTest {
    @InjectMocks
    UsuarioLayoutDaoImpl usuarioLayoutDao = new UsuarioLayoutDaoImpl();
    @Mock
    JdbcTemplate jdbcTemplate;

    @Test
    public void save() {
        UsuarioLayout usuarioLayout = new UsuarioLayout();
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Date.class))).thenReturn(1);
        usuarioLayoutDao.save(usuarioLayout);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Date.class));
    }
    @Test(expected = GeneralException.class)
    public void saveException() {
        UsuarioLayout usuarioLayout = new UsuarioLayout();
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Date.class))).thenReturn(0);
        usuarioLayoutDao.save(usuarioLayout);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Date.class));
    }

    @Test
    public void update() {
        UsuarioLayout usuarioLayout = new UsuarioLayout();
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt(),Mockito.any(Date.class),Mockito.anyInt())).thenReturn(1);
        usuarioLayoutDao.update(usuarioLayout);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt(),Mockito.any(Date.class),Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void updateException() {
        UsuarioLayout usuarioLayout = new UsuarioLayout();
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt(),Mockito.any(Date.class),Mockito.anyInt())).thenReturn(0);
        usuarioLayoutDao.update(usuarioLayout);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt(),Mockito.anyInt(),Mockito.any(Date.class),Mockito.anyInt());
    }

    @Test
    public void delete() {
        Integer idUsuarioLayout=1;
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(1);
        usuarioLayoutDao.delete(idUsuarioLayout);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void deleteException() {
        Integer idUsuarioLayout=1;
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(0);
        usuarioLayoutDao.delete(idUsuarioLayout);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(), Mockito.anyInt());
    }

    @Test
    public void findByiD() {
        Integer idUsuarioLayout=1;
        UsuarioLayout expected = new UsuarioLayout();
        Mockito.when(jdbcTemplate.queryForObject(Mockito.anyString(), Mockito.any(UsuarioLayoutRowMapper.class), Mockito.anyInt())).thenReturn(expected);
        UsuarioLayout actual = usuarioLayoutDao.findByiD(idUsuarioLayout);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).queryForObject(Mockito.anyString(), Mockito.any(UsuarioLayoutRowMapper.class), Mockito.anyInt());
        assertEquals(expected,actual);
    }

    @Test
    public void findAll() {
        List<UsuarioLayout> expectedList = new ArrayList<>();
          Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(UsuarioLayoutRowMapper.class))).thenReturn(expectedList);
        List<UsuarioLayout> actualList = usuarioLayoutDao.findAll();
          Mockito.verify(jdbcTemplate,Mockito.times(1)).query(Mockito.anyString(), Mockito.any(UsuarioLayoutRowMapper.class));
          assertEquals(expectedList,actualList);
    }
}