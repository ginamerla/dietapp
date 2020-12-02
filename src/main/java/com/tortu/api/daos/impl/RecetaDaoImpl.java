package com.tortu.api.daos.impl;

import com.tortu.api.daos.RecetaDao;
import com.tortu.api.daos.mappers.RecetaRowMapper;
import com.tortu.api.models.Receta;
import com.tortu.api.utils.GeneralException;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * Clase de la capa de acceso a la BD
 */
@Log4j2
@Component
public class RecetaDaoImpl implements RecetaDao {

//    private static final Logger LOG = LoggerFactory.getLogger(RecetaDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Receta model) throws GeneralException {
        log.info("Inserting Receta:{}", model);
//        LOG.info(String.format("Creando RECETA :%s", model));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SAVE, new String[]{"id_receta"});
                    ps.setString(1, model.getNombre());
                    return ps;
                }
                , keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void update(Receta model) throws GeneralException {
        log.info("Updating Receta in DB:{}", model);
//        LOG.info(String.format("Actualizando RECETA: %s", model));
        int updatedRows = jdbcTemplate.update(UPDATE, model.getNombre(),model.getIdReceta());
        if(updatedRows==0){
            log.error("Cannot update DB");
//            LOG.error("No se pudo actualizar en la BD");
            throw  new GeneralException("La RECETA no pudo ser actualizada");
        }
    }

    @Override
    public void delete(Integer id) throws GeneralException {
        log.info("Deleting Receta id:{}", id);
//        LOG.info(String.format("Eliminando RECETA ID: %s", id));
        int updatedRows = jdbcTemplate.update(DELETE,id);
        if(updatedRows==0){
            log.error("Cannot delete from DB");
//            LOG.error("No se pudo eliminar en la BD");
            throw  new GeneralException("La RECETA no pudo ser eliminada");
        }
    }

    @Override
    public Receta findByiD(Integer id) throws GeneralException {
        log.info("Searching Receta id:{}", id);
//        LOG.info(String.format("Consultando receta con id: %s",id));
        Receta receta = null;
        try {
            receta = jdbcTemplate.queryForObject(FINDBYID, new RecetaRowMapper(), id);
        }catch (Exception e){
            log.error("Receta not found");
        }
        return receta;
    }

    @Override
    public List<Receta> findAll() throws GeneralException {
        log.info("Searching all Recetas");
//        LOG.info("Consultando todas las recetas");
        return jdbcTemplate.query(FIND_ALL, new RecetaRowMapper());
    }

    public List<Receta> findRecipeByName(String name) throws GeneralException{
        log.info("Searching recipes with name:{}", name);
//        LOG.info(String.format("Consultando recetas con nombre: %s", name));
        String param = "%"+name.trim()+"%";
        return jdbcTemplate.query(FIND_RECIPE_BY_NAME, new RecetaRowMapper(), param);
    }
}
