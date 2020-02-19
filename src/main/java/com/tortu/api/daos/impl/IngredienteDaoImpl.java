package com.tortu.api.daos.impl;

import com.tortu.api.daos.IngredienteDao;
import com.tortu.api.daos.mappers.IngredienteRowMapper;
import com.tortu.api.models.Ingrediente;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Capa de acceso a la base de datos
 */
@Component
public class IngredienteDaoImpl implements IngredienteDao {
    public static final Logger LOG = LoggerFactory.getLogger(IngredienteDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Ingrediente model) throws GeneralException {
        LOG.info(String.format("Creando INGREDIENTE: %s",model));
        int updatedRows = jdbcTemplate.update(SAVE,model.getNombre(), model.getIdCategoriaIngrediente());
        if(updatedRows==0){
            LOG.error("No se pudo insertar en la BD");
            throw  new GeneralException("El INGREDIENTE no pudo ser guardado");
        }
    }

    @Override
    public void update(Ingrediente model) throws GeneralException {
        LOG.info((String.format("Actualizando INGREDIENTE: %s", model)));
        int updatedRows = jdbcTemplate.update(UPDATE, model.getNombre(), model.getIdCategoriaIngrediente(), model.getIdIngrediente());
        if(updatedRows==0){
            LOG.error("No se pudo actualizar en la BD");
            throw  new GeneralException("El INGREDIENTE no pudo ser actualizado");
        }
    }

    @Override
    public void delete(Integer id) throws GeneralException {
        LOG.info(String.format("Eliminando INGREDIENTE con id: %d", id));
        int updatedRows = jdbcTemplate.update(DELETE,id);
        if(updatedRows==0){
            LOG.error("No se pudo eliminar en la BD");
            throw  new GeneralException("El INGREDIENTE no pudo ser eliminado");
        }
    }

    @Override
    public Ingrediente findByiD(Integer id) throws GeneralException {
        LOG.info(String.format("Consultando INGREDIENTE con id: %d",id));
        return jdbcTemplate.queryForObject(FINDBYID,new IngredienteRowMapper(),id);
    }

    @Override
    public List<Ingrediente> findAll() throws GeneralException {
        LOG.info("Consultando todos los INGREDIENTES");
        return  jdbcTemplate.query(FIND_ALL, new IngredienteRowMapper());
    }
}
