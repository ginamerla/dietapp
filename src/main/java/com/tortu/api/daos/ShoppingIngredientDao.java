package com.tortu.api.daos;

import com.tortu.api.dto.ShoppingIngredientDTO;

import java.util.List;

public interface ShoppingIngredientDao {
    /**
     * -- Lista de compras (ingredientes TOTALES) para la semana
     * select sum(ri.cantidad) as 'Cantidad' ,m.medida , i.id_ingrediente , i.nombre as 'Ingrediente', ci.nombre as'Categoria'
     * from  combo_dieta_usuario cdu
     * inner join dieta_usuario du on cdu.id_dieta_usuario =du.id_dieta_usuario
     * inner join receta_periodo rp on cdu.id_receta_periodo = rp.id_receta_periodo
     * inner join receta r on rp.id_receta =r.id_receta
     * inner join receta_ingrediente ri on r.id_receta =ri.id_receta
     * inner join medida m on ri.id_medida =m.id_medida
     * inner join ingrediente i on ri.id_ingrediente =i.id_ingrediente
     * inner join categoria_ingrediente ci on i.id_categoria_ingrediente =ci.id_categoria_ingrediente
     * where du.id_usuario = 4
     * group by m.medida , i.nombre
     * order by ci.nombre, i.nombre ;
     */
    public static final String FIND_SHOPPINGINGREDIENT = "select sum(ri.cantidad) as 'Cantidad' ,m.medida , i.id_ingrediente , i.nombre as 'Ingrediente', ci.nombre as'Categoria'\n" +
            "from  combo_dieta_usuario cdu\n" +
            "inner join dieta_usuario du on cdu.id_dieta_usuario =du.id_dieta_usuario \n" +
            "inner join receta_periodo rp on cdu.id_receta_periodo = rp.id_receta_periodo\n" +
            "inner join receta r on rp.id_receta =r.id_receta \n" +
            "inner join receta_ingrediente ri on r.id_receta =ri.id_receta \n" +
            "inner join medida m on ri.id_medida =m.id_medida \n" +
            "inner join ingrediente i on ri.id_ingrediente =i.id_ingrediente \n" +
            "inner join categoria_ingrediente ci on i.id_categoria_ingrediente =ci.id_categoria_ingrediente \n" +
            "where du.id_usuario = ?\n" +
            "group by m.medida , i.nombre \n" +
            "order by ci.nombre, i.nombre";

    /**
     * Obtiene la lista de ingredientes para las recetas de la semana de un usario
     * @param userId el id del usuario que va a consultar su lista de compras
     * @return lista de ingredientes necesarios para las recetas de la semana
     */
    public List<ShoppingIngredientDTO> getShoppingList(Integer userId);
}
