package com.tortu.api.rest.mappers;

import com.tortu.api.daos.mappers.DietaUsuarioRowMapper;
import com.tortu.api.models.DietaUsuario;
import com.tortu.api.rest.resources.DietaUsuarioResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class DietaUsuarioResourceMapperTest {

    private DietaUsuarioResourceMapper dietaUsuarioResourceMapper;
    @Before
    public void init(){
        dietaUsuarioResourceMapper = new DietaUsuarioResourceMapper();
    }

    @Test
    public void map() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuario.setIdDietaUsuario(1);
        dietaUsuario.setIdUsuario(1);
        dietaUsuario.setDiaSemana("Lunes");

        DietaUsuarioResource dietaUsuarioResource = dietaUsuarioResourceMapper.map(dietaUsuario);

        assertNotNull(dietaUsuarioResource);
        assertEquals(dietaUsuario.getIdDietaUsuario(), dietaUsuarioResource.getIdDietaUsuario());
        assertEquals(dietaUsuario.getIdUsuario(), dietaUsuarioResource.getIdUsuario());
        assertEquals(dietaUsuario.getDiaSemana(), dietaUsuarioResource.getDiaSemana());
    }
    @Test
    public void mapModelNull(){
        DietaUsuarioResource dietaUsuarioResource = dietaUsuarioResourceMapper.map(null);
        assertNull(dietaUsuarioResource);
    }
}