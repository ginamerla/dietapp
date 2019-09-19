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
        jdbcTemplate.update(SAVE, model.getIdReceta(), model.getNombre());
    }

    @Override
    public void update(Receta model) throws GeneralException {
        LOG.info(String.format("Actualizando RECETA: %s", model));
        jdbcTemplate.update(UPDATE, model.getNombre(),model.getIdReceta());
    }

    @Override
    public void delete(Integer id) throws GeneralException {
        LOG.info(String.format("Eliminando RECETA ID: %s", id));
        jdbcTemplate.update(DELETE,id);
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
