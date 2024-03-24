package com.fiap.postechgerenciarusuarios.dominio;

import com.fiap.postechgerenciarusuarios.infra.seguranca.criptografia.ConverterDados;
import jakarta.persistence.*;
import org.hibernate.annotations.Proxy;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Proxy(lazy = false)
abstract sealed class Pessoa permits Usuario, Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Convert(converter = ConverterDados.class)
	@Column(length = 400)
	private String email;

	@Convert(converter = ConverterDados.class)
	@Column(length = 400)
	private String nome;

	@Convert(converter = ConverterDados.class)
	@Column(length = 255, nullable = true, unique = true)
	private String cpf;

	protected Pessoa() {}

	Pessoa(String email, String nome) {
		this.email = email;
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public UUID getId() {
		return id;
	}

}
