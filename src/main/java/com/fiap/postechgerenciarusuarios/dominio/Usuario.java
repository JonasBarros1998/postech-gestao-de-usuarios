package com.fiap.postechgerenciarusuarios.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public non-sealed class Usuario extends Pessoa {

	@Column
	public final LocalDateTime dataDeCadastro = LocalDateTime.now();

	@Column(nullable = false)
	public String sub;

	protected Usuario() {}

	public Usuario(String email, String nome, String sub) {
		super(email, nome);
		this.sub = sub;
	}

	public void addCPF(String cpf) {
		super.setCpf(cpf);
	}

	public String getSub() {
		return sub;
	}
}
