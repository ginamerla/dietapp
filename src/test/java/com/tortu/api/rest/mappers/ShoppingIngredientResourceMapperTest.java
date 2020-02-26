package com.tortu.api.rest.mappers;

import com.tortu.api.dto.ShoppingIngredientDTO;
import com.tortu.api.rest.resources.ShoppingIngredientResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class ShoppingIngredientResourceMapperTest {

    private ShoppingIngredientResourceMapper resourceMapper;
    @Before
    public void init(){
        resourceMapper = new ShoppingIngredientResourceMapper();
    }
    @Test
    public void map(){
        ShoppingIngredientDTO expectedDTO = new ShoppingIngredientDTO();
        expectedDTO.setCategory("categoryTest");
        expectedDTO.setItem("itemTest");
        expectedDTO.setIdIngredient(1);
        expectedDTO.setUnit("unitTest");
        expectedDTO.setQuantity(0.0);

        ShoppingIngredientResource resourceDTO = resourceMapper.map(expectedDTO);

        assertNotNull(resourceDTO);
        assertEquals(expectedDTO.getCategory(), resourceDTO.getCategory());
        assertEquals(expectedDTO.getIdIngredient(),resourceDTO.getIdIngredient());
        assertEquals(expectedDTO.getItem(),resourceDTO.getItem());
        assertEquals(expectedDTO.getQuantity(), resourceDTO.getQuantity());
        assertEquals(expectedDTO.getUnit(),resourceDTO.getUnit());
    }

    @Test
    public void mapModelNull(){
        ShoppingIngredientDTO expected = null;
        ShoppingIngredientResource resource = resourceMapper.map(expected);
        assertNull(resource);
    }
}