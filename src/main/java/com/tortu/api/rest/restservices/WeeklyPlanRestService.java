package com.tortu.api.rest.restservices;

import com.tortu.api.rest.resources.WeeklyPlanResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.WeeklyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createWeeklyPlan (WeeklyPlanResource weeklyPlanResource){
        createWeeklyPlanValidator.validate(weeklyPlanResource);
        weeklyPlanService.saveWeeklyPlan(weeklyPlanResource);
        return Response.ok().build();
    }
}
