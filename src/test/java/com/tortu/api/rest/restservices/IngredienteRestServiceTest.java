package com.tortu.api.rest.restservices;

import com.tortu.api.models.Ingrediente;
import com.tortu.api.rest.mappers.IngredienteResourceMapper;
import com.tortu.api.rest.resources.IngredienteResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.IngredienteService;
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
public class IngredienteRestServiceTest {

    @InjectMocks
    private IngredienteRestService ingredienteRestService = new IngredienteRestService();
    @Mock
    private IngredienteService ingredienteService;
    @Mock
    IngredienteResourceMapper resourceMapper;
    @Mock
    GenericValidator createIngredienteValidator;
    @Mock(name = "updateIngredienteValidator")
    GenericValidator updateIngredienteValidator;

    @Test
    public void findAllRecetas() {
        List<Ingrediente> expectedIngredienteList = new ArrayList<>();
        expectedIngredienteList.add(new Ingrediente());
        expectedIngredienteList.add(new Ingrediente());
        Mockito.when(ingredienteService.findAllIngredientes()).thenReturn(expectedIngredienteList);
        IngredienteResource resource = Mockito.mock(IngredienteResource.class);
        Mockito.when(resourceMapper.map(Mockito.any(Ingrediente.class))).thenReturn(resource);

        Response response = ingredienteRestService.findAllRecetas();

        Mockito.verify(ingredienteService,Mockito.times(1)).findAllIngredientes();
        Mockito.verify(resourceMapper,Mockito.times(2)).map(Mockito.any(Ingrediente.class));
        assertEquals(200, response.getStatus());
        assertTrue(response.getEntity() instanceof List);
        List<IngredienteResource> actualList = (List<IngredienteResource>) response.getEntity();
        assertEquals(expectedIngredienteList.size(),actualList.size());
    }
    @Test
    public void findAllRecetasEmptyList() {
        List<Ingrediente> expectedIngredienteList = new ArrayList<>();
        Mockito.when(ingredienteService.findAllIngredientes()).thenReturn(expectedIngredienteList);
        //resource mapper se omite porque la lista viene vacia

        Response response = ingredienteRestService.findAllRecetas();

        Mockito.verify(ingredienteService,Mockito.times(1)).findAllIngredientes();
        assertEquals(200, response.getStatus());
        List<IngredienteResource> actualList = (List<IngredienteResource>) response.getEntity();
        assertTrue(actualList.isEmpty());
    }

    @Test
    public void findIngredienteById() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        Mockito.when(ingredienteService.findIngrediente(ingrediente.getIdIngrediente())).thenReturn(ingrediente);
        IngredienteResource ingredienteResource = new IngredienteResource();
        ingredienteResource.setIdIngrediente(1);
        Mockito.when(resourceMapper.map(ingrediente)).thenReturn(ingredienteResource);

        Response response = ingredienteRestService.findIngredienteById(ingrediente.getIdIngrediente());

        Mockito.verify(ingredienteService,Mockito.times(1)).findIngrediente(ingrediente.getIdIngrediente());
        Mockito.verify(resourceMapper,Mockito.times(1)).map(ingrediente);
        assertEquals(200, response.getStatus());
        IngredienteResource resource = (IngredienteResource) response.getEntity();
        assertEquals(ingrediente.getIdIngrediente(), resource.getIdIngrediente());
    }
    @Test(expected = GeneralException.class)
    public void findIngredienteByIdExceptionIdNull() {
        Ingrediente ingrediente = new Ingrediente();

        Response response = ingredienteRestService.findIngredienteById(ingrediente.getIdIngrediente());
    }

    @Test
    public void createIngrediente() {
        Ingrediente ingrediente = new Ingrediente();
        Mockito.doNothing().when(createIngredienteValidator).validate(ingrediente);
        Mockito.doNothing().when(ingredienteService).saveIngrediente(ingrediente);

        Response response = ingredienteRestService.createIngrediente(ingrediente);

        Mockito.verify(createIngredienteValidator,Mockito.times(1)).validate(ingrediente);
        Mockito.verify(ingredienteService,Mockito.times(1)).saveIngrediente(ingrediente);
        assertEquals(200,response.getStatus());
    }
    @Test(expected = GeneralException.class)
    public void createIngredienteException() {
        Ingrediente ingrediente = new Ingrediente();
        Mockito.doNothing().when(createIngredienteValidator).validate(ingrediente);
        Mockito.doThrow(GeneralException.class).when(ingredienteService).saveIngrediente(ingrediente);
        ingredienteRestService.createIngrediente(ingrediente);
        Mockito.verify(createIngredienteValidator,Mockito.times(1)).validate(ingrediente);
        Mockito.verify(ingredienteService,Mockito.times(1)).saveIngrediente(ingrediente);
    }

    @Test
    public void updateIngrediente() {
        Ingrediente ingrediente = new Ingrediente();
        Mockito.doNothing().when(updateIngredienteValidator).validate(ingrediente);
        Mockito.doNothing().when(ingredienteService).updateIngrediente(ingrediente);

        Response response = ingredienteRestService.updateIngrediente(ingrediente);

        Mockito.verify(updateIngredienteValidator,Mockito.times(1)).validate(ingrediente);
        Mockito.verify(ingredienteService,Mockito.times(1)).updateIngrediente(ingrediente);
        assertEquals(200,response.getStatus());
    }
    @Test(expected = GeneralException.class)
    public void updateIngredienteException() {
        Ingrediente ingrediente = new Ingrediente();
        Mockito.doNothing().when(updateIngredienteValidator).validate(ingrediente);
        Mockito.doThrow(GeneralException.class).when(ingredienteService).updateIngrediente(ingrediente);

        ingredienteRestService.updateIngrediente(ingrediente);
    }

    @Test
    public void deleteIngrediente() {
        Mockito.doNothing().when(ingredienteService).deleteIngrediente(Mockito.anyInt());

        Response response = ingredienteRestService.deleteIngrediente(1);

        Mockito.verify(ingredienteService,Mockito.times(1)).deleteIngrediente(Mockito.anyInt());
        assertEquals(200,response.getStatus());
    }
    @Test(expected = GeneralException.class)
    public void deleteIngredienteExceptionIdNull() {
        Integer id =null;
        ingredienteRestService.deleteIngrediente(id);
    }
}