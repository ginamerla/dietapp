package com.tortu.api.rest.restservices;

import com.tortu.api.models.RecetaIngrediente;
import com.tortu.api.rest.mappers.RecetaIngredienteResourceMapper;
import com.tortu.api.rest.resources.RecetaIngredienteResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.RecetaIngredienteService;
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
 * API RecetaIngrediente
 */
@Service
@Path("/recetaingredientes")
public class RecetaIngredienteRestService {
    @Autowired
    private RecetaIngredienteService recetaIngredienteService;
    @Autowired
    private RecetaIngredienteResourceMapper resourceMapper;
    @Autowired
    @Qualifier("createRecetaIngredienteValidator")
    private GenericValidator<RecetaIngrediente> createValidator;
    @Autowired
    @Qualifier("updateRecetaIngredienteValidator")
    private GenericValidator<RecetaIngrediente> updateValidator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllRecetaIngrediente(){
        List<RecetaIngrediente> recetaIngredienteList = recetaIngredienteService.findAllRecetaIngrediente();
        List<RecetaIngredienteResource> resourceList = new ArrayList<>();
        for(RecetaIngrediente recetaIngrediente:recetaIngredienteList){
            RecetaIngredienteResource resource = resourceMapper.map(recetaIngrediente);
            resourceList.add(resource);
        }
        return Response.ok(resourceList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findRecetaIngredente(@PathParam("id")Integer idRecetaIngrediente){
        if(idRecetaIngrediente==null){
            throw new GeneralException("El ID_RECETA_INGREDIENTE es nulo ");
        }
        RecetaIngrediente recetaIngrediente = recetaIngredienteService.findRecetaIngrediente(idRecetaIngrediente);
        if(recetaIngrediente==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        RecetaIngredienteResource resource = resourceMapper.map(recetaIngrediente);
        return Response.ok(resource).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRecetaIngrediente(RecetaIngrediente recetaIngrediente){
        createValidator.validate(recetaIngrediente);
        recetaIngredienteService.saveRecetaIngrediente(recetaIngrediente);
        return Response.ok().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateRecetaIngrediente(RecetaIngrediente recetaIngrediente){
        updateValidator.validate(recetaIngrediente);
        recetaIngredienteService.updateRecetaIngrediente(recetaIngrediente);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRecetaIngrediente(@PathParam("id")Integer idRecetaIngrediente){
        if(idRecetaIngrediente==null){
            throw new GeneralException("El ID de RecetaIngrediente es nulo");
        }
        recetaIngredienteService.deleteRecetaIngrediente(idRecetaIngrediente);
        return Response.ok().build();
    }
}
