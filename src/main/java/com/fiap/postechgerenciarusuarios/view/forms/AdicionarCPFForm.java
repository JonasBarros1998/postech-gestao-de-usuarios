package com.fiap.postechgerenciarusuarios.view.forms;

import org.hibernate.validator.constraints.Length;

public record AdicionarCPFForm(
	@Length(min = 11, max = 11, message = "O campo cpf deve ter 11 caracteres")
	String cpf
) {
}
