package com.tortu.api.services.impl;

import com.tortu.api.models.Usuario;
import com.tortu.api.services.UsuarioService;
import com.tortu.api.utils.GeneralException;

import java.util.List;

public class FakeUsuarioServiceImpl implements UsuarioService {
    @Override
    public Usuario obtenerUsuarioPorId(Integer idUsuario) {
        Usuario fakeUser = new Usuario();
        fakeUser.setEmail("papol@gmail.com");
        fakeUser.setIdUsuario(1);
        fakeUser.setNombre("papol");
        return fakeUser;
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) throws GeneralException {
        return null;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) throws GeneralException {
        return null;
    }

    @Override
    public Usuario findUsuario(Usuario usuario) throws GeneralException {
        return null;
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        return null;
    }

    @Override
    public void deleteUsuario(Integer idUsuario) throws GeneralException {

    }
}
