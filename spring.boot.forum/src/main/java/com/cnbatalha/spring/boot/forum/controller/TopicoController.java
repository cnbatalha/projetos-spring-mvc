package com.cnbatalha.spring.boot.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnbatalha.spring.boot.forum.model.Topico;
import com.cnbatalha.spring.boot.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
	
	@Autowired TopicoRepository topicoRepo;
	
	@GetMapping
	public List<Topico> getTopicos() {
		return topicoRepo.findAll();
	}

}
