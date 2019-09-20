package com.tortu.api.services;

import com.tortu.api.models.CategoriaIngrediente;
import com.tortu.api.utils.GeneralException;

import java.util.List;

/**
 * Interface para los servicios de Categoria_Ingrediente
 */
public interface CategoriaIngredienteService {
    /**
     * Guarda la informacion de una nueva categoria para ingredientes
     * @param categoriaIngrediente
     * @return el objeto con la informacion guardada
     * @throws GeneralException
     */
    CategoriaIngrediente saveCategoriaIngrediente(CategoriaIngrediente categoriaIngrediente) throws GeneralException;

    /**
     * Actualiza la informacion de una categoria_ingrediente
     * @param categoriaIngrediente
     * @return el objeto con la informacion actualizada
     * @throws GeneralException
     */
    CategoriaIngrediente updateCategoriaIngrediente(CategoriaIngrediente categoriaIngrediente) throws GeneralException;

    /**
     * Consulta la categoria_ingrediente con el id especificado
     * @param id de la categoria_ingrediente que se quiere consultar
     * @return el objeto encontrado con ese id
     * @throws GeneralException
     */
    CategoriaIngrediente findCategoriaIngrediente(Integer id) throws  GeneralException;

    /**
     * Consulta todas las categorias_ingrediente
     * @return lista de todos los objetos encontrados
     */
    List<CategoriaIngrediente> findAllCategoriaIngrediente();

    /**
     * Elimina la categoria_ingrediente con el id especificado
     * @param id de la categoria_ingrediente a eliminar
     * @throws GeneralException
     */
    void deleteCategoriaIngrediente(Integer id) throws GeneralException;
}
