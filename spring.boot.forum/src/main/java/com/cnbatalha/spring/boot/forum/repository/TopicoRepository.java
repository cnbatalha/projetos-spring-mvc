package com.cnbatalha.spring.boot.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cnbatalha.spring.boot.forum.model.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Integer> {

	List<Topico> findByTitulo(String titulo);
	
	List<Topico> findByCursoNome(String cursoNome);
	
}
