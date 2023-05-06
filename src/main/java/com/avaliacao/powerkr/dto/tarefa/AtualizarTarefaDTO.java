package com.avaliacao.powerkr.dto.tarefa;

import com.avaliacao.powerkr.model.Status;

import java.time.LocalDateTime;

public record AtualizarTarefaDTO(String titulo, String descricao, Status status, LocalDateTime dataConclusao) {
}
