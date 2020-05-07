package com.tortu.api.rest.restservices;

import com.tortu.api.models.Receta;
import com.tortu.api.rest.mappers.RecetaResourceMapper;
import com.tortu.api.rest.resources.RecetaResource;
import com.tortu.api.rest.resources.RecipeCompleteResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.RecetaService;
import com.tortu.api.utils.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller de la entidad de Recetas
 */
@Service
@Path("/recetas")
public class RecetaRestService {

    @Autowired
    private RecetaService recetaService;

    @Autowired
    private RecetaResourceMapper recetaResourceMapper;

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

    @Path("/complete")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRecipeComplete(RecipeCompleteResource recipeComplete){
        recipeCompleteValidator.validate(recipeComplete);
        recetaService.saveRecipeComplete(recipeComplete);
        return Response.ok().build();
    }
}
