package com.avaliacao.powerkr.domain.service;

import com.avaliacao.powerkr.domain.dto.usuario.CadastrarUsuarioDTO;
import com.avaliacao.powerkr.domain.model.Usuario;
import com.avaliacao.powerkr.domain.repository.UsuarioRepository;
import com.avaliacao.powerkr.infra.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email);
    }

    // Criptografando a senha e cadastrando um usuário novo no banco de dados
    public Usuario criptografar(CadastrarUsuarioDTO dto) {
        UserDetails login = usuarioRepository.findByEmail(dto.email());

        if (login != null) {
            throw new ApiException("Esse email já foi cadastrado!!");
        }

        String senhaCriptografada = passwordEncoder.encode(dto.senha());
        Usuario usuario = new Usuario(dto.nome(), dto.email(), senhaCriptografada);
        usuarioRepository.save(usuario);
        return usuario;
     }
}
