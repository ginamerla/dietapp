package com.tortu.api.services;

import com.tortu.api.models.RecetaIngrediente;
import com.tortu.api.utils.GeneralException;

import java.util.List;

/**
 * Interface de los servicios para RecetaIngrediente
 */
public interface RecetaIngredienteService {
    /**
     * Guarda la informacion de una nueva RecetaIngrediente
     * @param recetaIngrediente con la informacion nueva a guardar
     * @throws GeneralException cuando no se pudo guardar
     */
    void saveRecetaIngrediente(RecetaIngrediente recetaIngrediente) throws GeneralException;

    /**
     * Actualiza la informacion de RecetaIngreidente
     * @param recetaIngrediente con la informacion a actualizar
     * @throws GeneralException cuando no se pudo actualizar
     */
    void updateRecetaIngrediente(RecetaIngrediente recetaIngrediente)throws GeneralException;

    /**
     * Elimina la RecetaIngrediente con el id enviado
     * @param idRecetaIngredente id de la recetaIngrediente que se quiere eliminar
     * @throws GeneralException cuando no se pudo eliminar la recetaIngrediente
     */
    void deleteRecetaIngrediente(Integer idRecetaIngredente)throws GeneralException;

    /**
     * Consulta la informacion de RecetaIngrediente con el Id enviado
     * @param idRecetaIngrediente id de la recetaIngrediente que se quiere consultar
     * @return el objeto encontrado
     * @throws GeneralException cuando no se pudo realizar la consulta
     */
    RecetaIngrediente findRecetaIngrediente(Integer idRecetaIngrediente)throws GeneralException;

    /**
     * Consulta todas las RecetasIngredientes existentes
     * @return lista con los objetos encontrados
     */
    List<RecetaIngrediente> findAllRecetaIngrediente();
}
