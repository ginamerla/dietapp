package com.tortu.api.rest.restservices;

import com.tortu.api.models.DietaUsuario;
import com.tortu.api.rest.mappers.DietaUsuarioResourceMapper;
import com.tortu.api.rest.resources.DietaUsuarioResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.DietaUsuarioService;
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
public class DietaUsuarioRestServiceTest {

    @InjectMocks
    DietaUsuarioRestService restService = new DietaUsuarioRestService();
    @Mock
    DietaUsuarioService service;
    @Mock
    DietaUsuarioResourceMapper mapper;
    @Mock
    GenericValidator createDietaUsuarioValidator;
    @Mock(name = "updateDietaUsuarioValidator")
    GenericValidator updateDietaUsuarioValidator;

    @Test
    public void findAllDietaUsuario() {
        List<DietaUsuario> expectedList = new ArrayList<>();
        expectedList.add(new DietaUsuario());
        Mockito.when(service.findAllDietaUsuario()).thenReturn(expectedList);
        DietaUsuarioResource resource = Mockito.mock(DietaUsuarioResource.class);
        Mockito.when(mapper.map(Mockito.any(DietaUsuario.class))).thenReturn(resource);

        Response response = restService.findAllDietaUsuario();

        Mockito.verify(service,Mockito.times(1)).findAllDietaUsuario();
        Mockito.verify(mapper,Mockito.times(1)).map(Mockito.any(DietaUsuario.class));
        assertEquals(200,response.getStatus());
        assertTrue(response.getEntity() instanceof List);
        List<DietaUsuarioResource> resourceList = (List<DietaUsuarioResource>) response.getEntity();
        assertEquals(1,resourceList.size());
    }
    @Test
    public void findAllDietaUsuarioEmptyList() {
        List<DietaUsuario> expectedList = new ArrayList<>();
        Mockito.when(service.findAllDietaUsuario()).thenReturn(expectedList);

        Response response = restService.findAllDietaUsuario();

        Mockito.verify(service,Mockito.times(1)).findAllDietaUsuario();
        assertEquals(200,response.getStatus());
        List<DietaUsuarioResource> resourceList = (List<DietaUsuarioResource>) response.getEntity();
        assertTrue(resourceList.isEmpty());
    }

    @Test
    public void findDietaUsuarioById() {
        Integer idDietaUsuario = 1;
        DietaUsuario dietaUsuario = new DietaUsuario();
        dietaUsuario.setIdDietaUsuario(idDietaUsuario);
        Mockito.when(service.findDietaUsuario(dietaUsuario.getIdDietaUsuario())).thenReturn(dietaUsuario);
        DietaUsuarioResource resource = new DietaUsuarioResource();
        resource.setIdDietaUsuario(1);
        Mockito.when(mapper.map(dietaUsuario)).thenReturn(resource);

        Response response = restService.findDietaUsuarioById(idDietaUsuario);

        Mockito.verify(service,Mockito.times(1)).findDietaUsuario(idDietaUsuario);
        Mockito.verify(mapper,Mockito.times(1)).map(dietaUsuario);
        assertEquals(200,response.getStatus());
        DietaUsuarioResource actualResponse = (DietaUsuarioResource) response.getEntity();
        assertEquals(dietaUsuario.getIdDietaUsuario(),actualResponse.getIdDietaUsuario());
    }
    @Test(expected = GeneralException.class)
    public void findDietaUsuarioExceptionIdNull(){
        DietaUsuario dietaUsuario = new DietaUsuario();
        restService.findDietaUsuarioById(dietaUsuario.getIdDietaUsuario());
    }

    @Test
    public void createDietaUsuario() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        Mockito.doNothing().when(createDietaUsuarioValidator).validate(dietaUsuario);
        Mockito.doNothing().when(service).saveDietaUsuario(dietaUsuario);
        //DietaUsuarioResource resource = new DietaUsuarioResource();
        //Mockito.when(mapper.map(savedDieta)).thenReturn(resource);

        Response response = restService.createDietaUsuario(dietaUsuario);

        Mockito.verify(createDietaUsuarioValidator,Mockito.times(1)).validate(dietaUsuario);
        Mockito.verify(service,Mockito.times(1)).saveDietaUsuario(dietaUsuario);
        //Mockito.verify(mapper,Mockito.times(1)).map(savedDieta);
        assertEquals(200,response.getStatus());
    }
    @Test(expected = GeneralException.class)
    public void createDietaUsuarioException(){
        DietaUsuario dietaUsuario = new DietaUsuario();
        Mockito.doNothing().when(createDietaUsuarioValidator).validate(dietaUsuario);
        Mockito.doThrow(GeneralException.class).when(service).saveDietaUsuario(dietaUsuario);

        restService.createDietaUsuario(dietaUsuario);

        Mockito.verify(createDietaUsuarioValidator,Mockito.times(1)).validate(dietaUsuario);
        Mockito.verify(service,Mockito.times(1)).saveDietaUsuario(dietaUsuario);
    }

    @Test
    public void updateDietaUsuario() {
        DietaUsuario dietaUsuario = new DietaUsuario();
        Mockito.doNothing().when(updateDietaUsuarioValidator).validate(dietaUsuario);
        Mockito.doNothing().when(service).updateDietaUsuario(dietaUsuario);

        Response response = restService.updateDietaUsuario(dietaUsuario);

        Mockito.verify(updateDietaUsuarioValidator,Mockito.times(1)).validate(dietaUsuario);
        Mockito.verify(service,Mockito.times(1)).updateDietaUsuario(dietaUsuario);
        assertEquals(200,response.getStatus());
    }
    @Test(expected = GeneralException.class)
    public void updateDietaUsuarioException(){
        DietaUsuario dietaUsuario = new DietaUsuario();
        Mockito.doNothing().when(updateDietaUsuarioValidator).validate(dietaUsuario);
        Mockito.doThrow(GeneralException.class).when(service).updateDietaUsuario(dietaUsuario);
        restService.updateDietaUsuario(dietaUsuario);

        Mockito.verify(updateDietaUsuarioValidator,Mockito.times(1)).validate(dietaUsuario);
        Mockito.verify(service,Mockito.times(1)).updateDietaUsuario(dietaUsuario);
    }

    @Test
    public void deleteDietaUsuario() {
        Integer idDieta = 1;
        Mockito.doNothing().when(service).deleteDietaUsuario(idDieta);
        Response response = restService.deleteDietaUsuario(idDieta);
        Mockito.verify(service,Mockito.times(1)).deleteDietaUsuario(idDieta);
        assertEquals(200,response.getStatus());
    }
    @Test(expected = GeneralException.class)
    public void deleteDietaUsuarioExceptionIdNull() {
        Integer idDieta = null;
        restService.deleteDietaUsuario(idDieta);
    }
}