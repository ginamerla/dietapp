package com.tortu.api.rest.restservices;

import com.tortu.api.rest.resources.WPWeekDayResultResource;
import com.tortu.api.rest.resources.WeeklyPlanResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.WeeklyPlanService;
import com.tortu.api.utils.GeneralException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class WeeklyPlanRestServiceTest {

    @InjectMocks
    private WeeklyPlanRestService wpRestService = new WeeklyPlanRestService();

    @Mock
    private GenericValidator<WeeklyPlanResource> createWeeklyPlanValidator;

    @Mock
    private WeeklyPlanService weeklyPlanService;

    @Test
    public void createWeeklyPlan(){
        WeeklyPlanResource resource = new WeeklyPlanResource();
        Mockito.doNothing().when(createWeeklyPlanValidator).validate(resource);
        Mockito.doNothing().when(weeklyPlanService).saveWeeklyPlan(resource);

        wpRestService.createWeeklyPlan(resource);

        Mockito.verify(createWeeklyPlanValidator,Mockito.times(1)).validate(resource);
        Mockito.verify(weeklyPlanService, Mockito.times(1)).saveWeeklyPlan(resource);
    }

    @Test
    public void getWeeklyPlan(){
        Integer userId = 2;
        List<WPWeekDayResultResource> expectedList = new ArrayList<>();
        expectedList.add(new WPWeekDayResultResource());
        expectedList.add(new WPWeekDayResultResource());
        Mockito.when(weeklyPlanService.getWeeklyPlan(userId)).thenReturn(expectedList);

        Response response = wpRestService.getWeeklyPlan(userId);

        Mockito.verify(weeklyPlanService,Mockito.times(1)).getWeeklyPlan(userId);
        assertEquals(200, response.getStatus());
        assertTrue(response.getEntity() instanceof List);
        List<WPWeekDayResultResource> actualList = (List<WPWeekDayResultResource>)response.getEntity();
        assertEquals(expectedList.size(), actualList.size());
    }

    @Test (expected = GeneralException.class)
    public void getWeeklyPlanIdNull(){
        wpRestService.getWeeklyPlan(null);
    }
    @Test
    public void getWeeklyPlanListNull(){
        Integer userId = 2;
        List<WPWeekDayResultResource> expectedList = new ArrayList<>();
        Mockito.when(weeklyPlanService.getWeeklyPlan(userId)).thenReturn(expectedList);

        Response response = wpRestService.getWeeklyPlan(userId);

        Mockito.verify(weeklyPlanService,Mockito.times(1)).getWeeklyPlan(userId);

        assertEquals(200, response.getStatus());
        assertTrue(response.getEntity() instanceof List);
        List<WPWeekDayResultResource> actualList = (List<WPWeekDayResultResource>)response.getEntity();
        assertTrue(actualList.isEmpty());
    }

//    @Test
//    public void printWeeklyPLan() throws IOException {
//        Integer userId=1;
//        String path = "path";
//        Mockito.when(weeklyPlanService.printPdf(userId)).thenReturn(path);
//
//    }
}