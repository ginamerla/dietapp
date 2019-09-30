package com.tortu.api.rest.restservices;

import com.tortu.api.models.CategoriaIngrediente;
import com.tortu.api.rest.mappers.CategoriaIngredienteResourceMapper;
import com.tortu.api.rest.resources.CategoriaIngredienteResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.CategoriaIngredienteService;
import com.tortu.api.utils.GeneralException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class CategoriaIngredienteRestServiceTest {
    @InjectMocks
    private CategoriaIngredienteRestService restService = new CategoriaIngredienteRestService();
    @Mock
    private CategoriaIngredienteService service;
    @Mock
    private CategoriaIngredienteResourceMapper resourceMapper;
    @Mock
    private GenericValidator createCategoriaIngredienteValidator;
    @Mock(name = "updateCategoriaIngredienteValidator")
    private GenericValidator updateCategoriaIngredienteValidator;

    @Test
    public void findAllCategoriaIngrediente() {
        List<CategoriaIngrediente> expectedList = new ArrayList<>();
        expectedList.add(new CategoriaIngrediente());
        Mockito.when(service.findAllCategoriaIngrediente()).thenReturn(expectedList);

        CategoriaIngredienteResource resource = Mockito.mock(CategoriaIngredienteResource.class);
        Mockito.when(resourceMapper.map(Mockito.any(CategoriaIngrediente.class))).thenReturn(resource);

        Response response = restService.findAllCategoriaIngrediente();

        Mockito.verify(service,Mockito.times(1)).findAllCategoriaIngrediente();
        Mockito.verify(resourceMapper,Mockito.times(1)).map(Mockito.any(CategoriaIngrediente.class));

        assertEquals(200, response.getStatus());
        assertTrue(response.getEntity() instanceof List);
        List<CategoriaIngredienteResource> resultList = (List<CategoriaIngredienteResource>) response.getEntity();
        assertEquals(1, resultList.size());

    }
    @Test
    public void findAllCategoriaIngredienteEmptyList(){
        List<CategoriaIngrediente> expectedList = new ArrayList<>();
        Mockito.when(service.findAllCategoriaIngrediente()).thenReturn(expectedList);

        Response response = restService.findAllCategoriaIngrediente();

        Mockito.verify(service,Mockito.times(1)).findAllCategoriaIngrediente();
        assertEquals(200,response.getStatus());
        List<CategoriaIngredienteResource> resourceList = (List<CategoriaIngredienteResource>) response.getEntity();
        assertTrue(resourceList.isEmpty());
    }

    @Test
    public void findCategoriaIngredienteById() {
        Integer id=1;
        CategoriaIngrediente expected = new CategoriaIngrediente();
        expected.setIdCategoriaIngrediente(id);
        Mockito.when(service.findCategoriaIngrediente(id)).thenReturn(expected);

        CategoriaIngredienteResource resource = new CategoriaIngredienteResource();
        resource.setIdCategoriaIngrediente(id);
        Mockito.when(resourceMapper.map(expected)).thenReturn(resource);

        Response response = restService.findCategoriaIngredienteById(id);

        Mockito.verify(service,Mockito.times(1)).findCategoriaIngrediente(id);
        Mockito.verify(resourceMapper,Mockito.times(1)).map(expected);

        assertEquals(200, response.getStatus());
        CategoriaIngredienteResource realResult = (CategoriaIngredienteResource) response.getEntity();
        assertEquals(expected.getIdCategoriaIngrediente(),realResult.getIdCategoriaIngrediente());
    }

    @Test(expected = GeneralException.class)
    public void findCategoriaIngredienteByIdExceptionIdNull(){
        Response response = restService.findCategoriaIngredienteById(null);
    }

    @Test
    public void createCategoriaIngrediente() {
        CategoriaIngrediente categoria = new CategoriaIngrediente();
        Mockito.doNothing().when(createCategoriaIngredienteValidator).validate(categoria);
        Mockito.doNothing().when(service).saveCategoriaIngrediente(categoria);
        //CategoriaIngredienteResource resource = new CategoriaIngredienteResource();
        //Mockito.when(resourceMapper.map(categoria)).thenReturn(resource);

        Response response = restService.createCategoriaIngrediente(categoria);

        Mockito.verify(createCategoriaIngredienteValidator,Mockito.times(1)).validate(categoria);
        Mockito.verify(service,Mockito.times(1)).saveCategoriaIngrediente(categoria);
        //Mockito.verify(resourceMapper,Mockito.times(1)).map(categoria);

        assertEquals(200, response.getStatus());
    }

    /**
     * Prueba con alguna excepcion dentro del metodo (ej, servicio)
     */
    @Test(expected = GeneralException.class)
    public void createCategoriaIngredienteException(){
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        Mockito.doNothing().when(createCategoriaIngredienteValidator).validate(categoriaIngrediente);
        Mockito.doThrow(GeneralException.class).when(service).saveCategoriaIngrediente(categoriaIngrediente);

        restService.createCategoriaIngrediente(categoriaIngrediente);

        Mockito.verify(createCategoriaIngredienteValidator,Mockito.times(1)).validate(categoriaIngrediente);
        Mockito.verify(service,Mockito.times(1)).saveCategoriaIngrediente(categoriaIngrediente);
    }

    @Test
    public void updateCategoriaIngrediente() {
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        Mockito.doNothing().when(updateCategoriaIngredienteValidator).validate(categoriaIngrediente);
        Mockito.doNothing().when(service).updateCategoriaIngrediente(categoriaIngrediente);
        //CategoriaIngredienteResource resource = new CategoriaIngredienteResource();
        //Mockito.when(resourceMapper.map(categoriaIngrediente)).thenReturn(resource);

        Response response = restService.updateCategoriaIngrediente(categoriaIngrediente);

        Mockito.verify(updateCategoriaIngredienteValidator,Mockito.times(1)).validate(categoriaIngrediente);
        Mockito.verify(service,Mockito.times(1)).updateCategoriaIngrediente(categoriaIngrediente);
        //Mockito.verify(resourceMapper,Mockito.times(1)).map(categoriaIngrediente);
        assertEquals(200, response.getStatus());
    }
    @Test(expected = GeneralException.class)
    public void updateCategoriaIngredienteException(){
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        Mockito.doNothing().when(updateCategoriaIngredienteValidator).validate(categoriaIngrediente);
        Mockito.doThrow(GeneralException.class).when(service).updateCategoriaIngrediente(categoriaIngrediente);

        restService.updateCategoriaIngrediente(categoriaIngrediente);

        Mockito.verify(updateCategoriaIngredienteValidator,Mockito.times(1)).validate(categoriaIngrediente);
        Mockito.verify(service,Mockito.times(1)).updateCategoriaIngrediente(categoriaIngrediente);
    }

    @Test
    public void deleteCategoriaIngrediente() {
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        categoriaIngrediente.setIdCategoriaIngrediente(1);
        Mockito.doNothing().when(service).deleteCategoriaIngrediente(categoriaIngrediente.getIdCategoriaIngrediente());

        restService.deleteCategoriaIngrediente(categoriaIngrediente.getIdCategoriaIngrediente());

        Mockito.verify(service,Mockito.times(1)).deleteCategoriaIngrediente(categoriaIngrediente.getIdCategoriaIngrediente());
    }
    @Test(expected = GeneralException.class)
    public void deleteCategoriaIngredienteExceptionIdNull(){
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        restService.deleteCategoriaIngrediente(categoriaIngrediente.getIdCategoriaIngrediente());
    }
    @Test(expected = GeneralException.class)
    public void deleteCategoriaIngredienteException(){
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        categoriaIngrediente.setIdCategoriaIngrediente(1);
        Mockito.doThrow(GeneralException.class).when(service).deleteCategoriaIngrediente(categoriaIngrediente.getIdCategoriaIngrediente());
        restService.deleteCategoriaIngrediente(categoriaIngrediente.getIdCategoriaIngrediente());
        Mockito.verify(service,Mockito.times(1)).deleteCategoriaIngrediente(categoriaIngrediente.getIdCategoriaIngrediente());
    }

}