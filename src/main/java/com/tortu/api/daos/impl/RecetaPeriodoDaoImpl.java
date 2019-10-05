package com.tortu.api.daos.impl;

import com.tortu.api.daos.RecetaPeriodoDao;
import com.tortu.api.daos.mappers.RecetaPeriodoRowMapper;
import com.tortu.api.models.RecetaPeriodo;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
    public void save(RecetaPeriodo model) throws GeneralException {
        LOG.info(String.format("Guardando el Receta_Periodo: %s",model));
        int updatedRows = jdbcTemplate.update(SAVE,model.getIdReceta(), model.getIdPeriodo());
        if(updatedRows==0){
            LOG.error("No se pudo insertar en la Base de Datos");
            throw new GeneralException("RecetaPeriodo no pudo ser guardado");
        }
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
}
