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

import com.guerra.domain.Escola;
import com.guerra.repositories.EscolaRepository;

@RestController
@RequestMapping(value = "/escolas")
public class EscolaController {
	
	@Autowired
	private EscolaRepository repo;	
	
	
	@GetMapping
	public ResponseEntity<List<Escola>> findAll() {
		List<Escola> obj = repo.findAll();
		return ResponseEntity.ok().body(obj);		
	}
	
	@GetMapping(value = "/{id}")
	public Optional <Escola> findById (@PathVariable Integer id) {
		Optional<Escola> obj = repo.findById(id);
		return obj;
	}
	
	@PostMapping
	public Escola create(@RequestBody Escola obj) {
		return repo.save(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id) {
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
