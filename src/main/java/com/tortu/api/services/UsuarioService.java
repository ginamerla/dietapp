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
     * Este metodo regresa un usuario en base al id proporcionado.
     * @param idUsuario Identificador del usuario.
     * @return Usuario.
     */
    Usuario obtenerUsuarioPorId(Integer idUsuario);

    Usuario saveUsuario(Usuario usuario) throws GeneralException;

    Usuario updateUsuario(Usuario usuario) throws GeneralException;

    Usuario findUsuario(Usuario usuario) throws GeneralException;

    List<Usuario> findAllUsuarios ();

    void deleteUsuario(Integer idUsuario) throws GeneralException;
}
