package com.tortu.api.daos.mappers;

import com.tortu.api.dto.PopularRecipe;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Assigns the PopularRecipe object properties with the BD entity properties.
 */
public class PopularRecipeRowMapper implements RowMapper<PopularRecipe> {
    private static final String RECIPE_NAME = "nombre";
    private static final String RECIPE_COUNT ="total";
    @Override
    public PopularRecipe mapRow(ResultSet resultSet, int i) throws SQLException {
        PopularRecipe popularRecipe = new PopularRecipe();
        popularRecipe.setRecipeName(resultSet.getString(RECIPE_NAME));
        popularRecipe.setRecipeCount(resultSet.getInt(RECIPE_COUNT));
        return popularRecipe;
    }
}
