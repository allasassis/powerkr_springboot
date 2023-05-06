package com.avaliacao.powerkr.domain.dto.tarefa;

import com.avaliacao.powerkr.domain.model.Status;

import java.time.LocalDateTime;

public record AtualizarTarefaDTO(String titulo, String descricao, Status status, LocalDateTime dataConclusao) {
}
