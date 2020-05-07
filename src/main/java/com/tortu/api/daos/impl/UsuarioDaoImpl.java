package com.tortu.api.daos.impl;

import com.tortu.api.daos.UsuarioDao;
import com.tortu.api.daos.mappers.UsuarioRowMapper;
import com.tortu.api.models.Usuario;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioDaoImpl implements UsuarioDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioDaoImpl.class);


    @Override
    public int save(Usuario model)  {
        LOG.info(String.format("Creando el usuario: %s",model));
        int updatedRows = jdbcTemplate.update(SAVE, model.getNombre(), model.getEmail());
        if(updatedRows==0){
            LOG.error("No se pudo insertar en la BD");
            throw  new GeneralException("El USUARIO no pudo ser guardado");
        }
        return updatedRows;
    }

    @Override
    public void update(Usuario model) {
        LOG.info(String.format("Actualizando el usuario: %s",model));
        int updatedRows = jdbcTemplate.update(UPDATE, model.getNombre(), model.getEmail(), model.getIdUsuario());
        if(updatedRows==0){
            LOG.error("No se pudo actualizar en la BD");
            throw  new GeneralException("El USUARIO no pudo ser actualizado");
        }
    }

    @Override
    public void delete(Integer id) {
        LOG.info(String.format("Eliminando el usuario: %d",id));
        int updatedRows = jdbcTemplate.update(DELETE, id);
        if(updatedRows==0){
            LOG.error("No se pudo eliminar en la BD");
            throw  new GeneralException("El USUARIO no pudo ser eliminado");
        }
    }

    @Override
    public Usuario findByiD(Integer idUsuario) {
        LOG.info(String.format("Consultando el usuario con id: %s",idUsuario));
        return  jdbcTemplate.queryForObject(FINDBYID, new UsuarioRowMapper(), idUsuario);
    }

    @Override
    public List<Usuario> findAll() {
        LOG.info("Consultando todos los usuarios");
        return  jdbcTemplate.query(FIND_ALL, new UsuarioRowMapper());
    }
}
