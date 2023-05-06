package com.avaliacao.powerkr.domain.dto.tarefa;

import com.avaliacao.powerkr.domain.model.Tarefa;
import com.avaliacao.powerkr.domain.model.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ListaTarefasDTO(String titulo, String descricao, @JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime dataCriacao, @JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime dataConclusao, Status status) {

    public ListaTarefasDTO(Tarefa tarefa) {
        this(tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataCriacao(), tarefa.getDataConclusao(), tarefa.getStatus());
    }

}
