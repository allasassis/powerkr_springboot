package com.avaliacao.powerkr.domain.repository;

import com.avaliacao.powerkr.domain.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
}
