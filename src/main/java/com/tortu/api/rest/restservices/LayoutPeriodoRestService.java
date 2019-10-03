package com.tortu.api.rest.restservices;

import com.tortu.api.models.LayoutPeriodo;
import com.tortu.api.rest.mappers.LayoutPeriodoResourceMapper;
import com.tortu.api.rest.resources.LayoutPeriodoResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.LayoutPeriodoService;
import com.tortu.api.services.impl.LayoutPeriodoServiceImpl;
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
 * API LayoutPeriodo
 */
@Service
@Path("/layoutperiodo")
public class LayoutPeriodoRestService {
    @Autowired
    private LayoutPeriodoService layoutPeriodoService;
    @Autowired
    private LayoutPeriodoResourceMapper resourceMapper;
    @Autowired
    @Qualifier("createLayoutPeriodoValidator")
    private GenericValidator<LayoutPeriodo> createLayoutPeriodoValidator;
    @Autowired
    @Qualifier("updateLayoutPeriodoValidator")
    private GenericValidator<LayoutPeriodo> updateLayoutPeriodoValidator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllLayoutPeriodo(){
        List<LayoutPeriodo> layoutPeriodoList = layoutPeriodoService.findAllLayoutPeriodo();
        List<LayoutPeriodoResource> resourceList = new ArrayList<>();
        for(LayoutPeriodo layoutPeriodo:layoutPeriodoList){
            LayoutPeriodoResource resource = resourceMapper.map(layoutPeriodo);
            resourceList.add(resource);
        }
        return Response.ok(resourceList).build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findLayoutPeriodo(@PathParam("id")Integer id){
        if(id==null){
            throw new GeneralException("El id es nulo");
        }
        LayoutPeriodo layoutPeriodo = layoutPeriodoService.findLayoutPeriodo(id);
        if(layoutPeriodo==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        LayoutPeriodoResource resource = resourceMapper.map(layoutPeriodo);
        return Response.ok(resource).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createLayoutPeriodo(LayoutPeriodo layoutPeriodo){
        createLayoutPeriodoValidator.validate(layoutPeriodo);
        layoutPeriodoService.saveLayoutPeriodo(layoutPeriodo);
        return Response.ok().build();
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLayoutPeriodo(LayoutPeriodo layoutPeriodo){
        updateLayoutPeriodoValidator.validate(layoutPeriodo);
        layoutPeriodoService.updateLayoutPeriodo(layoutPeriodo);
        return Response.ok().build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteLayoutPeriodo(@PathParam("id")Integer id){
        if(id==null){
            throw new GeneralException("El id es nulo");
        }
        layoutPeriodoService.deleteLayoutPeriodo(id);
        return Response.ok().build();
    }
}
