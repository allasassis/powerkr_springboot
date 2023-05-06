package com.avaliacao.powerkr.domain.dto.usuario;

import jakarta.validation.constraints.Email;

public class AtualizarUsuarioDTO {

    private String nome;

    @Email
    private String email;

    private String senha;

    public AtualizarUsuarioDTO() {
    }

    public AtualizarUsuarioDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
