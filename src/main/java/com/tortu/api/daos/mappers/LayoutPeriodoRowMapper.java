package com.tortu.api.daos.mappers;

import com.tortu.api.models.LayoutPeriodo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Asigna las propiedades del modelo a cada uno de los campos de la entidad en la BD
 */
public class LayoutPeriodoRowMapper implements RowMapper<LayoutPeriodo> {
    private static final String ID_LAYOUT_PERIODO = "id_layout_periodo";
    private static final String ID_LAYOUT="id_layout";
    private static final String ID_PERIODO="id_periodo";

    @Override
    public LayoutPeriodo mapRow(ResultSet resultSet, int i) throws SQLException {
        LayoutPeriodo layoutPeriodo = new LayoutPeriodo();
        layoutPeriodo.setIdLayoutPeriodo(resultSet.getInt(ID_LAYOUT_PERIODO));
        layoutPeriodo.setIdLayout(resultSet.getInt(ID_LAYOUT));
        layoutPeriodo.setIdPeriodo(resultSet.getInt(ID_PERIODO));
        return layoutPeriodo;
    }
}
