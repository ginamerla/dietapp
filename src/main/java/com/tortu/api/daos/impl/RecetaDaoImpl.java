package com.tortu.api.daos.impl;

import com.tortu.api.DietAppApplication;
import com.tortu.api.daos.RecetaDao;
import com.tortu.api.daos.mappers.RecetaRowMapper;
import com.tortu.api.models.Receta;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de la capa de acceso a la BD
 */
@Component
public class RecetaDaoImpl implements RecetaDao {

    private static final Logger LOG = LoggerFactory.getLogger(RecetaDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Receta model) throws GeneralException {
        LOG.info(String.format("Creando RECETA :%s", model));
        int updatedRows = jdbcTemplate.update(SAVE, model.getNombre());
        if(updatedRows==0){
            LOG.error("No se pudo insertar en la BD");
            throw  new GeneralException("La RECETA no pudo ser guardada");
        }
    }

    @Override
    public void update(Receta model) throws GeneralException {
        LOG.info(String.format("Actualizando RECETA: %s", model));
        int updatedRows = jdbcTemplate.update(UPDATE, model.getNombre(),model.getIdReceta());
        if(updatedRows==0){
            LOG.error("No se pudo actualizar en la BD");
            throw  new GeneralException("La RECETA no pudo ser actualizada");
        }
    }

    @Override
    public void delete(Integer id) throws GeneralException {
        LOG.info(String.format("Eliminando RECETA ID: %s", id));
        int updatedRows = jdbcTemplate.update(DELETE,id);
        if(updatedRows==0){
            LOG.error("No se pudo eliminar en la BD");
            throw  new GeneralException("La RECETA no pudo ser eliminada");
        }
    }

    @Override
    public Receta findByiD(Integer id) throws GeneralException {
        LOG.info(String.format("Consultando receta con id: %s",id));
        Receta receta = jdbcTemplate.queryForObject(FINDBYID, new RecetaRowMapper(), id);
        return receta;
    }

    @Override
    public List<Receta> findAll() throws GeneralException {
        LOG.info("Consultando todas las recetas");
        List<Receta> recetaList = jdbcTemplate.query(FIND_ALL, new RecetaRowMapper());
        return recetaList;
    }
}
