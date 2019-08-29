package com.tortu.api.daos.mappers;

import com.tortu.api.models.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRowMapper implements RowMapper<Usuario> {
    @Override
    public Usuario mapRow(ResultSet resultSet, int i) throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setIdUsuario(resultSet.getInt("id_usuario"));
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setEmail(resultSet.getString("email"));

        return  usuario;
    }
}
