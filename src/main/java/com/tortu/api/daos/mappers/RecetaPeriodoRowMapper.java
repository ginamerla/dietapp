package com.tortu.api.daos.mappers;

import com.tortu.api.models.RecetaPeriodo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que asigna las propiedades del modelo RecetaPeriodo con los campos de la entidad en la BD
 */
public class RecetaPeriodoRowMapper implements RowMapper<RecetaPeriodo> {

    private static final String ID_RECETA_PERIODO = "id_receta_periodo";
    private static final String ID_RECETA="id_receta";
    private static final String ID_PERIODO="id_periodo";
    @Override
    public RecetaPeriodo mapRow(ResultSet resultSet, int i) throws SQLException {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        recetaPeriodo.setIdRecetaPeriodo(resultSet.getInt(ID_RECETA_PERIODO));
        recetaPeriodo.setIdReceta(resultSet.getInt(ID_RECETA));
        recetaPeriodo.setIdPeriodo(resultSet.getInt(ID_PERIODO));
        return recetaPeriodo;
    }
}
