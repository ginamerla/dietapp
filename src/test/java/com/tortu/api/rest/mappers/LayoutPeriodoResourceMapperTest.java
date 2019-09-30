package com.tortu.api.rest.mappers;

import com.tortu.api.models.LayoutPeriodo;
import com.tortu.api.rest.resources.LayoutPeriodoResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class LayoutPeriodoResourceMapperTest {

    private LayoutPeriodoResourceMapper resourceMapper;

    @Before
    public void init(){
            resourceMapper=new LayoutPeriodoResourceMapper();
    }
    @Test
    public void map() {
        LayoutPeriodo layoutPeriodo = new LayoutPeriodo();
        layoutPeriodo.setIdLayoutPeriodo(1);
        layoutPeriodo.setIdLayout(1);
        layoutPeriodo.setIdPeriodo(1);

        LayoutPeriodoResource actual = resourceMapper.map(layoutPeriodo);
        assertEquals(layoutPeriodo.getIdLayoutPeriodo(), actual.getIdLayoutPeriodo());
        assertEquals(layoutPeriodo.getIdLayout(), actual.getIdLayout());
        assertEquals(layoutPeriodo.getIdPeriodo(),actual.getIdPeriodo());
    }

    @Test
    public void mapModelNull() {
        LayoutPeriodo layoutPeriodo = null;

        LayoutPeriodoResource actual = resourceMapper.map(layoutPeriodo);
        assertNull(actual);
    }
}