package com.tortu.api.rest.restservices;

import com.tortu.api.models.DietaUsuario;
import com.tortu.api.rest.mappers.DietaUsuarioResourceMapper;
import com.tortu.api.rest.resources.DietaUsuarioResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.DietaUsuarioService;
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
 * Controlador de Dieta_Usuario
 */
@Service
@Path("/dietas")
public class DietaUsuarioRestService {
    @Autowired
    private DietaUsuarioService dietaUsuarioService;
    @Autowired
    private DietaUsuarioResourceMapper resourceMapper;
    @Autowired
    @Qualifier("createDietaUsuarioValidator")
    private GenericValidator createDietaUsuarioValidator;
    @Autowired
    @Qualifier("updateDietaUsuarioValidator")
    private GenericValidator updateDietaUsuarioValidator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllDietaUsuario(){
        List<DietaUsuario> dietaUsuarioList = dietaUsuarioService.findAllDietaUsuario();
        List<DietaUsuarioResource> resourceList = new ArrayList<>();
        for(DietaUsuario dietaUsuario: dietaUsuarioList){
            DietaUsuarioResource dietaUsuarioResource = resourceMapper.map(dietaUsuario);
            resourceList.add(dietaUsuarioResource);
        }
        return Response.ok(resourceList).build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findDietaUsuarioById(@PathParam("id")Integer idDietaUsuario){
        if(idDietaUsuario==null){
            throw new GeneralException("El ID de la dieta_usuario es nulo");
        }
        DietaUsuario dietaUsuario = dietaUsuarioService.findDietaUsuario(idDietaUsuario);
        DietaUsuarioResource resource = resourceMapper.map(dietaUsuario);
        return Response.ok(resource).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDietaUsuario(DietaUsuario dietaUsuario){
        createDietaUsuarioValidator.validate(dietaUsuario);
        dietaUsuarioService.saveDietaUsuario(dietaUsuario);
        //DietaUsuarioResource resource = resourceMapper.map(dietaUsuario);
        return Response.ok().build();
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDietaUsuario(DietaUsuario dietaUsuario){
        updateDietaUsuarioValidator.validate(dietaUsuario);
        dietaUsuarioService.updateDietaUsuario(dietaUsuario);
       // DietaUsuarioResource resource = resourceMapper.map(dietaUsuario);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDietaUsuario(@PathParam("id")Integer idDietaUsuario){
        if(idDietaUsuario==null){
            throw new GeneralException("El ID de la dieta_usuario es nulo");
        }
        dietaUsuarioService.deleteDietaUsuario(idDietaUsuario);
        return Response.ok().build();
    }
}
