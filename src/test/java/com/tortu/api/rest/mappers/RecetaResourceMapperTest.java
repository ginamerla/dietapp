package com.tortu.api.rest.mappers;

import com.tortu.api.models.Receta;
import com.tortu.api.rest.resources.RecetaResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class RecetaResourceMapperTest {

    private RecetaResourceMapper recetaResourceMapper;

    @Before
    public void init(){
        recetaResourceMapper = new RecetaResourceMapper();
    }

    @Test
    public void map() {
        Receta receta = new Receta();
        receta.setIdReceta(1);
        receta.setNombre("Receta de prueba");

        RecetaResource resource = recetaResourceMapper.map(receta);

        assertNotNull(resource);
        assertEquals(receta.getIdReceta(), resource.getIdReceta());
        assertEquals(receta.getNombre(), resource.getNombre());
    }

    public void mapModelNull(){
        RecetaResource actualResult = recetaResourceMapper.map(null);
        assertNull(actualResult);
    }
}