package com.cnbatalha.spring.boot.forum.model;

import java.time.LocalDateTime;
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
@NoArgsConstructor
public class Topico {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter	private Long id;
	@Getter @Setter private String titulo;
	@Getter @Setter private String mensagem;
	
	@Getter @Setter	private LocalDateTime dataCriacao = LocalDateTime.now();
	
 	@Enumerated(EnumType.STRING)
 	@Getter @Setter private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
 	@ManyToOne
 	@Getter @Setter private Usuario usuario;
 	@ManyToOne
 	@Getter @Setter private Curso curso;

 	@OneToMany(mappedBy = "topico")
 	private List<Resposta> respostas = new ArrayList<Resposta>();
 	
}
