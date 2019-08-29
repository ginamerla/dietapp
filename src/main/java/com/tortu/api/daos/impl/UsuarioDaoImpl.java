package com.tortu.api.daos.impl;

import com.tortu.api.DietAppApplication;
import com.tortu.api.daos.UsuarioDao;
import com.tortu.api.daos.mappers.UsuarioRowMapper;
import com.tortu.api.models.Usuario;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioDaoImpl implements UsuarioDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger LOG = LoggerFactory.getLogger(DietAppApplication.class);


    @Override
    public void save(Usuario model) throws GeneralException {
        LOG.info("Creando el usuario");
        jdbcTemplate.update(SAVE, new Object[]{
                model.getIdUsuario(),
                model.getNombre(),
                model.getEmail()
        });

    }

    @Override
    public void update(Usuario model) throws GeneralException {
        LOG.info("Actualizando el usuario");
        jdbcTemplate.update(UPDATE, new Object[]{
                model.getNombre(),
                model.getEmail(),
                model.getIdUsuario()
        });
    }

    @Override
    public void delete(Integer id) throws GeneralException {
        LOG.info("Eliminando el usuario");
        jdbcTemplate.update(DELETE, new Object[]{
                id});
    }

    @Override
    public Usuario findByiD(Usuario model) throws GeneralException {
        LOG.info("Consultando el Usuario por id_usuario");
        Usuario usuario = new Usuario();
        usuario = jdbcTemplate.queryForObject(FINDBYID, new UsuarioRowMapper(), new Object[]{model.getIdUsuario()});
        return usuario;
    }

    @Override
    public List<Usuario> findAll() throws GeneralException {
        LOG.info("Consultando todos los usuarios");
        List<Usuario> usuarioList = new ArrayList<Usuario>();
        usuarioList = jdbcTemplate.query(FIND_ALL, new UsuarioRowMapper());
        return usuarioList;
    }
}
