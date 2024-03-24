package com.fiap.postechgerenciarusuarios.view.controller;

import com.fiap.postechgerenciarusuarios.aplicacao.AdicionarNovoCPF;
import com.fiap.postechgerenciarusuarios.aplicacao.Autenticar;
import com.fiap.postechgerenciarusuarios.infra.seguranca.criptografia.CriptografiaUtil;
import com.fiap.postechgerenciarusuarios.view.forms.AdicionarCPFForm;
import com.fiap.postechgerenciarusuarios.view.forms.UsuarioAutenticadoForm;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/usuarios")
@RestController
public class UsuarioController {

	Autenticar autenticar;

	CriptografiaUtil criptografia;

	AdicionarNovoCPF adicionarCPF;

	@Autowired
	UsuarioController(Autenticar autenticar, CriptografiaUtil criptografia,AdicionarNovoCPF adicionarCPF) {
		this.autenticar = autenticar;
		this.criptografia = criptografia;
		this.adicionarCPF = adicionarCPF;
	}

	@GetMapping("/login")
	public ResponseEntity<UsuarioAutenticadoForm> login(@AuthenticationPrincipal OidcUser usuario, HttpSession sessao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.autenticar.usuario(usuario, sessao));
	}

	@PutMapping("/cpf/{id}")
	public ResponseEntity<AdicionarCPFForm> adicionarCPF(@RequestBody @Valid AdicionarCPFForm adicionarCPFForm, @PathVariable UUID id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.adicionarCPF.adicionar(adicionarCPFForm, id));
	}

	/*
	@GetMapping("/token")
	public ResponseEntity<UsuarioAutenticadoForm> buscar(HttpSession sessaoHTTP) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.autenticar.token(sessaoHTTP));
	}*/
}
