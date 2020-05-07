package com.tortu.api.rest.restservices;

import com.tortu.api.models.Receta;
import com.tortu.api.rest.mappers.RecetaResourceMapper;
import com.tortu.api.rest.resources.RecetaResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.impl.RecetaServiceImpl;
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
public class RecetaRestServiceTest {

    @InjectMocks
    RecetaRestService recetaRestService = new RecetaRestService();

    @Mock
    RecetaServiceImpl recetaService;

    @Mock
    RecetaResourceMapper recetaResourceMapper;

    @Mock
    GenericValidator validator;

    @Mock(name = "updateRecetaValidator")
    GenericValidator updateRecetaValidator;

    @Test
    public void findAllRecetas() {
        List<Receta> expectedList = new ArrayList<>();
        expectedList.add(new Receta());
        expectedList.add(new Receta());
        expectedList.add(new Receta());

        Mockito.when(recetaService.findAllRecetas()).thenReturn(expectedList);

        RecetaResource recetaResource = Mockito.mock(RecetaResource.class);

        Mockito.when(recetaResourceMapper.map(Mockito.any(Receta.class))).thenReturn(recetaResource);

        Response actualResponse = recetaRestService.findAllRecetas();

        Mockito.verify(recetaService,Mockito.times(1)).findAllRecetas();
        Mockito.verify(recetaResourceMapper,Mockito.times(3)).map(Mockito.any(Receta.class));

        assertEquals(200, actualResponse.getStatus());
        assertTrue(actualResponse.getEntity() instanceof List);
        List<RecetaResource> resourceList = (List<RecetaResource>) actualResponse.getEntity();
        assertEquals(3,resourceList.size());

    }

    @Test
    public void findAllRecetasEmptyList(){
        List<Receta> expectedList = new ArrayList<>();
        Mockito.when(recetaService.findAllRecetas()).thenReturn(expectedList);

        Response response = recetaRestService.findAllRecetas();

        Mockito.verify(recetaService,Mockito.times(1)).findAllRecetas();

        assertEquals(200, response.getStatus());
        List<RecetaResource> resourceList = (List<RecetaResource>) response.getEntity();
        assertTrue(resourceList.isEmpty());

    }

    @Test
    public void findRecetaById() {
        Integer idReceta = 1;
        Receta expectedReceta = new Receta();
        expectedReceta.setIdReceta(idReceta);

        Mockito.when(recetaService.findReceta(Mockito.anyInt())).thenReturn(expectedReceta);

        RecetaResource recetaResource = new RecetaResource();
        recetaResource.setIdReceta(idReceta);

        Mockito.when(recetaResourceMapper.map(expectedReceta)).thenReturn(recetaResource);

        Response response = recetaRestService.findRecetaById(idReceta);

        Mockito.verify(recetaService,Mockito.times(1)).findReceta(Mockito.anyInt());
        Mockito.verify(recetaResourceMapper,Mockito.times(1)).map(expectedReceta);

        assertEquals(200, response.getStatus());

        RecetaResource resource = (RecetaResource) response.getEntity();
        assertEquals(expectedReceta.getIdReceta(),resource.getIdReceta());

    }

    @Test(expected = GeneralException.class)
    public void findRecetaIdNull(){
        Response response = recetaRestService.findRecetaById(null);
    }

//    @Test
//    public void createReceta() {
//        Receta receta = new Receta();
//        Mockito.doNothing().when(validator).validate(receta);
//        Mockito.doNothing().when(recetaService).saveReceta(receta);
//
//        Response response = recetaRestService.createReceta(receta);
//
//        Mockito.verify(validator,Mockito.times(1)).validate(receta);
//        Mockito.verify(recetaService,Mockito.times(1)).saveReceta(receta);
//
//        assertEquals(200, response.getStatus());
//    }

    @Test(expected = GeneralException.class)
    public void createRecetaException(){
        Receta receta = new Receta();
        Mockito.doNothing().when(validator).validate(receta);
        Mockito.doThrow(GeneralException.class).when(recetaService).saveReceta(receta);

        Response response = recetaRestService.createReceta(receta);

        Mockito.verify(validator,Mockito.times(1)).validate(receta);
        Mockito.verify(recetaService,Mockito.times(1)).saveReceta(receta);
        assertEquals(200,response.getStatus());
    }

    @Test
    public void updateReceta() {
        Receta receta = new Receta();
        Mockito.doNothing().when(validator).validate(receta);
        Mockito.doNothing().when(recetaService).updateReceta(receta);
        Response response = recetaRestService.updateReceta(receta);
        Mockito.verify(updateRecetaValidator,Mockito.times(1)).validate(receta);
        Mockito.verify(recetaService,Mockito.times(1)).updateReceta(receta);
        assertEquals(200, response.getStatus());
    }

    @Test(expected = GeneralException.class)
    public void updateRecetaException(){
        Receta receta = new Receta();
        Mockito.doNothing().when(updateRecetaValidator).validate(receta);
        Mockito.doThrow(GeneralException.class).when(recetaService).updateReceta(receta);

        recetaRestService.updateReceta(receta);

        Mockito.verify(updateRecetaValidator,Mockito.times(1)).validate(receta);
        Mockito.verify(recetaService,Mockito.times(1)).updateReceta(receta);
    }

    @Test
    public void deleteReceta() {
        Integer idReceta = 1;
        Mockito.doNothing().when(recetaService).deleteReceta(idReceta);

        Response response = recetaRestService.deleteReceta(idReceta);

        Mockito.verify(recetaService,Mockito.times(1)).deleteReceta(idReceta);

        assertEquals(200,response.getStatus());
    }

    @Test(expected = GeneralException.class)
    public void deleteRecetaExceptionIdNull(){
        Integer idReceta = null;
        recetaRestService.deleteReceta(idReceta);
    }
    @Test(expected = GeneralException.class)
    public void deleteRecetaException(){
        Integer idReceta = 1;
        Mockito.doThrow(GeneralException.class).when(recetaService).deleteReceta(idReceta);
        recetaRestService.deleteReceta(idReceta);
    }
}