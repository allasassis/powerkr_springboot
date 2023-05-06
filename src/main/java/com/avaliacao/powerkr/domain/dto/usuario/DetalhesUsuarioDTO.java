package com.avaliacao.powerkr.domain.dto.usuario;

import com.avaliacao.powerkr.domain.model.Usuario;

public record DetalhesUsuarioDTO(String nome, String email, String senha) {

    public DetalhesUsuarioDTO(Usuario usuario) {
        this(usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }
}
