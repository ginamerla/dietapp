package com.tortu.api.daos.impl;

import com.tortu.api.daos.ShoppingIngredientDao;
import com.tortu.api.daos.mappers.ShoppingIngredientDTORowMapper;
import com.tortu.api.dto.ShoppingIngredientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Capa de acceso a la BD
 * Consulta la informacion de los ingredientes necesarios para las recetas de la semana de un solo usuario
 */
@Component
public class ShoppingIngredientDaoImpl implements ShoppingIngredientDao {

    public static final Logger LOG = LoggerFactory.getLogger(ShoppingIngredientDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ShoppingIngredientDTO> getShoppingList(Integer userId) {
        // jdbc template - usar DTO aqui para mapear y regresar una lista de DTO
        LOG.info(String.format("Obteniendo lista de compras para usuario: %d", userId));
        return jdbcTemplate.query(FIND_SHOPPINGINGREDIENT, new ShoppingIngredientDTORowMapper(), userId);
    }
}
