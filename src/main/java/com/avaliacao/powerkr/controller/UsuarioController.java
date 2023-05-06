package com.avaliacao.powerkr.controller;

import com.avaliacao.powerkr.domain.dto.usuario.CadastrarUsuarioDTO;
import com.avaliacao.powerkr.domain.dto.usuario.DadosTokenJWT;
import com.avaliacao.powerkr.domain.model.Usuario;
import com.avaliacao.powerkr.domain.service.UsuarioService;
import com.avaliacao.powerkr.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/new")
    @Transactional
    public ResponseEntity<DadosTokenJWT> cadastrarUsuario(@RequestBody CadastrarUsuarioDTO dto) {
        Usuario usuario = usuarioService.criptografar(dto);
        String token = tokenService.gerarToken(usuario);
        return ResponseEntity.ok(new DadosTokenJWT(token));
    }

}
