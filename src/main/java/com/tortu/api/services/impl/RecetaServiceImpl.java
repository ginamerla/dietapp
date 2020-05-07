package com.tortu.api.services.impl;

import com.tortu.api.DietAppApplication;
import com.tortu.api.daos.RecetaDao;
import com.tortu.api.models.Receta;
import com.tortu.api.models.RecetaIngrediente;
import com.tortu.api.models.RecetaPeriodo;
import com.tortu.api.rest.resources.RecetaIngredienteResource;
import com.tortu.api.rest.resources.RecipeCompleteResource;
import com.tortu.api.rest.resources.RecipeIngredientResource;
import com.tortu.api.services.RecetaIngredienteService;
import com.tortu.api.services.RecetaPeriodoService;
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

    @Autowired
    private RecetaPeriodoService recetaPeriodoService;
    @Autowired
    private RecetaIngredienteService recetaIngredienteService;

    @Override
    public int saveReceta(Receta receta) throws GeneralException {
        LOG.info(String.format("Guardando la receta: %s", receta));
        return  recetaDao.save(receta);
    }

    @Override
    public void updateReceta(Receta receta) throws GeneralException {
        LOG.info(String.format("Actualizando la receta: %s",receta));
        if(receta.getIdReceta()==null){
            LOG.error("IdReceta es nulo");
            throw new GeneralException("El id de la receta es nulo");
        }
        recetaDao.update(receta);
    }

    @Override
    public Receta findReceta(Integer idReceta) throws GeneralException {
        LOG.info(String.format("Consultando la receta con id: %s", idReceta));
        if(idReceta==null){
            LOG.error("idReceta es nulo");
            throw new GeneralException("El id de la receta es nulo");
        }
        return recetaDao.findByiD(idReceta);
    }

    @Override
    public List<Receta> findAllRecetas() {
        LOG.info("Consultando todas las recetas");
        List<Receta> recetaList = recetaDao.findAll();
        if(recetaList==null){
            LOG.warn("No se encontraron Recetas");
            return new ArrayList<>();
        }
        return recetaList;
    }

    @Override
    public void deleteReceta(Integer idReceta) throws GeneralException {
        LOG.info(String.format("Eliminando la receta con id: %s",idReceta));
        if(idReceta==null){
            LOG.error("idReceta nulo");
            throw new GeneralException("El id de la receta es nulo");
        }
        recetaDao.delete(idReceta);
    }

    @Override
    public void saveRecipeComplete(RecipeCompleteResource recipe) throws GeneralException {
        LOG.info(String.format("Creando receta completa: %s", recipe.getRecipeName()));
        Receta newRecipe=new Receta();
        newRecipe.setNombre(recipe.getRecipeName());
        int newRecipeId = saveReceta(newRecipe);

        RecetaPeriodo rp = new RecetaPeriodo();
        rp.setIdReceta(newRecipeId);
        rp.setIdPeriodo(recipe.getPeriodId());

        for(RecipeIngredientResource ing:recipe.getIngredientResourceList()){
            RecetaIngrediente ri = new RecetaIngrediente();
            ri.setCantidad(ing.getQuantity());
            ri.setIdMedida(ing.getUnitId());
            ri.setIdIngrediente(ing.getItemId());
            ri.setIdReceta(newRecipeId);
            recetaIngredienteService.saveRecetaIngrediente(ri);
        }
        LOG.info(String.format("Receta creada: %s", recipe.getRecipeName()));
    }
}
