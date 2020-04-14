package com.tortu.api.services.impl;

import com.tortu.api.daos.DietaUsuarioDao;
import com.tortu.api.models.DietaUsuario;
import com.tortu.api.services.DietaUsuarioService;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion de los servcios para Dieta_Usuario
 */
@Service
public class DietaUsuarioServiceImpl implements DietaUsuarioService {
    private static final Logger LOG = LoggerFactory.getLogger(DietaUsuarioServiceImpl.class);
    @Autowired
    private DietaUsuarioDao dietaUsuarioDao;

    @Override
    public void saveDietaUsuario(DietaUsuario dietaUsuario) throws GeneralException {
        LOG.info(String.format("Creando la dieta_usuario: %s", dietaUsuario));
        dietaUsuarioDao.save(dietaUsuario);
    }

    @Override
    public void updateDietaUsuario(DietaUsuario dietaUsuario) throws GeneralException {
        LOG.info(String.format("Actualizando la dieta_usuario: %s", dietaUsuario));
        if(dietaUsuario.getIdDietaUsuario()==null){
            throw new GeneralException("El ID de la dieta_usuario es nulo");
        }
        dietaUsuarioDao.update(dietaUsuario);
    }

    @Override
    public DietaUsuario findDietaUsuario(Integer idDietaUsuario) throws GeneralException {
        LOG.info(String.format("Consultando la dieta_usuario con id: %d", idDietaUsuario));
        if(idDietaUsuario == null){
            throw new GeneralException("El id de la dieta_usuario es nulo");
        }
        return dietaUsuarioDao.findByiD(idDietaUsuario);
    }

    @Override
    public List<DietaUsuario> findAllDietaUsuario() {
        LOG.info("Consultando todas las dietas_usuario");
        List<DietaUsuario> dietaUsuarioList = dietaUsuarioDao.findAll();
        if(dietaUsuarioList==null){
            return new ArrayList<>();
        }
        return dietaUsuarioList;
    }

    @Override
    public void deleteDietaUsuario(Integer idDietaUsuario) throws GeneralException {
        LOG.info(String.format("Eliminando la dieta_usuario con id: %d", idDietaUsuario));
        if(idDietaUsuario==null){
            throw new GeneralException("El id de la dieta_usuario es nulo");
        }
        dietaUsuarioDao.delete(idDietaUsuario);
    }

    @Override
    public List<Integer> getDietaUsuarioIdListByUser(Integer userId) throws GeneralException {
        LOG.info(String.format("Consultando ids de dieta_usuario con el id de usuario: %d", userId));
        List<Integer> idList = dietaUsuarioDao.findIdDietaUsuarioListByUser(userId);
        if(idList==null){
            return new ArrayList<>();
        }
        return idList;
    }

}
