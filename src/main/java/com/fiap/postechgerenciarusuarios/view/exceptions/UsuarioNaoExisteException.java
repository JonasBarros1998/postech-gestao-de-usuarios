package com.fiap.postechgerenciarusuarios.view.exceptions;

public class UsuarioNaoExisteException extends RuntimeException {

	public UsuarioNaoExisteException(String mensagem) {
		super(mensagem);
	}
}
