package com.tortu.api.rest.restservices;

import com.tortu.api.models.Usuario;
import com.tortu.api.rest.mappers.UsuarioResourceMapper;
import com.tortu.api.rest.resources.UsuarioResource;
import com.tortu.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Controller de la entidad de usuarios.
 * @author visilva
 */
@Service
@Path("/usuarios")
public class UsuarioRestService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioResourceMapper converter;

    @GET
    @Path("/{usuarioId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response obtenerInfoUsuarioPorId(@PathParam("usuarioId") Integer usuarioId) {
        Usuario usuario =  usuarioService.obtenerUsuarioPorId(usuarioId);
        UsuarioResource resource = converter.mapper(usuario);
        return Response.ok(resource).build();
    }
}
