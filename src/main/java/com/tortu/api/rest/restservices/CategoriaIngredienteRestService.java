package com.tortu.api.rest.restservices;

import com.tortu.api.models.CategoriaIngrediente;
import com.tortu.api.rest.mappers.CategoriaIngredienteResourceMapper;
import com.tortu.api.rest.resources.CategoriaIngredienteResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.CategoriaIngredienteService;
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
 * Controlador del modelo categoria_ingrediente
 */
@Service
@Path("/categorias")
public class CategoriaIngredienteRestService {
    @Autowired
    private CategoriaIngredienteService categoriaIngredienteService;
    @Autowired
    private CategoriaIngredienteResourceMapper categoriaIngredienteResourceMapper;
    @Autowired
    @Qualifier("createCategoriaIngredienteValidator")
    private GenericValidator createCategoriaIngredienteValidator;
    @Autowired
    @Qualifier("updateCategoriaIngredienteValidator")
    private GenericValidator updateCategoriaIngredienteValidator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllCategoriaIngrediente(){
        List<CategoriaIngrediente> categoriaIngredienteList = categoriaIngredienteService.findAllCategoriaIngrediente();
        List<CategoriaIngredienteResource> resourceList = new ArrayList<>();
        for(CategoriaIngrediente categoriaIngrediente:categoriaIngredienteList){
            CategoriaIngredienteResource resource = categoriaIngredienteResourceMapper.map(categoriaIngrediente);
            resourceList.add(resource);
        }
        return Response.ok(resourceList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCategoriaIngredienteById(@PathParam("id")Integer id){
        if(id==null){
            throw new GeneralException("El ID de la categoria_ingrediente es nulo");
        }
        CategoriaIngrediente categoriaIngrediente = categoriaIngredienteService.findCategoriaIngrediente(id);
        if(categoriaIngrediente==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        CategoriaIngredienteResource resource = categoriaIngredienteResourceMapper.map(categoriaIngrediente);
        return Response.ok(resource).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCategoriaIngrediente(CategoriaIngrediente categoriaIngrediente){
        createCategoriaIngredienteValidator.validate(categoriaIngrediente);
        categoriaIngredienteService.saveCategoriaIngrediente(categoriaIngrediente);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCategoriaIngrediente(CategoriaIngrediente categoriaIngrediente){
        updateCategoriaIngredienteValidator.validate(categoriaIngrediente);
        categoriaIngredienteService.updateCategoriaIngrediente(categoriaIngrediente);
        //CategoriaIngredienteResource resource = categoriaIngredienteResourceMapper.map(categoriaIngrediente);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCategoriaIngrediente(@PathParam("id")Integer id){
        if(id==null){
            throw new GeneralException("El ID de la categoria es nulo");
        }
        categoriaIngredienteService.deleteCategoriaIngrediente(id);
        return Response.ok().build();
    }
}
