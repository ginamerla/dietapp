package com.tortu.api.daos;

import com.tortu.api.utils.GeneralException;

import java.util.List;

/**
 * @param <T> modelo a manipular en la BD
 * @param <K> Llave o id unico de la entidad
 */
public interface GenericDao<T, K> {

    /**
     * Crea una nueva entidad
     * @param model
     * @throws GeneralException
     * @return
     */
    int save(T model) throws GeneralException;

    /**
     * Actualiza los datos de la entidad
     * @param model
     * @throws GeneralException
     */
    void update(T model) throws GeneralException;

    /**
     * Elimina
     * @param id
     * @throws GeneralException
     */
    void delete(K id) throws GeneralException;

    /**
     * Consulta todos los datos del modelo proporcionado
     * @param id
     * @return el modelo
     * @throws GeneralException
     */
    T findByiD(K id) throws GeneralException;

    /**
     * Obtener todos los datos de la entidad
     * @return lista de modelos
     * @throws GeneralException
     */
    List<T> findAll() throws GeneralException;
}
