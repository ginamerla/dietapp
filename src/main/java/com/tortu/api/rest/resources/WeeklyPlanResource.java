package com.tortu.api.rest.resources;

import java.util.List;

/**
 * Representa el recurso (REST)para crear un nuevo weekly plan
 */
public class WeeklyPlanResource {
    private Integer userId;
    private Integer layoutId;
    private List<WeeklyPlanPeriodRecipeResource> weeklyPlanPeriodRecipes;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(Integer layoutId) {
        this.layoutId = layoutId;
    }

    public List<WeeklyPlanPeriodRecipeResource> getWeeklyPlanPeriodRecipes() {
        return weeklyPlanPeriodRecipes;
    }

    public void setWeeklyPlanPeriodRecipes(List<WeeklyPlanPeriodRecipeResource> weeklyPlanPeriodRecipes) {
        this.weeklyPlanPeriodRecipes = weeklyPlanPeriodRecipes;
    }
}
