package com.tortu.api.daos.impl;

import com.tortu.api.daos.CategoriaIngredienteDao;
import com.tortu.api.daos.mappers.CategoriaIngredienteRowMapper;
import com.tortu.api.models.CategoriaIngrediente;
import com.tortu.api.utils.GeneralException;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Clase que sirve de capa entre los servicios y la llamada a la Base de Datos
 */
@Log4j2
@Component
public class CategoriaIngredienteDaoImpl implements CategoriaIngredienteDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
//    private static final Logger LOG = LoggerFactory.getLogger(CategoriaIngredienteDaoImpl.class);

    @Override
    public int save(CategoriaIngrediente model) throws GeneralException {
        log.info("Inserting CategoriaIngrediente:{}", model);
//        LOG.info(String.format("Creando categoria_ingrediente: %s", model));
        int updatedRows = jdbcTemplate.update(SAVE, model.getNombre());
        if(updatedRows==0){
            log.error("Cannot insert CategoriaIngrediente in DB");
//            LOG.error("No se pudo insertar en la BD");
            throw  new GeneralException("La CATEGORIA_INGREDIENTE no pudo ser guardada");
        }
        return updatedRows;
    }

    @Override
    public void update(CategoriaIngrediente model) throws GeneralException {
        log.info("Updating CategoriaIngrediente:{}", model);
//        LOG.info(String.format("Actualizando categoria_ingrediente: %s", model));
        int updatedRows = jdbcTemplate.update(UPDATE, model.getNombre(), model.getIdCategoriaIngrediente());
        if(updatedRows==0){
            log.error("Cannot update CategoriaIngrediente in DB");
//            LOG.error("No se pudo actualizar en la BD");
            throw  new GeneralException("El CATEGORIA_INGREDIENTE no pudo ser actualizada");
        }
    }

    @Override
    public void delete(Integer id) throws GeneralException {
        log.info("Deleting CategoriaIngrediente id:{}", id);
//        LOG.info(String.format("Eliminando categoria_ingrediente %d",id));
        int updatedRows = jdbcTemplate.update(DELETE,id);
        if(updatedRows==0){
            log.error("Cannot delete CategoriaIngrediente from DB");
//            LOG.error("No se pudo eliminar en la BD");
            throw  new GeneralException("El CATEGORIA_INGREDIENTE no pudo ser eliminada");
        }
    }

    @Override
    public CategoriaIngrediente findByiD(Integer id) throws GeneralException {
        log.info("Searching CategoriaIngrediente id:{}",id);
//        LOG.info(String.format("Consultando categoria_ingrediente con id %d", id));
        CategoriaIngrediente categoriaIngrediente = null;
        try {
            categoriaIngrediente =jdbcTemplate.queryForObject(FINDBYID, new CategoriaIngredienteRowMapper(), id);
        }catch (Exception e){
            log.error("CategoriaIngrediente not found");
        }
        return categoriaIngrediente;
    }

    @Override
    public List<CategoriaIngrediente> findAll() throws GeneralException {
        log.info("Searching all CategoriaIngredientes");
//        LOG.info("Consultando todos los categoria_ingrediente");
        return jdbcTemplate.query(FIND_ALL, new CategoriaIngredienteRowMapper());
    }
}
