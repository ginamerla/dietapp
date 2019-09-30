package com.tortu.api.daos.impl;

import com.tortu.api.daos.UsuarioLayoutDao;
import com.tortu.api.daos.mappers.UsuarioLayoutRowMapper;
import com.tortu.api.models.UsuarioLayout;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementacion de los DAOs, clase que se conecta con la BD
 */
@Component
public class UsuarioLayoutDaoImpl implements UsuarioLayoutDao {

    public static final Logger LOG = LoggerFactory.getLogger(UsuarioDaoImpl.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void save(UsuarioLayout model) throws GeneralException {
        LOG.info(String.format("Guardando usuarioLayout: %s", model));
        int updatedRows = jdbcTemplate.update(SAVE, model.getIdUsuario(), model.getIdLayout(), model.getFecha());
        if(updatedRows==0){
            throw  new GeneralException("El USUARIO_LAYOUT no pudo ser guardado");
        }
    }

    @Override
    public void update(UsuarioLayout model) throws GeneralException {
        LOG.info(String.format("Actualizando UsuarioLayout: %s",model));
        int updatedRows = jdbcTemplate.update(UPDATE,model.getIdUsuario(),model.getIdLayout(),model.getFecha(),model.getIdUsuarioLayout());
        if(updatedRows==0){
            throw  new GeneralException("El USUARIO_LAYOUT no pudo ser actualizado");
        }
    }

    @Override
    public void delete(Integer id) throws GeneralException {
        LOG.info(String.format("Eliminando UsuarioLayout con id: %d", id));
        int updatedRows = jdbcTemplate.update(DELETE, id);
        if(updatedRows==0){
            throw  new GeneralException("El USUARIO_LAYOUT no pudo ser eliminado");
        }
    }

    @Override
    public UsuarioLayout findByiD(Integer id) throws GeneralException {
        LOG.info(String.format("Consultando UsuarioLayout con id: %d", id));
         return jdbcTemplate.queryForObject(FINDBYID, new UsuarioLayoutRowMapper(), id);
    }

    @Override
    public List<UsuarioLayout> findAll() throws GeneralException {
        LOG.info("Consultando todos los usuarioLayout");
        List<UsuarioLayout> usuarioLayoutList = jdbcTemplate.query(FIND_ALL, new UsuarioLayoutRowMapper());
        return usuarioLayoutList;
    }
}
