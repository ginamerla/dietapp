package com.tortu.api.daos;

import com.tortu.api.models.LayoutPeriodo;

public interface LayoutPeriodoDao extends GenericDao<LayoutPeriodo,Integer> {
    public static final String FIND_ALL =
            "select * from layout_periodo" +
                    "inner join receta on layout_periodo.id_layout=layout.id_layout" +
                    "inner join periodo on layout_periodo.id_periodo =periodo.id_periodo";
    public static final String FINDBYID =
            "select * from layout_periodo" +
                    "inner join receta on layout_periodo.id_layout=layout.id_layout" +
                    "inner join periodo on layout_periodo.id_periodo =periodo.id_periodo" +
                    "where id_layout_periodo = ?";
    public static final String SAVE =
            "insert into layout_periodo (id_layout_periodo, id_layout, id_periodo) values (?, ?,?)";
    public static final String UPDATE =
            "update layout_periodo set id_layout = ?, id_periodo = ? where id_layout_periodo = ?";
    public static final String DELETE =
            "delete from layout_periodo where id_layout_periodo = ?";
}
