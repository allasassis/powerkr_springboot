package com.avaliacao.powerkr.model;

import com.avaliacao.powerkr.dto.tarefa.CriarTarefaDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Tarefa() {
    }

    public Tarefa(CriarTarefaDTO dto) {
        this.titulo = dto.titulo();
        this.descricao = dto.descricao();

        this.dataCriacao = LocalDateTime.now();
        this.status = Status.ABERTA;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public Status getStatus() {
        return status;
    }
}
