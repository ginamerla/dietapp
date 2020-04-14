package com.tortu.api.services;

import com.tortu.api.models.ComboDietaUsuario;
import com.tortu.api.utils.GeneralException;

import java.util.List;

/**
 * Interface de los servicios de ComboDietaUsuario
 */
public interface ComboDietaUsuarioService {
    /**
     * Agrega un nuevo ComboDietaUsuario
     * @param comboDietaUsuario con la informacion nueva a guardar
     * @throws GeneralException cuando no se pudo guardar correctamente
     */
    void saveComboDietaUsuario(ComboDietaUsuario comboDietaUsuario) throws GeneralException;

    /**
     * Actualiza la informacion de ComboDietaUsuario
     * @param comboDietaUsuario con la informacion a actualizar
     * @throws GeneralException cuando no se pudo actualizar correctamente
     */
    void updateComboDietaUsuario (ComboDietaUsuario comboDietaUsuario) throws GeneralException;

    /**
     * Elimina el ComboDietaUsuario con el id enviado
     * @param idComboDietaUsuario id del ComboDietaUsuario que se quiere eliminar
     * @throws GeneralException cuando no se pudo eliminar correctamente
     */
    void deleteComboDietaUsuario(Integer idComboDietaUsuario) throws GeneralException;

    /**
     * Consulta la informacion del ComboUsuario con el id enviado
     * @param idComboDietaUsario id del ComboUsuario que se quiere consultar
     * @return el objeto encontrado con el id enviado
     * @throws GeneralException cuando no se pudo encontrar el objeto con el id enviado
     */
    ComboDietaUsuario findComboDietaUsuario(Integer idComboDietaUsario) throws GeneralException;

    /**
     * Consulta los ComboDietaUsuario existentes
     * @return una lista con los objetos encontrados
     */
    List<ComboDietaUsuario> findAllComboDietaUsuario();

    /**
     * Consulta la lista de IDs de combo_dieta_usuario que contengan los id_dieta_usuario de la lista enviada
     * @param dietaUsuarioIdList lista con id_dieta_usuario a consultar
     * @return lista de IDs combo_dieta_usuario encontrada
     * @throws GeneralException
     */
    List<Integer> getComboDietaUsuarioIdsByDietaUsuario(List<Integer> dietaUsuarioIdList) throws GeneralException;

}
