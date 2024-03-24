package com.fiap.postechgerenciarusuarios;

import com.fiap.postechgerenciarusuarios.infra.seguranca.criptografia.CriptografiaUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostechGerenciarUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostechGerenciarUsuariosApplication.class, args);
	}

}
