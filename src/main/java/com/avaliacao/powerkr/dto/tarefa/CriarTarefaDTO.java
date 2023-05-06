package com.avaliacao.powerkr.dto.tarefa;

import jakarta.validation.constraints.NotBlank;

public record CriarTarefaDTO(@NotBlank String titulo, @NotBlank String descricao) {
}
