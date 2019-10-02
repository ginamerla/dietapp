package com.tortu.api.daos.impl;

import com.tortu.api.daos.DietaUsuarioDao;
import com.tortu.api.daos.mappers.DietaUsuarioRowMapper;
import com.tortu.api.models.DietaUsuario;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementacion de la capa de acceso a la BD
 */
@Component
public class DietaUsuarioDaoImpl implements DietaUsuarioDao {
    private static final Logger LOG = LoggerFactory.getLogger(DietaUsuarioDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(DietaUsuario model) throws GeneralException {
        LOG.info(String.format("Creando DIETA_USUARIO: %s",model));
        int updatedRows = jdbcTemplate.update(SAVE,model.getIdUsuario(),model.getDiaSemana());
        if(updatedRows==0){
            LOG.error("No se pudo insertar en la BD");
            throw  new GeneralException("La DIETA_USUARIO no pudo ser guardada");
        }
    }

    @Override
    public void update(DietaUsuario model) throws GeneralException {
        LOG.info(String.format("Actualizando DIETA_USUARIO: %s",model));
        int updatedRows = jdbcTemplate.update(UPDATE,model.getIdUsuario(), model.getDiaSemana(), model.getIdDietaUsuario());
        if(updatedRows==0){
            LOG.error("No se pudo actualizar la BD");
            throw  new GeneralException("La DIETA_USUARIO no pudo ser actualizada");
        }
    }

    @Override
    public void delete(Integer id) throws GeneralException {
        LOG.info("Eliminando DIETA_USUARIO: %d", id);
        int updatedRows = jdbcTemplate.update(DELETE, id);
        if(updatedRows==0){
            LOG.error("No se pudo eliminar de la BD");
            throw  new GeneralException("La DIETA_USUARIO no pudo ser eliminada");
        }
    }

    @Override
    public DietaUsuario findByiD(Integer id) throws GeneralException {
        LOG.info(String.format("Consultando DIETA_USUARIO con id: %d",id));
        DietaUsuario dietaUsuario = jdbcTemplate.queryForObject(FINDBYID,new DietaUsuarioRowMapper(), id);
        return dietaUsuario;
    }

    @Override
    public List<DietaUsuario> findAll() throws GeneralException {
        LOG.info("Consultando todos los DIETAS_USUARIO");
        List<DietaUsuario> dietaUsuarioList = jdbcTemplate.query(FIND_ALL, new DietaUsuarioRowMapper());
        return dietaUsuarioList;
    }
}
