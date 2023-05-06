package com.avaliacao.powerkr.dto.tarefa;

import com.avaliacao.powerkr.model.Status;
import com.avaliacao.powerkr.model.Tarefa;

import java.time.LocalDateTime;

public record DetalhesTarefaDTO(String titulo, String descricao, LocalDateTime dataCriacao, LocalDateTime dataConclusao, Status status) {

    public DetalhesTarefaDTO(Tarefa tarefa) {
        this(tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataCriacao(), tarefa.getDataConclusao(), tarefa.getStatus());
    }

}
