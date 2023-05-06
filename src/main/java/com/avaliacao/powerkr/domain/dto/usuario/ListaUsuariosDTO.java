package com.avaliacao.powerkr.domain.dto.usuario;

import com.avaliacao.powerkr.domain.model.Usuario;

public record ListaUsuariosDTO(String nome, String email, String senha) {

    public ListaUsuariosDTO(Usuario usuario) {
        this(usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }
}
