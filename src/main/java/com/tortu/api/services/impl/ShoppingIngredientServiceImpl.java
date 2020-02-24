package com.tortu.api.services.impl;

import com.tortu.api.daos.ShoppingIngredientDao;
import com.tortu.api.dto.ShoppingIngredientDTO;
import com.tortu.api.services.ShoppingIngredientService;
import com.tortu.api.utils.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementacion del servicio de lista de compras de ingredientes
 */
@Service
public class ShoppingIngredientServiceImpl implements ShoppingIngredientService {

    public static final Logger LOG= LoggerFactory.getLogger(ShoppingIngredientServiceImpl.class);
    @Autowired
    private ShoppingIngredientDao shoppingIngredientDao;


    @Override
    public List<ShoppingIngredientDTO> findUserShoppingList(Integer userId) {
        LOG.info(String.format("Consultando la lista de compras del usuario: %d", userId));
        if(userId==null){
            LOG.error("userId is null");
            throw new GeneralException("El id del usuario es nulo");
        }
        return shoppingIngredientDao.getShoppingList(userId);
    }
}
