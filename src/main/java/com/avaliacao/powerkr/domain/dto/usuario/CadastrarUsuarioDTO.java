package com.avaliacao.powerkr.domain.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastrarUsuarioDTO(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String senha) {
}
