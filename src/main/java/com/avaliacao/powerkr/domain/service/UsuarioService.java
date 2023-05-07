package com.avaliacao.powerkr.domain.service;

import com.avaliacao.powerkr.domain.dto.usuario.*;
import com.avaliacao.powerkr.domain.model.Usuario;
import com.avaliacao.powerkr.domain.repository.UsuarioRepository;
import com.avaliacao.powerkr.infra.exception.ApiException;
import com.avaliacao.powerkr.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    public DadosTokenJWT cadastrarUsuario(CadastrarUsuarioDTO dto) {
        Usuario usuario = criptografarCadastro(dto);
        String token = tokenService.gerarToken(usuario);

        return new DadosTokenJWT(token);
    }

    public List<ListaUsuariosDTO> listarUsuarios() {
        return usuarioRepository.findAll().stream().map(ListaUsuariosDTO::new).toList();
    }

    public DetalhesUsuarioDTO findById(Long id) {
        Usuario usuario = verificarSeExiste(id);
        return new DetalhesUsuarioDTO(usuario);
    }

    public DetalhesUsuarioDTO atualizarUsuario(Long id, AtualizarUsuarioDTO dto) {
        Usuario usuario = verificarSeExiste(id);

        // Caso o usuário esteja querendo atualizar a senha, vamos criptografar antes, e depois atualizar na entidade/tabela
        if (dto.getSenha() != null) {
            String senhaCriptografada = passwordEncoder.encode(dto.getSenha());
            dto.setSenha(senhaCriptografada);
        }

        usuario.atualizar(dto);
        usuarioRepository.save(usuario);
        return new DetalhesUsuarioDTO(usuario);
    }

    public void deletarUsuario(Long id) {
        verificarSeExiste(id);
        usuarioRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email);
    }

    // Criptografando a senha e cadastrando um usuário novo no banco de dados
    private Usuario criptografarCadastro(CadastrarUsuarioDTO dto) {
        UserDetails login = usuarioRepository.findByEmail(dto.email());

        if (login != null) {
            throw new ApiException("Esse email já foi cadastrado!");
        }

        String senhaCriptografada = passwordEncoder.encode(dto.senha());
        Usuario usuario = new Usuario(dto.nome(), dto.email(), senhaCriptografada);
        usuarioRepository.save(usuario);
        return usuario;
     }

     private Usuario verificarSeExiste(Long id) {
         Optional<Usuario> usuario = usuarioRepository.findById(id);

         if (usuario.isEmpty()) {
             throw new ApiException("Esse usuário não existe!");
         }

         return usuario.get();
     }
}
