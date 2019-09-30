package com.tortu.api.services;

import com.tortu.api.models.UsuarioLayout;
import com.tortu.api.utils.GeneralException;

import java.util.List;

/**
 * Interface de los servicios de UsuarioLayout
 */
public interface UsuarioLayoutService {
    /**
     * Crea un nuevo UsuarioLayout
     * @param usuarioLayout
     * @throws GeneralException
     */
    void saveUsuarioLayout(UsuarioLayout usuarioLayout) throws GeneralException;

    /**
     * Actualiza el UsuarioLayout
     * @param usuarioLayout
     * @throws GeneralException
     */
    void updateUsuarioLayout(UsuarioLayout usuarioLayout) throws GeneralException;

    /**
     * Cosulta el UsuarioLayout con el id proporcionado
     * @param idUsuarioLayout
     * @return el UsuarioLayout encontrado con ese id
     * @throws GeneralException
     */
    UsuarioLayout findUsuarioLayout(Integer idUsuarioLayout) throws GeneralException;

    /**
     * Consulta todos los UsuarioLayot existentes
     * @return lista de los objetos encontrados
     */
    List<UsuarioLayout> findAllUsuarioLayout();

    /**
     * Elimina el UsuarioLayout con el id proporcionado
     * @param idUsuarioLayout que se va a eliminar
     * @throws GeneralException
     */
    void deleteUsuarioLayout(Integer idUsuarioLayout) throws GeneralException;

}
