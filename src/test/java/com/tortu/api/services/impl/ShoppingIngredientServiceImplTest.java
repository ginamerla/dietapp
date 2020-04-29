package com.tortu.api.services.impl;

import com.tortu.api.daos.CommonDao;
import com.tortu.api.dto.ShoppingIngredientDTO;
import com.tortu.api.models.Usuario;
import com.tortu.api.utils.GeneralException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class ShoppingIngredientServiceImplTest {

    @InjectMocks
    private ShoppingIngredientServiceImpl shoppingIngredientService = new ShoppingIngredientServiceImpl();

    @Mock
    private CommonDao commonDao;

    @Test
    public void findUserShoppingList(){
        List<ShoppingIngredientDTO> expectedList = new ArrayList<>();
        expectedList.add(new ShoppingIngredientDTO());
        expectedList.add(new ShoppingIngredientDTO());
        Integer userId=1;
        Mockito.when(commonDao.getShoppingList(userId)).thenReturn(expectedList);
        List<ShoppingIngredientDTO> resultList = shoppingIngredientService.findUserShoppingList(userId);
        Mockito.verify(commonDao,Mockito.times(1)).getShoppingList(userId);
        assertEquals(expectedList,resultList);
        assertEquals(2, resultList.size());
    }

    @Test(expected = GeneralException.class)
    public void findUserShoppingListExceptionIdNull(){
        Usuario user = new Usuario();
        shoppingIngredientService.findUserShoppingList(user.getIdUsuario());
    }

}