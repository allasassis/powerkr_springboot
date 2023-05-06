package com.avaliacao.powerkr.controller;

import com.avaliacao.powerkr.dto.tarefa.CriarTarefaDTO;
import com.avaliacao.powerkr.dto.tarefa.DetalhesTarefaDTO;
import com.avaliacao.powerkr.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    @Transactional
    public DetalhesTarefaDTO criarTarefa(@RequestBody CriarTarefaDTO dto) {
        return tarefaService.criarTarefa(dto);
    }
}
