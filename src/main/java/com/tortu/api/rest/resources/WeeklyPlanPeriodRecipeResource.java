package com.tortu.api.rest.resources;

import java.util.List;

public class WeeklyPlanPeriodRecipeResource {
    private Integer periodId;
    private List<WeeklyPlanRecipeResource> weeklyPlanRecipes;

    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    public List<WeeklyPlanRecipeResource> getWeeklyPlanRecipes() {
        return weeklyPlanRecipes;
    }

    public void setWeeklyPlanRecipes(List<WeeklyPlanRecipeResource> weeklyPlanRecipes) {
        this.weeklyPlanRecipes = weeklyPlanRecipes;
    }
}
