package com.tortu.api.rest.restservices;

import com.tortu.api.dto.ShoppingIngredientDTO;
import com.tortu.api.rest.mappers.ShoppingIngredientResourceMapper;
import com.tortu.api.rest.resources.ShoppingIngredientResource;
import com.tortu.api.services.ShoppingIngredientService;
import com.tortu.api.utils.GeneralException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class ShoppingIngredientRestServiceTest {

    @InjectMocks
    private ShoppingIngredientRestService restService = new ShoppingIngredientRestService();
    @Mock
    private ShoppingIngredientService service;
    @Mock
    private ShoppingIngredientResourceMapper resourceMapper;

    @Test
    public void getShoppingList(){
        Integer userId=1;
        List<ShoppingIngredientDTO> expectedDTOList = new ArrayList<>();
        expectedDTOList.add(new ShoppingIngredientDTO());
        Mockito.when(service.findUserShoppingList(userId)).thenReturn(expectedDTOList);
        ShoppingIngredientResource resource = Mockito.mock(ShoppingIngredientResource.class);
        Mockito.when(resourceMapper.map(Mockito.any(ShoppingIngredientDTO.class))).thenReturn(resource);

        Response response = restService.getShoppingList(userId);

        Mockito.verify(service,Mockito.times(1)).findUserShoppingList(userId);
        Mockito.verify(resourceMapper,Mockito.times(1)).map(Mockito.any(ShoppingIngredientDTO.class));

        assertEquals(200, response.getStatus());
        assertTrue(response.getEntity() instanceof List);
        List<ShoppingIngredientResource> actualResourceList = (List<ShoppingIngredientResource>) response.getEntity();
        assertEquals(expectedDTOList.size(), actualResourceList.size());
    }

    @Test(expected = GeneralException.class)
    public void getShoppingListUserIdNull(){
        restService.getShoppingList(null);
    }

    @Test
    public void getShoppingListNotFound(){
        Integer userId=1;
        List<ShoppingIngredientDTO> DTOList = new ArrayList<>();
        Mockito.when(service.findUserShoppingList(userId)).thenReturn(DTOList);

        Response response = restService.getShoppingList(userId);

        Mockito.verify(service,Mockito.times(1)).findUserShoppingList(userId);
        assertEquals(404, response.getStatus());
    }
}