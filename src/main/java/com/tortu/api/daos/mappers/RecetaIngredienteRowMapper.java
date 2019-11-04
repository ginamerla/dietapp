package com.tortu.api.daos.mappers;

import com.tortu.api.models.RecetaIngrediente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Asigna las propiedades del modelo RecetaIngrediente con cada uno de los campos de la BD
 */
public class RecetaIngredienteRowMapper implements RowMapper<RecetaIngrediente> {
    private static final String ID_RECETA_INGREDIENTE="id_receta_ingrediente";
    private static final String ID_RECETA = "id_receta";
    private static final String ID_INGREDIENTE = "id_ingrediente";
    private static final String ID_MEDIDA = "id_medida";
    private static final String CANTIDAD = "cantidad";
    @Override
    public RecetaIngrediente mapRow(ResultSet resultSet, int i) throws SQLException {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        recetaIngrediente.setIdRecetaIngrediente(resultSet.getInt(ID_RECETA_INGREDIENTE));
        recetaIngrediente.setIdReceta(resultSet.getInt(ID_RECETA));
        recetaIngrediente.setIdIngrediente(resultSet.getInt(ID_INGREDIENTE));
        recetaIngrediente.setIdMedida(resultSet.getInt(ID_MEDIDA));
        recetaIngrediente.setCantidad(resultSet.getDouble(CANTIDAD));
        return recetaIngrediente;
    }
}
