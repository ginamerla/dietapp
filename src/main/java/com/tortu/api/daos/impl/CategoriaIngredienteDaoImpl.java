package com.tortu.api.daos.impl;

import com.tortu.api.daos.CategoriaIngredienteDao;
import com.tortu.api.daos.mappers.CategoriaIngredienteRowMapper;
import com.tortu.api.models.CategoriaIngrediente;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que sirve de capa entre los servicios y la llamada a la Base de Datos
 */
@Component
public class CategoriaIngredienteDaoImpl implements CategoriaIngredienteDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger LOG = LoggerFactory.getLogger(CategoriaIngredienteDaoImpl.class);

    @Override
    public void save(CategoriaIngrediente model) throws GeneralException {
        LOG.info(String.format("Creando categoria_ingrediente: %s", model));
        jdbcTemplate.update(SAVE, model.getIdCategoriaIngrediente(), model.getNombre());

    }

    @Override
    public void update(CategoriaIngrediente model) throws GeneralException {
        LOG.info(String.format("Actualizando categoria_ingrediente: %s", model));
        jdbcTemplate.update(UPDATE, model.getNombre(), model.getIdCategoriaIngrediente());

    }

    @Override
    public void delete(Integer id) throws GeneralException {
        LOG.info(String.format("Eliminando categoria_ingrediente %d",id));
        jdbcTemplate.update(DELETE,id);
    }

    @Override
    public CategoriaIngrediente findByiD(Integer id) throws GeneralException {
        LOG.info(String.format("Consultando categoria_ingrediente con id %d", id));
        CategoriaIngrediente categoriaIngrediente = jdbcTemplate.queryForObject(FINDBYID, new CategoriaIngredienteRowMapper(), id);
        return categoriaIngrediente;
    }

    @Override
    public List<CategoriaIngrediente> findAll() throws GeneralException {
        LOG.info("Consultando todos los categoria_ingrediente");
        return jdbcTemplate.query(FIND_ALL, new CategoriaIngredienteRowMapper());
    }
}
