package com.tortu.api.services;

import com.tortu.api.models.Receta;
import com.tortu.api.rest.resources.RecipeCompleteResource;
import com.tortu.api.utils.GeneralException;

import java.util.List;

/**
 * Interface para el servicio del modelo Receta
 */
public interface RecetaService {

    /**
     * Guarda la receta enviada y regresa la misma informacion
     * @param receta nueva que se debe guardar
     * @return id de la receta guardada
     * @throws GeneralException
     */
    int saveReceta(Receta receta) throws GeneralException;

    /**
     * Actualiza la informacion de la receta
     * @param receta con la informacion a actualizar
     * @throws GeneralException
     */
    void updateReceta(Receta receta) throws GeneralException;

    /**
     * Busca la receta con el id enviado
     * @param idReceta id de la receta a buscar
     * @return la receta encontrada con ese id
     * @throws GeneralException
     */
    Receta findReceta(Integer idReceta) throws GeneralException;

    /**
     * Consulta todas las recetas
     * @return lista de recetas encontradas
     */
    List<Receta> findAllRecetas();

    /**
     * Elimina la receta con el id enviado
     * @param idReceta id de la receta a eliminar
     * @throws GeneralException
     */
    void deleteReceta(Integer idReceta) throws  GeneralException;

    /**
     * Crea una receta nueva completa con ingredientes, medidas y cantidades
     * @param recipe recurso con la informacion necesaria
     * @throws GeneralException
     */
    void saveRecipeComplete(RecipeCompleteResource recipe) throws GeneralException;

}
