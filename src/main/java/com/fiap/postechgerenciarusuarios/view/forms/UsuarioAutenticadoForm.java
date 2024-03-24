package com.fiap.postechgerenciarusuarios.view.forms;

import java.util.UUID;

public record UsuarioAutenticadoForm(
	String token,

	UUID idDoUsuario
) {}
