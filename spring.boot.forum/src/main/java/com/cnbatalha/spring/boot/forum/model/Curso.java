package com.cnbatalha.spring.boot.forum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Curso {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String categoria;
	
}