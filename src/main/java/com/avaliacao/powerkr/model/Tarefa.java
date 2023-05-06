package com.avaliacao.powerkr.model;

import com.avaliacao.powerkr.dto.tarefa.AtualizarTarefaDTO;
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

        if (dto.dataConclusao() != null) {
            this.dataConclusao = dto.dataConclusao();
        }
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

    public void atualizar(AtualizarTarefaDTO dto) {
        if (dto.titulo() != null) {
            this.titulo = dto.titulo();
        }
        if (dto.descricao() != null) {
            this.descricao = dto.descricao();
        }
        if (dto.status() != null) {
            this.status = dto.status();
        }
        if (dto.dataConclusao() != null) {
            this.dataConclusao = dto.dataConclusao();
        }
    }
}
