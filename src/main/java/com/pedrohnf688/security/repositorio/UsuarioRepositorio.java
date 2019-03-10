package com.pedrohnf688.security.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pedrohnf688.security.modelo.Usuario;

@Transactional(readOnly = true)
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	Usuario findByEmail(String email);
}
