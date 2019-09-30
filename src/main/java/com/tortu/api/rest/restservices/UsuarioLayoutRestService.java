package com.tortu.api.rest.restservices;

import com.tortu.api.models.UsuarioLayout;
import com.tortu.api.rest.mappers.UsuarioLayoutResourceMapper;
import com.tortu.api.rest.resources.UsuarioLayoutResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.UsuarioLayoutService;
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
 * Controlador del API UsuarioLayout
 */
@Service
@Path("/usuariolayout")
public class UsuarioLayoutRestService {
    @Autowired
    private UsuarioLayoutService usuarioLayoutService;
    @Autowired
    private UsuarioLayoutResourceMapper usuarioLayoutResourceMapper;
    @Autowired
    @Qualifier("createUsuarioLayoutValidator")
    private GenericValidator createUsuarioLayoutValidator;
    @Autowired
    @Qualifier("updateUsuarioLayoutValidator")
    private GenericValidator updateUsuarioLayoutValidator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllUsuarioLayout(){
        List<UsuarioLayout> usuarioLayoutList = usuarioLayoutService.findAllUsuarioLayout();
        List<UsuarioLayoutResource> resourceList = new ArrayList<>();
        for(UsuarioLayout usuarioLayout:usuarioLayoutList){
            UsuarioLayoutResource resource = usuarioLayoutResourceMapper.map(usuarioLayout);
            resourceList.add(resource);
        }
        return Response.ok(resourceList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUsuarioLayout(@PathParam("id") Integer idUsuarioLayout){
        if(idUsuarioLayout==null){
            throw new GeneralException("El idUsuarioLayout es nulo");
        }
        UsuarioLayout usuarioLayout = usuarioLayoutService.findUsuarioLayout(idUsuarioLayout);
        UsuarioLayoutResource resource = usuarioLayoutResourceMapper.map(usuarioLayout);
        return Response.ok(resource).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUsuarioLayout(UsuarioLayout usuarioLayout){
        createUsuarioLayoutValidator.validate(usuarioLayout);
        usuarioLayoutService.saveUsuarioLayout(usuarioLayout);
        return Response.ok().build();
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUsuarioLayout(UsuarioLayout usuarioLayout){
        updateUsuarioLayoutValidator.validate(usuarioLayout);
        usuarioLayoutService.updateUsuarioLayout(usuarioLayout);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUsuarioLayout(@PathParam("id")Integer idUsuarioLayout){
        if(idUsuarioLayout==null){
            throw new GeneralException("El Id del UsuarioLayou es nulo");
        }
        usuarioLayoutService.deleteUsuarioLayout(idUsuarioLayout);
        return Response.ok().build();
    }
}
