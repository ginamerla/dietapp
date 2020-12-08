package com.tortu.api.daos;

import com.tortu.api.models.Ingrediente;

public interface IngredienteDao extends GenericDao<Ingrediente, Integer> {
    public static final String FIND_ALL =
            "select * from ingrediente";
    public static final String FINDBYID =
            "select * from ingrediente where id_ingrediente=?";
    public static final String SAVE =
            "insert into ingrediente (nombre, id_categoria_ingrediente) values ('test', ?)";
    public static final String UPDATE =
            "update ingredientes set nombre = ?, id_categoria_ingrediente = ? where id_ingrediente = ?";
    public static final String DELETE =
            "delete from ingrediente where id_ingrediente = ?";
}
