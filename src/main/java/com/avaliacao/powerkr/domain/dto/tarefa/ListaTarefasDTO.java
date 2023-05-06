package com.avaliacao.powerkr.domain.dto.tarefa;

import com.avaliacao.powerkr.domain.model.Tarefa;
import com.avaliacao.powerkr.domain.model.Status;

import java.time.LocalDateTime;

public record ListaTarefasDTO(String titulo, String descricao, LocalDateTime dataCriacao, LocalDateTime dataConclusao, Status status) {

    public ListaTarefasDTO(Tarefa tarefa) {
        this(tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataCriacao(), tarefa.getDataConclusao(), tarefa.getStatus());
    }

}