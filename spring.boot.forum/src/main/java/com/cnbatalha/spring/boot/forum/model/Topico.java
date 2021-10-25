package com.cnbatalha.spring.boot.forum.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Topico {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
 	private String titulo;
 	private String mensagem; 	
 	@Enumerated(EnumType.STRING)
 	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
 	@ManyToOne
 	private Usuario usuario;
 	@ManyToOne
 	private Curso curso;

 	@OneToMany(mappedBy = "topico")
 	private List<Resposta> respostas = new ArrayList<Resposta>();
 	
}
