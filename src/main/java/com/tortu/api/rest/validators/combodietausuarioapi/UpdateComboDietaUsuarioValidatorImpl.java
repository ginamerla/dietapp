package com.tortu.api.rest.validators.combodietausuarioapi;

import com.tortu.api.models.ComboDietaUsuario;
import com.tortu.api.rest.validators.GenericValidator;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Valida la informacion de ComboDietaUsuario al actualizar
 */
@Component("updateComboDietaUsuarioValidator")
public class UpdateComboDietaUsuarioValidatorImpl implements GenericValidator<ComboDietaUsuario> {
    private static final Logger LOG = LoggerFactory.getLogger(UpdateComboDietaUsuarioValidatorImpl.class);

    /**
     * Al actualizar un ComboDietaUsuario ninguno de sus campos pueden ser vacios/nulos
     * @param modelo
     * @throws GeneralException
     */
    @Override
    public void validate(ComboDietaUsuario modelo) throws GeneralException {
        if(modelo==null){
            LOG.error("ComboDietaUsuario es nulo");
            throw new GeneralException("El ComboDetaUsuario que se quiere crear es nulo");
        }
        if(modelo.getIdComboDietaUsuario()==null){
            LOG.error("id" +
                    "idComboDietaUsuario es nulo");
            throw new GeneralException("El ID_COMBO_DIETA_USUARIO del ComboDetaUsuario que se quiere crear es nulo");
        }
        if(modelo.getIdDietaUsuario()==null){
            LOG.error("idDietaUsuario es nulo");
            throw new GeneralException("El ID_DIETA_USUARIO del ComboDetaUsuario que se quiere crear es nulo");
        }
        if(modelo.getIdRecetaPeriodo()==null){
            LOG.error("idRecetaPeriodo  es nulo");
            throw new GeneralException("El ID_RECETA_PERIODO del ComboDetaUsuario que se quiere crear es nulo");
        }
    }
}
