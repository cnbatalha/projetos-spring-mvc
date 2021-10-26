package com.cnbatalha.spring.boot.forum.dto;

import org.springframework.data.domain.Page;

import com.cnbatalha.spring.boot.forum.model.Topico;

import lombok.Getter;

@Getter
public class TopicoDto {

	private Long id;
 	private String titulo;
 	private String mensagem; 	
 	private String curso;
 	
 	public TopicoDto(Topico topico) {
 		this.id = topico.getId();
 		this.titulo = topico.getTitulo();
 		this.mensagem = topico.getMensagem();
 		this.curso = topico.getCurso() == null ? "" : topico.getCurso().getNome();
 	}
	
 	public static Page<TopicoDto> converter(Page<Topico> topicos) {
 		return topicos.map(TopicoDto::new);
 	}
 	
}
