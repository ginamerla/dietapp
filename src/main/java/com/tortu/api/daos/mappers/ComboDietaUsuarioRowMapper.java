package com.tortu.api.daos.mappers;

import com.tortu.api.models.ComboDietaUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Asigna las propiedades del modelo ComboDietaUsuario con los campos de la BD
 */
public class ComboDietaUsuarioRowMapper implements RowMapper<ComboDietaUsuario> {
    private static final String ID_COMBO_DIETA_USUARIO="id_combo_dieta_usuario";
    private static final String ID_DIETA_USUARIO="id_dieta_usuario";
    private static final String ID_RECETA_PERIODO="id_receta_periodo";
    @Override
    public ComboDietaUsuario mapRow(ResultSet resultSet, int i) throws SQLException {
        ComboDietaUsuario comboDietaUsuario = new ComboDietaUsuario();
        comboDietaUsuario.setIdComboDietaUsuario(resultSet.getInt(ID_COMBO_DIETA_USUARIO));
        comboDietaUsuario.setIdDietaUsuario(resultSet.getInt(ID_DIETA_USUARIO));
        comboDietaUsuario.setIdRecetaPeriodo(resultSet.getInt(ID_RECETA_PERIODO));
        return comboDietaUsuario;
    }
}
