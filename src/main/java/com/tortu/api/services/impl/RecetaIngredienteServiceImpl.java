package com.tortu.api.services.impl;

import com.tortu.api.daos.RecetaIngredienteDao;
import com.tortu.api.models.RecetaIngrediente;
import com.tortu.api.services.RecetaIngredienteService;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion de los servicios para RecetaIngrediente
 */
@Service
public class RecetaIngredienteServiceImpl implements RecetaIngredienteService {
    private static final Logger LOG = LoggerFactory.getLogger(RecetaIngredienteServiceImpl.class);
    @Autowired
    private RecetaIngredienteDao recetaIngredienteDao;

    @Override
    public void saveRecetaIngrediente(RecetaIngrediente recetaIngrediente) throws GeneralException {
        LOG.info(String.format("Guardando RecetaIngrediente: %s", recetaIngrediente));
        recetaIngredienteDao.save(recetaIngrediente);
    }

    @Override
    public void updateRecetaIngrediente(RecetaIngrediente recetaIngrediente) throws GeneralException {
        LOG.info(String.format("Actualizando RecetaIngrediente: %s", recetaIngrediente));
        if(recetaIngrediente.getIdRecetaIngrediente()==null){
            LOG.error("El id_receta_ingrediente es nulo");
            throw new GeneralException("El id de RecetaIngrediente es nulo");
        }
        recetaIngredienteDao.update(recetaIngrediente);
    }

    @Override
    public void deleteRecetaIngrediente(Integer idRecetaIngredente) throws GeneralException {
        LOG.info(String.format("Eliminando RecetaIngrediente con id: %d", idRecetaIngredente));
        if(idRecetaIngredente==null){
            LOG.error("id_receta_ingrediente es nulo");
            throw new GeneralException("El id de RecetaIngrediente es nulo");
        }
        recetaIngredienteDao.delete(idRecetaIngredente);
    }

    @Override
    public RecetaIngrediente findRecetaIngrediente(Integer idRecetaIngrediente) throws GeneralException {
        LOG.info(String.format("Consultando RecetaIngrediente con id: %d", idRecetaIngrediente));
        RecetaIngrediente recetaIngrediente = recetaIngredienteDao.findByiD(idRecetaIngrediente);
        if(recetaIngrediente==null){
            LOG.warn(String.format("No se encontro RecetaIngrediente con id: %d", idRecetaIngrediente));
            throw new GeneralException("RecetaIngrediente no encontrada");
        }
        return recetaIngrediente;
    }

    @Override
    public List<RecetaIngrediente> findAllRecetaIngrediente() {
        LOG.info("Consultando todas las RecetaIngrediente");
        List<RecetaIngrediente> recetaIngredienteList = recetaIngredienteDao.findAll();
        if(recetaIngredienteList==null){
            LOG.warn("No se encontraron RecetaIngrediente");
            return new ArrayList<>();
        }
        return recetaIngredienteList;
    }
}
