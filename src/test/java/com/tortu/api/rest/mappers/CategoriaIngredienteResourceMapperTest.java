package com.tortu.api.rest.mappers;

import com.tortu.api.models.CategoriaIngrediente;
import com.tortu.api.rest.resources.CategoriaIngredienteResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.annotation.Bean;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class CategoriaIngredienteResourceMapperTest {

    private CategoriaIngredienteResourceMapper resourceMapper;

    @Before
    public void init(){
        resourceMapper = new CategoriaIngredienteResourceMapper();
    }

    @Test
    public void map() {
        CategoriaIngrediente categoria = new CategoriaIngrediente();
        categoria.setIdCategoriaIngrediente(1);
        categoria.setNombre("Nombre Categoria Prueba");

        CategoriaIngredienteResource resource = resourceMapper.map(categoria);

        assertNotNull(resource);
        assertEquals(1, resource.getIdCategoriaIngrediente().intValue());
        assertEquals("Nombre Categoria Prueba", resource.getNombre());
    }
    @Test
    public void mapExceptionModelNull(){
        CategoriaIngredienteResource actualResult = resourceMapper.map(null);
        assertNull(actualResult);
    }
}