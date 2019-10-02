package com.tortu.api.services;

import com.tortu.api.models.Ingrediente;
import com.tortu.api.utils.GeneralException;

import java.util.List;

/**
 * Interface para el servicio de Ingrediente
 */
public interface IngredienteService {
    /**
     * Crea un nuevo ingrediente
     * @param ingrediente
     * @throws GeneralException
     */
    void saveIngrediente(Ingrediente ingrediente) throws GeneralException;

    /**
     * Actualiza la informacion del ingrediente
     * @param ingrediente
     * @throws GeneralException
     */
    void updateIngrediente(Ingrediente ingrediente) throws GeneralException;

    /**
     * Obtiene el ingrediente con el id proporcionado
     * @param id
     * @return
     * @throws GeneralException
     */
    Ingrediente findIngrediente(Integer id) throws GeneralException;

    /**
     * Obtiene todos los ingredientes existentes
     * @return
     */
    List<Ingrediente> findAllIngredientes();

    /**
     * Elimina el ingrediente con el id enviado
     * @param id
     * @throws GeneralException
     */
    void deleteIngrediente(Integer id) throws GeneralException;
}
