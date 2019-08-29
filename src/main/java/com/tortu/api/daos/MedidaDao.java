package com.tortu.api.daos;

import com.tortu.api.models.Medida;

public interface MedidaDao extends GenericDao<Medida, Integer> {
    public static final String FIND_ALL =
            "select * from medida";
    public static final String FINDBYID =
            "select * from medida where id_medida=?";
    public static final String SAVE =
            "insert into medida (id_medida, medida) values (?, ?)";
    public static final String UPDATE =
            "update medida set medida = ? where id_medida = ?";
    public static final String DELETE =
            "delete from medida where id_medida = ?";
}
