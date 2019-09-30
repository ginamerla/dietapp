package com.tortu.api.services.impl;

import com.tortu.api.daos.UsuarioLayoutDao;
import com.tortu.api.models.UsuarioLayout;
import com.tortu.api.services.UsuarioLayoutService;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa los servicios para UsuarioLayout
 */
@Service
public class UsuarioLayoutServiceImpl implements UsuarioLayoutService {
    public static final Logger LOG = LoggerFactory.getLogger(UsuarioLayoutServiceImpl.class);
    @Autowired
    private UsuarioLayoutDao usuarioLayoutDao;

    @Override
    public void saveUsuarioLayout(UsuarioLayout usuarioLayout) throws GeneralException {
        LOG.info(String.format("Guardando el UsuarioLayout: %s", usuarioLayout));
        usuarioLayoutDao.save(usuarioLayout);
    }

    @Override
    public void updateUsuarioLayout(UsuarioLayout usuarioLayout) throws GeneralException {
        LOG.info(String.format("Actualizando el UsuarioLayout: %s", usuarioLayout));
        if(usuarioLayout.getIdUsuarioLayout()==null){
            throw new GeneralException("Datos invalidos: el ID del UsuarioLayout es nulo");
        }
        usuarioLayoutDao.update(usuarioLayout);
    }

    @Override
    public UsuarioLayout findUsuarioLayout(Integer idUsuarioLayout) throws GeneralException {
        LOG.info(String.format("Consultando el UsuarioLayout con id: %d",idUsuarioLayout));
        if (idUsuarioLayout==null){
            throw new GeneralException("Datos invalidos: el ID del UsuarioLayout es nulo");
        }
        return usuarioLayoutDao.findByiD(idUsuarioLayout);
    }

    @Override
    public List<UsuarioLayout> findAllUsuarioLayout() {
        LOG.info("Consultando todos los UsuarioLayout");
        List<UsuarioLayout> usuarioLayoutList = usuarioLayoutDao.findAll();
        if(usuarioLayoutList==null){
            return new ArrayList<>();
        }
        return usuarioLayoutList;
    }

    @Override
    public void deleteUsuarioLayout(Integer idUsuarioLayout) throws GeneralException {
        LOG.info(String.format("Eliminando el UsuarioLayout con id: %d", idUsuarioLayout));
        if(idUsuarioLayout==null){
            throw new GeneralException("Datos invalidos: El ID del usuarioLayout es nulo");
        }
        usuarioLayoutDao.delete(idUsuarioLayout);
    }
}
