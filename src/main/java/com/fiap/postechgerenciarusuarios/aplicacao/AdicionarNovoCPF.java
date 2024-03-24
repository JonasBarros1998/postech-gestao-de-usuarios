package com.fiap.postechgerenciarusuarios.aplicacao;

import com.fiap.postechgerenciarusuarios.dominio.Usuario;
import com.fiap.postechgerenciarusuarios.infra.bancodedados.UsuarioRepository;
import com.fiap.postechgerenciarusuarios.view.exceptions.UsuarioNaoExisteException;
import com.fiap.postechgerenciarusuarios.view.forms.AdicionarCPFForm;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdicionarNovoCPF {

	UsuarioRepository usuarioRepository;

	public AdicionarNovoCPF(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public AdicionarCPFForm adicionar(AdicionarCPFForm adicionarCPFForm, UUID id) {
		Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNaoExisteException("Usuario consultado nao existe"));

		usuario.addCPF(adicionarCPFForm.cpf());
		this.usuarioRepository.save(usuario);
		return adicionarCPFForm;
	}
}
