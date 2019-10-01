package com.tortu.api.rest.restservices;

import com.tortu.api.models.Ingrediente;
import com.tortu.api.rest.mappers.IngredienteResourceMapper;
import com.tortu.api.rest.resources.IngredienteResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.IngredienteService;
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
 * Controlador de la entidad Ingrediente
 */
@Service
@Path("/ingredientes")
public class IngredienteRestService {
    @Autowired
    private IngredienteService ingredienteService;
    @Autowired
    private IngredienteResourceMapper ingredienteResourceMapper;
    @Autowired
    @Qualifier("createIngredienteValidator")
    private GenericValidator createIngredienteValidator;
    @Autowired
    @Qualifier("updateIngredienteValidator")
    private GenericValidator updateIngredienteValidator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllRecetas(){
        List<Ingrediente> ingredienteList = ingredienteService.findAllIngredientes();
        List<IngredienteResource> resourceList = new ArrayList<>();
        for(Ingrediente ingrediente: ingredienteList){
            IngredienteResource ingredienteResource = ingredienteResourceMapper.map(ingrediente);
            resourceList.add(ingredienteResource);
        }
        return Response.ok(resourceList).build();
    }

    @GET
    @Path("/{idIngrediente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findIngredienteById(@PathParam("idIngrediente")Integer id){
        if(id==null){
            throw new GeneralException("El id es nulo");
        }
        Ingrediente ingrediente = ingredienteService.findIngrediente(id);
        if(ingrediente==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        IngredienteResource ingredienteResource = ingredienteResourceMapper.map(ingrediente);
        return Response.ok(ingredienteResource).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createIngrediente(Ingrediente ingrediente){
        createIngredienteValidator.validate(ingrediente);
        ingredienteService.saveIngrediente(ingrediente);
        //IngredienteResource ingredienteResource = ingredienteResourceMapper.map(savedIngrediente);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateIngrediente(Ingrediente ingrediente){
        updateIngredienteValidator.validate(ingrediente);
        ingredienteService.updateIngrediente(ingrediente);
        //IngredienteResource ingredienteResource = ingredienteResourceMapper.map(updatedIngrediente);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{idIngrediente}")
    public Response deleteIngrediente(@PathParam("idIngrediente")Integer id){
        if(id==null){
            throw new GeneralException("El id es nulo");
        }
        ingredienteService.deleteIngrediente(id);
        return Response.ok().build();
    }
}
