package com.tortu.api.daos;

import com.tortu.api.models.DietaUsuario;

public interface DietaUsuarioDao extends GenericDao<DietaUsuario, Integer> {
    public static final String FIND_ALL =
            "select * from dieta_usuario" +
                    "inner join usuario on dieta_usuario.id_usuario = usuario.id_usuario";
    public static final String FINDBYID =
            "select * from dieta_usuario" +
                    "inner join usuario on dieta_usuario.id_usuario = usuario.id_usuario" +
                    "where id_dieta_usuario = ?";
    public static final String SAVE =
            "insert into dieta_usuario (id_dieta_usuario, id_usuario, dia_semana) values (?, ?, ?)";
    public static final String UPDATE =
            "update dieta_usuario set id_usuario = ?, dia_semana = ? where id_dieta_usuario = ?";
    public static final String DELETE =
            "delete from dieta_usuario where id_dieta_usuario = ?";
}
