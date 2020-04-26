package com.tortu.api.daos;

import com.tortu.api.dto.ShoppingIngredientDTO;
import com.tortu.api.dto.WPIngredientResultDTO;
import com.tortu.api.dto.WPResultDTO;

import java.util.List;

public interface CommonDao {

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

    public static final String FIND_WEEKLYPLAN_BY_USER = "select du.dia_semana,   p.periodo, r.nombre, r.id_receta \n" +
            "from  combo_dieta_usuario cdu\n" +
            "inner join dieta_usuario du on du.id_dieta_usuario = cdu.id_dieta_usuario\n" +
            "inner join receta_periodo rp on cdu.id_receta_periodo = rp.id_receta_periodo\n" +
            "inner join receta r on rp.id_receta = r.id_receta\n" +
            "inner join periodo p on rp.id_periodo=p.id_periodo\n" +
            "where du.id_usuario = ?\n" +
            "order by FIELD(du.dia_semana , \"lunes\", \"martes\", \"miercoles\", \"jueves\", \"viernes\", \"sabado\",\"domingo\");";

    public static final String FIND_INGREDIENTS_BY_RECIPE = "select r.nombre as 'Receta' , i.nombre as 'Ingrediente', ri.cantidad , m.medida as 'Medida'\n" +
            "from receta_ingrediente ri \n" +
            "inner join receta r on ri.id_receta = r.id_receta\n" +
            "inner join ingrediente i on ri.id_ingrediente = i.id_ingrediente\n" +
            "inner join medida m on ri.id_medida = m.id_medida \n" +
            "where ri.id_receta = ?;";

    /**
     * Obtiene la lista de ingredientes para las recetas de la semana de un usario
     * @param userId el id del usuario que va a consultar su lista de compras
     * @return lista de ingredientes necesarios para las recetas de la semana
     */
    public List<ShoppingIngredientDTO> getShoppingList(Integer userId);

    /**
     * Obtener el plan semanal de un usuario (dias de la semana y recetas por periodo) (DBQWPR01)
     * @param userId id del usuario
     * @return lista de WPResultDTO
     */
    public List<WPResultDTO> getWeeklyPlanByUser(Integer userId);

    /**
     * Obtiene la lista de ingredientes de una receta (DBQWPRI1R01)
     * @param recipeId id de la receta de la que se van a obtener los ingredientes
     * @return lista de WPIngredientResultDTO
     */
    public List<WPIngredientResultDTO> getRecipeIngredients(Integer recipeId);


}
