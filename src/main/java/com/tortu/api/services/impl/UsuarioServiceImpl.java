package com.tortu.api.services.impl;

import com.tortu.api.daos.UsuarioDao;
import com.tortu.api.models.Usuario;
import com.tortu.api.services.UsuarioService;
import com.tortu.api.utils.GeneralException;
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

    @Override
    public Usuario obtenerUsuarioPorId(Integer idUsuario) {
        throw new UnsupportedOperationException("Esta operacion no esta permitida!");
    }

    @Override
    public Usuario saveUsuario(Usuario usuario){
        usuarioDao.save(usuario);
        return usuario;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) throws GeneralException {
        if(usuario.getIdUsuario()==null){
            throw new GeneralException("Datos invalidos: ID del usuario es nulo");
        }
        usuarioDao.update(usuario);
        return usuario;
    }

    @Override
    public Usuario findUsuario(Usuario usuario) throws GeneralException {
        if(usuario == null){
            throw new GeneralException("Datos invalidos - El usuario es nulo");
        }
        if(usuario.getIdUsuario() == null){
            throw new GeneralException("Datos invalidos: El ID del usuario es nulo");
        }
        return usuarioDao.findByiD(usuario.getIdUsuario());
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        List<Usuario> usuarioList = usuarioDao.findAll();
        if(usuarioList == null){
            return new ArrayList<>();
        }
        return usuarioList;
    }

    @Override
    public void deleteUsuario(Integer idUsuario) throws GeneralException {
        if(idUsuario==null){
            throw new GeneralException("Datos invalidos: El ID es nulo");
        }
        usuarioDao.delete(idUsuario);
    }
}
