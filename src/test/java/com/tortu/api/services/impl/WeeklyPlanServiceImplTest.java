package com.tortu.api.services.impl;

import com.tortu.api.models.DietaUsuario;
import com.tortu.api.models.UsuarioLayout;
import com.tortu.api.rest.resources.WPWeekDayResultResource;
import com.tortu.api.rest.resources.WeeklyPlanPeriodRecipeResource;
import com.tortu.api.rest.resources.WeeklyPlanRecipeResource;
import com.tortu.api.rest.resources.WeeklyPlanResource;
import com.tortu.api.services.*;
import org.apache.cxf.management.annotation.ManagedOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class WeeklyPlanServiceImplTest {

    @InjectMocks
    private WeeklyPlanServiceImpl weeklyPlanService;
    @Mock
    private UsuarioLayoutService usuarioLayoutService;
    @Mock
    private DietaUsuarioService dietaUsuarioService;
    @Mock
    private RecetaPeriodoService recetaPeriodoService;
    @Mock
    private ComboDietaUsuarioService comboDietaUsuarioService;

    @Test
    public void saveWeeklyPlan(){
        WeeklyPlanRecipeResource recipe = new WeeklyPlanRecipeResource();
        recipe.setRecipeId(31);
        WeeklyPlanRecipeResource recipe2 = new WeeklyPlanRecipeResource();
        recipe.setRecipeId(32);
        List<WeeklyPlanRecipeResource> recipeList = new ArrayList<>();
        recipeList.add(recipe);
        recipeList.add(recipe2);

        WeeklyPlanPeriodRecipeResource periodRecipe = new WeeklyPlanPeriodRecipeResource();
        periodRecipe.setPeriodId(1);
        periodRecipe.setWeeklyPlanRecipes(recipeList);
        WeeklyPlanPeriodRecipeResource periodRecipe2 = new WeeklyPlanPeriodRecipeResource();
        periodRecipe2.setPeriodId(2);
        periodRecipe2.setWeeklyPlanRecipes(recipeList);
        WeeklyPlanPeriodRecipeResource periodRecipe3 = new WeeklyPlanPeriodRecipeResource();
        periodRecipe3.setPeriodId(3);
        periodRecipe3.setWeeklyPlanRecipes(recipeList);

        List<WeeklyPlanPeriodRecipeResource> periodRecipeList = new ArrayList<>();
        periodRecipeList.add(periodRecipe);
        periodRecipeList.add(periodRecipe2);
        periodRecipeList.add(periodRecipe3);

        WeeklyPlanResource wpResource = new WeeklyPlanResource();
        Integer userId= 1;
        wpResource.setLayoutId(1);
        wpResource.setUserId(userId);
        wpResource.setWeeklyPlanPeriodRecipes(periodRecipeList);

        // deleteCurrentWeeklyPlanInfoByUserId
        List<Integer> expectedDUIdList = new ArrayList<>();
        expectedDUIdList.add(100);
        expectedDUIdList.add(200);

        Mockito.when(dietaUsuarioService.getDietaUsuarioIdListByUser(Mockito.anyInt())).thenReturn(expectedDUIdList);
        List<Integer> actualCDUIdList = new ArrayList<>();
        actualCDUIdList.add(55);
        actualCDUIdList.add(56);
        actualCDUIdList.add(57);
        Mockito.when(comboDietaUsuarioService.getComboDietaUsuarioIdsByDietaUsuario(expectedDUIdList)).thenReturn(actualCDUIdList);
        Mockito.doNothing().when(comboDietaUsuarioService).deleteComboDietaUsuario(Mockito.anyInt());
        Mockito.doNothing().when(dietaUsuarioService).deleteDietaUsuario(Mockito.anyInt());
        // fin
        UsuarioLayout usuarioLayout = new UsuarioLayout();
//        Mockito.doNothing().when(usuarioLayoutService).saveUsuarioLayout(usuarioLayout);

        Mockito.doNothing().when(dietaUsuarioService).saveDietaUsuario(Mockito.any(DietaUsuario.class));

        //paso 4
        List<Integer> bRecipeList = new ArrayList<>();
        List<Integer> expectedLst = new ArrayList<>();
//        Mockito.when(recetaPeriodoService.getRecetaPeriodoIdList(1,bRecipeList)).thenReturn(expectedLst);
        // fin
        //paso 5
//        List<Integer> duIdList = new ArrayList<>();
        Mockito.when(dietaUsuarioService.getDietaUsuarioIdListByUser(1)).thenReturn(expectedDUIdList);

        weeklyPlanService.saveWeeklyPlan(wpResource);

        Mockito.verify(dietaUsuarioService,Mockito.times(2)).getDietaUsuarioIdListByUser(Mockito.anyInt());
        Mockito.verify(comboDietaUsuarioService,Mockito.times(1)).getComboDietaUsuarioIdsByDietaUsuario(expectedDUIdList);
        Mockito.verify(comboDietaUsuarioService,Mockito.times(3)).deleteComboDietaUsuario(Mockito.anyInt());
        Mockito.verify(dietaUsuarioService,Mockito.times(2)).deleteDietaUsuario(Mockito.anyInt());
        Mockito.verify(dietaUsuarioService,Mockito.times(5)).saveDietaUsuario(Mockito.any(DietaUsuario.class));
        Mockito.verify(recetaPeriodoService,Mockito.times(1)).getRecetaPeriodoIdList(1, expectedLst);
    }

}