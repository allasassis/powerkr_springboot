package com.avaliacao.powerkr.dto.tarefa;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record CriarTarefaDTO(@NotBlank String titulo, @NotBlank String descricao, LocalDateTime dataConclusao) {
}
