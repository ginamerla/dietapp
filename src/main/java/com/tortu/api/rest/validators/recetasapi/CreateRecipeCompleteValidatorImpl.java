package com.tortu.api.rest.validators.recetasapi;

import com.tortu.api.rest.resources.RecipeCompleteResource;
import com.tortu.api.rest.resources.RecipeIngredientResource;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * Valida las propiedades del modelo para crear una nueva receta completa
 */
@Component("createRecipeCompleteValidator")
public class CreateRecipeCompleteValidatorImpl implements GenericValidator<RecipeCompleteResource> {
    /**
     * Para crear una nueva receta completa no debe tener propiedades vacias
     * @param modelo la receta completa que se va a guardar
     * @throws GeneralException cuando alguna propiedad es vacia/nula
     */
    @Override
    public void validate(RecipeCompleteResource modelo) throws GeneralException {
        if(modelo==null){
            throw new GeneralException("RecipeCompleteResource is null");
        }
        if(StringUtils.isBlank(modelo.getRecipeName())){
            throw new GeneralException("El nombre de la receta es nulo/vacio");
        }
        if(modelo.getPeriodId()==null){
            throw new GeneralException("El id del periodo es nulo");
        }
        if(CollectionUtils.isEmpty(modelo.getIngredientResourceList())){
            for(RecipeIngredientResource ri: modelo.getIngredientResourceList()){
                if(ri.getItemId()==null){
                    throw new GeneralException("El ingrediente es nulo");
                }
                if(ri.getQuantity()==null){
                    throw new GeneralException("La cantidad es nula");
                }
                if(ri.getUnitId()==null){
                    throw new GeneralException("La medida es nula");
                }
            }
        }
    }
}
