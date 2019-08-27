package com.tortu.api.services.impl;

import com.tortu.api.models.Usuario;
import com.tortu.api.services.UsuarioService;

public class FakeUsuarioServiceImpl implements UsuarioService {
    @Override
    public Usuario obtenerUsuarioPorId(Integer idUsuario) {
        Usuario fakeUser = new Usuario();
        fakeUser.setEmail("papol@gmail.com");
        fakeUser.setIdUsuario(1);
        fakeUser.setNombre("papol");
        return fakeUser;
    }
}
