package com.tortu.api.daos;

import com.tortu.api.models.Periodo;

public interface PeriodoDao extends GenericDao<Periodo, Integer> {
    public static final String FIND_ALL =
            "select * from periodo";
    public static final String FINDBYID =
            "select * from periodo where id_periodo=?";
    public static final String SAVE =
            "insert into periodo (id_periodo, periodo) values (?, ?)";
    public static final String UPDATE =
            "update periodo set periodo = ?, where id_periodo = ?";
    public static final String DELETE =
            "delete from periodo where id_periodo = ?";
}
