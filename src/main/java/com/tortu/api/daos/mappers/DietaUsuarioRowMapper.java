package com.tortu.api.daos.mappers;

import com.tortu.api.models.DietaUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que mappea las propiedades del modelo "DietaUsuario" con las propiedades de la BD
 * Asigna cada propiedad del modelo con su campo del resultado de la consulta
 */
public class DietaUsuarioRowMapper implements RowMapper<DietaUsuario> {
    private static final String ID_DIETA_USUARIO = "id_dieta_usuario";
    private static final String ID_USUARIO = "id_usuario";
    private static final String DIA_SEMANA = "dia_semana";

    @Override
    public DietaUsuario mapRow(ResultSet resultSet, int i) throws SQLException {
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuario.setIdDietaUsuario(resultSet.getInt(ID_DIETA_USUARIO));
        dietaUsuario.setIdUsuario(resultSet.getInt(ID_USUARIO));
        dietaUsuario.setDiaSemana(resultSet.getString(DIA_SEMANA));
        return dietaUsuario;
    }
}
