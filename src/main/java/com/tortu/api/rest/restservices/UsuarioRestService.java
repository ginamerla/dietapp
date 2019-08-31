package com.tortu.api.rest.restservices;

import com.tortu.api.models.Usuario;
import com.tortu.api.rest.mappers.UsuarioResourceMapper;
import com.tortu.api.rest.resources.UsuarioResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.UsuarioService;
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
 * Controller de la entidad de usuarios.
 * @author visilva
 */
@Service
@Path("/usuarios")
public class UsuarioRestService {

    @Autowired
    @Qualifier("createUsuarioValidator")
    private GenericValidator createUsuarioValidator;

    @Autowired
    @Qualifier("findUsuarioByIdValidator")
    private GenericValidator findUsuarioByIdValidator;

    @Autowired
    @Qualifier("updateUsuarioValidator")
    private GenericValidator updateUsuarioValidator;


    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioResourceMapper converter;

    @Autowired
    private UsuarioResourceMapper usuarioResourceMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllUsuarios(){
        List<Usuario>usuarioList = usuarioService.findAllUsuarios();
        List<UsuarioResource> usuarioResourceList = new ArrayList<UsuarioResource>();
        for(Usuario usuario:usuarioList){
            UsuarioResource resource = usuarioResourceMapper.mapper(usuario);
            usuarioResourceList.add(resource);
        }
        return  Response.ok(usuarioResourceList).build();
    }

    @GET
    @Path("/{usuario}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findUsuarioById(@PathParam("usuario") Usuario usuario) {
        findUsuarioByIdValidator.validate(usuario);
        Usuario usuarioResponse =  usuarioService.findUsuario(usuario);
        UsuarioResource resource = converter.mapper(usuario);
        return Response.ok(resource).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUsuario(Usuario usuario){
        createUsuarioValidator.validate(usuario);
        Usuario usuarioResponse = usuarioService.saveUsuario(usuario);
        UsuarioResource resource = usuarioResourceMapper.mapper(usuarioResponse);
        return Response.ok(resource).build();
    }

    @PUT
    @Path("/usuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUsuario( @PathParam("usuario") Usuario usuario ){
        updateUsuarioValidator.validate(usuario);
        Usuario usuarioResponse = usuarioService.updateUsuario(usuario);
        UsuarioResource resource = usuarioResourceMapper.mapper(usuarioResponse);
        return Response.ok(resource).build();
    }

    @DELETE
    @Path("/usuarioId")
    public Response deleteUsuario(@PathParam("usuarioId") Integer id){
        if(id==null){
            throw new GeneralException("El ID del usuario es nulo");
        }
        usuarioService.deleteUsuario(id);
        return Response.ok().build();
    }
}
