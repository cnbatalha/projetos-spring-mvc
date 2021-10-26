package com.cnbatalha.spring.boot.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.cnbatalha.spring.boot.forum.model.Curso;
import com.cnbatalha.spring.boot.forum.model.Topico;
import com.cnbatalha.spring.boot.forum.repository.CursoRepository;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TopicoForm {

	@NotNull @NotEmpty
	private String titulo;
	@NotNull @NotEmpty	
	private String mensagem;
	@NotNull @NotEmpty
	private String nomeCurso;
	
	public Topico converter(CursoRepository cursoRepo) {
		ModelMapper modelMapper = new ModelMapper();
		Topico topico = modelMapper.map(this, Topico.class);
		
		Curso curso = cursoRepo.findByNome(this.nomeCurso);
		topico.setCurso(curso);
		
		return topico; 
	}
	
}
