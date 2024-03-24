package com.fiap.postechgerenciarusuarios.infra.seguranca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Seguranca {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
			.csrf(configuracao -> configuracao.disable())
			.authorizeHttpRequests(
				authorizeConfig ->
					authorizeConfig
						.requestMatchers("api/usuarios/login").authenticated()
						//.requestMatchers("api/usuarios/token").permitAll()
						.anyRequest().permitAll()
				)
			.oauth2Login(Customizer.withDefaults())
			.build();
	}

	/*
	 * Cria um Bean para a classe AuthenticationManager
	 * */
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
}
