package com.tortu.api.daos.mappers;

import com.tortu.api.models.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta clase mapea(asigna) cada una de las propiedades del modelo con la BD
 * Cada propiedad del modelo "usuario" con los campos del resultado de la consulta
 */
public class UsuarioRowMapper implements RowMapper<Usuario> {

    private static final String NOMBRE = "nombre";
    private static final String ID_USUARIO = "id_usuario";
    private static final String EMAIL = "email";

    @Override
    public Usuario mapRow(ResultSet resultSet, int i) throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setIdUsuario(resultSet.getInt(ID_USUARIO));
        usuario.setNombre(resultSet.getString(NOMBRE));
        usuario.setEmail(resultSet.getString(EMAIL));

        return  usuario;
    }
}
