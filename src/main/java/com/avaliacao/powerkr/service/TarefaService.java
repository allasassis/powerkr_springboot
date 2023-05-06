package com.avaliacao.powerkr.service;

import com.avaliacao.powerkr.dto.tarefa.CriarTarefaDTO;
import com.avaliacao.powerkr.dto.tarefa.DetalhesTarefaDTO;
import com.avaliacao.powerkr.model.Tarefa;
import com.avaliacao.powerkr.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;


    public DetalhesTarefaDTO criarTarefa(CriarTarefaDTO dto) {
        Tarefa tarefa = new Tarefa(dto);
        tarefaRepository.save(tarefa);
        return new DetalhesTarefaDTO(tarefa);
    }
}
