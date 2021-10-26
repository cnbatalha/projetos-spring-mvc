package com.cnbatalha.spring.boot.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cnbatalha.spring.boot.forum.controller.form.AtualizacaoTopicoForm;
import com.cnbatalha.spring.boot.forum.controller.form.TopicoForm;
import com.cnbatalha.spring.boot.forum.dto.DetalheTopicoDto;
import com.cnbatalha.spring.boot.forum.dto.TopicoDto;
import com.cnbatalha.spring.boot.forum.model.Topico;
import com.cnbatalha.spring.boot.forum.repository.CursoRepository;
import com.cnbatalha.spring.boot.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
	
	@Autowired TopicoRepository topicoRepo;
	
	@Autowired CursoRepository cursoRepo;
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Topico> topico = topicoRepo.findById(id);
		if (topico.isPresent()) {
			topicoRepo.deleteById(id);
			return ResponseEntity.ok().build(); 
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm topicoForm) {
		Optional<Topico> topicoOp = topicoRepo.findById(id);
		if (topicoOp.isPresent()) {
			Topico topico = topicoForm.atualizar(id, topicoRepo);
			// atualização diretamente pelo hibernate
			return ResponseEntity.ok(new TopicoDto(topico)); 
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalheTopicoDto> detalhar(@PathVariable Long id) {
		Optional<Topico> topico = topicoRepo.findById(id);
		if (topico.isPresent()) {
			return ResponseEntity.ok(new DetalheTopicoDto(topicoRepo.getById(id)));	
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping	
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriBuilder) {
		Topico topico = topicoRepo.save(topicoForm.converter(cursoRepo));		
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	} 

	@GetMapping
	public Page<TopicoDto> lista(@RequestParam(required = false) String titulo, @RequestParam int pagina, @RequestParam int qtd, @RequestParam String ordenacao) {
		
		Pageable paginacao = PageRequest.of(pagina, qtd, Direction.ASC, ordenacao);
		
		if (titulo == null) {
			Page<Topico> topicos = topicoRepo.findAll(paginacao);
			return TopicoDto.converter(topicos);
		} else {
			Page<Topico> topicos = topicoRepo.findByTitulo(titulo, paginacao);
			return TopicoDto.converter(topicos);
		}
	}

	@GetMapping(value = "old" )
	public List<Topico> getTopicosOld() {
		return topicoRepo.findAll();
	}

}
