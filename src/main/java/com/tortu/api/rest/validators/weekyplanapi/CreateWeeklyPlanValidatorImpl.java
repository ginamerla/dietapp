package com.tortu.api.rest.validators.weekyplanapi;

import com.tortu.api.rest.resources.WeeklyPlanPeriodRecipeResource;
import com.tortu.api.rest.resources.WeeklyPlanRecipeResource;
import com.tortu.api.rest.resources.WeeklyPlanResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * Valida los datos para crear un nuevo WeeklyPlan
 */
@Component("createWeeklyPlanValidatorImpl")
public class CreateWeeklyPlanValidatorImpl implements GenericValidator<WeeklyPlanResource> {
    /**
     * Al crear un weelyPlan se debe validar:
        * userId no debe estar vacio/nulo
        * layoutId no sebe ser vacio/nulo
        * lista weeklyPlanPeriodRecipes no debe ser vacia/nula, debe tener 3 o 5 elementos (periodos default)
        * lista weeklyPlanPeriodRecipes no debe tener elementos vacios/nulos
     * @param modelo lista de objetos a validar
     * @throws GeneralException
     */
    @Override
    public void validate(WeeklyPlanResource modelo) throws GeneralException {
        // validar userId no sea nulo/vacio
        if(modelo.getUserId()==null){
            throw new GeneralException("El id del usuario es nulo");
        }
        // Validar layoutId no sea nulo/vacio
        if(modelo.getLayoutId()==null){
            throw new GeneralException("El id del layout es nulo");
        }
        //validar lista weeklyPlanPeriodRecipes no sea nula/vacia
        if(modelo.getWeeklyPlanPeriodRecipes()==null || modelo.getWeeklyPlanPeriodRecipes().isEmpty()){
            throw new GeneralException("La lista weeklyPlanPeriodRecipes es nula o vacia");
        }
        //Validar cada elemento de la lista (day)
        for(WeeklyPlanPeriodRecipeResource period: modelo.getWeeklyPlanPeriodRecipes()){
            validateWeeklyPlanPeriodRecipe(period);
        }

    }

    /**
     * Valida que las propiedades de WeeklyPlanPeriodRecipeResource no sean nulas o vacias
     * @param period WeeklyPlanPeriodRecipeResource a validar
     */
    private void validateWeeklyPlanPeriodRecipe(WeeklyPlanPeriodRecipeResource period){
        if (period.getPeriodId() == null) {
        throw new GeneralException("El id del periodo es nulo");
        }
        if(CollectionUtils.isEmpty(period.getWeeklyPlanRecipes()) ){
            throw new GeneralException(" la lista WeeklyPlanRecipes es nula/vacia");
        }
        for (WeeklyPlanRecipeResource recipe : period.getWeeklyPlanRecipes()){
            validateWeeklyPlanRecipe(recipe);
        }
    }

    /**
     * Valida que las propiedades de WeeklyPlanPeriodRecipeResource no sean nulas o vacias
     * @param recipe WeeklyPlanPeriodRecipeResource a validar
     */
    private void validateWeeklyPlanRecipe(WeeklyPlanRecipeResource recipe){
        if(recipe.getRecipeId()==null){
            throw new GeneralException("El id de la receta es nulo");
        }

    }
}
