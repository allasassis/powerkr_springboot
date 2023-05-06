package com.avaliacao.powerkr.domain.dto.tarefa;

import com.avaliacao.powerkr.domain.model.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record AtualizarTarefaDTO(String titulo, String descricao, Status status, @JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime dataConclusao) {
}
