package com.avaliacao.powerkr.domain.dto.tarefa;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record CriarTarefaDTO(@NotBlank String titulo, @NotBlank String descricao, @JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime dataConclusao) {
}
