package com.tortu.api.services.impl;

import com.tortu.api.daos.LayoutPeriodoDao;
import com.tortu.api.models.LayoutPeriodo;
import com.tortu.api.services.LayoutPeriodoService;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion de los servicios para LayoutPeriodo
 */
@Service
public class LayoutPeriodoServiceImpl implements LayoutPeriodoService {
    private static final Logger LOG = LoggerFactory.getLogger(LayoutPeriodoServiceImpl.class);
    @Autowired
    private LayoutPeriodoDao layoutPeriodoDao;

    @Override
    public void saveLayoutPeriodo(LayoutPeriodo layoutPeriodo) throws GeneralException {
        LOG.info(String.format("Guardando el layoutPeriodo: %s",layoutPeriodo));
        layoutPeriodoDao.save(layoutPeriodo);
    }

    @Override
    public void updateLayoutPeriodo(LayoutPeriodo layoutPeriodo) throws GeneralException {
        LOG.info(String.format("Actualizando el LayoutPeriodo: %s", layoutPeriodo));
        layoutPeriodoDao.update(layoutPeriodo);
    }

    @Override
    public void deleteLayoutPeriodo(Integer id) throws GeneralException {
        LOG.info(String.format("Eliminando el LayoutPeriodo con id: %d",id));
        if(id==null){
            throw new GeneralException("El id del LayoutPeriodo es nulo");
        }
        layoutPeriodoDao.delete(id);
    }

    @Override
    public LayoutPeriodo findLayoutPeriodo(Integer id) throws GeneralException {
        LOG.info(String.format("Consultando el LayoutPeriodo con id: %d",id));
        if(id==null){
            throw new GeneralException("El id del LayoutPeriodo es nulo");
        }
        LayoutPeriodo layoutPeriodo = layoutPeriodoDao.findByiD(id);
        if(layoutPeriodo==null){
            throw new GeneralException("El LayoutPeriodo no fue encontrado");
        }
        return layoutPeriodo;
    }

    @Override
    public List<LayoutPeriodo> findAllLayoutPeriodo() {
        LOG.info("Consultando todos los LayoutPeriodo");
        List<LayoutPeriodo> layoutPeriodoList = layoutPeriodoDao.findAll();
        if(layoutPeriodoList==null){
            return new ArrayList<>();
        }
        return layoutPeriodoList;
    }
}
