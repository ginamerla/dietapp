package com.tortu.api.daos;

import com.tortu.api.models.RecetaPeriodo;

import java.util.Collection;
import java.util.List;

public interface RecetaPeriodoDao extends GenericDao <RecetaPeriodo,Integer> {
    public static final String FIND_ALL =
            "select * from receta_periodo";
    public static final String FINDBYID =
            "select * from receta_periodo where id_receta_periodo=?";
    public static final String SAVE =
            "insert into receta_periodo (id_receta, id_periodo) values (?, ?)";
    public static final String UPDATE =
            "update receta_periodo set id_receta = ?, id_periodo = ? where id_receta_periodo = ?";
    public static final String DELETE =
            "delete from receta_periodo where id_receta_periodo = ?";

    public static final String FIND_ID_LIST_BY_PERIODO_RECETA =
            "select id_receta_periodo from receta_periodo where id_receta  in (:ids) and id_periodo = :periodId";

    /**
     * Obtiene la lista de IDs en RECETA_PERIODO que contengan los idReceta y el idPeriodo enviados
     * @param periodId id del periodo
     * @param recipeIdList lista de id de recetas
     * @return lista de ids encontrados
     */
    List<Integer> findRecetaPeriodoIdListByPeriodoReceta(Integer periodId, List<Integer> recipeIdList);

}
