package com.tortu.api.daos.mappers;

import com.tortu.api.dto.RecipeIngredientLookupDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Asigna las columnas de BD a las propiedades del DTO
 */
public class RecipeIngredientLookupDTORowMapper implements RowMapper<RecipeIngredientLookupDTO>{
   private static final String PERIODO = "periodo";
   private static final String RECETA = "receta";
   private static final String INGREDIENTE = "ingrediente";
   private static final String CANTIDAD = "cantidad";
   private static final String MEDIDA = "medida";

    @Override
    public RecipeIngredientLookupDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        RecipeIngredientLookupDTO dto = new RecipeIngredientLookupDTO();
        dto.setPeriodo(resultSet.getString(PERIODO));
        dto.setReceta(resultSet.getString(RECETA));
        dto.setIngrediente(resultSet.getString(INGREDIENTE));
        dto.setCantidad(resultSet.getDouble(CANTIDAD));
        dto.setMedida(resultSet.getString(MEDIDA));
        return dto;
    }
}

