package com.tortu.api.services.impl;

import com.tortu.api.daos.IngredienteDao;
import com.tortu.api.models.Ingrediente;
import com.tortu.api.services.IngredienteService;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion de los servicios de ingrediente
 */
@Service
public class IngredienteServiceImpl implements IngredienteService {

    public static final Logger LOG = LoggerFactory.getLogger(IngredienteServiceImpl.class);
    @Autowired
    private IngredienteDao ingredienteDao;

    @Override
    public void saveIngrediente(Ingrediente ingrediente) throws GeneralException {
        LOG.info(String.format("Guardando el ingrediente: %s",ingrediente));
        ingredienteDao.save(ingrediente);
    }

    @Override
    public void updateIngrediente(Ingrediente ingrediente) throws GeneralException {
        LOG.info(String.format("Actualizando el ingrediente: %s", ingrediente));
        if(ingrediente.getIdIngrediente()==null){
            throw new GeneralException("El ID del ingrediente es nulo");
        }
        ingredienteDao.update(ingrediente);
    }

    @Override
    public Ingrediente findIngrediente(Integer id) throws GeneralException {
        LOG.info(String.format("Consultando el ingrediente con id: %d", id));
        if(id==null){
            throw new GeneralException("El id del ingrediente es nulo");
        }

        return ingredienteDao.findByiD(id);
    }

    @Override
    public List<Ingrediente> findAllIngredientes() {
        LOG.info("Consultando todos los ingredientes");
        List<Ingrediente> ingredienteList = ingredienteDao.findAll();
        if(ingredienteList==null){
            return new ArrayList<>();
        }
        return ingredienteList;
    }

    @Override
    public void deleteIngrediente(Integer id) throws GeneralException {
        LOG.info(String.format("Eliminando el ingrediente con id: %d",id));
        if(id==null){
            throw new GeneralException("El id del ingrediente es nulo");
        }
        ingredienteDao.delete(id);
    }
}
