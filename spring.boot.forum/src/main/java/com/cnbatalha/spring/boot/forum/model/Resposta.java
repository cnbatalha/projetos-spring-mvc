package com.cnbatalha.spring.boot.forum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Resposta {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter	
	private Integer id;
	@Getter @Setter
	private String mensagem;
	
	@ManyToOne
	@Getter @Setter
	private Topico topico;
	
	@ManyToOne
	@Getter @Setter
	private Usuario usuario;
	
	@Getter @Setter
	private boolean solucao = false;
	
	
}
