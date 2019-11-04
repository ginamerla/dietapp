package com.tortu.api.daos;

import com.tortu.api.models.RecetaPeriodo;

public interface RecetaPeriodoDao extends GenericDao <RecetaPeriodo,Integer> {
    public static final String FIND_ALL =
            "select * from receta_periodo";
    public static final String FINDBYID =
            "select * from receta_periodo where id_receta_periodo=?";
    public static final String SAVE =
            "insert into receta_periodo (id_receta, id_periodo) values (?, ?)";
    public static final String UPDATE =
            "update receta_periodo set id_receta = ?, id_periodo = ? where id_receta_periodo = ?";
    public static final String DELETE =
            "delete from receta_periodo where id_receta_periodo = ?";
}
