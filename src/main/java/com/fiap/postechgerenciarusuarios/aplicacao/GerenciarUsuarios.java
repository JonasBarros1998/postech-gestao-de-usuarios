package com.fiap.postechgerenciarusuarios.aplicacao;

import com.fiap.postechgerenciarusuarios.dominio.Usuario;
import com.fiap.postechgerenciarusuarios.infra.bancodedados.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GerenciarUsuarios {

	UsuarioRepository usuarioRepository;

	Usuario usuarioLogado;

	@Autowired
	public GerenciarUsuarios(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public UUID salvar(Usuario usuario) {
		this.usuarioRepository.findBySub(usuario.getSub()).ifPresentOrElse(
			usuarioExiste -> this.usuarioLogado = usuarioExiste,
			() -> this.usuarioLogado = this.usuarioRepository.save(usuario)
		);

		return this.usuarioLogado.getId();
	}

}
