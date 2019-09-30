package com.tortu.api.services;

import com.tortu.api.models.LayoutPeriodo;
import com.tortu.api.utils.GeneralException;

import java.util.List;

/**
 * Interface para los servicios de LayoutPeriodo
 */
public interface LayoutPeriodoService {
    /**
     * Guarda un nuevo LayoutPeriodo
     * @param layoutPeriodo
     * @throws GeneralException
     */
    void saveLayoutPeriodo(LayoutPeriodo layoutPeriodo) throws GeneralException;

    /**
     * Actualiza la informacion de un LayoutPeriodo
     * @param layoutPeriodo
     * @throws GeneralException
     */
    void updateLayoutPeriodo(LayoutPeriodo layoutPeriodo)throws GeneralException;

    /**
     * Elimina el LayoutPeriodo con el id enviado
     * @param id del LayoutPeriodo a Eliminar
     * @throws GeneralException
     */
    void deleteLayoutPeriodo(Integer id)throws GeneralException;

    /**
     * Consulta la informacion del LayoutPeriodo con el id enviado
     * @param id del LayoutPeriodo que se quiere consultar
     * @return el objeto encontrado
     * @throws GeneralException
     */
    LayoutPeriodo findLayoutPeriodo(Integer id) throws GeneralException;

    /**
     * Consulta todos los layoutPeriodo existentes
     * @return lista con los objetos encontrados
     */
    List<LayoutPeriodo> findAllLayoutPeriodo();
}
