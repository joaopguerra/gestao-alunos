package com.guerra.controllers;

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

import com.guerra.domain.Aluno;
import com.guerra.repositories.AlunoRepository;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoRepository repo;	
	
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		List<Aluno> obj = repo.findAll();
		return ResponseEntity.ok().body(obj);		
	}
	
	@GetMapping(value = "/{id}")
	public Optional <Aluno> findById (@PathVariable Integer id) {
		Optional<Aluno> obj = repo.findById(id);
		return obj;
	}
	
	@PostMapping
	public Aluno create(@RequestBody Aluno obj) {
		return repo.save(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id) {
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
