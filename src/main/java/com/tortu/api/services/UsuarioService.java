package com.tortu.api.services;

import com.tortu.api.models.Usuario;

/**
 * Interface para el manejo de usuarios.
 * @author visilva
 */
public interface UsuarioService {

    /**
     * Este metodo regresa un usuario en base al id proporcionado.
     * @param idUsuario Identificador del usuario.
     * @return Usuario.
     */
    Usuario obtenerUsuarioPorId(Integer idUsuario);
}
