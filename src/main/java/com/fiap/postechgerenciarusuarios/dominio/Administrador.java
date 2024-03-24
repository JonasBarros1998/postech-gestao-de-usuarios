package com.fiap.postechgerenciarusuarios.dominio;

import com.fiap.postechgerenciarusuarios.infra.seguranca.criptografia.ConverterDados;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "administrador")
public non-sealed class Administrador extends Pessoa {

	@Column
	public final LocalDateTime dataDeCadastro = LocalDateTime.now();

	@Convert(converter = ConverterDados.class)
	@Column(nullable = false, name = "cargo")
	@Enumerated(EnumType.STRING)
	public Cargo cargo;

	protected Administrador() {}

	public Administrador(String email, String nome, Cargo cargo) {
		super(email, nome);
		this.cargo = cargo;
	}

}
