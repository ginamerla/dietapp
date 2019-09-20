package com.tortu.api.daos.mappers;

import com.tortu.api.models.CategoriaIngrediente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta clase mappea (asigna) cada una de las propiedades del modelo de la BD
 * Cada propiedad del modelo(categoriaIngrediente) con los campos de la consulta
 */
public class CategoriaIngredienteRowMapper implements RowMapper<CategoriaIngrediente> {

    private static final String ID_CATEGORIA_INGREDIENTE= "id_categoria_ingrediente";
    private static final String NOMBRE = "nombre";

    @Override
    public CategoriaIngrediente mapRow(ResultSet resultSet, int i) throws SQLException {

        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        categoriaIngrediente.setIdCategoriaIngrediente(resultSet.getInt(ID_CATEGORIA_INGREDIENTE));
        categoriaIngrediente.setNombre(resultSet.getString(NOMBRE));

        return categoriaIngrediente;
    }
}
