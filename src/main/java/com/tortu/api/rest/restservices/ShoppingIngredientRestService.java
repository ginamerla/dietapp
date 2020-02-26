package com.tortu.api.rest.restservices;

import com.tortu.api.dto.ShoppingIngredientDTO;
import com.tortu.api.rest.mappers.ShoppingIngredientResourceMapper;
import com.tortu.api.rest.resources.ShoppingIngredientResource;
import com.tortu.api.services.ShoppingIngredientService;
import com.tortu.api.utils.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador de ShoppingIngredient
 * Consulta los ingredientes necesarios para las recetas de una semana de un usuario
 * Regresa la lista de compras de un usuario
 */
@Service
@Path("/shoppinglists")
public class ShoppingIngredientRestService {
    @Autowired
    private ShoppingIngredientService shoppingIngredientService;
    @Autowired
    private ShoppingIngredientResourceMapper mapper;

    /**
     * Consulta los ingredientes para las recetas de una semana del usuario
     * @param userId id del usuario
     * @return lista de compras con los ingredientes y cantidades necesarias para las recetas de la semana
     */
    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShoppingList(@PathParam("userId") Integer userId){
        if(userId==null){
            throw new GeneralException("El id del usuario es nulo");
        }
        List<ShoppingIngredientDTO> dtoShoppingList = shoppingIngredientService.findUserShoppingList(userId);
        List<ShoppingIngredientResource> resourceShoppingList = new ArrayList<>();
        if(dtoShoppingList==null || dtoShoppingList.size()==0){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        for(ShoppingIngredientDTO ingredientDTO:dtoShoppingList){
            ShoppingIngredientResource ingredientResource = mapper.map(ingredientDTO);
            resourceShoppingList.add(ingredientResource);
        }
        return Response.ok(resourceShoppingList).build();
    }
}
