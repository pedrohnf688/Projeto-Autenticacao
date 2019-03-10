package com.pedrohnf688.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pedrohnf688.security.enums.PerfilEnum;
import com.pedrohnf688.security.modelo.Usuario;
import com.pedrohnf688.security.repositorio.UsuarioRepositorio;
import com.pedrohnf688.utils.SenhasUtils;



@SpringBootApplication
@ComponentScan("com.pedrohnf688")
@EnableJpaRepositories("com.pedrohnf688.security.repositorio")
@EntityScan("com.pedrohnf688.security.modelo")
public class TesteAutenticacaoApplication {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(TesteAutenticacaoApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			Usuario usuario = new Usuario();
			usuario.setEmail("usuario@email.com");
			usuario.setPerfil(PerfilEnum.ROLE_USUARIO);
			usuario.setSenha(SenhasUtils.gerarBCrypt("123456"));
			this.usuarioRepositorio.save(usuario);
			
			Usuario admin = new Usuario();
			admin.setEmail("admin@email.com");
			admin.setPerfil(PerfilEnum.ROLE_ADMIN);
			admin.setSenha(SenhasUtils.gerarBCrypt("123456"));
			this.usuarioRepositorio.save(admin);
			
		};
		
	}
}
	
