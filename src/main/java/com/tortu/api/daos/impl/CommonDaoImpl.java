package com.tortu.api.daos.impl;

import com.tortu.api.daos.CommonDao;
import com.tortu.api.daos.mappers.RecipeIngredientLookupDTORowMapper;
import com.tortu.api.daos.mappers.ShoppingIngredientDTORowMapper;
import com.tortu.api.daos.mappers.WPIngredientResultDTORowMapper;
import com.tortu.api.daos.mappers.WeeklyPlanResultDTORowMapper;
import com.tortu.api.dto.RecipeIngredientLookupDTO;
import com.tortu.api.dto.ShoppingIngredientDTO;
import com.tortu.api.dto.WPIngredientResultDTO;
import com.tortu.api.dto.WPResultDTO;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Capa de acceso a la BD
 */
@Log4j2
@Component
public class CommonDaoImpl implements CommonDao {

//    public static final Logger LOG = LoggerFactory.getLogger(CommonDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ShoppingIngredientDTO> getShoppingList(Integer userId) {
        // jdbc template - usar DTO aqui para mapear y regresar una lista de DTO
        log.info("Searching DB... Getting shoppingList for user id:{}", userId);
//        LOG.info(String.format("Consultando BD... Obteniendo lista de compras para usuario: %d", userId));
        return jdbcTemplate.query(FIND_SHOPPINGINGREDIENT, new ShoppingIngredientDTORowMapper(), userId);
    }

    @Override
    public List<WPResultDTO> getWeeklyPlanByUser(Integer userId) {
        log.info("Searching DB... Getting weeklyPlan List for user id:{}", userId);
//        LOG.info(String.format("Consultando BD... Obtieniendo lista plan semanal del usuario: %d", userId));
        return jdbcTemplate.query(FIND_WEEKLYPLAN_BY_USER, new WeeklyPlanResultDTORowMapper(), userId);
    }

    @Override
    public List<WPIngredientResultDTO> getRecipeIngredients(Integer recipeId) {
        log.info("Searching DB... Getting ingredientList for recipe id:{}", recipeId);
//        LOG.info(String.format("Consultando BD... Obteniendo lista de ingredientes para la receta: %d", recipeId));
        return jdbcTemplate.query(FIND_INGREDIENTS_BY_RECIPE, new WPIngredientResultDTORowMapper(), recipeId);
    }

    @Override
    public List<RecipeIngredientLookupDTO> getRecipeListByIngredient(String ingredient) {
        log.info("Searching DB... Getting recipes with ingredient:{}", ingredient);
//        LOG.info(String.format("Consultando BD... Obteniendo recetas con ingrediente: %s", ingredient));
        String param = "%"+ingredient.trim()+"%";
        return jdbcTemplate.query(FIND_RECIPE_BY_INGREDIENT, new RecipeIngredientLookupDTORowMapper(), param);
    }



}
