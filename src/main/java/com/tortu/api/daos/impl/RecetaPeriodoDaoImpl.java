package com.tortu.api.daos.impl;

import com.tortu.api.daos.RecetaPeriodoDao;
import com.tortu.api.daos.mappers.RecetaPeriodoRowMapper;
import com.tortu.api.models.RecetaPeriodo;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * Implementacion de la capa de acceso a la Base de Datos del modelo RecetaPeriodo
 */
@Component
public class RecetaPeriodoDaoImpl implements RecetaPeriodoDao {
    private static final Logger LOG = LoggerFactory.getLogger(RecetaPeriodoDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(RecetaPeriodo model) throws GeneralException {
        LOG.info(String.format("Guardando el Receta_Periodo: %s",model));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SAVE, new String[]{
                    "id_receta_periodo"
            });
            ps.setInt(1,model.getIdReceta());
            ps.setInt(2,model.getIdPeriodo());
            return ps;
        }, keyHolder);

//        int updatedRows = jdbcTemplate.update(SAVE,model.getIdReceta(), model.getIdPeriodo());
//        if(updatedRows==0){
//            LOG.error("No se pudo insertar en la Base de Datos");
//            throw new GeneralException("RecetaPeriodo no pudo ser guardado");
//        }
//        return updatedRows;
        return keyHolder.getKey().intValue();
    }

    @Override
    public void update(RecetaPeriodo model) throws GeneralException {
        LOG.info(String.format("Actualizando el Receta_Periodo: %s",model));
        int updatedRows = jdbcTemplate.update(UPDATE,model.getIdReceta(), model.getIdPeriodo(), model.getIdRecetaPeriodo());
        if(updatedRows==0){
            LOG.error("No se pudo actualizar la Base de Datos");
            throw new GeneralException("RecetaPeriodo no pudo ser actualizado");
        }
    }

    @Override
    public void delete(Integer id) throws GeneralException {
        LOG.info(String.format("Eliminando Receta_Periodo con id: %d",id));
        int updatedRows = jdbcTemplate.update(DELETE,id);
        if(updatedRows==0){
            LOG.error("No se pude eliminar de la Base de Datos");
            throw new GeneralException("RecetaPeriodo no pudo ser eliminado");
        }
    }

    @Override
    public RecetaPeriodo findByiD(Integer id) throws GeneralException {
        LOG.info(String.format("Consultando RecetaPeriodo con id: %d", id));
        return jdbcTemplate.queryForObject(FINDBYID, new RecetaPeriodoRowMapper(), id);
    }

    @Override
    public List<RecetaPeriodo> findAll() throws GeneralException {
        LOG.info("Consultando todos los Receta_Periodo");
        return jdbcTemplate.query(FIND_ALL, new RecetaPeriodoRowMapper());
    }

    @Override
    public List<Integer> findRecetaPeriodoIdListByPeriodoReceta(Integer periodId, List<Integer> recipeIdList) {
        LOG.info("Consultando la lista de ids con periodId y recipeId");
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("ids", recipeIdList);
        parameters.addValue("periodId", periodId);
        return namedParameterJdbcTemplate.queryForList(FIND_ID_LIST_BY_PERIODO_RECETA, parameters, Integer.class);
    }
}
