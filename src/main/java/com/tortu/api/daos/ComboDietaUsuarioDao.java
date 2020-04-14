package com.tortu.api.daos;

import com.tortu.api.models.ComboDietaUsuario;

import java.util.List;

public interface ComboDietaUsuarioDao extends GenericDao<ComboDietaUsuario, Integer> {
    public static final String FIND_ALL =
            "select * from combo_dieta_usuario";
    public static final String FINDBYID =
            "select * from combo_dieta_usuario where id_combo_dieta_usuario = ?";
    public static final String SAVE =
            "insert into combo_dieta_usuario (id_dieta_usuario, id_receta_periodo) values (?, ?)";
    public static final String UPDATE =
            "update combo_dieta_usuario set id_dieta_usuario = ?, id_receta_periodo = ? where id_combo_dieta_usuario = ?";
    public static final String DELETE =
            "delete from combo_dieta_usuario where id_combo_dieta_usuario = ?";

    public static final String FIND_ID_LIST_BY_DIETA_USUARIO =
            "select id_combo_dieta_usuario from combo_dieta_usuario where id_dieta_usuario in (:ids)";

    /**
     * Obtiene la lista de Ids en COMBO_DIETA_USUARIO que corresponden a los id_dieta_usuario enviados
     * @param dietaUsuarioIdList lista de ids de dieta_usuario
     * @return lista de ids de combo_dieta_usuario encontrados
     */
    List<Integer> findComboDietaUsuarioIdListByDietaUsuario(List<Integer> dietaUsuarioIdList);

}
