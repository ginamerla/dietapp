package com.tortu.api.rest.restservices;

import com.tortu.api.rest.resources.WPWeekDayResultResource;
import com.tortu.api.rest.resources.WeeklyPlanResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.WeeklyPlanService;
import com.tortu.api.utils.GeneralException;
import org.apache.cxf.helpers.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * API WeeklyPlan
 */
@Service
@Path("/weeklyplan")
public class WeeklyPlanRestService {
    @Autowired
    @Qualifier("createWeeklyPlanValidatorImpl")
    private GenericValidator<WeeklyPlanResource> createWeeklyPlanValidator;
    @Autowired
    private WeeklyPlanService weeklyPlanService;

    private static final Logger LOG = LoggerFactory.getLogger(WeeklyPlanRestService.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createWeeklyPlan (WeeklyPlanResource weeklyPlanResource){
        createWeeklyPlanValidator.validate(weeklyPlanResource);
        weeklyPlanService.saveWeeklyPlan(weeklyPlanResource);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWeeklyPlan (@PathParam("id") Integer userId){
        if(userId==null){
            throw new GeneralException("El id del usuario es nulo");
        }
        List<WPWeekDayResultResource> result = weeklyPlanService.getWeeklyPlan(userId);
        return Response.ok(result).build();
    }

    @GET
    @Path("/pdf/{id}")
    @Produces("application/pdf")
    public Response printWeeklyPlan(@PathParam("id") Integer userId) throws IOException {
        if(userId==null){
            throw new GeneralException("El id del usuario es nulo");
        }
        LOG.info("Iniciando creacion de PDF");
        InputStream fileIs = weeklyPlanService.printPdf(userId);
        if(fileIs==null){
            throw new GeneralException("No se pudo crear el PDF");
        }
        LOG.info("PDF creado");
//        File file = new File(fileIs);
        Response.ResponseBuilder response = Response.ok((Object) fileIs);
        response.header("Content-Disposition","attachment; filename=\"Dieta.pdf\"");
        return response.build();
    }
}
