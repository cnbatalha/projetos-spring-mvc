package com.cnbatalha.spring.boot.forum.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cnbatalha.spring.boot.forum.controller.form.TopicoForm;
import com.cnbatalha.spring.boot.forum.dto.TopicoDto;
import com.cnbatalha.spring.boot.forum.model.Topico;
import com.cnbatalha.spring.boot.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
	
	@Autowired TopicoRepository topicoRepo;
	
	@PostMapping	
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriBuilder) {
		Topico topico = topicoRepo.save(topicoForm.converter());		
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	} 

	@GetMapping
	public List<TopicoDto> lista(String titulo) {
		if (titulo == null) {
			List<Topico> topicos = topicoRepo.findAll();
			return TopicoDto.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepo.findByTitulo(titulo);
			return TopicoDto.converter(topicos);
		}
	}

	@GetMapping(value = "all")
	public List<TopicoDto> getTopicos() {
		List<Topico> topicos = topicoRepo.findAll();
		return TopicoDto.converter(topicos);
	}

	@GetMapping(value = "old" )
	public List<Topico> getTopicosOld() {
		return topicoRepo.findAll();
	}

}
