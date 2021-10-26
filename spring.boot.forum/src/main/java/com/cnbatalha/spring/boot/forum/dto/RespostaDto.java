package com.cnbatalha.spring.boot.forum.dto;

import com.cnbatalha.spring.boot.forum.model.Resposta;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RespostaDto {
	
	private Integer id;
	private String mensagem;
	
	public RespostaDto(Resposta resposta) {
		this.id = resposta.getId();
		this.mensagem = resposta.getMensagem();
	}

}
