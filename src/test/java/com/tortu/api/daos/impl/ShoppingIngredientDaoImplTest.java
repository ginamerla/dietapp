package com.tortu.api.daos.impl;

import com.tortu.api.daos.mappers.ShoppingIngredientDTORowMapper;
import com.tortu.api.dto.ShoppingIngredientDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingIngredientDaoImplTest {
    @InjectMocks
    private ShoppingIngredientDaoImpl dao = new ShoppingIngredientDaoImpl();
    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    public void getShppingList(){
        Integer userId=1;
        List<ShoppingIngredientDTO> expectedList = new ArrayList<>();

        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(ShoppingIngredientDTORowMapper.class), Mockito.anyInt())).thenReturn(expectedList);

        List<ShoppingIngredientDTO> resultList =dao.getShoppingList(userId);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).query(Mockito.anyString(),Mockito.any(ShoppingIngredientDTORowMapper.class), Mockito.anyInt());
        assertEquals(expectedList,resultList);
    }

}