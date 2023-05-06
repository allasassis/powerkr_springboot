package com.avaliacao.powerkr.repository;

import com.avaliacao.powerkr.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
}
