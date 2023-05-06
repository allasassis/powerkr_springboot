package com.avaliacao.powerkr.controller;

import com.avaliacao.powerkr.domain.dto.usuario.CadastrarUsuarioDTO;
import com.avaliacao.powerkr.domain.dto.usuario.DadosTokenJWT;
import com.avaliacao.powerkr.domain.dto.usuario.EfetuarLoginDTO;
import com.avaliacao.powerkr.domain.model.Usuario;
import com.avaliacao.powerkr.domain.service.UsuarioService;
import com.avaliacao.powerkr.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/novo")
    @Transactional
    public ResponseEntity<DadosTokenJWT> cadastrarUsuario(@RequestBody CadastrarUsuarioDTO dto) {
        DadosTokenJWT token = usuarioService.cadastrarUsuario(dto);

        return ResponseEntity.status(201).body(token);
    }

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody EfetuarLoginDTO dto) {

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.email(), dto.senha()));
        String token = tokenService.gerarToken((Usuario) authenticate.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(token));
    }

}
