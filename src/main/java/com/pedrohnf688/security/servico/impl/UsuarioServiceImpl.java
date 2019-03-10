package com.pedrohnf688.security.servico.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.pedrohnf688.security.modelo.Usuario;
import com.pedrohnf688.security.repositorio.UsuarioRepositorio;
import com.pedrohnf688.security.servico.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Override
	public Optional<Usuario> buscarPorEmail(String email) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(this.usuarioRepositorio.findByEmail(email));
	}

}
