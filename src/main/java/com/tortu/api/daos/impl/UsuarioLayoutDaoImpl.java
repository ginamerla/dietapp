package com.tortu.api.daos.impl;

import com.tortu.api.daos.UsuarioLayoutDao;
import com.tortu.api.daos.mappers.UsuarioLayoutRowMapper;
import com.tortu.api.models.UsuarioLayout;
import com.tortu.api.utils.GeneralException;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementacion de los DAOs, clase que se conecta con la BD
 */
@Log4j2
@Component
public class UsuarioLayoutDaoImpl implements UsuarioLayoutDao {

//    public static final Logger LOG = LoggerFactory.getLogger(UsuarioLayoutDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(UsuarioLayout model) throws GeneralException {
        log.info("Inserting usuarioLayout: {}", model);
//        LOG.info(String.format("Guardando usuarioLayout: %s", model));
        int updatedRows = jdbcTemplate.update(SAVE, model.getIdUsuario(), model.getIdLayout(), model.getFecha());
        if(updatedRows==0){
            log.error("Cannot insert UsuarioLayout in DB");
//            LOG.error("No se pudo insertar en la BD");
            throw  new GeneralException("El USUARIO_LAYOUT no pudo ser guardado");
        }
        return updatedRows;
    }

    @Override
    public void update(UsuarioLayout model) throws GeneralException {
        log.info("Updating UsuarioLayout: {}", model);
//        LOG.info(String.format("Actualizando UsuarioLayout: %s",model));
        int updatedRows = jdbcTemplate.update(UPDATE,model.getIdUsuario(),model.getIdLayout(),model.getFecha(),model.getIdUsuarioLayout());
        if(updatedRows==0){
            log.error("Cannot update UsuarioLayout in DB");
//            LOG.error("No se pudo actualizar en la BD");
            throw  new GeneralException("El USUARIO_LAYOUT no pudo ser actualizado");
        }
    }

    @Override
    public void delete(Integer id) throws GeneralException {
        log.info("Deleting UsuarioLayout id:{}", id);
//        LOG.info(String.format("Eliminando UsuarioLayout con id: %d", id));
        int updatedRows = jdbcTemplate.update(DELETE, id);
        if(updatedRows==0){
            log.error("Cannot delete UsuarioLayout in DB");
//            LOG.error("No se pudo eliminar en la BD");
            throw  new GeneralException("El USUARIO_LAYOUT no pudo ser eliminado");
        }
    }

    @Override
    public UsuarioLayout findByiD(Integer id) throws GeneralException {
        log.info("Searching UsuarioLayout id: {}", id);
//        LOG.info(String.format("Consultando UsuarioLayout con id: %d", id));
        UsuarioLayout usuarioLayout = null;
        try{
            usuarioLayout = jdbcTemplate.queryForObject(FINDBYID, new UsuarioLayoutRowMapper(), id);
        }catch (Exception e){
            log.error("UsuarioLayout not found");
        }
         return usuarioLayout;
    }

    @Override
    public List<UsuarioLayout> findAll() throws GeneralException {
        log.info("Searching all UsuarioLayouts");
//        LOG.info("Consultando todos los usuarioLayout");
        List<UsuarioLayout> usuarioLayoutList = jdbcTemplate.query(FIND_ALL, new UsuarioLayoutRowMapper());
        return usuarioLayoutList;
    }
}
