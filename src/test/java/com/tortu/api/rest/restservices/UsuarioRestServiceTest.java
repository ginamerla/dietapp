package com.tortu.api.rest.restservices;

import com.tortu.api.models.Usuario;
import com.tortu.api.rest.mappers.UsuarioResourceMapper;
import com.tortu.api.rest.resources.UsuarioResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.services.UsuarioService;
import com.tortu.api.services.impl.UsuarioServiceImpl;
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
public class UsuarioRestServiceTest {

    @InjectMocks
    private UsuarioRestService usuarioRestService = new UsuarioRestService();

    @Mock
    private UsuarioService usuarioService;

    @Mock
    private UsuarioResourceMapper usuarioResourceMapper;

    @Mock
    private GenericValidator validator;

    @Mock(name="updateUsuarioValidator")
    private GenericValidator updateUsuarioValidator;

    /**
     * Prueba Buscar todos los usuarios
     * Happy path
     */
    @Test
    public void findAllUsuarios() {
        List<Usuario> expectedList = new ArrayList<>();
        expectedList.add(new Usuario());
        expectedList.add(new Usuario());
        Mockito.when(usuarioService.findAllUsuarios()).thenReturn(expectedList);
        //se instancia un usuarioResourse falso(mockeado)
        UsuarioResource usuarioResource = Mockito.mock(UsuarioResource.class);
        Mockito.when(usuarioResourceMapper.map(Mockito.any(Usuario.class))).thenReturn(usuarioResource);


        Response actualResponse = usuarioRestService.findAllUsuarios();
        Mockito.verify(usuarioService, Mockito.times(1)).findAllUsuarios();
        Mockito.verify(usuarioResourceMapper,Mockito.times(2)).map(Mockito.any(Usuario.class));

        assertEquals(200,actualResponse.getStatus());
        assertTrue(actualResponse.getEntity() instanceof List);
        List<UsuarioResource> entityResult = (List<UsuarioResource>) actualResponse.getEntity();
        assertEquals(2,entityResult.size());

    }

    @Test
    public void findAllUsuariosEmptyList() {
        //el mock de la lista que va a regresar el servicio mockeado
        List<Usuario> expectedList = new ArrayList<>();
        Mockito.when(usuarioService.findAllUsuarios()).thenReturn(expectedList);

        //eta es la llamada real al metodo que se esta probando
        Response actualResponse = usuarioRestService.findAllUsuarios();

        //se hace 1 verify porque solo hay un metodo del servicio mockeado (linea 68)
        Mockito.verify(usuarioService, Mockito.times(1)).findAllUsuarios();

        //Como el metodo regresa un Response.ok se debe validar que al menos regrese un 200
        assertEquals(200, actualResponse.getStatus());
        //ahora se debe verificar que la lista este vacia
        //se crea la variable para obtener la lista de respuesta (entity) para poder comprobar que la lista sea vacia
        List<UsuarioResource> listaRespuesta = (List<UsuarioResource>) actualResponse.getEntity();
        //Se verifica que realmente la lista este vacia
        assertTrue(listaRespuesta.isEmpty());
    }

    @Test
    public void findUsuarioById() {
        Integer idUsuario = 1;
        Usuario expectedUsuario = new Usuario();
        expectedUsuario.setIdUsuario(idUsuario);

        Mockito.when(usuarioService.findUsuario(idUsuario)).thenReturn(expectedUsuario);

        //se instancia un usuarioResourse falso(mockeado)
        UsuarioResource usuarioResource = new UsuarioResource();
        usuarioResource.setId(idUsuario);

        Mockito.when(usuarioResourceMapper.map(expectedUsuario)).thenReturn(usuarioResource);

        //llamada real
        Response actualResponse = usuarioRestService.findUsuarioById(idUsuario);

        // verificar los mocks
        Mockito.verify(usuarioService, Mockito.times(1)).findUsuario(1);
        Mockito.verify(usuarioResourceMapper,Mockito.times(1)).map(expectedUsuario);

        //valida los resultados
        assertEquals(actualResponse.getStatus(),200);

        //verifica que el usuario que regreso sea el mismo que se consulto
        UsuarioResource resource = (UsuarioResource) actualResponse.getEntity();
        assertEquals(expectedUsuario.getIdUsuario(),resource.getId());
    }

