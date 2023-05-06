package com.avaliacao.powerkr.domain.service;

import com.avaliacao.powerkr.domain.dto.tarefa.CriarTarefaDTO;
import com.avaliacao.powerkr.domain.model.Tarefa;
import com.avaliacao.powerkr.domain.dto.tarefa.AtualizarTarefaDTO;
import com.avaliacao.powerkr.domain.dto.tarefa.DetalhesTarefaDTO;
import com.avaliacao.powerkr.domain.dto.tarefa.ListaTarefasDTO;
import com.avaliacao.powerkr.infra.exception.ApiException;
import com.avaliacao.powerkr.domain.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;


    public List<ListaTarefasDTO> listarTarefas() {
        return tarefaRepository.findAll().stream().map(ListaTarefasDTO::new).toList();
    }

    public DetalhesTarefaDTO criarTarefa(CriarTarefaDTO dto) {
        Tarefa tarefa = new Tarefa(dto);
        tarefaRepository.save(tarefa);
        return new DetalhesTarefaDTO(tarefa);
    }

    public DetalhesTarefaDTO buscarPorId(Long id) {
        Tarefa tarefa = verificarSeExiste(id);
        return new DetalhesTarefaDTO(tarefa);
    }

    public DetalhesTarefaDTO atualizarTarefa(Long id, AtualizarTarefaDTO dto) {
        Tarefa tarefa = verificarSeExiste(id);
        tarefa.atualizar(dto);
        tarefaRepository.save(tarefa);
        return new DetalhesTarefaDTO(tarefa);
    }

    public void excluirTarefa(Long id) {
        verificarSeExiste(id);
        tarefaRepository.deleteById(id);
    }

    private Tarefa verificarSeExiste(Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);

        if (tarefa.isEmpty()) {
            throw new ApiException("Esse ID não existe! Por favor, tente outro.");
        }

        return tarefa.get();
    }
}
