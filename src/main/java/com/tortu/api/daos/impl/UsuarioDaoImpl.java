package com.tortu.api.daos.impl;

import com.tortu.api.DietAppApplication;
import com.tortu.api.daos.UsuarioDao;
import com.tortu.api.daos.mappers.UsuarioRowMapper;
import com.tortu.api.models.Usuario;
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
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioDaoImpl.class);


    @Override
    public void save(Usuario model)  {
        LOG.info(String.format("Creando el usuario: %s",model));
        jdbcTemplate.update(SAVE, model.getIdUsuario(), model.getNombre(), model.getEmail());

    }

    @Override
    public void update(Usuario model) {
        LOG.info(String.format("Actualizando el usuario: %s",model));
        jdbcTemplate.update(UPDATE, model.getNombre(), model.getEmail(), model.getIdUsuario());
    }

    @Override
    public void delete(Integer id) {
        LOG.info(String.format("Eliminando el usuario: %d",id));
        jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Usuario findByiD(Integer idUsuario) {
        LOG.info(String.format("Consultando el usuario con id: %s",idUsuario));
        Usuario usuario = jdbcTemplate.queryForObject(FINDBYID, new UsuarioRowMapper(), idUsuario);
        return usuario;
    }

    @Override
    public List<Usuario> findAll() {
        LOG.info("Consultando todos los usuarios");
        List<Usuario> usuarioList = new ArrayList<Usuario>();
        usuarioList = jdbcTemplate.query(FIND_ALL, new UsuarioRowMapper());
        return usuarioList;
    }
}
