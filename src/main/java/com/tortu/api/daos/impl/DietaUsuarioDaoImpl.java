package com.tortu.api.daos.impl;

import com.tortu.api.daos.DietaUsuarioDao;
import com.tortu.api.daos.mappers.DietaUsuarioRowMapper;
import com.tortu.api.models.DietaUsuario;
import com.tortu.api.utils.GeneralException;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementacion de la capa de acceso a la BD
 */
@Log4j2
@Component
public class DietaUsuarioDaoImpl implements DietaUsuarioDao {
//    private static final Logger LOG = LoggerFactory.getLogger(DietaUsuarioDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(DietaUsuario model) throws GeneralException {
        log.info("Inserting DietaUsuario:{}", model);
//        LOG.info(String.format("Creando DIETA_USUARIO: %s",model));
        int updatedRows = jdbcTemplate.update(SAVE,model.getIdUsuario(),model.getDiaSemana());
        if(updatedRows==0){
            log.error("Cannot insert DietaUsuario in DB");
//            LOG.error("No se pudo insertar en la BD");
            throw  new GeneralException("La DIETA_USUARIO no pudo ser guardada");
        }
        return updatedRows;
    }

    @Override
    public void update(DietaUsuario model) throws GeneralException {
        log.info("Updating DietaUsuario:{}", model);
//        LOG.info(String.format("Actualizando DIETA_USUARIO: %s",model));
        int updatedRows = jdbcTemplate.update(UPDATE,model.getIdUsuario(), model.getDiaSemana(), model.getIdDietaUsuario());
        if(updatedRows==0){
            log.error("Cannot update DietaUsuario in DB");
//            LOG.error("No se pudo actualizar la BD");
            throw  new GeneralException("La DIETA_USUARIO no pudo ser actualizada");
        }
    }

    @Override
    public void delete(Integer id) throws GeneralException {
        log.info("Deleting DietaUsuario id:{}",id);
//        LOG.info("Eliminando DIETA_USUARIO: {}", id);
        int updatedRows = jdbcTemplate.update(DELETE, id);
        if(updatedRows==0){
            log.error("Cannot delete DietaUsuario from DB");
//            LOG.error("No se pudo eliminar de la BD");
            throw  new GeneralException("La DIETA_USUARIO no pudo ser eliminada");
        }
    }

    @Override
    public DietaUsuario findByiD(Integer id) throws GeneralException {
        log.info("Searching DietaUsuario id:{}", id);
//        LOG.info(String.format("Consultando DIETA_USUARIO con id: %d",id));
        DietaUsuario dietaUsuario = null;
        try {
            dietaUsuario = jdbcTemplate.queryForObject(FINDBYID,new DietaUsuarioRowMapper(), id);
        }catch (Exception e){
            log.error("DietaUsuario not found");
        }
        return dietaUsuario;
    }

    @Override
    public List<DietaUsuario> findAll() throws GeneralException {
        log.info("Searching all DietaUsuarios");
//        LOG.info("Consultando todos los DIETAS_USUARIO");
        return jdbcTemplate.query(FIND_ALL, new DietaUsuarioRowMapper());
    }

    @Override
    public List<Integer> findIdDietaUsuarioListByUser (Integer userId){
//        LOG.info("Eliminando DIETA_USUARIO: {}", userId);
        log.info("Searching DietaUsuario with user Id:{}", userId);
        return jdbcTemplate.queryForList(FIND_ID_LIST_BY_USER, Integer.class, userId);
    }
}
