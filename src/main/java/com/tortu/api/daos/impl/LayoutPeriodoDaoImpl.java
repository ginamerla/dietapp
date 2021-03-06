package com.tortu.api.daos.impl;

import com.tortu.api.daos.LayoutPeriodoDao;
import com.tortu.api.daos.mappers.LayoutPeriodoRowMapper;
import com.tortu.api.models.LayoutPeriodo;
import com.tortu.api.utils.GeneralException;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementacion de la clase de acceso a la BD
 */
@Log4j2
@Component
public class LayoutPeriodoDaoImpl implements LayoutPeriodoDao {
//    private static final Logger LOG = LoggerFactory.getLogger(LayoutPeriodoDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(LayoutPeriodo model) throws GeneralException {
        log.info("Inserting LayoutPeriodo:{}", model);
//        LOG.info(String.format("Insertando LayoutPeriodo: %s",model));
        int updatedRows = jdbcTemplate.update(SAVE,model.getIdLayout(), model.getIdPeriodo());
        if(updatedRows==0){
            log.error("Cannot insert in DB");
//            LOG.error("No se pudo insertar en la BD");
            throw new GeneralException("No se pudo insertar el nuevo regitro LayoutPeriodo");
        }
        return updatedRows;
    }

    @Override
    public void update(LayoutPeriodo model) throws GeneralException {
        log.info("Updating LayoutPeriodo:{}", model);
//        LOG.info(String.format("Actualizando el LayoutPeriodo: %s",model));
        int updatedRows = jdbcTemplate.update(UPDATE,model.getIdLayout(),model.getIdPeriodo(),model.getIdLayoutPeriodo());
        if(updatedRows==0){
            log.error("Cannot update LayoutPeriodo in DB");
//            LOG.error("No se pudo actualizar en la BD");
            throw new GeneralException("No se pudo actualizar el registro LayoutPeriodo");
        }
    }

    @Override
    public void delete(Integer id) throws GeneralException {
        log.info("Deleting LayoutPeriodo id:{}", id);
//        LOG.info(String.format("Eliminando el layoutPeriodo con id: %d",id));
        int updatedRows = jdbcTemplate.update(DELETE,id);
        if(updatedRows==0){
            log.error("Cannot delete LayoutPeriodo from DB");
//            LOG.error("No se pudo eliminar en la BD");
            throw new GeneralException("No se pudo eliminar el layoutPeriodo");
        }
    }

    @Override
    public LayoutPeriodo findByiD(Integer id) throws GeneralException {
        log.info("Searching LayoutPeriodo id:{}", id);
//        LOG.info(String.format("Consultando el layoutPeriod con id: %d",id));
        LayoutPeriodo layoutPeriodo = null;
        try {
            layoutPeriodo = jdbcTemplate.queryForObject(FINDBYID, new LayoutPeriodoRowMapper(), id);
        }catch (Exception e){
            log.error("LayoutPeriodo not found");
        }
        return layoutPeriodo;
    }

    @Override
    public List<LayoutPeriodo> findAll() throws GeneralException {
        log.info("Searching all LayoutPeriodos");
//        LOG.info("Consultando todos los LayoutPeriodo");
        return jdbcTemplate.query(FIND_ALL,new LayoutPeriodoRowMapper());
    }
}
