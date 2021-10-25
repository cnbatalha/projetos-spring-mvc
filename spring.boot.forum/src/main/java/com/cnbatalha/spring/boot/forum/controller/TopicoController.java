package com.cnbatalha.spring.boot.forum.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cnbatalha.spring.boot.forum.model.Topico;

@RequestMapping("/topico")
public class TopicoController {
	
	@GetMapping
	public List<Topico> getTopicos() {
		
	}

}
