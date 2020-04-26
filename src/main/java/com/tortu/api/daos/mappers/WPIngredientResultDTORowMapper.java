package com.tortu.api.daos.mappers;

import com.tortu.api.dto.WPIngredientResultDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Asigna las propiedades del DTO con las columnas de la BD obtenidad en la consulta
 */
public class WPIngredientResultDTORowMapper implements RowMapper<WPIngredientResultDTO> {
    //Receta, Ingrediente, cantidad, Medida
    private static final String RECIPE_NAME = "Receta";
    private static final String ITEM = "Ingrediente";
    private static final String QUANTITY = "cantidad";
    private static final String UNIT = "Medida";

    @Override
    public WPIngredientResultDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        WPIngredientResultDTO dto = new WPIngredientResultDTO();
        dto.setRecipeName(resultSet.getString(RECIPE_NAME));
        dto.setItem(resultSet.getString(ITEM));
        dto.setQuantity(resultSet.getDouble(QUANTITY));
        dto.setUnit(resultSet.getString(UNIT));
        return dto;
    }
}
