package com.tortu.api.services.impl;

import com.tortu.api.daos.ComboDietaUsuarioDao;
import com.tortu.api.models.ComboDietaUsuario;
import com.tortu.api.services.ComboDietaUsuarioService;
import com.tortu.api.utils.GeneralException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class ComboDietaUsuarioServiceImplTest {

    @InjectMocks
    private ComboDietaUsuarioService comboDietaUsuarioService = new ComboDietaUsuarioServiceImpl();
    @Mock
    private ComboDietaUsuarioDao comboDietaUsuarioDao;

//    @Test
//    public void saveComboDietaUsuario(){
//        ComboDietaUsuario comboDietaUsuario = new ComboDietaUsuario();
//        Mockito.doNothing().when(comboDietaUsuarioDao).save(comboDietaUsuario);
//
//        comboDietaUsuarioService.saveComboDietaUsuario(comboDietaUsuario);
//
//        Mockito.verify(comboDietaUsuarioDao,Mockito.times(1)).save(comboDietaUsuario);
//    }
//    @Test
//    public void updateComboDietaUsuario(){
//        ComboDietaUsuario combo = new ComboDietaUsuario();
//        combo.setIdComboDietaUsuario(1);
//        Mockito.doNothing().when(comboDietaUsuarioDao).save(combo);
//
//        comboDietaUsuarioService.updateComboDietaUsuario(combo);
//
//        Mockito.verify(comboDietaUsuarioDao,Mockito.times(1)).update(combo);
//    }
//    @Test(expected = GeneralException.class)
//    public void updateComboDietaUsuarioException(){
//        ComboDietaUsuario combo = new ComboDietaUsuario();
//        Mockito.doNothing().when(comboDietaUsuarioDao).save(combo);
//
//        comboDietaUsuarioService.updateComboDietaUsuario(combo);
//
//        Mockito.verify(comboDietaUsuarioDao,Mockito.times(1)).update(combo);
//    }
    @Test
    public void deleteComboDietaUsuario(){
        Mockito.doNothing().when(comboDietaUsuarioDao).delete(1);

        comboDietaUsuarioService.deleteComboDietaUsuario(1);

        Mockito.verify(comboDietaUsuarioDao,Mockito.times(1)).delete(1);
    }
    @Test(expected = GeneralException.class)
    public void deleteComboDietaUsuarioException(){
        comboDietaUsuarioService.deleteComboDietaUsuario(null);
    }
    @Test
    public void findComboDietaUsuario(){
        ComboDietaUsuario expected = new ComboDietaUsuario();
        Mockito.when(comboDietaUsuarioDao.findByiD(1)).thenReturn(expected);

        ComboDietaUsuario actual = comboDietaUsuarioService.findComboDietaUsuario(1);

        Mockito.verify(comboDietaUsuarioDao,Mockito.times(1)).findByiD(1);
        assertEquals(expected,actual);
    }
    @Test(expected = GeneralException.class)
    public void findComboDietaUsuarioException(){
        ComboDietaUsuario expected = new ComboDietaUsuario();
        Mockito.when(comboDietaUsuarioDao.findByiD(1)).thenReturn(null);

        ComboDietaUsuario actual = comboDietaUsuarioService.findComboDietaUsuario(1);

        Mockito.verify(comboDietaUsuarioDao,Mockito.times(1)).findByiD(1);
        assertNull(actual);
    }
    @Test
    public void findAllComboDietaUsuario(){
        List<ComboDietaUsuario> expectedList = new ArrayList<>();
        expectedList.add(new ComboDietaUsuario());
        expectedList.add(new ComboDietaUsuario());
        Mockito.when(comboDietaUsuarioDao.findAll()).thenReturn(expectedList);

        List<ComboDietaUsuario> actualList = comboDietaUsuarioService.findAllComboDietaUsuario();

        Mockito.verify(comboDietaUsuarioDao,Mockito.times(1)).findAll();
        assertEquals(expectedList,actualList);
        assertEquals(2,actualList.size());
    }
    @Test
    public void findAllComboDietaUsuarioEmptyList(){
        Mockito.when(comboDietaUsuarioDao.findAll()).thenReturn(null);

        List<ComboDietaUsuario> actualList = comboDietaUsuarioService.findAllComboDietaUsuario();

        Mockito.verify(comboDietaUsuarioDao,Mockito.times(1)).findAll();
        assertNotNull(actualList);
    }
    @Test
    public void getComboDietaUsuarioIdsByDietaUsuario(){
        List<Integer> idList = new ArrayList<>();
        idList.add(90);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        Mockito.when(comboDietaUsuarioDao.findComboDietaUsuarioIdListByDietaUsuario(idList)).thenReturn(expected);

        List<Integer> actualList = comboDietaUsuarioService.getComboDietaUsuarioIdsByDietaUsuario(idList);

        Mockito.verify(comboDietaUsuarioDao,Mockito.times(1)).findComboDietaUsuarioIdListByDietaUsuario(idList);
        assertEquals(expected,actualList);
        assertEquals(3, actualList.size());
    }
    @Test
    public void getComboDietaUsuarioIdsByDietaUsuarioIdListEmpty(){
        List<Integer> actualList = comboDietaUsuarioService.getComboDietaUsuarioIdsByDietaUsuario(null);
        assertNotNull(actualList);
    }
    @Test
    public void getComboDietaUsuarioIdsByDietaUsuarioResultEmpty(){
        List<Integer> idList = new ArrayList<>();
        idList.add(90);
        idList.add(89);
        Mockito.when(comboDietaUsuarioDao.findComboDietaUsuarioIdListByDietaUsuario(idList)).thenReturn(null);

        List<Integer> actualList = comboDietaUsuarioService.getComboDietaUsuarioIdsByDietaUsuario(idList);

        Mockito.verify(comboDietaUsuarioDao,Mockito.times(1)).findComboDietaUsuarioIdListByDietaUsuario(idList);
        assertNotNull(actualList);
    }

}