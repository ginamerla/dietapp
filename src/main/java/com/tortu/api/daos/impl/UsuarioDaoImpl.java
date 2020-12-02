package com.tortu.api.daos.impl;

import com.tortu.api.daos.UsuarioDao;
import com.tortu.api.daos.mappers.UsuarioRowMapper;
import com.tortu.api.models.Usuario;
import com.tortu.api.utils.GeneralException;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Log4j2
@Component
public class UsuarioDaoImpl implements UsuarioDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
//    private static final Logger LOG = LoggerFactory.getLogger(UsuarioDaoImpl.class);


    @Override
    public int save(Usuario model)  {
        log.info("Inserting user: {}", model);
//        LOG.info(String.format("Creando el usuario: %s",model));
        int updatedRows = jdbcTemplate.update(SAVE, model.getNombre(), model.getEmail());
        if(updatedRows==0){
            log.error("Cannot insert Usuario in DB");
//            LOG.error("No se pudo insertar en la BD");
            throw  new GeneralException("El USUARIO no pudo ser guardado");
        }
        return updatedRows;
    }

    @Override
    public void update(Usuario model) {
        log.info("Updating user: {}",model);
//        LOG.info(String.format("Actualizando el usuario: %s",model));
        int updatedRows = jdbcTemplate.update(UPDATE, model.getNombre(), model.getEmail(), model.getIdUsuario());
        if(updatedRows==0){
            log.error("Cannot update Usuario in DB");
//            LOG.error("No se pudo actualizar en la BD");
            throw  new GeneralException("El USUARIO no pudo ser actualizado");
        }
    }

    @Override
    public void delete(Integer id) {
        log.info("Deleting user id:{}", id);
//        LOG.info(String.format("Eliminando el usuario: %d",id));
        int updatedRows = jdbcTemplate.update(DELETE, id);
        if(updatedRows==0){
            log.error("Cannot delete Usuario in DB");
//            LOG.error("No se pudo eliminar en la BD");
            throw  new GeneralException("El USUARIO no pudo ser eliminado");
        }
    }

    @Override
    public Usuario findByiD(Integer idUsuario) {
        log.info("Searching for user id: {}", idUsuario);
//        LOG.info(String.format("Consultando el usuario con id: %s",idUsuario));
        Usuario user = null;
        try{
        user = jdbcTemplate.queryForObject(FINDBYID, new UsuarioRowMapper(), idUsuario);
        }catch (Exception e){
            log.info("User not found");
        }
        return user;
    }

    @Override
    public List<Usuario> findAll() {
        log.info("Searching all Usuarios");
//        LOG.info("Consultando todos los usuarios");
        return  jdbcTemplate.query(FIND_ALL, new UsuarioRowMapper());
    }
}
