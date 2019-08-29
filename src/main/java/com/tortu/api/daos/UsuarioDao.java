package com.tortu.api.daos;

import com.tortu.api.models.Usuario;

public interface UsuarioDao extends GenericDao<Usuario, Integer>{

    public static final String FIND_ALL =
            "select * from usuario";
    public static final String FINDBYID =
            "select * from usuario where id_usuario=?";
    public static final String SAVE =
            "insert into usuario (id_usuario, nombre, email) values (?, ?, ?)";
    public static final String UPDATE =
            "update usuario set nombre = ?, email = ? where id_usuario = ?";
    public static final String DELETE =
            "delete from usuario where id_usuario = ?";

}
