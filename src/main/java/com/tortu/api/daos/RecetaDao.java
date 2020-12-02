package com.tortu.api.daos;

import com.tortu.api.models.Receta;
import com.tortu.api.utils.GeneralException;

import java.util.List;

public interface RecetaDao extends GenericDao<Receta, Integer> {
    public static final String FIND_ALL =
            "select * from receta";
    public static final String FINDBYID =
            "select * from receta where id_receta=?";
    public static final String SAVE =
            "insert into receta (nombre) values (?)";
    public static final String UPDATE =
            "update receta set nombre = ? where id_receta = ?";
    public static final String DELETE =
            "delete from receta where id_receta = ?";
    public static final String FIND_RECIPE_BY_NAME =
            "select * from receta where nombre like ?";

    public List<Receta> findRecipeByName(String name) throws GeneralException;
}
