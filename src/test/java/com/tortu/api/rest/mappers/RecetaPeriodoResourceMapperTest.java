package com.tortu.api.rest.mappers;

import com.tortu.api.models.RecetaPeriodo;
import com.tortu.api.rest.resources.RecetaPeriodoResource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecetaPeriodoResourceMapperTest {

    private RecetaPeriodoResourceMapper resourceMapper;
    @Before
    public void init(){
        resourceMapper = new RecetaPeriodoResourceMapper();
    }
    @Test
    public void map() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        recetaPeriodo.setIdRecetaPeriodo(1);
        recetaPeriodo.setIdReceta(2);
        recetaPeriodo.setIdPeriodo(3);

        RecetaPeriodoResource resource = resourceMapper.map(recetaPeriodo);
        assertEquals(recetaPeriodo.getIdRecetaPeriodo(), resource.getIdRecetaPeriodo());
        assertEquals(recetaPeriodo.getIdReceta(), resource.getIdReceta());
        assertEquals(recetaPeriodo.getIdPeriodo(),resource.getIdPeriodo());
    }
    @Test
    public void mapModelNull() {
        RecetaPeriodo recetaPeriodo = null;
        RecetaPeriodoResource resource = resourceMapper.map(recetaPeriodo);
        assertNull(resource);
    }
}