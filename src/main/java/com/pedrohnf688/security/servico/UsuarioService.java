package com.pedrohnf688.security.servico;

import java.util.Optional;

import com.pedrohnf688.security.modelo.Usuario;


public interface UsuarioService {

	Optional<Usuario> buscarPorEmail(String email);
	
}
