package com.tortu.api.rest.restservices;

import com.tortu.api.models.RecetaPeriodo;
import com.tortu.api.rest.mappers.RecetaPeriodoResourceMapper;
import com.tortu.api.rest.resources.RecetaPeriodoResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.RecetaPeriodoService;
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
 * API RecetaPeriodo
 */
@Service
@Path("/recetaperiodo")
public class RecetaPeriodoRestService {
    @Autowired
    private RecetaPeriodoService recetaPeriodoService;
    @Autowired
    private RecetaPeriodoResourceMapper resourceMapper;
    @Autowired
    @Qualifier("createRecetaPeriodoValidator")
    private GenericValidator<RecetaPeriodo> createRecetaPeriodoValidator;
    @Autowired
    @Qualifier("updateRecetaPeriodoValidator")
    private GenericValidator<RecetaPeriodo> updateRecetaPeriodoValidator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllRecetaPeriodo(){
        List<RecetaPeriodo> recetaPeriodoList = recetaPeriodoService.findAllRecetaPeriodo();
        List<RecetaPeriodoResource> resourceList = new ArrayList<>();
        for(RecetaPeriodo recetaPeriodo: recetaPeriodoList){
            RecetaPeriodoResource resource = resourceMapper.map(recetaPeriodo);
            resourceList.add(resource);
        }
        return Response.ok(resourceList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findRecetaPeriodo(@PathParam("id")Integer idRecetaPeriodo){
        if(idRecetaPeriodo==null){
            throw new GeneralException("El ID de RecetaPeriodo es nulo");
        }
        RecetaPeriodo recetaPeriodo = recetaPeriodoService.findRecetaPeriodo(idRecetaPeriodo);
        if(recetaPeriodo==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        RecetaPeriodoResource resource = resourceMapper.map(recetaPeriodo);
        return Response.ok(resource).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRecetaPeriodo(RecetaPeriodo recetaPeriodo){
        createRecetaPeriodoValidator.validate(recetaPeriodo);
        recetaPeriodoService.saveRecetaPeriodo(recetaPeriodo);
        return Response.ok().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateRecetaPeriodo(RecetaPeriodo recetaPeriodo){
        updateRecetaPeriodoValidator.validate(recetaPeriodo);
        recetaPeriodoService.updateRecetaPeriodo(recetaPeriodo);
        return Response.ok().build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteRecetaPeriodo(@PathParam("id")Integer idRecetaPeriodo){
        if(idRecetaPeriodo==null){
            throw new GeneralException("El ID de RecetaPeriodo es nulo");
        }
        recetaPeriodoService.deleteRecetaPeriodo(idRecetaPeriodo);
        return Response.ok().build();
    }
}
