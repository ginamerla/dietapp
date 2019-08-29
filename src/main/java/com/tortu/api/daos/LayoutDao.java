package com.tortu.api.daos;

import com.tortu.api.models.Layout;

public interface LayoutDao extends GenericDao<Layout, Integer> {
    public static final String FIND_ALL =
            "select * from layout";
    public static final String FINDBYID =
            "select * from layout where id_layout=?";
    public static final String SAVE =
            "insert into layout (id_layout, layout, activo) values (?, ?, ?)";
    public static final String UPDATE =
            "update layout set layout = ?, activo = ? where id_layout = ?";
    public static final String DELETE =
            "delete from layout where id_layout = ?";
}
