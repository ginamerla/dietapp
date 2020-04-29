package com.tortu.api.rest.validators.weekyplanapi;

import com.tortu.api.rest.resources.WeeklyPlanPeriodRecipeResource;
import com.tortu.api.rest.resources.WeeklyPlanRecipeResource;
import com.tortu.api.rest.resources.WeeklyPlanResource;
import com.tortu.api.utils.GeneralException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class CreateWeeklyPlanValidatorImplTest {

    private CreateWeeklyPlanValidatorImpl validator;

    @Before
    public void init (){
        validator = new CreateWeeklyPlanValidatorImpl();
    }
    @Test
    public void validate() {
        WeeklyPlanRecipeResource recipe = new WeeklyPlanRecipeResource();
        recipe.setRecipeId(100);
        List<WeeklyPlanRecipeResource> recipeList = new ArrayList<>();
        recipeList.add(recipe);

        WeeklyPlanPeriodRecipeResource PRResource1 = new WeeklyPlanPeriodRecipeResource();
        PRResource1.setPeriodId(2);
        PRResource1.setWeeklyPlanRecipes(recipeList);
        List<WeeklyPlanPeriodRecipeResource> periodRecipeResources = new ArrayList<>();
        periodRecipeResources.add(PRResource1);

        WeeklyPlanResource resource = new WeeklyPlanResource();
        resource.setUserId(30);
        resource.setLayoutId(1);
        resource.setWeeklyPlanPeriodRecipes(periodRecipeResources);

        validator.validate(resource);
    }

    @Test (expected = GeneralException.class)
    public void validateException() {
        List<WeeklyPlanPeriodRecipeResource> periodRecipeResources = new ArrayList<>();

        WeeklyPlanResource resource = new WeeklyPlanResource();
        resource.setUserId(30);
        resource.setLayoutId(1);
        resource.setWeeklyPlanPeriodRecipes(periodRecipeResources);

        validator.validate(resource);
    }
}