package com.tortu.api.services.impl;

import com.tortu.api.daos.CategoriaIngredienteDao;
import com.tortu.api.models.CategoriaIngrediente;
import com.tortu.api.services.CategoriaIngredienteService;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion de los servicios para categoria_ingrediente
 * Clase que hace el llamado al DAO
 */
@Service
public class CategoriaIngredienteServiceImpl implements CategoriaIngredienteService {
    @Autowired
    private CategoriaIngredienteDao categoriaIngredienteDao;
    public static final Logger LOG = LoggerFactory.getLogger(CategoriaIngredienteServiceImpl.class);

    @Override
    public  void saveCategoriaIngrediente(CategoriaIngrediente categoriaIngrediente) throws GeneralException {
        LOG.info(String.format("Creando categoria_ingrediente: %s", categoriaIngrediente));
        categoriaIngredienteDao.save(categoriaIngrediente);
    }

    @Override
    public  void updateCategoriaIngrediente(CategoriaIngrediente categoriaIngrediente) throws GeneralException {
        LOG.info("Actualizando categoria_ingrediente: %s",categoriaIngrediente);
        if(categoriaIngrediente.getIdCategoriaIngrediente()==null){
            throw new GeneralException("El ID de la categoria_ingrediente es nulo");
        }
        categoriaIngredienteDao.update(categoriaIngrediente);
    }

    @Override
    public CategoriaIngrediente findCategoriaIngrediente(Integer id) throws GeneralException {
        LOG.info(String.format("Buscando la categoria_ingrediente con id: %d", id));
        if(id == null){
            throw new GeneralException("El ID de la categoria_ingrediente es nulo");
        }
        return categoriaIngredienteDao.findByiD(id);
    }

    @Override
    public List<CategoriaIngrediente> findAllCategoriaIngrediente() {
        LOG.info("Buscando todas las categorias_ingrediente");
        List<CategoriaIngrediente> categoriaIngredienteList = categoriaIngredienteDao.findAll();
        if(categoriaIngredienteList==null){
            return new ArrayList<>();
        }
        return categoriaIngredienteList;
    }

    @Override
    public void deleteCategoriaIngrediente(Integer id) throws GeneralException {
        LOG.info(String.format("Eliminando la categoria_ingrediente con id: %d", id));
        if(id==null){
            throw new GeneralException("El ID de categoria_ingrediente es nulo");
        }
        categoriaIngredienteDao.delete(id);
    }
}
