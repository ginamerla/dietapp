package com.tortu.api.rest.restservices;

import com.tortu.api.models.LayoutPeriodo;
import com.tortu.api.rest.mappers.LayoutPeriodoResourceMapper;
import com.tortu.api.rest.resources.LayoutPeriodoResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.LayoutPeriodoService;
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
public class LayoutPeriodoRestServiceTest {

    @InjectMocks
    LayoutPeriodoRestService restService = new LayoutPeriodoRestService();
    @Mock
    LayoutPeriodoService service;
    @Mock
    LayoutPeriodoResourceMapper resourceMapper;
    @Mock
    GenericValidator<LayoutPeriodo> createValidator;
    @Mock(name = "updateLayoutPeriodoValidator")
    GenericValidator<LayoutPeriodo> updateValidator;

    @Test
    public void findAllLayoutPeriodo() {
        List<LayoutPeriodo> expectedList = new ArrayList<>();
        expectedList.add(new LayoutPeriodo());
        expectedList.add(new LayoutPeriodo());
        Mockito.when(service.findAllLayoutPeriodo()).thenReturn(expectedList);
        LayoutPeriodoResource resource = new LayoutPeriodoResource();
        Mockito.when(resourceMapper.map(Mockito.any(LayoutPeriodo.class))).thenReturn(resource);
        Response response = restService.findAllLayoutPeriodo();
        Mockito.verify(service,Mockito.times(1)).findAllLayoutPeriodo();
        Mockito.verify(resourceMapper,Mockito.times(2)).map(Mockito.any(LayoutPeriodo.class));
        assertEquals(200,response.getStatus());
        assertTrue(response.getEntity() instanceof List);
        List<LayoutPeriodoResource> resourceList = (List<LayoutPeriodoResource>) response.getEntity();
        assertEquals(2,resourceList.size());
    }
    @Test
    public void findAllLayoutPeriodoEmptyList() {
        List<LayoutPeriodo> expectedList = new ArrayList<>();
        Mockito.when(service.findAllLayoutPeriodo()).thenReturn(expectedList);
        Response response = restService.findAllLayoutPeriodo();
        Mockito.verify(service,Mockito.times(1)).findAllLayoutPeriodo();
        assertEquals(200,response.getStatus());
        assertTrue(response.getEntity() instanceof List);
        List<LayoutPeriodoResource> resourceList = (List<LayoutPeriodoResource>) response.getEntity();
        assertTrue(resourceList.isEmpty());
    }

    @Test
    public void findLayoutPeriodo() {
        Integer id=1;
        LayoutPeriodo layoutPeriodo = new LayoutPeriodo();
        layoutPeriodo.setIdLayoutPeriodo(id);
        Mockito.when(service.findLayoutPeriodo(id)).thenReturn(layoutPeriodo);
        LayoutPeriodoResource resource = new LayoutPeriodoResource();
        resource.setIdLayoutPeriodo(1);
        Mockito.when(resourceMapper.map(layoutPeriodo)).thenReturn(resource);
        Response response = restService.findLayoutPeriodo(id);
        Mockito.verify(service,Mockito.times(1)).findLayoutPeriodo(id);
        Mockito.verify(resourceMapper,Mockito.times(1)).map(layoutPeriodo);
        assertEquals(200,response.getStatus());
        LayoutPeriodoResource actual = (LayoutPeriodoResource) response.getEntity();
        assertEquals(layoutPeriodo.getIdLayoutPeriodo(), actual.getIdLayoutPeriodo());
    }
    @Test(expected = GeneralException.class)
    public void findLayoutPeriodoExceptionIdNull() {
        Integer id=null;
        restService.findLayoutPeriodo(id);
    }

    @Test
    public void createLayoutPeriodo() {
        LayoutPeriodo layoutPeriodo = new LayoutPeriodo();
        Mockito.doNothing().when(createValidator).validate(layoutPeriodo);
        Mockito.doNothing().when(service).saveLayoutPeriodo(layoutPeriodo);
        Response response = restService.createLayoutPeriodo(layoutPeriodo);
        Mockito.verify(createValidator,Mockito.atMost(1)).validate(layoutPeriodo);
        Mockito.verify(service,Mockito.times(1)).saveLayoutPeriodo(layoutPeriodo);
        assertEquals(200,response.getStatus());
    }

    @Test
    public void updateLayoutPeriodo() {
        LayoutPeriodo layoutPeriodo = new LayoutPeriodo();
        Mockito.doNothing().when(updateValidator).validate(layoutPeriodo);
        Mockito.doNothing().when(service).updateLayoutPeriodo(layoutPeriodo);
        Response response = restService.updateLayoutPeriodo(layoutPeriodo);
        Mockito.verify(updateValidator,Mockito.atMost(1)).validate(layoutPeriodo);
        Mockito.verify(service,Mockito.times(1)).updateLayoutPeriodo(layoutPeriodo);
        assertEquals(200,response.getStatus());
    }

    @Test
    public void deleteLayoutPeriodo() {
        Integer id=1;
        Mockito.doNothing().when(service).deleteLayoutPeriodo(id);
        Response response = restService.deleteLayoutPeriodo(id);
        Mockito.verify(service,Mockito.times(1)).deleteLayoutPeriodo(id);
        assertEquals(200, response.getStatus());
    }
    @Test(expected = GeneralException.class)
    public void deleteLayoutPeriodoIdNull() {
        Integer id=null;
        Response response = restService.deleteLayoutPeriodo(id);
    }
}