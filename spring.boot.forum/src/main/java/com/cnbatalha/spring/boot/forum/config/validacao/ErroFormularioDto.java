package com.cnbatalha.spring.boot.forum.config.validacao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ErroFormularioDto {

	private String campo;
	private String erro;

	public ErroFormularioDto(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}
	
}
