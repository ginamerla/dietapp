package com.tortu.api.daos.mappers;

import com.tortu.api.dto.WPResultDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Asigna las columnas de BD al DTO
 */
public class WeeklyPlanResultDTORowMapper implements RowMapper<WPResultDTO> {

     private static final String WEEK_DAY = "dia_semana";
     private static final String PERIOD_NAME = "periodo";
     private static final String RECIPE_NAME = "nombre";
     private static final String RECIPE_ID = "id_receta";

    @Override
    public WPResultDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        WPResultDTO dto = new WPResultDTO();
        dto.setWeekDay(resultSet.getString(WEEK_DAY));
        dto.setPeriodName(resultSet.getString(PERIOD_NAME));
        dto.setRecipeName(resultSet.getString(RECIPE_NAME));
        dto.setRecipeId(resultSet.getInt(RECIPE_ID));
        return dto;
    }
}
