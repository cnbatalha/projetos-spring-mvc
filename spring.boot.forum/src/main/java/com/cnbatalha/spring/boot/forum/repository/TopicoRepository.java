package com.cnbatalha.spring.boot.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cnbatalha.spring.boot.forum.model.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Integer> {

}
