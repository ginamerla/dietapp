package com.tortu.api.rest.restservices;

import com.tortu.api.models.RecetaIngrediente;
import com.tortu.api.rest.mappers.RecetaIngredienteResourceMapper;
import com.tortu.api.rest.resources.RecetaIngredienteResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.RecetaIngredienteService;
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
public class RecetaIngredienteRestServiceTest {

    @InjectMocks
    private RecetaIngredienteRestService restService;
    @Mock
    private RecetaIngredienteService service;
    @Mock
    private RecetaIngredienteResourceMapper mapper;
    @Mock
    private GenericValidator<RecetaIngrediente> createValidator;
    @Mock
    private GenericValidator<RecetaIngrediente> updateValidator;

    @Test
    public void findAllRecetaIngrediente() {
        List<RecetaIngrediente> recetaIngredienteList = new ArrayList<>();
        recetaIngredienteList.add(new RecetaIngrediente());
        recetaIngredienteList.add(new RecetaIngrediente());
        recetaIngredienteList.add(new RecetaIngrediente());
        Mockito.when(service.findAllRecetaIngrediente()).thenReturn(recetaIngredienteList);
        RecetaIngredienteResource resource = new RecetaIngredienteResource();
        Mockito.when(mapper.map(Mockito.any(RecetaIngrediente.class))).thenReturn(resource);
        Response response = restService.findAllRecetaIngrediente();
        Mockito.verify(service,Mockito.times(1)).findAllRecetaIngrediente();
        Mockito.verify(mapper,Mockito.times(3)).map(Mockito.any(RecetaIngrediente.class));
        assertEquals(200,response.getStatus());
        assertTrue(response.getEntity() instanceof List);
        List<RecetaIngredienteResource> resourceList = (List<RecetaIngredienteResource>) response.getEntity();
        assertEquals(3, resourceList.size());
    }
    @Test
    public void findAllRecetaIngredienteEmptyList() {
        List<RecetaIngrediente> recetaIngredienteList = new ArrayList<>();
        Mockito.when(service.findAllRecetaIngrediente()).thenReturn(recetaIngredienteList);
        RecetaIngredienteResource resource = new RecetaIngredienteResource();
        Response response = restService.findAllRecetaIngrediente();
        Mockito.verify(service,Mockito.times(1)).findAllRecetaIngrediente();
        assertEquals(200,response.getStatus());
        assertTrue(response.getEntity() instanceof List);
        List<RecetaIngredienteResource> resourceList = (List<RecetaIngredienteResource>) response.getEntity();
        assertTrue(resourceList.isEmpty());
    }

    @Test
    public void findRecetaIngredente() {
        Integer id=34;
        RecetaIngrediente recetaIngrediente=new RecetaIngrediente();
        recetaIngrediente.setIdRecetaIngrediente(id);
        Mockito.when(service.findRecetaIngrediente(id)).thenReturn(recetaIngrediente);
        RecetaIngredienteResource resource = new RecetaIngredienteResource();
        resource.setIdRecetaIngrediente(id);
        Mockito.when(mapper.map(recetaIngrediente)).thenReturn(resource);
        Response response = restService.findRecetaIngredente(id);
        Mockito.verify(service,Mockito.times(1)).findRecetaIngrediente(id);
        Mockito.verify(mapper,Mockito.times(1)).map(recetaIngrediente);
        assertEquals(200, response.getStatus());
        RecetaIngredienteResource actual = (RecetaIngredienteResource) response.getEntity();
        assertEquals(recetaIngrediente.getIdRecetaIngrediente(), actual.getIdRecetaIngrediente());
    }
    @Test(expected = GeneralException.class)
    public void findRecetaIngredenteExceptionIdNull() {
        Integer id=null;
        Response response = restService.findRecetaIngredente(id);
    }
    @Test
    public void findRecetaIngredenteExceptionNotFound() {
        Integer id=34;
        RecetaIngrediente recetaIngrediente=new RecetaIngrediente();
        recetaIngrediente.setIdRecetaIngrediente(id);
        Mockito.when(service.findRecetaIngrediente(id)).thenReturn(null);
        Response response = restService.findRecetaIngredente(id);
        Mockito.verify(service,Mockito.times(1)).findRecetaIngrediente(id);
        assertEquals(404, response.getStatus());
    }

    @Test
    public void createRecetaIngrediente() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        Mockito.doNothing().when(createValidator).validate(recetaIngrediente);
        Mockito.doNothing().when(service).saveRecetaIngrediente(recetaIngrediente);
        Response response = restService.createRecetaIngrediente(recetaIngrediente);
        Mockito.verify(createValidator,Mockito.times(1)).validate(recetaIngrediente);
        Mockito.verify(service,Mockito.times(1)).saveRecetaIngrediente(recetaIngrediente);
        assertEquals(200, response.getStatus());
    }
    @Test(expected = GeneralException.class)
    public void createRecetaIngredienteException() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        Mockito.doNothing().when(createValidator).validate(recetaIngrediente);
        Mockito.doThrow(GeneralException.class).when(service).saveRecetaIngrediente(recetaIngrediente);
        Response response = restService.createRecetaIngrediente(recetaIngrediente);
        Mockito.verify(createValidator,Mockito.times(1)).validate(recetaIngrediente);
        Mockito.verify(service,Mockito.times(1)).saveRecetaIngrediente(recetaIngrediente);
    }

    @Test
    public void updateRecetaIngrediente() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        Mockito.doNothing().when(updateValidator).validate(recetaIngrediente);
        Mockito.doNothing().when(service).updateRecetaIngrediente(recetaIngrediente);
        Response response = restService.updateRecetaIngrediente(recetaIngrediente);
        Mockito.verify(updateValidator,Mockito.times(1)).validate(recetaIngrediente);
        Mockito.verify(service,Mockito.times(1)).updateRecetaIngrediente(recetaIngrediente);
        assertEquals(200, response.getStatus());
    }
    @Test(expected = GeneralException.class)
    public void updateRecetaIngredienteException() {
        RecetaIngrediente recetaIngrediente = new RecetaIngrediente();
        Mockito.doNothing().when(updateValidator).validate(recetaIngrediente);
        Mockito.doThrow(GeneralException.class).when(service).updateRecetaIngrediente(recetaIngrediente);
        Response response = restService.updateRecetaIngrediente(recetaIngrediente);
        Mockito.verify(updateValidator,Mockito.times(1)).validate(recetaIngrediente);
        Mockito.verify(service,Mockito.times(1)).updateRecetaIngrediente(recetaIngrediente);
    }

    @Test
    public void deleteRecetaIngrediente() {
        Integer id=65;
        Mockito.doNothing().when(service).deleteRecetaIngrediente(id);
        Response response = restService.deleteRecetaIngrediente(id);
        Mockito.verify(service,Mockito.times(1)).deleteRecetaIngrediente(id);
        assertEquals(200, response.getStatus());
    }
    @Test(expected = GeneralException.class)
    public void deleteRecetaIngredienteException() {
        Integer id=null;
        Response response = restService.deleteRecetaIngrediente(id);
    }
}