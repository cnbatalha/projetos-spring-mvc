package com.cnbatalha.spring.boot.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import com.cnbatalha.spring.boot.forum.model.Topico;
import com.cnbatalha.spring.boot.forum.repository.TopicoRepository;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AtualizacaoTopicoForm {

	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	@NotNull @NotEmpty	
	private String mensagem;
	
	public Topico converter() {
		ModelMapper modelMapper = new ModelMapper();
		Topico topico = modelMapper.map(this, Topico.class);
		return topico; 
	}

	public Topico atualizar(Long id, TopicoRepository topicoRepo) {
		Topico topico =	topicoRepo.getById(id);
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
		
		return topico;
	}
	
}
