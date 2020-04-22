package com.tortu.api.daos.impl;

import com.tortu.api.daos.ComboDietaUsuarioDao;
import com.tortu.api.daos.mappers.ComboDietaUsuarioRowMapper;
import com.tortu.api.models.ComboDietaUsuario;
import com.tortu.api.utils.GeneralException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ComboDietaUsuarioDaoImplTest {
    @InjectMocks
    private ComboDietaUsuarioDao comboDietaUsuarioDao = new ComboDietaUsuarioDaoImpl();
    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    public void save(){
        ComboDietaUsuario comboDietaUsuario = new ComboDietaUsuario();

        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(1);

        comboDietaUsuarioDao.save(comboDietaUsuario);

        Mockito.verify(jdbcTemplate, Mockito.times(1)).update(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void saveException(){
        ComboDietaUsuario comboDietaUsuario = new ComboDietaUsuario();

        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(0);

        comboDietaUsuarioDao.save(comboDietaUsuario);

        Mockito.verify(jdbcTemplate, Mockito.times(1)).update(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt());
    }
    @Test
    public void update(){
        ComboDietaUsuario comboDietaUsuario = new ComboDietaUsuario();

        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(1);

        comboDietaUsuarioDao.update(comboDietaUsuario);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void updateException(){
        ComboDietaUsuario comboDietaUsuario = new ComboDietaUsuario();

        Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(0);

        comboDietaUsuarioDao.update(comboDietaUsuario);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());
    }
    @Test
    public void delete(){
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(1);
        comboDietaUsuarioDao.delete(1);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt());
    }
    @Test(expected = GeneralException.class)
    public void deleteException(){
        Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(0);
        comboDietaUsuarioDao.delete(1);
        Mockito.verify(jdbcTemplate,Mockito.times(1)).update(Mockito.anyString(),Mockito.anyInt());
    }
    @Test
    public void findById(){
        ComboDietaUsuario expected = new ComboDietaUsuario();

        Mockito.when(jdbcTemplate.queryForObject(Mockito.anyString(), Mockito.any(ComboDietaUsuarioRowMapper.class), Mockito.anyInt())).thenReturn(expected);

        ComboDietaUsuario actual = comboDietaUsuarioDao.findByiD(1);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).queryForObject(Mockito.anyString(), Mockito.any(ComboDietaUsuarioRowMapper.class), Mockito.anyInt());
        assertEquals(expected,actual);
    }
    @Test
    public void findAll(){
        List<ComboDietaUsuario> expectedList = new ArrayList<>();
        expectedList.add(new ComboDietaUsuario());
        expectedList.add(new ComboDietaUsuario());

        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(ComboDietaUsuarioRowMapper.class))).thenReturn(expectedList);

        List<ComboDietaUsuario> actualList = comboDietaUsuarioDao.findAll();

        Mockito.verify(jdbcTemplate,Mockito.times(1)).query(Mockito.anyString(), Mockito.any(ComboDietaUsuarioRowMapper.class));
        assertEquals(expectedList.size(), actualList.size());
    }
    @Test
    public void findComboDietaUsuarioIdListByDietaUsuario(){
        //TODO: Test pending
    }
}