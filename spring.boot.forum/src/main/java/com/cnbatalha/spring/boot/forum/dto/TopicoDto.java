package com.cnbatalha.spring.boot.forum.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.cnbatalha.spring.boot.forum.model.Topico;

import lombok.Getter;

@Getter
public class TopicoDto {

	private Integer id;
 	private String titulo;
 	private String mensagem; 	
 	private String curso;
 	
 	public TopicoDto(Topico topico) {
 		this.id = topico.getId();
 		this.titulo = topico.getTitulo();
 		this.mensagem = topico.getMensagem();
 		this.curso = topico.getCurso().getNome();
 	}
	
 	public static List<TopicoDto> converter(List<Topico> topicos) {
 		return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
 	}
 	
}
