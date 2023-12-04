package com.guerra.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guerra.domain.entity.Turma;
import com.guerra.repositories.TurmaRepository;

@RestController
@RequestMapping(value = "/turmas")
public class TurmaController {
	
	@Autowired
	private TurmaRepository repo;	
	
	
	@GetMapping
	public ResponseEntity<List<Turma>> findAll() {
		List<Turma> obj = repo.findAll();
		return ResponseEntity.ok().body(obj);		
	}
	
	@GetMapping(value = "/{id}")
	public Optional <Turma> findById (@PathVariable Integer id) {
		Optional<Turma> obj = repo.findById(id);
		return obj;
	}
	
	@PostMapping
	public Turma create(@RequestBody Turma obj) {
		return repo.save(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id) {
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
