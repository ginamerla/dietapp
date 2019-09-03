package com.tortu.api.daos;

import com.tortu.api.models.UsuarioLayout;

public interface UsuarioLayoutDao extends GenericDao<UsuarioLayout, Integer> {
    public static final String FIND_ALL =
            "select * from usuario_layout" +
                    "inner join usuario on usuario_layout.id_usuario = usuario.id_usuario" +
                    "inner join layout on usuario_layout.id_layout = layout.id_layout";
    public static final String FINDBYID =
            "select * from usuario_layout" +
                    "inner join usuario on usuario_layout.id_usuario = usuario.id_usuario" +
                    "inner join layout on usuario_layout.id_layout = layout.id_layout" +
                    "where id_usuario_layout=?";
    public static final String SAVE =
            "insert into usuario_layout (id_usuario_layout, id_usuario, id_layout, fecha) values (?, ?, ?,?)";
    public static final String UPDATE =
            "update usuario_layout set id_usuario = ?, id_layout = ?, fecha = ? where id_usuario_layout = ?";
    public static final String DELETE =
            "delete from usuario_layout where id_usuario_layout = ?";
}
