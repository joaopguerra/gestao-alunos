package com.guerra.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guerra.domain.Aluno;
import com.guerra.services.AlunoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		List<Aluno> obj = service.buscar();
		return ResponseEntity.ok().body(obj);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> findById (@PathVariable Long id) throws ObjectNotFoundException{
		Aluno obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}

}
