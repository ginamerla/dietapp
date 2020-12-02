package com.tortu.api.rest.restservices;

import com.tortu.api.models.ComboDietaUsuario;
import com.tortu.api.rest.mappers.ComboDietaUsuarioResourceMapper;
import com.tortu.api.rest.resources.ComboDietaUsuarioResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.ComboDietaUsuarioService;
import com.tortu.api.services.impl.ComboDietaUsuarioServiceImpl;
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
 * API ComboDietaUsuario
 */
@Service
@Path("/api/v1/combodietausuario")
public class ComboDietaUsuarioRestService {
    @Autowired
    private ComboDietaUsuarioServiceImpl comboService;
    @Autowired
    private ComboDietaUsuarioResourceMapper comboMapper;
    @Autowired
    @Qualifier("createComboDietaUsuarioValidator")
    private GenericValidator<ComboDietaUsuario> createComboValidator;
    @Autowired
    @Qualifier("updateComboDietaUsuarioValidator")
    private GenericValidator<ComboDietaUsuario> updateComboValidator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllComboDietaUsuario(){
        List<ComboDietaUsuario> comboList = comboService.findAllComboDietaUsuario();
        List<ComboDietaUsuarioResource> resources = new ArrayList<>();
        for(ComboDietaUsuario combo : comboList){
            ComboDietaUsuarioResource resource = comboMapper.map(combo);
            resources.add(resource);
        }
        return Response.ok(resources).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findComboDietaUsuario(@PathParam("id")Integer idCombo){
        if(idCombo==null){
            throw new GeneralException("El id de ComboDietaUsuario es nulo");
        }
        ComboDietaUsuario comboDietaUsuario = comboService.findComboDietaUsuario(idCombo);
        if(comboDietaUsuario==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        ComboDietaUsuarioResource resource = comboMapper.map(comboDietaUsuario);
        return Response.ok(resource).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createComboDietaUsuario(ComboDietaUsuario comboDietaUsuario){
        createComboValidator.validate(comboDietaUsuario);
        comboService.saveComboDietaUsuario(comboDietaUsuario);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateComboDietaUsuario(ComboDietaUsuario comboDietaUsuario){
        updateComboValidator.validate(comboDietaUsuario);
        comboService.updateComboDietaUsuario(comboDietaUsuario);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteComboDietaUsuario(@PathParam("id")Integer idCombo){
        if(idCombo==null){
            throw new GeneralException("El id del ComboDietaUsuario es nulo");
        }
        comboService.deleteComboDietaUsuario(idCombo);
        return Response.ok().build();
    }
}
