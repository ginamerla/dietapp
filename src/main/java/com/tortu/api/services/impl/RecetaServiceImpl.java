package com.tortu.api.services.impl;

import com.tortu.api.daos.CommonDao;
import com.tortu.api.daos.RecetaDao;
import com.tortu.api.dto.PopularRecipe;
import com.tortu.api.dto.RecipeIngredientLookupDTO;
import com.tortu.api.models.Receta;
import com.tortu.api.models.RecetaIngrediente;
import com.tortu.api.models.RecetaPeriodo;
import com.tortu.api.rest.resources.RecipeCompleteResource;
import com.tortu.api.rest.resources.RecipeIngredientResource;
import com.tortu.api.services.RecetaIngredienteService;
import com.tortu.api.services.RecetaPeriodoService;
import com.tortu.api.services.RecetaService;
import com.tortu.api.utils.GeneralException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion del servicio de Receta
 */
@Log4j2
@Service
public class RecetaServiceImpl implements RecetaService {

    @Autowired
    private RecetaDao recetaDao;
    @Autowired
    private CommonDao commonDao;
    @Autowired
    private RecetaPeriodoService recetaPeriodoService;
    @Autowired
    private RecetaIngredienteService recetaIngredienteService;

    @Override
    public int saveReceta(Receta receta) throws GeneralException {
        log.info("Guardando la receta: {}", receta);
        return  recetaDao.save(receta);
    }

    @Override
    public void updateReceta(Receta receta) throws GeneralException {
        log.info("Actualizando la receta: {}",receta);
        if(receta.getIdReceta()==null){
            log.error("IdReceta es nulo");
            throw new GeneralException("El id de la receta es nulo");
        }
        recetaDao.update(receta);
    }

    @Override
    public Receta findReceta(Integer idReceta) throws GeneralException {
        log.info("Consultando la receta con id: {}", idReceta);
        if(idReceta==null){
            log.error("idReceta es nulo");
            throw new GeneralException("El id de la receta es nulo");
        }
        return recetaDao.findByiD(idReceta);
    }

    @Override
    public List<Receta> findAllRecetas() {
        log.info("Consultando todas las recetas");
        List<Receta> recetaList = recetaDao.findAll();
        if(recetaList==null){
            log.warn("No se encontraron Recetas");
            return new ArrayList<>();
        }
        return recetaList;
    }

    @Override
    public void deleteReceta(Integer idReceta) throws GeneralException {
        log.info("Eliminando la receta con id: {}",idReceta);
        if(idReceta==null){
            log.error("idReceta nulo");
            throw new GeneralException("El id de la receta es nulo");
        }
        recetaDao.delete(idReceta);
    }

    @Override
    public void saveRecipeComplete(RecipeCompleteResource recipe) throws GeneralException {
        log.info("Creando receta completa: {}", recipe.getRecipeName());
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
        log.info("Receta creada: {}", recipe.getRecipeName());
    }

    @Override
    public List<RecipeIngredientLookupDTO> recipeIngredientLookup(String ingredient) throws GeneralException {
        log.info("Buscando recetas con ingrediente: {}", ingredient);
        if(StringUtils.isBlank(ingredient)){
            log.error("Ingrediente nulo");
            throw new GeneralException("El ingrediente a buscar es nulo");
        }
        return commonDao.getRecipeListByIngredient(ingredient);
    }

    @Override
    public List<Receta> recipeNameLookup(String name) throws GeneralException {
        log.info("Buscando receta con nombre: {}", name);
        if(StringUtils.isBlank(name)){
            log.error("Nombre nulo");
            throw new GeneralException("El nombre de la receta es nulo");
        }
        List<Receta> recetas = recetaDao.findRecipeByName(name);
        if(recetas==null){
            log.warn("No se encontraron recetas");
            return new ArrayList<>();
        }
        return recetas;
    }

    @Override
    public List<PopularRecipe> getPopularRecipes() throws GeneralException {
        log.info("Buscando recetas mas populares...");
        List<PopularRecipe> recipes = commonDao.getTop5Recipes();
        if(recipes==null){
            log.info("No se encontraron recetas");
            return new ArrayList<>();
        }
        return recipes;
    }
}
