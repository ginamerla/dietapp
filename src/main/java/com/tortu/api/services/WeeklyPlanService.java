package com.tortu.api.services;

import com.tortu.api.rest.resources.WPWeekDayResultResource;
import com.tortu.api.rest.resources.WeeklyPlanResource;
import com.tortu.api.utils.GeneralException;

import java.util.List;

/**
 * Interface con los servicios de WeeklyPlan
 */
public interface WeeklyPlanService {
    /**
     * Crea el plan semanal del usuario
     * @param weeklyPlanResource Recurso que contiene la informacion del usuario, layout y recetas por periodo
     * @throws GeneralException
     */
    void saveWeeklyPlan(WeeklyPlanResource weeklyPlanResource) throws GeneralException;

    /**
     * Obtiene el plan semanal del usuario
     * @param userId id del usuario
     * @throws GeneralException
     */
    List<WPWeekDayResultResource> getWeeklyPlan(Integer userId) throws GeneralException;
}
