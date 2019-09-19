package com.tortu.api.services.impl;

import com.tortu.api.DietAppApplication;
import com.tortu.api.daos.UsuarioDao;
import com.tortu.api.models.Usuario;
import com.tortu.api.services.UsuarioService;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.management.AgentConfigurationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion del Servicio de Usuario. Esta clase deberia de llamar a los DAOs de usuario.
 * @author visilva
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    public static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Override
    public Usuario saveUsuario(Usuario usuario){
        LOG.info(String.format("Creando el usuario: %s",usuario));
        usuarioDao.save(usuario);
        return usuario;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) throws GeneralException {
        LOG.info(String.format("Actualizando el usuario: %s",usuario));
        if(usuario.getIdUsuario()==null){
            throw new GeneralException("Datos invalidos: ID del usuario es nulo");
        }
        usuarioDao.update(usuario);
        return usuario;
    }

    @Override
    public Usuario findUsuario(Integer idUsuario) throws GeneralException {
        LOG.info(String.format("Buscando el usuario con id: %s",idUsuario));
        if(idUsuario == null){
            throw new GeneralException("Datos invalidos: El ID del usuario es nulo");
        }
        return usuarioDao.findByiD(idUsuario);
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        LOG.info("Buscando todos los usuarios: %s");
        List<Usuario> usuarioList = usuarioDao.findAll();
        if(usuarioList == null){
            return new ArrayList<>();
        }
        return usuarioList;
    }

    @Override
    public void deleteUsuario(Integer idUsuario) throws GeneralException {
        LOG.info(String.format("Eliminando el usuario: %s",idUsuario));
        if(idUsuario==null){
            throw new GeneralException("Datos invalidos: El ID es nulo");
        }
        usuarioDao.delete(idUsuario);
    }
}
