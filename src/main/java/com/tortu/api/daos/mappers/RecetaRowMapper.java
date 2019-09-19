package com.tortu.api.daos.mappers;

import com.tortu.api.models.Receta;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que mappea las propiedades del modelo "receta" con las propiedades de la BD
 * Asigna cada propiedad del modelo con su campo del resultado de la consulta
 */
public class RecetaRowMapper implements RowMapper<Receta> {

    private static final String ID_RECETA = "id_receta";
    private static final String NOMBRE = "nombre";

    @Override
    public Receta mapRow(ResultSet resultSet, int i) throws SQLException {
        Receta receta = new Receta();
        receta.setIdReceta(resultSet.getInt(ID_RECETA));
        receta.setNombre(resultSet.getString(NOMBRE));
        return receta;
    }
}
