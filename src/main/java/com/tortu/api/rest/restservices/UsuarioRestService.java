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
    private GenericValidator<Usuario> createUsuarioValidator;

    @Autowired
    @Qualifier("updateUsuarioValidator")
    private GenericValidator<Usuario> updateUsuarioValidator;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioResourceMapper usuarioResourceMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllUsuarios(){
        List<Usuario>usuarioList = usuarioService.findAllUsuarios();

        List<UsuarioResource> usuarioResourceList = new ArrayList<UsuarioResource>();
            for(Usuario usuario:usuarioList){
                UsuarioResource resource = usuarioResourceMapper.map(usuario);
                usuarioResourceList.add(resource);
        }

        return  Response.ok(usuarioResourceList).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findUsuarioById(@PathParam("id") Integer id) {
        if(id == null){
            throw new GeneralException("El ID es nulo");
        }
        Usuario usuario =  usuarioService.findUsuario(id);
        if(usuario==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        UsuarioResource resource = usuarioResourceMapper.map(usuario);
        return Response.ok(resource).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUsuario(Usuario usuario){
        createUsuarioValidator.validate(usuario);
        usuarioService.saveUsuario(usuario);
        return Response.ok().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUsuario(Usuario usuario){
        updateUsuarioValidator.validate(usuario);
        usuarioService.updateUsuario(usuario);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUsuario(@PathParam("id") Integer id){
        if(id==null){
            throw new GeneralException("El ID del usuario es nulo");
        }
        usuarioService.deleteUsuario(id);
        return Response.ok().build();
    }
}
