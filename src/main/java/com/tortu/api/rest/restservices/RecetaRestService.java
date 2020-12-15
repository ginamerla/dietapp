package com.tortu.api.rest.restservices;

import com.tortu.api.dto.PopularRecipe;
import com.tortu.api.dto.RecipeIngredientLookupDTO;
import com.tortu.api.models.Receta;
import com.tortu.api.rest.mappers.PopularRecipeResourceMapper;
import com.tortu.api.rest.mappers.RecetaResourceMapper;
import com.tortu.api.rest.mappers.RecipeIngredientLookupResourceMapper;
import com.tortu.api.rest.resources.*;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.RecetaService;
import com.tortu.api.utils.GeneralException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller de la entidad de Recetas
 */
@Service
@Path("/api/v1/recetas")
public class RecetaRestService {

    @Autowired
    private RecetaService recetaService;

    @Autowired
    private RecetaResourceMapper recetaResourceMapper;

    @Autowired
    private RecipeIngredientLookupResourceMapper recipeIngredientLookupResourceMapper;

    @Autowired
    private PopularRecipeResourceMapper popularRecipeResourceMapper;

    @Autowired
    @Qualifier("createRecetaValidator")
    private GenericValidator<Receta> createRecetaValidator;

    @Autowired
    @Qualifier("updateRecetaValidator")
    private GenericValidator<Receta> updateRecetaValidator;

    @Autowired
    @Qualifier("createRecipeCompleteValidator")
    private GenericValidator<RecipeCompleteResource> recipeCompleteValidator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllRecetas(){
        List<Receta> recetaList = recetaService.findAllRecetas();
        List<RecetaResource> resourceList = new ArrayList<>();
        for(Receta receta:recetaList){
            RecetaResource resource = recetaResourceMapper.map(receta);
            resourceList.add(resource);
        }
        return Response.ok(resourceList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findRecetaById(@PathParam("id") Integer id){
        if(id == null){
            throw new GeneralException("El ID de la receta es nulo");
        }
        Receta receta = recetaService.findReceta(id);
        if(receta==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        RecetaResource resource = recetaResourceMapper.map(receta);
        return Response.ok(resource).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createReceta(Receta receta){
        createRecetaValidator.validate(receta);
        recetaService.saveReceta(receta);
        return Response.ok().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateReceta(Receta receta){
        updateRecetaValidator.validate(receta);
        recetaService.updateReceta(receta);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteReceta(@PathParam("id")Integer idReceta){
        if (idReceta==null){
            throw new GeneralException("El ID de la receta es nulo");
        }
        recetaService.deleteReceta(idReceta);
        return Response.ok().build();
    }

    /**
     * Se crea la receta con la informacion completa
     * @param recipeComplete informacion de la receta cantidad, medida, ingrediente
     * @return (se crea la receta completa
     */
    @Path("/complete")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRecipeComplete(RecipeCompleteResource recipeComplete){
        recipeCompleteValidator.validate(recipeComplete);
        recetaService.saveRecipeComplete(recipeComplete);
        return Response.ok().build();
    }

//    @GET
//    @Path("/find/{ing}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response findRecipeByIngredient(@PathParam("ing")String ingrediente){
//        if(StringUtils.isBlank(ingrediente)){
//            throw new GeneralException("No se envio ingrediente a buscar");
//        }
//        List<RecipeIngredientLookupDTO> dtoList = recetaService.recipeIngredientLookup(ingrediente);
//        List<RecipeIngredientLookupResource> resourceList = new ArrayList<>();
//        if(CollectionUtils.isEmpty(dtoList)){
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//        for(RecipeIngredientLookupDTO dto:dtoList){
//            RecipeIngredientLookupResource resource = recipeIngredientLookupResourceMapper.map(dto);
//            resourceList.add(resource);
//        }
//        return Response.ok(resourceList).build();
//    }

//    @GET
//    @Path("find/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response findRecipeByName(@PathParam("nombre") String nombre){
//        if(StringUtils.isBlank(nombre)){
//            throw new GeneralException("No se envio un nombre para buscar");
//        }
//        List<Receta> recipesFound = recetaService.recipeNameLookup(nombre);
//        List<RecetaResource> resources = new ArrayList<>();
//        for(Receta r: recipesFound){
//            RecetaResource recetaResource = recetaResourceMapper.map(r);
//            resources.add(recetaResource);
//        }
//        return Response.ok(resources).build();
//    }

    @Path("/busqueda")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(RecetaBusquedaResource busqueda){
        if(busqueda==null){
            throw new GeneralException("El objeto busqueda esa vacio");
        }
        String tipo=busqueda.getTipoBusqueda();
        String valor=busqueda.getValor();
        if(StringUtils.isBlank(tipo) || (StringUtils.isBlank(valor))) {
            throw new GeneralException("El tipo o valor de busqueda es nulo o vacio");
        }
        if(tipo.equals("receta")){
            List<Receta> recipesFound = recetaService.recipeNameLookup(valor);
            List<RecetaResource> resources = new ArrayList<>();
            for(Receta r: recipesFound){
                RecetaResource recetaResource = recetaResourceMapper.map(r);
                resources.add(recetaResource);
            }
            return Response.ok(resources).build();
        }
        if(tipo.equals("ingrediente")){
            List<RecipeIngredientLookupDTO> dtoList = recetaService.recipeIngredientLookup(valor);
            List<RecipeIngredientLookupResource> resourceList = new ArrayList<>();
            if(CollectionUtils.isEmpty(dtoList)){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            for(RecipeIngredientLookupDTO dto:dtoList){
                RecipeIngredientLookupResource resource = recipeIngredientLookupResourceMapper.map(dto);
                resourceList.add(resource);
            }
            return Response.ok(resourceList).build();
        }
        return Response.ok().build();
    }

    @GET
    @Path("/top5")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPopularRecipes(){
        List<PopularRecipe> recipes = recetaService.getPopularRecipes();
        List<PopularRecipeResource> resources = new ArrayList<>();
        for(PopularRecipe recipe:recipes){
            PopularRecipeResource resource = popularRecipeResourceMapper.map(recipe);
            resources.add(resource);
        }
        return Response.ok(resources).build();
    }
}
