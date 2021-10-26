package com.cnbatalha.spring.boot.forum.controller.form;

import org.modelmapper.ModelMapper;

import com.cnbatalha.spring.boot.forum.model.Topico;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TopicoForm {

	private String titulo;
	private String mensagem;
	private String nomeCurso;
	
	public Topico converter() {
		ModelMapper modelMapper = new ModelMapper();
		Topico topico = modelMapper.map(this, Topico.class);
		return topico; 
	}
	
}
