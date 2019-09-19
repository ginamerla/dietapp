package com.tortu.api.services;

import com.tortu.api.models.Receta;
import com.tortu.api.utils.GeneralException;

import java.util.List;

/**
 * Interface para el servicio del modelo Receta
 */
public interface RecetaService {

    /**
     * Guarda la receta enviada y regresa la misma informacion
     * @param receta nueva que se debe guardar
     * @return la nueva receta guardada
     * @throws GeneralException
     */
    Receta saveReceta(Receta receta) throws GeneralException;

    /**
     * Actualiza la informacion de la receta
     * @param receta con la informacion a actualizar
     * @return la receta actualizada
     * @throws GeneralException
     */
    Receta updateReceta(Receta receta) throws GeneralException;

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

}
