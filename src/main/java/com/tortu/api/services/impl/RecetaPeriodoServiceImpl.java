package com.tortu.api.services.impl;

import com.tortu.api.daos.RecetaPeriodoDao;
import com.tortu.api.models.RecetaPeriodo;
import com.tortu.api.services.RecetaPeriodoService;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion de los servicios para Receta_Periodo
 */
@Service
public class RecetaPeriodoServiceImpl implements RecetaPeriodoService {
    @Autowired
    private RecetaPeriodoDao recetaPeriodoDao;
    private static final Logger LOG = LoggerFactory.getLogger(RecetaPeriodoServiceImpl.class);

    @Override
    public void saveRecetaPeriodo(RecetaPeriodo recetaPeriodo) throws GeneralException {
        LOG.info(String.format("Guardando RecetaPeriodo: %s", recetaPeriodo));
        recetaPeriodoDao.save(recetaPeriodo);
    }

    @Override
    public void updateRecetaPeriodo(RecetaPeriodo recetaPeriodo) throws GeneralException {
        LOG.info(String.format("Actualizando RecetaPeriodo: %s",recetaPeriodo));
        if(recetaPeriodo.getIdRecetaPeriodo()==null){
            LOG.error("ID recetaPeriodo nulo");
            throw new GeneralException("El Id de RecetaPeriodo es nulo");
        }
        recetaPeriodoDao.update(recetaPeriodo);
    }

    @Override
    public void deleteRecetaPeriodo(Integer idRecetaPeriodo) throws GeneralException {
        LOG.info(String.format("Eliminando RecetaPeriodo con id: %d",idRecetaPeriodo));
        if(idRecetaPeriodo==null){
            LOG.error("Id RecetaPeriodo es nulo");
            throw new GeneralException("El ID de RecetaPeriodo es nulo");
        }
        recetaPeriodoDao.delete(idRecetaPeriodo);
    }

    @Override
    public RecetaPeriodo findRecetaPeriodo(Integer idRecetaPeriodo) throws GeneralException {
        LOG.info(String.format("Consultando RecetaPeriodo con id: %d",idRecetaPeriodo));
        if(idRecetaPeriodo==null){
            LOG.error("Id RecetaPeriodo es nulo");
            throw new GeneralException("El ID de recetaPeriodo es nulo");
        }
        RecetaPeriodo recetaPeriodo = recetaPeriodoDao.findByiD(idRecetaPeriodo);
        if(recetaPeriodo==null){
            LOG.warn(String.format("No se encontro RecetaPeriodo con id: %d",idRecetaPeriodo));
            throw new GeneralException("RecetaPeriodo no encontrada");
        }
        return recetaPeriodo;
    }

    @Override
    public List<RecetaPeriodo> findAllRecetaPeriodo() {
        LOG.info("Consultando todas las RecetaPeriodos");
        List<RecetaPeriodo> recetaPeriodoList = recetaPeriodoDao.findAll();
        if(recetaPeriodoList==null){
            LOG.warn("No se encontraron RecetaPeriodos");
            return new ArrayList<>();
        }
        return recetaPeriodoList;
    }

    @Override
    public List<Integer> getRecetaPeriodoIdList(Integer periodId, List<Integer> recipeIdList) throws GeneralException {
        LOG.info("Consultando lista de ids de RECETA_PERIODO por periodo y recetas");
        List<Integer> idList = recetaPeriodoDao.findRecetaPeriodoIdListByPeriodoReceta(periodId, recipeIdList);
        if(idList == null){
            LOG.warn("no se encontraron RECETA_PERIODO ids con esas recetas y periodo enviados");
            return new ArrayList<>();
        }
        return idList;
    }
}
