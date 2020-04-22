package com.tortu.api.services;

import com.tortu.api.models.RecetaPeriodo;
import com.tortu.api.utils.GeneralException;

import java.util.List;

/**
 * Interface de los servicios para el modelo Receta_Periodo
 */
public interface RecetaPeriodoService {
    /**
     * Guarda la informacion de un nuevo RecetaPeriodo
     * @param recetaPeriodo que se va a guardar
     * @throws GeneralException si no se pudo guardar
     */
    void saveRecetaPeriodo (RecetaPeriodo recetaPeriodo) throws GeneralException;

    /**
     * Actualiza la informacion de una Receta_Periodo
     * @param recetaPeriodo con la informacion a actualizar
     * @throws GeneralException cuando no se pudo actualizar el objeto
     */
    void updateRecetaPeriodo (RecetaPeriodo recetaPeriodo) throws GeneralException;

    /**
     * Elimina la Receta_Periodo con el id proporcionado
     * @param idRecetaPeriodo id de la receta_periodo que se quiere eliminar
     * @throws GeneralException cuando no se pudo eliminar el objeto
     */
    void deleteRecetaPeriodo(Integer idRecetaPeriodo) throws GeneralException;

    /**
     * Consulta la informacion de un Receta_Periodo con el id proporcionado
     * @param idRecetaPeriodo id del receta_periodo que se quiere consultar
     * @return el objeto encontrado con el id proporcionado
     * @throws GeneralException cuando no se pudo encontrar ningun objeto
     */
    RecetaPeriodo findRecetaPeriodo (Integer idRecetaPeriodo) throws GeneralException;

    /**
     * Consulta todos los Receta_Periodo existentes
     * @return lista con los objetos encontrados
     */
    List<RecetaPeriodo> findAllRecetaPeriodo();

    /**
     * Obtiene la lista de ids de RECETA_PERIODO para las recetas y periodo enviados.
     * @param periodId id del periodo de la lista de recetas
     * @param recipeIdList lista con id de recetas
     * @return lista de ids de RECETA_PERIODO
     * @throws GeneralException
     */
    List<Integer> getRecetaPeriodoIdList(Integer periodId, List<Integer> recipeIdList) throws GeneralException;
}
