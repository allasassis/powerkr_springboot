package com.avaliacao.powerkr.dto.tarefa;

import com.avaliacao.powerkr.model.Status;
import com.avaliacao.powerkr.model.Tarefa;

import java.time.LocalDateTime;

public record ListaTarefasDTO(String titulo, String descricao, LocalDateTime dataCriacao, Status status) {

    public ListaTarefasDTO(Tarefa tarefa) {
        this(tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataCriacao(), tarefa.getStatus());
    }

}
