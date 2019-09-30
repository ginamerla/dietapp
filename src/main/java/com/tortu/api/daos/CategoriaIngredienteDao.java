package com.tortu.api.daos;

import com.tortu.api.models.CategoriaIngrediente;

/**
 * Interface que contiene los queries de la tabla categoria_ingrediente
 */
public interface CategoriaIngredienteDao extends GenericDao<CategoriaIngrediente, Integer>{

    public static final String FIND_ALL =
            "select * from categoria_ingrediente";
    public static final String FINDBYID =
            "select * from categoria_ingrediente where id_categoria_ingrediente=?";
    public static final String SAVE =
            "insert into categoria_ingrediente (nombre) values (?)";
    public static final String UPDATE =
            "update categoria_ingrediente set nombre = ? where id_categoria_ingrediente = ?";
    public static final String DELETE =
            "delete from categoria_ingrediente where id_categoria_ingrediente = ?";

}
