package com.avaliacao.powerkr.domain.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record EfetuarLoginDTO(@NotBlank String email, @NotBlank String senha) {
}
