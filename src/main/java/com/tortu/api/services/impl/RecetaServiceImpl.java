package com.tortu.api.services.impl;

import com.tortu.api.DietAppApplication;
import com.tortu.api.daos.RecetaDao;
import com.tortu.api.models.Receta;
import com.tortu.api.services.RecetaService;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion del servicio de Receta
 */
@Service
public class RecetaServiceImpl implements RecetaService {

    public static final Logger LOG = LoggerFactory.getLogger(RecetaServiceImpl.class);

    @Autowired
    private RecetaDao recetaDao;

    @Override
    public void saveReceta(Receta receta) throws GeneralException {
        LOG.info(String.format("Guardando la receta: %s", receta));
        recetaDao.save(receta);
    }

    @Override
    public void updateReceta(Receta receta) throws GeneralException {
        LOG.info("Actualizando la receta: %s",receta);
        if(receta.getIdReceta()==null){
            throw new GeneralException("El id de la receta es nulo");
        }
        recetaDao.update(receta);
    }

    @Override
    public Receta findReceta(Integer idReceta) throws GeneralException {
        LOG.info("Consultando la receta con id: %s", idReceta);
        if(idReceta==null){
            throw new GeneralException("El id de la receta es nulo");
        }
        return recetaDao.findByiD(idReceta);
    }

    @Override
    public List<Receta> findAllRecetas() {
        LOG.info("Consultando todas las recetas");
        List<Receta> recetaList = recetaDao.findAll();
        if(recetaList==null){
            return new ArrayList<>();
        }
        return recetaList;
    }

    @Override
    public void deleteReceta(Integer idReceta) throws GeneralException {
        LOG.info(String.format("Eliminando la receta con id: %s",idReceta));
        if(idReceta==null){
            throw new GeneralException("El id de la receta es nulo");
        }
        recetaDao.delete(idReceta);
    }
}
