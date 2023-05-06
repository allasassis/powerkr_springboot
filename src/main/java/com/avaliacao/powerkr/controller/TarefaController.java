package com.avaliacao.powerkr.controller;

import com.avaliacao.powerkr.domain.dto.tarefa.AtualizarTarefaDTO;
import com.avaliacao.powerkr.domain.dto.tarefa.CriarTarefaDTO;
import com.avaliacao.powerkr.domain.dto.tarefa.DetalhesTarefaDTO;
import com.avaliacao.powerkr.domain.dto.tarefa.ListaTarefasDTO;
import com.avaliacao.powerkr.domain.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<ListaTarefasDTO>> listarTarefas() {
        return ResponseEntity.ok(tarefaService.listarTarefas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesTarefaDTO> buscarTarefaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tarefaService.buscarPorId(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesTarefaDTO> criarTarefa(@RequestBody CriarTarefaDTO dto) {
        return ResponseEntity.status(201).body(tarefaService.criarTarefa(dto));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesTarefaDTO> atualizarTarefa(@PathVariable Long id, @RequestBody AtualizarTarefaDTO dto) {
        return ResponseEntity.ok(tarefaService.atualizarTarefa(id, dto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirTarefa(@PathVariable Long id) {
        tarefaService.excluirTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
