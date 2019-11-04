package com.tortu.api.daos.impl;

import com.tortu.api.daos.RecetaIngredienteDao;
import com.tortu.api.daos.mappers.RecetaIngredienteRowMapper;
import com.tortu.api.models.RecetaIngrediente;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementacion de la capa de acceso a la BD del modelo RecetaIngrediente
 */
@Component
public class RecetaIngredienteDaoImpl implements RecetaIngredienteDao {
    private static final Logger LOG = LoggerFactory.getLogger(RecetaIngredienteDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void save(RecetaIngrediente model) throws GeneralException {
        LOG.info(String.format("Guardando el modelo en la Base de datos: %s",model));
        int updatedRows = jdbcTemplate.update(SAVE, model.getCantidad(), model.getIdReceta(), model.getIdMedida(), model.getIdIngrediente());
        if(updatedRows==0){
            LOG.error(String.format("No se pudo guardar el modelo en la base de datos: %s", model));
            throw new GeneralException("La RecetaIngrediente no se pudo guardar");
        }
    }

    @Override
    public void update(RecetaIngrediente model) throws GeneralException {
        LOG.info(String.format("Actualizando la informacion del modelo: %s", model));
        int updatedRows=jdbcTemplate.update(UPDATE, model.getCantidad(), model.getIdReceta(), model.getIdMedida(), model.getIdIngrediente(), model.getIdRecetaIngrediente());
        if(updatedRows==0){
            LOG.error(String.format("No se pudo actualizar el modelo en la base de datos: %s",model));
            throw new GeneralException("La RecetaIngrediente no se pudo actualizar");
        }
    }

    @Override
    public void delete(Integer id) throws GeneralException {
        LOG.info(String.format("Eliminando el modelo con id: %d",id));
        int updatedRows=jdbcTemplate.update(DELETE,id);
        if(updatedRows==0){
            LOG.error(String.format("No se pudo eliminar de la base de datos el modelo con id: %d", id));
            throw new GeneralException("La RecetaIngrediente no se pudo eliminar");
        }
    }

    @Override
    public RecetaIngrediente findByiD(Integer id) throws GeneralException {
        LOG.info(String.format("Consultando modelo con id: %d", id));
        return jdbcTemplate.queryForObject(FINDBYID, new RecetaIngredienteRowMapper(),id);
    }

    @Override
    public List<RecetaIngrediente> findAll() throws GeneralException {
        LOG.info("Consultando todas las RecetasIngredientes");
        return jdbcTemplate.query(FIND_ALL, new RecetaIngredienteRowMapper());
    }
}
