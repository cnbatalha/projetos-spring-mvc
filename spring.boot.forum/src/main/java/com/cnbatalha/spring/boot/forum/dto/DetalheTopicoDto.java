package com.cnbatalha.spring.boot.forum.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.cnbatalha.spring.boot.forum.model.StatusTopico;
import com.cnbatalha.spring.boot.forum.model.Topico;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DetalheTopicoDto {

	private Long id;
 	private String titulo;
 	private String mensagem; 	
 	private String curso;
 	private List<RespostaDto> respostas;
 	private LocalDateTime dataCriacao;
 	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
 	
 	public DetalheTopicoDto(Topico topico) {
 		this.id = topico.getId();
 		this.titulo = topico.getTitulo();
 		this.mensagem = topico.getMensagem();
 		this.curso = topico.getCurso() == null ? "" : topico.getCurso().getNome();
 		this.status = topico.getStatus();
 		this.dataCriacao = topico.getDataCriacao();
	}
	
}


