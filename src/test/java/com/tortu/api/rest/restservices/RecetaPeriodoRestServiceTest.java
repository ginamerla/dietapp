package com.tortu.api.rest.restservices;

import com.tortu.api.models.RecetaPeriodo;
import com.tortu.api.rest.mappers.RecetaPeriodoResourceMapper;
import com.tortu.api.rest.resources.RecetaPeriodoResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.RecetaPeriodoService;
import com.tortu.api.utils.GeneralException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class RecetaPeriodoRestServiceTest {
    @InjectMocks
    private RecetaPeriodoRestService restService = new RecetaPeriodoRestService();
    @Mock
    private RecetaPeriodoService service;
    @Mock
    private RecetaPeriodoResourceMapper mapper;
    @Mock(name = "createRecetaPeriodoValidator")
    private GenericValidator<RecetaPeriodo> createRecetaPeriodoValidator;
    @Mock(name = "updateRecetaPeriodoValidator")
    private GenericValidator<RecetaPeriodo> updateRecetaPeriodoValidator;

    @Test
    public void findAllRecetaPeriodo() {
        List<RecetaPeriodo> expectedList = new ArrayList<>();
        expectedList.add(new RecetaPeriodo());
        expectedList.add(new RecetaPeriodo());
        Mockito.when(service.findAllRecetaPeriodo()).thenReturn(expectedList);
        RecetaPeriodoResource resource = new RecetaPeriodoResource();
        Mockito.when(mapper.map(Mockito.any(RecetaPeriodo.class))).thenReturn(resource);
        Response response = restService.findAllRecetaPeriodo();
        Mockito.verify(service,Mockito.times(1)).findAllRecetaPeriodo();
        Mockito.verify(mapper,Mockito.times(2)).map(Mockito.any(RecetaPeriodo.class));
        assertEquals(200, response.getStatus());
        assertTrue(response.getEntity() instanceof List);
        List<RecetaPeriodoResource> resourceList = (List<RecetaPeriodoResource>) response.getEntity();
        assertEquals(2,resourceList.size());
    }
    @Test
    public void findAllRecetaPeriodoEmptylist() {
        List<RecetaPeriodo> expectedList = new ArrayList<>();
        Mockito.when(service.findAllRecetaPeriodo()).thenReturn(expectedList);
        Response response = restService.findAllRecetaPeriodo();
        Mockito.verify(service,Mockito.times(1)).findAllRecetaPeriodo();
        assertEquals(200, response.getStatus());
        assertTrue(response.getEntity() instanceof List);
        List<RecetaPeriodoResource> resourceList = (List<RecetaPeriodoResource>) response.getEntity();
        assertTrue(resourceList.isEmpty());
    }

    @Test
    public void findRecetaPeriodo() {
        Integer idRecetaPeriodo =44;
        RecetaPeriodo expected = new RecetaPeriodo();
        expected.setIdRecetaPeriodo(idRecetaPeriodo);
        Mockito.when(service.findRecetaPeriodo(idRecetaPeriodo)).thenReturn(expected);
        RecetaPeriodoResource resource = new RecetaPeriodoResource();
        resource.setIdRecetaPeriodo(idRecetaPeriodo);
        Mockito.when(mapper.map(expected)).thenReturn(resource);
        Response response = restService.findRecetaPeriodo(idRecetaPeriodo);
        Mockito.verify(service,Mockito.times(1)).findRecetaPeriodo(idRecetaPeriodo);
        Mockito.verify(mapper,Mockito.times(1)).map(expected);
        assertEquals(200, response.getStatus());
        RecetaPeriodoResource actualResource = (RecetaPeriodoResource) response.getEntity();
        assertEquals(expected.getIdRecetaPeriodo(), actualResource.getIdRecetaPeriodo());
    }
    @Test(expected = GeneralException.class)
    public void findRecetaPeriodoExceptionIdRecetaPeriodoNull() {
        Integer idRecetaPeriodo =null;
        restService.findRecetaPeriodo(idRecetaPeriodo);
    }
    @Test
    public void findRecetaPeriodoNotFound() {
        Integer idRecetaPeriodo =44;
        Mockito.when(service.findRecetaPeriodo(idRecetaPeriodo)).thenReturn(null);
        Response response = restService.findRecetaPeriodo(idRecetaPeriodo);
        Mockito.verify(service,Mockito.times(1)).findRecetaPeriodo(idRecetaPeriodo);
        assertEquals(404, response.getStatus());
    }

//    @Test
//    public void createRecetaPeriodo() {
//        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
//        Mockito.doNothing().when(createRecetaPeriodoValidator).validate(recetaPeriodo);
//        Mockito.doNothing().when(service).saveRecetaPeriodo(recetaPeriodo);
//        Response response = restService.createRecetaPeriodo(recetaPeriodo);
//        Mockito.verify(createRecetaPeriodoValidator,Mockito.times(1)).validate(recetaPeriodo);
//        Mockito.verify(service,Mockito.times(1)).saveRecetaPeriodo(recetaPeriodo);
//        assertEquals(200, response.getStatus());
//    }

    @Test
    public void updateRecetaPeriodo() {
        RecetaPeriodo recetaPeriodo = new RecetaPeriodo();
        Mockito.doNothing().when(updateRecetaPeriodoValidator).validate(recetaPeriodo);
        Mockito.doNothing().when(service).updateRecetaPeriodo(recetaPeriodo);
        Response response = restService.updateRecetaPeriodo(recetaPeriodo);
        Mockito.verify(updateRecetaPeriodoValidator,Mockito.times(1)).validate(recetaPeriodo);
        Mockito.verify(service,Mockito.times(1)).updateRecetaPeriodo(recetaPeriodo);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void deleteRecetaPeriodo() {
        Integer id=74;
        Mockito.doNothing().when(service).deleteRecetaPeriodo(id);
        Response response = restService.deleteRecetaPeriodo(id);
        Mockito.verify(service,Mockito.times(1)).deleteRecetaPeriodo(id);
        assertEquals(200, response.getStatus());
    }
    @Test(expected = GeneralException.class)
    public void deleteRecetaPeriodoIdNull() {
        Integer id=null;
        Response response = restService.deleteRecetaPeriodo(id);
    }
}