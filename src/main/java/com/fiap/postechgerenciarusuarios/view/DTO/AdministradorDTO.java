package com.fiap.postechgerenciarusuarios.view.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

public class AdministradorDTO {

	private UUID id;

	public String email;

	public String nome;

	public String cpf;
	private LocalDateTime dataDeCadastro;

	public AdministradorDTO(String email, String nome, String cpf) {
		this.email = email;
		this.nome = nome;
		this.cpf = cpf;
	}

	public UUID getId() {
		return id;
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

	public LocalDateTime getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(LocalDateTime dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
