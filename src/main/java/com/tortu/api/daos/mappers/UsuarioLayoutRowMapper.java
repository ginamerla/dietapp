package com.tortu.api.daos.mappers;

import com.tortu.api.models.UsuarioLayout;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que asigna las propiedades al modelo usuarioLayout correspondientes a los campos de la entidad
 */
public class UsuarioLayoutRowMapper implements RowMapper<UsuarioLayout> {
    public static final String ID_USUARIO_LAYOUT = "id_usuario_layout";
    public static final String ID_LAYOUT = "id_layout";
    public static final String ID_USUARIO = "id_usuario";
    public static final String FECHA = "fecha";
    @Override
    public UsuarioLayout mapRow(ResultSet resultSet, int i) throws SQLException {
        UsuarioLayout usuarioLayout = new UsuarioLayout();
        usuarioLayout.setIdUsuarioLayout(resultSet.getInt(ID_USUARIO_LAYOUT));
        usuarioLayout.setIdUsuario((resultSet.getInt(ID_USUARIO)));
        usuarioLayout.setIdLayout(resultSet.getInt(ID_LAYOUT));
        usuarioLayout.setFecha(resultSet.getDate(FECHA));
        return usuarioLayout;
    }
}
