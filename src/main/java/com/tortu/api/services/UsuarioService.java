package com.tortu.api.services;

import com.tortu.api.models.Usuario;
import com.tortu.api.utils.GeneralException;
import sun.java2d.loops.GeneralRenderer;

import java.util.List;

/**
 * Interface para el manejo de usuarios.
 * @author visilva
 */
public interface UsuarioService {

    /**
     * Guarda el nuevo usuario y regresa el mismo usuario guardado
     * @param usuario nuevo usuario a guardar
     * @return Usuario guardado
     * @throws GeneralException
     */
    Usuario saveUsuario(Usuario usuario) throws GeneralException;

    /**
     * Actualiza los datos de un usuario
     * @param usuario con los datos actualizados
     * @return Usuario actualizado
     * @throws GeneralException
     */
    Usuario updateUsuario(Usuario usuario) throws GeneralException;

    /**
     * Obtiene un usuario con el id enviado
     * @param idUsuario para obtener el id
     * @return Usuario encontrado con el id
     * @throws GeneralException
     */
    Usuario findUsuario(Integer idUsuario) throws GeneralException;

    /**
     * Busca todos los usuarios
     * @return Lista de usuarios encontrados
     */
    List<Usuario> findAllUsuarios ();

    /**
     * Elimina el usuario con el id enviado
     * @param idUsuario id del usuario a eliminar
     * @throws GeneralException
     */
    void deleteUsuario(Integer idUsuario) throws GeneralException;
}
