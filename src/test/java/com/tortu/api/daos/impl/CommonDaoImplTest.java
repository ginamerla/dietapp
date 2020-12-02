package com.tortu.api.daos.impl;

import com.tortu.api.daos.mappers.RecipeIngredientLookupDTORowMapper;
import com.tortu.api.daos.mappers.ShoppingIngredientDTORowMapper;
import com.tortu.api.daos.mappers.WPIngredientResultDTORowMapper;
import com.tortu.api.daos.mappers.WeeklyPlanResultDTORowMapper;
import com.tortu.api.dto.RecipeIngredientLookupDTO;
import com.tortu.api.dto.ShoppingIngredientDTO;
import com.tortu.api.dto.WPIngredientResultDTO;
import com.tortu.api.dto.WPResultDTO;
import com.tortu.api.rest.mappers.RecipeIngredientLookupResourceMapper;
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
public class CommonDaoImplTest {
    @InjectMocks
    private CommonDaoImpl dao = new CommonDaoImpl();
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

    @Test
    public void getWeeklyPlanByUser(){
        Integer userId = 1;
        List<WPResultDTO> expectedDtoList = new ArrayList<>();
        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(WeeklyPlanResultDTORowMapper.class), Mockito.anyInt())).thenReturn(expectedDtoList);

        List<WPResultDTO> actualList = dao.getWeeklyPlanByUser(userId);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).query(Mockito.anyString(), Mockito.any(WeeklyPlanResultDTORowMapper.class), Mockito.anyInt());
        assertEquals(expectedDtoList,actualList);
    }

    @Test
    public void getRecipeIngredients(){
        Integer recipeId = 3;
        List<WPIngredientResultDTO> expectedList = new ArrayList<>();
        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(WPIngredientResultDTORowMapper.class), Mockito.anyInt())).thenReturn(expectedList);

        List<WPIngredientResultDTO> actualList = dao.getRecipeIngredients(recipeId);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).query((Mockito.anyString()), Mockito.any(WPIngredientResultDTORowMapper.class), Mockito.anyInt());
        assertEquals(expectedList,actualList);
    }

    @Test
    public void getRecipeListByIngredient(){
        String param="chia";
        List<RecipeIngredientLookupDTO> expectedList=new ArrayList<>();
        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(RecipeIngredientLookupDTORowMapper.class), Mockito.anyString())).thenReturn(expectedList);

        List<RecipeIngredientLookupDTO> actualList = dao.getRecipeListByIngredient(param);

        Mockito.verify(jdbcTemplate,Mockito.times(1)).query(Mockito.anyString(), Mockito.any(RecipeIngredientLookupDTORowMapper.class), Mockito.anyString());
        assertEquals(expectedList,actualList);
    }
}