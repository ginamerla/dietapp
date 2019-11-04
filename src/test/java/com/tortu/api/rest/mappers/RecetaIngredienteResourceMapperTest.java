package com.tortu.api.rest.mappers;

import com.tortu.api.models.RecetaIngrediente;
import com.tortu.api.rest.resources.RecetaIngredienteResource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecetaIngredienteResourceMapperTest {

    private RecetaIngredienteResourceMapper resourceMapper;
    @Before
    public void init(){
        resourceMapper = new RecetaIngredienteResourceMapper();
    }
    @Test
    public void map() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setIdRecetaIngrediente(23);
        recetaIngrediente.setIdReceta(656);
        recetaIngrediente.setIdIngrediente(54);
        recetaIngrediente.setIdMedida(64);
        recetaIngrediente.setCantidad(200d);

        RecetaIngredienteResource resource = resourceMapper.map(recetaIngrediente);

        assertEquals(recetaIngrediente.getIdRecetaIngrediente(), resource.getIdRecetaIngrediente());
        assertEquals(recetaIngrediente.getIdReceta(), resource.getIdReceta());
        assertEquals(recetaIngrediente.getIdIngrediente(), resource.getIdIngrediente());
        assertEquals(recetaIngrediente.getIdMedida(), resource.getIdMedida());
        assertEquals(recetaIngrediente.getCantidad(),resource.getCantidad());
    }
    @Test
    public void mapNull() {
        RecetaIngrediente recetaIngrediente = null;
        RecetaIngredienteResource resource = resourceMapper.map(recetaIngrediente);
        assertNull(resource);
    }
}