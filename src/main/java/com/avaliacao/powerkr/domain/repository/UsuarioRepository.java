package com.avaliacao.powerkr.domain.repository;

import com.avaliacao.powerkr.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
