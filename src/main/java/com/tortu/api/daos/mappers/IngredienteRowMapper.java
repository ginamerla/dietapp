package com.tortu.api.daos.mappers;

import com.tortu.api.models.Ingrediente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Asigna las propiedades del modelo ingrediente con las propiedades de la base de datos
 */
public class IngredienteRowMapper implements RowMapper<Ingrediente> {
    public static final String ID_INGREDIENTE = "id_ingrediente";
    public static final String NOMBRE = "nombre";
    public static final String ID_CATEGORIA_INGREDIENTE = "id_categoria_ingrediente";

    @Override
    public Ingrediente mapRow(ResultSet resultSet, int i) throws SQLException {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(resultSet.getInt(ID_INGREDIENTE));
        ingrediente.setNombre(resultSet.getString(NOMBRE));
        ingrediente.setIdCategoriaIngrediente(resultSet.getInt(ID_CATEGORIA_INGREDIENTE));
        return ingrediente;
    }
}
