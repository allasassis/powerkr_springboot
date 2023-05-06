package com.avaliacao.powerkr.controller;

import com.avaliacao.powerkr.domain.dto.usuario.*;
import com.avaliacao.powerkr.domain.model.Usuario;
import com.avaliacao.powerkr.domain.service.UsuarioService;
import com.avaliacao.powerkr.infra.security.TokenService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<List<ListaUsuariosDTO>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<DetalhesUsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
        DetalhesUsuarioDTO usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping("/novo")
    @Transactional
    public ResponseEntity<DadosTokenJWT> cadastrarUsuario(@RequestBody CadastrarUsuarioDTO dto) {
        DadosTokenJWT token = usuarioService.cadastrarUsuario(dto);

        return ResponseEntity.status(201).body(token);
    }

    @PostMapping("/login")
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody EfetuarLoginDTO dto) {

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.email(), dto.senha()));
        String token = tokenService.gerarToken((Usuario) authenticate.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(token));
    }

    @PutMapping("/{id}")
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<DetalhesUsuarioDTO> atualizarUsuario(@PathVariable Long id, @RequestBody AtualizarUsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.atualizarUsuario(id, dto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
