package com.cnbatalha.spring.boot.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cnbatalha.spring.boot.forum.model.Curso;

@RepositoryRestResource(path = "curso", collectionResourceRel = "cursos")
public interface CursoRepository extends JpaRepository<Curso, Integer> {

	Curso findByNome(String cursoNome);
	
}
