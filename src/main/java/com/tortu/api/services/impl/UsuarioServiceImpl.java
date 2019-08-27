package com.tortu.api.services.impl;

import com.tortu.api.models.Usuario;
import com.tortu.api.services.UsuarioService;

/**
 * Implementacion del Servicio de Usuario. Esta clase deberia de llamar a los DAOs de usuario.
 * @author visilva
 */
public class UsuarioServiceImpl implements UsuarioService {
    @Override
    public Usuario obtenerUsuarioPorId(Integer idUsuario) {
        throw new UnsupportedOperationException("Esta operacion no esta permitida!");
    }
}
