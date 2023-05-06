package com.avaliacao.powerkr.repository;

import com.avaliacao.powerkr.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
