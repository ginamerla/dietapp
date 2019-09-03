package com.tortu.api.daos;

import com.tortu.api.models.RecetaIngrediente;

public interface RecetaIngredienteDao extends GenericDao<RecetaIngrediente,Integer> {
    public static final String FIND_ALL =
            "select * from receta_ingrediente" +
                    "inner join receta on receta_ingrediente.id_receta=receta.id_receta" +
                    "inner join ingrediente on receta_ingrediente.id_ingrediente = ingrediente.id_ingrediente" +
                    "inner join medida on receta_ingrediente.id_medida = medida.id_medida";
    public static final String FINDBYID =
            "select * from receta_ingrediente" +
                    "inner join receta on receta_ingrediente.id_receta=receta.id_receta" +
                    "inner join ingrediente on receta_ingrediente.id_ingrediente = ingrediente.id_ingrediente" +
                    "inner join medida on receta_ingrediente.id_medida = medida.id_medida"+
                    "where id_receta_ingrediente=?";
    public static final String SAVE =
            "insert into receta_ingrediente (id_receta_ingrediente, cantidad, id_receta, id_medida,id_ingrediente) values (?, ?, ?,?,?)";
    public static final String UPDATE =
            "update receta_ingrediente set cantidad = ?, id_receta = ?, id_medida=?, id_ingrediente=? where id_receta_ingrediente = ?";
    public static final String DELETE =
            "delete from receta_ingrediente where id_receta_ingrediente = ?";
}
