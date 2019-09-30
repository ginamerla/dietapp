package com.tortu.api.rest.mappers;

import com.tortu.api.models.Ingrediente;
import com.tortu.api.rest.resources.IngredienteResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class IngredienteResourceMapperTest {
    private IngredienteResourceMapper ingredienteResourceMapper;
    @Before
    public void init(){
        ingredienteResourceMapper = new IngredienteResourceMapper();
    }

    @Test
    public void map() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        ingrediente.setNombre("Tomate");
        ingrediente.setIdCategoriaIngrediente(1);

        IngredienteResource result = ingredienteResourceMapper.map(ingrediente);

        assertNotNull(result);
        assertEquals(ingrediente.getIdIngrediente(),result.getIdIngrediente());
        assertEquals(ingrediente.getNombre(), result.getNombre());
        assertEquals(ingrediente.getIdCategoriaIngrediente(),result.getIdCategoriaIngrediente());
    }
    @Test
    public void mapModelNull() {
        Ingrediente ingrediente = null;
        IngredienteResource result = ingredienteResourceMapper.map(ingrediente);

        assertNull(result);
    }
}