package com.tortu.api.services.impl;

import com.tortu.api.daos.ComboDietaUsuarioDao;
import com.tortu.api.models.ComboDietaUsuario;
import com.tortu.api.services.ComboDietaUsuarioService;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion de los servicios para ComboDietaUsuario
 */
@Service
public class ComboDietaUsuarioServiceImpl implements ComboDietaUsuarioService {
    private static final Logger LOG = LoggerFactory.getLogger(ComboDietaUsuarioServiceImpl.class);
    @Autowired
    private ComboDietaUsuarioDao comboDietaUsuarioDao;

    @Override
    public void saveComboDietaUsuario(ComboDietaUsuario comboDietaUsuario) throws GeneralException {
         LOG.info(String.format("Guardando ComboDietaUsuario: %s", comboDietaUsuario));
         comboDietaUsuarioDao.save(comboDietaUsuario);
    }

    @Override
    public void updateComboDietaUsuario(ComboDietaUsuario comboDietaUsuario) throws GeneralException {
        LOG.info(String.format("Actualizando ComboDietaUsuario: %s", comboDietaUsuario));
        if(comboDietaUsuario.getIdComboDietaUsuario()==null){
            LOG.error("ID de ComboDietaUsuario nulo");
            throw new GeneralException("No se pudo actualizar el ComboDietaUsuario. ID nulo");
        }
        comboDietaUsuarioDao.update(comboDietaUsuario);
    }

    @Override
    public void deleteComboDietaUsuario(Integer idComboDietaUsuario) throws GeneralException {
        LOG.info(String.format("Eliminando ComboDietaUsuario con id: %d", idComboDietaUsuario));
        if(idComboDietaUsuario==null){
            LOG.error("Id ComboDietaUsuario es nulo");
            throw new GeneralException("No se puede eliminar ComboDietaUsuarioc.  ID nulo");
        }
        comboDietaUsuarioDao.delete(idComboDietaUsuario);
    }

    @Override
    public ComboDietaUsuario findComboDietaUsuario(Integer idComboDietaUsario) throws GeneralException {
        LOG.info(String.format("Consultando ComboDietaUsuario id: %d", idComboDietaUsario));
        ComboDietaUsuario comboDietaUsuario = comboDietaUsuarioDao.findByiD(idComboDietaUsario);
        if(comboDietaUsuario==null){
            LOG.warn(String.format("Ningun ComboDietaUsuario con id: %d", idComboDietaUsario));
            throw new GeneralException("No se encontro ningun ComboDietaUsuario con ese id");
        }
        return comboDietaUsuario;
    }

    @Override
    public List<ComboDietaUsuario> findAllComboDietaUsuario() {
        LOG.info("Consultando todos los ComboDietaUsuarios");
        List<ComboDietaUsuario> comboDietaUsuarioList = comboDietaUsuarioDao.findAll();
        if(comboDietaUsuarioList==null){
            LOG.warn("Ningun ComboDietaUsuario encontrado");
            return new ArrayList<>();
        }
        return comboDietaUsuarioList;
    }
}
