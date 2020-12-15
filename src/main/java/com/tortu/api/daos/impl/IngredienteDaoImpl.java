package com.tortu.api.daos.impl;

import com.tortu.api.daos.IngredienteDao;
import com.tortu.api.daos.mappers.IngredienteRowMapper;
import com.tortu.api.models.Ingrediente;
import com.tortu.api.utils.GeneralException;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Capa de acceso a la base de datos
 */
@Log4j2
@Component
public class IngredienteDaoImpl implements IngredienteDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Ingrediente model) throws GeneralException {
        log.info("Inserting Ingrediente:{}", model);
        int updatedRows = jdbcTemplate.update(SAVE,model.getNombre(), model.getIdCategoriaIngrediente());
        if(updatedRows==0){
            log.error("Cannot insert Ingrediente in DB");
            throw  new GeneralException("El INGREDIENTE no pudo ser guardado");
        }
        return updatedRows;
    }

    @Override
    public void update(Ingrediente model) throws GeneralException {
        log.info("Updating Ingrediente:{}", model);
        int updatedRows = jdbcTemplate.update(UPDATE, model.getNombre(), model.getIdCategoriaIngrediente(), model.getIdIngrediente());
        if(updatedRows==0){
            log.error("Cannont update Ingrediente in DB");
            throw  new GeneralException("El INGREDIENTE no pudo ser actualizado");
        }
    }

    @Override
    public void delete(Integer id) throws GeneralException {
        log.info("Deleting Ingrediente id:{}", id);
        int updatedRows = jdbcTemplate.update(DELETE,id);
        if(updatedRows==0){
            log.error("Cannot delete Ingrediente from DB");
            throw  new GeneralException("El INGREDIENTE no pudo ser eliminado");
        }
    }

    @Override
    public Ingrediente findByiD(Integer id) throws GeneralException {
        log.info("Searching Ingrediente id:{}", id);
        Ingrediente ingrediente = null;
        try{
            ingrediente = jdbcTemplate.queryForObject(FINDBYID,new IngredienteRowMapper(),id);
        }catch (Exception e){
            log.error("Ingrediente not found");
        }
        return ingrediente;
    }

    @Override
    public List<Ingrediente> findAll() throws GeneralException {
        log.info("Searching all ingredientes");
        return  jdbcTemplate.query(FIND_ALL, new IngredienteRowMapper());
    }
}
