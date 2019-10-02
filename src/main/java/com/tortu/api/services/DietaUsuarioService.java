package com.tortu.api.services;

import com.tortu.api.models.DietaUsuario;
import com.tortu.api.utils.GeneralException;

import java.util.List;

/**
 * Interface de los servicios para Dieta_Usuario
 */
public interface DietaUsuarioService {
    /**
     * Guarda una nueva DIETA_USUARIO y regresa el objeto guardado
     * @param dietaUsuario que se va a guardar/crear
     * @throws GeneralException
     */
    void saveDietaUsuario(DietaUsuario dietaUsuario) throws GeneralException;

    /**
     * Actualiza la informacion de la dieta_usuario con el id enviado
     * @param dietaUsuario con la informacion a actualizar
     * @throws GeneralException
     */
    void updateDietaUsuario(DietaUsuario dietaUsuario) throws GeneralException;

    /**
     * Consulta la dieta_usuario con el id enviado
     * @param idDietaUsuario id de la dieta_usuario a consultar
     * @return la dieta_usuario encontrada
     * @throws GeneralException
     */
    DietaUsuario findDietaUsuario(Integer idDietaUsuario) throws GeneralException;

    /**
     * Consulta todas las dieta_usuarios existentes
     * @return una lista con los objetos dieta_usuario encontrados
     */
    List<DietaUsuario> findAllDietaUsuario();

    /**
     * Elimina la dieta_usuario con el id enviado
     * @param idDietaUsuario id de la dieta_usuario a eliminar
     * @throws GeneralException
     */
    void deleteDietaUsuario(Integer idDietaUsuario) throws GeneralException;
}
