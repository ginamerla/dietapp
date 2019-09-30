package com.tortu.api.rest.restservices;

import com.tortu.api.models.UsuarioLayout;
import com.tortu.api.rest.mappers.UsuarioLayoutResourceMapper;
import com.tortu.api.rest.resources.UsuarioLayoutResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.UsuarioLayoutService;
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
public class UsuarioLayoutRestServiceTest {

    @InjectMocks
    private UsuarioLayoutRestService restService = new UsuarioLayoutRestService();
    @Mock
    private UsuarioLayoutService service;
    @Mock
    private UsuarioLayoutResourceMapper mapper;
    @Mock(name = "createUsuarioLayoutValidator")
    private GenericValidator<UsuarioLayout> createValidator;
    @Mock(name = "updateUsuarioLayoutValidator")
    private GenericValidator<UsuarioLayout> updateValidator;

    @Test
    public void findAllUsuarioLayout() {
        List<UsuarioLayout> expectedList = new ArrayList<>();
        expectedList.add(new UsuarioLayout());
        expectedList.add(new UsuarioLayout());
        Mockito.when(service.findAllUsuarioLayout()).thenReturn(expectedList);
        UsuarioLayoutResource resource = new UsuarioLayoutResource();
        Mockito.when(mapper.map(Mockito.any(UsuarioLayout.class))).thenReturn(resource);
        Response response = restService.findAllUsuarioLayout();
        Mockito.verify(service,Mockito.times(1)).findAllUsuarioLayout();
        Mockito.verify(mapper,Mockito.times(2)).map(Mockito.any(UsuarioLayout.class));
        assertEquals(200, response.getStatus());
        assertTrue(response.getEntity() instanceof List);
    }
    @Test
    public void findAllUsuarioLayoutEmptyList() {
        List<UsuarioLayout> expectedList = new ArrayList<>();
        Mockito.when(service.findAllUsuarioLayout()).thenReturn(expectedList);
        Response response = restService.findAllUsuarioLayout();
        Mockito.verify(service,Mockito.times(1)).findAllUsuarioLayout();
        assertEquals(200, response.getStatus());
        List<UsuarioLayoutResource> resourceList = (List<UsuarioLayoutResource>) response.getEntity();
        assertTrue(resourceList.isEmpty());
    }

    @Test
    public void findUsuarioLayout() {
        Integer id=1;
        UsuarioLayout expected = new UsuarioLayout();
        expected.setIdUsuarioLayout(id);
        Mockito.when(service.findUsuarioLayout(Mockito.anyInt())).thenReturn(expected);
        UsuarioLayoutResource resource = new UsuarioLayoutResource();
        resource.setIdUsuarioLayout(id);
        Mockito.when(mapper.map(expected)).thenReturn(resource);

        Response response = restService.findUsuarioLayout(id);

        Mockito.verify(service,Mockito.times(1)).findUsuarioLayout(Mockito.anyInt());
        Mockito.verify(mapper,Mockito.times(1)).map(expected);
        assertEquals(200, response.getStatus());
        UsuarioLayoutResource usuarioLayoutResource = (UsuarioLayoutResource) response.getEntity();
        assertEquals(expected.getIdUsuarioLayout(), usuarioLayoutResource.getIdUsuarioLayout());
    }
    @Test(expected = GeneralException.class)
    public void findUsuarioLayoutExceptionIdNull() {
        Integer id=null;
        UsuarioLayout expected = new UsuarioLayout();
        expected.setIdUsuarioLayout(id);

        restService.findUsuarioLayout(id);
    }

    @Test
    public void createUsuarioLayout() {
        UsuarioLayout usuarioLayout = new UsuarioLayout();
        Mockito.doNothing().when(createValidator).validate(usuarioLayout);
        Mockito.doNothing().when(service).saveUsuarioLayout(usuarioLayout);
        Response response = restService.createUsuarioLayout(usuarioLayout);
        Mockito.verify(createValidator,Mockito.times(1)).validate(usuarioLayout);
        Mockito.verify(service,Mockito.times(1)).saveUsuarioLayout(usuarioLayout);
        assertEquals(200, response.getStatus());
    }
    @Test(expected = GeneralException.class)
    public void createUsuarioLayoutException() {
        UsuarioLayout usuarioLayout = new UsuarioLayout();
        Mockito.doNothing().when(createValidator).validate(usuarioLayout);
        Mockito.doThrow(GeneralException.class).when(service).saveUsuarioLayout(usuarioLayout);
        Response response = restService.createUsuarioLayout(usuarioLayout);
        Mockito.verify(createValidator,Mockito.times(1)).validate(usuarioLayout);
        Mockito.verify(service,Mockito.times(1)).saveUsuarioLayout(usuarioLayout);
    }

    @Test
    public void updateUsuarioLayout() {
        UsuarioLayout usuarioLayout = new UsuarioLayout();
        Mockito.doNothing().when(updateValidator).validate(usuarioLayout);
        Mockito.doNothing().when(service).updateUsuarioLayout(usuarioLayout);
        Response response = restService.updateUsuarioLayout(usuarioLayout);
        Mockito.verify(updateValidator,Mockito.times(1)).validate(usuarioLayout);
        Mockito.verify(service,Mockito.times(1)).updateUsuarioLayout(usuarioLayout);
        assertEquals(200,response.getStatus());
    }
    @Test(expected = GeneralException.class)
    public void updateUsuarioLayoutException() {
        UsuarioLayout usuarioLayout = new UsuarioLayout();
        Mockito.doNothing().when(updateValidator).validate(usuarioLayout);
        Mockito.doThrow(GeneralException.class).when(service).updateUsuarioLayout(usuarioLayout);
        Response response = restService.updateUsuarioLayout(usuarioLayout);
        Mockito.verify(updateValidator,Mockito.times(1)).validate(usuarioLayout);
        Mockito.verify(service,Mockito.times(1)).updateUsuarioLayout(usuarioLayout);
    }

    @Test
    public void deleteUsuarioLayout() {
        Integer id=1;
        Mockito.doNothing().when(service).deleteUsuarioLayout(id);
        Response response = restService.deleteUsuarioLayout(id);
        Mockito.verify(service,Mockito.times(1)).deleteUsuarioLayout(id);
        assertEquals(200,response.getStatus());
    }
    @Test(expected = GeneralException.class)
    public void deleteUsuarioLayoutException() {
        Integer id=1;
        Mockito.doThrow(GeneralException.class).when(service).deleteUsuarioLayout(id);
        restService.deleteUsuarioLayout(id);
        Mockito.verify(service,Mockito.times(1)).deleteUsuarioLayout(id);
    }
    @Test(expected = GeneralException.class)
    public void deleteUsuarioLayoutExceptionIdNull() {
        Integer id=null;
        restService.deleteUsuarioLayout(id);
    }
}