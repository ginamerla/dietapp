package com.tortu.api.services;

import com.tortu.api.dto.ShoppingIngredientDTO;

import java.util.List;

/**
 * Interface del servicio de lista de compras
 */
public interface ShoppingIngredientService {
    /**
     * Obtiene la lista de compras de la semana para el usuario indicado
     * @param userId id del usuario
     * @return lista de ingredientes para las recetas de la semana
     */
    List<ShoppingIngredientDTO> findUserShoppingList(Integer userId);

}
