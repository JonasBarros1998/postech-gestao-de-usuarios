package com.fiap.postechgerenciarusuarios.infra.seguranca;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public class CarregarInformacoesDoUsuarioLogado {

	public static OidcUser usuario;

	public static void adicionar(OidcUser OidcUsuario) {
		usuario = OidcUsuario;
	}

}
