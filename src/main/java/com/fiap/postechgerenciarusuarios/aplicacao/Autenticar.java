package com.fiap.postechgerenciarusuarios.aplicacao;

import com.fiap.postechgerenciarusuarios.dominio.Usuario;
import com.fiap.postechgerenciarusuarios.infra.seguranca.CarregarInformacoesDoUsuarioLogado;
import com.fiap.postechgerenciarusuarios.view.forms.UsuarioAutenticadoForm;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service
public class Autenticar {

	GerenciarUsuarios gerenciarUsuarios;

	Autenticar(GerenciarUsuarios gerenciarUsuarios) {
		this.gerenciarUsuarios = gerenciarUsuarios;
	}

	public UsuarioAutenticadoForm usuario(OidcUser usuario, HttpSession sessao) {


		var novoUsuario = new Usuario(usuario.getEmail(), usuario.getIdToken().getFullName(), usuario.getAttribute("sub"));

		this.adicionar(usuario, sessao);

		var idDoUsuario = this.gerenciarUsuarios.salvar(novoUsuario);

		var tokenDoUsuario = this.token(sessao);

		return new UsuarioAutenticadoForm(tokenDoUsuario, idDoUsuario);
	}

	public void adicionar(OidcUser usuario, HttpSession sessao) {
		this.salvarTokenDoUsuario(usuario.getIdToken().getTokenValue(), sessao);
		CarregarInformacoesDoUsuarioLogado.adicionar(usuario);
	}

	public String token(HttpSession sessaoHTTP) {
		return (String) sessaoHTTP.getAttribute(sessaoHTTP.getId());
	}

	public void salvarTokenDoUsuario(String token, HttpSession sessao) {
		sessao.getAttribute(sessao.getId());
		sessao.setMaxInactiveInterval(3600);
		sessao.setAttribute(sessao.getId(), token);
	}

}