    @Test(expected = GeneralException.class)
    public void findUsuarioByIdNull() {
        Response actualResponse = usuarioRestService.findUsuarioById(null);

    }

    @Test
    public void createUsuario() {
        //Primero la llamada real, despues cada una de las lineas de codigo del metodo
        // se van creando su llamada, despues los objetos y despues el verify
        Usuario usuarioNuevo = new Usuario();

        Mockito.doNothing().when(validator).validate(usuarioNuevo);
        Usuario usuarioGuardado = new Usuario();
        Mockito.when(usuarioService.saveUsuario(usuarioNuevo)).thenReturn(usuarioGuardado);

        UsuarioResource usuarioResource = new UsuarioResource();
        Mockito.when(usuarioResourceMapper.map(usuarioGuardado)).thenReturn(usuarioResource);

        Response actualResponse = usuarioRestService.createUsuario(usuarioNuevo);

        Mockito.verify(validator,Mockito.times(1)).validate(usuarioNuevo);
        Mockito.verify(usuarioService,Mockito.times(1)).saveUsuario(usuarioNuevo);
        Mockito.verify(usuarioResourceMapper,Mockito.times(1)).map(usuarioGuardado);

        assertEquals(200,actualResponse.getStatus());

    }

    @Test(expected = GeneralException.class)
    public void createUsuarioException(){
        Usuario usuario = new Usuario();

        Mockito.doNothing().when(validator).validate(usuario);
        //para crear la excepcion en el servicio
        Mockito.when(usuarioService.saveUsuario(usuario)).thenThrow(GeneralException.class);

        Response actualResponse = usuarioRestService.createUsuario(usuario);

        Mockito.verify(validator, Mockito.times(1)).validate(usuario);
        Mockito.verify(usuarioService,Mockito.times(1)).saveUsuario(usuario);

    }

    @Test
    public void updateUsuario() {
        Usuario usuarioActualizado = new Usuario();
        Mockito.doNothing().when(updateUsuarioValidator).validate(usuarioActualizado);

        Mockito.when(usuarioService.updateUsuario(usuarioActualizado)).thenReturn(usuarioActualizado);

        UsuarioResource usuarioResource = new UsuarioResource();
        Mockito.when(usuarioResourceMapper.map(usuarioActualizado)).thenReturn(usuarioResource);

        Response actualResponse = usuarioRestService.updateUsuario(usuarioActualizado);

        Mockito.verify(updateUsuarioValidator,Mockito.times(1)).validate(usuarioActualizado);
        Mockito.verify(usuarioService,Mockito.times(1)).updateUsuario(usuarioActualizado);
        Mockito.verify(usuarioResourceMapper,Mockito.times(1)).map(usuarioActualizado);

        assertEquals(200, actualResponse.getStatus());

    }

    @Test(expected = GeneralException.class)
    public void updateUsuarioException() {
        Usuario usuarioActualizado = new Usuario();
        Mockito.doNothing().when(updateUsuarioValidator).validate(usuarioActualizado);
        Mockito.when(usuarioService.updateUsuario(usuarioActualizado)).thenThrow(GeneralException.class);

        Response actualResponse = usuarioRestService.updateUsuario(usuarioActualizado);

        Mockito.verify(updateUsuarioValidator,Mockito.times(1)).validate(usuarioActualizado);
        Mockito.verify(usuarioService,Mockito.times(1)).updateUsuario(usuarioActualizado);

    }

    @Test
    public void deleteUsuario() {
        Usuario usuarioEliminado = new Usuario();
        usuarioEliminado.setIdUsuario(1);

        Response actualResponse = usuarioRestService.deleteUsuario(usuarioEliminado.getIdUsuario());

        assertEquals(200, actualResponse.getStatus());

    }

    @Test(expected = GeneralException.class)
    public void deleteUsuarioIdNull() {
        usuarioRestService.deleteUsuario(null);
    }
}