package com.tortu.api.daos.mappers;

import com.tortu.api.dto.ShoppingIngredientDTO;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Asigna las propiedades del DTO con las columnas de la BD
 */
public class ShoppingIngredientDTORowMapper implements RowMapper<ShoppingIngredientDTO>{
    /**
     *   private Double quantity;
     *     private String unit;
     *     private String item;
     *     private String category;
     *     Cantidad|medida  |id_ingrediente|Ingrediente      |Categoria
     */
    private static final String QUANTITY = "Cantidad";
    private static final String UNIT = "medida";
    private static final String ID_INGREDIENT = "id_ingrediente";
    private static final String ITEM = "Ingrediente";
    private static final String CATEGORY = "Categoria";

    @Override
    public ShoppingIngredientDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        ShoppingIngredientDTO dto = new ShoppingIngredientDTO();
        dto.setQuantity(resultSet.getDouble(QUANTITY));
        dto.setUnit(resultSet.getString(UNIT));
        dto.setIdIngredient(resultSet.getInt(ID_INGREDIENT));
        dto.setItem(resultSet.getString(ITEM));
        dto.setCategory(resultSet.getString(CATEGORY));
        return dto;
    }
}
