package com.fiap.postechgerenciarusuarios.view.forms;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public record UsuarioForm(

	@NotEmpty()
	@Length(max = 120)
	String email,

	@NotEmpty()
	@Length(max = 200)
	String nome,

	@Length(min = 11, max = 11, message = "o campo CPF deve contar 11 caracteres")
	@CPF
	String cpf
){}
