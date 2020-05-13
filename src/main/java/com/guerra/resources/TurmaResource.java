package com.guerra.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guerra.domain.Turma;
import com.guerra.services.TurmaService;

@RestController
@RequestMapping(value = "/turmas")
public class TurmaResource {
	
	@Autowired
	private TurmaService service;
	
	@GetMapping()
	public ResponseEntity<List<Turma>> findAll() {
		List<Turma> obj = service.buscar();
		return ResponseEntity.ok().body(obj);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Turma> findById (@PathVariable Integer id) {
		Turma obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public Turma create(@RequestBody Turma obj) {
		return service.adicionar(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
