package com.fiap.postechgerenciarusuarios.dominio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Cargo {

	ADMINISTRADOR("ADMIN");

	private final String cargo;

	Cargo(String cargo) {
		this.cargo = cargo;
	}

	@JsonCreator
	public static Cargo decode(final String tipo) {
		return Stream.of(Cargo.values())
			.filter(targetEnum -> targetEnum.cargo.equals(tipo))
			.findFirst()
			.orElseThrow();
	}

	@JsonValue
	public String getCode() {
		return cargo;
	}
}
