package com.fiap.postechgerenciarusuarios.infra.seguranca.criptografia;

import jakarta.persistence.AttributeConverter;
import org.springframework.stereotype.Component;

@Component
public class ConverterDados implements AttributeConverter<String,String> {

	private CriptografiaUtil criptografiaUtil;

	ConverterDados(CriptografiaUtil criptografiaUtil) {
		this.criptografiaUtil = criptografiaUtil;
	}

	@Override
	public String convertToDatabaseColumn(String valor) {
		if(valor != null) {
			return this.criptografiaUtil.criptografar(valor);
		}
		return null;
	}

	@Override
	public String convertToEntityAttribute(String valor) {
		if (valor != null) {
			return this.criptografiaUtil.descriptografar(valor);
		}
		return null;
	}
}
