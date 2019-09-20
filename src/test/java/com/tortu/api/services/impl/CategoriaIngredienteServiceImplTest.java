package com.tortu.api.services.impl;

import com.tortu.api.daos.impl.CategoriaIngredienteDaoImpl;
import com.tortu.api.models.CategoriaIngrediente;
import com.tortu.api.utils.GeneralException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class CategoriaIngredienteServiceImplTest {
    @InjectMocks
    private CategoriaIngredienteServiceImpl categoriaIngredienteService = new CategoriaIngredienteServiceImpl();
    @Mock
    private CategoriaIngredienteDaoImpl categoriaIngredienteDao;

    @Test
    public void saveCategoriaIngrediente() {
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        Mockito.doNothing().when(categoriaIngredienteDao).save(categoriaIngrediente);

        categoriaIngredienteService.saveCategoriaIngrediente(categoriaIngrediente);

        Mockito.verify(categoriaIngredienteDao,Mockito.times(1)).save(categoriaIngrediente);
    }

    @Test
    public void updateCategoriaIngrediente() {
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        categoriaIngrediente.setIdCategoriaIngrediente(1);

        Mockito.doNothing().when(categoriaIngredienteDao).update(categoriaIngrediente);

        categoriaIngredienteService.updateCategoriaIngrediente(categoriaIngrediente);

        Mockito.verify(categoriaIngredienteDao,Mockito.times(1)).update(categoriaIngrediente);
    }

    @Test(expected = GeneralException.class)
    public void updateCategoriaIngredienteExceptionIdNull(){
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        categoriaIngredienteService.updateCategoriaIngrediente(categoriaIngrediente);
    }

    @Test
    public void findCategoriaIngrediente() {
        CategoriaIngrediente categoria = new CategoriaIngrediente();
        categoria.setIdCategoriaIngrediente(1);

        CategoriaIngrediente  expectedCategoria= new CategoriaIngrediente();
        expectedCategoria.setNombre("Nombre Prueba");
        Mockito.when(categoriaIngredienteDao.findByiD(categoria.getIdCategoriaIngrediente())).thenReturn(expectedCategoria);

        CategoriaIngrediente result = categoriaIngredienteService.findCategoriaIngrediente(categoria.getIdCategoriaIngrediente());

        Mockito.verify(categoriaIngredienteDao,Mockito.times(1)).findByiD(categoria.getIdCategoriaIngrediente());
        assertEquals(expectedCategoria.getNombre(), result.getNombre());
    }

    @Test(expected = GeneralException.class)
    public void findCategoriaIngredienteExceptionIdNull() {
        CategoriaIngrediente categoria = new CategoriaIngrediente();

        CategoriaIngrediente categoriaIngrediente = categoriaIngredienteService.findCategoriaIngrediente(categoria.getIdCategoriaIngrediente());
    }
    @Test
    public void findAllCategoriaIngrediente() {
        List<CategoriaIngrediente> expectedList = new ArrayList<>();
        expectedList.add(new CategoriaIngrediente());
        expectedList.add(new CategoriaIngrediente());

        Mockito.when(categoriaIngredienteDao.findAll()).thenReturn(expectedList);

        List<CategoriaIngrediente> resultList = categoriaIngredienteService.findAllCategoriaIngrediente();

        Mockito.verify(categoriaIngredienteDao,Mockito.times(1)).findAll();
        assertEquals(expectedList.get(1),resultList.get(1));
    }
    @Test
    public void findAllCategoriaIngredienteNullList(){
        Mockito.when(categoriaIngredienteDao.findAll()).thenReturn(null);

        List<CategoriaIngrediente> resultList = categoriaIngredienteService.findAllCategoriaIngrediente();

        Mockito.verify(categoriaIngredienteDao,Mockito.times(1)).findAll();
        assertNotNull(resultList);
    }

    @Test
    public void deleteCategoriaIngrediente() {
        Mockito.doNothing().when(categoriaIngredienteDao).delete(1);

        categoriaIngredienteService.deleteCategoriaIngrediente(1);

        Mockito.verify(categoriaIngredienteDao,Mockito.times(1)).delete(1);

    }
    @Test(expected = GeneralException.class)
    public void deleteCategoriaIngredienteExceptionIdNull() {
        CategoriaIngrediente categoriaIngrediente = new CategoriaIngrediente();
        categoriaIngredienteService.deleteCategoriaIngrediente(categoriaIngrediente.getIdCategoriaIngrediente());
    }
}
